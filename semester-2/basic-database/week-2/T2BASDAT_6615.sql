--tabel pertandingan_sepakbola
create table pertandingan_sepakbola
(
id_pertandingan varchar(10) primary key,
nama_pertandingan varchar(20) not null,
tgl_pertandingan date not null,
lokasi_pertandingan varchar(30) not null
);

--tabel club_sepakbola
create table club_sepakbola
(
id_club varchar(10) primary key,
nama_club varchar(20) unique,
pemilik_club varchar(20) not null,
lokasi_club varchar(20) not null,
id_pertandingan varchar(10), 
constraint club_pertandingan foreign key (id_pertandingan) 
references pertandingan_sepakbola (id_pertandingan)
);

--tabel pemain
create table pemain
(
id_pemain varchar(10) primary key,
nama_pemain varchar(20) not null,
umur_pemain number not null,
tgllahir_pemain date not null,
id_club varchar(10),
constraint pemain_club foreign key (id_club)
references club_sepakbola (id_club)
);

--tabel pelatih
create table pelatih
(
id_pelatih varchar(10) primary key,
nama_pelatih varchar(20) not null,
umur_pemain number not null,
tempaptinggal_pelatih varchar(20) not null,
tgllahir_pelatih date not null,
id_club varchar(10),
constraint pelatih_club foreign key (id_club)
references club_sepakbola (id_club)
);

--tabel skor
create table skor
(
id_skor varchar(10) primary key,
banyak_skor integer not null,
namapencetak_skor varchar(20) not null,
namateam_skor varchar(20) not null
);

--tabel pelanggaran
create table pelanggaran
(
id_pelanggaran varchar(10) primary key,
jenis_pelanggaran varchar(50) not null,
kartu_pelanggaran varchar(50) not null,
pemain_pelanggaran varchar(50) not null
);

--tabel medis
create table medis
(
id_medis varchar(10) primary key,
nama_medis varchar(20) not null,
jeniskelamin_medis varchar(20) not null,
umur_medis number not null
);

--tabel komentator
create table komentator
(
id_komentator varchar(10) primary key,
nama_komentator varchar(30) not null,
jeniskelamin_komentator varchar(20) not null,
umur_komentator number not null,
id_pertandingan varchar(10),
constraint komentator_pertandingan foreign key (id_pertandingan)
references pertandingan_sepakbola (id_pertandingan) 
);

--tabel keamanan
create table keamanan
(
id_keamanan varchar(10) primary key,
nama_keamanan varchar(20) not null,
jeniskelamin_keamanan varchar(20) not null,
umur_keamanan number not null
);

--tabel penonton
create table penonton
(
id_penonton varchar(10) primary key,
ktp_penonton number unique,
umur_penonton number not null,
jeniskelamin_penonton varchar(20) not null
);

--tabel kios
create table kios
(
id_kios varchar(10) primary key,
nama_kios varchar(30) unique,
jenismakanan_kios varchar(30) not null,
jenissouvenir_kios varchar(30) not null
);

--isi tabel
--pertandingan_sepakbola
insert into pertandingan_sepakbola values ('S101','BONDING BALL','17-AUGUST-18','STADION GELORA BUNG KARNO');
insert into pertandingan_sepakbola values ('S102','VICTORIOUS','25-AUGUST-18','STADION GELORA BUNG KARNO');
insert into pertandingan_sepakbola values ('S103','JUNIOR CHAMPION','01-SEPTEMBER-18','STADION GELORA BUNG KARNO');
insert into pertandingan_sepakbola values ('S104','PROVINCE TOURNAMENT','10-SEPTEMBER-18','STADION GELORA BUNG KARNO');
insert into pertandingan_sepakbola values ('S105','LIGA FORZA','02-DECEMBER-18','STADION GELORA BUNG KARNO');

--club_sepakbola
insert into club_sepakbola values ('C101','PERSIJA JAKARTA','GEDE WIDIADE','JAKARTA','S101');
insert into club_sepakbola values ('C102','PERSIB BANDUNG','PT. PBB','BANDUNG','S102');
insert into club_sepakbola values ('C103','AREMA CRONUS','OVAN TOBING','MALANG','S103');
insert into club_sepakbola values ('C104','PERSEBAYA','JAWA POS','SURABAYA','S104');
insert into club_sepakbola values ('C105','SRIWIJAYA FC','SYAHRIAL OESMAN','PALEMBANG','S105');

--pemain
insert into pemain values ('P101','BAMBANG PAMUNGKAS',37,'10-JUNE-1980','C101');
insert into pemain values ('P102','FEBRI HARYADI',22,'19-FEBRUARY-1996','C102');
insert into pemain values ('P103','KURNIA MEIGA',27,'7-MAY-1990','C103');
insert into pemain values ('P104','ANDIK VERMANSYAH',26,'23-NOVEMBER-1991','C104');
insert into pemain values ('P105','TALAOHU MUSAFRI',36,'19-FEBRUARY-1982','C105');

--pelatih
insert into pelatih values ('PL101','STEFANO CUGURRA',43,'BRAZIL','25-JULY-1974','C101');
insert into pelatih values ('PL102','ROBERTO CARLOZ',44,'BRAZIL','10-APRIL-1973','C102');
insert into pelatih values ('PL103','JOKO SUSILO',47,'CEPU','9-DECEMBER-1970','C103');
insert into pelatih values ('PL1O4','ANGEL ALFREDO',41,'ARGENTINA','18-AUGUST-1972','C104');
insert into pelatih values ('PL105','RACHMAD DARMAWAN',51,'TANGERANG','28-NOVEMBER-1966','C105');

