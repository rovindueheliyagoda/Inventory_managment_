-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 07:12 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `items management`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemID` int(11) NOT NULL,
  `itemCode` varchar(10) NOT NULL,
  `itemName` varchar(30) NOT NULL,
  `itemPrice` decimal(5,2) NOT NULL,
  `itemDesc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`itemID`, `itemCode`, `itemName`, `itemPrice`, `itemDesc`) VALUES
(27, '001', 'Acetaminophen', '24.00', 'medicine'),
(28, '987', 'Adderall', '32.90', 'medicine '),
(29, '897', 'Alprazolam', '23.50', 'medicine'),
(30, '345', 'Amitriptyline', '2.90', 'medicine'),
(31, '789', 'Amlodipine', '45.90', 'medicine'),
(32, '770', 'Amoxicillin', '56.00', 'medicine'),
(33, '568', 'Ativan', '32.90', 'medicine'),
(34, '809', 'Atorvastatin', '56.90', 'medicine'),
(35, '354', 'Lisinopril ', '0.98', 'medicine'),
(36, '666', 'Metformin ', '69.00', 'medicine');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
