-- phpMyAdmin SQL Dump
-- http://www.phpmyadmin.net
--
-- 生成日期: 2013 年 11 月 30 日 00:18

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `ybOxfzZbYWcQsTKYVrDk`
--

-- --------------------------------------------------------

--
-- 表的结构 `tb_applicant`
--

CREATE TABLE IF NOT EXISTS `tb_applicant` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `applicantName` varchar(128) NOT NULL,
  `applyDate` date NOT NULL,
  `referrerName` varchar(128) NOT NULL,
  `creditCardNumber` varchar(64) NOT NULL,
  `memberType` varchar(64) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `ModifiedDate` datetime NOT NULL,
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0',
  `status` varchar(45) NOT NULL DEFAULT 'todo',
  `IsMember` bit(1) NOT NULL DEFAULT b'0',
  `IsReferrerTrue` bit(1) NOT NULL DEFAULT b'0',
  `applicantEmail` varchar(45) NOT NULL DEFAULT 'example@example.com',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

--
-- 转存表中的数据 `tb_applicant`
--

INSERT INTO `tb_applicant` (`ID`, `applicantName`, `applyDate`, `referrerName`, `creditCardNumber`, `memberType`, `CreatedDate`, `ModifiedDate`, `IsDeleted`, `status`, `IsMember`, `IsReferrerTrue`, `applicantEmail`) VALUES
(4, '冯飞', '2013-11-07', '朱枫翔', '320106', 'B等會員', '2013-11-08 23:51:49', '2013-11-22 18:00:11', b'0', 'additionalInfo', b'0', b'0', 'example@example.com'),
(5, 'Yui', '2013-10-28', 'Rio', 'Love', 'A等會員', '2013-11-09 08:23:33', '2013-11-13 00:21:14', b'0', 'accept', b'1', b'0', 'example@example.com'),
(10, 'FF', '2013-11-09', 'ZFX', 'credit', 'A等會員', '2013-11-09 10:50:19', '2013-11-18 19:23:47', b'0', 'accept', b'1', b'0', 'example@example.com'),
(11, '翔子', '2013-11-08', '静宇翔', '820', 'B等會員', '2013-11-11 17:45:11', '2013-11-11 17:45:11', b'0', 'todo', b'1', b'0', 'example@example.com'),
(16, '肥肥飞', '2013-11-03', '组织者', '330', 'A等會員', '2013-11-12 23:16:43', '2013-11-22 18:00:11', b'0', 'accept', b'1', b'0', 'example@example.com'),
(17, 'ChengBo', '2013-11-13', '冯飞', '56778', 'A等會員', '2013-11-13 08:55:30', '2013-11-22 17:57:39', b'0', 'accept', b'1', b'0', 'example@example.com'),
(18, 'ChengBo', '2013-11-13', '冯飞', '56778', 'A等會員', '2013-11-13 08:55:35', '2013-11-22 18:00:11', b'0', 'todo', b'0', b'0', 'example@example.com'),
(19, '朱枫翔', '2013-11-01', '大业', '330', 'A等會員', '2013-11-13 22:40:07', '2013-11-22 18:00:11', b'0', 'defer', b'0', b'0', 'example@example.com'),
(44, 'Yan', '2013-11-23', '飞飞', '1234567890', 'A等會員', '2013-11-23 22:15:50', '2013-11-23 22:15:50', b'0', 'todo', b'0', b'0', 'example@example.com');

-- --------------------------------------------------------

--
-- 表的结构 `tb_event`
--

