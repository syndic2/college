--DROP VIEW (MATERI)
DROP VIEW agenPlayer;
DROP VIEW agenManager;

--DROP VIEW (TUGAS)
DROP VIEW termuda;
DROP VIEW tertua;
DROP VIEW satu2nya;
DROP VIEW biggestStadium;

--DROP PROCEDURE & FUNCTION (MATERI)
DROP FUNCTION auto_gen_id_player;
DROP FUNCTION check_pembelian;
DROP PROCEDURE agentPM;
DROP PROCEDURE dataPlayer;

--DROP PROCEDURE & FUNCTION (TUGAS)
DROP FUNCTION cek_umur_player;
DROP FUNCTION auto_gen_person;
DROP PROCEDURE dataClub;
DROP PROCEDURE bigStadium;

--MATERI
--No. 1
CREATE OR REPLACE FUNCTION auto_gen_id_player (
	player VARCHAR2
) RETURN VARCHAR2
IS
	dua NUMBER;
	tiga NUMBER;
	total NUMBER;
	inc NUMBER;
	gen VARCHAR2(6);
	kode NUMBER;
BEGIN
	kode:= 1;
	IF INSTR(player, ' ', 1, 2) != 0 THEN
		tiga:= INSTR(player, ' ', 1, 2) + 1;
		gen:= SUBSTR(player, 1, 1);
		gen:= gen || SUBSTR(player, tiga, 1);
	ELSIF INSTR(player, ' ', 1, 1) != 0 THEN
		dua:= INSTR(player, ' ', 1, 1) + 1;
		gen:= SUBSTR(player, 1, 1);
		gen:= gen || SUBSTR(player, dua, 1);
	ELSE 
		gen:= SUBSTR(player, 1, 2);
	END IF;
	
	SELECT COUNT(p.id_player) INTO total
	FROM player p
	WHERE SUBSTR(p.id_player, 1, 2) = gen;
	
	IF total > 0 THEN
		SELECT MAX(SUBSTR(p.id_player, -1, 1)) INTO inc
		FROM player p
		WHERE SUBSTR(p.id_player, 1, 2) = gen;
		kode:= kode + inc;
	END IF;
	
	gen:= gen || '00' || kode;
	
	RETURN UPPER(gen);
END;
/
SHOW ERR;

DECLARE
	x VARCHAR2(6);
BEGIN
	x:= auto_gen_id_player('Antoine Griezmann');
	DBMS_OUTPUT.PUT_LINE(x);
END;
/
SHOW ERR;

--No. 2
CREATE OR REPLACE FUNCTION check_pembelian (
	club VARCHAR2
) RETURN VARCHAR2
IS
	idx NUMBER;
	total NUMBER;
	outp VARCHAR2(1000);
BEGIN
	outp:= 'club ' || club;
	SELECT COUNT(ht.id_transaksi) INTO total
	FROM h_transaksi ht, club c
	WHERE ht.club_baru=  c.id_club AND c.nama_club= club;
	
	IF total > 0 THEN
		idx:= 0;
		FOR i IN (SELECT p.nama_player AS nama, TO_CHAR(ht.tgl_transfer, 'DD-MM-YYYY') AS tgl
				  FROM player p, club c, h_transaksi ht, d_transaksi dt
				  WHERE ht.id_transaksi= dt.id_transaksi AND
					   (c.id_club= ht.club_baru AND c.nama_club= club) AND
						p.id_player= dt.id_player
				  ORDER BY ht.tgl_transfer ASC)
		LOOP
			IF idx = 0 THEN
				outp:= outp || ' pernah membeli player ' || i.nama || ' pada tanggal ' || i.tgl;
			ELSE
				outp:= outp || ' dan pernah membeli player ' || i.nama || ' juga pada tanggal ' || i.tgl;
			END IF;
			idx:= idx+1;
		END LOOP;
		outp:= outp || ' jumlah transaksi yang pernah dilakukan adalah ' || total;
	ELSE
		outp:= outp || ' tidak pernah membeli pemain siapapun';
	END IF;
	
	RETURN UPPER(outp);
END;
/
SHOW ERR;

DECLARE
	x VARCHAR2(1000);
