-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: az_organizer
-- ------------------------------------------------------
-- Server version	5.1.73-community

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
-- Table structure for table `callclient`
--

DROP TABLE IF EXISTS `callclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `callclient` (
  `idCall` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idContact` int(10) unsigned NOT NULL,
  `dateCall` date DEFAULT NULL,
  PRIMARY KEY (`idCall`),
  KEY `fk_call_idx` (`idContact`),
  CONSTRAINT `fk_call` FOREIGN KEY (`idContact`) REFERENCES `contact` (`idContact`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `callclient`
--

LOCK TABLES `callclient` WRITE;
/*!40000 ALTER TABLE `callclient` DISABLE KEYS */;
INSERT INTO `callclient` VALUES (4,4,'2015-09-09'),(5,5,'2015-09-10'),(6,6,'2015-09-09'),(7,7,'2015-09-11'),(8,8,'2015-09-01'),(9,9,'2015-09-05'),(11,11,'2015-10-06');
/*!40000 ALTER TABLE `callclient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `idContact` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nameContact` varchar(45) NOT NULL DEFAULT 'no name',
  PRIMARY KEY (`idContact`),
  UNIQUE KEY `idClient_UNIQUE` (`idContact`),
  KEY `fk1_idx` (`nameContact`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (7,'G.Prokopenko'),(6,'I.Panchenko'),(5,'M.Volkova'),(8,'N.Kovaleva'),(4,'O.Savushkina'),(9,'R.Ignatov'),(11,'Victor');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_has_meet`
--

DROP TABLE IF EXISTS `contact_has_meet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_has_meet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idContact` int(10) unsigned NOT NULL,
  `idMeet` int(10) unsigned NOT NULL,
  `organizer` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_contact_has_meet_meet1_idx` (`idMeet`),
  KEY `fk_contact_has_meet_contact1_idx` (`idContact`),
  CONSTRAINT `fk_contact_has` FOREIGN KEY (`idMeet`) REFERENCES `meet` (`idMeet`) ON UPDATE CASCADE,
  CONSTRAINT `fk_contact_has2` FOREIGN KEY (`idContact`) REFERENCES `contact` (`idContact`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_has_meet`
--

LOCK TABLES `contact_has_meet` WRITE;
/*!40000 ALTER TABLE `contact_has_meet` DISABLE KEYS */;
INSERT INTO `contact_has_meet` VALUES (4,4,4,0),(5,5,5,0),(6,6,6,0),(7,7,7,0),(8,8,8,0),(9,9,9,0),(11,11,10,0),(12,5,11,0);
/*!40000 ALTER TABLE `contact_has_meet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `e_mail`
--

DROP TABLE IF EXISTS `e_mail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `e_mail` (
  `idMail` int(11) NOT NULL AUTO_INCREMENT,
  `idContact` int(10) unsigned NOT NULL,
  `e_mail` varchar(45) NOT NULL,
  PRIMARY KEY (`idMail`),
  KEY `fk_idx` (`idContact`),
  CONSTRAINT `fke-mail` FOREIGN KEY (`idContact`) REFERENCES `contact` (`idContact`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `e_mail`
--

LOCK TABLES `e_mail` WRITE;
/*!40000 ALTER TABLE `e_mail` DISABLE KEYS */;
INSERT INTO `e_mail` VALUES (4,4,'O.Savushkina@mail.ua'),(5,5,'M.Volkova@mail.ua'),(6,6,'I.Panchenko@mail.ua'),(7,7,'G.Prokopenko@mail.ua'),(8,8,'N.Kovaleva@mail.ua'),(9,9,'R.Ignatov@mail.ua'),(11,11,'victor@mail.ua'),(12,5,'M.Volkova_home@mail.ua');
/*!40000 ALTER TABLE `e_mail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meet`
--

DROP TABLE IF EXISTS `meet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meet` (
  `idMeet` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `meetDate` date DEFAULT NULL,
  PRIMARY KEY (`idMeet`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meet`
--

LOCK TABLES `meet` WRITE;
/*!40000 ALTER TABLE `meet` DISABLE KEYS */;
INSERT INTO `meet` VALUES (4,'2015-10-10'),(5,'2015-12-01'),(6,'2015-10-01'),(7,'2015-09-26'),(8,'2015-10-01'),(9,'2015-09-15'),(10,'2016-01-01'),(11,'2015-12-31');
/*!40000 ALTER TABLE `meet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `idPhone` int(11) NOT NULL AUTO_INCREMENT,
  `idContact` int(10) unsigned NOT NULL,
  `phone_work` int(11) DEFAULT NULL,
  `phone_home` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPhone`),
  KEY `fk_phone_idx` (`idContact`),
  CONSTRAINT `fk_phone` FOREIGN KEY (`idContact`) REFERENCES `contact` (`idContact`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (4,4,3486547,0),(5,5,264362,124156),(6,6,3649875,0),(7,7,3547810,3540025),(8,8,3450287,0),(9,9,3604800,3607711),(11,11,3153318,3248321);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder`
--

DROP TABLE IF EXISTS `reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reminder` (
  `idRemind` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idMeet` int(11) unsigned DEFAULT NULL,
  `reminderDate` date DEFAULT NULL,
  `notice` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRemind`),
  KEY `fk_remin_idx` (`idMeet`),
  CONSTRAINT `fk_remin` FOREIGN KEY (`idMeet`) REFERENCES `meet` (`idMeet`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder`
--

LOCK TABLES `reminder` WRITE;
/*!40000 ALTER TABLE `reminder` DISABLE KEYS */;
INSERT INTO `reminder` VALUES (4,4,'2015-10-05',NULL),(5,5,'2015-10-01',NULL),(6,6,'2015-09-17',NULL),(7,7,'2015-09-20',NULL),(8,8,'2015-09-05',NULL),(9,9,'2015-09-10',NULL),(10,10,'2015-12-12',NULL);
/*!40000 ALTER TABLE `reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'az_organizer'
--

--
-- Dumping routines for database 'az_organizer'
--
/*!50003 DROP PROCEDURE IF EXISTS `addPerson` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPerson`(in personIn varchar(45), out getIdPerson int)
BEGIN
set @IdPerson = (select idPerson from person where person_name = personIn);
if not exists (select * from person where person_name = personIn)
then insert ignore into person set person_name = personIn;
end if;
set getIdPerson = (select idPerson from person where person_name = personIn);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addPhotoPeople` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPhotoPeople`(in personIn varchar(45), in urlIn varchar(45), out getId int )
BEGIN
set @IdPerson = (select idPerson from person where person_name = personIn);
set @IdPhoto = (select idPhoto from photo where url_photo = urlIn);
if not exists (select * from photo_has_people where idPhoto = @IdPhoto)
then insert into photo_has_people (idPerson, idPhoto) values (@IdPerson, @IdPhoto);
end if;
set getId = (select id from photo_has_people where idPhoto = @IdPhoto);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addPlace` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPlace`(in placeIn varchar(45), out getIdPlace int)
BEGIN
if not exists (select * from place where placeName = placeIn)
then insert ignore into place set placeName = placeIn;
end if;
set getIdPlace = (select idPlace from place where placeName = placeIn);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addUrlPhoto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUrlPhoto`(in placeIn varchar(45),in urlIn varchar(45), in dateIn datetime, out getIdPhoto int)
BEGIN
set @IdPlace = (select idPlace from place where placeName = placeIn);
if not exists (select * from photo where url_photo = urlIn)
then insert into photo (idPlace, url_photo, date_photo) values(@IdPlace, urlIn, dateIn);
end if;
set getIdPhoto = (select idPhoto from photo where url_photo = urlIn);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `remove` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `remove`(in urlIn varchar(100))
BEGIN
set @getIdPhoto = (select idPhoto from photo where url_photo = urlIn);
SET SQL_SAFE_UPDATES=0;
delete from photo_has_people where idPhoto = @getIdPhoto;
delete from person where idPerson not in (select idPerson from photo_has_people);
delete from photo where idPhoto = @getIdPhoto;
delete from place where idPlace not in (select idPlace from photo);
SET SQL_SAFE_UPDATES=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `removeItem` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeItem`(in inIdContact int)
BEGIN
SET SQL_SAFE_UPDATES=0;
delete from contact_has_meet where idContact = inIdContact;
delete from reminder where idMeet not in (select idMeet from contact_has_meet);
delete from meet where idMeet not in (select idMeet from contact_has_meet);
delete from e_mail where idContact = inIdContact;
delete from phone where idContact = inIdContact;
delete from callclient where idContact = inIdContact;
delete from contact where idContact = inIdContact;
SET SQL_SAFE_UPDATES=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-03 20:39:40
