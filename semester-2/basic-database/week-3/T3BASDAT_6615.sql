--MATERI
--NO 1
select d.duelist_id as "ID", d.nama as "NAMA"
from duelist d 
where d.nama like '%en%' and (to_char(d.tanggal_lahir,'yyyy')>=1998 and to_char(d.tanggal_lahir,'yyyy')<=2000)
order by d.nama asc;

--MATERI
--NO 2
select c.card_id  as "Id",c.card_name as "Nama Kartu", c.card_level as "Level"
from card c
where c.card_attribute= 'Dark' and c.card_sub_type= 'Dragon'
order by c.card_name asc;

--MATERI
--NO 3
select distinct m.kd_match as "ID", dhome.nama as "Nama 1", daway.nama as "Nama 2"
from match m, duelist dhome, duelist daway, locations l
where (m.id_home= dhome.duelist_id and m.id_away= daway.duelist_id) and (l.location_id= m.location_id and l.city= 'Los Angeles') 
order by m.kd_match asc;

--MATERI
--NO 4 
select m.kd_match as "Id", d.nama as "Nama Duelist"  
from match m, duelist d, locations l, country c
where (m.location_id= l.location_id and m.id_home= d.duelist_id and m.status>0) 
and (l.country_id= c.country_id and c.country_name= 'Canada') 
order by d.nama,m.kd_match;

--MATERI
--NO 5
select pemberi.nama as "Pemberi", penerima.nama as "Penerima", c.card_name as "Nama Kartu" 
from duelist penerima, duelist pemberi, d_barter db, h_barter hb, card c
where (db.duelist_id_give= pemberi.duelist_id and db.duelist_id_take= penerima.duelist_id) 
and (db.kd_barter= hb.kd_barter and to_char(hb.tgl_barter,'yyyy')>=2000) 
and (db.card_id= c.card_id and c.rarity_id= 'Secret Rare');

--MATERI
--NO 6
select distinct c.card_name as "Nama Monster", c.atk as "ATK", c.def as "DEF", r.rarity_value as "Value" 
from card c, rarity r
where c.rarity_id= r.rarity_id and (c.atk>=1000 and c.atk<=2000) and (c.def>=1000) and (c.card_level=4) 
and (r.rarity_id= 'Rare' or r.rarity_id= 'Super Rare')
order by r.rarity_value asc;

--TUGAS
--NO 2
select distinct d.nama as "NAMA", m.tgl_match as "Tanggal", c.card_id as "ID"
from duelist d, match m, card c
where (m.id_home= d.duelist_id and m.status>0) and (to_char(m.tgl_match,'yyyy')>=2006 and to_char(m.tgl_match,'yyyy')<=2008) 
and (m.card_id= c.card_id and d.gender= 'F')
order by d.nama asc; 

--TUGAS 
--NO 3
select distinct hb.tgl_barter as "TANGGAL", c.card_name as "NAMA KARTU", pengirim.nama as "PENGIRIM", penerima.nama as "PENERIMA"
from duelist penerima, duelist pengirim, h_barter hb, d_barter db, card c
where (hb.kd_barter= db.kd_barter and to_char(hb.tgl_barter,'mm')= 05) 
and (db.duelist_id_give= pengirim.duelist_id and db.duelist_id_take= penerima.duelist_id) and db.card_id= c.card_id
order by hb.tgl_barter, c.card_name;

--TUGAS
--NO 4
select distinct d.nama as "NAMA", c.card_name as "Kartu", co.country_name as "Negara"
from duelist d, match m, card c, locations l, country co
where to_char(d.tanggal_lahir,'mm')= 09 and (m.id_home= d.duelist_id and m.card_id= c.card_id) 
and (m.location_id= l.location_id and l.country_id= co.country_id) and m.status= 1
order by d.nama, co.country_name;

--TUGAS 
--NO 5
select pemberi.nama as  "NAMA",  (to_char(hb.tgl_barter,'yyyy')-to_char(pemberi.tanggal_lahir,'yyyy')) as "UMUR", c.card_name as "KARTU"
from duelist pemberi, h_barter hb, d_barter db, card c, rarity r
where (db.duelist_id_give= pemberi.duelist_id and db.card_id= c.card_id) and (hb.kd_barter= db.kd_barter and c.rarity_id= r.rarity_id)
and (r.rarity_value>10000 and (to_char(hb.tgl_barter,'yyyy')-to_char(pemberi.tanggal_lahir,'yyyy')<20));