const config= require('./config');
const express= require('express');
const mysql= require('mysql');
const bodyParser= require('body-parser');

const app= express();
const pool= mysql.createPool(config.database);

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(config.server.port, () => console.log(`Server running on port ${config.server.port}.`));

//CONNECTION
const getConnection= () => {
    return new Promise((resolve, reject) => {
        pool.getConnection((err, conn) => {
            if (err) reject(err);
            else resolve(conn);
        });
    });
};

//EXECUTE QUERY
const executeQuery= (conn, query) => {
    return new Promise((resolve, reject) => {
        conn.query(query, (err, res) => {
            if (err) reject(err);
            else resolve(res);
        });
    });
};

const autoGen= (maxID) => {
	if (maxID === null) return '001';
	else {
		if (maxID > 0 && maxID < 10) return '00'+maxID;
		else if (maxID >= 10 && maxID < 100) return '0'+maxID;
		else if (maxID >= 100 && maxID < 1000) return maxID; 
	}
};

//1
app.post('/registerUser', async (req, res) => {
    let newUser= {
        email: req.body.email,
        nama: req.body.nama,
        password: req.body.password,
        tipe_pengguna: parseInt(req.body.tipe_pengguna)
    };
    let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT * 
        FROM user 
		WHERE email = '${newUser.email}'
	`);

    if (result.length) {
        res.status(400).json({
            status: 400,
            message: 'Registrasi gagal! E-mail sudah terpakai sebelumnya.'
        });
    } else {
		result= await executeQuery(conn, `
			INSERT INTO user 
			VALUES ('', '${newUser.email}', '${newUser.nama}', '${newUser.password}', ${newUser.tipe_pengguna})
		`);
        
        if (result.affectedRows > 0) {
            newUser.id_pengguna= result.insertId;

            res.status(200).json({
                status: 200,
                message: `Registrasi user ${newUser.email} berhasil!`,
                registeredUser: newUser
            });
        } 
    }
});

//2
app.post('/uploadSong', async (req, res) => {
    let newSong= {
        id_pengguna: parseInt(req.body.id_pengguna),
        judul_lagu: req.body.judul_lagu,
        genre: req.body.genre,
        durasi: parseInt(req.body.durasi)
    };
    let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT * 
        FROM user 
		WHERE id_pengguna = ${newSong.id_pengguna}
	`);

    if (!result.length) {
        res.status(400).json({
            status: 400,
            message: 'Pengguna tidak ditemukan!'
        });
    } else {
        if (result[0].tipe_pengguna !== 1) {
            res.status(400).json({
                status: 400,
                message: 'Pengguna tidak mempunyai hak untuk mengupload lagu.'
            });
        } else {
			result= await executeQuery(conn, `
				SELECT * 
                FROM song
				WHERE judul_lagu = '${newSong.judul_lagu}'
			`);
            
            if (result.length) {
                res.status(400).json({
                    status: 200,
                    message: `Judul lagu '${newSong.judul_lagu}' sudah ada sebelumnya.`
                });
            } else {
                let kode= 'S';

                if (newSong.genre === 'Pop') kode+= 10;
                if (newSong.genre === 'Jazz') kode+= 20;
                if (newSong.genre === 'Country') kode+= 30;    
                
				result= await executeQuery(conn, `
					SELECT MAX(SUBSTRING(id_lagu, 4))+1 AS id
                    FROM song
					WHERE SUBSTRING(id_lagu, 1, 3) = '${kode}'
				`);

                kode+= autoGen(result[0].id);

				result= await executeQuery(conn, `
					INSERT INTO song
					VALUES ('', '${kode}', ${newSong.id_pengguna}, '${newSong.judul_lagu}', '${newSong.genre}', ${newSong.durasi})
				`);
				
                if (result.affectedRows > 0) {
					newSong.id_lagu= kode;

					res.status(200).json({
						status: 200,
						message: 'Upload lagu berhasil!',
						uploadedSong: newSong
					});
				} 
            }
        }
    }
});

