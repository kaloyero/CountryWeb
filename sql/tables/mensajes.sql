DROP TABLE IF EXISTS `mensajes`;

CREATE TABLE `mensajes`
(
	`IdMensaje`            int(10) unsigned NOT NULL AUTO_INCREMENT,
	`Fecha`                DATE NOT NULL,
	`Asunto`               VARCHAR(50) NOT NULL,
	`FechaCierre`          DATE NOT NULL,
	`Resolucion`           VARCHAR(50) NOT NULL,
	`Estado`               VARCHAR(1) NOT NULL,
	`IdMensajeCategoria`   int(10) NULL,
	`IdIntegrante`         int(10) NULL,
	`TipoMensaje`          VARCHAR(1) NOT NULL,
	PRIMARY KEY (`IdMensaje`),
	FOREIGN KEY R_102 (`IdMensajeCategoria`) REFERENCES mensajeCategorias (`IdMensajeCategoria`),
	FOREIGN KEY R_103 (`IdIntegrante`) REFERENCES Integrantes (`IdIntegrante`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
