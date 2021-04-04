const express = require("express");
const mysql = require("mysql");
const app = express();
const jwt = require("jsonwebtoken");

const pool = mysql.createPool({
    host:"localhost",
    database:"minggu7_soa_senin",
    user:"root",
    password:""
})

app.use(express.urlencoded({extended:true}));


app.post('/api/registerUser', (req, res) => {
    var tampungemail=[];

    if (!req.body.email || !req.body.nama || !req.body.password ) res.status(400).send('Isi semua field !');
    else{

        var email = req.body.email;
        var nama = req.body.nama;
        var password = req.body.password;
                            
        pool.query("select * from user where email_user=?",[email], (error,rows,fields) => {
            if(error){
                console.error(error);
            }
            else{
                rows.forEach(row =>{
                    tampungemail.push(row.email);
                });
    
                if(tampungemail.length>0){
                    res.status(400).send('email sudah terpakai !');
                }
                else{
                    var apikey="";
                    for(var i =0;i<10;i++){
                        var angka= Math.floor(Math.random() * 10);
                        apikey=apikey+angka;
                    }
                    
                    pool.query("insert into user values(?,?,?,0,?,0)",[email,password,nama,apikey], (error,rows,fields) => {
                        if(error){
                            console.error(error);
                        }
                        else{
                            res.status(200).send(apikey);
                        }
                    })
                }
            }
        });       
    }
});

app.post('/api/topup', (req, res) => {
    var tampungsaldo=[]
    if (!req.body.email || !parseInt(req.body.nominal)) res.status(400).send('Isi semua field !');
    else{
        var email = req.body.email;
        var nominal = parseInt(req.body.nominal);

        pool.query("select * from user where email_user=?",[email], (error,rows,fields) => {
            if(error){
                console.error(error);
            }
            else{
                rows.forEach(row =>{
                    tampungsaldo.push(row.saldo_user);
                });
    
                if(tampungsaldo.length==0){
                    res.status(400).send('email tidak ditemukan !');
                }
                else{
                    var saldosekarang= tampungsaldo[0]+nominal;
                    pool.query("update user set saldo_user=? where email_user=?",[saldosekarang,email], (error,rows,fields) => {
                        if(error){
                            console.error(error);
                        }
                        else{
                            res.status(200).send("Saldo sekarang : "+saldosekarang);
                        }
                    });   
                }
            }
        });       
    }
});

app.post('/api/addLaporan', (req, res) => {
    var tampungsaldo=[];
    var judul = req.body.judul;
    var jenis = req.body.jenis;
    var deskripsi = req.body.deskripsi;
    var barang = req.body.barang;
    var alamat = req.body.alamat;
    var tanggal = req.body.tanggal;
    var kodepos = req.body.kodepos;
    var email = req.body.email;
    var apikey = parseInt(req.body.apikey);

    pool.query("select * from user where email_user=? and api_key=?",[email,apikey], (error,rows,fields) => {
        if(error){
            console.error(error);
        }
        else{
            rows.forEach(row =>{
                tampungsaldo.push(row.email_user);
            });

            if(tampungsaldo.length==0){
                res.status(400).send('email tidak ditemukan atau apikey salah !');
            }
            else{
                pool.query("insert into laporan_lostfound values(null,?,?,?,?,?,?,?,?)",[judul,jenis,deskripsi,barang,alamat,tanggal,kodepos,email], (error,rows,fields) => {
                    if(error){
                        console.error(error);
                    }
                    else{
                        res.status(200).send("berhasil tambah laporan");
                    }
                }) 
            }
        }
    }); 
              
});

app.post('/api/subscribeAPI', (req, res) => {
    var tampungsaldo=[]
    if (!req.body.email) res.status(400).send('Isi semua field !');
    else{
        var email = req.body.email;

        pool.query("select * from user where email_user=?",[email], (error,rows,fields) => {
            if(error){
                console.error(error);
            }
            else{
                rows.forEach(row =>{
                    tampungsaldo.push(row.saldo_user);
                });
    
                if(tampungsaldo.length==0){
                    res.status(400).send('email tidak ditemukan !');
                }
                else{
                    if(tampungsaldo[0]<150000){
                        res.status(400).send("Butuh saldo 150000 untuk dapat subscribe")
                    }
                    else{
                        pool.query("update user set tipe_user=1 where email_user=?",[email], (error,rows,fields) => {
                            if(error){
                                console.error(error);
                            }
                            else{
                                res.status(200).send("Anda berhasil subscribe");
                            }
                        });  
                    } 
                }
            }
        });       
    }
});


app.post("/api/loginUser",function(req,res) {
    const email = req.body.email;
    const password = req.body.password;
    const tampung = [];

    pool.query(`select * from user where email='${email}' and password ='${password}'`,function(error,result){
        if(error ) res.status(500).send(error);
        else{
            if(result.length <=0){
                return res.status(400).send("Invalid Username or password");
            }
            else{
                result.forEach(row =>{
                    tampung.push(row.tipe);
                });

                const token = jwt.sign({    
                    "email":email,
                    "tipe":tampung[0]
                }   ,"217116594");
                res.status(200).send(token);
            }
        }
    })
});

