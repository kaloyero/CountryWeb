DROP TABLE IF EXISTS `liquidaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liquidaciones` (
  `IdLiquidacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Numero` varchar(20) NOT NULL,
  `Fecha` date NOT NULL,
  `IdPeriodo` int(11) DEFAULT NULL,
  `Estado` varchar(1) NOT NULL,
  `FechaVencimiento` date NOT NULL,
  PRIMARY KEY (`IdLiquidacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
