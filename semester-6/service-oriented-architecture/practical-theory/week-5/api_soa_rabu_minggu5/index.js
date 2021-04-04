const express = require('express');
const mysql = require("mysql");
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true}));

app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.header("Access-Control-Allow-Methods", 'GET,PUT,POST,DELETE');
    next();
 });

const conn = mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"",
    database:"db_soa_w5",
    multipleStatements:true
});

conn.connect((err) => {
    if(!err){
        console.log("Connected to DB");
    }else{
        console.log("Connection Failed!");
    }
});

app.post('/api/topup', (req, res) => {
    const nohp = req.body.nomorhp;
    const password = req.body.password;
    const jumlah = req.body.jumlah;

    let check = "select * from user where nomorhp='"+nohp+"' and password='"+password+"'";

    if(nohp && password && jumlah){
        conn.query(check, (err, result) => {
            let response = {
                status: 200,
                message: "Sukses"
            };
            let hasilCekUser = result;
            if(hasilCekUser.length > 0){
                let jumSaldo = parseInt(hasilCekUser[0].saldo);
                jumSaldo = parseInt(jumlah) + parseInt(jumSaldo);
                
                let queryInsertSaldo = "insert into history values ('','"+nohp+"','+"+jumlah+"','TOPUP SALDO')"
                conn.query(queryInsertSaldo, (err, result));

                let queryUpdateSaldo = "update user set saldo='"+jumSaldo+"' where nomorhp='"+nohp+"'";
                conn.query(queryUpdateSaldo, (err, result));

                response.saldo = jumSaldo;
            }else{
                response.status = 400;
                response.message = "Nomor HP / Password Salah!";
            }
            res.send(response);
            return;
        });
    }else{
        let response = {
            status: 400,
            message: "Field harus terisi!"
        };
        res.send(response);
        return;
    }
});

app.post('/api/user', (req, res) => {
    const nohp = req.body.nomorhp;
    const password = req.body.password;

    let queryGetUserInfo = "select * from user where nomorhp='"+nohp+"' and password='"+password+"'";

    if(!nohp || !password){
        let response = {
            status: 400,
            message: "Field harus terisi!"
        };
        res.send(response);
        return;
    }else{
        conn.query(queryGetUserInfo, (err, result) => {
            let response = {
                status: 200,
                message: "Sukses"
            };
            let hasilCekUser = result;
            if(hasilCekUser.length > 0){
                response.data = hasilCekUser;
            }else{
                response.status = 400;
                response.message = "Nomor HP / Password Salah!";
            }
            res.send(response);
            return;
        });
    }
});

app.post('/api/register', (req, res) => {
    const nohp = req.body.nomorhp;
    let queryUser ="select * from user where nomorhp='"+nohp+"'";

    if(nohp) {
        conn.query(queryUser, (err, result) => {
            if (err) throw err;
            const hasil = result;
            let response = {
                status: 200,
                message: "Sukses"
            };
            if(hasil.length > 0){
                response.status = 400;
                response.message = "User sudah digunakan!";
            }else{
                const nama = req.body.nama;
                const alamat = req.body.alamat;
                const password = req.body.password;
                const cpassword = req.body.cpassword;
    
                if(!nama || !alamat || !password || !cpassword){
                    response.status = 400;
                    response.message = "Pastikan semua field terisi!";
                }else{
                    if(password != cpassword){
                        response.status = 400;
                        response.message = "Password dan Confirm Password tidak sama!";
                    }else{
                        let queryinsert = "insert into user values ('"+nama+"','"+nohp+"','"+alamat+"','"+password+"','0')";
                        conn.query(queryinsert, (err, result) => {
                            if (err) throw err;
                        })
                        response.nomorhp = nohp;
                        response.nama = nama;
                        response.alamat = alamat;
                    }
                }
            }
            res.send(response);
            return;
        });
    }else{
        let response = {
            status: 400,
            message: "Nomor HP harus diisi!"
        };
        res.status(200).send(response);
        return;
    }
});

