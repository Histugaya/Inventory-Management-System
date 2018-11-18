-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2017 at 09:30 PM
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
-- Database: `ims`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id` int(11) NOT NULL,
  `Customername` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Contact` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `Customername`, `Address`, `Contact`) VALUES
(1, 'Sharmila', 'Pokhara', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `CustomerID` int(11) NOT NULL,
  `CustomerName` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Contact` varchar(250) NOT NULL,
  `Product` varchar(250) NOT NULL,
  `Company` varchar(250) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Date` varchar(250) NOT NULL,
  `Status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `Id` int(11) NOT NULL,
  `Name` varchar(250) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Suppliername` varchar(250) NOT NULL,
  `Date` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`Id`, `Name`, `Qty`, `Rpu`, `Suppliername`, `Date`) VALUES
(6, 'S8', 90, 25000, 'Samsung', '2017-08-15');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `Id` int(11) NOT NULL,
  `Product` varchar(250) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Suppliername` varchar(250) NOT NULL,
  `Date` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`Id`, `Product`, `Qty`, `Rpu`, `Suppliername`, `Date`) VALUES
(7, 'S8', 1000, 25000, 'Samsung', '2017-08-15');

-- --------------------------------------------------------

--
-- Table structure for table `purchasereturn`
--

CREATE TABLE `purchasereturn` (
  `Id` int(11) NOT NULL,
  `Product` varchar(250) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Suppliername` varchar(250) NOT NULL,
  `Date` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchasereturn`
--

INSERT INTO `purchasereturn` (`Id`, `Product`, `Qty`, `Rpu`, `Suppliername`, `Date`) VALUES
(3, 'S8', 900, 25000, 'Samsung', '2017-08-16');

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `SaleId` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `CustomerName` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Contact` varchar(250) NOT NULL,
  `Product` varchar(250) NOT NULL,
  `Company` varchar(250) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Date` varchar(250) NOT NULL,
  `Status` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`SaleId`, `CustomerID`, `CustomerName`, `Address`, `Contact`, `Product`, `Company`, `Qty`, `Rpu`, `Total`, `Date`, `Status`) VALUES
(4, 1, 'Sharmila', 'Pokhara', '12345', 'S8', 'Samsung', 100, 25000, 2500000, '2017-08-16', 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `salesreturn`
--

CREATE TABLE `salesreturn` (
  `CustomerID` int(11) NOT NULL,
  `CustomerName` varchar(250) NOT NULL,
  `Address` varchar(250) NOT NULL,
  `Contact` varchar(250) NOT NULL,
  `Product` varchar(250) NOT NULL,
  `Company` varchar(250) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Status` varchar(250) NOT NULL,
  `Date` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesreturn`
--

INSERT INTO `salesreturn` (`CustomerID`, `CustomerName`, `Address`, `Contact`, `Product`, `Company`, `Qty`, `Rpu`, `Total`, `Status`, `Date`) VALUES
(1, 'Sharmila', 'Pokhara', '12345', 'S8', 'Samsung', 90, 25000, 2250000, 'Paid', '17/08/17');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Id` int(11) NOT NULL,
  `Suppliername` varchar(250) NOT NULL,
  `Product` varchar(250) NOT NULL,
  `Rpu` int(11) NOT NULL,
  `Contact` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Id`, `Suppliername`, `Product`, `Rpu`, `Contact`) VALUES
(1, 'Samsung', 'S8', 25000, '12345');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Username` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Username`, `Password`) VALUES
('Manish', 'manish56');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `purchasereturn`
--
ALTER TABLE `purchasereturn`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`SaleId`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `purchasereturn`
--
ALTER TABLE `purchasereturn`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `SaleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