//3
app.post('/createPlaylist', async (req, res) => {
	let newPlaylist= {
		email_pengguna: req.body.email_pengguna,
		nama_playlist: req.body.nama_playlist,
		collection_lagu: req.body.collection_lagu,
		status_playlist: parseInt(req.body.status_playlist) 
	};
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT * 
		FROM user
		WHERE email = '${newPlaylist.email_pengguna}'
	`);

	if (!result.length) {
		res.status(400).json({
			status: 400,
			message: 'E-mail pengguna tidak valid!'
		});
	} else {
		result= await executeQuery(conn, `
			SELECT *
			FROM song	
		`);

		let collection_lagu= newPlaylist.collection_lagu.split(',').map(id => id.trim());
		let exist= collection_lagu.every(id => result.map(o => o.id_lagu).indexOf(id) > -1);
		
		if (!exist) {
			res.status(400).json({
				status: 400,
				message: 'Lagu tidak ditemukan!'
			});
		} else {
			let kode= 'PL'+(newPlaylist.status_playlist === 1 ? 'P' : 'S');

			result= await executeQuery(conn, `
				SELECT MAX(SUBSTR(id_playlist, 5))+1 AS id
				FROM playlist
				WHERE SUBSTR(id_playlist, 1, 3) = '${kode}'
			`);

			kode+= autoGen(result[0].id);

			result= await executeQuery(conn, `
				INSERT INTO playlist
				VALUES ('', '${kode}', '${newPlaylist.email_pengguna}', '${newPlaylist.nama_playlist}', '${newPlaylist.collection_lagu}', ${newPlaylist.status_playlist})
			`);

			if (result.affectedRows > 0) {
				newPlaylist.id_playlist= kode;
				newPlaylist.collection_lagu= collection_lagu;

				res.status(200).json({
					status: 200,
					message: 'Playlist berhasil dibuat!',
					createdPlaylist: newPlaylist
				});
			}
		}
	}
});

//4
app.get('/searchSongByKeyword/:keyword', async (req, res) => {
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT * 
		FROM song
		WHERE judul_lagu LIKE '%${req.params.keyword}%' OR
			  LOWER(judul_lagu) LIKE '%${req.params.keyword}%' OR
			  UPPER(judul_lagu) LIKE '%${req.params.keyword}%'
	`);

	if (!result.length) {
		res.status(400).json({
			status: 400,
			message: 'Lagu tidak ditemukan!'
		});
	} else {
		res.status(200).json({
			status: 200,
			searchedSong: result.map(o => ({
				id_lagu: o.id_lagu,
				id_pengguna: o.id_pengguna,
				judul_lagu: o.judul_lagu,
				genre: o.genre,
				durasi: o.durasi
			}))
		});
	}
});

//5
app.delete('/deleteSong/:judul', async (req, res) => {
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT * 
		FROM song
		WHERE judul_lagu = '${req.params.judul}'
	`);
	let deleted= result;

	if (!result.length) {
		res.status(400).json({
			status: 400,
			message: `Judul lagu '${req.params.judul}' tidak ditemukan!`
		});
	} else {
		result= await executeQuery(conn, `
			DELETE FROM song
			WHERE judul_lagu = '${req.params.judul}'
		`);

		if (result.affectedRows > 0) {
			res.status(200).json({
				status: 200,
				message: `Lagu berjudul '${req.params.judul}' berhasil dihapus!`,
				deletedSong: deleted[0]
			});
		}
	}
});

//6
app.get('/getPlaylist/:email_pengguna', async (req, res) => {
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT *
		FROM playlist
		WHERE email_pengguna = '${req.params.email_pengguna}'
	`);

	if (!result.length) {
		res.status(400).json({
			status: 400,
			message: 'Playlist tidak ditemukan!'
		});
	} else {
		res.status(200).json({
			status: 200,
			requestedPlaylist: result.map(o => ({
				id_playlist: o.id_playlist,
				nama_playlist: o.nama_playlist,
				collection_lagu: o.collection_lagu.split(',').map(id => id.trim())
			}))
		});
	}
});

