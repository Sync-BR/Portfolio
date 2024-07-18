CREATE SCHEMA `portfolio` ;
CREATE TABLE `portfolio`.`login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `usuario`));
INSERT INTO `portfolio`.`login` (`id`, `usuario`, `password`) VALUES ('1', 'admin', '123');


CREATE TABLE `portfolio`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(30) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `archiveName` VARCHAR(45) NOT NULL,
  `repository` VARCHAR(20) NOT NULL,
  `frontendProject` TINYINT NOT NULL,
  `backendProject` TINYINT NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`repository`)
);
