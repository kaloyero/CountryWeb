DROP TABLE IF EXISTS `instructores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructores` (
  `IdInstructor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  `IdPersona` int(11) NOT NULL,
  PRIMARY KEY (`IdInstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
