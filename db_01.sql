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
-- Table `mydb`.`Rank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rank` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Region` (
  `regionId` INT NOT NULL,
  `regionname` VARCHAR(45) NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`regionId`, `User_id`),
  INDEX `fk_Region_User_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Region_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Gathering`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Gathering` (
  `gatheringId` INT NOT NULL AUTO_INCREMENT,
  `recruit` TINYINT NOT NULL DEFAULT 0,
  `writer` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `regionId` INT NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `info` VARCHAR(100) NOT NULL,
  `img` VARCHAR(45) NULL,
  `regDate` DATETIME GENERATED ALWAYS AS (now()) VIRTUAL,
  `modiDate` DATETIME GENERATED ALWAYS AS (now()) VIRTUAL,
  `Region_regionId` INT NOT NULL,
  `Region_User_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`gatheringId`, `User_id`),
  INDEX `fk_Gathering_Region1_idx` (`Region_regionId` ASC, `Region_User_id` ASC) VISIBLE,
  INDEX `fk_Gathering_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Gathering_Region1`
    FOREIGN KEY (`Region_regionId` , `Region_User_id`)
    REFERENCES `mydb`.`Region` (`regionId` , `User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gathering_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `writer` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `Gathering_gatheringId` INT NOT NULL,
  `Gathering_User_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Gathering_gatheringId`, `Gathering_User_id`),
  INDEX `fk_review_Gathering1_idx` (`Gathering_gatheringId` ASC, `Gathering_User_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_Gathering1`
    FOREIGN KEY (`Gathering_gatheringId` , `Gathering_User_id`)
    REFERENCES `mydb`.`Gathering` (`gatheringId` , `User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- ---------------------rank--------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `img` VARCHAR(45) NULL,
  `rank` VARCHAR(45) NULL,
  `birthday` VARCHAR(45) NULL,
  `likecategory` VARCHAR(45) NOT NULL,
  `regionId` INT NOT NULL,
  `Rank_id` INT NOT NULL,
  `review_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Rank_id`, `review_id`),
  INDEX `fk_User_Rank1_idx` (`Rank_id` ASC) VISIBLE,
  INDEX `fk_User_review1_idx` (`review_id` ASC) VISIBLE,
  CONSTRAINT `fk_User_Rank1`
    FOREIGN KEY (`Rank_id`)
    REFERENCES `mydb`.`Rank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `mydb`.`Review` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Board` (
  `boardId` INT NOT NULL AUTO_INCREMENT,
  `gatheringId` INT NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `regDate` DATETIME GENERATED ALWAYS AS (now()) VIRTUAL,
  `Gathering_gatheringId` INT NOT NULL,
  `Gathering_User_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`boardId`, `User_id`),
  INDEX `fk_Board_Gathering1_idx` (`Gathering_gatheringId` ASC, `Gathering_User_id` ASC) VISIBLE,
  INDEX `fk_Board_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Board_Gathering1`
    FOREIGN KEY (`Gathering_gatheringId` , `Gathering_User_id`)
    REFERENCES `mydb`.`Gathering` (`gatheringId` , `User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Board_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`History`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`History` (
  `id` INT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `gatheringId` VARCHAR(45) NOT NULL,
  `boardId` VARCHAR(45) NOT NULL,
  `User_id` INT NOT NULL,
  `User_Rank_id` INT NOT NULL,
  `User_review_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_history_User1_idx` (`User_id` ASC, `User_Rank_id` ASC, `User_review_id` ASC) VISIBLE,
  CONSTRAINT `fk_history_User1`
    FOREIGN KEY (`User_id` , `User_Rank_id` , `User_review_id`)
    REFERENCES `mydb`.`User` (`id` , `Rank_id` , `review_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OpenAPI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OpenAPI` (
)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
