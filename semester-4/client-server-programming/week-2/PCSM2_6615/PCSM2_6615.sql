--DROP VIEW & SYNONYM (MATERI)
DROP VIEW vC_trans;
DROP VIEW vEng_liga;
DROP VIEW vStadium_mng;
DROP VIEW vAgen_mng;

DROP SYNONYM cTrans;
DROP SYNONYM engLiga;
DROP SYNONYM stadiumMng;
DROP SYNONYM agenMng;

--DROP VIEW & SYNONYM (TUGAS)
DROP VIEW vClub_ng;
DROP VIEW vNegara_mng;

DROP SYNONYM clubNg;
DROP SYNONYM negaraMng;

--MATERI
--No. 1
SELECT m.nama_manager AS "NAMA_MANAGER"
FROM manager m, club_manager cm, cTrans
WHERE cm.id_manager= m.id_manager AND cm.id_club= cTrans.id AND cTrans.count >= 1
ORDER BY SUBSTR(m.nama_manager, 3) DESC;

CREATE OR REPLACE VIEW vC_trans AS
SELECT ht.club_asal AS id, COUNT(p.id_player) AS count
FROM h_transaksi ht, d_transaksi dt, player p
WHERE ht.id_transaksi= dt.id_transaksi AND dt.id_player= p.id_player AND
      TO_CHAR(ht.tgl_transfer, 'YYYY') >= 2015
GROUP BY ht.club_asal;

CREATE OR REPLACE SYNONYM cTrans FOR vC_trans;

--No. 2
SELECT *
FROM engLiga;

CREATE OR REPLACE VIEW vEng_liga AS
SELECT l.nama_liga AS "NAMA_LIGA", COUNT(c.id_club) AS "JUMLAH CLUB"
FROM liga l, club c
WHERE l.id_liga= c.id_liga AND l.id_negara= 'ENG'
GROUP BY l.nama_liga;

CREATE OR REPLACE SYNONYM engLiga FOR vEng_liga;

--No. 3
SELECT stadiumMng.s_nama AS "NAMA_STADIUM", m.nama_manager AS "NAMA_MANAGER"
FROM manager m, club_manager cm, stadiumMng
WHERE m.id_manager= cm.id_manager AND stadiumMng.id_club= cm.id_club
ORDER BY m.nama_manager ASC, SUBSTR(stadiumMng.s_nama, 4) ASC;

CREATE OR REPLACE VIEW vStadium_mng AS
SELECT s.nama_stadium AS s_nama, s.id_club AS id_club
FROM stadium s, club c
WHERE s.id_club= c.id_club AND s.kapasitas > 50000;

CREATE OR REPLACE SYNONYM stadiumMng FOR vStadium_mng;

--No. 4
SELECT a.nama_agen AS "NAMA_AGEN", agenMng.count AS "Jumlah Client Manager"
FROM agen a, player p, agenMng
WHERE a.id_agen= agenMng.id_agen AND a.id_agen= p.id_agen AND
      CAST((TO_CHAR(SYSDATE - p.dob_player) / 365) AS DECIMAL) > 30
GROUP BY a.nama_agen, agenMng.count
ORDER BY agenMng.count DESC, SUBSTR(a.nama_agen, 4) ASC;

CREATE OR REPLACE VIEW vAgen_mng AS
SELECT a.id_agen AS id_agen, COUNT(m.id_manager) AS count
FROM agen a, manager m
WHERE a.id_agen= m.id_agen
GROUP BY a.id_agen;

CREATE OR REPLACE SYNONYM agenMng FOR vAgen_mng;

--TUGAS
--No. 2
SELECT CASE WHEN LENGTH(p.nama_player) > 10
       THEN LPAD(p.nama_player, 20, ' ')
       ELSE RPAD(p.nama_player, 20, ' ')
       END AS "Nama Player",
       FLOOR((TO_CHAR(SYSDATE - p.dob_player) / 365)) AS "Usia Player"
FROM player p, clubNg
WHERE p.id_negara= clubNg.id AND clubNg.count > 4
ORDER BY p.id_negara DESC, "Usia Player" ASC;

CREATE OR REPLACE VIEW vClub_ng AS
SELECT l.id_negara AS id, COUNT(c.id_club) AS count
FROM liga l, club c
WHERE l.id_liga= c.id_liga
GROUP BY l.id_negara;

CREATE OR REPLACE SYNONYM clubNg FOR vClub_ng;

--No. 3
SELECT CASE WHEN MOD(negaraMng.count, 2) != 0
       THEN RPAD(LPAD(negaraMng.count, 11, ' '), 20, ' ')
       END AS "JUMLAH_MANAGER", n.nama_negara AS "NAMA_NEGARA"
FROM player p, negara n, negaraMng
WHERE n.id_negara= negaraMng.id AND p.id_negara= n.id_negara
HAVING COUNT(p.id_player) > 2
GROUP BY n.nama_negara, negaraMng.count
ORDER BY negaraMng.count ASC;

CREATE OR REPLACE VIEW vNegara_mng AS
SELECT COUNT(m.id_manager) AS count, n.id_negara AS id
FROM manager m, negara n
WHERE m.id_negara= n.id_negara
GROUP BY n.id_negara;

CREATE OR REPLACE SYNONYM negaraMng FOR vNegara_mng;

--No. 4
--SYNONYM (MATERI)
CREATE OR REPLACE SYNONYM cTrans FOR vC_trans;
CREATE OR REPLACE SYNONYM engLiga FOR vEng_liga;
CREATE OR REPLACE SYNONYM stadiumMng FOR vStadium_mng;
CREATE OR REPLACE SYNONYM agenMng FOR vAgen_mng;

--SYNONYM (TUGAS)
CREATE OR REPLACE SYNONYM clubNg FOR vClub_ng;
CREATE OR REPLACE SYNONYM negaraMng FOR vNegara_mng;
