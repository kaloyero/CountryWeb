DROP TABLE IF EXISTS `integranteactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integranteactividades` (
  `IdIntegranteActividad` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdIntegrante` int(11) DEFAULT NULL,
  `IdActividad` int(11) NOT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  PRIMARY KEY (`IdIntegranteActividad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
