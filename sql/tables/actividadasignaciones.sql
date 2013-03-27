DROP TABLE IF EXISTS `actividadasignaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividadasignaciones` (
  `IdAsignacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdInstructor` int(11) NOT NULL,
  `IdActividad` int(11) NOT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date DEFAULT NULL,
  PRIMARY KEY (`IdAsignacion`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
