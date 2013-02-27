DROP TABLE IF EXISTS `periodos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodos` (
  `IdPeriodo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  `Estado` varchar(1) NOT NULL,
  `IdEmprendimiento` int(11) NOT NULL,
  PRIMARY KEY (`IdPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
