DROP TABLE IF EXISTS `mensajeDetalles`;

CREATE TABLE `mensajeDetalles`
(
	`IdMensajeDetalle`     int(10) unsigned NOT NULL AUTO_INCREMENT,
	`Mensaje`              LONGBLOB NOT NULL,
	`IdMensaje`            int(10) NULL,
	PRIMARY KEY (`IdMensajeDetalle`),
	FOREIGN KEY R_101 (`IdMensaje`) REFERENCES Mensajes (`IdMensaje`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
