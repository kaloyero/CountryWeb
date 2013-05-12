DROP TABLE IF EXISTS `noticiaCategorias`;
CREATE TABLE `noticiaCategorias`
(
	`IdCategoria`          int(10) unsigned NOT NULL AUTO_INCREMENT,
	`Descripcion`          VARCHAR(50) NULL,
	PRIMARY KEY (`IdCategoria`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
