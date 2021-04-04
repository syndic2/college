--TUGAS
--1
select 'Di ' || rpad(substr(re.region_name,1,length(re.region_name)-1) || upper(substr(re.region_name,length(re.region_name),1)),8,' ')
|| ' Telah Terjadi ' || count(m.location_id) || ' Match' as "Region Match"
from match m, locations lo, country co, region re
where (m.location_id= lo.location_id) and (lo.country_id= co.country_id) and (co.region_id= re.region_id)
group by re.region_name
order by count(m.location_id) desc;

--2
select rpad(upper(substr(d.nama,instr(d.nama,' ')+1)),9,' ') || ' TELAH MEMBERIKAN DAN MENERIMA KARTU SEBANYAK ' || 
count(kd_barter) || ' KARTU' as "BARTER"
from duelist d, d_barter db
where (db.duelist_id_give= d.duelist_id) or (db.duelist_id_take= d.duelist_id)
group by d.nama
order by count(kd_barter) desc,d.nama asc;

--3
select rpad(upper(substr(d.nama,1,instr(d.nama,' '))),8,' ') || ' MENDAPATKAN ' || count(db.duelist_id_take) || 
' KARTU ' || rpad(upper(r.rarity_id),11,' ') || ' DENGAN TOTAL VALUE ' || 
lpad(substr(sum(r.rarity_value),1,length(sum(r.rarity_value))-3) || ',' || 
substr(sum(r.rarity_value),length(sum(r.rarity_value))-2,length(sum(r.rarity_value)-(length(sum(r.rarity_value))-3)))
,7,' ') as "DUELIST GET CARD VALUE"
from duelist d, d_barter db, card c, rarity r
where (db.duelist_id_take= d.duelist_id) and (db.card_id= c.card_id) and (c.rarity_id= r.rarity_id)
group by d.nama,r.rarity_id
order by r.rarity_id,sum(r.rarity_value) desc,d.nama;

--4
select rpad(substr(d.nama,1,instr(d.nama,' ')-2) || upper(substr(d.nama,instr(d.nama,' ')-1,1)) || ' ' ||
substr(d.nama,instr(d.nama,' ')+1,length(d.nama)-instr(d.nama,' ')-1) || upper(substr(d.nama,length(d.nama),1)),15,' ') || 
' Telah Memenangkan Kartu Bertype ' || c.card_attribute || ' Sebanyak ' || count(m.card_id) || ' Kali' as "LOOT DUELIST"
from duelist d, match m, card c 
where (m.id_home= d.duelist_id  and m.status= 1 and m.card_id= c.card_id) or (m.id_away= d.duelist_id and m.status= 0 and m.card_id= c.card_id) 
group by c.card_attribute,d.nama
order by count(m.card_id) desc,d.nama,c.card_attribute; 

--5
select rpad(d.nama,16,' ') || ' Mengalami Profit/Loss Sebesar ' || rpad((sum(rtake.rarity_value)-sum(rgive.rarity_value)) || ',' 
,10,'0') as "CARD VALUE PROFIT/LOSS"
from duelist d, d_barter dbgive, d_barter dbtake, card cgive, card ctake, rarity rgive, rarity rtake
where (dbgive.duelist_id_give= d.duelist_id and dbgive.card_id= cgive.card_id and cgive.rarity_id= rgive.rarity_id) 
and (dbtake.duelist_id_take= d.duelist_id and dbtake.card_id= ctake.card_id and ctake.rarity_id= rtake.rarity_id) 
group by d.nama
order by (sum(rgive.rarity_value)-sum(rtake.rarity_value)),d.nama;