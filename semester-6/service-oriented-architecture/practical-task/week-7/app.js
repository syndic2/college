const express= require('express'),
      morgan= require('morgan'),
      path= require('path'),
      fs= require('fs'),
      db= require('./database');

const app= express();
const accessLogStream = fs.createWriteStream(path.join(__dirname, 'access.log'), { flags: 'a' })
 
app.use(morgan((tokens, req, res) => {
    return [
        tokens.method(req, res),
        tokens.url(req, res),
        tokens.status(req, res),
        tokens['response-time'](req, res), 'ms',
        tokens.res(req, res, 'content-length'), '-',
    ].join('')
}, { stream: accessLogStream }));
app.use(express.json());
app.use(express.urlencoded({ extended: true}));

app.listen(3000, () => console.log('Server running on port 3000'));

const getAPIKey = () => {
    const alphabets= 'abcdefghijklmnopqrstuvwxyz'.split('');

    let key= '';

    for (let i= 0; i<10; i++) {
        let hash= Math.floor(Math.random()*2)+1;
        let model= Math.floor(Math.random()*2)+1;
        let randAlpha= Math.floor(Math.random()*alphabets.length);
        
        if (hash === 1) {
            key+= Math.floor(Math.random()*10);
        } else {
            if (model === 1) key+= alphabets[randAlpha].toUpperCase();
            else key+= alphabets[randAlpha]; 
        }
    }

    return key;
};

//1
app.post('/api/registerUser', async (req, res) => {
    const newUser= req.body;
    const not_null= Object.keys(newUser).every(key => {
        if (key === 'saldo' || key === 'tipe_user') 
            return newUser[key] === '' || newUser[key] !== '';
        
        return newUser[key] !== ''; 
    });

    if (!not_null) {
        return res.status(400).json({
            status: 400,
            message: 'All field required.'
        });
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${newUser.email_user}'
    `);

    conn.release();

    if (query.length) {
        return res.status(400).json({
            status: 400,
            message: 'E-mail already used.'
        });
    }  

    let api_key= getAPIKey();

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        INSERT INTO user
        VALUES (
            null,
            '${newUser.email_user}', 
            '${newUser.nama_user}',
            '${newUser.nohp}',
            ${newUser.saldo ? newUser.saldo : 0},
            ${newUser.tipe_user ? newUser.tipe_user : 0},
            '${newUser.password_user}',
            '${api_key}',
            10
        )
    `);
    
    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    return res.status(200).json({
        status: 200,
        api_key: api_key
    });
});

//2
app.post('/api/topUp', async (req, res) => {
    const userTopUp= req.body;
    const not_null= Object.keys(userTopUp).every(key => userTopUp[key] !== '');

    if (!not_null) {
        return res.status(400).json({
            status: 400, 
            message: 'All field required.'
        });
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT * 
        FROM user
        WHERE email_user = '${userTopUp.email_user}'
    `);

    conn.release();

    if (!query.length) {
        return res.status(404).json({
            status: 404,
            message: 'E-mail not found.'
        });
    }

    let dataUser= query[0];

    dataUser.saldo_user+= parseInt(userTopUp.nominal_topup);

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET saldo_user = '${dataUser.saldo_user}'
        WHERE email_user = '${userTopUp.email_user}'
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    return res.status(200).json({
        status: 200,
        saldo: dataUser.saldo_user
    });
});

//3
app.post('/api/getPremium', async (req, res) => {
    if (!req.query.api_key) {
        return res.status(400).json({
            status: 400,
            message: 'Required API Key parameter'
        });
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE api_key = '${req.query.api_key}'
    `);

    conn.release();

    if (!query.length) {
        return res.status(404).json({
            status: 404,
            message: 'API key not found.'
        });
    }

    if (!req.body.email_user) {
        return res.status(400).json({
            status: 400,
            message: 'Required e-mail field.'
        });
    }

    if (query[0].email_user !== req.body.email_user) {
        return res.status(400).json({
            status: 400,
            message: 'Wrong e-mail.'
        });
    }

    if (query[0].tipe_user === 1) {
        return res.status(400).json({
            status: 400,
            message: 'Already upgraded to premium.'
        });
    }

    if (query[0].saldo_user < 150000) {
        return res.status(400).json({
            status: 400,
            message: 'Balance not enough to upgrade account.'
        });
    }

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET saldo_user = saldo_user - ${150000}, tipe_user = 1
        WHERE email_user = '${req.body.email_user}'
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    return res.status(200).json({
        status: 200,
        message: 'Upgrade account success.'
    });
});

