DROP TABLE IF EXISTS `infracciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `infracciones` (
  `IdInfraccion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Numero` varchar(20) NOT NULL,
  `Motivo` varchar(50) NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  `IdTipoInfraccion` int(11) NOT NULL,
  `IdVehiculo` int(11) NOT NULL,
  `IdMascota` int(11) NOT NULL,
  `Foto` blob,
  PRIMARY KEY (`IdInfraccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