--skor
insert into skor values ('SK101',3,'BAMBANG PAMUNGKAS','PERSIJA JAKARTA');
insert into skor values ('SK102',1,'TONY SUCIPTO','PERSIB BANDUNG');
insert into skor values ('SK103',1,'BENNY WAHYUDI','AREMA CRONUS');
insert into skor values ('SK104',2,'ANDIK VERMANSYAH','PERSEBAYA');
insert into skor values ('SK105',1,'ABDOULAYE MAIGA','SRIWIJAYA FC');

--pelanggaran
insert into pelanggaran values ('F101','TIDAK SPORTIF','KUNING','TALAOHU MUSAFRI');
insert into pelanggaran values ('F102','MENARIK KAOS LAWAN','MERAH','ABDOULAYE MAIGA');
insert into pelanggaran values ('F103','BERKATA KASAR','KUNING','FEBRI HARYADI');
insert into pelanggaran values ('F104','MENGULUR WAKTU','KUNING','ANDIK VERMANSYAH');
insert into pelanggaran values ('F105','MEMEGANGI TUBUH LAWAN','MERAH','KURNIA MEIGA');

--medis
insert into medis values ('M101','dr. Indra Susanto','LAKI-LAKI',50);
insert into medis values ('M102','dr. M.Rizal','LAKI-LAKI',42);
insert into medis values ('M103','dr. Fannyta Tunggari','PEREMPUAN',33);
insert into medis values ('M104','dr. Raddy Irmawan','LAKI-LAKI',29);
insert into medis values ('M105','dr. Lia Nazliah','PEREMPUAN',49);

--komentator
insert into komentator values ('K101','VALENTINO SIMANJUNTAK','LAKI-LAKI',34,'S101');
insert into komentator values ('K102','DARIUS','LAKI-LAKI',35,'S102');
insert into komentator values ('K103','BUNG TOWEL','LAKI-LAKI',42,'S103');
insert into komentator values ('K104','ANDINI NURMALASARI','PEREMPUAN',29,'S104');
insert into komentator values ('K105','SANDRA OLGA','PEREMPUAN',28,'S105');

--keamanan
insert into keamanan values ('KN101','M. GOZALI','LAKI-LAKI',37);
insert into keamanan values ('KN102','BAYU HADI','LAKI-LAKI',42);
insert into keamanan values ('KN103','ILHAM RETNO','LAKI-LAKI',45);
insert into keamanan values ('KN104','NURUL FAJAR','LAKI-LAKI',51);
insert into keamanan values ('KN105','I GEDE ADI','LAKI-LAKI',49);

--penonton
insert into penonton values ('PN101','3578276602',19,'LAKI-LAKI');
insert into penonton values ('PN102','3578276619',23,'PEREMPUAN');
insert into penonton values ('PN103','3578276676',32,'PEREMPUAN');
insert into penonton values ('PN104','3578276690',27,'LAKI-LAKI');
insert into penonton values ('PN105','3578276643',40,'LAKI-LAKI');

--kios
insert into kios values ('KS101','SPORTIVA','AYAM KENCTUCKY','JERSEY');
insert into kios values ('KS102','FOOD BALL','NASI GORENG','GANTUNGAN KUNCI');
insert into kios values ('KS103','BALLECTION','KENTANG GORENG','BOLA');
insert into kios values ('KS104','HOUSE OF FOOD AND SPORT','MIE GORENG','TOPI');
insert into kios values ('KS105','LIVE EAT SPORT','SOFT DRINK','BAJU');

--tambah field
alter table medis add spesialis varchar(20) not null;
alter table keamanan add profesi varchar(20) not null;
alter table penonton add ticket varchar(20) not null;
alter table kios add stock int not null;

--ubah data
--skor
update skor set namapencetak_skor= 'ROHIT CHAND' where namapencetak_skor= 'BAMBANG PAMUNGKAS';
update skor set namapencetak_skor= 'ATEP RIZAL' where namapencetak_skor= 'TONY SUCIPTO';
update skor set namapencetak_skor= 'CHRISTIAN GONZALES' where namapencetak_skor= 'BENNY WAHYUDI';
update skor set namapencetak_skor= 'EVAN DIMAS' where namapencetak_skor= 'ANDIK VERMANSYAH';
update skor set namapencetak_skor= 'KEITH GUMBS' where namapencetak_skor= 'ABDOULAYE MAIGA';

--medis
update medis set nama_medis= 'dr. Bagus Dewa' where nama_medis= 'dr. Indra Susanto';
update medis set nama_medis= 'dr. Rony Susilo' where nama_medis= 'dr. M.Rizal';
update medis set nama_medis= 'dr. Sisilia' where nama_medis= 'dr. Fannyta Tunggari';
update medis set nama_medis= 'dr. Fariz Ilham' where nama_medis= 'dr. Raddy Irmawan';
update medis set nama_medis= 'dr. Intan Kurnia' where nama_medis= 'dr. Lia Nazliah';

--delete data
--penonton
delete from penonton where umur_penonton= '19';
delete from penonton where umur_penonton= '23';
delete from penonton where umur_penonton= '32';
delete from penonton where umur_penonton= '27';
delete from penonton where umur_penonton= '40';

--pelanggaran
delete from pelanggaran where jenis_pelanggaran= 'TIDAK SPORTIF';
delete from pelanggaran where jenis_pelanggaran= 'MENARIK KAOS LAWAN';
delete from pelanggaran where jenis_pelanggaran= 'BERKATA KASAR';
delete from pelanggaran where jenis_pelanggaran= 'MENGULUR WAKTU';
delete from pelanggaran where jenis_pelanggaran= 'MEMEGANGI TUBUH LAWAN';