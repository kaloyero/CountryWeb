DROP TABLE IF EXISTS `noticiaSuscripciones`;
CREATE TABLE noticiaSuscripciones
(
	IdNoticiaSuscripcion int(10) unsigned NOT NULL AUTO_INCREMENT,
	IdCategoria          int(10) NULL,
	IdIntegrante         int(10) NULL,
	PRIMARY KEY (IdNoticiaSuscripcion),
	FOREIGN KEY R_97 (IdCategoria) REFERENCES NoticiaCategorias (IdCategoria),
	FOREIGN KEY R_99 (IdIntegrante) REFERENCES Integrantes (IdIntegrante)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
