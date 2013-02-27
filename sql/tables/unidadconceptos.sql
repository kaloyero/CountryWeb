DROP TABLE IF EXISTS `unidadconceptos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidadconceptos` (
  `IdUnidadConceptos` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdUnidad` int(11) NOT NULL,
  `IdConcepto` int(11) NOT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  PRIMARY KEY (`IdUnidadConceptos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
