const express = require('express'),
      app = express(),
      port = process.env.port || 3000,
      bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

const mysql = require('mysql');
var con = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "tutor_soa_minggu5"
});

con.connect(err => {
    if (err) throw err;
});


app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.header("Access-Control-Allow-Methods", 'GET,PUT,POST,DELETE');
    next();
  });

app.post('/api/registerUser',(req , res)=>{
    var username=req.body.username;
    var password=req.body.password;
    con.query("select count(*) as jumlah from user where username=?",[username],function(error,rows,fields){
        if(rows[0].jumlah>0){
            var response={
                'status':0,
                'message':'Username sudah dipakai sebelumnya'
            }
            res.status(200).json(response);
        }else{
            con.query("insert into user values(?,?,?)",[0,username,password], (error, rows, fields) => {
                if (error) {
                    console.error(error);
                } else {
                    let notification={
                        'status':1 ,
                        'message':'Berhasil Register'
                    };
                    res.status(200).json(notification);      
                }
            });
        }
    });
});

app.get('/api/getAllUser',function(req,res){
    con.query('select * from user', (error, rows, fields) => {
        if (error) {
            console.error(error);
        } else {
            res.json(rows);
        }
    });
});

app.delete('/api/deleteUser/:iduser',function(req,res){
    var id_user=req.params.iduser;
    con.query('select count(*) as jumlah from user where id=?',[id_user],function(error,rows,fields){
        if(rows[0].jumlah==0){
            var notification={
                'status':0 ,
                'message':'ID user tidak ditemukan'
            };
                res.status(200).json(notification);
        }else{
            con.query('delete from user where id=?',[id_user], (error, rows, fields) => {
                if (error) {
                    console.error(error);
                } else {
                    let notification={
                        'status':1 ,
                        'message':'Delete User Berhasil'
                    };
                    res.status(200).json(notification);
                }
            });
        }
    });
});

app.get('/api/getUser/:iduser',function(req,res){
    var id_user=req.params.iduser;
    con.query('select * from user where id=?',[id_user], (error, rows, fields) => {
        if (error) {
            console.error(error);
        } else {
            res.json(rows);
        }
    });
});

app.post('/api/checkLogin',(req , res)=>{
    var username=req.body.username;
    var password=req.body.password;
    if(username=="admin" && password=="admin"){
        var response={
            'status':1,
            'message':"Berhasil login sebagai admin"
        }
        res.json(response);
    }else{
        con.query("select count(*) as jumlah from user where username=? and password=?",[username,password], (error, rows, fields) => {
            if (error) {
                console.error(error);
            } else {
               if(rows[0].jumlah>0){
                let notification={
                    'status':2 ,
                    'message':'Berhasil login sebagai user'
                };
                    res.json(notification);
               }else{
                let notification={
                    'status':0 ,
                    'message':'Login Gagal'
                };
                    res.json(notification);
               }
            }
        });
    }
});

app.listen(3000);