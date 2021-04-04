const config= require('./config');
const express= require('express');
const bodyParser= require('body-parser');
const mysql= require('mysql');
const multer= require('multer');
const path= require('path');

const app= express();
const pool= mysql.createPool(config.database);

app.set('view engine', 'ejs');

app.use(express.static('public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true}));

app.listen(3000, () => console.log('Server running on port 3000.'));

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
            cb(null, file.originalname)
        },
    }),
    fileFilter: (req, file, cb) => {
        checkFileType(file, cb);
    }
});

const checkFileType = (file, cb) => {
    const filetypes= /jpeg|jpg|png|gif/;
    const extname= filetypes.test(path.extname(file.originalname).toLowerCase());
    const mimetype= filetypes.test(file.mimetype);
    
    if(mimetype && extname) return cb(null,true);
    else cb('Error: Image Only!');
};

//1
app.post('/api/user', async (req, res) => {
    let newUser= {
        username: req.body.username,
        password: req.body.password, 
        nomorhp: req.body.nomorhp   
    };

    if (!newUser.username || !newUser.password || !newUser.nomorhp) {
        res.status(400).json({
            status: 400,
            message: 'Field harus diisi semua.'
        });
    } else {
        let conn= await getConnection();
        let result= await executeQuery(conn, `
            SELECT * 
            FROM user
            WHERE username = '${newUser.username}'
        `);

        if (result.length) {
            res.status(400).json({
                status: 400,
                message: 'Username sudah digunakan.'
            });
        } else {
            result= await executeQuery(conn, `
                INSERT INTO user
                VALUES (
                    null,
                    '${newUser.username}',
                    '${newUser.password}',
                    '${newUser.nomorhp}'
                )
            `);

            if (result.affectedRows > 0) {
                res.status(200).json({
                    status: 200,
                    message: 'Register berhasil!'
                });
            }
        }
    }
});

//2
app.put('/api/user/:username', async (req, res) => {
    let newData= {
        username: req.body.username,
        nomorhp: req.body.nomorhp,
        newpassword: req.body.newpassword,
        oldpassword: req.body.oldpassword,
    };

    if (!newData.username || !newData.newpassword || !newData.oldpassword || !newData.nomorhp) {            
        res.status(400).json({
            status: 400,
            message: 'Field harus diisi semua.'
        });
    } else {
        let conn= await getConnection();
        let result= await executeQuery(conn, `
            SELECT *
            FROM user
            WHERE username = '${req.params.username}'
        `);

        if (newData.oldpassword !== result[0].password) {
            res.status(400).json({
                status: 400,
                message: 'Old password harus sama dengan new password.'
            });
        } else {
            result= await executeQuery(conn, `
                UPDATE user
                SET username = '${newData.username}', 
                    password = '${newData.newpassword}',
                    nohp = '${newData.nomorhp}'
                WHERE username = '${req.params.username}'
            `);

            if (result.affectedRows > 0) {
                res.status(200).json({
                    status: 200,
                    message: 'Update berhasil!'
                });
            } 
        }
    }
});

app.post('/api/subscribe', async (req, res) => {
    let newSubscribe= {
        username: req.body.username,
        password: req.body.password,
        usercari: req.body.usercari
    };

    let conn= await getConnection();
    let result= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE username = '${newSubscribe.usercari}'
    `);

    if (!result.length) {
        res.status(404).json({
            status: 404,
            message: 'User cari tidak ditemukan.'
        });
    } else {
        result= await executeQuery(conn, `
            INSERT INTO subscribe
            VALUES (
                null,
                '${newSubscribe.username}',
                '${newSubscribe.usercari}'
            )
        `);

        if (result.affectedRows > 0) {
            res.status(200).json({
                status: 200,
                message: 'Berhasil subscribe!'
            });
        }
    }
});

app.delete('/api/subscribe', async (req, res) => {
    let unsubscribe= {
        username: req.body.username,
        password: req.body.password,
        usercari: req.body.usercari
    };

    let conn= await getConnection();
    let result= await executeQuery(conn, `
        DELETE FROM subscribe
        WHERE username = '${unsubscribe.username}' AND
              usernamesub = '${unsubscribe.usercari}'
    `);

    if (result.affectedRows > 0) {
        res.status(200).json({
            status: 200,
            message: 'Berhasil unsubscribe!'
        });
    }
});

app.post('/upload', upload.single('gambar'), async (req, res) => {
    
});



