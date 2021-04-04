--DROP FUNCTION
DROP FUNCTION idClub;
DROP FUNCTION idNegara;
DROP PROCEDURE newStadium;

--DROP TRIGGER
DROP TRIGGER newClub;
DROP TRIGGER newNegara;
DROP TRIGGER delHtrans;
DROP TRIGGER delDtrans;

--TUGAS
--No. 1
CREATE OR REPLACE FUNCTION idClub (
	club VARCHAR2
) RETURN VARCHAR2
IS
	ada NUMBER;
	cari NUMBER;
	spasi NUMBER;
	kode NUMBER;
	gen VARCHAR2(6);
BEGIN
	kode:= 1;
	cari:= 1;
	spasi:= 0;
	WHILE INSTR(club, ' ', 1, cari) != 0
	LOOP
		spasi:= INSTR(club, ' ', 1, cari);
		cari:= cari + 1;
	END LOOP;
	
	IF spasi = 0 THEN
		gen:= UPPER(SUBSTR(club, 1, 2)); 
	ELSE
		gen:= UPPER(SUBSTR(club, 1, 1) || SUBSTR(club, spasi + 1, 1));
	END IF;
	
	SELECT COUNT(id_club) INTO ada 
	FROM club
	WHERE SUBSTR(id_club, 1, 2) = gen;
	
	IF ada > 0 THEN
		SELECT MAX(SUBSTR(id_club, 3)) + 1 INTO kode
		FROM club 
		WHERE SUBSTR(id_club, 1, 2) = gen;
	END IF;
	
	IF kode > 0 AND kode < 10 THEN
		gen:= gen || '00' || kode;
	ELSIF kode >= 10 AND kode < 100 THEN
		gen:= gen || '0' || kode;
	ELSIF kode >= 100 AND kode < 1000 THEN
		gen:= gen || kode;
	END IF;
	
	RETURN gen;
END;
/
SHOW ERR;

CREATE OR REPLACE PROCEDURE newStadium (
	club VARCHAR2
)
IS
	tahun DATE;
	d2 NUMBER;
	d3 NUMBER;
	kode NUMBER;
	id VARCHAR2(6);
	nama VARCHAR2(100);
	nama_std VARCHAR2(100);
	kapasitas NUMBER;
BEGIN
	SELECT MAX(SUBSTR(id_stadium, 4)) + 1 INTO kode
	FROM stadium;

	IF kode > 0 AND kode < 10 THEN
		id:= 'STD' || '00' || kode;
	ELSIF kode >= 10 AND kode < 100 THEN
		id:= 'STD' || '0' || kode;
	ELSIF kode >= 100 AND kode < 1000 THEN
		id:= 'STD' || kode;
	END IF;
	
	SELECT nama_club, tahun_berdiri INTO nama, tahun
	FROM club
	WHERE id_club = club;
	
	IF LENGTH(nama || ' Stadium') > 20 THEN
		nama_std:= SUBSTR(nama, 1, 12) || ' Stadium';
	END IF;
	
	d2:= TO_NUMBER(SUBSTR(TO_CHAR(tahun, 'YYYY'), 2, 1));
	d3:= TO_NUMBER(SUBSTR(TO_CHAR(tahun, 'YYYY'), 3, 1));
	kapasitas:= POWER(d2, 3) + (d3*100) + (LENGTH(nama)+50);
	
	INSERT INTO stadium VALUES (id, nama_std, kapasitas, club, 'ENG');
END;
/
SHOW ERR;

CREATE OR REPLACE TRIGGER newClub
AFTER INSERT ON club
DECLARE
	idx NUMBER;
	last_inserted NUMBER;
	last_id VARCHAR2(6);
	new_id VARCHAR2(6);
	new_nama VARCHAR2(100);
	new_tahun DATE;
	new_liga VARCHAR2(6);
	cek_kode NUMBER;
	cek_id VARCHAR2(6);
