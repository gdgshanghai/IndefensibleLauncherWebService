CREATE DATABASE  IF NOT EXISTS `membership` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `membership`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: membership
-- ------------------------------------------------------
-- Server version	5.6.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_url_collection`
--

DROP TABLE IF EXISTS `tb_url_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_url_collection` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `URL` varchar(128) NOT NULL,
  `Type` varchar(60) NOT NULL,
  `CreatedDate` datetime NOT NULL,
  `ModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `URL_UNIQUE` (`URL`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_url_collection`
--

LOCK TABLES `tb_url_collection` WRITE;
/*!40000 ALTER TABLE `tb_url_collection` DISABLE KEYS */;
INSERT INTO `tb_url_collection` VALUES (1,'yyets.com','HOME','2014-04-27 16:11:45','2014-04-27 16:11:45'),(2,'mingdao.com','WORK','2014-04-27 16:11:46','2014-04-27 16:11:46'),(3,'sina.com.cn','NEWS','2014-04-27 16:11:47','2014-04-27 16:11:47'),(4,'stackoverflow.com','WORK','2014-04-27 16:11:47','2014-04-27 16:11:47'),(5,'news.163.com','NEWS','2014-04-27 16:11:47','2014-04-27 16:11:47'),(6,'plus.google.com','SOCIAL','2014-04-27 16:11:47','2014-04-27 16:11:47'),(7,'engadget.com','NEWS','2014-04-27 16:11:47','2014-04-27 16:11:47'),(8,'github.com','WORK','2014-04-27 16:11:47','2014-04-27 16:11:47'),(9,'bilibili.kankanews.com','HOME','2014-04-27 16:11:47','2014-04-27 16:11:47'),(10,'renren.com','SOCIAL','2014-04-27 16:11:47','2014-04-27 16:11:47'),(11,'drive.google.com','WORK','2014-04-27 16:11:47','2014-04-27 16:11:47'),(12,'yhd.com','SHOPPING','2014-04-27 16:11:47','2014-04-27 16:11:47'),(13,'facebook.com','SOCIAL','2014-04-27 16:11:48','2014-04-27 16:11:48'),(14,'36kr.com','NEWS','2014-04-27 16:11:48','2014-04-27 16:11:48'),(15,'mail.google.com','WORK','2014-04-27 16:11:48','2014-04-27 16:11:48'),(16,'pingwest.com','NEWS','2014-04-27 16:11:48','2014-04-27 16:11:48'),(17,'twitter.com','SOCIAL','2014-04-27 16:11:48','2014-04-27 16:11:48'),(18,'wallet.google.com','FINANCE','2014-04-27 16:11:48','2014-04-27 16:11:48'),(19,'jd.com','SHOPPING','2014-04-27 16:11:48','2014-04-27 16:11:48'),(20,'wx.qq.com','SOCIAL','2014-04-27 16:11:48','2014-04-27 16:11:48'),(21,'alipay.com','FINANCE','2014-04-27 16:11:48','2014-04-27 16:11:48'),(22,'accounts.google.com','SOCIAL','2014-04-27 16:11:48','2014-04-27 16:11:48'),(23,'taobao.com','HOME','2014-04-27 16:11:48','2014-04-27 16:11:48'),(24,'news.qq.com','NEWS','2014-04-27 16:11:49','2014-04-27 16:11:49'),(25,'weibo.com','SOCIAL','2014-04-27 16:11:49','2014-04-27 16:11:49'),(26,'boc.cn','FINANCE','2014-04-27 16:11:49','2014-04-27 16:11:49'),(27,'zhihu.com','SOCIAL','2014-04-27 16:11:49','2014-04-27 16:11:49'),(28,'bilibili.tv','HOME','2014-04-27 16:11:49','2014-04-27 16:11:49'),(29,'google.com','WORK','2014-04-27 16:11:49','2014-04-27 16:11:49'),(30,'news.dbanotes.net','NEWS','2014-04-27 16:11:49','2014-04-27 16:11:49'),(31,'mojichina.com','HOME','2014-04-27 16:11:49','2014-04-27 16:11:49'),(32,'tmall.com','SHOPPING','2014-04-27 16:11:49','2014-04-27 16:11:49'),(33,'youku.com','HOME','2014-04-27 16:11:49','2014-04-27 16:11:49'),(34,'icbc.com.cn','FINANCE','2014-04-27 16:11:49','2014-04-27 16:11:49'),(35,'mi.com','SHOPPING','2014-04-27 21:05:42','2014-04-27 21:05:42');
/*!40000 ALTER TABLE `tb_url_collection` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-01  9:22:43
