-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2018 at 10:29 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store`
--

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

drop table if exists categories;
drop table if exists product;
drop table if exists carts;


CREATE TABLE `carts` (
  `id` mediumint(10) UNSIGNED NOT NULL,
  `image` varchar(45) NOT NULL,
  `message` tinytext,
  `price` decimal(5,2) UNSIGNED NOT NULL,
  `quantity` mediumint(10) UNSIGNED NOT NULL,
  `product_id` mediumint(8) UNSIGNED NOT NULL,
  `category_id` mediumint(8) UNSIGNED NOT NULL,
  `sex` varchar(60) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`id`, `image`, `message`, `price`, `quantity`, `product_id`, `category_id`, `sex`) VALUES
(1, '3.jpg', '', '65.50', 32, 73, 3, 'women'),
(2, '3.jpg', NULL, '75.50', 1, 63, 2, 'women');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `category` varchar(40) NOT NULL,
  `description` tinytext NOT NULL,
  `image` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `category`, `description`, `image`) VALUES
(1, 'tee-shirts', 'Well-designed tee-shirts.', '1.jpg'),
(2, 'trousers', 'Well-dessigned trousers.', '1.jpg'),
(3, 'hats', 'Well-designed hats.', '1.jpg'),
(4, 'shoes', 'Well-designed shoes', '1.jpg'),
(5, 'accessories', 'Here are the accessories', '1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` mediumint(10) UNSIGNED NOT NULL,
  `category_id` tinyint(3) UNSIGNED NOT NULL,
  `sex` varchar(60) NOT NULL,
  `size` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `description` tinytext,
  `image` varchar(45) NOT NULL,
  `price` decimal(5,2) UNSIGNED NOT NULL,
  `stock` mediumint(8) UNSIGNED NOT NULL DEFAULT '0',
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `category_id`, `sex`, `size`, `name`, `description`, `image`, `price`, `stock`, `date_created`) VALUES
(1, 1, 'men', 'medium', 'Pretty Tee-shirt', 'A pretty bue tee-shirt', '1.jpg', '6.50', 105, '2018-01-22 18:18:35'),
(2, 1, 'men', 'medium', 'Grey Tee-shirt', 'An elaborate, painted grey tee-shirt.', '2.jpg', '7.95', 22, '2018-01-22 18:20:59'),
(3, 1, 'men', 'medium', 'Yellow Tee-shirt', 'A Pretty Yellow tee-shirt', '3.jpg', '5.50', 105, '2018-01-22 18:18:35'),
(4, 1, 'men', 'medium', 'Red Tee-shirt', 'An elaborate, painted Red tee-shirt.', '4.jpg', '4.95', 22, '2018-01-22 18:20:59'),
(5, 1, 'men', 'medium', 'Sky Blue Tee-shirt', 'A sky bue tee-shirt', '5.jpg', '8.50', 105, '2018-01-22 18:18:35'),
(6, 1, 'men', 'medium', 'Grey Tee-shirt', 'An elaborate, painted grey tee-shirt.', '6.jpg', '7.95', 22, '2018-01-22 18:20:59'),
(7, 1, 'men', 'medium', 'Pretty Grey Tee-shirt', 'A Pretty Grey tee-shirt', '7.jpg', '7.50', 105, '2018-01-22 18:18:35'),
(8, 1, 'men', 'medium', 'Grey Tee-shirt', 'An elaborate, painted grey tee-shirt.', '8.jpg', '7.95', 22, '2018-01-22 18:20:59'),
(9, 1, 'men', 'medium', 'Green Tee-shirt', 'A Pretty green tee-shirt', '9.jpg', '10.50', 105, '2018-01-22 18:18:35'),
(10, 1, 'men', 'medium', 'Purple Tee-shirt', 'An elaborate, painted purple tee-shirt.', '10.jpg', '8.95', 22, '2018-01-22 18:20:59'),
(11, 2, 'men', 'medium', 'Pretty Trouser', 'A pretty grey trouser', '1.jpg', '30.50', 105, '2018-01-22 18:18:35'),
(12, 2, 'men', 'medium', 'Brown Trouser', 'An elaborate, painted brown trouser.', '2.jpg', '7.95', 22, '2018-01-22 18:20:59'),
(13, 2, 'men', 'medium', 'Black Trouser', 'A Pretty black Trouser', '3.jpg', '31.50', 105, '2018-01-22 18:18:35'),
(14, 2, 'men', 'small', 'Brown Trouser', 'An elaborate, painted brown trouser.', '4.jpg', '34.95', 22, '2018-01-22 18:20:59'),
(15, 2, 'men', 'small', 'Dark Trouser', 'A dark trouser', '5.jpg', '38.50', 105, '2018-01-22 18:18:35'),
(16, 2, 'men', 'small', 'Dark Trouser', 'An elaborate, painted dark trouser.', '6.jpg', '7.95', 22, '2018-01-22 18:20:59'),
(17, 2, 'men', 'small', 'Grey Grey Trouser', 'A Pretty grey trouser', '7.jpg', '37.50', 105, '2018-01-22 18:18:35'),
(18, 2, 'men', 'small', 'Grey Trouser', 'An elaborate, painted grey trouser.', '8.jpg', '37.95', 22, '2018-01-22 18:20:59'),
(19, 2, 'men', 'small', 'Red Trouser', 'A Pretty red trouser', '9.jpg', '40.50', 105, '2018-01-22 18:18:35'),
(20, 2, 'men', 'small', 'White Trouser', 'An elaborate, painted white trouser.', '10.jpg', '48.95', 22, '2018-01-22 18:20:59'),
(21, 3, 'men', 'large', 'Pretty Hat', 'A pretty grey hat', '1.jpg', '36.50', 105, '2018-01-22 18:18:35'),
(22, 3, 'men', 'large', 'Brown Hat', 'An elaborate, painted brown hat.', '2.jpg', '37.95', 22, '2018-01-22 18:20:59'),
(23, 3, 'men', 'large', 'Black Hat', 'A Pretty black hat', '3.jpg', '35.50', 105, '2018-01-22 18:18:35'),
(24, 3, 'men', 'large', 'Brown Hat', 'An elaborate, painted brown hat.', '4.jpg', '34.95', 22, '2018-01-22 18:20:59'),
(25, 3, 'men', 'large', 'Dark Hat', 'A dark hat', '5.jpg', '38.50', 105, '2018-01-22 18:18:35'),
(26, 3, 'men', 'large', 'Dark Hat', 'An elaborate, painted dark hat.', '6.jpg', '37.95', 22, '2018-01-22 18:20:59'),
(27, 3, 'men', 'large', 'Grey Grey Hat', 'A Pretty grey hat', '7.jpg', '47.50', 105, '2018-01-22 18:18:35'),
(28, 3, 'men', 'large', 'Grey Hat', 'An elaborate, painted grey hat.', '8.jpg', '87.95', 22, '2018-01-22 18:20:59'),
(29, 3, 'men', 'large', 'Red Hat', 'A Pretty red hat', '9.jpg', '50.50', 105, '2018-01-22 18:18:35'),
(30, 3, 'men', 'large', 'White Hat', 'An elaborate, painted white hat.', '10.jpg', '88.95', 22, '2018-01-22 18:20:59'),
(31, 4, 'men', 'medium', 'Pretty Shoe', 'A pretty grey shoe', '1.jpg', '26.50', 105, '2018-01-22 18:18:35'),
(32, 4, 'men', 'medium', 'Brown Shoe', 'An elaborate, painted brown shoe.', '2.jpg', '87.95', 22, '2018-01-22 18:20:59'),
(33, 4, 'men', 'medium', 'Black Shoe', 'A Pretty black shoe', '3.jpg', '75.50', 105, '2018-01-22 18:18:35'),
(34, 4, 'men', 'medium', 'Brown Shoe', 'An elaborate, painted brown shoe.', '4.jpg', '84.95', 22, '2018-01-22 18:20:59'),
(35, 4, 'men', 'medium', 'Dark Shoe', 'A dark shoe', '5.jpg', '98.50', 105, '2018-01-22 18:18:35'),
(36, 4, 'men', 'medium', 'Dark Shoe', 'An elaborate, painted dark shoe.', '6.jpg', '107.95', 22, '2018-01-22 18:20:59'),
(37, 4, 'men', 'medium', 'Grey Grey Shoe', 'A Pretty grey shoe', '7.jpg', '57.50', 105, '2018-01-22 18:18:35'),
(38, 4, 'men', 'medium', 'Grey Shoe', 'An elaborate, painted grey shoe.', '8.jpg', '37.95', 22, '2018-01-22 18:20:59'),
(39, 4, 'men', 'medium', 'Red Shoe', 'A Pretty red shoe', '9.jpg', '170.50', 105, '2018-01-22 18:18:35'),
(40, 4, 'men', 'small', 'White Shoe', 'An elaborate, painted white shoe.', '10.jpg', '88.95', 22, '2018-01-22 18:20:59'),
(41, 5, 'men', 'large', 'Pretty watch', 'A pretty grey watch', '1.jpg', '126.50', 105, '2018-01-22 18:18:35'),
(42, 5, 'men', 'large', 'Brown watch', 'An elaborate, painted brown watch.', '2.jpg', '157.95', 22, '2018-01-22 18:20:59'),
(43, 5, 'men', 'large', 'Black watch', 'A Pretty black watch', '3.jpg', '165.50', 105, '2018-01-22 18:18:35'),
(44, 5, 'men', 'large', 'Brown watch', 'An elaborate, painted brown watch.', '4.jpg', '124.95', 22, '2018-01-22 18:20:59'),
(45, 5, 'men', 'large', 'Dark watch', 'A dark watch', '5.jpg', '568.50', 105, '2018-01-22 18:18:35'),
(46, 5, 'men', 'large', 'Dark watch', 'An elaborate, painted dark watch.', '6.jpg', '527.95', 22, '2018-01-22 18:20:59'),
(47, 5, 'men', 'large', 'Grey Grey watch', 'A Pretty grey watch', '7.jpg', '237.50', 105, '2018-01-22 18:18:35'),
(48, 5, 'men', 'large', 'Grey Watch', 'An elaborate, painted grey watch.', '8.jpg', '237.95', 22, '2018-01-22 18:20:59'),
(49, 5, 'men', 'large', 'Red Watch', 'A Pretty red watch', '9.jpg', '160.50', 105, '2018-01-22 18:18:35'),
(50, 5, 'men', 'large', 'White Watch', 'An elaborate, painted white watch.', '10.jpg', '89.95', 22, '2018-01-22 18:20:59'),
(51, 1, 'women', 'medium', 'Pretty Tee-shirt', 'A pretty green tee-shirt', '1.jpg', '20.50', 105, '2018-01-22 18:18:35'),
(52, 1, 'women', 'medium', 'Grey Tee-shirt', 'An elaborate, painted grey tee-shirt.', '2.jpg', '27.95', 22, '2018-01-22 18:20:59'),
(53, 1, 'women', 'medium', 'Sky Blue Tee-shirt', 'A Pretty sky blue tee-shirt', '3.jpg', '25.50', 105, '2018-01-22 18:18:35'),
(54, 1, 'women', 'medium', 'White Black Tee-shirt', 'An elaborate, painted white black tee-shirt.', '4.jpg', '24.95', 22, '2018-01-22 18:20:59'),
(55, 1, 'women', 'medium', 'White Tee-shirt', 'A white tee-shirt', '5.jpg', '8.50', 105, '2018-01-22 18:18:35'),
(56, 1, 'women', 'medium', 'Pink Tee-shirt', 'An elaborate, painted pink tee-shirt.', '6.jpg', '27.95', 22, '2018-01-22 18:20:59'),
(57, 1, 'women', 'medium', 'Purple Grey Tee-shirt', 'A Pretty purple tee-shirt', '7.jpg', '27.50', 105, '2018-01-22 18:18:35'),
(58, 1, 'women', 'medium', 'Grey White Tee-shirt', 'An elaborate, painted grey white tee-shirt.', '8.jpg', '37.95', 22, '2018-01-22 18:20:59'),
(59, 1, 'women', 'medium', 'Grey Brown Tee-shirt', 'A Pretty grey brown tee-shirt', '9.jpg', '30.50', 105, '2018-01-22 18:18:35'),
(60, 1, 'women', 'medium', 'Blue Tee-shirt', 'An elaborate, painted blue tee-shirt.', '10.jpg', '98.95', 22, '2018-01-22 18:20:59'),
(61, 2, 'women', 'small', 'Blue Trouser', 'A pretty blue trouser', '1.jpg', '86.50', 105, '2018-01-22 18:18:35'),
(62, 2, 'women', 'small', 'Grey Trouser', 'An elaborate, painted grey Trouser.', '2.jpg', '87.95', 22, '2018-01-22 18:20:59'),
(63, 2, 'women', 'small', 'Blue Trouser', 'A Pretty pink blue', '3.jpg', '75.50', 105, '2018-01-22 18:18:35'),
(64, 2, 'women', 'small', 'Red Trouser', 'An elaborate, painted red Trouser.', '4.jpg', '104.95', 22, '2018-01-22 18:20:59'),
(65, 2, 'women', 'small', 'Blue Trouser', 'A blue skirt', '5.jpg', '128.50', 105, '2018-01-22 18:18:35'),
(66, 2, 'women', 'small', 'Purple Trouser', 'An elaborate, painted purple Trouser.', '6.jpg', '157.95', 22, '2018-01-22 18:20:59'),
(67, 2, 'women', 'small', 'Red Trouser', 'A Pretty red skirt', '7.jpg', '127.50', 105, '2018-01-22 18:18:35'),
(68, 2, 'women', 'small', 'Blue Trouser', 'An elaborate, painted white Trouser.', '8.jpg', '107.95', 22, '2018-01-22 18:20:59'),
(69, 2, 'women', 'small', 'Red Trouser', 'A Pretty red skirt', '9.jpg', '150.50', 105, '2018-01-22 18:18:35'),
(70, 2, 'women', 'small', 'White Trouser', 'An elaborate, painted white Trouser.', '10.jpg', '208.95', 22, '2018-01-22 18:20:59'),
(71, 3, 'women', 'large', 'black Hat', 'A pretty black hat', '1.jpg', '56.50', 105, '2018-01-22 18:18:35'),
(72, 3, 'women', 'large', 'Grey Hat', 'An elaborate, painted grey hat.', '2.jpg', '57.95', 22, '2018-01-22 18:20:59'),
(73, 3, 'women', 'large', 'Purple Hat', 'A Pretty purple hat', '3.jpg', '65.50', 105, '2018-01-22 18:18:35'),
(74, 3, 'women', 'large', 'Pink Hat', 'An elaborate, painted pink hat.', '4.jpg', '44.95', 22, '2018-01-22 18:20:59'),
(75, 3, 'women', 'large', 'Blue Hat', 'A blue hat', '5.jpg', '68.50', 105, '2018-01-22 18:18:35'),
(76, 3, 'women', 'large', 'Black Hat', 'An elaborate, painted black hat.', '6.jpg', '77.95', 22, '2018-01-22 18:20:59'),
(77, 3, 'women', 'large', 'Pink Hat', 'A Pretty pink hat', '7.jpg', '87.50', 105, '2018-01-22 18:18:35'),
(78, 3, 'women', 'large', 'Grey Hat', 'An elaborate, painted grey hat.', '8.jpg', '47.95', 22, '2018-01-22 18:20:59'),
(79, 3, 'women', 'large', 'Brown Hat', 'A Pretty brown hat', '9.jpg', '70.50', 105, '2018-01-22 18:18:35'),
(80, 3, 'women', 'large', 'Blue Hat', 'An elaborate, painted blue hat.', '10.jpg', '88.95', 22, '2018-01-22 18:20:59'),
(81, 4, 'women', 'medium', 'Pink Brown Shoe', 'A pretty pink brown shoe', '1.jpg', '66.50', 105, '2018-01-22 18:18:35'),
(82, 4, 'women', 'medium', 'Black Shoe', 'An elaborate, painted black shoe.', '2.jpg', '47.95', 22, '2018-01-22 18:20:59'),
(83, 4, 'women', 'medium', 'Brown Shoe', 'A Pretty brown shoe', '3.jpg', '95.50', 105, '2018-01-22 18:18:35'),
(84, 4, 'women', 'medium', 'Blue Shoe', 'An elaborate, painted blue shoe.', '4.jpg', '64.95', 22, '2018-01-22 18:20:59'),
(85, 4, 'women', 'medium', 'Black Shoe', 'A black shoe', '5.jpg', '128.50', 105, '2018-01-22 18:18:35'),
(86, 4, 'women', 'medium', 'Pink Shoe', 'An elaborate, painted pink shoe.', '6.jpg', '107.95', 22, '2018-01-22 18:20:59'),
(87, 4, 'women', 'medium', 'Brown White Shoe', 'A Pretty brown white shoe', '7.jpg', '267.50', 105, '2018-01-22 18:18:35'),
(88, 4, 'women', 'medium', 'Grey Shoe', 'An elaborate, painted grey shoe.', '8.jpg', '457.95', 22, '2018-01-22 18:20:59'),
(89, 4, 'women', 'medium', 'White Shoe', 'A Pretty white shoe', '9.jpg', '102.50', 105, '2018-01-22 18:18:35'),
(90, 4, 'women', 'medium', 'Black Shoe', 'An elaborate, painted black shoe.', '10.jpg', '128.95', 22, '2018-01-22 18:20:59'),
(91, 5, 'women', 'large', 'Pretty Necklace', 'A pretty grey necklace', '1.jpg', '56.50', 105, '2018-01-22 18:18:35'),
(92, 5, 'women', 'large', 'Brown Necklace', 'An elaborate, painted brown necklace.', '2.jpg', '97.95', 22, '2018-01-22 18:20:59'),
(93, 5, 'women', 'large', 'Black Necklace', 'A Pretty black necklace', '3.jpg', '65.50', 105, '2018-01-22 18:18:35'),
(94, 5, 'women', 'large', 'Brown Necklace', 'An elaborate, painted brown necklace.', '4.jpg', '84.95', 22, '2018-01-22 18:20:59'),
(95, 5, 'women', 'large', 'Dark Necklace', 'A dark necklace', '5.jpg', '78.50', 105, '2018-01-22 18:18:35'),
(96, 5, 'women', 'large', 'black Necklace', 'An elaborate, painted black necklace.', '6.jpg', '87.95', 22, '2018-01-22 18:20:59'),
(97, 5, 'women', 'large', 'Grey Necklace', 'A Pretty grey necklace', '7.jpg', '67.50', 105, '2018-01-22 18:18:35'),
(98, 5, 'women', 'large', 'Grey Necklace', 'An elaborate, painted grey necklace.', '8.jpg', '77.95', 22, '2018-01-22 18:20:59'),
(99, 5, 'women', 'large', 'Red Necklace', 'A Pretty red necklace', '9.jpg', '120.50', 105, '2018-01-22 18:18:35'),
(100, 5, 'women', 'large', 'White Necklace', 'An elaborate, painted white necklace.', '10.jpg', '258.95', 22, '2018-01-22 18:20:59');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `id` mediumint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` mediumint(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
