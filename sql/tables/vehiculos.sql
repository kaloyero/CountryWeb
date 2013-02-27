DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculos` (
  `IdVehiculo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(20) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  `CIlindrada` varchar(10) DEFAULT NULL,
  `IdTipoVehiculo` int(11) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  PRIMARY KEY (`IdVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