app.post("/api/createClass",function(req,res) {
    const nama = req.body.nama;
    const deskripsi = req.body.deskripsi;
    const grade = req.body.grade;
    const token = req.body.token;

    let user = {};
    if(!token){
        res.status(401).send("Token not found");
    }
    try{
        user = jwt.verify(token,"217116594");
    }catch(err){
        //401 not authorized
        res.status(401).send("Token Invalid");
    }
    if((new Date().getTime()/1000)-user.iat>3*86400){
        return res.status(400).send("Token expired");
    }
    if(user.tipe==0){ 
        return res.status(400).send("you are not allowed to access this resource")
    }
    else{
        if (!req.body.nama || !req.body.deskripsi || !req.body.grade) res.status(400).send('Isi semua field !');
        else{
            if (grade!="SMA" && grade!="SMP" && grade!="SD") res.status(400).send('Grade Class salah !');
            else{
                pool.query(`select * from class`,function(error,result){
                    if(error ) res.status(500).send(error);
                    else{
                        var banyak = result.length+1;
                        var kode = "";

                        if(banyak>0 && banyak<=9){
                            kode = "KE00"+ banyak;   
                        }
                        else if(banyak>=10 && banyak<=99){
                            kode = "KE0"+ banyak;
                        }
                        else{
                            kode = "KE"+banyak;
                        }
                        
                        pool.query("insert into class values(?,?,?,?)",[kode,nama,deskripsi,grade], (error,rows,fields) => {
                            if(error){
                                console.error(error);
                            }
                            else{
                                res.status(200).send(kode);
                            }
                        })

                    }
                })
            }
        }
    }
});

