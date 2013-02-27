DROP TABLE IF EXISTS `conceptos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conceptos` (
  `IdConcepto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) DEFAULT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  `Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`IdConcepto`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
