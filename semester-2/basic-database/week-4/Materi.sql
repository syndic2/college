--1
select c.card_level as "Monster Bintang", sum(c.atk) as "Jumlah Attack", sum(c.def) as "Jumlah Defense" 
from card c
group by c.card_level
order by c.card_level desc;

--2
select d.duelist_id as "Id", d.nama as "Nama Duelist", to_char(d.tanggal_lahir,'dd-mm-yyyy')"Tanggal Lahir"
from duelist d
where mod(to_char(d.tanggal_lahir,'yyyy'),4)= 0
group by d.duelist_id, d.nama, d.tanggal_lahir
order by to_char(d.tanggal_lahir,'yyyy'),to_char(d.tanggal_lahir,'mm'),to_char(d.tanggal_lahir,'dd');

--3
select r.rarity_id as "Id", count(c.rarity_id) as "Banyak Kartu", r.rarity_value as "Jumlah Value"
from card c, rarity r
where c.rarity_id= r.rarity_id
group by r.rarity_id, r.rarity_value
order by r.rarity_id desc;

--4
select dhome.nama || ' telah memenangkan match  sebanyak 0' || count(dhome.duelist_id) || ' kali' as  "Data Duel"
from duelist dhome, match m
where dhome.duelist_id= m.id_home and m.status= 1
group by dhome.nama, dhome.duelist_id
order by count(dhome.duelist_id) desc;

--5
select substr(p1.nama,1,instr(p1.nama,' ',1,1)) || 'melakukan duel dengan ' || substr(p2.nama,1,instr(p2.nama,' ',1,1))|| 'di benua ' || re.region_name as "Keterangan"  
from duelist p1, duelist p2, match m, locations lo, country co, region re
where (m.id_home= p1.duelist_id and m.id_away= p2.duelist_id) and (m.location_id= lo.location_id) 
and (lo.country_id= co.country_id) and (re.region_id= co.region_id);

--6
select concat('KOMBINASI ATTACK DAN DEFENSE TERTINGGI CARD ADALAH ',max(sum(c.atk))+max(sum(c.def))) as "MAX COMBINATION" 
from card c
group by c.atk, c.def;

--7
select concat('RECORD MATCH TERBANYAK ',max(count(m.id_home)+count(m.id_away))) as "MATCH TERBANYAK / DUELIST" 
from match m
group by m.id_home, m.id_away;


