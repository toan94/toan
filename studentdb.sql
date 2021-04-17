-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema studentsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema studentsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `studentsdb` ;

-- -----------------------------------------------------
-- Table `studentsdb`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`courses` (
  `course_Id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`course_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `studentsdb`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`students` (
  `student_Id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `studentsdb`.`students_courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`students_courses` (
  `student_Id` INT NOT NULL,
  `course_Id` INT NOT NULL,
  PRIMARY KEY (`student_Id`, `course_Id`),
  INDEX `course_Id_idx` (`course_Id` ASC) VISIBLE,
  CONSTRAINT `course_Id`
    FOREIGN KEY (`course_Id`)
    REFERENCES `studentsdb`.`courses` (`course_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `student_Id`
    FOREIGN KEY (`student_Id`)
    REFERENCES `studentsdb`.`students` (`student_Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
