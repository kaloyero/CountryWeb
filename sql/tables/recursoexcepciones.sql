DROP TABLE IF EXISTS `recursoexcepciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recursoexcepciones` (
  `IdExcepcion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `HoraIni` int(11) NOT NULL,
  `Duracion` int(11) NOT NULL,
  `IdRecurso` int(11) NOT NULL,
  PRIMARY KEY (`IdExcepcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
