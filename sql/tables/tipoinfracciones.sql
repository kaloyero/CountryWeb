DROP TABLE IF EXISTS `tipoinfracciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoinfracciones` (
  `IdTipoInfraccion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `IdConcepto` int(11) DEFAULT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  PRIMARY KEY (`IdTipoInfraccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
