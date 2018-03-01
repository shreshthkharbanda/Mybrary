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
-- Table structure for table `ShareJokes`
--

DROP TABLE IF EXISTS `ShareJokes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ShareJokes` (
  `idJokes` int(11) NOT NULL AUTO_INCREMENT,
  `jokeText` varchar(767) DEFAULT NULL,
  `jokeImage` mediumtext,
  `jokeImage2` blob,
  `jokeImage3` blob,
  `jokeImage4` blob,
  `jokeImage5` blob,
  `jokeImage6` blob,
  `jokeLikes` int(11) DEFAULT NULL,
  `jokeShares` int(11) DEFAULT NULL,
  PRIMARY KEY (`idJokes`),
  UNIQUE KEY `idJokes_UNIQUE` (`idJokes`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ShareJokes`
--

LOCK TABLES `ShareJokes` WRITE;
/*!40000 ALTER TABLE `ShareJokes` DISABLE KEYS */;
INSERT INTO `ShareJokes` VALUES (33,'New Seatbelt Design','http://funnyandhumorous.com/thumb/jokes-about-drivers-14.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'\"IDK\" Meaning','https://s-media-cache-ak0.pinimg.com/736x/97/aa/e9/97aae94a353165ab1e7e43d1479a23e6.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(35,NULL,'https://s-media-cache-ak0.pinimg.com/736x/9c/5c/3f/9c5c3f150f27fa313fd9ab138ae00645.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(36,NULL,'https://s-media-cache-ak0.pinimg.com/736x/44/87/73/44877371c3892b4e93787e554f1aaa8e.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(37,NULL,'http://4.bp.blogspot.com/-fK3ZnbBFszk/VqXSB0BRKrI/AAAAAAAAAxM/gQkKCoGtT1M/s1600/funny%2Bclean%2Bmarried%2Bcouples%2Bpictures%2B05.GIF',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(38,NULL,'https://s-media-cache-ak0.pinimg.com/236x/49/de/06/49de06b71539ad102f9183e36dc6a1ef.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,NULL,'https://lh3.googleusercontent.com/-ffMMZnIx-B8/VcZRKQ9knnI/AAAAAAABnjY/BPlI1Aw1GUo/w500-h289/funny-happy-mothers-day-photos-34.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,NULL,'http://sanitaryum.com/wp-content/uploads/2015/11/Dinsosaur-least-fav-deer-comet-635x635.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,NULL,'https://s-media-cache-ak0.pinimg.com/originals/db/aa/6b/dbaa6b9b47de62c9f9bf4c9d96866aba.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(42,NULL,'https://s-media-cache-ak0.pinimg.com/236x/06/7f/d6/067fd68d97d0f815df6aaa241dce3dbe.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,NULL,'https://s-media-cache-ak0.pinimg.com/originals/02/09/24/02092486076d7bf03b2637c75693cb00.gif',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,NULL,'http://3.bp.blogspot.com/-tXTBQPY1frs/UuLJ8tmQ6XI/AAAAAAAABgk/A2zD5qnTXTk/s1600/Funny-jokes-part-11.gif',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,NULL,'https://s-media-cache-ak0.pinimg.com/originals/ab/72/20/ab7220904be007652d49d3e46d5150d6.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,NULL,'https://thewondrous.com/wp-content/uploads/2015/09/funny-clean-jokes.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,NULL,'http://sanitaryum.com/wp-content/uploads/2012/05/Jokes-on-Sodium.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,NULL,'https://s-media-cache-ak0.pinimg.com/736x/9b/0b/8c/9b0b8c2de2e8cefb9d7d01248a1cfa75.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,NULL,'http://funlexia.com/wp-content/uploads/2013/04/Text-Message-Funny-Jokes.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,NULL,'https://s-media-cache-ak0.pinimg.com/736x/e0/00/96/e0009669621973236b76bff801302ab2.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,NULL,'https://s-media-cache-ak0.pinimg.com/736x/a7/ab/4d/a7ab4d8aa1c4a0a2fec6a854ee4aed5f.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,NULL,'https://s-media-cache-ak0.pinimg.com/736x/03/12/13/031213a8966a9bda4f4bdf741dd95314.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,NULL,'https://s-media-cache-ak0.pinimg.com/736x/55/92/be/5592be1c4355fa88f2028ec4d8aac71d.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,NULL,'https://s-media-cache-ak0.pinimg.com/736x/f4/d8/be/f4d8be2eadf6fe702d1666286505c40f.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,NULL,'https://s-media-cache-ak0.pinimg.com/736x/cd/76/df/cd76df0dffc86dce81e1750d628ed3b0.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,NULL,'https://s-media-cache-ak0.pinimg.com/736x/99/d5/e6/99d5e67f2f6de7dcda295ffa425dd9c4.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,NULL,'http://www.aboutpathankot.com/wp-content/uploads/2016/12/Funny-Jokes-Images37.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,NULL,'https://s-media-cache-ak0.pinimg.com/736x/0d/01/bd/0d01bd38069519dda9d9fbd8612b4bce.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(66,NULL,'https://static.getjar.com/ss/44/846117_4.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(69,NULL,'http://www.whykol.com/wp-content/uploads/2016/05/13254619_631710513660174_1829601467461510508_n.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(70,NULL,'https://s-media-cache-ak0.pinimg.com/736x/27/5d/84/275d84b3ada01a03db88204aa84e9ee6.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(71,NULL,'$name',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(72,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(73,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(74,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(75,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(76,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(77,NULL,'www.google.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(78,NULL,'www.google.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(79,NULL,'www.google.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ShareJokes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-23 20:50:57