app.put('/api/updateUser', (req, res) => {
    const nohp = req.body.nomorhp;
    const password = req.body.password;

    let queryGetUserInfo = "select * from user where nomorhp='"+nohp+"' and password='"+password+"'";

    if(!nohp || !password){
        let response = {
            status: 200,
            message: "Field harus terisi!"
        };
        res.send(response);
        return;
    }else{
        conn.query(queryGetUserInfo, (err, result) => {
            let response = {
                status: 200,
                message: "Sukses"
            };
            let hasilCekUser = result;
            if(hasilCekUser.length > 0){
                const nama = req.body.nama;
                const alamat = req.body.alamat;

                if(nama && alamat){
                    let queryUpdateUser = "update user set nama='"+nama+"', alamat='"+alamat+"' where nomorhp='"+nohp+"'";

                    conn.query(queryUpdateUser, (err, result));
                    response.status = 200;
                    response.nama = nama;
                    response.alamat = alamat;
                    response.nomorhp = nohp;
                }else{
                    response.status = 400;
                    response.message = "Nama / alamat harus terisi";
                }
            }else{
                response.status = 400;
                response.message = "Nomor HP / Password Salah!";
            }
            res.send(response);
            return;
        });
    }
});

app.post('/api/transaksi', (req, res) => {
    const nohp = req.body.nomorhp;
    const password = req.body.password;
    const jumlah = req.body.jumlah;
    const pesan = req.body.pesan;

    let check = "select * from user where nomorhp='"+nohp+"' and password='"+password+"'";

    if(nohp && password && jumlah && pesan){
        conn.query(check, (err, result) => {
            let response = {
                status: 200,
                message: "Sukses"
            };
            let hasilCekUser = result;
            if(hasilCekUser.length > 0){
                let jumSaldo = parseInt(hasilCekUser[0].saldo);
                
                if(parseInt(jumSaldo) - parseInt(jumlah) >= 0){
                    jumSaldo = parseInt(jumSaldo) - parseInt(jumlah);

                    let queryInsertSaldo = "insert into history values ('','"+nohp+"','-"+jumlah+"','"+pesan+"')"
                    conn.query(queryInsertSaldo, (err, result));

                    let queryUpdateSaldo = "update user set saldo='"+jumSaldo+"' where nomorhp='"+nohp+"'";
                    conn.query(queryUpdateSaldo, (err, result));

                    response.message = "Sukses";
                    response.saldo = jumSaldo;
                }else{
                    response.status = 400;
                    response.message = "Saldo Tidak Cukup!";
                }
            }else{
                response.status = 400;
                response.message = "Nomor HP / Password Salah!";
            }
            res.send(response);
            return;
        });
    }else{
        let response = {
            status: 400,
            message: "Field harus terisi!"
        };
        res.send(response);
        return;
    }
});

app.get('/api/viewhistory', (req, res) => {
    const nohp = req.body.nomorhp;
    const password = req.body.password;

    let queryGetUserInfo = "select * from user where nomorhp='"+nohp+"' and password='"+password+"'";

    if(!nohp || !password){
        let response = {
            status: 400,
            message: "Field harus terisi!"
        };
        res.send(response);
        return;
    }else{
        conn.query(queryGetUserInfo, (err, result) => {
            let response = {
                status: 200,
                message: "Sukses"
            };
            let hasilCekUser = result;
            if(hasilCekUser.length > 0){
                let queryViewHistory = "select * from history where nomorhp='"+nohp+"'";
    
                conn.query(queryViewHistory, (err, result) => {
                    if(err) throw err;
                    let response = {
                        status: 200,
                        message: "Sukses"
                    };
                    response.history = result;
                    res.send(response);
                    return;
                });
            }else{
                response.status = 400;
                response.message = "Nomor HP / Password Salah!";
                res.send(response);
                return;
            }
        });
    }
});

app.listen(3000, () => console.log("Listening on port "+3000+"..."));