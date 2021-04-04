const express= require('express'),
      jwt= require('jsonwebtoken'),
      fetch= require('node-fetch'),
      morgan= require('morgan'),
      path= require('path'),
      fs= require('fs'),
      db= require('./database');

const app= express();
const accessLogStream = fs.createWriteStream(path.join(__dirname, 'access.log'), { flags: 'a' })

app.use(express.json());
app.use(express.urlencoded({ extended: true}));
app.use(morgan((tokens, req, res) => {
    return [
        tokens.method(req, res),
        tokens.url(req, res),
        tokens['response-time'](req, res), 'ms'
    ].join('')
}, { stream: accessLogStream }));

app.listen(3000, () => console.log('Server running on port 3000'));

//1
app.post('/api/register', async (req, res) => {
    const data= req.body;

    if (!Object.keys(data).every(key => data[key] !== '')) {
        return res.status(400).send('Semua field tidak boleh kosong.');
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${data.email_user}'
    `);

    if (query.length) {
        return res.status(400).send('E-mail sudah digunakan.');
    }

    conn.release();

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        INSERT INTO user
        VALUES (
            '${data.email_user}',
            '${data.password_user}',
            '${data.nama_user}',
            0,
            0,
            10
        )
    `);

    conn.release();

    if (query.affectedRows > 0) {
        return res.status(200).send('Register berhasil.');
    }
});

