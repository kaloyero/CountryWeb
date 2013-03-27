DROP TABLE IF EXISTS `recursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recursos` (
  `IdRecurso` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `IdTipoRecurso` int(11) NOT NULL,
  `IdConcepto` int(11) DEFAULT NULL,
  `MaxTiempoReserva` int(11) NOT NULL,
  PRIMARY KEY (`IdRecurso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
