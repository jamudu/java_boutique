CREATE DATABASE  IF NOT EXISTS `boutique` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `boutique`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: boutique
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `prendas`
--

DROP TABLE IF EXISTS `prendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prendas` (
  `codigo` varchar(8) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `color` varchar(20) NOT NULL,
  `talla` varchar(4) NOT NULL,
  `precioCoste` decimal(6,2) unsigned zerofill NOT NULL,
  `precioVenta` decimal(6,2) unsigned zerofill NOT NULL,
  `stock` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prendas`
--

LOCK TABLES `prendas` WRITE;
/*!40000 ALTER TABLE `prendas` DISABLE KEYS */;
INSERT INTO `prendas` VALUES ('12345678','pantalon','blanco','M',0005.35,0008.45,0000000002),('23456789','falda','negro','L',0004.56,0005.67,0000000006),('34567890','calcetines','rojo','S',0001.23,0002.24,0000000003),('55','pantalon','amarillo','L',0010.12,0020.13,0000000000),('56','vestido','negro','S',0009.77,0019.78,0000000002),('57','camisa','blanco','S',0005.56,0015.57,0000000002),('58','camiseta','gris','XL',0002.23,0012.24,0000000001),('59','falda','blanco','M',0003.45,0013.46,0000000001);
/*!40000 ALTER TABLE `prendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-13  8:52:03