CREATE TABLE IF NOT EXISTS `tb_event` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `cssClass` varchar(60) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `url` varchar(128) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `ModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=93 ;

--
-- 转存表中的数据 `tb_event`
--

INSERT INTO `tb_event` (`ID`, `title`, `cssClass`, `start`, `end`, `url`, `CreatedDate`, `ModifiedDate`) VALUES
(1, 'cleaning time', 'event-special', '2013-11-01 00:00:00', '2013-11-01 23:00:00', '../Reservation/Reserve?startTime=1383235200000&endTime=1383318000000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(2, 'cleaning time', 'event-special', '2013-11-02 00:00:00', '2013-11-02 23:00:00', '../Reservation/Reserve?startTime=1383321600000&endTime=1383404400000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(3, 'cleaning time', 'event-special', '2013-11-03 00:00:00', '2013-11-03 23:00:00', '../Reservation/Reserve?startTime=1383408000000&endTime=1383490800000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(4, 'cleaning time', 'event-special', '2013-11-04 00:00:00', '2013-11-04 23:00:00', '../Reservation/Reserve?startTime=1383494400000&endTime=1383577200000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(5, 'cleaning time', 'event-special', '2013-11-05 00:00:00', '2013-11-05 23:00:00', '../Reservation/Reserve?startTime=1383580800000&endTime=1383663600000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(6, 'Empty', 'event-success', '2013-11-06 00:00:00', '2013-11-06 23:00:00', '../Reservation/Reserve?startTime=1383667200000&endTime=1383750000000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(7, 'Empty', 'event-success', '2013-11-07 00:00:00', '2013-11-07 23:00:00', '../Reservation/Reserve?startTime=1383753600000&endTime=1383836400000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(8, 'Empty', 'event-success', '2013-11-08 00:00:00', '2013-11-08 23:00:00', '../Reservation/Reserve?startTime=1383840000000&endTime=1383922800000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(9, 'Empty', 'event-success', '2013-11-09 00:00:00', '2013-11-09 23:00:00', '../Reservation/Reserve?startTime=1383926400000&endTime=1384009200000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(10, 'Empty', 'event-success', '2013-11-10 00:00:00', '2013-11-10 23:00:00', '../Reservation/Reserve?startTime=1384012800000&endTime=1384095600000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(11, 'Empty', 'event-success', '2013-11-11 00:00:00', '2013-11-11 23:00:00', '../Reservation/Reserve?startTime=1384099200000&endTime=1384182000000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(12, 'Empty', 'event-success', '2013-11-12 00:00:00', '2013-11-12 23:00:00', '../Reservation/Reserve?startTime=1384185600000&endTime=1384268400000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(13, 'Empty', 'event-success', '2013-11-13 00:00:00', '2013-11-13 23:00:00', '../Reservation/Reserve?startTime=1384272000000&endTime=1384354800000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(14, 'Empty', 'event-success', '2013-11-14 00:00:00', '2013-11-14 23:00:00', '../Reservation/Reserve?startTime=1384358400000&endTime=1384441200000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(15, 'Empty', 'event-success', '2013-11-15 00:00:00', '2013-11-15 23:00:00', '../Reservation/Reserve?startTime=1384444800000&endTime=1384527600000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(16, 'Empty', 'event-success', '2013-11-16 00:00:00', '2013-11-16 23:00:00', '../Reservation/Reserve?startTime=1384531200000&endTime=1384614000000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(17, 'Empty', 'event-success', '2013-11-17 00:00:00', '2013-11-17 23:00:00', '../Reservation/Reserve?startTime=1384617600000&endTime=1384700400000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(18, 'half full', 'event-warning', '2013-11-18 00:00:00', '2013-11-18 23:00:00', '../Reservation/Reserve?startTime=1384704000000&endTime=1384786800000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(19, 'full', 'event-important', '2013-11-19 00:00:00', '2013-11-19 23:00:00', '###', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(20, 'Empty', 'event-success', '2013-11-20 00:00:00', '2013-11-20 23:00:00', '../Reservation/Reserve?startTime=1384876800000&endTime=1384959600000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(21, 'Empty', 'event-success', '2013-11-21 00:00:00', '2013-11-21 23:00:00', '../Reservation/Reserve?startTime=1384963200000&endTime=1385046000000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(22, 'Empty', 'event-success', '2013-11-22 00:00:00', '2013-11-22 23:00:00', '../Reservation/Reserve?startTime=1385049600000&endTime=1385132400000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(23, 'Empty', 'event-success', '2013-11-23 00:00:00', '2013-11-23 23:00:00', '../Reservation/Reserve?startTime=1385136000000&endTime=1385218800000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(24, 'Empty', 'event-success', '2013-11-24 00:00:00', '2013-11-24 23:00:00', '../Reservation/Reserve?startTime=1385222400000&endTime=1385305200000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(25, 'cleaning time', 'event-special', '2013-11-25 00:00:00', '2013-11-25 23:00:00', '../Reservation/Reserve?startTime=1385308800000&endTime=1385391600000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(26, 'cleaning time', 'event-special', '2013-11-26 00:00:00', '2013-11-26 23:00:00', '../Reservation/Reserve?startTime=1385395200000&endTime=1385478000000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(27, 'Empty', 'event-success', '2013-11-27 00:00:00', '2013-11-27 23:00:00', '../Reservation/Reserve?startTime=1385481600000&endTime=1385564400000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(28, 'half full', 'event-warning', '2013-11-28 00:00:00', '2013-11-28 23:00:00', '../Reservation/Reserve?startTime=1385568000000&endTime=1385650800000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(29, 'Empty', 'event-success', '2013-11-29 00:00:00', '2013-11-29 23:00:00', '../Reservation/Reserve?startTime=1385654400000&endTime=1385737200000', '2013-11-19 01:37:14', '2013-11-19 01:37:14'),
(30, 'Empty', 'event-success', '2013-11-30 00:00:00', '2013-11-30 23:00:00', '../Reservation/Reserve?startTime=1385740800000&endTime=1385823600000', '2013-11-19 01:37:15', '2013-11-19 01:37:15'),
(31, 'Empty', 'event-success', '2013-12-01 00:00:00', '2013-12-01 23:00:00', '../Reservation/Reserve?startTime=1385827200000&endTime=1385910000000', '2013-11-19 01:37:17', '2013-11-19 01:37:17'),
(32, 'Empty', 'event-success', '2013-12-02 00:00:00', '2013-12-02 23:00:00', '../Reservation/Reserve?startTime=1385913600000&endTime=1385996400000', '2013-11-19 01:37:17', '2013-11-19 01:37:17'),
(33, 'Empty', 'event-success', '2013-12-03 00:00:00', '2013-12-03 23:00:00', '../Reservation/Reserve?startTime=1386000000000&endTime=1386082800000', '2013-11-19 01:37:17', '2013-11-19 01:37:17'),
(34, 'Empty', 'event-success', '2013-12-04 00:00:00', '2013-12-04 23:00:00', '../Reservation/Reserve?startTime=1386086400000&endTime=1386169200000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(35, 'Empty', 'event-success', '2013-12-05 00:00:00', '2013-12-05 23:00:00', '../Reservation/Reserve?startTime=1386172800000&endTime=1386255600000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(36, 'Empty', 'event-success', '2013-12-06 00:00:00', '2013-12-06 23:00:00', '../Reservation/Reserve?startTime=1386259200000&endTime=1386342000000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(37, 'Empty', 'event-success', '2013-12-07 00:00:00', '2013-12-07 23:00:00', '../Reservation/Reserve?startTime=1386345600000&endTime=1386428400000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(38, 'Empty', 'event-success', '2013-12-08 00:00:00', '2013-12-08 23:00:00', '../Reservation/Reserve?startTime=1386432000000&endTime=1386514800000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(39, 'Empty', 'event-success', '2013-12-09 00:00:00', '2013-12-09 23:00:00', '../Reservation/Reserve?startTime=1386518400000&endTime=1386601200000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(40, 'Empty', 'event-success', '2013-12-10 00:00:00', '2013-12-10 23:00:00', '../Reservation/Reserve?startTime=1386604800000&endTime=1386687600000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(41, 'Empty', 'event-success', '2013-12-11 00:00:00', '2013-12-11 23:00:00', '../Reservation/Reserve?startTime=1386691200000&endTime=1386774000000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(42, 'Empty', 'event-success', '2013-12-12 00:00:00', '2013-12-12 23:00:00', '../Reservation/Reserve?startTime=1386777600000&endTime=1386860400000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(43, 'Empty', 'event-success', '2013-12-13 00:00:00', '2013-12-13 23:00:00', '../Reservation/Reserve?startTime=1386864000000&endTime=1386946800000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(44, 'Empty', 'event-success', '2013-12-14 00:00:00', '2013-12-14 23:00:00', '../Reservation/Reserve?startTime=1386950400000&endTime=1387033200000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(45, 'Empty', 'event-success', '2013-12-15 00:00:00', '2013-12-15 23:00:00', '../Reservation/Reserve?startTime=1387036800000&endTime=1387119600000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(46, 'Empty', 'event-success', '2013-12-16 00:00:00', '2013-12-16 23:00:00', '../Reservation/Reserve?startTime=1387123200000&endTime=1387206000000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(47, 'Empty', 'event-success', '2013-12-17 00:00:00', '2013-12-17 23:00:00', '../Reservation/Reserve?startTime=1387209600000&endTime=1387292400000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(48, 'Empty', 'event-success', '2013-12-18 00:00:00', '2013-12-18 23:00:00', '../Reservation/Reserve?startTime=1387296000000&endTime=1387378800000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(49, 'Empty', 'event-success', '2013-12-19 00:00:00', '2013-12-19 23:00:00', '../Reservation/Reserve?startTime=1387382400000&endTime=1387465200000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(50, 'Empty', 'event-success', '2013-12-20 00:00:00', '2013-12-20 23:00:00', '../Reservation/Reserve?startTime=1387468800000&endTime=1387551600000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(51, 'Empty', 'event-success', '2013-12-21 00:00:00', '2013-12-21 23:00:00', '../Reservation/Reserve?startTime=1387555200000&endTime=1387638000000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(52, 'Empty', 'event-success', '2013-12-22 00:00:00', '2013-12-22 23:00:00', '../Reservation/Reserve?startTime=1387641600000&endTime=1387724400000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(53, 'Empty', 'event-success', '2013-12-23 00:00:00', '2013-12-23 23:00:00', '../Reservation/Reserve?startTime=1387728000000&endTime=1387810800000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(54, 'Empty', 'event-success', '2013-12-24 00:00:00', '2013-12-24 23:00:00', '../Reservation/Reserve?startTime=1387814400000&endTime=1387897200000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(55, 'Empty', 'event-success', '2013-12-25 00:00:00', '2013-12-25 23:00:00', '../Reservation/Reserve?startTime=1387900800000&endTime=1387983600000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(56, 'Empty', 'event-success', '2013-12-26 00:00:00', '2013-12-26 23:00:00', '../Reservation/Reserve?startTime=1387987200000&endTime=1388070000000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(57, 'Empty', 'event-success', '2013-12-27 00:00:00', '2013-12-27 23:00:00', '../Reservation/Reserve?startTime=1388073600000&endTime=1388156400000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(58, 'Empty', 'event-success', '2013-12-28 00:00:00', '2013-12-28 23:00:00', '../Reservation/Reserve?startTime=1388160000000&endTime=1388242800000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(59, 'Empty', 'event-success', '2013-12-29 00:00:00', '2013-12-29 23:00:00', '../Reservation/Reserve?startTime=1388246400000&endTime=1388329200000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(60, 'Empty', 'event-success', '2013-12-30 00:00:00', '2013-12-30 23:00:00', '../Reservation/Reserve?startTime=1388332800000&endTime=1388415600000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(61, 'Empty', 'event-success', '2013-12-31 00:00:00', '2013-12-31 23:00:00', '../Reservation/Reserve?startTime=1388419200000&endTime=1388502000000', '2013-11-19 01:37:18', '2013-11-19 01:37:18'),
(62, 'Empty', 'event-success', '2013-10-01 00:00:00', '2013-10-01 23:00:00', '../Reservation/Reserve?startTime=1380556800000&endTime=1380639600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(63, 'Empty', 'event-success', '2013-10-02 00:00:00', '2013-10-02 23:00:00', '../Reservation/Reserve?startTime=1380643200000&endTime=1380726000000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(64, 'Empty', 'event-success', '2013-10-03 00:00:00', '2013-10-03 23:00:00', '../Reservation/Reserve?startTime=1380729600000&endTime=1380812400000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(65, 'Empty', 'event-success', '2013-10-04 00:00:00', '2013-10-04 23:00:00', '../Reservation/Reserve?startTime=1380816000000&endTime=1380898800000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(66, 'Empty', 'event-success', '2013-10-05 00:00:00', '2013-10-05 23:00:00', '../Reservation/Reserve?startTime=1380902400000&endTime=1380985200000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(67, 'Empty', 'event-success', '2013-10-06 00:00:00', '2013-10-06 23:00:00', '../Reservation/Reserve?startTime=1380988800000&endTime=1381071600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(68, 'Empty', 'event-success', '2013-10-07 00:00:00', '2013-10-07 23:00:00', '../Reservation/Reserve?startTime=1381075200000&endTime=1381158000000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(69, 'Empty', 'event-success', '2013-10-08 00:00:00', '2013-10-08 23:00:00', '../Reservation/Reserve?startTime=1381161600000&endTime=1381244400000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(70, 'Empty', 'event-success', '2013-10-09 00:00:00', '2013-10-09 23:00:00', '../Reservation/Reserve?startTime=1381248000000&endTime=1381330800000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(71, 'Empty', 'event-success', '2013-10-10 00:00:00', '2013-10-10 23:00:00', '../Reservation/Reserve?startTime=1381334400000&endTime=1381417200000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(72, 'Empty', 'event-success', '2013-10-11 00:00:00', '2013-10-11 23:00:00', '../Reservation/Reserve?startTime=1381420800000&endTime=1381503600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(73, 'Empty', 'event-success', '2013-10-12 00:00:00', '2013-10-12 23:00:00', '../Reservation/Reserve?startTime=1381507200000&endTime=1381590000000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(74, 'Empty', 'event-success', '2013-10-13 00:00:00', '2013-10-13 23:00:00', '../Reservation/Reserve?startTime=1381593600000&endTime=1381676400000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(75, 'Empty', 'event-success', '2013-10-14 00:00:00', '2013-10-14 23:00:00', '../Reservation/Reserve?startTime=1381680000000&endTime=1381762800000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(76, 'Empty', 'event-success', '2013-10-15 00:00:00', '2013-10-15 23:00:00', '../Reservation/Reserve?startTime=1381766400000&endTime=1381849200000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(77, 'Empty', 'event-success', '2013-10-16 00:00:00', '2013-10-16 23:00:00', '../Reservation/Reserve?startTime=1381852800000&endTime=1381935600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(78, 'Empty', 'event-success', '2013-10-17 00:00:00', '2013-10-17 23:00:00', '../Reservation/Reserve?startTime=1381939200000&endTime=1382022000000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(79, 'Empty', 'event-success', '2013-10-18 00:00:00', '2013-10-18 23:00:00', '../Reservation/Reserve?startTime=1382025600000&endTime=1382108400000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(80, 'Empty', 'event-success', '2013-10-19 00:00:00', '2013-10-19 23:00:00', '../Reservation/Reserve?startTime=1382112000000&endTime=1382194800000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(81, 'Empty', 'event-success', '2013-10-20 00:00:00', '2013-10-20 23:00:00', '../Reservation/Reserve?startTime=1382198400000&endTime=1382281200000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(82, 'Empty', 'event-success', '2013-10-21 00:00:00', '2013-10-21 23:00:00', '../Reservation/Reserve?startTime=1382284800000&endTime=1382367600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(83, 'Empty', 'event-success', '2013-10-22 00:00:00', '2013-10-22 23:00:00', '../Reservation/Reserve?startTime=1382371200000&endTime=1382454000000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(84, 'Empty', 'event-success', '2013-10-23 00:00:00', '2013-10-23 23:00:00', '../Reservation/Reserve?startTime=1382457600000&endTime=1382540400000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(85, 'Empty', 'event-success', '2013-10-24 00:00:00', '2013-10-24 23:00:00', '../Reservation/Reserve?startTime=1382544000000&endTime=1382626800000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(86, 'Empty', 'event-success', '2013-10-25 00:00:00', '2013-10-25 23:00:00', '../Reservation/Reserve?startTime=1382630400000&endTime=1382713200000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(87, 'Empty', 'event-success', '2013-10-26 00:00:00', '2013-10-26 23:00:00', '../Reservation/Reserve?startTime=1382716800000&endTime=1382799600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(88, 'Empty', 'event-success', '2013-10-27 00:00:00', '2013-10-27 23:00:00', '../Reservation/Reserve?startTime=1382803200000&endTime=1382886000000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(89, 'Empty', 'event-success', '2013-10-28 00:00:00', '2013-10-28 23:00:00', '../Reservation/Reserve?startTime=1382889600000&endTime=1382972400000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(90, 'Empty', 'event-success', '2013-10-29 00:00:00', '2013-10-29 23:00:00', '../Reservation/Reserve?startTime=1382976000000&endTime=1383058800000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(91, 'Empty', 'event-success', '2013-10-30 00:00:00', '2013-10-30 23:00:00', '../Reservation/Reserve?startTime=1383062400000&endTime=1383145200000', '2013-11-19 19:21:51', '2013-11-19 19:21:51'),
(92, 'Empty', 'event-success', '2013-10-31 00:00:00', '2013-10-31 23:00:00', '../Reservation/Reserve?startTime=1383148800000&endTime=1383231600000', '2013-11-19 19:21:51', '2013-11-19 19:21:51');

-- --------------------------------------------------------

--
-- 表的结构 `tb_field`
--

CREATE TABLE IF NOT EXISTS `tb_field` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `status` varchar(128) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `ModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=838 ;

