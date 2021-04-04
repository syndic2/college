const express= require('express');
const jwt= require('jsonwebtoken');
const mysql= require('mysql');

const app= express();
const pool= mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'materi_soa_6'
});

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
        conn.query(query, (err, result) => {
            if (err) reject(err);
            else resolve(result);
        });
    });
};

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.listen(3000, () => console.log('Server running on port 3000'));

app.post('/api/register', async (req, res) => {
    let data= req.body;
    let null_field= Object.keys(data).every(key => data[key] !== '');

    if (!null_field) { 
        res.status(400).send('Field tidak boleh kosong');    
    }

    let conn= await getConnection();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user 
        WHERE nomorhp = '${data.nomorhp}'
    `);

    conn.release();

    if (query.length) {
        res.status(400).send('Nomor hp sudah terpakai');    
    }

    conn= await getConnection();
    query= await executeQuery(conn, `
        INSERT into user
        VALUES (
            '${data.nomorhp}',
            '${data.nama}',
            '${data.alamat}',
            '${data.password}',
            '${data.tipe_user}',
            0
        )
    `);

    conn.release();

    if (query.affectedRows > 0) {
        res.status(200).send({
            nomorhp: data.nomorhp,
            password: data.password
        });    
    } else {
        res.status(400).send('Register gagal');
    }
});

app.post('/api/login', async (req, res) => {
    let data= req.body;
    let null_field= Object.keys(data).every(key => data[key] !== '');

    if (!null_field) { 
        res.status(400).send('Field tidak boleh kosong');    
    }

    let conn= await getConnection();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user 
        WHERE nomorhp = '${data.nomorhp}' AND 
              password = '${data.password}'
    `);

    conn.release();

    if (!query.length) {
        res.status(400).send('Username atau password salah');    
    }

    let getToken= jwt.sign({
        nomorhp: query[0].nomorhp,
        tipe: query[0].tipe
    }, 'rahasia');

    res.status(200).send({
        token: getToken,
    });
});

app.post('/api/addMovie', async (req, res) => {
    let data= req.body;
    let null_field= Object.keys(data).every(key => data[key] !== '');

    if (!null_field) { 
        res.status(400).send('Field tidak boleh kosong');    
    }

    let token= req.headers.token;
    let user= {};

    if (!token) {
        res.status(401).send('Token tidak ditemukan');
    }

    try {
        user= jwt.verify(token, 'rahasia');
    } catch (err) {    
        res.status(401).send('Token invalid');
    }
    
    //CEK EXPIRED 90menit
    if ((new Date().getTime()/1000)-user.iat>5400) {
        res.status(400).send("Token expired");
    }

     //CEK AUTHORISASI
     if (user.tipe !== 0) {
        res.status(400).send("Hanya bertipe admin saja")
     } 

     let conn= await getConnection();
     let query= await executeQuery(conn, `
        SELECT MAX(id) AS id
        FROM movie
     `);

     let id= 0;

     if (query.length) {
        id= '00'+(id+1);
     } else {
        id= '00'+(id+1);
     }

     id+= data.judul.substring(0, 2);

     conn.release();

    conn= await getConnection();
    query= await executeQuery(conn, `
        INSERT INTO movie
        VALUES (
            '${id}',
            '${data.judul}',
            '${data.tahun}',
            '${data.director}',
            '${data.durasi}',
            ${data.harga_sewa}
        )
    `);

    conn.release();

    if (query.affectedRows > 0) {
        res.status(200).send({
            id : id,
            judul: data.judul,
            tahun: data.tahun,
            director: data.director,
            durasi: data.durasi,
            harga_sewa: data.harga_sewa,
        });
    } else {
        res.status(400).send('Gagal tambah');
    }
});