BEGIN
	x:= check_pembelian('Manchester United');
	DBMS_OUTPUT.PUT_LINE(x);
END;
/
SHOW ERR;

--No. 3
CREATE OR REPLACE VIEW agenPlayer AS
SELECT a.id_agen AS id , COUNT(p.id_player) AS ct
FROM agen a, player p
WHERE a.id_agen= p.id_agen
GROUP BY a.id_agen;

CREATE OR REPLACE VIEW agenManager AS
SELECT a.id_agen AS id, COUNT(m.id_manager) AS ct
FROM agen a, manager m
WHERE a.id_agen= m.id_agen
GROUP BY a.id_agen;

CREATE OR REPLACE PROCEDURE agentPM
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE('===================================================');
	DBMS_OUTPUT.PUT_LINE('|AGEN               |CLIENT PLAYER |CLIENT MANAGER|');
	DBMS_OUTPUT.PUT_LINE('===================================================');
	FOR i IN (SELECT a.nama_agen AS nama, ap.ct AS cp, am.ct AS cm
			  FROM agen a, agenPlayer ap, agenManager am
			  WHERE a.id_agen= ap.id AND a.id_agen= am.id
			  ORDER BY SUBSTR(a.nama_agen, 1, 1) ASC, ap.ct ASC, am.ct DESC)
	LOOP
		DBMS_OUTPUT.PUT('|' || RPAD(i.nama, 19, ' '));
		DBMS_OUTPUT.PUT('|' || RPAD(i.cp, 14, ' '));
		DBMS_OUTPUT.PUT('|' || RPAD(i.cm, 14, ' '));
		DBMS_OUTPUT.PUT('|');
		DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('===================================================');
END;
/
SHOW ERR;

CALL agentPM();

--No. 4
CREATE OR REPLACE PROCEDURE dataPlayer
IS
BEGIN
	FOR i IN (SELECT p.nama_player AS nama, TO_CHAR(ht.tgl_transfer, 'DD-MONYYYY') AS tgl, asal.nama_club AS asal,
					 baru.nama_club AS baru
			  FROM player p, club asal, club baru, h_transaksi ht, d_transaksi dt
			  WHERE ht.id_transaksi= dt.id_transaksi AND
				   (asal.id_club= ht.club_asal AND baru.id_club= ht.club_baru) AND
					p.id_player= dt.id_player
			  ORDER BY TO_CHAR(ht.tgl_transfer, 'DD') ASC, TO_CHAR(ht.tgl_transfer, 'MON') ASC, 
					   TO_CHAR(ht.tgl_transfer, 'YYYY') ASC, p.nama_player ASC)
	LOOP
		DBMS_OUTPUT.PUT_LINE('=======================================');
		DBMS_OUTPUT.PUT_LINE('|            INFO TRANSFER            |');
		DBMS_OUTPUT.PUT_LINE('=======================================');
		DBMS_OUTPUT.PUT_LINE('|NAMA PLAYER      :' || LPAD(i.nama, 19, ' ') || '|');
		DBMS_OUTPUT.PUT_LINE('|TANGGAL TRANSFER :' || LPAD(i.tgl, 19, ' ') || '|');
		DBMS_OUTPUT.PUT_LINE('|CLUB ASAL        :' || LPAD(i.asal, 19, ' ') || '|');
		DBMS_OUTPUT.PUT_LINE('|CLUB BARU        :' || LPAD(i.baru, 19, ' ') || '|');
		DBMS_OUTPUT.PUT_LINE('=======================================');
	END LOOP;
END;
/
SHOW ERR;

CALL dataPlayer();

--TUGAS
--No. 2
CREATE OR REPLACE VIEW termuda AS
SELECT p.id_club AS id, MAX(p.dob_player) AS dob
FROM player p
HAVING COUNT(p.id_player) > 1
GROUP BY p.id_club;

CREATE OR REPLACE VIEW tertua AS
SELECT p.id_club AS id, MIN(p.dob_player) AS dob
FROM player p
HAVING COUNT(p.id_player) > 1
GROUP BY p.id_club;

CREATE OR REPLACE VIEW satu2nya AS
SELECT p.id_club AS id
FROM player p
HAVING COUNT(p.id_player) = 1
GROUP BY p.id_club;