//4
app.post('/api/addApiSubscription', async (req, res) => {
    const data= req.body;
    const not_null= Object.keys(data).every(key => data[key] !== '');

    if (!not_null) {
        return res.status(400).json({
            status: 400,
            message: 'All field required.'
        });
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${data.email_user}'
    `);

    conn.release();

    if (!query.length) {
        return res.status(404).json({
            status: 404,
            message: 'E-mail not found.'
        });
    }

    if (query[0].saldo_user < parseInt(data.jumlah_hit*50)) {
        return res.status(400).json({
            status: 400,
            message: 'Not enough balance.'
        });
    }

    let dataUser= query[0];

    dataUser.saldo_user-= data.jumlah_hit*50;
    dataUser.api_hit+= parseInt(data.jumlah_hit);

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET saldo_user = ${dataUser.saldo_user}, api_hit = ${dataUser.api_hit}
        WHERE email_user = '${data.email_user}'
    `);

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    return res.status(200).json({
        status: 200,
        message: 'Add API hit success.'
    });
});

//5
app.post('/api/createReport', async (req, res) => {
    const userReport= req.body;

    if (!req.query.api_key) {
        return res.status(400).json({
            status: 400,
            message: 'Required API key parameter.'
        });
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT * 
        FROM user
        WHERE api_key = '${req.query.api_key}'
    `);

    conn.release();

    if (!query.length) {
        return res.status(404).json({
            status: 404,
            message: 'Invalid API key.'
        });
    }

    if (query[0].api_hit-1 < 0) {
        return res.status(404).json({
            status: 404,
            message: 'Out of API hit.'
        });
    }

    let dataUser= query[0];

    const not_null= Object.keys(userReport).every(key => {
        if (key === 'email_pelapor') return userReport[key] === '' || userReport[key] !== '';
        else return userReport[key] !== '';
    });

    if (!not_null) {
        return res.status(400).json({
            status: 400,
            message: 'All field required.'
        });
    }

    if (!userReport.email_pelapor) {
        if (query[0].tipe_user !== 1) {
            return res.status(400).json({
                status: 400,
                message: 'Only premium user can empty the e-mail field.'
            });
        }
    } else {
        if (query[0].email_user !== userReport.email_pelapor) {
            return res.status(400).json({
                status: 400,
                message: 'Wrong e-mail.'
            });
        }
    }

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        INSERT INTO laporan
        VALUES (
            null,
            '${userReport.judul_laporan}',
            '${userReport.tanggal_laporan}', 
            '${userReport.deskripsi_laporan}',
            '${userReport.jenis_kriminalitas}',
            '${userReport.alamat_kejadian}', 
            '${userReport.kode_pos_alamat}',
            '${userReport.email_pelapor ? userReport.email_pelapor : 'anonymous'}'
        )
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    dataUser.api_hit-= 1;

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET api_hit = '${dataUser.api_hit}'
        WHERE email_user = '${dataUser.email_user}'
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    return res.status(200).json({
        status: 200,
        message: 'Add report success.'
    });
});

//6
app.get('/api/searchReport', async (req, res) => {
    if (!req.query.apiKey) {
        return res.status(400).json({
            status: 400,
            message: 'Required API key parameter'
        });
    }

    let conn= await db.getConn();
    let query= await db.executeQuery(conn, `
        SELECT *
        FROM user
        WHERE api_key = '${req.query.apiKey}'
    `);

    conn.release();

    if (!query.length) {
        return res.status(404).json({
            status: 404,
            message: 'Invalid API Key.'
        });
    }

    if (query[0].api_hit-1 < 0) {
        return res.status(404).json({
            status: 404,
            message: 'Out of API hit.'
        });
    }

    let dataUser= query[0];
    let jenis= ``,
        kode_pos= ``,
        tahun= ``;

    if (query[0].tipe_user !== 1) {
        tahun= '2020';
    }

    if (req.query.jenis_kriminalitas) {
        jenis= `'${req.query.jenis_kriminalitas}'`;
    }

    if (req.query.zip_code) {
        kode_pos= `'${req.query.zip_code}'`;
    } 

    if (req.query.tahun) {
        if (query[0].tipe_user !== 1 && parseInt(req.query.tahun) < 2020) {
            return res.status(400).json({
                status: 400, 
                message: 'Only premium account can use this feature.'
            });
        }

        tahun= `'${req.query.tahun}'`;
    }

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        SELECT *
        FROM laporan
        WHERE ${jenis !== '' ? 'jenis_kriminalitas = '+jenis : 'jenis_kriminalitas <> ""'} AND
              ${kode_pos !== '' ? 'kode_pos_alamat = '+kode_pos : 'kode_pos_alamat <> ""'} AND
              ${tahun !== '' ? 'SUBSTRING(tanggal_laporan, 7) = '+tahun : 'tanggal_laporan <> ""'}
    `);

    conn.release();

    let results= query;

    dataUser.api_hit-= 1;

    conn= await db.getConn();
    query= await db.executeQuery(conn, `
        UPDATE user
        SET api_hit = '${dataUser.api_hit}'
        WHERE email_user = '${dataUser.email_user}'
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Internal server error. Please try again.'
        });
    }

    if (!results.length) {
        return res.status(404).json({
            status: 404,
            message: 'Reports not found.'
        });
    }

    return res.status(200).json({
        status: 200,
        reports: results
    });
});

