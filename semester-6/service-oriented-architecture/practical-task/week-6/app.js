const express= require('express');
const bodyParser= require('body-parser');
const mysql= require('mysql');
const jwt= require('jsonwebtoken');

const app= express();
const pool= mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: '6615'
});

app.use(bodyParser.json());
app.use(express.urlencoded({ extended: true }));

app.listen(3000, () => console.log('Server running on port 3000'));

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

const checkToken= (token, authorize, res) => {
    let user= {};

    if (!token) {
        return res.status(401).json({
            status: 401,
            message: 'Token not found.'
        });
    }
    
    try {
        user= jwt.verify(token, '217116615');
    } catch (error) {
        return res.status(401).json({
            status: 401,
            message: 'Token invalid.'
        });
    }
    
    if ((new Date().getTime()/1000) - user.iat > 3600) {
        return res.status(400).json({
            status: 400,
            message: 'Token expired.'
        });
    }

    if(authorize !== -1 && user.tipe_user !== authorize) {
        return res.status(400).json({
            status: 400,
            message: "You are not allowed to access this resource."
        });
    }

    return user;
};

//1
app.post('/api/registerUser', async (req, res) => {
    let newUser= req.body;
    let notNull= Object.keys(newUser).every(key => newUser[key] !== '');

    if (!notNull) {
        return res.status(400).json({
            status: 400,
            message: 'Field tidak boleh kosong.'
        });
    }

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${newUser.email_user}'
    `);

    if (query.length) {
        return res.status(400).json({
            status: 400,
            message: 'E-mail sudah digunakan sebelumnya.'
        });
    }

    conn.release();

    conn= await getConn();
    query= await executeQuery(conn, `
        INSERT INTO user
        VALUES (
            null,
            '${newUser.email_user}',
            '${newUser.nama_user}',
            '${newUser.password_user}',
            ${newUser.tipe_user}
        )
    `);

    conn.release();

    if (query.affectedRows == 0) {
        return res.status(500).json({
            status: 500,
            message: 'Terjadi kesalahan. Silahkan coba lagi.'
        });
    }

    return res.status(200).json({
        status: 200,
        message: 'Register berhasil.'
    });
});

//2
app.post('/api/loginUser', async (req, res) => {
    let login= req.body;
    let notNull= Object.keys(login).every(key => login[key] !== '');

    if (!notNull) {
        return res.status(400).json({
            status: 400,
            message: 'Field tidak boleh kosong.'
        });
    }

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT *
        FROM user
        WHERE email_user = '${login.email_user}' AND
              password_user = '${login.password_user}'
    `);

    if (!query.length) {
        return res.status(400).json({
            status: 400,
            message: 'E-mail atau password salah.'
        });
    }

    conn.release();

    let token= jwt.sign({
        email_user: login.email_user,
        tipe_user: query[0].tipe_user
    }, '217116615');

    return res.status(200).json({
        status: 200,
        token: token,
        expire: '60 menit'
    });
});

//3
app.post('/api/createRecipe', async (req, res) => {
    let newRecipe= req.body;
    let notNull= Object.keys(newRecipe).every(key => newRecipe[key] !== '');

    if (!notNull) {
        return res.status(400).json({
            status: 400,
            message: 'Field tidak boleh kosong.'
        });
    }

    let user= checkToken(req.headers.token, -1, res);
    let kode= 'RE';

    if (!user.email_user) {
        return;
    }

    if (user.email_user !== newRecipe.email_user) {
        return res.status(400).json({
            status: 400,
            message: 'E-mail tidak cocok.'
        });
    }

    if (newRecipe.kategori_resep === 'Main Course') kode+= 'MC';
    else if (newRecipe.kategori_resep === 'Appetizer') kode+= 'AP';
    else if (newRecipe.kategori_resep === 'Dessert') kode+= 'DS';

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT MAX(SUBSTRING(id_resep, 5))+1 AS maxID
        FROM resep
        WHERE SUBSTRING(id_resep, 1, 4) = '${kode}'
    `);

    conn.release();

    if (query[0].maxID === null) kode+= '001';
    else {
        if (query[0].maxID > 0 && query[0].maxID < 10) 
            kode+= '00'+query[0].maxID;
        else if (query[0].maxID >= 10 && query[0].maxID < 100) 
            kode+= '0'+query[0].maxID;
        else if (query[0].maxID >= 100 && query[0].maxID < 1000) 
            kode+= query[0].maxID;
    }

    conn= await getConn();
    query= await executeQuery(conn, `
        INSERT INTO resep
        VALUES (
            '${kode}', 
            '${newRecipe.judul_resep}',
            '${newRecipe.bahan_resep}',
            '${newRecipe.kategori_resep}',
            '${newRecipe.estimasi_waktu}',
            '${newRecipe.email_user}'
        )
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Terjadi kesalahan. Silahkan coba lagi.'
        });
    }

    return res.status(200).json({
        status: 200,
        kode_resep: kode
    });
});

