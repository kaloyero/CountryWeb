DROP TABLE IF EXISTS `integrantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integrantes` (
  `IdIntegrante` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(2) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  PRIMARY KEY (`IdIntegrante`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
