-- MySQL Script generated by MySQL Workbench
-- Tue Nov 28 13:05:21 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Avtosalon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Avtosalon` (
  `idAvtosalon` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `ownerName` VARCHAR(45) NULL,
  PRIMARY KEY (`idAvtosalon`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cars` (
  `idCars` INT NOT NULL,
  `seler` VARCHAR(45) NULL,
  `Avtosalon_idAvtosalon` INT NOT NULL,
  PRIMARY KEY (`idCars`, `Avtosalon_idAvtosalon`),
  INDEX `fk_Cars_Avtosalon1_idx` (`Avtosalon_idAvtosalon` ASC),
  CONSTRAINT `fk_Cars_Avtosalon1`
    FOREIGN KEY (`Avtosalon_idAvtosalon`)
    REFERENCES `mydb`.`Avtosalon` (`idAvtosalon`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_Detalis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_Detalis` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_Detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_Detail` (
  `idCar_Detail` INT NOT NULL,
  `maxSpeed` INT NULL,
  `maxDistanc` INT NULL,
  `model` VARCHAR(45) NULL,
  `class` VARCHAR(45) NULL,
  PRIMARY KEY (`idCar_Detail`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_Detail_has_Cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_Detail_has_Cars` (
  `Car_Detail_idCar_Detail` INT NOT NULL,
  `Cars_idCars` INT NOT NULL,
  `Cars_Avtosalon_idAvtosalon` INT NOT NULL,
  PRIMARY KEY (`Car_Detail_idCar_Detail`, `Cars_idCars`, `Cars_Avtosalon_idAvtosalon`),
  INDEX `fk_Car_Detail_has_Cars_Cars1_idx` (`Cars_idCars` ASC, `Cars_Avtosalon_idAvtosalon` ASC),
  INDEX `fk_Car_Detail_has_Cars_Car_Detail1_idx` (`Car_Detail_idCar_Detail` ASC),
  CONSTRAINT `fk_Car_Detail_has_Cars_Car_Detail1`
    FOREIGN KEY (`Car_Detail_idCar_Detail`)
    REFERENCES `mydb`.`Car_Detail` (`idCar_Detail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Car_Detail_has_Cars_Cars1`
    FOREIGN KEY (`Cars_idCars`)
    REFERENCES `mydb`.`Cars` (`idCars`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Car_Detail_has_Cars1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Car_Detail_has_Cars1` (
  `Car_Detail_idCar_Detail` INT NOT NULL,
  `Cars_idCars` INT NOT NULL,
  PRIMARY KEY (`Car_Detail_idCar_Detail`, `Cars_idCars`),
  INDEX `fk_Car_Detail_has_Cars1_Cars1_idx` (`Cars_idCars` ASC),
  INDEX `fk_Car_Detail_has_Cars1_Car_Detail1_idx` (`Car_Detail_idCar_Detail` ASC),
  CONSTRAINT `fk_Car_Detail_has_Cars1_Car_Detail1`
    FOREIGN KEY (`Car_Detail_idCar_Detail`)
    REFERENCES `mydb`.`Car_Detail` (`idCar_Detail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Car_Detail_has_Cars1_Cars1`
    FOREIGN KEY (`Cars_idCars`)
    REFERENCES `mydb`.`Cars` (`idCars`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