BEGIN
	idx:= 0;
	FOR i IN (SELECT *
			  FROM club) 
	LOOP
		idx:= idx + 1;
	END LOOP;
	
	last_inserted:= 0;
	FOR i IN (SELECT *
			  FROM club) 
	LOOP
		last_inserted:= last_inserted + 1;
		IF last_inserted = idx THEN
			last_id:= i.id_club;
			new_id:= i.id_club;
			new_nama:= i.nama_club;
			new_tahun:= i.tahun_berdiri;
			new_liga:= i.id_liga;
		END IF;
	END LOOP;
	
	new_id:= idClub(new_nama);
	
	cek_kode:= TO_NUMBER(SUBSTR(new_id, 3)) - 1;
	IF cek_kode > 0 AND cek_kode < 10 THEN
		cek_id:= SUBSTR(new_id, 1, 2) || '00' || cek_kode;
	ELSIF cek_kode >= 10 AND cek_kode < 100 THEN
		cek_id:= SUBSTR(new_id, 1, 2) || '0' || cek_kode;
	ELSIF cek_kode >= 100 AND cek_kode < 1000 THEN
		cek_id:= SUBSTR(new_id, 1, 2) || cek_kode;
	END IF;
	
	IF UPPER(last_id) = UPPER(cek_id) THEN
		new_id:= UPPER(last_id);
	END IF;
	
	new_nama:= INITCAP(new_nama);
	new_tahun:= TO_DATE(TO_CHAR(new_tahun, 'YYYY'), 'YYYY');
	
	IF TO_CHAR(new_tahun, 'YYYY') < 2000 THEN
		new_liga:= 'EN001';
	ELSE
		new_liga:= 'EN004';
	END IF;
	
	UPDATE club 
	SET id_club = new_id, nama_club = new_nama, 
		tahun_berdiri = new_tahun, id_liga = new_liga
	WHERE id_club = last_id;
	
	newStadium(new_id);
END;
/
SHOW ERR;

--No. 2
CREATE OR REPLACE FUNCTION idNegara (
	negara VARCHAR2
) RETURN VARCHAR2
IS	
	ada NUMBER;
	gen VARCHAR2(3);
BEGIN
	gen:= UPPER(SUBSTR(negara, 1, 3));
	
	SELECT COUNT(id_negara) INTO ada
	FROM negara
	WHERE SUBSTR(id_negara, 1, 3) = gen;
	
	IF ada > 0 THEN
		gen:= UPPER(SUBSTR(gen, 1, 2) || SUBSTR(negara, -2, 1));
	END IF;
	
	RETURN gen;
END;
/
SHOW ERR;

CREATE OR REPLACE TRIGGER newNegara
BEFORE INSERT ON negara
FOR EACH ROW
DECLARE
	nama_kembar EXCEPTION;
	ada NUMBER;
BEGIN
	:NEW.id_negara:= idNegara(:NEW.nama_negara);
	:NEW.nama_negara:= UPPER(:NEW.nama_negara);
	
	SELECT COUNT(nama_negara) INTO ada
	FROM negara
	WHERE nama_negara = :NEW.nama_negara;
	
	IF ada > 0 THEN
		RAISE nama_kembar;
	END IF;

EXCEPTION
	WHEN nama_kembar THEN
		RAISE_APPLICATION_ERROR(-20001, 'NAMA NEGARA TIDAK BOLEH KEMBAR');
END;
/
SHOW ERR;

--No. 3
CREATE OR REPLACE TRIGGER delHtrans
BEFORE DELETE ON h_transaksi
FOR EACH ROW
DECLARE
BEGIN
	DELETE FROM d_transaksi
	WHERE id_transaksi= :OLD.id_transaksi;
END;
/
SHOW ERR;

--No. 4
CREATE OR REPLACE TRIGGER delDtrans
BEFORE DELETE ON d_transaksi
FOR EACH ROW
DECLARE
	ht_harga NUMBER;
	dt_harga NUMBER;
	harga_baru NUMBER;
BEGIN	
	SELECT biaya_transfer INTO ht_harga
	FROM h_transaksi
	WHERE id_transaksi = :OLD.id_transaksi;
	
	dt_harga:= :OLD.subtotal;
	harga_baru:= ht_harga - dt_harga;
	
	UPDATE h_transaksi
	SET biaya_transfer = harga_baru
	WHERE id_transaksi = :OLD.id_transaksi;
END;
/
SHOW ERR;