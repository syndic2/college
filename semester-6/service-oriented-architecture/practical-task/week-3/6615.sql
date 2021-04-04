-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2020 at 07:32 AM
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
-- Table structure for table `follow_playlist`
--

CREATE TABLE `follow_playlist` (
  `id` int(100) NOT NULL,
  `id_user` int(100) NOT NULL,
  `id_playlist` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `follow_playlist`
--

INSERT INTO `follow_playlist` (`id`, `id_user`, `id_playlist`) VALUES
(1, 1, 'PLP001'),
(2, 3, 'PLP001'),
(3, 4, 'PLP001'),
(4, 5, 'PLP001'),
(5, 6, 'PLP001'),
(6, 7, 'PLP001'),
(7, 8, 'PLP001'),
(8, 9, 'PLP001'),
(9, 10, 'PLP001'),
(10, 11, 'PLP001'),
(11, 12, 'PLP001'),
(12, 13, 'PLP001'),
(13, 14, 'PLP001'),
(14, 15, 'PLP001'),
(15, 16, 'PLP001'),
(16, 17, 'PLP001'),
(17, 18, 'PLP001'),
(18, 19, 'PLP001'),
(19, 20, 'PLP001'),
(20, 21, 'PLP001'),
(21, 22, 'PLP001'),
(22, 23, 'PLP001'),
(23, 24, 'PLP001'),
(24, 25, 'PLP001'),
(25, 1, 'PLP002'),
(26, 3, 'PLP002'),
(27, 4, 'PLP002'),
(28, 5, 'PLP002'),
(29, 6, 'PLP002');

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--

CREATE TABLE `playlist` (
  `id` int(100) NOT NULL,
  `id_playlist` varchar(100) NOT NULL,
  `email_pengguna` varchar(100) NOT NULL,
  `nama_playlist` varchar(100) NOT NULL,
  `collection_lagu` varchar(500) NOT NULL,
  `status_playlist` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`id`, `id_playlist`, `email_pengguna`, `nama_playlist`, `collection_lagu`, `status_playlist`) VALUES
(1, 'PLP001', 'felix@mail.com', 'Good Song Oh Yeah 1', 'S10001, S20001, S30001', 1),
(2, 'PLS001', 'felix@mail.com', 'My Favorite 2', 'S10001, S20001, S30001', 0),
(3, 'PLP002', 'felix@mail.com', 'My Favorite 3', 'S10002, S20002, S30002', 1),
(4, 'PLS002', 'felix@mail.com', 'My Favorite 4', 'S10002, S20002, S30002', 0);

-- --------------------------------------------------------

--
-- Table structure for table `song`
--

CREATE TABLE `song` (
  `id` int(100) NOT NULL,
  `id_lagu` varchar(100) NOT NULL,
  `id_pengguna` int(100) NOT NULL,
  `judul_lagu` varchar(100) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `durasi` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `song`
--

INSERT INTO `song` (`id`, `id_lagu`, `id_pengguna`, `judul_lagu`, `genre`, `durasi`) VALUES
(1, 'S10001', 1, 'Song 1', 'Pop', 2400),
(3, 'S30001', 1, 'Song 3', 'Country', 2400),
(4, 'S10002', 3, 'MarVeiL 1', 'Pop', 2400),
(5, 'S20002', 3, 'MarVeiL 2', 'Jazz', 2400),
(6, 'S30002', 3, 'MarVeiL 3', 'Country', 2400);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_pengguna` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tipe_pengguna` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_pengguna`, `email`, `nama`, `password`, `tipe_pengguna`) VALUES
(1, 'jonsu@mail.com', 'jonsu', 'asd', 1),
(2, 'felix@mail.com', 'felix', 'asd', 0),
(3, 'gidion@mail.com', 'gidion', 'asd', 1),
(4, 'ivan@mail.com', 'ivan', 'asd', 0),
(5, 'matt@mail.com', 'matt', 'asd', 1),
(6, 'jason@mail.com', 'jason', 'asd', 0),
(7, 'stefa@mail.com', 'stefa', 'asd', 1),
(8, 'agung@mail.com', 'agung', 'asd', 0),
(9, 'ryan@mail.com', 'ryan', 'asd', 1),
(10, 'feli@mail.com', 'feli', 'asd', 0),
(11, 'sisca@mail.com', 'sisca', 'asd', 1),
(12, 'vivi@mail.com', 'vivi', 'asd', 0),
(13, 'richard@mail.com', 'richard', 'asd', 1),
(14, 'regan@mail.com', 'regan', 'asd', 0),
(15, 'yoel@mail.com', 'yoel', 'asd', 1),
(16, 'robert@mail.com', 'robert', 'asd', 0),
(17, 'hubert@mail.com', 'hubert', 'asd', 1),
(18, 'alex@mail.com', 'alex', 'asd', 0),
(19, 'cindy@mail.com', 'cindy', 'asd', 1),
(20, 'sony@mail.com', 'sony', 'asd', 0),
(21, 'edwin@mail.com', 'edwin', 'asd', 1),
(22, 'ely@mail.com', 'ely', 'asd', 0),
(23, 'rony@mail.com', 'rony', 'asd', 1),
(24, 'gilbert@mail.com', 'gilbert', 'asd', 0),
(25, 'alfon@mail.com', 'alfon', 'asd', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `follow_playlist`
--
ALTER TABLE `follow_playlist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `follow_playlist`
--
ALTER TABLE `follow_playlist`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `song`
--
ALTER TABLE `song`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
