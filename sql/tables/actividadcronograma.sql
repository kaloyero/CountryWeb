DROP TABLE IF EXISTS `actividadcronograma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividadcronograma` (
  `IdCronograma` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DiaSemana` int(11) NOT NULL,
  `HoraIni` int(11) NOT NULL,
  `Duracion` int(11) NOT NULL,
  `IdActividad` int(11) NOT NULL,
  PRIMARY KEY (`IdCronograma`)
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=utf8;
