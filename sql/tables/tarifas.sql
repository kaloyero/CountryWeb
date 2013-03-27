DROP TABLE IF EXISTS `tarifas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarifas` (
  `IdTarifa` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Importe` decimal(10,2) NOT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  `IdConcepto` int(11) NOT NULL,
  PRIMARY KEY (`IdTarifa`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
