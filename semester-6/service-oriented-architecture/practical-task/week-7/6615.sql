-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2020 at 05:34 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `6615`
--
CREATE DATABASE IF NOT EXISTS `6615` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `6615`;

-- --------------------------------------------------------

--
-- Table structure for table `laporan`
--

CREATE TABLE `laporan` (
  `id_laporan` int(11) NOT NULL,
  `judul_laporan` varchar(100) NOT NULL,
  `tanggal_laporan` varchar(100) NOT NULL,
  `deskripsi_laporan` varchar(500) NOT NULL,
  `jenis_kriminalitas` varchar(100) NOT NULL,
  `alamat_kejadian` varchar(500) NOT NULL,
  `kode_pos_alamat` varchar(100) NOT NULL,
  `email_pelapor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `laporan`
--

INSERT INTO `laporan` (`id_laporan`, `judul_laporan`, `tanggal_laporan`, `deskripsi_laporan`, `jenis_kriminalitas`, `alamat_kejadian`, `kode_pos_alamat`, `email_pelapor`) VALUES
(1, 'Orang Desa Hilang', '22/04/2017', 'Hilang secara misterius', 'penculikkan', 'Gregol 15', '60233', 'anonymous'),
(2, 'Orang Kota Hilang', '22/04/2017', 'Hilang secara misterius', 'penculikkan', 'Gregol 15', '60233', 'felix@mail.com'),
(3, 'Orang Rumah Hilang', '22/04/2017', 'Hilang secara misterius', 'penculikkan', 'Gregol 15', '60233', 'gidion@mail.com'),
(4, 'Orang Sekolah Hilang', '22/04/2017', 'Hilang secara misterius', 'penculikkan', 'Gregol 15', '60233', 'ivan@mail.com'),
(5, 'KDRT di Jakarta', '23/05/2018', 'Kekerasan dalam rumah tangga', 'kekerasan', 'Rambutan 16', '60234', 'jonsu@mail.com'),
(6, 'KDRT di Surabaya', '23/05/2018', 'Kekerasan dalam rumah tangga', 'kekerasan', 'Rambutan 16', '60234', 'felix@mail.com'),
(7, 'KDRT di Malang', '23/05/2018', 'Kekerasan dalam rumah tangga', 'kekerasan', 'Rambutan 16', '60234', 'anonymous'),
(8, 'KDRT di Mojokerto', '23/05/2018', 'Kekerasan dalam rumah tangga', 'kekerasan', 'Rambutan 16', '60234', 'ivan@mail.com'),
(9, 'Terjadi tabrak lari di dekat tol Cipularang', '24/06/2019', 'Tabrak lari di dekat tol Cipularang', 'tabrak lari', 'Durian 17', '60235', 'anonymous'),
(10, 'Terjadi tabrak lari di dekat tol Cipumurah', '24/06/2019', 'Tabrak lari di dekat tol Cipumurah', 'tabrak lari', 'Durian 17', '60235', 'felix@mail.com'),
(11, 'Terjadi tabrak lari di dekat tol Depok', '24/06/2019', 'Tabrak lari di dekat tol Depok', 'tabrak lari', 'Durian 17', '60235', 'gidion@mail.com'),
(12, 'Terjadi tabrak lari di dekat tol Demak', '24/06/2019', 'Tabrak lari di dekat tol Demak', 'tabrak lari', 'Durian 17', '60235', 'ivan@mail.com'),
(13, 'Menyelinap-nyelinap di pinggir rumah warga', '25/07/2020', 'Menyelinap curiga', 'aktivitas mencurigakan', 'Jeruk 18', '60236', 'jonsu@mail.com'),
(14, 'Menyelinap-nyelinap di pinggir rumah RT', '25/07/2020', 'Menyelinap curiga', 'aktivitas mencurigakan', 'Jeruk 18', '60236', 'felix@mail.com'),
(15, 'Menyelinap-nyelinap di pinggir rumah RW', '25/07/2020', 'Menyelinap curiga', 'aktivitas mencurigakan', 'Jeruk 18', '60236', 'anonymous'),
(16, 'Menyelinap-nyelinap di pinggir rumah Lurah', '25/07/2020', 'Menyelinap curiga', 'aktivitas mencurigakan', 'Jeruk 18', '60236', 'ivan@mail.com'),
(17, 'Terjadi penculikkan dekat warung', '26/08/2017', 'Penculikkan di dekat warung', 'penculikkan', 'Apel 19', '60237', 'anonymous'),
(18, 'Kekerasan terhadap orang tua', '27/09/2018', 'Kekerasan orang tua', 'kekerasan', 'Pisang 20', '60239', 'felix@mail.com'),
(19, 'Tabrak lari di jalan raya', '28/10/2019', 'Tabrak lari jalan raya', 'tabrak lari', 'Mangga 21', '60240', 'gidion@mail.com'),
(20, 'Orang bergerak curiga', '29/11/2020', 'Sangat mencurigakan', 'aktivitas mencurigakan', 'Nipis 22', '60241', 'ivan@mail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `email_user` varchar(100) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `nohp_user` varchar(100) NOT NULL,
  `saldo_user` int(11) NOT NULL,
  `tipe_user` tinyint(4) NOT NULL,
  `password_user` varchar(100) NOT NULL,
  `api_key` varchar(100) NOT NULL,
  `api_hit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `email_user`, `nama_user`, `nohp_user`, `saldo_user`, `tipe_user`, `password_user`, `api_key`, `api_hit`) VALUES
(1, 'jonsu@mail.com', 'jonsu', '123', 4000, 1, 'asd', 'ed16I8357D', 9),
(2, 'felix@mail.com', 'felix', '123', 4500, 0, 'asd', '1t4jb333Tu', 5),
(3, 'gidion@mail.com', 'gidion', '123', 5000, 1, 'asd', 'gjU534Z5Hl', 14),
(4, 'ivan@mail.com', 'ivan', '123', 4500, 0, 'asd', 'r6Z09A0F36', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`id_laporan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `laporan`
--
ALTER TABLE `laporan`
  MODIFY `id_laporan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
