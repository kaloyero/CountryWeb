DROP TABLE IF EXISTS `recursoreservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE RecursoReservas
(
	IdReserva            INTEGER unsigned NOT NULL AUTO_INCREMENT,
	Fecha                DATE NOT NULL,
	IdRecurso            INTEGER NOT NULL,
	Descripcion          VARCHAR(80) NULL,
	HoraIni              INTEGER NOT NULL,
	Duracion             INTEGER NOT NULL,
	IdEvento             INTEGER NOT NULL,
	IdIntegrante         INTEGER NOT NULL,
	PRIMARY KEY (IdReserva),
	FOREIGN KEY FK_Recursos_RecursoReservas (IdRecurso) REFERENCES Recursos (IdRecurso),
	FOREIGN KEY FX_Eventos_RecursosReservas (IdEvento) REFERENCES Eventos (IdEvento),
	FOREIGN KEY FX_Integrantes_RecursoReservas (IdIntegrante) REFERENCES Integrantes (IdIntegrante)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;