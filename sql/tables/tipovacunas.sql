DROP TABLE IF EXISTS `tipovacunas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipovacunas` (
  `IdTipoVacuna` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `VigenciaMeses` int(11) NOT NULL,
  `Obligatoria` varchar(1) DEFAULT NULL,
  `IdEspecie` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdTipoVacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
