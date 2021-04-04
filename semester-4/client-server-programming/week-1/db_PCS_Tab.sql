drop table negara cascade constraints purge;
drop table liga cascade constraints purge;
drop table club cascade constraints purge;
drop table stadium cascade constraints purge;
drop table agen cascade constraints purge;
drop table manager cascade constraints purge;
drop table player cascade constraints purge;
drop table h_transaksi cascade constraints purge;
drop table d_transaksi cascade constraints purge;
drop table club_manager cascade constraints purge;

create table negara
(
	id_negara varchar2(3) primary key,
	nama_negara varchar2(15)
);

create table liga
(
	id_liga varchar2(5) primary key,
	nama_liga varchar2(30),
	id_negara references negara(id_negara),
	divisi number
);

create table agen
(
	id_agen varchar2(7) primary key,
	nama_agen varchar2(20),
	experience number,
	id_negara references negara(id_negara)
);

create table manager
(
	id_manager varchar2(6) primary key,
	nama_manager varchar2(20),
	dob_manager date,
	id_negara references negara(id_negara),
	id_agen references agen(id_agen)
);

create table club
(
	id_club varchar2(7) primary key,
	nama_club varchar2(20),
	tahun_berdiri date,
	id_liga references liga(id_liga)
);

create table stadium
(
	id_stadium varchar2(6) primary key,
	nama_stadium varchar2(20),
	kapasitas number,
	id_club references club(id_club),
	id_negara references negara(id_negara)
);


create table player
(
	id_player varchar2(6) primary key,
	nama_player varchar2(20),
	dob_player date,
	id_club references club(id_club),
	id_negara references negara(id_negara),
	id_agen references agen(id_agen)
);

create table h_transaksi
(
	id_transaksi varchar2(8) primary key,
	club_asal references club(id_club),
	club_baru references club(id_club),
	biaya_transfer number,
	tgl_transfer date
);

create table d_transaksi
(
	id_transaksi references h_transaksi(id_transaksi),
	id_player references player(id_player),
	subtotal number,
	constraint pk_dtrans primary key(id_transaksi,id_player)
);

create table club_manager
(
	id_club references club(id_club),
	id_manager references manager(id_manager),
	constraint pk_cm primary key(id_club,id_manager)
);



insert into negara values('ENG','ENGLAND');
insert into negara values('FRN','FRANCE');
insert into negara values('ESP','SPAIN');
insert into negara values('WLS','WALES');
insert into negara values('GER','GERMANY');
insert into negara values('ITA','ITALY');
insert into negara values('JPN','JAPAN');
insert into negara values('ROM','ROMANIA');
insert into negara values('RUS','RUSSIA');
insert into negara values('UKR','UKRAINE');
insert into negara values('BEL','BELGIUM');
insert into negara values('HOL','HOLLAND');
insert into negara values('USA','USA');
insert into negara values('SWE','SWEDEN');
insert into negara values('NOR','NORWAY');
insert into negara values('CRO','CROATIA');
insert into negara values('ICE','ICELAND');
insert into negara values('DEN','DENMARK');
insert into negara values('CZE','CZECH');
insert into negara values('IRE','IRELAND');
insert into negara values('FIN','FINLAND');
insert into negara values('BUL','BULGARIA');
insert into negara values('SER','SERBIA');
insert into negara values('KOR','SOUTH KOREA');
insert into negara values('ARG','ARGENTINA');
insert into negara values('BRA','BRAZIL');
insert into negara values('POR','PORTUGAL');
insert into negara values('SCO','SCOTLAND');

