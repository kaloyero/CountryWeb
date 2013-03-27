DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidades` (
  `IdUnidad` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(20) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  `IdEmprendimiento` int(11) NOT NULL,
  PRIMARY KEY (`IdUnidad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
