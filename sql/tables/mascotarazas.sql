DROP TABLE IF EXISTS `mascotarazas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mascotarazas` (
  `IdRaza` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `IdEspecie` int(11) NOT NULL,
  PRIMARY KEY (`IdRaza`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
