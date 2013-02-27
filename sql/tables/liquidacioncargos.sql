DROP TABLE IF EXISTS `liquidacioncargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liquidacioncargos` (
  `IdCargo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  `Modo` varchar(1) NOT NULL,
  `IdLiquidacion` int(11) NOT NULL,
  `IdUnidad` int(11) NOT NULL,
  `IdConcepto` int(11) DEFAULT NULL,
  `IdInfraccion` int(11) DEFAULT NULL,
  `IdUnidadConceptos` int(11) NOT NULL,
  `IdIntegranteActividad` int(11) NOT NULL,
  `IdReserva` int(11) NOT NULL,
  PRIMARY KEY (`IdCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
