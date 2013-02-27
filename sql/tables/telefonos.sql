DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonos` (
  `IdTelefono` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CodigoPais` varchar(5) DEFAULT NULL,
  `CodigoArea` varchar(5) DEFAULT NULL,
  `Prefijo` varchar(5) DEFAULT NULL,
  `Numero` varchar(10) NOT NULL,
  `IdTipoTelefono` int(11) NOT NULL,
  `IdPersona` int(11) NOT NULL,
  PRIMARY KEY (`IdTelefono`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
