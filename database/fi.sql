-- MySQL dump 10.13  Distrib 5.6.11, for Win64 (x86_64)
--
-- Host: localhost    Database: qcfi
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applicant_code` varchar(14) NOT NULL COMMENT '投保人编码,固定投保人填写华泰提供的编码，投保人不固定则为空',
  `applicant_name` varchar(150) NOT NULL COMMENT '投保人名称\nVARCHAR2(150)\n某物流公司',
  `gender` char(2) DEFAULT NULL COMMENT 'Man:M,Woman:F,Unassigned:X signed:X',
  `birthday` date DEFAULT NULL COMMENT 'yyyy-mm-dd',
  `identity_type` varchar(150) DEFAULT NULL COMMENT '证件类别 01-身份证;02-军官证;03-护照;04-驾驶执照;05-返乡证;99-其它,使用编号',
  `identity` varchar(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL COMMENT '66668888',
  `cell_phone` varchar(50) DEFAULT NULL COMMENT '13801380000',
  `zip` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insured`
--

DROP TABLE IF EXISTS `insured`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insured` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `insured_name` varchar(150) NOT NULL COMMENT '被保险人名称\nVARCHAR2(150)\n某货运公司\nM',
  `gender` char(2) DEFAULT NULL COMMENT 'Man:M,Woman:F,Unassigned:X signed:X',
  `birthday` date DEFAULT NULL COMMENT 'yyyy-mm-dd',
  `identity_type` varchar(150) DEFAULT NULL COMMENT '证件类别 01-身份证;02-军官证;03-护照;04-驾驶执照;05-返乡证;99-其它,使用编号',
  `identity` varchar(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL COMMENT '66668888',
  `cell_phone` varchar(50) DEFAULT NULL COMMENT '13801380000',
  `zip` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insured`
--

LOCK TABLES `insured` WRITE;
/*!40000 ALTER TABLE `insured` DISABLE KEYS */;
/*!40000 ALTER TABLE `insured` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(4) NOT NULL COMMENT '编码\nVARCHAR2(3)\n01',
  `name` varchar(60) NOT NULL COMMENT '名称\nVARCHAR2(60)\n华泰一切险',
  `description` varchar(500) NOT NULL COMMENT '描述\nVARCHAR2(500)\n说明...',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'1234','test','test'),(2,'1235','test2','test2');
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `plan_id` int(11) NOT NULL,
  `applicant_id` int(11) NOT NULL,
  `insured_id` int(11) NOT NULL,
  `freight_name` varchar(800) NOT NULL COMMENT '货物名称：耐火材料',
  `freight_type` varchar(200) NOT NULL COMMENT '货物类型编码：02',
  `package_and_quantity` varchar(400) NOT NULL COMMENT '1*20GP',
  `package_type` varchar(45) DEFAULT NULL COMMENT '包装类型：',
  `billl_no` varchar(200) NOT NULL COMMENT '提单号：AS PER B/L',
  `invoice_no` varchar(200) DEFAULT NULL COMMENT '发票号：KST-2008-160',
  `contract_no` varchar(200) DEFAULT NULL COMMENT '贸易合同号',
  `container_no` varchar(200) DEFAULT NULL COMMENT '集装箱号码',
  `invoice_amount` decimal(16,2) NOT NULL COMMENT '发票金额：1000000.00',
  `add_rate` decimal(4,3) NOT NULL COMMENT '加成：1.1',
  `amount` decimal(20,6) NOT NULL COMMENT '保险金额：1100000.00',
  `amount_currency` char(2) NOT NULL COMMENT '保额币种编码：01',
  `charge_rate` decimal(20,6) NOT NULL COMMENT '费率：0.5',
  `premium` decimal(20,6) NOT NULL COMMENT '保费：30',
  `transport_type` char(2) NOT NULL COMMENT '运输方式（编码）:01',
  `traffic_no` varchar(200) NOT NULL COMMENT 'SD23456',
  `ship_name` varchar(255) DEFAULT NULL COMMENT '船名',
  `express_no` varchar(200) DEFAULT NULL COMMENT '快递单号',
  `is_container` tinyint(4) DEFAULT NULL COMMENT '是否为集装箱（运输方式选择2时带出，其他不需要）',
  `departure_country` varchar(200) NOT NULL COMMENT '起运地国家（编码）:01',
  `departure_city` varchar(200) NOT NULL COMMENT '起运地: 广州',
  `destination_country` varchar(200) NOT NULL COMMENT '目的地国家 （编码）:25',
  `destination_city` varchar(200) NOT NULL COMMENT '目的地: 北京',
  `departure_date` date NOT NULL COMMENT '起运时间\nDATE\nYYYY-MM-DD\n2012-12-26',
  `survey_addr_code` varchar(200) NOT NULL COMMENT '查勘地址地址编码\nVARCHAR2(200)\n138\nM',
  `note` varchar(1024) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_applicant_id_idx` (`applicant_id`),
  KEY `fk_plan_id_idx` (`plan_id`),
  KEY `fk_insured_id_idx` (`insured_id`),
  CONSTRAINT `fk_applicant_id` FOREIGN KEY (`applicant_id`) REFERENCES `applicant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_insured_id` FOREIGN KEY (`insured_id`) REFERENCES `insured` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_id` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `company_name` varchar(150) NOT NULL,
  `channel_name` varchar(255) NOT NULL COMMENT '渠道名称',
  `channel_contact` varchar(255) NOT NULL COMMENT '渠道联系人',
  `channel_contact_type` varchar(255) NOT NULL COMMENT '渠道联系方式',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `cell_phone` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-23  1:05:13
