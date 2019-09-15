-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema facturaciondb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `facturaciondb` ;

-- -----------------------------------------------------
-- Schema facturaciondb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `facturaciondb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `facturaciondb` ;

-- -----------------------------------------------------
-- Table `facturaciondb`.`asignaturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`asignaturas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`asignaturas` (
  `idAsignaturas` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `descripcion` VARCHAR(450) NULL DEFAULT NULL,
  PRIMARY KEY (`idAsignaturas`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`clases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`clases` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`clases` (
  `idClases` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NOT NULL,
  `Duracion` FLOAT NULL DEFAULT NULL,
  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`idClases`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`cursos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`cursos` (
  `idCursos` INT(11) NOT NULL AUTO_INCREMENT,
  `curso` VARCHAR(45) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(450) NULL DEFAULT NULL,
  PRIMARY KEY (`idCursos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`cursos_has_asignaturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`cursos_has_asignaturas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`cursos_has_asignaturas` (
  `Cursos_idCursos` INT(11) NOT NULL,
  `Asignaturas_idAsignaturas` INT(11) NOT NULL,
  `curriculu` BLOB NULL DEFAULT NULL,
  `Descripcion` VARCHAR(245) NULL DEFAULT NULL,
  PRIMARY KEY (`Cursos_idCursos`, `Asignaturas_idAsignaturas`),
  CONSTRAINT `fk_Cursos_has_Asignaturas_Asignaturas1`
    FOREIGN KEY (`Asignaturas_idAsignaturas`)
    REFERENCES `facturaciondb`.`asignaturas` (`idAsignaturas`),
  CONSTRAINT `fk_Cursos_has_Asignaturas_Cursos`
    FOREIGN KEY (`Cursos_idCursos`)
    REFERENCES `facturaciondb`.`cursos` (`idCursos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_Cursos_has_Asignaturas_Asignaturas1` ON `facturaciondb`.`cursos_has_asignaturas` (`Asignaturas_idAsignaturas` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`datos_de_facturacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`datos_de_facturacion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`datos_de_facturacion` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`factura` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`factura` (
  `nºfactura` INT(11) NOT NULL,
  `Id_clase` INT(11) NOT NULL,
  PRIMARY KEY (`nºfactura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_idclase` ON `facturaciondb`.`factura` (`Id_clase` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`gastos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`gastos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`gastos` (
  `idGastos` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NULL DEFAULT NULL,
  `importe` FLOAT NULL DEFAULT NULL,
  `enlace` VARCHAR(100) NULL DEFAULT NULL,
  `Descripción` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idGastos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`precios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`precios` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`precios` (
  `idPrecios` INT(11) NOT NULL AUTO_INCREMENT,
  `PrecioFinal` FLOAT NULL DEFAULT NULL,
  `impuestos` DECIMAL(10,0) NULL DEFAULT NULL,
  `factor` DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (`idPrecios`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`rol` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`rol` (
  `idRol` INT(11) NOT NULL AUTO_INCREMENT,
  `Rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facturaciondb`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facturaciondb`.`usuarios` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facturaciondb`.`usuarios` (
  `email` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecharegistro` TIMESTAMP(1) NULL DEFAULT NULL,
  `rol_idRol` INT(11) NOT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `fk_usuarios_rol1`
    FOREIGN KEY (`rol_idRol`)
    REFERENCES `facturaciondb`.`rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE INDEX `fk_usuarios_rol1_idx` ON `facturaciondb`.`usuarios` (`rol_idRol` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