//2
app.post('/api/loginUser', async (req, res) => {
    const data= req.body;

    if (!Object.keys(data).every(key => data[key] !== '')) {
        return res.status(400).send('Semua field tidak boleh kosong.');
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${data.email_user}' AND 
              password_user = '${data.password_user}'
    `);

    if (!query.length) {
        return res.status(400).send('Username atau password salah!');
    }

    conn.release();

    const token = jwt.sign({    
        'username': query[0].email_user,
        'tipe_user': query[0].tipe_user,
        'saldo_user': query[0].saldo_user
    }   ,"217116615");

    return res.status(200).send(token);
});

//3
app.post('/api/topUp', async (req, res) => {
    const token= req.header('x-auth-token');
    const data= req.body;

    if (!token) {
        return res.status(401).send("Token not found");
    }

    if (!Object.keys(data).every(key => data[key] !== '')) {
        return res.status(400).send('Semua field tidak boleh kosong.');
    }

    let user= {};

    try {
        user = jwt.verify(token,"217116615");
    } catch (error) {
        return res.status(401).send("Token Invalid");
    }

    if((new Date().getTime()/1000)-user.iat>3600){
        return res.status(400).send("Token expired");
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${user.username}'
    `);

    if (!query.length) {
        return res.status(400).send('E-mail tidak sesuai.');
    }

    let dataUser= query[0];

    conn.release();

    dataUser.saldo_user+= parseInt(data.jumlah_topup);

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET saldo_user = ${dataUser.saldo_user}
        WHERE email_user = '${user.username}'
    `);

    conn.release();

    if (query.affectedRows > 0) {
        return res.status(200).json(dataUser.saldo_user);   
    }
});

//4
app.post('/api/getPremium', async (req, res) => {
    const token= req.header('x-auth-token');

    if (!token) {
        return res.status(401).send("Token not found");
    }

    if (!req.body.email_user) {
        return res.status(400).send('Field tidak boleh kosong.');
    }

    let user= {};

    try {
        user = jwt.verify(token,"217116615");
    } catch (error) {
        return res.status(401).send("Token Invalid");
    }

    if((new Date().getTime()/1000)-user.iat>3600){
        return res.status(400).send("Token expired");
    }

    if (user.username !== req.body.email_user) {
        return res.status(400).send('E-mail tidak sesuai.');
    }   

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${user.username}'
    `);

    let dataUser= query[0];

    conn.release();

    if (dataUser.saldo_user < 200000) {
        return res.status(400).send('Saldo tidak mencukupi.');
    }

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET saldo_user = saldo_user - 200000, tipe_user = 1
        WHERE email_user = '${dataUser.email_user}'
    `);

    if (query.affectedRows > 0) {
        return res.status(200).send('Berhasil menjadi premium.');
    }
});

//5
app.post('/api/addSubscription', async (req, res) => {
    const token= req.header('x-auth-token');
    const data= req.body;

    if (!token) {
        return res.status(401).send("Token not found");
    }

    if (!Object.keys(data).every(key => data[key] !== '')) {
        return res.status(400).send('Field tidak boleh kosong.');
    }

    let user= {};

    try {
        user = jwt.verify(token,"217116615");
    } catch (error) {
        return res.status(401).send("Token Invalid");
    }

    if((new Date().getTime()/1000)-user.iat>3600){
        return res.status(400).send("Token expired");
    }

    if (user.username !== req.body.email_user) {
        return res.status(400).send('E-mail tidak sesuai.');
    }   

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${user.username}'
    `);

    let dataUser= query[0];

    conn.release();

    if (dataUser.saldo_user < data.jumlah_hit*75) {
        return res.status(400).send('Saldo tidak mencukupi.');
    }

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET saldo_user = saldo_user - ${parseInt(data.jumlah_hit)*75}, api_hit = api_hit + ${parseInt(data.jumlah_hit)} 
        WHERE email_user = '${dataUser.email_user}'
    `);

    if (query.affectedRows > 0) {
        return res.status(200).send('Berhasil tambah subscription');
    }
});

//6
app.get('/api/searchBerita', async (req, res) => {
    const token= req.header('x-auth-token');

    if (!token) {
        return res.status(401).send("Token not found");
    }

    try {
        user = jwt.verify(token,"217116615");
    } catch (error) {
        return res.status(401).send("Token Invalid");
    }

    if((new Date().getTime()/1000)-user.iat>3600){
        return res.status(400).send("Token expired");
    }

    if (!req.query.query) {
        return res.status(400).send('Parameter query tidak boleh kosong.');
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${user.username}'
    `);

    conn.release();

    if (query[0].api_hit <= 0) {
        return res.status(400).send('API Hit tidak mencukupi.');
    }

    let dataUser= query[0];

    const fetchAPI= await fetch(`
        https://newsapi.org/v2/everything?q=${req.query.query}&apiKey=7a61529df3474ec6acbcc7d4e0dff152
    `);
    const result= await fetchAPI.json();

    dataUser.api_hit-= 1;

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET api_hit = ${dataUser.api_hit}
        WHERE email_user = '${dataUser.email_user}'
    `);

    if (query.affectedRows > 0) {
        return res.status(200).json(result);
    }
});

//7 
app.get('/api/getHeadlineNews', async (req, res) => {
    const token= req.header('x-auth-token');

    if (!token) {
        return res.status(401).send("Token not found");
    }

    try {
        user = jwt.verify(token,"217116615");
    } catch (error) {
        return res.status(401).send("Token Invalid");
    }

    if((new Date().getTime()/1000)-user.iat>3600){
        return res.status(400).send("Token expired");
    }

    if (!req.query.category || !req.query.country) {
        return res.status(400).send('Parameter query tidak boleh kosong.');
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${user.username}'
    `);

    conn.release();

    if (query[0].tipe_user !== 1) {
        return res.status(400).send('Untuk user premium saja.');        
    }

    if (query[0].api_hit <= 0) {
        return res.status(400).send('API Hit tidak mencukupi.');
    }

    let dataUser= query[0];

    const fetchAPI= await fetch(`
    https://newsapi.org/v2/top-headlines?country=${req.query.country}&category=${req.query.category}&apiKey=7a61529df3474ec6acbcc7d4e0dff152
    `);
    const result= await fetchAPI.json();

    dataUser.api_hit-= 1;

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET api_hit = ${dataUser.api_hit}
        WHERE email_user = '${dataUser.email_user}'
    `);

    if (query.affectedRows > 0) {
        return res.status(200).json(result);
    }
});



