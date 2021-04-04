const express= require('express');
const mysql= require('mysql');
const morgan= require('morgan');
const fs = require('fs');
const path= require('path');

const app= express();
const pool= mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'materi_soa_7'
});

const getConn= () => {
    try {
        return new Promise((resolve, reject) => {
            pool.getConnection((err, conn) => {
                if (err) reject(err);
                else resolve(conn);
            });
        });
    } catch (error) {
        console.log(error);   
    }
};

const executeQuery= (conn, query) => {
    try {
        return new Promise((resolve, reject) => {
            conn.query(query, (err, res) => {
                if (err) reject(err);
                else resolve(res); 
            });
        });
    } catch (error) {
        console.log(error);
    }
};


// create a write stream (in append mode)
const accessLogStream = fs.createWriteStream(path.join(__dirname, 'access.log'), { flags: 'a' })
 
// setup the logger
app.use(morgan('dev', { stream: accessLogStream }))
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.listen(3000, () => console.log('Server running on port 3000'));

app.post('/api/addUser', async (req, res) => {
    const newUser= req.body;

    let notNull= Object.keys(newUser).every(key => newUser[key] !== '');

    if (!notNull) {
        return res.status(400).json({
            status: 400,
            message: 'Field tidak boleh kosong.'
        });
    }

    const api_key= Math.floor(Math.random()*1000000000)+1000000000;

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE nomorhp = '${newUser.nomorhp}'
    `);

    conn.release();

    if (query.length) {
        return res.send('Nomor hp sudah diguanakan.');
    }

    conn= await getConn();
    query= await executeQuery(conn, `
        INSERT INTO user
        VALUES (
            '${newUser.nomorhp}',
            '${newUser.password}', 
            '${newUser.nama}',
            ${newUser.tipe_user},
            ${newUser.saldo},
            '${api_key}',
            0
        )
    `);

    conn.release();

    if (query.affectedRows > 0) {
        return res.send({
            api_key: api_key
        });
    }

});

app.post('/api/topUp', async (req, res) => {
    const data= req.query;

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE gkey = '${data.key}'
    `);

    let nomorhp= query[0].nomorhp;
    let newSaldo= parseInt(query[0].saldo)+parseInt(data.jumlah_topup);

    conn.release();

    if (!query.length) {
        return res.send('API Key tidak valid.');
    }

    if (query[0].tipeuser === 0) {
        return res.send('Artis tidak boleh top up');
    }

    conn= await getConn();
    query= await executeQuery(conn, `
        UPDATE user
        SET saldo = ${newSaldo}
        WHERE gkey = '${data.key}'
    `);

    conn.release();

    if (query.affectedRows > 0) {
        res.send({
            nomorhp: nomorhp,
            saldo: newSaldo
        });
    }
});

app.post('/api/addSong', async (req, res) => {
    const api_key= req.query.key;
    const newSong= req.body;

    let conn= await getConn(); 
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE gkey = '${api_key}'
    `);

    conn.release();

    if (!query.length) {
        return res.send('API Key tidak valid.');
    }

    if (query[0].tipeuser !== 0) {
        return res.send('Hanya boleh bertipe artis.');
    }

    let nomorhp= query[0].nomorhp;

    conn= await getConn();
    query= await executeQuery(conn, `
        INSERT INTO music
        VALUES (
            null,
            '${newSong.judul_lagu}',
            '${newSong.genre}',
            '${newSong.durasi}',
            '${nomorhp}'
        )
    `);

    conn.release();

    if (query.affectedRows > 0) {
        return res.send(newSong);
    }
});

app.delete('/api/song', async (req, res) => {
    const api_key= req.query.key;
    const data= req.body;

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT * 
        FROM user 
        WHERE gkey = '${api_key}'
    `);

    conn.release();

    let nomorhp= query[0].nomorhp;

    if (!query.length) {
        return res.send('API key tidak valid.');
    }

    conn= await getConn();
    query= await executeQuery(conn, `
        SELECT *
        FROM music
        WHERE nomorhpartis = '${nomorhp}' AND id = ${data.id_lagu}
    `);

    if (!query.length) {
        return res.send('Lagu atau artist tidak sesuai.');
    }

    conn.release();

    conn= await getConn();
    query= await executeQuery(conn, `
        DELETE FROM music
        WHERE id = ${data.id_lagu}
    `);

    if (query.affectedRows > 0) {
        return res.send('Sukses hapus');
    }
});
