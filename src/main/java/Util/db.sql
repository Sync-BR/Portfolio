CREATE SCHEMA `portfolio` ;
CREATE TABLE `portfolio`.`login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `usuario`));
INSERT INTO `portfolio`.`login` (`id`, `usuario`, `password`) VALUES ('1', 'admin', '123');

