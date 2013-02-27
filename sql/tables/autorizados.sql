DROP TABLE IF EXISTS `autorizados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autorizados` (
  `IdAutorizado` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) DEFAULT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  `IdTipoAutorizado` int(11) NOT NULL,
  PRIMARY KEY (`IdAutorizado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