--
-- 转存表中的数据 `tb_field`
--

INSERT INTO `tb_field` (`ID`, `start`, `end`, `status`, `CreatedDate`, `ModifiedDate`) VALUES
(1, '2013-11-25 00:00:00', '2013-11-26 00:00:00', '', '2013-11-23 22:28:05', '2013-11-23 22:28:05'),
(2, '2013-11-19 01:33:34', '2013-11-19 01:33:34', '', '2013-11-19 01:33:34', '2013-11-19 01:33:34'),
(3, '2013-11-19 01:33:34', '2013-11-19 01:33:34', '', '2013-11-19 01:33:34', '2013-11-19 01:33:34'),
(4, '2013-11-19 01:33:34', '2013-11-19 01:33:34', '', '2013-11-19 01:33:34', '2013-11-19 01:33:34'),
(5, '2013-11-19 01:33:34', '2013-11-19 01:33:34', '', '2013-11-19 01:33:34', '2013-11-19 01:33:34'),
(6, '2013-11-19 01:33:34', '2013-11-19 01:33:34', '', '2013-11-19 01:33:34', '2013-11-19 01:33:34'),
(7, '2013-11-19 01:33:35', '2013-11-19 01:33:35', '', '2013-11-19 01:33:35', '2013-11-19 01:33:35'),
(8, '2013-11-19 01:33:35', '2013-11-19 01:33:35', '', '2013-11-19 01:33:35', '2013-11-19 01:33:35'),
(9, '2013-11-19 01:33:35', '2013-11-19 01:33:35', '', '2013-11-19 01:33:35', '2013-11-19 01:33:35'),
(10, '2013-11-01 00:00:00', '2013-11-05 00:00:00', '', '2013-11-19 01:37:37', '2013-11-19 01:37:37');

