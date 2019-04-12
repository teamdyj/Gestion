
-- -----------------------------------------------------
-- Database FacturacionDB
-- -----------------------------------------------------
DROP Database IF EXISTS `FacturacionDB` ;

-- -----------------------------------------------------
-- Database FacturacionDB
-- -----------------------------------------------------
CREATE Database IF NOT EXISTS `FacturacionDB` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `FacturacionDB` ;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`usuarios` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`usuarios` (
  `email` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `rol` VARCHAR(45) NULL,
  `fecharegistro` TIMESTAMP(1) NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Datos_de_facturacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Datos_de_facturacion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Datos_de_facturacion` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `usuarios_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `fk_Facturar_usuarios1`
    FOREIGN KEY (`usuarios_email`)
    REFERENCES `FacturacionDB`.`usuarios` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Facturar_usuarios1_idx` ON `FacturacionDB`.`Datos_de_facturacion` (`usuarios_email` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Cursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Cursos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Cursos` (
  `idCursos` INT NOT NULL AUTO_INCREMENT,
  `curso` VARCHAR(45) NULL,
  `Descripcion` VARCHAR(450) NULL,
  `Curricului` VARCHAR(450) NULL,
  PRIMARY KEY (`idCursos`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Asignaturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Asignaturas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Asignaturas` (
  `idAsignaturas` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `descripcion` VARCHAR(450) NULL,
  `curriculu` VARCHAR(450) NULL,
  PRIMARY KEY (`idAsignaturas`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Precios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Precios` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Precios` (
  `idPrecios` INT NOT NULL AUTO_INCREMENT,
  `Precio` FLOAT NULL,
  `impuestos` DECIMAL NULL,
  `factor` DECIMAL NULL,
  `asignatura` VARCHAR(100) NULL,
  PRIMARY KEY (`idPrecios`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `index` ON `FacturacionDB`.`Precios` (`asignatura` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Cursos_has_Asignaturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Cursos_has_Asignaturas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Cursos_has_Asignaturas` (
  `Cursos_idCursos` INT NOT NULL,
  `Asignaturas_idAsignaturas` INT NOT NULL,
  `usuarios_email` VARCHAR(45) NOT NULL,
  `Precios_idPrecios` INT NOT NULL,
  `id_cursoshasAsig` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cursos_idCursos`, `Asignaturas_idAsignaturas`, `Precios_idPrecios`, `usuarios_email`),
  CONSTRAINT `fk_Cursos_has_Asignaturas_Cursos`
    FOREIGN KEY (`Cursos_idCursos`)
    REFERENCES `FacturacionDB`.`Cursos` (`idCursos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_has_Asignaturas_Asignaturas1`
    FOREIGN KEY (`Asignaturas_idAsignaturas`)
    REFERENCES `FacturacionDB`.`Asignaturas` (`idAsignaturas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_has_Asignaturas_usuarios1`
    FOREIGN KEY (`usuarios_email`)
    REFERENCES `FacturacionDB`.`usuarios` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cursos_has_Asignaturas_Precios1`
    FOREIGN KEY (`Precios_idPrecios`)
    REFERENCES `FacturacionDB`.`Precios` (`idPrecios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Cursos_has_Asignaturas_Asignaturas1_idx` ON `FacturacionDB`.`Cursos_has_Asignaturas` (`Asignaturas_idAsignaturas` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_Cursos_has_Asignaturas_Cursos_idx` ON `FacturacionDB`.`Cursos_has_Asignaturas` (`Cursos_idCursos` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_Cursos_has_Asignaturas_usuarios1_idx` ON `FacturacionDB`.`Cursos_has_Asignaturas` (`usuarios_email` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_Cursos_has_Asignaturas_Precios1_idx` ON `FacturacionDB`.`Cursos_has_Asignaturas` (`Precios_idPrecios` ASC) ;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `FacturacionDB`.`Cursos_has_Asignaturas` (`id_cursoshasAsig` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Factura` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Factura` (
  `nºfactura` INT NOT NULL,
  `Datos de facturacion_dni` VARCHAR(9) NOT NULL,
  `Id_clase` INT NOT NULL,
  PRIMARY KEY (`nºfactura`),
  CONSTRAINT `fk_Factura_Datos de facturacion1`
    FOREIGN KEY (`Datos de facturacion_dni`)
    REFERENCES `FacturacionDB`.`Datos_de_facturacion` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Factura_Datos de facturacion1_idx` ON `FacturacionDB`.`Factura` (`Datos de facturacion_dni` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_idclase` ON `FacturacionDB`.`Factura` (`Id_clase` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Clases_Impartidas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Clases_Impartidas` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Clases_Impartidas` (
  `idClases_Impartidas` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NULL,
  `horas` FLOAT NULL,
  `Duracion` FLOAT NULL,
  `Descripcion` VARCHAR(450) NULL,
  `Cursos_has_Asignaturas_Cursos_idCursos` INT NOT NULL,
  `Cursos_has_Asignaturas_Asignaturas_idAsignaturas` INT NOT NULL,
  `Cursos_has_Asignaturas_Precios_idPrecios` INT NOT NULL,
  `Cursos_has_Asignaturas_usuarios_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClases_Impartidas`, `Cursos_has_Asignaturas_Asignaturas_idAsignaturas`, `Cursos_has_Asignaturas_Cursos_idCursos`),
  CONSTRAINT `fk_Clases_Impartidas_Cursos_has_Asignaturas1`
    FOREIGN KEY (`Cursos_has_Asignaturas_Cursos_idCursos` , `Cursos_has_Asignaturas_Asignaturas_idAsignaturas` , `Cursos_has_Asignaturas_Precios_idPrecios` , `Cursos_has_Asignaturas_usuarios_email`)
    REFERENCES `FacturacionDB`.`Cursos_has_Asignaturas` (`Cursos_idCursos` , `Asignaturas_idAsignaturas` , `Precios_idPrecios` , `usuarios_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Clases_Impartidas_Factura1`
    FOREIGN KEY (`idClases_Impartidas`)
    REFERENCES `FacturacionDB`.`Factura` (`Id_clase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Clases_Impartidas_Cursos_has_Asignaturas1_idx` ON `FacturacionDB`.`Clases_Impartidas` (`Cursos_has_Asignaturas_Cursos_idCursos` ASC, `Cursos_has_Asignaturas_Asignaturas_idAsignaturas` ASC, `Cursos_has_Asignaturas_Precios_idPrecios` ASC, `Cursos_has_Asignaturas_usuarios_email` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk-idclase` ON `FacturacionDB`.`Clases_Impartidas` (`idClases_Impartidas` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Tipo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Tipo` (
  `Tipo` VARCHAR(45) NOT NULL,
  `id _tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id _tipo`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `Tipo_UNIQUE` ON `FacturacionDB`.`Tipo` (`Tipo` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `FacturacionDB`.`Gastos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FacturacionDB`.`Gastos` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `FacturacionDB`.`Gastos` (
  `idGastos` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NULL,
  `importe` FLOAT NULL,
  `enlace` VARCHAR(100) NULL,
  `usuarios_email` VARCHAR(45) NOT NULL,
  `Tipo_id _tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGastos`),
  CONSTRAINT `fk_Gastos_usuarios1`
    FOREIGN KEY (`usuarios_email`)
    REFERENCES `FacturacionDB`.`usuarios` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gastos_Tipo1`
    FOREIGN KEY (`Tipo_id _tipo`)
    REFERENCES `FacturacionDB`.`Tipo` (`id _tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_Gastos_usuarios1_idx` ON `FacturacionDB`.`Gastos` (`usuarios_email` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_Gastos_Tipo1_idx` ON `FacturacionDB`.`Gastos` (`Tipo_id _tipo` ASC) ;
