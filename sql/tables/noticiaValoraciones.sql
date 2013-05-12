DROP TABLE IF EXISTS `noticiaValoraciones`;
CREATE TABLE `noticiaValoraciones`
(
	`IdNoticiaValoracion`  int(10) unsigned NOT NULL AUTO_INCREMENT,
	`IdNoticia`            int(10) NULL,
	`Valoracion`           INTEGER NOT NULL,
	`IdIntegrante`         int(10) NULL,
	PRIMARY KEY (`IdNoticiaValoracion`),
	FOREIGN KEY R_95 (`IdNoticia`) REFERENCES Noticias (`IdNoticia`),
	FOREIGN KEY R_100 (`IdIntegrante`) REFERENCES Integrantes (`IdIntegrante`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;