insert into liga values('EN001','Premier League','ENG',1);
insert into liga values('EN002','EFL Championship','ENG',2);
insert into liga values('EN003','English Football League','ENG',3);
insert into liga values('EN004','EFL League One','ENG',4);
insert into liga values('EN005','EFL League Two','ENG',5);
insert into liga values('EN006','National League (division)','ENG',6);
insert into liga values('FR001','Ligue 1','FRN',1);
insert into liga values('FR002','Ligue 2','FRN',2);
insert into liga values('FR003','Championnat National','FRN',3);
insert into liga values('FR004','Championnat National 2','FRN',4);
insert into liga values('FR005','Championnat National 3','FRN',5);
insert into liga values('SP001','La Liga','ESP',1);
insert into liga values('SP002','Segunda División','ESP',2);
insert into liga values('SP003','Segunda División B','ESP',3);
insert into liga values('SP004','Tercera División','ESP',4);
insert into liga values('SP005','Divisiones Regionales de Fútbol','ESP',5);
insert into liga values('IT001','Serie A','ITA',1);
insert into liga values('IT002','Serie B','ITA',2);
insert into liga values('IT003','Serie C','ITA',3);
insert into liga values('IT004','Serie D','ITA',4);
insert into liga values('IT005','Eccellenza','ITA',5);
insert into liga values('IT006','Promozione','ITA',6);
insert into liga values('HO001','Eredvisie','HOL',1);
insert into liga values('BA001','Campeonato Serie A','BRA',1);
insert into liga values('AR001','Superliga Argentina','ARG',1);
insert into liga values('US001','Major League Soccer','USA',1);
insert into liga values('JP001','Japan League','JPN',1);
insert into liga values('KO001','Korea League','KOR',1);
insert into liga values('BE001','Belgian First Division A','BEL',1);



insert into agen values('AGEN001','Lee Philpott',11,'ENG');
insert into agen values('AGEN002','Jonathan Dean',8,'ENG');
insert into agen values('AGEN003','Chris Greenhill',8,'ENG');
insert into agen values('AGEN004','Jonny Hughes',10,'ENG');
insert into agen values('AGEN005','Graham Duffield',2,'ENG');
insert into agen values('AGEN006','Magno Vieira',7,'ENG');
insert into agen values('AGEN007','David Bosumtwe',12,'ENG');
insert into agen values('AGEN008','Adam Bouskouchi',3,'ENG');
insert into agen values('AGEN009','David Currie',5,'ENG');
insert into agen values('AGEN010','Curtis Dawes',1,'ENG');
insert into agen values('AGEN011','Frederik De Jong',5,'ENG');
insert into agen values('AGEN012','Joseph Chenwi',2,'ENG');
insert into agen values('AGEN013','Peter Bint',4,'ENG');
insert into agen values('AGEN014','Lionel Foy',5,'ENG');
insert into agen values('AGEN015','Mark Gibbon',10,'ENG');
insert into agen values('AGEN016','Diomansy Kamara',5,'FRN');
insert into agen values('AGEN017','Olusola Omole',7,'FRN');
insert into agen values('AGEN018','Sabastine Onyeka',7,'USA');
insert into agen values('AGEN019','Emmanuel Mensah',8,'FRN');
insert into agen values('AGEN020','Osman Chari',7,'USA');
insert into agen values('AGEN021','Augusto Lopez',2,'USA');
insert into agen values('AGEN022','Antti Roiha',8,'FIN');
insert into agen values('AGEN023','Razaq Raji',1,'IRE');
insert into agen values('AGEN024','Eric Darko',10,'USA');
insert into agen values('AGEN025','Alexandre Marquot',6,'FRN');
insert into agen values('AGEN026','Matthijs Lambregts',10,'HOL');
insert into agen values('AGEN027','Bo Nilsson',6,'SWE');
insert into agen values('AGEN028','Constantin Negura',7,'ROM');
insert into agen values('AGEN029','Thiery Manigone',10,'IRE');
insert into agen values('AGEN030','Adolfo Lopes',3,'POR');


