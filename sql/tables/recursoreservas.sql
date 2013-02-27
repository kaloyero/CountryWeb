DROP TABLE IF EXISTS `recursoreservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recursoreservas` (
  `IdReserva` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `IdRecurso` int(11) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `HoraIni` int(11) NOT NULL,
  `Duracion` int(11) NOT NULL,
  PRIMARY KEY (`IdReserva`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