CREATE OR REPLACE FUNCTION cek_umur_player (
	player VARCHAR2
) RETURN VARCHAR2
IS
	cek_tertua NUMBER;
	cek_termuda NUMBER;
	cek_satu2nya NUMBER;
	club VARCHAR2(100);
	outp VARCHAR2(100);
BEGIN
	SELECT COUNT(p.nama_player) INTO cek_termuda
	FROM player p, club c, termuda tm	
	WHERE p.nama_player= player AND 
		 (p.id_club= c.id_club AND tm.id= c.id_club) AND p.dob_player= tm.dob;
	
	SELECT COUNT(p.nama_player) INTO cek_tertua
	FROM player p, club c, tertua tt	
	WHERE p.nama_player= player AND 
		 (p.id_club= c.id_club AND tt.id= c.id_club) AND p.dob_player= tt.dob;
	
	SELECT COUNT(p.nama_player) INTO cek_satu2nya
	FROM player p, club c, satu2nya st
	WHERE p.nama_player= player AND (p.id_club= c.id_club AND st.id= c.id_club);
	
	IF cek_termuda > 0 THEN
		SELECT c.nama_club INTO club
		FROM player p, club c, termuda tm
		WHERE p.nama_player= player AND 
			 (p.id_club= c.id_club AND tm.id= c.id_club) AND p.dob_player= tm.dob;
		outp:= player || ' adalah pemain termuda di club ' || club || '.';
	ELSIF cek_tertua > 0 THEN
		SELECT c.nama_club INTO club
		FROM player p, club c, tertua tt
		WHERE p.nama_player= player AND 
			 (p.id_club= c.id_club AND tt.id= c.id_club) AND p.dob_player= tt.dob;
		outp:= player || ' adalah pemain tertua di club ' || club || '.';
	ELSIF cek_satu2nya > 0 THEN
		SELECT c.nama_club INTO club
		FROM player p, club c, satu2nya st
	    WHERE p.nama_player= player AND (p.id_club= c.id_club AND st.id= c.id_club);
		outp:= player || ' adalah satu-satunya pemain yang terdaftar pada ' || club || '.';
	ELSE
		SELECT c.nama_club INTO club
		FROM player p, club c
	    WHERE p.nama_player= player AND p.id_club= c.id_club;
		outp:= player || ' adalah pemain biasa di club ' || club || '.';
	END IF;
	
	RETURN UPPER(outp);
END;
/
SHOW ERR;

DECLARE
	x VARCHAR2(100);
BEGIN
	x:= cek_umur_player('Javier Pastore');
	DBMS_OUTPUT.PUT_LINE(x);
END;
/
SHOW ERR;

--No. 3
CREATE OR REPLACE FUNCTION auto_gen_person (
	name VARCHAR2,
	role VARCHAR2
) RETURN VARCHAR2
IS
	dua NUMBER;
	tiga NUMBER;
	total NUMBER;
	inc NUMBER;
	gen VARCHAR2(6);
	kode NUMBER;
BEGIN
	kode:= 1;
	IF INSTR(name, ' ', 1, 2) != 0 THEN
		tiga:= INSTR(name, ' ', 1, 2) + 1;
		gen:= gen ||SUBSTR(name, 1, 1);
		gen:= gen || SUBSTR(name, tiga, 1);
	ELSIF INSTR(name, ' ', 1, 1) != 0 THEN
		dua:= INSTR(name, ' ', 1, 1) + 1;
		gen:= gen || SUBSTR(name, 1, 1);
		gen:= gen || SUBSTR(name, dua, 1);
	ELSE 
		gen:= gen || SUBSTR(name, 1, 2);
	END IF;
	
	IF role = 'Player' THEN
		SELECT COUNT(p.id_player) INTO total
		FROM player p
		WHERE SUBSTR(p.id_player, 1, 2) = gen;
		
		IF total > 0 THEN
			SELECT MAX(SUBSTR(p.id_player, -1, 1)) INTO inc
			FROM player p
			WHERE SUBSTR(p.id_player, 1, 2) = gen;
			kode:= kode + inc;
		END IF;
		
		gen:= 'P' || gen;
	ELSIF role = 'Manager' THEN
		gen:= 'M' || gen;
		SELECT COUNT(m.id_manager) INTO total
		FROM manager m
		WHERE SUBSTR(m.id_manager, 1, 3) = gen;
		
		IF total > 0 THEN
			SELECT MAX(SUBSTR(m.id_manager, -2, 2)) INTO inc
			FROM manager m
			WHERE SUBSTR(m.id_manager, 1, 3) = gen;
			kode:= kode + inc;
		END IF;
	END IF;
	
	IF kode < 10 THEN
		gen:= gen || '00' || kode;
	ELSIF kode >= 10 AND kode < 100 THEN
		gen:= gen || '0' || kode;
	END IF;
		
	RETURN UPPER(gen);
