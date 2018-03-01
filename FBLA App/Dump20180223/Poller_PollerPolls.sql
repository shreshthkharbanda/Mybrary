CREATE DATABASE  IF NOT EXISTS `Poller` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Poller`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 52.41.161.91    Database: Poller
-- ------------------------------------------------------
-- Server version	5.5.46

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
-- Table structure for table `PollerPolls`
--

DROP TABLE IF EXISTS `PollerPolls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PollerPolls` (
  `idPoller` int(10) unsigned NOT NULL,
  `pollText` varchar(100) NOT NULL,
  `pollOpt1` varchar(45) NOT NULL,
  `pollOpt1Img` longtext,
  `pollOpt2` varchar(45) NOT NULL,
  `pollOpt2Img` longtext,
  `pollOpt3` varchar(45) DEFAULT NULL,
  `pollOpt3Img` longtext,
  `pollOpt4` varchar(45) DEFAULT NULL,
  `pollOpt4Img` longtext,
  `pollOpt5` varchar(45) DEFAULT NULL,
  `pollOpt5Img` longtext,
  `pollOpt6` varchar(45) DEFAULT NULL,
  `pollOpt6Img` longtext,
  `pollOpt7` varchar(45) DEFAULT NULL,
  `pollOpt7Img` longtext,
  `pollOpt8` varchar(45) DEFAULT NULL,
  `pollOpt8Img` longtext,
  `pollOpt9` varchar(45) DEFAULT NULL,
  `pollOpt9Img` longtext,
  `pollOpt10` varchar(45) DEFAULT NULL,
  `pollOpt10Img` longtext,
  `pollBy` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPoller`,`pollText`,`pollOpt1`,`pollOpt2`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PollerPolls`
--

LOCK TABLES `PollerPolls` WRITE;
/*!40000 ALTER TABLE `PollerPolls` DISABLE KEYS */;
INSERT INTO `PollerPolls` VALUES (1,'Which restaurant?','chipotle','http://www.coloradanmagazine.org/wp-content/uploads/2011/08/timeline_1993_chipotle_sign-150x150.jpg','subway','http://tamcom.tamarindocom.netdna-cdn.com/wp-content/uploads/2011/08/subway-150x150.jpg','panda express','http://lifewithkathy.com/wp-content/uploads/2012/04/25577-150x150.jpg','McDonald\'s','http://thecfim.com/wp-content/uploads/2016/03/mcdonalds-150x150.jpg','Jimmy John\'s','http://investorplace.com/wp-content/uploads/2015/05/jimmy-johns-logo-150x150.jpeg','Chilli\'s','http://logok.org/wp-content/uploads/2014/10/Chills-logo-150x150.png','Viatnamese','http://www.foursistersrestaurant.com/img/foursisters_logo.jpg','Burger King','http://vignette2.wikia.nocookie.net/logosfake/images/a/a4/BK_Anglosaw_Nadrid_attacks.png/revision/latest/scale-to-width-down/147?cb=20160315030120','Taco Bell','http://cdn.phillymag.com/wp-content/uploads/sites/3/2015/05/Taco-bell-150x150.jpg','Dominos','http://www.lanmo.lk/gallery/2000px-Dominos_pizza_logo.svg.png','~skharbanda'),(2,'Which channel?','CNN','http://hd-report.com/wp-content/uploads/2010/03/cnn_hd_logo_sq-150x150.jpg','Fox News','http://www.independentsentinel.com/wp-content/uploads/2016/05/fox-150x150.png','PBS','http://www.wcny.org/wp-content/uploads/2013/06/20130611_logos_pbskidsplay.jpg','CBS','http://illuminatisymbols.info/wp-content/uploads/2013/02/cbs-logo.png','ABC','http://logok.org/wp-content/uploads/2014/03/abc-gold-logo.png','Comedy Central','http://vignette3.wikia.nocookie.net/logopedia/images/d/d3/Comedy_Central_Logo.png/revision/latest?cb=20150109120103','Disney','http://dalaigroup.com/wp-content/uploads/2013/01/Disney-100x100.png','espn','https://i1.sndcdn.com/artworks-000134181389-qr1uko-large.jpg','QVC','http://koutokuji.main.jp/wp/wp-content/uploads/2014/03/15qvc.jpg','NBC','https://static1.squarespace.com/static/54d299f7e4b0c2c49c8e5abb/582cc48637c581a8c426b53e/582cd6cb579fb314427e2ab8/1479333610271/NBC+Logo.jpg?format=100w','~kashish2001');
/*!40000 ALTER TABLE `PollerPolls` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-23 20:51:03
