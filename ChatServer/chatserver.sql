-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2016 at 08:38 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chatserver`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_block_admin`
--

CREATE TABLE `tbl_block_admin` (
  `Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_block_chirag`
--

CREATE TABLE `tbl_block_chirag` (
  `Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_block_guest`
--

CREATE TABLE `tbl_block_guest` (
  `Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_block_lfa`
--

CREATE TABLE `tbl_block_lfa` (
  `Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `User_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id`, `User_name`, `Password`) VALUES
(1, 'Chirag', 'Chirag'),
(2, 'Admin', 'Admin'),
(3, 'Lfa', 'Lfa'),
(4, 'Guest', 'Guest');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_block_admin`
--
ALTER TABLE `tbl_block_admin`
  ADD KEY `Id` (`Id`);

--
-- Indexes for table `tbl_block_chirag`
--
ALTER TABLE `tbl_block_chirag`
  ADD KEY `Id` (`Id`);

--
-- Indexes for table `tbl_block_guest`
--
ALTER TABLE `tbl_block_guest`
  ADD KEY `Id` (`Id`);

--
-- Indexes for table `tbl_block_lfa`
--
ALTER TABLE `tbl_block_lfa`
  ADD KEY `Id` (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_block_admin`
--
ALTER TABLE `tbl_block_admin`
  ADD CONSTRAINT `tbl_block_admin_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `users` (`Id`);

--
-- Constraints for table `tbl_block_chirag`
--
ALTER TABLE `tbl_block_chirag`
  ADD CONSTRAINT `tbl_block_chirag_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `users` (`Id`);

--
-- Constraints for table `tbl_block_guest`
--
ALTER TABLE `tbl_block_guest`
  ADD CONSTRAINT `tbl_block_guest_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `users` (`Id`);

--
-- Constraints for table `tbl_block_lfa`
--
ALTER TABLE `tbl_block_lfa`
  ADD CONSTRAINT `tbl_block_lfa_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `users` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
