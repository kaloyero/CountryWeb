DROP TABLE IF EXISTS `noticiaAdjuntos`;
CREATE TABLE `noticiaAdjuntos`
(
	`IdNoticiaAdjunto`     int(10) unsigned NOT NULL AUTO_INCREMENT,
	`IdNoticia`            INTEGER NULL,
	`Adjunto`              VARCHAR(100) NOT NULL,
	PRIMARY KEY (`IdNoticiaAdjunto`),
	FOREIGN KEY R_94 (`IdNoticia`) REFERENCES Noticias (`IdNoticia`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