-- --------------------------------------------------------

--
-- 表的结构 `tb_reservation`
--

CREATE TABLE IF NOT EXISTS `tb_reservation` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberIDFK` bigint(20) NOT NULL,
  `fieldIDFK` varchar(60) DEFAULT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `status` varchar(128) NOT NULL,
  `weather` varchar(128) DEFAULT NULL,
  `event` varchar(128) DEFAULT NULL,
  `CreatedDate` datetime NOT NULL,
  `ModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=855 ;

--
-- 转存表中的数据 `tb_reservation`
--

INSERT INTO `tb_reservation` (`ID`, `memberIDFK`, `fieldIDFK`, `start`, `end`, `status`, `weather`, `event`, `CreatedDate`, `ModifiedDate`) VALUES
(849, 820, NULL, '2013-11-19 00:00:00', '2013-11-19 12:00:00', '申請中', '', '', '2013-11-19 02:44:04', '2013-11-19 02:44:04'),
(850, 666, NULL, '2013-11-19 00:00:00', '2013-11-20 00:00:00', '申請中', '', '', '2013-11-19 02:54:59', '2013-11-19 02:54:59'),
(851, 830, NULL, '2013-11-19 00:00:00', '2013-11-20 00:00:00', '通過', '', '', '2013-11-19 02:55:30', '2013-11-19 02:55:30'),
(852, 830, NULL, '2013-11-18 00:00:00', '2013-11-18 12:00:00', '申請中', '', '', '2013-11-19 02:55:42', '2013-11-19 02:55:42'),
(853, 1, NULL, '2013-11-19 00:00:00', '2013-11-26 00:00:00', '通過', '', '', '2013-11-19 19:16:37', '2013-11-19 19:16:37'),
(854, 880, NULL, '2013-11-28 00:00:00', '2013-11-28 15:00:00', '申請中', NULL, NULL, '2013-11-23 22:35:21', '2013-11-23 22:35:21');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