insert into manager values('MAN001','Greg Abbot',to_date('14-12-1963','DD-MM-YYYY'),'ENG','AGEN001');
insert into manager values('MAN002','Alex Ferguson',to_date('31-12-1941','DD-MM-YYYY'),'SCO','AGEN002');
insert into manager values('MAN003','Arsene Wenger',to_date('22-10-1949','DD-MM-YYYY'),'FRN','AGEN003');
insert into manager values('MAN004','Josep Guardiola',to_date('18-01-1971','DD-MM-YYYY'),'ESP','AGEN004');
insert into manager values('MAN005','Maurizio Sarri',to_date('10-01-1959','DD-MM-YYYY'),'ITA','AGEN005');
insert into manager values('MAN006','Jurgen Klopp',to_date('16-06-1967','DD-MM-YYYY'),'GER','AGEN015');
insert into manager values('MAN007','Mauricio Pochettino',to_date('02-03-1972','DD-MM-YYYY'),'ARG','AGEN016');
insert into manager values('MAN008','Ernesto Valverde',to_date('09-02-1964','DD-MM-YYYY'),'ESP','AGEN017');
insert into manager values('MAN009','Santiago Solari',to_date('08-10-1976','DD-MM-YYYY'),'ARG','AGEN018');
insert into manager values('MAN010','Diego Simeone',to_date('28-04-1970','DD-MM-YYYY'),'ARG','AGEN019');
insert into manager values('MAN011','Pablo Machin',to_date('07-04-1975','DD-MM-YYYY'),'ESP','AGEN020');
insert into manager values('MAN012','Marcelino Toral',to_date('14-08-1965','DD-MM-YYYY'),'ESP','AGEN021');
insert into manager values('MAN013','Massimiliano Allegri',to_date('11-08-1967','DD-MM-YYYY'),'ITA','');
insert into manager values('MAN014','Gennaro Gattuso',to_date('09-01-1978','DD-MM-YYYY'),'ITA','AGEN021');
insert into manager values('MAN015','Luciano Spalletti',to_date('03-07-1959','DD-MM-YYYY'),'ITA','AGEN022');
insert into manager values('MAN016','Carlo Ancelotti',to_date('10-06-1959','DD-MM-YYYY'),'ITA','AGEN023');
insert into manager values('MAN017','Eusebio Di Francesco',to_date('08-09-1969','DD-MM-YYYY'),'ITA','');
insert into manager values('MAN018','Thomas Tuchel',to_date('29-08-1973','DD-MM-YYYY'),'ITA','AGEN025');
insert into manager values('MAN019','Leonardo Jardim',to_date('01-08-1974','DD-MM-YYYY'),'POR','AGEN026');
insert into manager values('MAN020','Bruno Genesio',to_date('01-09-1966','DD-MM-YYYY'),'FRN','');
insert into manager values('MAN021','Christophe Galtier',to_date('23-08-1966','DD-MM-YYYY'),'FRN','');
insert into manager values('MAN022','Rudi Garcia',to_date('20-02-1964','DD-MM-YYYY'),'FRN','AGEN011');
insert into manager values('MAN023','Fernando Santos',to_date('10-10-1954','DD-MM-YYYY'),'POR','');
insert into manager values('MAN024','Carlos Parreira',to_date('27-02-1943','DD-MM-YYYY'),'BRA','AGEN013');
insert into manager values('MAN025','Abel Braga',to_date('09-01-1952','DD-MM-YYYY'),'BRA','AGEN014');
insert into manager values('MAN026','Renato Portaluppi',to_date('09-09-1962','DD-MM-YYYY'),'BRA','AGEN015');
insert into manager values('MAN027','Gustavo Alfaro',to_date('14-08-1962','DD-MM-YYYY'),'ARG','AGEN013');
insert into manager values('MAN028','Marcelo Gallardo',to_date('18-01-1976','DD-MM-YYYY'),'ARG','AGEN014');
insert into manager values('MAN029','Tsuneyasu Miyamoto',to_date('07-02-1997','DD-MM-YYYY'),'JPN','');
insert into manager values('MAN030','Jose Mourinho',to_date('26-01-1963','DD-MM-YYYY'),'POR','AGEN016');
insert into manager values('MAN031','Zinedine Zidane',to_date('23-06-1972','DD-MM-YYYY'),'FRN','AGEN017');
insert into manager values('MAN032','Paolo Maldini',to_date('26-06-1968','DD-MM-YYYY'),'ITA','AGEN018');
insert into manager values('MAN033','Harry Redknapp',to_date('02-03-1947','DD-MM-YYYY'),'ENG','');
insert into manager values('MAN034','Kenny Dalglish',to_date('04-03-1951','DD-MM-YYYY'),'SCO','AGEN020');


