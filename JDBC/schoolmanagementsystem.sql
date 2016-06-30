-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2016 at 09:38 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schoolmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE `tbl_student` (
  `Id` int(11) NOT NULL,
  `First_Name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Last_Name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email_id` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Status` tinyint(4) NOT NULL,
  `Added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Modified_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tbl_student`
--

INSERT INTO `tbl_student` (`Id`, `First_Name`, `Last_Name`, `Email_id`, `Status`, `Added_date`, `Modified_date`) VALUES
(2, 'i', 'maharjan', 'hari@gmail.com', 1, '2016-06-29 10:32:50', '2016-06-29 18:15:00'),
(3, 'Ramesh', 'Nepal', 'Ram12@gmailcom', 0, '2016-06-29 10:39:05', NULL),
(5, 'James', 'Bond', 'james@gmail.com', 1, '2016-06-29 10:50:13', NULL),
(6, 'Suman', 'Karki', 'suman@hotmail.com', 1, '2016-06-30 04:25:31', NULL),
(7, 'Karan', 'Subedi', 'sub123@gmail.com', 1, '2016-06-30 04:28:32', NULL),
(8, 'Kripesh', 'Bista', 'kripesh@gmail.com', 1, '2016-06-30 05:53:57', NULL),
(9, 'Harry', 'Potter', 'Harry@gmail.com', 1, '2016-06-30 07:20:25', NULL),
(10, 'Hermoine', 'Granger', 'Hermone@gmail.cm', 0, '2016-06-30 07:23:28', NULL),
(11, 'Rony', 'Karki', 'rony@gmail.com', 0, '2016-06-30 07:24:36', NULL),
(12, 'Dixanta', 'Shrestha', 'Dixanta@gmail.com', 0, '2016-06-30 07:25:18', NULL),
(13, 'asdasd', 'asdasd', 'asdasd@gmail.com', 0, '2016-06-30 07:25:32', NULL),
(14, 'Sonam', 'Shakya', 'shakyasonam@gmail.com', 0, '2016-06-30 07:25:33', '2016-06-29 18:15:00'),
(15, 'Hari', 'Bahadur', 'Harii@gmail.com', 1, '2016-06-30 07:30:13', NULL),
(16, 'Jim', 'Carry', 'Carry@gmail.com', 1, '2016-06-30 07:30:37', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_student`
--
ALTER TABLE `tbl_student`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