//7
app.put('/updatePlaylist/:id_playlist', async (req, res) => {
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT *
		FROM playlist
		WHERE id_playlist = '${req.params.id_playlist}'
	`);

	if (!result.length) {
		res.status(400).json({
			status: 400,
			message: 'Playlist tidak ditemukan!'
		});
	} else {
		result= await executeQuery(conn, `
			UPDATE playlist
			SET nama_playlist = '${req.body.nama_playlist}'
			WHERE id_playlist = '${req.params.id_playlist}'
		`);

		if (result.affectedRows > 0) {
			result= await executeQuery(conn, `
				SELECT *
				FROM playlist
				WHERE id_playlist = '${req.params.id_playlist}'
			`);

			res.status(200).json({
				status: 200,
				message: `Playlist dengan ID '${req.params.id_playlist}' berhasil di update!`,
				updatedPlaylist: {
					id_playlist: result[0].id_playlist,
					email_pengguna: result[0].email_pengguna,
					nama_playlist: result[0].nama_playlist,
					collection_lagu: result[0].collection_lagu.split(',').map(id => id.trim()),
					status_playlist: result[0].status_playlist
				}
			});
		}
	}
});

//8
app.post('/followPlaylist', async (req, res) => {
	let newFollow= {
		id_user: req.body.id_user,
		id_playlist: req.body.id_playlist,
		password_user: req.body.password_user
	};
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT *
		FROM user
		WHERE id_pengguna = '${newFollow.id_user}'
	`);

	if (!result.length) {
		res.status(400).json({
			status: 400,
			message: 'ID user tidak ditemukan!'
		});
	} else {
		result= await executeQuery(conn, `
			SELECT * 
			FROM user
			WHERE id_pengguna = '${newFollow.id_user}' AND password = '${newFollow.password_user}'
		`);

		if (!result.length) {
			res.status(400).json({
				status: 400,
				message: 'Password salah!'
			});
		} else {
			result= await executeQuery(conn, `
				SELECT *
				FROM playlist
				WHERE id_playlist = '${newFollow.id_playlist}'
			`);

			if (!result.length) {
				res.status(400).json({
					status: 400,
					message: 'ID playlist tidak ditemukan!'
				});
			} else {
				if (result[0].status_playlist !== 1) {
					res.status(400).json({
						status: 400,
						message: `Playlist '${newFollow.id_playlist}' tidak dapat di follow, karena bersifat private.`
					});
				} else {
					let message= '';

					result= await executeQuery(conn, `
						SELECT *
						FROM follow_playlist
						WHERE id_user = ${newFollow.id_user} AND id_playlist = '${newFollow.id_playlist}'
					`);

					if (!result.length) {
						result= await executeQuery(conn, `
							INSERT INTO follow_playlist
							VALUES ('', ${newFollow.id_user}, '${newFollow.id_playlist}')
						`);

						if (result.affectedRows > 0) 
							message= `Follow playlist '${newFollow.id_playlist}' berhasil!`;
					} else {
						result= await executeQuery(conn, `
							DELETE FROM follow_playlist
							WHERE id_user = ${newFollow.id_user} AND id_playlist = '${newFollow.id_playlist}'
						`);

						if (result.affectedRows > 0)
							message= `Unfollow playlist '${newFollow.id_playlist}' berhasil!`;
					}

					res.status(200).json({
						status: 200,
						message: message
					});
				}
			}
		}
	}
});

//9
app.get('/getPopularPlaylist', async (req, res) => {
	let conn= await getConnection();
	let result= await executeQuery(conn, `
		SELECT id_playlist, COUNT(id_user) AS count
		FROM follow_playlist
		GROUP BY id_playlist
	`);
	let popularPlaylist= []; 

	result.forEach(o => {
		popularPlaylist.push({
			id_playlist: o.id_playlist,
			followers_count: o.count,
			song_collection: [],
			followed_by: []
		});
	});

	popularPlaylist= popularPlaylist.filter(o => o.followers_count > 20);

	await popularPlaylist.asyncForEach(async o => {
		result= await executeQuery(conn, `
			SELECT collection_lagu
			FROM playlist
			WHERE id_playlist = '${o.id_playlist}'
		`);

		await result[0].collection_lagu.split(',').map(id => id.trim()).asyncForEach(async id => {
			result= await executeQuery(conn, `
				SELECT judul_lagu
				FROM song
				WHERE id_lagu = '${id}'
			`);

			if (result[0]) o.song_collection.push(result[0].judul_lagu);
		});

		result= await executeQuery(conn, `
			SELECT id_user
			FROM follow_playlist
			WHERE id_playlist = '${o.id_playlist}'
		`);

		await result.asyncForEach(async i => {
			result= await executeQuery(conn, `
				SELECT email
				FROM user
				WHERE id_pengguna = ${i.id_user}
			`);

			o.followed_by.push(result[0].email);
		});
	});

	if (!popularPlaylist.length) {
		res.status(400).json({
			status: 400,
			message: 'Popular playlist belum tersedia.'
		});
	} else {
		res.status(200).json({
			status: 200,
			requestedPlaylist: popularPlaylist
		});
	}
});

Array.prototype.asyncForEach = async function(callback, thisArg) {
	thisArg = thisArg || this;
	
	for (let i = 0, l = this.length; i !== l; ++i) {
		await callback.call(thisArg, this[i], i, this);
	}
};