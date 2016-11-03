CREATE DATABASE university;
USE university;
-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	5.7.15-0ubuntu0.16.04.1

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
-- Table structure for table `DataStructures`
--

DROP TABLE IF EXISTS `DataStructures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DataStructures` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(11) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DataStructures`
--

LOCK TABLES `DataStructures` WRITE;
/*!40000 ALTER TABLE `DataStructures` DISABLE KEYS */;
INSERT INTO `DataStructures` VALUES (1,4,'Vlad','Hnes'),(2,4,'Jack','Rich'),(3,4,'John','Reynolds');
/*!40000 ALTER TABLE `DataStructures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Java`
--

DROP TABLE IF EXISTS `Java`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Java` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(11) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Java`
--

LOCK TABLES `Java` WRITE;
/*!40000 ALTER TABLE `Java` DISABLE KEYS */;
INSERT INTO `Java` VALUES (1,5,'Vlad','Hnes'),(2,4,'Jack','Rich'),(3,4,'John','Reynolds');
/*!40000 ALTER TABLE `Java` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JavaScript`
--

DROP TABLE IF EXISTS `JavaScript`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JavaScript` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(11) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JavaScript`
--

LOCK TABLES `JavaScript` WRITE;
/*!40000 ALTER TABLE `JavaScript` DISABLE KEYS */;
INSERT INTO `JavaScript` VALUES (1,4,'Vlad','Hnes'),(2,4,'Jack','Rich'),(3,4,'John','Reynolds');
/*!40000 ALTER TABLE `JavaScript` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `imageURL` varchar(255) DEFAULT 'https://ih1.redbubble.net/image.175848241.2112/flat,800x800,075,f.jpg',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (ID,firstName,lastName,login,password) VALUES (1,'Vlad','Hnes','Vlad','Hnes123'),(2,'Jack','Rich','Jack','Rich123'),(3,'John','Reynolds','John','Reynolds123'),(4,'Paul','Godric','Paul','Godric123'),(5,'Paul','Godric','Paul','Godric123');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `imageURL` varchar(255) DEFAULT 'http://arhivach.org/storage/4/34/4346bfa65d3f8ef55b293c752c3c2dc0.jpg',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` (ID,firstName,lastName,login,password,subject) VALUES (1,'James','Gosling','James','Gosling123','Java'),(2,'Brendan','Eich','Breandan','Eich123','JavaScript'),(3,'Thomas','Cormen','Thomas','Cormen123','DataStructures');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-23 21:48:57