//4
app.get('/api/searchRecipe', async (req, res) => {
    if (JSON.stringify(req.query) === '{}') {
        return res.status(404).json({
            status: 404,
            message: 'Tidak ditemukan.'
        });
    }

    let exclude= ``;
    let user= {};
    
    user= checkToken(req.headers.token, -1, res);

    if (!user.email_user) {
        return;
    }

    if (req.query.exclude !== undefined) {
        if (req.query.exclude === '') {
            return res.status(400).json({
                status: 400,
                message: 'Parameter query tidak boleh kosong.'
            });
        }

        user= checkToken(req.headers.token, 2, res);

        if (!user.email_user) {
            return;
        }

        exclude= `AND bahan_resep NOT LIKE '%${req.query.exclude}%'`;
    }

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT *
        FROM resep
        WHERE judul_resep LIKE '%${req.query.query}%' ${exclude}
    `);

    conn.release();

    let result= [];
    
    query.forEach(item => {
        result.push({
            kode_resep: item.id_resep,
            judul_resep: item.judul_resep,
            type_resep: item.kategori_resep,
            bahan: item.bahan_resep.split(',').map(o => o.trim()),
            estimasi_waktu: item.estimasi_waktu,
            email_pembuat_resep: item.email_user
        });
    });

    if (!result.length) {
        return res.status(404).json({
            status: 404,
            message: 'Resep tidak ditemukan.' 
        });
    }

    return res.status(200).json({
        status: 200,
        searchedRecipe: result 
    });
});

//5
app.post('/api/reviewRecipe', async (req, res) => {
    let newReview= req.body;
    let notNull= Object.keys(newReview).every(key => newReview[key] !== '');

    if (!notNull) {
        return res.status(400).json({
            status: 400,
            message: 'Field tidak boleh kosong.'
        });
    }

    let conn= await getConn();
    let query= await executeQuery(conn, `
        SELECT *
        FROM resep
        WHERE id_resep = '${newReview.kode_resep}'
    `);

    conn.release();

    if (!query.length) {
        return res.status(400).json({
            status: 400,
            message: 'Kode resep tidak ditemukan.'
        });
    }

    let user= checkToken(req.headers.token, -1, res);

    if (!user.email_user) {
        return;
    }

    if (user.email_user !== newReview.email_reviewer) {
        return res.status(400).json({
            status: 400,
            message: 'E-mail tidak cocok'
        });
    }

    conn= await getConn();
    query= await executeQuery(conn, `
        INSERT INTO review
        VALUES (
            null,
            '${newReview.email_reviewer}',
            '${newReview.isi_review}', 
            '${newReview.tanggal_review}',
            '${newReview.kode_resep}'
        )
    `);

    conn.release();

    if (query.affectedRows === 0) {
        return res.status(500).json({
            status: 500,
            message: 'Terjadi kesalahan. Silahkan coba lagi.'
        });
    }

    return res.status(200).json({
        status: 200,
        message: 'Review berhasil ditambah.'
    });
});

//6
app.get('/api/getReview', async (req, res) => {
    let user= checkToken(req.headers.token, 0, res);

    if (!user.email_user) {
        return;
    }

    let optional= ``;
    let result;

    if (req.query.date !== undefined) {
        if (req.query.date === '') {
            return res.status(400).json({
                status: 400,
                message: 'Parameter query tidak boleh kosong.'
            });
        }

        optional= `AND tanggal_review = '${req.query.date}'`;
        result= {
            tanggal_review: req.query.date,
            kumpulan_review: []
        }
    } else {
        result= [];
    }

    let conn= await getConn();
    let recipes= await executeQuery(conn, `
        SELECT rs.id_resep, rs.judul_resep
        FROM review rv, resep rs
        WHERE rv.id_resep = rs.id_resep
        GROUP BY rs.id_resep
    `);

    conn.release();

    let review= ``;

    await recipes.asyncForEach(async item => {
        conn= await getConn();
        review= await executeQuery(conn, `
            SELECT *
            FROM review
            WHERE id_resep = '${item.id_resep}' ${optional}
        `);

        conn.release();

        if (optional !== ``) {
            review.forEach(o => {
                result.kumpulan_review.push({
                    email_reviewer: o.email_reviewer,
                    kode_resep: item.id_resep, 
                    judul_resep: item.judul_resep,
                    isi_review: o.isi_review,
                });
            });
        } else {
            result.push({
                kode_resep: item.id_resep,
                judul_resep: item.judul_resep,
                review_resep: review.map(o => ({
                    email_reviewer: o.email_reviewer,
                    isi_review: o.isi_review,
                    tanggal_review: o.tanggal_review
                }))
            });
        }
    }); 

    if (optional !== `` && !result.kumpulan_review.length) {
        return res.status(404).json({
            status: 404,
            message: 'Tidak ditemukan.'
        });
    }
    
    if (optional === `` && !result.length) {
        return res.status(404).json({
            status: 404,
            message: 'Tidak ditemukan.'
        });
    }

    return res.status(200).json({
        status: 200,
        reviews: result
    });
});

Array.prototype.asyncForEach = async function(callback, thisArg) {
	thisArg = thisArg || this;
	
	for (let i = 0, l = this.length; i !== l; ++i) {
		await callback.call(thisArg, this[i], i, this);
	}
};
