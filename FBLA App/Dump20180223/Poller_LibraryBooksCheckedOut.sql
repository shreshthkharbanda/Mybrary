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
-- Table structure for table `LibraryBooksCheckedOut`
--

DROP TABLE IF EXISTS `LibraryBooksCheckedOut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LibraryBooksCheckedOut` (
  `checkedOutId` int(11) NOT NULL,
  `bookTitle` longtext,
  `bookId` varchar(45) DEFAULT NULL,
  `userName` mediumtext,
  `userEmail` varchar(45) DEFAULT NULL,
  `libraryId` varchar(45) DEFAULT NULL,
  `dateCheckedOut` date DEFAULT NULL,
  `dateDue` date DEFAULT NULL,
  `likes` varchar(45) NOT NULL DEFAULT '0',
  `booleanLiked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`checkedOutId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibraryBooksCheckedOut`
--

LOCK TABLES `LibraryBooksCheckedOut` WRITE;
/*!40000 ALTER TABLE `LibraryBooksCheckedOut` DISABLE KEYS */;
INSERT INTO `LibraryBooksCheckedOut` VALUES (1,'A first look at communication theory (4th edition)','1','Shreshth Kharbanda','smartyshre@gmail.com','111112','2018-02-23','2018-03-23','7868',1),(2,'A measure of freedom','2','Shreshth Kharbanda','smartyshre@gmail.com','111112','2018-02-23','2018-03-23','941',0),(3,'Analyzing everyday texts: discourse, rhetoric and social perspectives','3','Shreshth Kharbanda','smartyshre@gmail.com','111112','2018-02-23','2018-03-23','227',1),(4,'Applied data communications: a business oriented approach (2nd edition)','4','Shreshth Kharbanda','smartyshre@gmail.com','111112','2018-02-23','2018-03-23','451',1),(5,'Artificial intelligence and statistics 99: 7th international workshop on artificial intelligence and statistics','5','Shreshth Kharbanda','smartyshre@gmail.com','111112','2018-02-23','2018-03-23','453',0),(6,'Beyond calculation: the next fifty years of computing','6','Shreshth Kharbanda','smartyshre@gmail.com','111112','2018-02-23','2018-03-23','294',1),(7,'Cataloging and classification: an introduction (2nd edition)','7','Gulshan Kharbanda','gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','390',0),(8,'Complexity and postmodernism: understanding complex systems','8','Gulshan Kharbanda','gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','348',0),(9,'Computer concepts (3rd edition-CD)','9','Gulshan Kharbanda','gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','736',1),(10,'Computing essentials','10','Gulshan Kharbanda','gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','98',1),(11,'Designing communication and collaboration support systems','11','Gulshan Kharbanda','gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','347',1),(12,'Dictionary of semiotics','12','Gulshan Kharbanda','gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','206',1),(13,'Economic complexity: chaos, sunspots, bubbles and nonlinearity (4th international symposium in economic theory and econometrics)','13',NULL,'gkharbanda@gmail.com','111113','2018-02-23','2018-03-23','478',0);
/*!40000 ALTER TABLE `LibraryBooksCheckedOut` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-23 20:51:01
