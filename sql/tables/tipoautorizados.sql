DROP TABLE IF EXISTS `tipoautorizados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoautorizados` (
  `IdTipoAutorizado` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`IdTipoAutorizado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