insert into club values('MU001','Manchester United',to_date('1878','YYYY'),'EN001');
insert into club values('AR001','Arsenal',to_date('1886','YYYY'),'EN001');
insert into club values('MC001','Manchester City',to_date('1880','YYYY'),'EN001');
insert into club values('CH001','Chelsea',to_date('1905','YYYY'),'EN001');
insert into club values('LI001','Liverpool',to_date('1892','YYYY'),'EN001');
insert into club values('TO001','Tottenham',to_date('1882','YYYY'),'EN001');
insert into club values('BA001','Barcelona',to_date('1899','YYYY'),'SP001');
insert into club values('RM001','Real Madrid',to_date('1902','YYYY'),'SP001');
insert into club values('AT001','Atletico Madrid',to_date('1903','YYYY'),'SP001');
insert into club values('SE001','Sevilla',to_date('1890','YYYY'),'SP001');
insert into club values('VA001','Valencia',to_date('1919','YYYY'),'SP001');
insert into club values('JU001','Juventus',to_date('1897','YYYY'),'IT001');
insert into club values('AM002','AC Milan',to_date('1899','YYYY'),'IT001');
insert into club values('IM001','Inter Milan',to_date('1908','YYYY'),'IT001');
insert into club values('NA001','Napoli',to_date('1926','YYYY'),'IT001');
insert into club values('AR002','AS Roma',to_date('1927','YYYY'),'IT001');
insert into club values('PS001','Paris Saint Germain',to_date('1970','YYYY'),'FR001');
insert into club values('AM001','AS Monaco',to_date('1919','YYYY'),'FR001');
insert into club values('LY001','Lyon',to_date('1950','YYYY'),'FR001');
insert into club values('LI001','Lille',to_date('1944','YYYY'),'FR001');
insert into club values('MA001','Marseille',to_date('1899','YYYY'),'FR001');
insert into club values('SA001','Santos',to_date('1912','YYYY'),'BA001');
insert into club values('SP001','Sao Paulo',to_date('1930','YYYY'),'BA001');
insert into club values('FL001','Flamengo',to_date('1895','YYYY'),'BA001');
insert into club values('IN001','Internacional',to_date('1909','YYYY'),'BA001');
insert into club values('GR001','Gremio',to_date('1903','YYYY'),'BA001');
insert into club values('BJ001','Boca Junior',to_date('1905','YYYY'),'AR001');
insert into club values('RP001','River Plate',to_date('1901','YYYY'),'AR001');
insert into club values('IN002','Independiate',to_date('1958','YYYY'),'AR001');
insert into club values('RC001','Racing Club',to_date('1903','YYYY'),'AR001');
insert into club values('GO001','Gamba Osaka',to_date('1980','YYYY'),'JP001');
insert into club values('FT001','FC Tokyo',to_date('1935','YYYY'),'JP001');
insert into club values('CO001','Cerezo Osaka',to_date('1957','YYYY'),'JP001');
insert into club values('VK001','Vissel Kobe',to_date('1966','YYYY'),'JP001');
insert into club values('UR001','Urawa Reds',to_date('1950','YYYY'),'JP001');
insert into club values('YF001','Yokohama FM',to_date('1972','YYYY'),'JP001');
insert into club values('GE001','Genk',to_date('1923','YYYY'),'BE001');
insert into club values('CB001','Club Brugge',to_date('1891','YYYY'),'BE001');
insert into club values('AN001','Anderlecht',to_date('1908','YYYY'),'BE001');
insert into club values('AV001','Aston Villa',to_date('1910','YYYY'),'EN002');
insert into club values('BC001','Birmingham City',to_date('1912','YYYY'),'EN002');
insert into club values('BR001','Blackburn Rovers',to_date('1914','YYYY'),'EN002');
insert into club values('BW001','Bolton Wanderers',to_date('1916','YYYY'),'EN002');
insert into club values('BR002','Brentford',to_date('1918','YYYY'),'EN002');
insert into club values('BC002','Bristol City',to_date('1919','YYYY'),'EN002');
insert into club values('AW001','AFC Wimbledon',to_date('1921','YYYY'),'EN003');
insert into club values('AS001','Accrington Stanley',to_date('1923','YYYY'),'EN003');
insert into club values('BA002','Barnsley',to_date('1925','YYYY'),'EN003');
insert into club values('BL001','Blackpool',to_date('1927','YYYY'),'EN003');
insert into club values('BC003','Bradford City',to_date('1929','YYYY'),'EN003');
insert into club values('BR003','Bristol Rovers',to_date('1922','YYYY'),'EN003');
insert into club values('EV001','Everton',to_date('1910','YYYY'),'EN001');

		
insert into stadium values('STD001','Gavea Stadium',78838,'FL001','ENG');
insert into stadium values('STD002','Bloomfield Rd',16220,'BL001','ENG');
insert into stadium values('STD003','Old Trafford',74643,'MU001','ENG');
insert into stadium values('STD004','City of Manchester',55097,'MC001','ENG');
insert into stadium values('STD005','Stamford Bridge',4163,'CH001','ENG');
insert into stadium values('STD006','Anfield',54074,'LI001','ENG');
insert into stadium values('STD007','White Hart Lane',36284,'TO001','ENG');
insert into stadium values('STD008','Camp Nou',99354,'BA001','ESP');
insert into stadium values('STD009','Santiago Barnabeu',81044,'RM001','ESP');
insert into stadium values('STD010','Wanda Metropolitano',68000,'AM001','ESP');
insert into stadium values('STD011','Pizjuan Stadium',43883,'SE001','ESP');
insert into stadium values('STD012','Mestalla Stadium',49500,'VA001','ESP');
insert into stadium values('STD013','Juventus Stadium',41507,'JU001','ITA');
insert into stadium values('STD014','San Siro',36500,'AM002','ITA');
insert into stadium values('STD015','Guiseppe Meazza',37000,'IM001','ITA');
insert into stadium values('STD016','Stadio San Paolo',60240,'NA001','ITA');
insert into stadium values('STD017','Stadio Olimpico',72900,'AR002','ITA');
insert into stadium values('STD018','Parc des Princes',47900,'PS001','FRN');
insert into stadium values('STD019','Kincho Stadium',18000,'CO001','JPN');
insert into stadium values('STD020','Noevir Stadium',30134,'VK001','JPN');
insert into stadium values('STD021','Saitama Stadium',63700,'UR001','JPN');
insert into stadium values('STD022','Nissan Stadium',72327,'YF001','JPN');
insert into stadium values('STD023','Luminus Arena',23718,'GE001','BEL');
insert into stadium values('STD024','Jan Breydel',29062,'CB001','BEL');
insert into stadium values('STD025','Vanden Stock',21500,'AN001','BEL');
insert into stadium values('STD026','Villa Park',42682,'AV001','ENG');
insert into stadium values('STD027','St Andrews',29409,'BC001','ENG');
insert into stadium values('STD028','Ewood Park',31367,'BR001','ENG');


