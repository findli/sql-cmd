-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: salesdept
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (12,'ООО \"Интрейд лтд\"','313-48-48','ул. Смольная, д. 7',1000),(13,'Иванов П.В.','336-74-87','пр. Пушкина, 125',3000),(14,'Петров',NULL,NULL,235),(15,'John',NULL,NULL,100),(16,'Jane','84848444',NULL,124),(22,'Иван','3343-22-22','Садовая, 14',123),(23,'Dan','4774747','tututu',11),(24,'Dan1',NULL,NULL,13),(25,'Иван Иванович',NULL,NULL,NULL),(26,'Новый заказ!',NULL,NULL,NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `product_id` bigint(20) unsigned NOT NULL,
  `qty` int(10) unsigned DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `customer_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `product_id` (`product_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2007-12-12',5,8,4500.00,12),(2,'2007-12-12',2,14,22000.00,12),(3,'2008-01-21',5,12,5750.00,13),(4,'2015-03-24',4,1,1000.00,14),(6,NULL,4,1,11.00,12),(7,'2005-11-11',4,1,1000.00,25),(8,'2012-12-12',1,1000,1000.00,26);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `orderview`
--

DROP TABLE IF EXISTS `orderview`;
/*!50001 DROP VIEW IF EXISTS `orderview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `orderview` AS SELECT 
 1 AS `order_id`,
 1 AS `date`,
 1 AS `qty`,
 1 AS `amount`,
 1 AS `customer_id`,
 1 AS `name`,
 1 AS `phone`,
 1 AS `address`,
 1 AS `rating`,
 1 AS `product_id`,
 1 AS `description`,
 1 AS `details`,
 1 AS `price`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `description` text,
  `details` text,
  `price` decimal(8,2) DEFAULT NULL,
  `manual` mediumblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Обогреватель Мосбытприбор ВГД 121R','Инфракрасный обогреватель. 3 режима нагрева: 400 Вт, 800 Вт, 1200 Вт',1145.00,NULL),(2,'Гриль Мосбытприбор СТ-14','Мощность 1440 Вт. Быстрый нагрев. Термостат.\\n		Цветовой индикатор работы',2115.00,NULL),(3,'Кофеварка Мосбытприбор ЕКЛ-1032','Цвет: черный. Мощность: 450 Вт.\\n		Вместительность: 2 чашки',710.00,NULL),(4,'Чайник Мосбытприбор МН','Цвет: белый. Мощность: 2200 Вт. Объем: 2 л',925.00,NULL),(5,'Утюг Мосбытприбор c паром АБ 200','Цвет: фиолетовый. Мощность: 1400 вт',518.00,NULL),(12,'unknown','nothing',11111.00,NULL),(13,'new',NULL,NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'salesdept'
--
/*!50003 DROP PROCEDURE IF EXISTS `insertOrder` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrder`(IN _name varchar(50), IN _product_id INT, 
					IN _date Date, IN _qty INT, IN _amount FLOAT, 
                    OUT inserted_id INT)
BEGIN
	
    if 0 < (select count(*) from customers where name = _name) then
		
       set @customer_id = (select id from customers where name = _name limit 1);
       
	else 
    
		insert into customers (name) values (_name);
        set @customer_id = last_insert_id();
        
	end if;
        
    
    insert into orders (customer_id, product_id, date, qty, amount)
         values (@customer_id,_product_id,_date, _qty, _amount);
         
	select last_insert_id() into inserted_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `orderview`
--

/*!50001 DROP VIEW IF EXISTS `orderview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `orderview` AS select `orders`.`id` AS `order_id`,`orders`.`date` AS `date`,`orders`.`qty` AS `qty`,`orders`.`amount` AS `amount`,`orders`.`customer_id` AS `customer_id`,`customers`.`name` AS `name`,`customers`.`phone` AS `phone`,`customers`.`address` AS `address`,`customers`.`rating` AS `rating`,`orders`.`product_id` AS `product_id`,`products`.`description` AS `description`,`products`.`details` AS `details`,`products`.`price` AS `price` from ((`orders` join `customers` on((`orders`.`customer_id` = `customers`.`id`))) join `products` on((`orders`.`product_id` = `products`.`id`))) order by `orders`.`date` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-15 23:11:17
