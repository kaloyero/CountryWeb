DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `Apellido` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `NroDocumento` varchar(10) DEFAULT NULL,
  `DireccionEmail` varchar(50) DEFAULT NULL,
  `IdPersona` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdTipoDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