insert into player values('DD001','David de Gea',to_date('07-11-1990','DD-MM-YYYY'),'MU001','ESP','AGEN020');
insert into player values('VL001','Victor Lindelof',to_date('17-07-1994','DD-MM-YYYY'),'MU001','SWE','AGEN021');
insert into player values('PJ001','Phil Jones',to_date('21-02-1992','DD-MM-YYYY'),'MU001','ENG','AGEN022');
insert into player values('CS001','Chris Smalling',to_date('22-11-1989','DD-MM-YYYY'),'MU001','ENG','AGEN023');
insert into player values('NM001','Nemanja Matic',to_date('01-08-1989','DD-MM-YYYY'),'MU001','SER','AGEN008');
insert into player values('PP001','Paul Pogba',to_date('15-03-1993','DD-MM-YYYY'),'MU001','FRN','AGEN009');
insert into player values('AH001','Ander Herrera',to_date('14-08-1989','DD-MM-YYYY'),'MU001','ESP','AGEN010');
insert into player values('JM001','Juan Mata',to_date('28-04-1988','DD-MM-YYYY'),'MU001','ESP','AGEN011');
insert into player values('RL001','Romelu Lukaku',to_date('13-05-1993','DD-MM-YYYY'),'MU001','BEL','AGEN012');
insert into player values('MR001','Marcus Rashford',to_date('31-10-1997','DD-MM-YYYY'),'MU001','ENG','AGEN001');
insert into player values('AM001','Anthony Martial',to_date('05-12-1995','DD-MM-YYYY'),'MU001','FRN','AGEN002');
insert into player values('PC001','Petr Cech',to_date('20-05-1982','DD-MM-YYYY'),'AR001','CZE','AGEN003');
insert into player values('SM001','Shkodran Mustafi',to_date('17-04-1992','DD-MM-YYYY'),'AR001','GER','AGEN004');
insert into player values('LK001','Laurent Koscielny',to_date('10-09-1985','DD-MM-YYYY'),'AR001','FRN','AGEN005');
insert into player values('NM002','Nacho Monreal',to_date('26-02-1986','DD-MM-YYYY'),'AR001','ESP','AGEN006');
insert into player values('HB001','Hector Bellerin',to_date('19-03-1995','DD-MM-YYYY'),'AR001','ESP','AGEN004');
insert into player values('CJ001','Carl Jenkinson',to_date('08-02-1992','DD-MM-YYYY'),'AR001','FIN','AGEN005');
insert into player values('AR001','Aaron Ramsey',to_date('26-12-1990','DD-MM-YYYY'),'AR001','WLS','AGEN006');
insert into player values('MO001','Mesut Ozil',to_date('15-10-1988','DD-MM-YYYY'),'AR001','GER','AGEN007');
insert into player values('DW001','Danny Welbeck',to_date('26-11-1990','DD-MM-YYYY'),'AR001','ENG','AGEN008');
insert into player values('JC001','Jasper Cillessen',to_date('22-04-1989','DD-MM-YYYY'),'BA001','HOL','AGEN009');
insert into player values('SU001','Samuel Umtiti',to_date('14-11-1993','DD-MM-YYYY'),'BA001','FRN','AGEN010');
insert into player values('GP001','Gerard Pique',to_date('02-02-1987','DD-MM-YYYY'),'BA001','ESP','AGEN011');
insert into player values('JA001','Jordi Alba',to_date('21-03-1989','DD-MM-YYYY'),'BA001','ESP','AGEN022');
insert into player values('NS001','Nelson Semedo',to_date('16-11-1993','DD-MM-YYYY'),'BA001','POR','AGEN023');
insert into player values('PC002','Philippe Countinho',to_date('12-06-1992','DD-MM-YYYY'),'BA001','BRA','AGEN024');
insert into player values('OD001','Ousmane Dembele',to_date('15-05-1997','DD-MM-YYYY'),'BA001','FRN','AGEN025');
insert into player values('LM001','Lionel Messi',to_date('24-06-1987','DD-MM-YYYY'),'BA001','ARG','AGEN026');
insert into player values('SB001','Sergio Busquets',to_date('16-07-1988','DD-MM-YYYY'),'BA001','ESP','AGEN027');
insert into player values('FL001','Filipe Luis',to_date('09-08-1985','DD-MM-YYYY'),'AT001','BRA','AGEN028');
insert into player values('JU001','Juanfran',to_date('09-01-1985','DD-MM-YYYY'),'AT001','ESP','AGEN029');
insert into player values('KO001','Koke',to_date('08-01-1992','DD-MM-YYYY'),'AT001','ESP','AGEN030');
insert into player values('VI001','Vitolo',to_date('02-11-1989','DD-MM-YYYY'),'AT001','ESP','AGEN015');
insert into player values('AG001','Antoine Griezmann',to_date('21-03-1991','DD-MM-YYYY'),'AT001','FRN','AGEN016');
insert into player values('DC001','Diego Costa',to_date('07-10-1988','DD-MM-YYYY'),'AT001','ESP','AGEN017');
insert into player values('PD001','Paulo Dybala',to_date('15-11-1993','DD-MM-YYYY'),'JU001','ARG','AGEN018');
insert into player values('CR001','Cristiano Ronaldo',to_date('05-02-1985','DD-MM-YYYY'),'JU001','POR','AGEN019');
insert into player values('MM001','Mario Mandzukic',to_date('21-05-1986','DD-MM-YYYY'),'JU001','CRO','AGEN027');
insert into player values('LM002','Luka Modric',to_date('09-09-1985','DD-MM-YYYY'),'RM001','CRO','AGEN028');
insert into player values('AD001','Angel Di Maria',to_date('14-02-1988','DD-MM-YYYY'),'PS001','ARG','AGEN020');
insert into player values('KM001','Kylian Mbappe',to_date('20-12-1998','DD-MM-YYYY'),'PS001','FRN','AGEN022');
insert into player values('NE001','Neymar',to_date('05-02-1992','DD-MM-YYYY'),'PS001','BRA','AGEN023');
insert into player values('HK001','Hiroshi Kiyotake',to_date('12-11-1989','DD-MM-YYYY'),'CO001','JPN','AGEN024');
insert into player values('YM001','Yusuke Maruhasi',to_date('02-09-1990','DD-MM-YYYY'),'CO001','JPN','AGEN025');
insert into player values('MI001','Mauri Icardi',to_date('19-02-1993','DD-MM-YYYY'),'IM001','ARG','AGEN026');
insert into player values('LI001','Lorenzo Insigne',to_date('04-06-1991','DD-MM-YYYY'),'NA001','ITA','AGEN027');
insert into player values('JP001','Javier Pastore',to_date('20-06-1989','DD-MM-YYYY'),'AR002','ARG','AGEN028');
insert into player values('DA001','Dani Alves',to_date('06-05-1983','DD-MM-YYYY'),'PS001','BRA','AGEN029');
insert into player values('IR001','Ivan Rakitic',to_date('10-03-1998','DD-MM-YYYY'),'BA001','CRO','AGEN030');