app.post("/api/joinClass",function(req,res) {
    const email = req.body.email;
    const kode = req.body.kode;
    const token = req.body.token;

    let user = {};
    if(!token){
        res.status(401).send("Token not found");
    }
    try{
        user = jwt.verify(token,"217116594");
    }catch(err){
        //401 not authorized
        res.status(401).send("Token Invalid");
    }
    if((new Date().getTime()/1000)-user.iat>3*86400){
        return res.status(400).send("Token expired");
    }

    if (!req.body.email || !req.body.kode) res.status(400).send('Isi semua field !');
        else{
            pool.query(`select * from user where email=?`,[email],function(error,result){
                if(error ) res.status(500).send(error);
                else{
                    if(result.length==0) res.status(404).send('email tidak ditemukan');
                    else{
                        var nama = "";
                        result.forEach(row =>{
                            nama=row.nama;
                        });
                        pool.query(`select * from class where kode=?`,[kode],function(error,result){
                            if(error ) res.status(500).send(error);
                            else{
                                if(result.length==0) res.status(400).send('kode kelas salah');
                                else{
                                    if(user.tipe==0){ 
                                        pool.query(`select * from murid where email=? and class=?`,[email,kode],function(error,result){
                                            if(error ) res.status(500).send(error);
                                            else{
                                                if(result.length>0) res.status(400).send('anda sudah ada di kelas');
                                                else{
                                                    pool.query("insert into murid values(?,?,?)",[email,kode,nama], (error,rows,fields) => {
                                                        if(error){
                                                            console.error(error);
                                                        }
                                                        else{
                                                            res.status(200).send("Berhasil join class");
                                                        }
                                                    })
                                                }
                                            }
                                        });
                                    }
                                    else{
                                        pool.query(`select * from guru where email=? and class=?`,[email,kode],function(error,result){
                                            if(error ) res.status(500).send(error);
                                            else{
                                                if(result.length>0) res.status(400).send('anda sudah ada di kelas');
                                                else{
                                                    pool.query("insert into guru values(?,?,?)",[email,kode,nama], (error,rows,fields) => {
                                                        if(error){
                                                            console.error(error);
                                                        }
                                                        else{
                                                            res.status(200).send("Berhasil join class");
                                                        }
                                                    })
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        })
                    }
                }
            });
        }
});

app.get("/api/getAllClass/:email/:token",function(req,res) {
    const email = req.params.email;
    const token = req.params.token;

    let kodekelas=[];
    let namakelas=[];
    let output=[];
    let murid=[];
    let muridkelas=[];
    let tampung=[];
    let jumlah=[];
    
    let user = {};
    if(!token){
        res.status(401).send("Token not found");
    }
    try{
        user = jwt.verify(token,"217116594");
    }catch(err){
        //401 not authorized
        res.status(401).send("Token Invalid");
    }
    if((new Date().getTime()/1000)-user.iat>3*86400){
        return res.status(400).send("Token expired");
    }
    if(user.tipe==0){ 
        return res.status(400).send("you are not allowed to access this resource")
    }
    else{
        pool.query(`select * from guru where email='${email}'`,function(error,result){
            if(error ) res.status(500).send(error);
            else{
                if(result.length <=0){
                    return res.status(400).send("Email salah");
                }
                else{
                    result.forEach(row =>{
                        kodekelas.push(row.class);
                    });
                    
                    pool.query(`select * from class`,function(error,result){
                        if(error ) res.status(500).send(error);
                        else{
                            result.forEach(row =>{

                                const databaru = {
                                    kode_kelas: row.kode,
                                    namakelas: row.nama
                                };
                                tampung.push(databaru);
                            });

                            for (let i = 0; i < kodekelas.length; i++) {
                                const cekkelas = tampung.find(t => t.kode_kelas === kodekelas[i] );   
                                namakelas.push(cekkelas.namakelas);
                            }

                            pool.query(`select * from murid`,function(error,result){
                                if(error ) res.status(500).send(error);
                                else{
                                    let email = [];
                                    let nama = [];
                                    let kelas = [];
                                    result.forEach(row =>{
                                        email.push(row.email);
                                        nama.push(row.nama);
                                        kelas.push(row.class);
                                    });

                                    
                                    for (let i = 0; i < kodekelas.length; i++) {
                                        murid=[];
                                        for (let j = 0; j < email.length; j++) {
                                            if(kodekelas[i]==kelas[j]){
                                                let databaru = {
                                                    email_user: email[j],
                                                    nama_user: nama[j]
                                                };
                                                murid.push(databaru);
                                            }
                                        }
                                        muridkelas.push(murid);
                                        
                                    }
                                    
                                    for (let i = 0; i < kodekelas.length; i++) {
                                        const databaru = {
                                            kode_kelas: kodekelas[i],
                                            nama_kelas: namakelas[i],
                                            murid: muridkelas[i],
                                            jumlah_murid: muridkelas[i].length
                                        };
                                        output.push(databaru);
                                    }
                                    res.send(output);

                                }
                            });
                        }
                    });
                }
            }
        })
    }
});

app.post("/api/createAssignment",function(req,res) {
    const kodekelas = req.body.kode;
    const nama = req.body.nama;
    const deskripsi = req.body.deskripsi;
    const deadline = req.body.deadline;
    const token = req.body.token;

    let user = {};
    if(!token){
        res.status(401).send("Token not found");
    }
    try{
        user = jwt.verify(token,"217116594");
    }catch(err){
        //401 not authorized
        res.status(401).send("Token Invalid");
    }
    if((new Date().getTime()/1000)-user.iat>3*86400){
        return res.status(400).send("Token expired");
    }
    if(user.tipe==0){ 
        return res.status(400).send("you are not allowed to access this resource")
    }
    else{
        if (!req.body.nama || !req.body.deskripsi || !req.body.kode|| !req.body.deadline) res.status(400).send('Isi semua field !');
        else{
            pool.query(`select * from class where kode=?`,[kodekelas],function(error,result){
                if(error ) res.status(500).send(error);
                else{
                    if(result==0) res.status(400).send("kode kelas tidak ada")
                    else{
                        pool.query(`select * from guru where email=? and class=?`,[user.email,kodekelas],function(error,result){
                            if(error ) res.status(500).send(error);
                            else{
                                if(result==0) res.status(400).send("anda tidak mengajar dikelas ini")
                                else{
                                    pool.query(`select * from tugas`,function(error,result){
                                        if(error ) res.status(500).send(error);
                                        else{
                                            var banyak = result.length+1;
                                            var kode = "";

                                            if(banyak>0 && banyak<=9){
                                                kode = "TU00"+ banyak;   
                                            }
                                            else if(banyak>=10 && banyak<=99){
                                                kode = "TU0"+ banyak;
                                            }
                                            else{
                                                kode = "TU"+banyak;
                                            }

                                            pool.query("insert into tugas values(?,?,?,?,?)",[kode,nama,kodekelas,deskripsi,deadline], (error,rows,fields) => {
                                                if(error){
                                                    console.error(error);
                                                }
                                                else{
                                                    res.status(200).send(kode);
                                                }
                                            })
                                        }
                                    })
                                }
                            }
                        });
                    }
                }
            })
        }
    }
});


//authorization ->hak akses
//authentication ->masuk ta ga
app.get("/api/tes",function(req,res){
    const token = req.header("x-auth-token");
    let user = {};
    if(!token){
        res.status(401).send("Token not found");
    }
    try{
        user = jwt.verify(token,"freebooks");
    }catch(err){
        //401 not authorized
        res.status(401).send("Token Invalid");
    }
    if((new Date().getTime()/1000)-user.iat>3*86400){
        return res.status(400).send("Token expired");
    }
    if(user.level>0){ //cek bukan admin, kalau admin level 0
        //proses authorization
        return res.status(400).send("you are not allowed to access this resource")
    }
    res.status(200).send(user);
});

app.listen(3000,function(){
    console.log("Listening to port 3000");
})