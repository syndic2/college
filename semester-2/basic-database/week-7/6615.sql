--MATERI
--NO 1
(select d.duelist_id as "DUELIST", d.nama as "NAMA"
from duelist d, d_barter db
where d.duelist_id= db.duelist_id_take)
intersect
(select d.duelist_id as "DUELIST", d.nama as "NAMA"
from duelist d, match m
where d.duelist_id= m.id_away or d.duelist_id= m.id_home);

--MATERI
--NO 2
select d.nama as "NAMA", sum(ra.rarity_value) as "Total Value"
from duelist d, d_barter db, card c, rarity ra
where d.duelist_id= db.duelist_id_take and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
having sum(ra.rarity_value)>5000
group by d.nama;

--MATERI
--NO 3
(select c.card_name as "Nama Kartu", c.atk as "ATK", c.def as "DEF"
from card c 
where c.rarity_id= 'Ultra Rare')
intersect
(select c.card_name as "Nama Kartu", c.atk as "ATK", c.def as "DEF"
from card c 
where c.card_id in 
	(select db.card_id
	 from d_barter db));

--MATERI
--NO 4
(select d.nama as "NAMA", (to_char(sysdate,'yyyy')-to_char(d.tanggal_lahir,'yyyy')) as "Usia"
from duelist d
where d.duelist_id not in
	(select m.id_home
	 from match m
	 where to_char(m.tgl_match,'mm')>=9 and to_char(m.tgl_match,'mm')<=11) 
	 and 
	 d.duelist_id not in
	(select m.id_away
	 from match m
	 where to_char(m.tgl_match,'mm')>=9 and to_char(m.tgl_match,'mm')<=11))
intersect 
(select d.nama as "NAMA", (to_char(sysdate,'yyyy')-to_char(d.tanggal_lahir,'yyyy')) as "Usia"
from duelist d, h_barter hb, d_barter db 
where d.duelist_id= db.duelist_id_give and db.kd_barter= hb.kd_barter and 
to_char(hb.tgl_barter,'mm')>=1 and to_char(hb.tgl_barter,'mm')<=3);

--TUGAS
--NO 2
create or replace view INSIDE_VALUE as
select d.nama as "NAMA", sum(ra.rarity_value) as "TOTAL VALUE"
from duelist d, d_barter db, card c, rarity ra
where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
having sum(ra.rarity_value)>
 	(select min(sum(ra.rarity_value))
	 from duelist d, d_barter db, card c, rarity ra
	 where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
	 group by d.nama) and
	 sum(ra.rarity_value)<
	 (select max(sum(ra.rarity_value)) 
	 from duelist d, d_barter db, card c, rarity ra
	 where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
	 group by ra.rarity_value) 
group by d.nama
order by length(d.nama);

select * 
from INSIDE_VALUE;

--TUGAS
--NO 3
(select d.nama as "NAMA", sum(ra.rarity_value) as "TOTAL VALUE"
from duelist d, d_barter db, card c, rarity ra
where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
having sum(ra.rarity_value)=
	(select min(sum(ra.rarity_value))
	 from duelist d, d_barter db, card c, rarity ra
	 where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
	 group by d.nama) or
	 sum(ra.rarity_value)=
	 (select max(sum(ra.rarity_value))
	 from duelist d, d_barter db, card c, rarity ra
	 where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
	 group by d.nama)
group by d.nama)
union all
(select *
from INSIDE_VALUE);

--TUGAS
--NO 4
create or replace view UMUR_VALUE as
select d.nama as "NAMA", (to_char(sysdate,'yyyy')-to_char(d.tanggal_lahir,'yyyy')) as "USIA", length(d.nama) as "CHAR"
from duelist d, d_barter db, card c, rarity ra
where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
having sum(ra.rarity_value)>
 	(select min(sum(ra.rarity_value))
	 from duelist d, d_barter db, card c, rarity ra
	 where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
	 group by d.nama) and
	 sum(ra.rarity_value)<
	 (select max(sum(ra.rarity_value)) 
	 from duelist d, d_barter db, card c, rarity ra
	 where d.duelist_id= db.duelist_id_give and db.card_id= c.card_id and c.rarity_id= ra.rarity_id
	 group by ra.rarity_value)
group by d.nama, d.tanggal_lahir
order by (case 
when (mod(to_number(to_char(sysdate,'yyyy')-to_char(d.tanggal_lahir,'yyyy')),2)= 1) and (mod(length(d.nama),2)= 1)
then 1
else 2
end), 2 desc, 3 desc;

select * 
from UMUR_VALUE;