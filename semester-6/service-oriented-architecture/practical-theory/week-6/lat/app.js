const express= require('express');
const mysql= require('mysql');
const jwt= require('jsonwebtoken');

const app= express();
const pool= mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'minggu6_soa_senin'
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
    })
}

app.use(express.urlencoded({ extended: true }));
app.use(express.json());

app.listen(3000, () => console.log('Server running on port 3000'));

app.post('/api/registerUser', async (req, res) => {
    let data= req.body;
    let null_field= Object.keys(data).every(key => data[key] !== '');

    if (!null_field) { 
        res.status(400).send('Field tidak boleh kosong');    
    }

    let conn= await getConnection();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${data.email_user}'
    `);

    conn.release();

    if (query.length) {
        res.status(400).send('Email sudah ada');
    }

    conn= await getConnection();
    query= await executeQuery(conn, `
        INSERT INTO user
        VALUES (
            null,
            '${data.email_user}',
            '${data.nama_user}',
            '${data.password_user}',
            ${data.tipe_user}
        )
    `);

    conn.release();

    if (query.affectedRows > 0) {
        res.status(200).send('Register berhasil');
    } else {
        res.status(400).send('Register gagal');
    }
});

app.post('/api/loginUser', async (req, res) => {
    let data= req.body;
    let null_field= Object.keys(data).every(key => data[key] !== '');

    if (!null_field) { 
        res.status(400).send('Field tidak boleh kosong');    
    }

    let conn= await getConnection();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${data.email_user}' AND
              password_user = '${data.password_user}'
    `);

    conn.release();

    if (!query.length) {
        res.status(400).send('Username atau password salah!');
    }

    let token= jwt.sign({
        email_user: query[0].email_user,
        tipe_user: query[0].tipe_user
    }, 'freebooks');

    res.status(200).send({  
        token: token
    });
});

app.post('/api/addBook', async (req, res) => {
    let token= req.headers.token;
    let data= req.body;
    let user= {};

     if (!token) {
        res.status(401).send('Token tidak ditemukan');
     }

     try {
        user= jwt.verify(token, 'freebooks');

     } catch (err) {    
        res.status(401).send('Token invalid');
     }

     //CEK EXPIRED 90menit
     if ((new Date().getTime()/1000)-user.iat>5400) {
        return res.status(400).send("Token expired");
     }

     //CEK AUTHORISASI
     if (user.tipe_user !== 0) {
        res.status(400).send("you are not allowed to access this resource")
     }

     res.status(200).send(user);
});