insert into h_transaksi values('TRANS001','EV001','MU001',50000000,to_date('10-07-2017','DD-MM-YYYY'));
insert into h_transaksi values('TRANS002','JU001','MU001',70000000,to_date('09-08-2016','DD-MM-YYYY'));
insert into h_transaksi values('TRANS003','AM001','MU001',20000000,to_date('09-08-2017','DD-MM-YYYY'));
insert into h_transaksi values('TRANS004','NA001','PS001',55000000,to_date('09-08-2012','DD-MM-YYYY'));
insert into h_transaksi values('TRANS005','RM001','AR001',40000000,to_date('09-08-2016','DD-MM-YYYY'));
insert into h_transaksi values('TRANS006','MU001','BA001',5500000,to_date('01-07-2008','DD-MM-YYYY'));
insert into h_transaksi values('TRANS007','AM001','MU001',8000000,to_date('01-09-2015','DD-MM-YYYY'));
insert into h_transaksi values('TRANS008','CH001','AT001',50000000,to_date('01-01-2018','DD-MM-YYYY'));
insert into h_transaksi values('TRANS009','CH001','AT001',15000000,to_date('28-07-2015','DD-MM-YYYY'));
insert into h_transaksi values('TRANS010','LI001','BA001',90000000,to_date('06-01-2018','DD-MM-YYYY'));
insert into h_transaksi values('TRANS011','LY001','BA001',15000000,to_date('12-06-2016','DD-MM-YYYY'));
insert into h_transaksi values('TRANS012','TO001','RM001',40000000,to_date('27-08-2012','DD-MM-YYYY'));
insert into h_transaksi values('TRANS013','SE001','BA001',20000000,to_date('01-07-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS014','CH001','EV001',25000000,to_date('31-05-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS015','EV001','CH001',24000000,to_date('02-09-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS016','IM001','LI001',9000000,to_date('06-01-2013','DD-MM-YYYY'));
insert into h_transaksi values('TRANS017','AT001','MU001',12000000,to_date('01-07-2011','DD-MM-YYYY'));
insert into h_transaksi values('TRANS018','SA001','BA001',50000000,to_date('01-07-2013','DD-MM-YYYY'));
insert into h_transaksi values('TRANS019','AT001','CH001',35000000,to_date('07-01-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS020','MU001','RM001',60000000,to_date('01-07-2009','DD-MM-YYYY'));
insert into h_transaksi values('TRANS021','RM001','JU001',100000000,to_date('10-07-2018','DD-MM-YYYY'));
insert into h_transaksi values('TRANS022','CH001','AR001',12000000,to_date('01-07-2015','DD-MM-YYYY'));
insert into h_transaksi values('TRANS023','MU001','AR001',17000000,to_date('01-09-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS024','VA001','CH001',26000000,to_date('24-08-2011','DD-MM-YYYY'));
insert into h_transaksi values('TRANS025','CH001','MU001',38000000,to_date('24-08-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS026','RM001','VA001',1100000,to_date('01-07-2007','DD-MM-YYYY'));
insert into h_transaksi values('TRANS027','VA001','BA001',10000000,to_date('01-07-2012','DD-MM-YYYY'));
insert into h_transaksi values('TRANS028','AT001','JU001',20000000,to_date('01-07-2015','DD-MM-YYYY'));
insert into h_transaksi values('TRANS029','BA001','AR001',500000,to_date('01-07-2011','DD-MM-YYYY'));
insert into h_transaksi values('TRANS030','RM001','MU001',50000000,to_date('25-08-2014','DD-MM-YYYY'));
insert into h_transaksi values('TRANS031','MU001','PS001',50000000,to_date('06-08-2015','DD-MM-YYYY'));
insert into h_transaksi values('TRANS032','PS001','AR002',15000000,to_date('01-07-2018','DD-MM-YYYY'));
insert into h_transaksi values('TRANS033','MU001','JU001',3500000,to_date('03-08-2012','DD-MM-YYYY'));
insert into h_transaksi values('TRANS034','BA001','JU001',9000000,to_date('01-07-207','DD-MM-YYYY'));
insert into h_transaksi values('TRANS035','BA001','PS001',106000000,to_date('01-08-2014','DD-MM-YYYY'));

insert into d_transaksi values('TRANS001','RL001',50000000);
insert into d_transaksi values('TRANS002','PP001',70000000);
insert into d_transaksi values('TRANS003','AH001',20000000);
insert into d_transaksi values('TRANS004','EC001',55000000);
insert into d_transaksi values('TRANS005','MO001',40000000);
insert into d_transaksi values('TRANS006','GP001',5500000);
insert into d_transaksi values('TRANS007','AM001',8000000);
insert into d_transaksi values('TRANS008','DC001',50000000);
insert into d_transaksi values('TRANS009','FL001',15000000);
insert into d_transaksi values('TRANS010','PC002',90000000);
insert into d_transaksi values('TRANS011','SU001',15000000);
insert into d_transaksi values('TRANS012','LM001',40000000);
insert into d_transaksi values('TRANS013','IR001',20000000);
insert into d_transaksi values('TRANS014','RL001',25000000);
insert into d_transaksi values('TRANS015','RL001',24000000);
insert into d_transaksi values('TRANS016','PC002',9000000);
insert into d_transaksi values('TRANS017','DD001',12000000);
insert into d_transaksi values('TRANS018','NE001',50000000);
insert into d_transaksi values('TRANS019','DC001',35000000);
insert into d_transaksi values('TRANS020','CR001',60000000);
insert into d_transaksi values('TRANS021','CR001',100000000);
insert into d_transaksi values('TRANS022','PC001',12000000);
insert into d_transaksi values('TRANS023','DW001',17000000);
insert into d_transaksi values('TRANS024','JM001',26000000);
insert into d_transaksi values('TRANS025','JM001',38000000);
insert into d_transaksi values('TRANS026','JM001',1100000);
insert into d_transaksi values('TRANS027','JA001',10000000);
insert into d_transaksi values('TRANS028','MM001',20000000);
insert into d_transaksi values('TRANS029','HB001',500000);
insert into d_transaksi values('TRANS030','AD001',50000000);
insert into d_transaksi values('TRANS031','AD001',50000000);
insert into d_transaksi values('TRANS032','JP001',15000000);
insert into d_transaksi values('TRANS033','PP001',3500000);
insert into d_transaksi values('TRANS034','DA001',6000000);
insert into d_transaksi values('TRANS035','NE001',100000000);
insert into d_transaksi values('TRANS035','DA001',6000000);

insert into club_manager values('MU001','MAN002');
insert into club_manager values('AR001','MAN003');
insert into club_manager values('MC001','MAN004');
insert into club_manager values('CH001','MAN005');
insert into club_manager values('LI001','MAN006');
insert into club_manager values('TO001','MAN007');
insert into club_manager values('BA001','MAN008');
insert into club_manager values('RM001','MAN009');
insert into club_manager values('AT001','MAN010');
insert into club_manager values('SE001','MAN011');
insert into club_manager values('VA001','MAN012');
insert into club_manager values('JU001','MAN013');
insert into club_manager values('AM002','MAN014');
insert into club_manager values('IM001','MAN015');
insert into club_manager values('NA001','MAN016');
insert into club_manager values('AR002','MAN017');
insert into club_manager values('PS001','MAN018');
insert into club_manager values('AM001','MAN019');
insert into club_manager values('LY001','MAN020');
insert into club_manager values('LI001','MAN021');
insert into club_manager values('MA001','MAN022');
insert into club_manager values('SA001','MAN023');
insert into club_manager values('SP001','MAN024');
insert into club_manager values('FL001','MAN025');


insert into h_transaksi values('TRANS036','MU001','CH001',10,to_date('01-09-2018','DD-MM-YYYY'));
insert into h_transaksi values('TRANS037','CH001','MU001',10,to_date('01-09-2017','DD-MM-YYYY'));
insert into h_transaksi values('TRANS038','MU001','CH001',10,to_date('01-09-2016','DD-MM-YYYY'));
insert into h_transaksi values('TRANS039','MC001','RM001',10,to_date('01-09-2012','DD-MM-YYYY'));
insert into h_transaksi values('TRANS040','RM001','MC001',10,to_date('01-09-2013','DD-MM-YYYY'));
insert into h_transaksi values('TRANS041','MC001','RM001',10,to_date('01-09-2014','DD-MM-YYYY'));
