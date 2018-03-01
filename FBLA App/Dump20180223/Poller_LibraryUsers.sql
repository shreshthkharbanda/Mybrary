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
-- Table structure for table `LibraryUsers`
--

DROP TABLE IF EXISTS `LibraryUsers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LibraryUsers` (
  `libraryId` int(11) NOT NULL AUTO_INCREMENT,
  `userFirstName` varchar(50) DEFAULT NULL,
  `userLastName` varchar(50) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userPhoneNumber` int(11) DEFAULT NULL,
  `userToken` varchar(300) DEFAULT '0',
  `userRegistrationId` varchar(300) DEFAULT '0',
  PRIMARY KEY (`libraryId`),
  UNIQUE KEY `userId_UNIQUE` (`libraryId`),
  UNIQUE KEY `userEmail_UNIQUE` (`userEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=123457 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibraryUsers`
--

LOCK TABLES `LibraryUsers` WRITE;
/*!40000 ALTER TABLE `LibraryUsers` DISABLE KEYS */;
INSERT INTO `LibraryUsers` VALUES (111112,'Shreshth','Kharbanda','smartyshre@gmail.com','jadook',1234567890,'eMdMGQbWmaQ:APA91bGo6S6pmVjlvA0bON0K79-ISEzGgIqPkiKVtglInLAv-hxg4jWK48a3lv-c_HicLpasy-EGooeEJslxOYvuIp5iErEkdIH-BDrHfZ2m_zjIAAwoyekZZqaWYQxXWERWTxw03D4W','eMdMGQbWmaQ:APA91bGo6S6pmVjlvA0bON0K79-ISEzGgIqPkiKVtglInLAv-hxg4jWK48a3lv-c_HicLpasy-EGooeEJslxOYvuIp5iErEkdIH-BDrHfZ2m_zjIAAwoyekZZqaWYQxXWERWTxw03D4W'),(111113,'Gulshan','Kharbanda','gkharbanda@gmail.com','jadook',1234567890,'fLzrabL5qh8:APA91bGtb-TQ4wIsORFvGn70rBIQFQf4zuNNuFHA8C8sW-GNYqYGviRsrErnXsFCT1vvJjrP_tfw2baMlQqoxXDH3eoM83HAdrg-89nCsewCVz6KkOO6F_Ldl0BS1DMSnvtjuIurfrGl','fLzrabL5qh8:APA91bGtb-TQ4wIsORFvGn70rBIQFQf4zuNNuFHA8C8sW-GNYqYGviRsrErnXsFCT1vvJjrP_tfw2baMlQqoxXDH3eoM83HAdrg-89nCsewCVz6KkOO6F_Ldl0BS1DMSnvtjuIurfrGl'),(111114,'Shilpi','Kharbanda','shilpikharbanda@gmail.com','jadook',1234567890,NULL,NULL),(111115,'Kashish','Kharbanda','kashish22us@gmail.com','jadook',1234567890,NULL,NULL),(111116,'Anurag','Wahi','anuwahi@gmail.com','jadook',1234567890,NULL,NULL),(111117,'Shikha','Wahi','swahi@gmail.com','jadook',1234567890,NULL,NULL),(111118,'Om Prakash','Wahi','omprakash@gmail.com','jadook',1234567890,NULL,NULL),(111119,'Lalita','Wahi','lalitaw@gmail.com','jadook',1234567890,NULL,NULL),(111121,'Vishal','Rana','vrana@gmail.com','vishal',1234567890,NULL,NULL),(111122,'Nidhi','Rana','nrana@gmail.com','nidhi',1234567890,NULL,NULL),(111123,'Desi','Faltoo','desifaltoo@gmail.com','jadook',1234567890,NULL,NULL),(111224,'Saksham','Wahi','saksham@gmail.com','saksham',1234567890,NULL,NULL),(123456,'myname','last','myemail@whatever.com','mypassword',1234567890,NULL,NULL);
/*!40000 ALTER TABLE `LibraryUsers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-23 20:51:04
