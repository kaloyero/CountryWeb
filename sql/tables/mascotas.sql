DROP TABLE IF EXISTS `mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mascotas` (
  `Codigo` varchar(20) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Tamanio` varchar(1) NOT NULL,
  `Color` varchar(20) NOT NULL,
  `MarcasDistintivas` varchar(100) DEFAULT NULL,
  `IdMascota` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdRaza` int(11) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  PRIMARY KEY (`IdMascota`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
