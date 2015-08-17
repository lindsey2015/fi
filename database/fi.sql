SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `qcfi` ;
CREATE SCHEMA IF NOT EXISTS `qcfi` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `qcfi` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE  TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  `user_type` TINYINT(2) NOT NULL ,
  `company_name` VARCHAR(150) NOT NULL ,
  `channel_name` VARCHAR(255) NOT NULL COMMENT '渠道名称' ,
  `channel_contact` VARCHAR(255) NOT NULL COMMENT '渠道联系人' ,
  `channel_contact_type` VARCHAR(255) NOT NULL COMMENT '渠道联系方式' ,
  `contact` VARCHAR(255) NULL COMMENT '联系人' ,
  `cell_phone` VARCHAR(50) NULL ,
  `phone` VARCHAR(50) NULL ,
  `email` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `plan` ;

CREATE  TABLE IF NOT EXISTS `plan` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `code` CHAR(4) NOT NULL COMMENT '编码\nVARCHAR2(3)\n01' ,
  `name` VARCHAR(60) NOT NULL COMMENT '名称\nVARCHAR2(60)\n华泰一切险' ,
  `description` VARCHAR(500) NOT NULL COMMENT '描述\nVARCHAR2(500)\n说明...' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `policy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `policy` ;

CREATE  TABLE IF NOT EXISTS `policy` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `plan_id` INT NOT NULL ,
  `applicant_name` VARCHAR(150) NOT NULL COMMENT '投保人' ,
  `insured_name` VARCHAR(150) NOT NULL COMMENT '被保险人' ,
  `freight_name` VARCHAR(800) NOT NULL COMMENT '货物名称：耐火材料' ,
  `freight_type` VARCHAR(200) NOT NULL COMMENT '货物类型编码：02' ,
  `package_and_quantity` VARCHAR(400) NOT NULL COMMENT '1*20GP' ,
  `package_type` VARCHAR(45) NULL COMMENT '包装类型：' ,
  `billl_no` VARCHAR(200) NOT NULL COMMENT '提单号：AS PER B/L' ,
  `invoice_no` VARCHAR(200) NULL COMMENT '发票号：KST-2008-160' ,
  `contract_no` VARCHAR(200) NULL COMMENT '贸易合同号' ,
  `container_no` VARCHAR(200) NULL COMMENT '集装箱号码' ,
  `invoice_amt` DECIMAL(16,2) NOT NULL COMMENT '发票金额：1000000.00' ,
  `add_rate` DECIMAL(4,3) NOT NULL COMMENT '加成：1.1' ,
  `amount` DECIMAL(20,6) NOT NULL COMMENT '保险金额：1100000.00' ,
  `amt_currency` CHAR(2) NOT NULL COMMENT '保额币种编码：01' ,
  `amt_exchange_rate` DECIMAL(20,6) NOT NULL COMMENT '汇率' ,
  `charge_rate` DECIMAL(20,6) NOT NULL COMMENT '费率：0.5' ,
  `premium` DECIMAL(20,6) NOT NULL COMMENT '保费：30' ,
  `transport_type` CHAR(2) NOT NULL COMMENT '运输方式（编码）:01' ,
  `traffic_no` VARCHAR(200) NOT NULL COMMENT 'SD23456' ,
  `ship_name` VARCHAR(255) NULL COMMENT '船名' ,
  `express_no` VARCHAR(200) NULL COMMENT '快递单号' ,
  `is_container` TINYINT NULL COMMENT '是否为集装箱（运输方式选择2时带出，其他不需要）' ,
  `departure_country` VARCHAR(200) NOT NULL COMMENT '起运地国家（编码）:01' ,
  `departure_city` VARCHAR(200) NOT NULL COMMENT '起运地: 广州' ,
  `destination_country` VARCHAR(200) NOT NULL COMMENT '目的地国家 （编码）:25' ,
  `destination_city` VARCHAR(200) NOT NULL COMMENT '目的地: 北京' ,
  `departure_date` DATE NOT NULL COMMENT '起运时间\nDATE\nYYYY-MM-DD\n2012-12-26' ,
  `survey_addr_code` VARCHAR(200) NOT NULL COMMENT '查勘地址地址编码\nVARCHAR2(200)\n138\nM' ,
  `note` VARCHAR(1024) NULL ,
  `is_international` TINYINT(1) NOT NULL ,
  `status` VARCHAR(45) NOT NULL ,
  `created_date` DATE NOT NULL ,
  `updated_date` DATE NOT NULL ,
  `updated_by` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_id_idx` (`user_id` ASC) ,
  INDEX `fk_plan_id_idx` (`plan_id` ASC) ,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_id`
    FOREIGN KEY (`plan_id` )
    REFERENCES `plan` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `applicant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `applicant` ;

CREATE  TABLE IF NOT EXISTS `applicant` (
  `id` INT NOT NULL ,
  `applicant_code` VARCHAR(14) NOT NULL COMMENT '投保人编码,固定投保人填写华泰提供的编码，投保人不固定则为空' ,
  `applicant_name` VARCHAR(150) NOT NULL COMMENT '投保人名称\nVARCHAR2(150)\n某物流公司' ,
  `gender` CHAR(2) NULL COMMENT 'Man:M,Woman:F,Unassigned:X signed:X' ,
  `birthday` DATE NULL COMMENT 'yyyy-mm-dd' ,
  `identity_type` VARCHAR(150) NULL COMMENT '证件类别 01-身份证;02-军官证;03-护照;04-驾驶执照;05-返乡证;99-其它,使用编号' ,
  `identity` VARCHAR(20) NULL ,
  `phone` VARCHAR(50) NULL COMMENT '66668888' ,
  `cell_phone` VARCHAR(50) NULL COMMENT '13801380000' ,
  `zip` VARCHAR(50) NULL ,
  `address` VARCHAR(100) NULL ,
  `email` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `insured`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `insured` ;

CREATE  TABLE IF NOT EXISTS `insured` (
  `id` INT NOT NULL ,
  `insured_name` VARCHAR(150) NOT NULL COMMENT '被保险人名称\nVARCHAR2(150)\n某货运公司\nM' ,
  `gender` CHAR(2) NULL COMMENT 'Man:M,Woman:F,Unassigned:X signed:X' ,
  `birthday` DATE NULL COMMENT 'yyyy-mm-dd' ,
  `identity_type` VARCHAR(150) NULL COMMENT '证件类别 01-身份证;02-军官证;03-护照;04-驾驶执照;05-返乡证;99-其它,使用编号' ,
  `identity` VARCHAR(20) NULL ,
  `phone` VARCHAR(50) NULL COMMENT '66668888' ,
  `cell_phone` VARCHAR(50) NULL COMMENT '13801380000' ,
  `zip` VARCHAR(50) NULL ,
  `address` VARCHAR(100) NULL ,
  `email` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

USE `qcfi` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
