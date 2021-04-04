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
    database: "minggu5_soa_senin"
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

app.post('/api/addProduct',function(req,res){
    var nama = req.body.nama_product;
    var harga = req.body.harga_product;
    var kategori = req.body.kategori_product;

    if(nama==""||harga==""||kategori==""){
        var respons = {
            status:0,
            message:"Ada field yang masih kosong"
        }
        res.json(respons);
    }else{
        con.query("INSERT INTO PRODUCTS VALUES(?,?,?,?)",['',nama,harga,kategori],function(err,rows,fields){
            if(err)console.error(err);
            else{
                var response = {
                    status:1,
                    message:"Add Product berhasil"
                }
                res.status(200).json(response);
            }
        });
    }
});

app.post('/api/registerUser',(req , res)=>{
    var username=req.body.username;
    var password=req.body.password;
    var nama=req.body.nama;
    con.query("select count(*) as jumlah from user where username=?",[username],function(error,rows,fields){
        if(rows[0].jumlah>0){
            var response={
                'status':0,
                'message':'Username sudah dipakai sebelumnya'
            }
            res.status(200).json(response);
        }else{
            con.query("insert into user values(?,?,?,?)",[0,username,password,nama], (error, rows, fields) => {
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

app.get('/api/getAllProducts',function(req,res){
    con.query('select * from products', (error, rows, fields) => {
        if (error) {
            console.error(error);
        } else {
            res.json(rows);
        }
    });
});

app.get('/api/searchProduct/:keyword',function(req,res){
    var nama = req.params.keyword;
    con.query("SELECT * FROM products WHERE nama_product like '%"+nama+"%'",function(err,rows,fields){
        if(err) console.error(err);
        else{
            if(rows.length==0){
                var respons = {
                    status:0,
                    message:"Tidak ada product dengan nama tersebut"
                }
                res.json(respons);
            }else{
                res.json(rows);
            }}
    });
});

app.delete('/api/deleteProduct/:idproduct',function(req,res){
    var id_product=req.params.idproduct;
    con.query('select count(*) as jumlah from products where id_product=?',[id_product],function(error,rows,fields){
        if(rows[0].jumlah==0){
            var notification={
                'status':0 ,
                'message':'ID barang tidak ditemukan'
            };
                res.status(200).json(notification);
        }else{
            con.query('delete from products where id_product=?',[id_product], (error, rows, fields) => {
                if (error) {
                    console.error(error);
                } else {
                    let notification={
                        'status':1 ,
                        'message':'Delete Barang Berhasil'
                    };
                    res.json(notification);
                }
            });
        }
    });
});

app.get('/searchProductByKeyword/:keyword',function(req,res){
    con.query('select * from user', (error, rows, fields) => {
        if (error) {
            console.error(error);
        } else {
            rows.forEach(row => {
                console.log(row.id);
            });
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
console.log('Web Service is running on PORT 3000');
