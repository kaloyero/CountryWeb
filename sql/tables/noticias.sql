DROP TABLE IF EXISTS `noticias`;
CREATE TABLE noticias
(
	IdNoticia            int(10) unsigned NOT NULL AUTO_INCREMENT,
	Titulo               VARCHAR(50) NOT NULL,
	Texto                MEDIUMBLOB NOT NULL,
	IdCategoria          int(10) NULL,
	Fecha                DATE NOT NULL,
	PublicaDesde         DATE NOT NULL,
	PublicaHasta         DATE NULL,
	Estado               VARCHAR(1) NOT NULL,
	PRIMARY KEY (IdNoticia),
	FOREIGN KEY R_93 (IdCategoria) REFERENCES NoticiaCategorias (IdCategoria)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
