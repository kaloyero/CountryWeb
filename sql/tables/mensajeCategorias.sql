DROP TABLE IF EXISTS `mensajeCategorias`;

CREATE TABLE `mensajeCategorias`
(
	`IdMensajeCategoria`   int(10) unsigned NOT NULL AUTO_INCREMENT,
	`Descripcion`          VARCHAR(50) NOT NULL,
	PRIMARY KEY (`IdMensajeCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
