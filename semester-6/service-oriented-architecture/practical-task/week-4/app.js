const config= require('./config');
const validation= require('./validation');

const express= require('express');
const { validationResult } = require('express-validator');
const bodyParser= require('body-parser');

const mysql= require('mysql');
const multer= require('multer');
const path= require('path');

const app= express();
const pool= mysql.createPool(config.database);

app.set('view engine', 'ejs');

app.use(express.static('public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(config.server.port, () => console.log(`Server running at port ${config.server.port}`));

const getConnection= () => {
    return new Promise((resolve, reject) => {
        pool.getConnection((err, conn) => {
            if (err) reject(err);
            else resolve(conn);
        });
    });
};

const executeQuery= (conn, query) => {
    return new Promise((resolve, reject) => {
        conn.query(query, (err, res) => {
            if (err) reject(err);
            else resolve(res); 
        });
    });
};

//MULTER
const upload= multer({
    storage: multer.diskStorage({
        destination: (req, file, cb) => {
            cb(null, './public/uploads')
        },
        filename: (req, file, cb) => {
            cb(null, file.originalname.split('.')[0]+''+path.extname(file.originalname))
        },
    }),
    fileFilter: (req, file, cb) => {
        checkFileType(file, cb);
    }
}).single('gambar_berita');

let imgType= true;

const checkFileType = (file, cb) => {
    let extName= path.extname(file.originalname);

    if (extName === '.jpg' || extName === '.png') {
        imgType= true;

        return cb(null, true);
    } else {
        imgType= false;

        cb(null, false);
    }
};

let userLogged= null

app.get('/logout', (req, res) => {
    userLogged= null;
    
    res.redirect('/loginPage');
});

//1
app.get('/loginPage', (req, res) => { 
    res.render('loginPage');
});

//2
app.post('/checkLogin', validation.login, async (req, res) => {
    const errors= validationResult(req).errors.map(err => err.msg);

    if (errors.length) {
        let msg= '';

        errors.forEach(i => msg+= i+'\n');
        
        res.json({
            type: 'null_field',
            msg: msg
        });
    } else {
        let data= {
            username: req.body.username,
            password: req.body.password
        };

        if (data.username === 'admin' && data.password === 'admin') {
            res.json({
                type: 'success_login',
                msg: 'Login berhasil!',
                url: 'http://localhost:3000/adminPage'
            });
        } else {
            let conn= await getConnection();
            let result= await executeQuery(conn, `
                SELECT *
                FROM user
                WHERE username = '${data.username}'
            `);

            conn.release();
    
            if (result.length) {
                if (result[0].password !== data.password) {
                    res.json({
                        type: 'error_password',
                        msg: 'Password salah!'
                    });
                } else {
                    userLogged= data.username;
                    res.json({
                        type: 'success_login',
                        msg: 'Login berhasil!',
                        url: 'http://localhost:3000/homePage'
                    });
                }
            } else {
                conn= await getConnection();
                result= await executeQuery(conn, `
                    INSERT INTO user (username, password)
                    VALUES (
                        '${data.username}', 
                        '${data.password}'
                    )
                `);
                
                conn.release();

                if  (result.affectedRows > 0) {
                    userLogged= data.username;

                    res.json({
                        type: 'success_login',
                        msg: 'Registrasi berhasil!',
                        url: 'http://localhost:3000/homePage'
                    });
                }
            }
        }
    }
});

//3
app.get('/homePage', async (req, res) => {
    let conn= await getConnection();
    let result= await executeQuery(conn, `
        SELECT id,
               judul_berita, 
               DATE_FORMAT(CAST(tgl_berita AS CHAR), '%d %M %Y %H:%i') AS tgl, 
               isi_berita, gambar_berita
        FROM berita
        ORDER BY id DESC
    `);

    conn.release();

    let news= result.map(i => ({
        id: i.id,
        judul_berita: i.judul_berita,
        tgl_berita: i.tgl,
        isi_berita: i.isi_berita,
        gambar_berita: i.gambar_berita,
        comments: []
    }));

    await news.asyncForEach(async i => {
        conn= await getConnection();
        result= await executeQuery(conn, `
            SELECT * 
            FROM comment
            WHERE id_berita = ${i.id}
        `);

        conn.release();

        if (result.length) {
            result.forEach(j => {
                i.comments.push({
                    user_comment: j.user_comment,
                    komentar_comment: j.komentar_comment
                });
            });
        }
    });
    
    if (userLogged !== null) {
        res.render('homePage', {
            news: news
        });
    } else {    
        res.redirect('/loginPage');
    }
});

//4
app.get('/adminPage', async (req, res) => {
    let conn= await getConnection();
    let result= await executeQuery(conn, `
        SELECT *
        FROM berita
    `);

    conn.release();

    res.render('adminPage', {
        news: result
    }); 
});

//5
app.post('/uploadBerita', upload, validation.postBerita, async (req, res) => {
    const errors= validationResult(req).errors.map(err => err.msg);

    if (!imgType) errors.push('Gambar hanya dapat bertipe JPG dan PNG.'); 

    if (errors.length) {
        let msg= '';

        errors.forEach(i => msg+= i+'\n');
        
        res.json({
            type: 'null_field',
            msg: msg
        });
    } else {
        let data= {
            judul_berita: req.body.judul_berita,
            kategori_berita: req.body.kategori_berita,
            isi_berita: req.body.isi_berita,
            tgl_berita: req.body.tgl_berita,
            gambar_berita: req.file ? req.file.originalname : undefined
        };
        
        let conn= await getConnection();
        let result= await executeQuery(conn, `
            INSERT INTO berita
            VALUES (
                null,
                '${data.judul_berita}',
                '${data.kategori_berita}',
                '${data.isi_berita}',
                '${data.tgl_berita}',
                '${data.gambar_berita}'
            ) 
        `);

        conn.release();

        if (result.affectedRows > 0) {
            res.json({
                type: 'success_upload',
                msg: 'Berita berhasil ditambahkan!'
            });
        } else {
            res.json({
                type: 'error_upload',
                msg: 'Terjadi kesalahan pada server.'
            });
        }
    }
});

//6
app.delete('/deleteBerita/:id', async (req, res) => {
    let id= req.params.id;
    let conn= await getConnection();
    let comments= await executeQuery(conn, `
        SELECT * 
        FROM comment
        WHERE id_berita = '${id}'
    `);

    conn.release();

    let result= null;

    if (comments.length) {
        await comments.asyncForEach(async i => {
            conn= await getConnection();
            result= await executeQuery(conn, `
                DELETE FROM comment
                WHERE id_berita = '${id}'
            `);

            conn.release();
        });

        conn= await getConnection();
        result= await executeQuery(conn, `
            DELETE FROM berita
            WHERE id = '${id}'
        `);

        conn.release();
    } else {
        conn= await getConnection();
        result= await executeQuery(conn, `
            DELETE FROM berita
            WHERE id = '${id}'
        `);

        conn.release();
    }

    if (result !== null) {
        if (result.affectedRows > 0) {
            res.send('Berita berhasil dihapus!');
        } else {
            res.send('Terjadi kesalahan. Coba lagi.');
        }
    }
});

//7
app.post('/commentBerita', async (req, res) => {
    let data= {
        id_berita: req.body.id,
        user_comment: userLogged,
        komentar_comment: req.body.komentar_comment
    };

    if (!data.komentar_comment) {
        res.send('Field komentar tidak boleh kosong!');
    } else {
        if (data.komentar_comment.includes('kasar')) {
            res.send('Dilarang mengandung kata "kasar"!');
        } else {
            let conn= await getConnection();
            let result= await executeQuery(conn, `
                INSERT INTO comment
                VALUES (
                    null,
                    '${data.id_berita}',
                    '${data.user_comment}',
                    '${data.komentar_comment}'
                )
            `);

            conn.release();

            if (result.affectedRows > 0) {
                res.send('Komentar berhasil ditambahkan!');
            } else {
                res.send('Terjadi kesalahan. Coba lagi.');
            }
        }
    }
});

Array.prototype.asyncForEach = async function(callback, thisArg) {
	thisArg = thisArg || this;
	
	for (let i = 0, l = this.length; i !== l; ++i) {
		await callback.call(thisArg, this[i], i, this);
	}
};


