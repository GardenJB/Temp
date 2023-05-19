-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` VARCHAR(45) NULL DEFAULT NULL,
  `likecategory` VARCHAR(45) NOT NULL,
  `regionId` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`region` (
  `regionId` INT NOT NULL,
  `regionname` VARCHAR(45) NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`regionId`, `User_id`),
  INDEX `fk_Region_User_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Region_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`gathering`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`gathering` (
  `gatheringId` INT NOT NULL AUTO_INCREMENT,
  `recruit` TINYINT NOT NULL DEFAULT '0',
  `writer` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `regionId` INT NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `info` VARCHAR(100) NOT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  `regDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `modiDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Region_regionId` INT NOT NULL,
  `Region_User_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`gatheringId`, `User_id`),
  INDEX `fk_Gathering_Region1_idx` (`Region_regionId` ASC, `Region_User_id` ASC) VISIBLE,
  INDEX `fk_Gathering_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Gathering_Region1`
    FOREIGN KEY (`Region_regionId` , `Region_User_id`)
    REFERENCES `mydb`.`region` (`regionId` , `User_id`),
  CONSTRAINT `fk_Gathering_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`category` (
  `categoryId` INT NOT NULL,
  `categoryname` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  `gathering_gatheringId` INT NOT NULL,
  `gathering_User_id` INT NOT NULL,
  PRIMARY KEY (`categoryId`),
  INDEX `fk_category_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_category_gathering1_idx` (`gathering_gatheringId` ASC, `gathering_User_id` ASC) VISIBLE,
  CONSTRAINT `fk_category_gathering1`
    FOREIGN KEY (`gathering_gatheringId` , `gathering_User_id`)
    REFERENCES `mydb`.`gathering` (`gatheringId` , `User_id`),
  CONSTRAINT `fk_category_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`history` (
  `id` INT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `gatheringId` VARCHAR(45) NOT NULL,
  `User_id` INT NOT NULL,
  `gathering_gatheringId` INT NOT NULL,
  `gathering_User_id` INT NOT NULL,
  PRIMARY KEY (`id`, `gathering_gatheringId`, `gathering_User_id`),
  INDEX `fk_history_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_history_gathering1_idx` (`gathering_gatheringId` ASC, `gathering_User_id` ASC) VISIBLE,
  CONSTRAINT `fk_history_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`user` (`id`),
  CONSTRAINT `fk_history_gathering1`
    FOREIGN KEY (`gathering_gatheringId` , `gathering_User_id`)
    REFERENCES `mydb`.`gathering` (`gatheringId` , `User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`openapi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`openapi` (
  `API` VARCHAR(100) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