END;
/
SHOW ERR;

DECLARE
	x VARCHAR2(6);
BEGIN
	x:= auto_gen_person('Antoine Griezmann', 'Player');
	DBMS_OUTPUT.PUT_LINE(x);
END;
/
SHOW ERR;

--No. 4
CREATE OR REPLACE PROCEDURE dataClub
IS
BEGIN
	FOR i IN (SELECT c.nama_club AS nama, TO_CHAR(c.tahun_berdiri, 'YYYY') AS thn, 
					 l.nama_liga AS liga, m.nama_manager AS mng, s.nama_stadium AS stadium
			  FROM club c, club_manager cm, manager m, stadium s, liga l
			  WHERE c.id_club= cm.id_club AND m.id_manager= cm.id_manager AND 
					c.id_club= s.id_club AND c.id_liga= l.id_liga
			  ORDER BY c.nama_club ASC)
	LOOP
		DBMS_OUTPUT.PUT_LINE('#######################################');
		DBMS_OUTPUT.PUT_LINE('|            INFO CLUB                |');
		DBMS_OUTPUT.PUT_LINE('#######################################');
		DBMS_OUTPUT.PUT_LINE('|NAMA CLUB        :' || LPAD(i.nama || '|', 20, ' '));
		DBMS_OUTPUT.PUT_LINE('|TAHUN BERDIRI    :' || LPAD(i.thn || '|', 20, ' '));
		DBMS_OUTPUT.PUT_LINE('|LIGA             :' || LPAD(i.liga || '|', 20, ' '));
		DBMS_OUTPUT.PUT_LINE('|MANAGER CLUB     :' || LPAD(i.mng || '|', 20, ' '));
		DBMS_OUTPUT.PUT_LINE('|STADIUM          :' || LPAD(i.stadium || '|', 20, ' '));
		DBMS_OUTPUT.PUT_LINE('#######################################');
	END LOOP;
END;
/
SHOW ERR;

CALL dataClub();

--No. 5
CREATE OR REPLACE VIEW biggestStadium AS
SELECT s.id_negara AS id, MAX(s.kapasitas) AS kapasitas 
FROM stadium s
GROUP BY s.id_negara;

CREATE OR REPLACE PROCEDURE bigStadium 
IS
BEGIN
	DBMS_OUTPUT.PUT_LINE('+==========================================================+');
	DBMS_OUTPUT.PUT_LINE('|AGEN               |STADIUM            |KAPASITAS         |');
	DBMS_OUTPUT.PUT_LINE('+----------------------------------------------------------+');
	FOR i IN (SELECT n.nama_negara AS n_nama, s.nama_stadium AS s_nama, s.kapasitas || ' KURSI' AS kapasitas
			  FROM stadium s, negara n, biggestStadium bs
			  WHERE s.id_negara= bs.id AND s.id_negara= n.id_negara AND s.kapasitas= bs.kapasitas
			  ORDER BY SUBSTR(s.nama_stadium, 2, 1) ASC, s.kapasitas DESC)
	LOOP
		DBMS_OUTPUT.PUT('|' || RPAD(i.n_nama, 19, ' '));
		DBMS_OUTPUT.PUT('|' || RPAD(i.s_nama, 19, ' '));
		DBMS_OUTPUT.PUT('|' || RPAD(i.kapasitas, 18, ' ') || '|');
		DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('+==========================================================+');
END;
/
SHOW ERR;

CALL bigStadium();