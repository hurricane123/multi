-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: temp
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `aa`
--

DROP TABLE IF EXISTS `aa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aa` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aa`
--

LOCK TABLES `aa` WRITE;
/*!40000 ALTER TABLE `aa` DISABLE KEYS */;
INSERT INTO `aa` VALUES (1);
/*!40000 ALTER TABLE `aa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'book1'),(2,'book2'),(3,'book3'),(4,'book4'),(5,'book5'),(6,'book6'),(7,'book6'),(8,'book6'),(9,'book6'),(10,'book6'),(11,'book6'),(12,'book6'),(13,'book6'),(14,'book6'),(15,'book6'),(16,'book6'),(17,'book6'),(18,'book6'),(19,'book6'),(20,'book6'),(21,'book6'),(22,'book6'),(23,'book6'),(24,'book6'),(25,'book6'),(26,'book5'),(27,'book6'),(28,'book6'),(29,'book6'),(30,'book6'),(31,'book6'),(32,'book6'),(33,'book6'),(34,'book6'),(35,'book6'),(36,'book6'),(37,'book6'),(38,'book6'),(39,'book6'),(40,'book6'),(41,'book6'),(42,'book6'),(43,'book6'),(44,'book6'),(45,'book6'),(46,'book6'),(47,'book5'),(48,'book6'),(49,'book6'),(50,'book6'),(51,'book6'),(52,'book6'),(53,'book6'),(54,'book6'),(55,'book6'),(56,'book6'),(57,'book6'),(58,'book6'),(59,'book6'),(60,'book6'),(61,'book6'),(62,'book6'),(63,'book6'),(64,'book6'),(65,'book6'),(66,'book6'),(67,'book6'),(68,'book5'),(69,'book6'),(70,'book6'),(71,'book6'),(72,'book6'),(73,'book6'),(74,'book6'),(75,'book6'),(76,'book6'),(77,'book6'),(78,'book6'),(79,'book6'),(80,'book6'),(81,'book6'),(82,'book6'),(83,'book6'),(84,'book6'),(85,'book6'),(86,'book6'),(87,'book6'),(88,'book6'),(89,'book5'),(90,'book6'),(91,'book6'),(92,'book6'),(93,'book6'),(94,'book6'),(95,'book6'),(96,'book6'),(97,'book6'),(98,'book6'),(99,'book6'),(100,'book6'),(101,'book6'),(102,'book6'),(103,'book6'),(104,'book6'),(105,'book6'),(106,'book6'),(107,'book6'),(108,'book6'),(109,'book6');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hurricane','hurricane123'),(2,'abc','abc123'),(3,'def','def123'),(4,'hug','hug123'),(5,'hhh','hhh123'),(6,'jjj','jjj123'),(7,'abc','abc123'),(8,'def','def123'),(9,'hug','hug123'),(10,'hhh','hhh123'),(11,'jjj','jjj123'),(12,'abc','abc123'),(13,'def','def123'),(14,'hug','hug123'),(15,'hhh','hhh123'),(16,'jjj','jjj123'),(17,'abc','abc123'),(18,'def','def123'),(19,'hug','hug123'),(20,'hhh','hhh123'),(21,'jjj','jjj123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-22 10:41:21
