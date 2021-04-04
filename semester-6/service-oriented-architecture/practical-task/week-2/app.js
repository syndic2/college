const express= require('express');
const bodyParser= require('body-parser');
const app= express();
const users= [];
const songs= [];
const playlists= [];

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.listen(3000, () => console.log('Server running on port 3000.'));

//1
app.post('/registerUser', (req, res) => {
    let user= users.find(o => o.email_user === req.body.email_user);

    if (user) {
        res.status(400).json({
            status: 'Fail',
            message: 'Registrasi gagal! E-mail sudah terpakai sebelumnya.'
        });
    } else {
        users.push({
            id_user: users.length+1,
            email_user: req.body.email_user,
            nama_user: req.body.nama_user,
            password_user: req.body.password_user,
            tipe_user: parseInt(req.body.tipe_user)
        });

        res.status(200).json({
            status: 'Success',
            message: `Registrasi user ${req.body.email_user} berhasil!`,
            registeredUser: users[users.length-1]
        });
    }
});

//2
app.post('/uploadSong', (req, res) => {
    let user= users.find(o => o.id_user === parseInt(req.body.id_user));
    let song= songs.find(o => o.judul_lagu === req.body.judul_lagu);

    if (!user) {
        res.status(400).json({
            status: 'Fail',
            message: 'Pengguna tidak ditemukan!'
        });
    } else {
        if (user.tipe_user !== 1) {
            res.status(400).json({
                status: 'Fail',
                message: 'Pengguna tidak mempunyai hak untuk mengupload lagu.'
            });
        } else {
            if (song) {
                res.status(400).json({
                    status: 'Fail',
                    message: 'Judul lagu sudah ada sebelumnya.'
                });
            } else {
                songs.push({
                    id_lagu: !songs.length ? songs.length+1 : songs[songs.length-1].id_lagu+1,
                    id_artist: parseInt(req.body.id_user),
                    judul_lagu: req.body.judul_lagu,
                    genre_lagu: req.body.genre_lagu,
                    durasi_lagu: parseInt(req.body.durasi_lagu)
                });

                res.status(200).json({
                    status: 'Success',
                    message: 'Upload lagu berhasil!',
                    uploadedSong: songs[songs.length-1]
                });
            }
        }
    }
});

//3
app.post('/createPlaylist', (req, res) => {
    req.body.collection_lagu= JSON.parse(`[ ${req.body.collection_lagu} ]`).map(id => parseInt(id)).sort();
    
    let user= users.find(o => o.email_user === req.body.email_user);
    let song= req.body.collection_lagu.every(id => songs.map(o => o.id_lagu).indexOf(id) > -1); 

    if (!user) {
        res.status(400).json({
            status: 'Fail',
            message: 'E-mail pengguna tidak ditemukan!'
        });
    } else {
        /*if (user.tipe_user !== 0) {
            res.status(400).json({
                status: 'Fail',
                message: 'Pengguna tidak mempunyai hak untuk membuat playlist.'
            });
        } else {
            
        }*/
        if (!song) {
            res.status(400).json({
                status: 'Fail',
                message: 'Lagu tidak ditemukan!'
            });
        } else {
            playlists.push({
                id_playlist: playlists.length+1,
                email_user: req.body.email_user,
                judul_playlist: req.body.judul_playlist,
                collection_lagu: req.body.collection_lagu
            });

            res.status(200).json({
                status: 'Success',
                message: 'Create playlist berhasil!',
                createdPlaylist: playlists[playlists.length-1]
            });
        }
    }
});

//4
app.get('/searchSongByKeyword/:keyword', (req, res) => {
    let song= songs.filter(o => 
        o.judul_lagu.includes(req.params.keyword) || 
        o.judul_lagu.toLowerCase().includes(req.params.keyword) || 
        o.judul_lagu.toUpperCase().includes(req.params.keyword)
    );

    if (!song.length) {
        res.status(400).json({
            status: 'Fail',
            message: 'Lagu tidak ditemukan!'
        });
    } else {
        res.status(200).json({
            status: 'Success',
            message: song
        });
    }
});

//5
app.delete('/deleteSong/:judul_lagu', (req, res) => {
    let song= songs.find(o => o.judul_lagu === req.params.judul_lagu);

    if (!song) {
        res.status(400).json({
            status: 'Fail',
            message: 'Judul lagu tidak ditemukan!'
        });
    } else {
        let index= songs.indexOf(song);

        songs.splice(index, 1);
        res.status(200).json({
            status: 'Success',
            message: 'Lagu berhasil di hapus!',
            deletedSong: song
        });
    }
});

//6
app.get('/getPlaylist/:email_user', (req, res) => {
    let requestedPlaylists= playlists.filter(o => o.email_user === req.params.email_user);

    if (!requestedPlaylists.length) {
        res.status(400).json({
            status: 'Fail',
            message: 'Playlist tidak ditemukan!'
        });
    } else {
        res.status(200).json({
            status: 'Success',
            requestedPlaylists: requestedPlaylists.map(o => ({ 
                id_playlist: o.id_playlist,
                judul_playlist: o.judul_playlist,
                collection_lagu: o.collection_lagu  
            }))
        });
    }
});

//7
app.put('/updatePlaylist/:id_playlist', (req, res) => {
    let playlist= playlists.find(o => o.id_playlist === parseInt(req.params.id_playlist));

    if (!playlist) {
        res.status(400).json({
            status: 'Fail',
            message: 'ID playlist tidak ditemukan!'
        });
    } else {
        playlist.judul_playlist= req.body.judul_playlist;

        res.status(200).json({
            status: 'Success',
            message: 'Update playlist berhasil!',
            updatedPlaylist: playlist
        });
    }
});



