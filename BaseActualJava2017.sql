-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: java2017
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
-- Table structure for table `elemento`
--

DROP TABLE IF EXISTS `elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento` (
  `idElemento` int(11) NOT NULL AUTO_INCREMENT,
  `ubicacion` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `capacidad` varchar(100) NOT NULL,
  `idTipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idElemento`),
  KEY `idTipo_idx` (`idTipo`),
  CONSTRAINT `idTipo` FOREIGN KEY (`idTipo`) REFERENCES `tipoelemento` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento`
--

LOCK TABLES `elemento` WRITE;
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
INSERT INTO `elemento` VALUES (1,'Rosario','Broadway','1000',1),(2,'Rosario','Circulo','1500',1),(3,'Buenos Aires','Gran Rex','2500',1),(4,'Rosario','Paso Sport','200',2),(5,'Rosario','Antares','200',2),(6,'Cordoba','Jhonny B Good','300',2),(7,'Buenos Aires','Luna Park','10000',3),(8,'Buenos Aires','Cancha CARP','80000',3),(9,'Rosario','Cancha NOB','50000',3),(10,'Cordoba','Chateau Carreras','60000',3),(11,'zeballos','hola','1234',1),(12,'gaso','gaso','123',3);
/*!40000 ALTER TABLE `elemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `habilitado` bit(1) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `encargado` bit(1) NOT NULL,
  `admin` bit(1) NOT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'John','Lennon','12234234','','jhon','yoko','\0','\0'),(2,'Paul','Mcartney','45567567','','paul','1234','\0','\0'),(8,'Bruno','Mars','34586146','','brunito','preasure','\0','\0'),(9,'Abel','Pintos','35123369','','abelito','motivos','\0','\0'),(10,'Joaquin','Sabina','30145912','\0','joaquinito','leningrado','\0','\0'),(12,'Marc','Anthony','23418390','','marquitos','jenny','\0','\0'),(13,'Maluma','Baby','38235162','','prettyboy','felices','\0','\0'),(15,'Patito','Bengoechea','57123739','','patito','ben','\0','\0'),(16,'admin','admin','12334567','','admin','admin','\0',''),(17,'user','user','12334568','','user','user','\0','\0'),(18,'encargado','encargado','12345675','','encar','encar','','\0'),(21,'asd','asdas','sadd','','asd','asdasd','\0','\0');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `fechaInicio` datetime NOT NULL,
  `fechaFin` datetime DEFAULT NULL,
  `idElemento` int(11) NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `idPersona_idx` (`idPersona`),
  KEY `idElemento_idx` (`idElemento`),
  CONSTRAINT `idElemento` FOREIGN KEY (`idElemento`) REFERENCES `elemento` (`idElemento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPersona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (16,1,'2015-12-25 00:00:00','2015-12-27 00:00:00',5),(17,2,'2016-05-29 00:00:00','2016-06-02 00:00:00',10),(18,15,'2017-05-23 00:00:00','2017-05-25 00:00:00',4),(19,8,'2013-06-21 00:00:00','2013-06-23 00:00:00',6),(20,1,'2015-12-25 00:00:00','2015-12-25 00:00:00',5),(21,2,'2016-05-29 00:00:00','2016-05-29 00:00:00',10),(22,15,'2017-05-20 00:00:00','2017-05-21 00:00:00',4),(23,8,'2013-06-21 00:00:00','2013-06-21 00:00:00',6),(24,15,'2018-10-10 00:00:00','2018-10-12 00:00:00',10),(25,17,'2018-10-10 00:00:00','2018-10-12 00:00:00',6),(26,21,'2018-10-12 00:00:00','2018-10-14 00:00:00',3),(28,17,'2018-09-09 00:00:00','2018-09-15 00:00:00',3),(30,17,'2018-06-11 00:00:00','2018-07-11 00:00:00',2);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoelemento`
--

DROP TABLE IF EXISTS `tipoelemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoelemento` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `cantDiasMax` int(11) NOT NULL,
  `soloenc` bit(1) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoelemento`
--

LOCK TABLES `tipoelemento` WRITE;
/*!40000 ALTER TABLE `tipoelemento` DISABLE KEYS */;
INSERT INTO `tipoelemento` VALUES (1,'Teatro',3,'\0'),(2,'Bar',4,'\0'),(3,'Estadio',4,''),(4,'Patio',2,'\0'),(5,'Puerto',120,'\0'),(6,'otroPuerto',100,'\0'),(7,'dosPuertos',1999,'\0'),(8,'tresPuertos',23441,'');
/*!40000 ALTER TABLE `tipoelemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `admin` tinyint(4) DEFAULT NULL,
  `encargado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'jhon','yoko',0,0),(2,'paul','jude',0,0),(3,'brunito','preasure',0,0),(4,'abelito','motivos',0,1),(5,'joaquinito','leningrado',0,1),(6,'juancito','abc123',1,0),(7,'marquitos','jenny',1,0),(8,'prettyboy','felices',0,0),(9,'user','12345',0,0),(10,'admin','12345',1,0),(11,'encargado','12345',0,1),(12,'patito','ben',0,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-21 20:12:25
