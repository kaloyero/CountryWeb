DROP TABLE IF EXISTS `mascotavacunas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mascotavacunas` (
  `IdVacuna` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FechaCertificado` date NOT NULL,
  `Descripcion` varchar(30) DEFAULT NULL,
  `IdMascota` int(11) NOT NULL,
  `IdTipoVacuna` int(11) NOT NULL,
  PRIMARY KEY (`IdVacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
