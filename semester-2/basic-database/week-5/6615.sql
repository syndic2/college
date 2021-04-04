--MATERI
--NO 1
select d.nama as "Duelist", count(db.duelist_id_give) || ' kali' as "Jumlah Barter"
from duelist d
left join d_barter db
on d.duelist_id= db.duelist_id_give
group by d.nama
order by 2 desc,1;

--MATERI
--NO 2
select d.nama as "Nama Duelist",  'Mememangkan match sebanyak 0' || count(m.kd_match) as "Jumlah Menang"
from duelist d
left join match m
on (m.id_home= d.duelist_id and m.status= 1) or (m.id_away= d.duelist_id and m.status= 0)
group by d.nama
order by 2 desc, 1;

--MATERI 
--NO 3
select m.kd_match as "ID MATCH", dhome.nama as "NAMA", daway.nama as "NAMA",
(case
when m.status= 1 then dhome.nama
when m.status= 0 then daway.nama 
end) as "Pemenang" 
from match m 
left join duelist dhome on m.id_home= dhome.duelist_id
left join duelist daway on m.id_away= daway.duelist_id 
order by 1;

--MATERI
--NO 4
select 
'Tanpa Level = 0' || sum((case
when c.card_sub_type= 'Normal'
then count(c.card_sub_type)
end)) || chr(10) || 
'Level 1-3 = 0' || sum((case
when c.card_level>=1 and c.card_level<=3
then count(c.card_level)
end)) || chr(10) || 
'Level 4-6 = 0' || sum((case
when c.card_level>=4 and c.card_level<=6
then count(c.card_level)
end)) || chr(10) || 
'Level 7-10 = 0' || sum((case
when c.card_level>=7 and c.card_level<=10
then count(c.card_level)
end)) as "Level dan banyak kartu"
from card c
group by c.card_sub_type, c.card_level
order by 1 asc;

--TUGAS
--NO 2
select 'Duelist laki laki berjumlah ' || 
sum((case when d.gender= 'M' then count(d.gender)
end)) || ' sedangkan duelist wanita berjumlah ' ||
sum((case when d.gender= 'F' then count(d.gender)
end)) as "Jumlah Gender"
from duelist d
group by d.gender
order by 1;

--TUGAS
--NO 5 
select
(case when  c.card_type= 'Spell' or c.card_type= 'Trap' then 'Kartu bertype ' || rpad(c.card_type,5,' ') ||  lpad(' Card',9,' ') 
else 'Kartu bertype ' || c.card_type end) ||
(case when m1.status= 1 then ' dimenangi home sebanyak ' || count(m1.id_home) || ' dengan value '
when m2.status= 0 then ' dimenangi away sebanyak ' || count(m2.id_away) || ' dengan value ' 
else ' belum di match sebanyak ' || count(c.card_id) end) ||
(case when sum(r1.rarity_value)<1000 and m1.status= 1 then lpad(substr(sum(r1.rarity_value),1,length(sum(r1.rarity_value))-3) ||  
substr(sum(r1.rarity_value),length(sum(r1.rarity_value))-2,length(sum(r1.rarity_value)-(length(sum(r1.rarity_value))-3))),7,' ')
when sum(r1.rarity_value)>=1000 and m1.status= 1 then lpad(substr(sum(r1.rarity_value),1,length(sum(r1.rarity_value))-3) || ',' ||
substr(sum(r1.rarity_value),length(sum(r1.rarity_value))-2,length(sum(r1.rarity_value)-(length(sum(r1.rarity_value))-3))),7,' ')
when sum(r2.rarity_value)>=1000 and m2.status= 0 then lpad(substr(sum(r2.rarity_value),1,length(sum(r2.rarity_value))-3) || ',' ||
substr(sum(r2.rarity_value),length(sum(r2.rarity_value))-2,length(sum(r2.rarity_value)-(length(sum(r2.rarity_value))-3))),7,' ') 
end) as " Card In Match"
from card c
left join match m1 on m1.card_id= c.card_id 
left join match m2 on m2.card_id= c.card_id 
left join rarity r1 on r1.rarity_id= c.rarity_id
left join rarity r2 on r2.rarity_id= c.rarity_id 
group by c.card_type, m2.status, m1.status
order by c.card_type, count(m2.id_away), count(m1.id_home), count(c.card_id);