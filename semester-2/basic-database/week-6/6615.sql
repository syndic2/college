--MATERI 
--NO 1
select l.city as "Kota"
from locations l
where l.location_id not in 
	(select m.location_id
	 from match m)
order by 1;

--MATERI
--NO 2
select c.card_name as "Nama Kartu"
from card c
where c.atk>=((select avg(c.atk)
			  from card c)-500) and
	  c.atk<=((select avg(c.atk)
			  from card c)+500)
group by c.card_name
order by 1;

--MATERI
--NO 3
select d.nama as "NAMA",
(case 
when (to_char(sysdate,'yyyy')-to_char(d.tanggal_lahir,'yyyy'))=
	 (select min(to_char(sysdate,'yyyy')-to_char(d.tanggal_lahir,'yyyy'))
	  from duelist d) 
then 'Duelist paling muda'
end) as "Keterangan"
from duelist d
where d.duelist_id in 
	(select m.id_away
	 from match m)
order by 1;

--TUGAS 
--NO 2 
select distinct rpad(upper(re.region_name),(select max(length(re.region_name)) from region re),' ') || 
(case
when re.region_name in 
	(select re.region_name 
	 from region re, country co, locations lo, match m
	 where m.status= 1 and re.region_id= co.region_id and co.country_id= lo.country_id and
     lo.location_id= m.location_id)
then ' HOME MENDAPATKAN KEUNTUNGAN ' || sum(ra.rarity_value)
when re.region_name not in 
	(select re.region_name 
	 from region re, country co, locations lo, match m
	 where re.region_id= co.region_id and co.country_id= lo.country_id and
	 lo.location_id= m.location_id)
then ' BELUM PERNAH MELAKUKAN MATCH' 
end) as "Keterangan"
from region re, country co, locations lo, match m, card c, rarity ra
where re.region_id= co.region_id and co.country_id= lo.country_id and
lo.location_id= m.location_id and m.status= 1 and m.card_id= c.card_id and c.rarity_id= ra.rarity_id  and 
re.region_name in 
	(select re.region_name 
	 from region re, country co, locations lo, match m
	 where m.status= 1 and re.region_id= co.region_id and co.country_id= lo.country_id and
     lo.location_id= m.location_id) or
re.region_name not in 
	(select re.region_name 
	 from region re, country co, locations lo, match m
	 where re.region_id= co.region_id and co.country_id= lo.country_id and
	 lo.location_id= m.location_id)
group by re.region_name
order by 1 desc;

--TUGAS
--NO 3
select 
(case 
when c.card_type= 'Spell' or c.card_type= 'Trap'
then rpad(c.card_type,(select min(length(c.card_type))+5 from card c),' ') || ' Card ' || sum(r.rarity_value)
else rpad(c.card_type,(select max(length(c.card_type))+1 from card c),' ') || sum(r.rarity_value)
end) as "Keterangan"
from card c, rarity r
where c.card_id not in 
	(select db.card_id
	 from d_barter db) and
	 c.card_id in
	 (select m.card_id
	 from match m) and 
	 c.rarity_id= r.rarity_id 
group by c.card_type 
order by c.card_type desc;

--TUGAS
--NO 5
select lpad(c.card_name,(select max(length(c.card_name))-6 from card c),' ') || 
(case
when c.atk= 
	(select max(c.atk) 
	 from card c
	 where c.card_id not in (select m.card_id from match m) or c.card_id in (select m.card_id from match m where m.status= 0)) 
then ' MAX ATK=>' || c.atk
when c.atk= 
	(select min(c.atk) 
	 from card c
	 where c.card_id not in (select m.card_id from match m) or c.card_id in (select m.card_id from match m where m.status= 0))
then ' MIN ATK=>' || c.atk
end) ||
(case
when c.def= 
	(select max(c.def) 
	 from card c
	 where c.card_id not in (select m.card_id from match m) or c.card_id in (select m.card_id from match m where m.status= 0)) 
then ' MAX DEF=>' || c.def
when c.def= 
	(select min(c.def) 
	 from card c
	 where c.card_id not in (select m.card_id from match m) or c.card_id in (select m.card_id from match m where m.status= 0))
then ' MIN DEF=>' || c.def
end) || 
(case
when c.card_level= 
	(select max(c.card_level) 
	 from card c
	 where c.card_id not in (select m.card_id from match m) or c.card_id in (select m.card_id from match m where m.status= 0)) 
then ' MAX LEVEL=>' || c.card_level
when c.card_level= 
	(select min(c.card_level) 
	 from card c
	 where c.card_id not in (select m.card_id from match m) or c.card_id in (select m.card_id from match m where m.status= 0))
then ' MIN LEVEL=>' || c.card_level
end) as "PENGHARGAAN"
from card c
where c.card_id not in 
	(select m.card_id 
	 from match m) or 
	 c.card_id in 
	 (select m.card_id 
	 from match m
	 where m.status= 0)
group by c.card_name, c.atk, c.def, c.card_level
order by length(c.card_name) desc, c.card_name desc;