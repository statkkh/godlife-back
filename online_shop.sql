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
-- -----------------------------------------------------
-- Schema online_shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_shop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE TABLE `product` (
  `product_number` INT NOT NULL COMMENT '상품 번호',
  `product_name` VARCHAR(45) NULL COMMENT '상품 이름',
  `price` INT NOT NULL COMMENT '가격',
  `register_date` DATETIME NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '등록일',
  PRIMARY KEY (`product_number`),
  UNIQUE KEY `product_number_UNIQUE` (`product_number` ) 
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_shop`.`user`
-- -----------------------------------------------------
CREATE TABLE `user` (
  `email` VARCHAR(50) NOT NULL COMMENT '유저 이메일',
  `password` VARCHAR(255) NULL DEFAULT NULL COMMENT '유저 비밀번호',
  `nickname` VARCHAR(50) NOT NULL COMMENT '유저 닉네임',
  `tel_number` VARCHAR(15) NOT NULL COMMENT '전화번호',
  PRIMARY KEY (`email`)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE  `order` (
  `order_number` INT NOT NULL COMMENT '주문번호',
  `user_email` VARCHAR(50) NOT NULL COMMENT '회원 이메일',
  `order_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문날짜',
  PRIMARY KEY (`order_number`),
  INDEX `fk_order_user_idx` (`user_email` ) ,
  UNIQUE KEY `order_number_UNIQUE` (`order_number` ),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_email`) REFERENCES `online_shop`.`user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE `order_detail` (
  `order_detail_number` INT NOT NULL COMMENT '주문처리 번호',
  `order_number` INT NOT NULL COMMENT '주문 번호',
  `product_number` INT NOT NULL COMMENT '상품번호',
  `quantity` INT NOT NULL DEFAULT 0 COMMENT '수량',
  `result` TINYINT NULL DEFAULT 0 COMMENT '처리유무',
  PRIMARY KEY (`order_detail_number`),
  UNIQUE KEY `order_detail_number_UNIQUE` (`order_detail_number` ),
  INDEX `fk_order_detail_order1_idx` (`order_number`),
  INDEX `fk_order_detail_product1_idx` (`product_number`),
  CONSTRAINT `fk_order_detail_order1` FOREIGN KEY (`order_number`) REFERENCES `mydb`.`order` (`order_number`)
    ON DELETE CASCADE    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_detail_product1` FOREIGN KEY (`product_number`) REFERENCES `mydb`.`product` (`product_number`)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`cart`
-- -----------------------------------------------------
CREATE TABLE `cart` (
  `cart_number` INT NOT NULL COMMENT '장바구니 번호',
  `user_email` VARCHAR(50) NOT NULL COMMENT '회원 이메일',
  `product_number` INT NOT NULL COMMENT '상품번호',
  `quantity` INT NULL COMMENT '수량',
  `result` TINYINT(1) NOT NULL COMMENT '배송 유무',
  `cart_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '카트 담은 날짜',
  PRIMARY KEY (`cart_number`),
  UNIQUE KEY `cart_number_UNIQUE` (`cart_number`),
  INDEX `fk_cart_product1_idx` (`product_number`),
  INDEX `fk_cart_user1_idx` (`user_email`),
  CONSTRAINT `fk_cart_product1` FOREIGN KEY (`product_number`) REFERENCES `product` (`product_number`)
    ON DELETE CASCADE    ON UPDATE CASCADE,
  CONSTRAINT `fk_cart_user1`    FOREIGN KEY (`user_email`) REFERENCES `user` (`email`)
    ON DELETE CASCADE    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
CREATE TABLE `employee` (
  `employee_email` VARCHAR(50) NOT NULL COMMENT '관리자 이메일',
  `employee_name` VARCHAR(45) NOT NULL COMMENT '관리자 이름',
  PRIMARY KEY (`employee_email`))
ENGINE = InnoDB;

USE `online_shop` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
