-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2017 at 09:31 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sims`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `Username` varchar(250) NOT NULL,
  `Firstnamt` varchar(250) NOT NULL,
  `Middlename` varchar(250) NOT NULL,
  `Lastname` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Permanentaddress` varchar(250) NOT NULL,
  `Temporaryaddress` varchar(250) NOT NULL,
  `Contact` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Username` varchar(250) NOT NULL,
  `Firstnamt` varchar(250) NOT NULL,
  `Middlename` varchar(250) NOT NULL,
  `Lastname` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Permanentaddress` varchar(250) NOT NULL,
  `Temporaryaddress` varchar(250) NOT NULL,
  `Contact` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Username`, `Firstnamt`, `Middlename`, `Lastname`, `Password`, `Permanentaddress`, `Temporaryaddress`, `Contact`, `Email`) VALUES
(1, 'Manish', 'Sunil', '', 'Maharjan', 'manish46', 'Kathmandu', 'Pokhara', '9860333514', 'histugaya48@gmail.com'),
(3, 'Hari', 'Hari', '', 'Thapa', 'hari46', 'Pokhara', 'Kathmandu', '9806756771', 'Haru57@yahoo.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
