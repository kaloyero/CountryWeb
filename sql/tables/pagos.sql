DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagos` (
  `IdPago` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Referencia` varchar(50) NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  `IdTipoPago` int(11) NOT NULL,
  PRIMARY KEY (`IdPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
