
CREATE database IF NOT EXISTS `1Q1A` DEFAULT CHARACTER SET utf8 ;
USE `1Q1A` ;

-- -----------------------------------------------------
-- Table `1Q1A`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `1Q1A`.`user` (
  `id` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `1Q1A`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `group` (
  `groupgId` INT NOT NULL AUTO_INCREMENT,
  `recruit` TINYINT NOT NULL DEFAULT '0',
  `writer` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `regionname` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `info` VARCHAR(100) NOT NULL,
  `img` VARCHAR(100) NULL DEFAULT NULL,
  `regDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `modiDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,

  PRIMARY KEY (`groupId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `1Q1A`.`history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `history` (
  `user_id` VARCHAR(50) NOT NULL,
  `group_groupId` INT NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `1q1a`.`mapapi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `1q1a`.`mapapi` (
  `address` VARCHAR(100) NOT NULL,
  `x` INT,
  `y` INT
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

