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
-- Table structure for table `Amazon`
--

DROP TABLE IF EXISTS `Amazon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Amazon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` blob,
  `name` varchar(60) NOT NULL,
  `retailer` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `itemId_UNIQUE` (`id`),
  UNIQUE KEY `Name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Amazon`
--

LOCK TABLES `Amazon` WRITE;
/*!40000 ALTER TABLE `Amazon` DISABLE KEYS */;
INSERT INTO `Amazon` VALUES (1,'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0		\n\n	\r\r\r \"\" $((,$&%\'-1-%)+7..#+383,7(-.+\n\n\n\r\r\Z\Z+%%-7+77-7++++-7+7++++7+7++++++++++++++++++++++++++++ÿÀ\0\0,\0P\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\08\0	\0\0\0\0\0\0!1\"AQaq±Ñ“¡#$3‚’2CTs‘”Áðÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0!1AQÿ\Ú\0\0\0?\0\ä\æ\Û\Ðû\ë–-\\:†\ÐU\0¨Æ½\ßC[–kGA\ã<(Xt®“\"G\à9Cxµe\æq\Çk¶O\æ®*\Ê\Ø®šýUôO\ØN­ Fò‘Có×©°²UÅ½£o(	‚ n\0\Øk©Ê©\â+ób\'g8¼\rª2¯\ãM\è\n\ézVŠ•<\Æ$Á\ìŠ r\ßù“\Ê	Kø°I\Ô)\ZøÀŠ7p»†H–Í…©°°AQŽ\Ð<©\'Žø‚\Äpõ\å²p-ô\Ó)‰H?J\èˆt›ø*J|¾\ÇGxG‡W1k\à¥CY]\à\Þ3y<\àÿ\0u\Ó’C\ÏÜ²§RH\\Ž°\Ûþ]jb‘¬õ,/ƒ0…`!—’IGIõšŸ\Ý6\Ûw¯¶\ÌôhuIL™0	\éV.\'` O:\Ôm*+QQÜ™>f®X0¢\×ZøQIg†*ˆ:L\íø.Rz\î^sõ\Z\ï`\Õ\ê\Â2	zÙ‡yÓ¿\È2H :Á\î>5›Z±p»\æs¸|*P\æBí¶ŠÄ¶	$¨x\Ù\ãµ%\\d/rœ‚\Þz[yR\Ñ\æ‘\0Î“\Ùá°šVF^\Ô\Óa™¸ˆ¤\Êóˆ‘\0£¼\n\æ2¶¢\è¼q*$’`OlŽH\'Q¯—uk\Å|}û&\îß…\Ð\äŒ\Å\ê-[!pD4€˜\ÔÀD\Þu\"q.>\á\Ü]\Íõ\á\æs£HD˜:\êLm&‘\Û\à(’xš\Ý\r¯\n\ÈIO>T(\É\í\'—P ‘;I=µ‡\'|\æu—,¬ñˆn\åõžlˆ^€k	€L\0c]5øt\Ï,L´Œ\\Û¤Æ¼Qa¼¹°²GW«¬øE5®\Î\Ý\Äó}¤ÿ\0UG\ÔÔ£ö‘´^¦BÒ½`Û¨ÞžqüUy¤‡(TkÎ‚>±\Ât…e6–\×n‡T[¸®²´€‚tŠ•¶`\n qb\Ìð\îMv÷l­\Ãj\â@BÁ2¡o\ÛQ‘{t?Ž¿\ïW/!|U‹ù|ƒVVÃ®\áÔ€\Z’|\0ªM÷\Ù]c\í\ìK—\rÛ°’P\0“ºŽ†Nþ\ZÔœ	&L‚ESq²\ÝùŠ÷¬\ÆU\ß\à«$ê›‹¤¨\ìB;\Ì\ê=|÷¬Ç‚­A$^]j#Pˆô\î\ÓÊ¥Ä­\'GžùŠ÷­B\â\ëO¾\Ýÿ\0¿z5HG\ÙÀûƒ\Éu`zw\n\ÓaÂ––w\íÝ¶\ã…mR	\ÓOy\í©u\ï\æ.>r½\ë³jyD}\ê\ç\àò½\é\ë3öÛˆ\î\Ó…«¥O\æ~¤…x+\"\nd)n8z«‹*1I;WeÀöúÀ·xw¤ŠXPDQÛ•‰~T\ß\ßø\Óô#ÿ\Ù','Macbook Pro 16gb RAM i7 intel core processor','Apple'),(2,'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0\0Z\0Z\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñð$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rðbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0?\0÷ú(¢€(êš•¾—a=\å\Í\ÄVöö\ë¾Y¥\Î\Ô…A§j\Ðjzl:¦¡o=¤£)\"!\0óŽ\ç#‘Žj¾£ikªZ\ê\ZmõºOi;’6\'\æ_C\ÇA\ÓÒ ·°²\Ò4!§\Ø\Ú\Ç´(v&I=I$’rI$žj[Fªœº\Zö÷7\æ\ZDÜ¦T\îa\êy\ã>•>é¿¼Ÿ÷\Éÿ\0\Z¨/\í!&”EPT)8\à\ÃÒ™&¡jû6\ÝI\Öv\Æ~a\èr½?Z»#&\Ë	z²]\Ëj“\Â\ÓÂªòFÊ†\Î\Òy\ïƒùS\Û\í\î\Ëú\ÆOõ¬xY\"$m{P•T\ä\Æñ&\Öö8ˆ~5¡ý©gÿ\0=ýûoð¢\È.\ËQ¼«1C“€\Êý*zÊšú\ÞxŠE g\rÛ‚7¨\Ï5«HŠ( Š( yxºŸ\Ýóú\n‚ð\æ\Î^qòšš\ä\âò_÷¿ ª·„)³\Ói¬^\ç|ºD—|Ÿõ«ÿ\0¢’®n>§óªv_\ë.ÿ\0\ë¢ÿ\0è¤«8E$œq\ÅjÝ‘\Ãk²M\Ç\Ôþtn>§óªbú\"g?•YV8\è;úÒŒÔ¶*P”w(Þ‚Ú„@œþ\è\èÔ­ŠÉ¸\Ô\âô\Çÿ\0j%kU\Ð(¢ŠQE\0a_^\Ëõ\ÈU;£›IA\é´\Ôú‹\í\Ô&\ãù\n¥rùµ“ý\ÓX=\ÏB\n7,¿\Ö]ÿ\0\×Eÿ\0\ÑIXúÞª¨¦ ¨?1\Ïò­kRG\Û\êôRW\â5¹‘¼\ÔH\Õ¬Œ\Øÿ\0\ë\Öx©¸\ÇA\åÔ£R¯¼B/™®Š\ä.þ@\r\ß\ßÓ]¦uöˆpX¼qü\ë\Ëa»…\Ýa32•þ#\ßð\Þh4N#\Ø#\ró\0\ì\é\\˜z–ž§©™a­LÝŸþBq\×ý¨•«Y3Ÿø™\Äz~\çÿ\0j%kW¬|\ß@¢Š(QE\Êê¯R¨þB¨\\Iþ\'û¦¬\ë-^\ã\ê?¬Û‰?Ñ¤ÿ\0t\ÖsÑ‡ÂŽ²×­\ßþñpýrJ\å5\ë9$—\Ê!”>I¹÷ýk­°\å®\ë¢è¤¤¼°K¥$ý\î£\Ô\â§I\Íheƒ\Ä*5.\Ï5‹I³±\ÔR5šF\ËNH\ã8#½vZ,h÷$•\'• ƒŸ©¢7š\ìHýG<‘[¶¶©oM£#‚}kžŽW»;ñ¸\èÔ“» Ÿ\åÔ¢þxÿ\0\íD­zÈºÿ\0Œ_õ\Ëÿ\0j¥k×¢x½Š( AEP®k7Uÿ\0\ÐEe]HE¬¿)?!æ·µm>\î\ãU¸’Ð‘\Ê\ã\ÐVeÞ“¨}ŽoôI>\áôô¬Zw;\á%Êµ:­;Ÿ´¾Ÿú)*\íR†\Åü±\"]\Ï‘Q™T!\nu=€©\r¤Àu€$\ìÿ\0ˆ­¬p6Y¢³¡[©¶¹¸»HŸ\î±g‰]œgÿ\0×Š³ö9¿\è!sÿ\0|Gÿ\0\ÄP{¿ù\Åÿ\0\\‡þJØ¬¹,Š9\î%™\Æ\ÔÂ€õ\' •©@úQ@‚Š( \nn&¶žI&–)0\Ä&7+cPp*)®ü\Ø^3gw†ªÿ\0\ëÖ\æ=®¡pË›L¼Rƒ‚~yc\í\Çþ|¯?\ï\Ðÿ\0\ZÐ¢CC%n\çe­\îŒ]—\ì\ã?ž\ï\éS}¸ÿ\0Ï•\çýú\ãZP\Z\ãÎ¼xÇ’ðÂ¬Œ˜\Ø9\0žø\äÖ…P ¢Š(ÿ\Ù','iPhone SE','Apple');
/*!40000 ALTER TABLE `Amazon` ENABLE KEYS */;
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
