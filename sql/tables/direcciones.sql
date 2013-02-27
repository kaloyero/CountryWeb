DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direcciones` (
  `IdDireccion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CalleNombre` varchar(18) NOT NULL,
  `CalleNumero` varchar(18) NOT NULL,
  `Torre` varchar(18) DEFAULT NULL,
  `Bloque` varchar(18) DEFAULT NULL,
  `Piso` varchar(18) DEFAULT NULL,
  `Departamento` varchar(18) DEFAULT NULL,
  `IdPersona` int(11) NOT NULL,
  `IdLocalidad` int(11) NOT NULL,
  PRIMARY KEY (`IdDireccion`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
