--No. 1
SELECT RPAD(c.nama_club, 30, ' ') AS "Club Aktif Transfer 3 Tahun"
FROM club c, (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2012
              GROUP BY c.id_club) c2012,
             (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2013
              GROUP BY c.id_club) c2013,
             (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2014
              GROUP BY c.id_club) c2014,
             (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2015
              GROUP BY c.id_club) c2015,
             (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2016
              GROUP BY c.id_club) c2016,
             (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2017
              GROUP BY c.id_club) c2017,
             (SELECT c.id_club AS id
              FROM club c, h_transaksi ht
              WHERE (c.id_club= ht.club_asal OR c.id_club= ht.club_baru) AND
                     to_char(ht.tgl_transfer, 'YYYY')= 2018
              GROUP BY c.id_club) c2018
WHERE (c.id_club IN c2012.id AND c.id_club IN c2013.id AND c.id_club IN c2014.id) OR
      (c.id_club IN c2013.id AND c.id_club IN c2014.id AND c.id_club IN c2015.id) OR
      (c.id_club IN c2014.id AND c.id_club IN c2015.id AND c.id_club IN c2016.id) OR
      (c.id_club IN c2015.id AND c.id_club IN c2016.id AND c.id_club IN c2017.id) OR
      (c.id_club IN c2016.id AND c.id_club IN c2017.id AND c.id_club IN c2018.id)
GROUP BY c.nama_club
ORDER BY SUBSTR(c.nama_club, 2) DESC;

--No. 2
SELECT n.nama_negara AS "Nama Negara", s.nama_stadium AS "Stadion Terbesar",
       RPAD(LPAD(n_biggest.avg || ' Orang', 18, ' '), 27, ' ')  AS "Kapasitas Stadion Rata2"
FROM negara n, stadium s, (SELECT n.id_negara AS id, MAX(s.kapasitas) AS max,
                                  CAST(AVG(s.kapasitas) AS DECIMAL) AS avg
                           FROM negara n, stadium s
                           WHERE n.id_negara= s.id_negara
                           GROUP BY n.id_negara) n_biggest
WHERE n.id_negara= n_biggest.id AND n.id_negara= s.id_negara AND s.kapasitas= n_biggest.max
ORDER BY n_biggest.avg DESC;

--No. 3
SELECT m.nama_manager AS "NAMA_MANAGER", c.nama_club AS "NAMA_CLUB"
FROM club c
RIGHT JOIN club_manager cm
ON c.id_club= cm.id_club
RIGHT JOIN manager m
ON m.id_manager= cm.id_manager;

--No. 4
SELECT CASE WHEN SUBSTR(n.nama_negara, 1, 1)= 'B'
       THEN LPAD(p.nama_player, 20, ' ')
       ELSE p.nama_player
       END AS "NAMA_PLAYER",
       p_trans.sum AS "TOTAL_PENJUALAN", n.nama_negara AS "NEGARA_ASAL"
FROM player p, negara n, (SELECT p.id_player AS id, COUNT(p.id_player) AS count,
                                 SUM(dt.subtotal) AS sum, AVG(dt.subtotal) AS avg
                          FROM player p, h_transaksi ht, d_transaksi dt
                          WHERE ht.id_transaksi= dt.id_transaksi AND dt.id_player= p.id_player
                          GROUP BY p.id_player) p_trans
WHERE p.id_player= p_trans.id AND p.id_negara= n.id_negara AND p_trans.count > 1 AND p_trans.avg > 30000000
ORDER BY SUBSTR(p.nama_player, -6+(LENGTH(p.nama_player)), 1) ASC;
