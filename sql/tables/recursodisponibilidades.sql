DROP TABLE IF EXISTS `recursodisponibilidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recursodisponibilidades` (
  `IdDisponibilidad` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DiaSemana` int(11) NOT NULL,
  `HoraIni` int(11) NOT NULL,
  `HoraFin` int(11) NOT NULL,
  `IdRecurso` int(11) NOT NULL,
  PRIMARY KEY (`IdDisponibilidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
