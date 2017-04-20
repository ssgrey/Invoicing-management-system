-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: db_database28
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `tb_gysinfo`
--

DROP TABLE IF EXISTS `tb_gysinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_gysinfo` (
  `id` varchar(32) NOT NULL COMMENT '供应商编号',
  `name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `jc` varchar(20) DEFAULT NULL COMMENT '简称',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `bianma` varchar(10) DEFAULT NULL COMMENT '邮编',
  `tel` varchar(15) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL COMMENT '传真',
  `lian` varchar(8) DEFAULT NULL COMMENT '联系人',
  `ltel` varchar(15) DEFAULT NULL COMMENT '联系人电话',
  `yh` varchar(50) DEFAULT NULL COMMENT '开户银行',
  `mail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_gysinfo`
--

LOCK TABLES `tb_gysinfo` WRITE;
/*!40000 ALTER TABLE `tb_gysinfo` DISABLE KEYS */;
INSERT INTO `tb_gysinfo` VALUES ('1001','苏宁易购','苏宁','南京','123000','123456','1457','辉','18341842036','建设银行','gsh0928'),('1002','国美电器','苏宁','南京','123000','123456','1457','辉','18341842036','建设银行','gsh0928'),('1003','京东商城','苏宁','南京','123000','123456','1457','辉','18341842036','建设银行','gsh0928');
/*!40000 ALTER TABLE `tb_gysinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jsr`
--

DROP TABLE IF EXISTS `tb_jsr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_jsr` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20171002 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jsr`
--

LOCK TABLES `tb_jsr` WRITE;
/*!40000 ALTER TABLE `tb_jsr` DISABLE KEYS */;
INSERT INTO `tb_jsr` VALUES (20171001,'宫帅辉','男','23','18341842036',5);
/*!40000 ALTER TABLE `tb_jsr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_khinfo`
--

DROP TABLE IF EXISTS `tb_khinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_khinfo` (
  `id` varchar(50) COLLATE utf8_bin NOT NULL,
  `khname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `jian` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `bianma` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `lian` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ltel` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `xinhang` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `hao` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_khinfo`
--

LOCK TABLES `tb_khinfo` WRITE;
/*!40000 ALTER TABLE `tb_khinfo` DISABLE KEYS */;
INSERT INTO `tb_khinfo` VALUES ('2006','小李','xl','郑州','14287','45546','4532857','45345','45343','4345','45343','43'),('kh7','万达','啊','北京','231','546','6546','5646','564','156','6516','345');
/*!40000 ALTER TABLE `tb_khinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_kucun`
--

DROP TABLE IF EXISTS `tb_kucun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_kucun` (
  `id` varchar(30) COLLATE utf8_bin NOT NULL,
  `spname` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `jc` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `gg` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `bz` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '包装',
  `dw` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '商品单位',
  `dj` float DEFAULT NULL COMMENT '单价',
  `kcsl` float DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_kucun`
--

LOCK TABLES `tb_kucun` WRITE;
/*!40000 ALTER TABLE `tb_kucun` DISABLE KEYS */;
INSERT INTO `tb_kucun` VALUES ('2001','ipad','平板','33*20','精装','台',2,0),('2002','watch','表','20*20','精装','台',20,78),('2004','米4','手机','14','1','t',5,132);
/*!40000 ALTER TABLE `tb_kucun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rkth_detail`
--

DROP TABLE IF EXISTS `tb_rkth_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_rkth_detail` (
  `id` float NOT NULL,
  `rkthID` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `spid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dj` float DEFAULT NULL,
  `sl` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rkthID` (`rkthID`),
  CONSTRAINT `tb_rkth_detail_ibfk_1` FOREIGN KEY (`rkthID`) REFERENCES `tb_rkth_main` (`rkthID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='进货退货详细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rkth_detail`
--

LOCK TABLES `tb_rkth_detail` WRITE;
/*!40000 ALTER TABLE `tb_rkth_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_rkth_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rkth_main`
--

DROP TABLE IF EXISTS `tb_rkth_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_rkth_main` (
  `rkthID` varchar(30) COLLATE utf8_bin NOT NULL,
  `pzs` float DEFAULT NULL,
  `je` float DEFAULT NULL,
  `ysjl` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `gysname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `rtdate` datetime DEFAULT NULL,
  `czy` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `jsr` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `jsfs` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`rkthID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='进货退货主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rkth_main`
--

LOCK TABLES `tb_rkth_main` WRITE;
/*!40000 ALTER TABLE `tb_rkth_main` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_rkth_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ruku_detail`
--

DROP TABLE IF EXISTS `tb_ruku_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ruku_detail` (
  `id` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '流水号',
  `rkID` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '入库编号',
  `spid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商品编号',
  `dj` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '单价',
  `sl` float DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`),
  KEY `rkID` (`rkID`),
  CONSTRAINT `tb_ruku_detail_ibfk_1` FOREIGN KEY (`rkID`) REFERENCES `tb_ruku_main` (`rkID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='入库明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ruku_detail`
--

LOCK TABLES `tb_ruku_detail` WRITE;
/*!40000 ALTER TABLE `tb_ruku_detail` DISABLE KEYS */;
INSERT INTO `tb_ruku_detail` VALUES ('2','RK20170318001','2002','10.0',50),('3','RK20170318002','2002','10.0',200),('4','RK20170318002','2004','10.0',120),('5','RK20170329001','2002','20.0',1),('6','RK20170329001','2004','10.0',20);
/*!40000 ALTER TABLE `tb_ruku_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ruku_main`
--

DROP TABLE IF EXISTS `tb_ruku_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ruku_main` (
  `rkID` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '入库编号',
  `pzs` float DEFAULT NULL COMMENT '品种数量',
  `je` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '总计金额',
  `ysjl` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '验收结论',
  `gysname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商名称',
  `rkdate` datetime(6) DEFAULT NULL COMMENT '入库时间',
  `czy` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '操作员',
  `jsr` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '经手人',
  `jsfs` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '结算方式',
  PRIMARY KEY (`rkID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ruku_main`
--

LOCK TABLES `tb_ruku_main` WRITE;
/*!40000 ALTER TABLE `tb_ruku_main` DISABLE KEYS */;
INSERT INTO `tb_ruku_main` VALUES ('RK20170318001',2,'1500.0','恩','国美电器','2017-03-18 00:00:00.000000','辉','张三','支付宝'),('RK20170318002',2,'3200.0','恩','国美电器','2017-03-18 00:00:00.000000','辉','张三','支付宝'),('RK20170329001',2,'220.0','合格','国美电器','2017-03-29 00:00:00.000000','辉','张三','支付宝'),('RK20170406001',1,'0.0','额','苏宁易购','2017-04-06 00:00:00.000000','辉','张三','支付宝');
/*!40000 ALTER TABLE `tb_ruku_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sell_detail`
--

DROP TABLE IF EXISTS `tb_sell_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sell_detail` (
  `id` int(11) NOT NULL COMMENT '流水号',
  `sellID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '销售编号',
  `spid` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商品编号',
  `dj` float DEFAULT NULL COMMENT '销售单价',
  `sl` float DEFAULT NULL COMMENT '销售数量',
  PRIMARY KEY (`id`),
  KEY `sellID` (`sellID`),
  CONSTRAINT `tb_sell_detail_ibfk_1` FOREIGN KEY (`sellID`) REFERENCES `tb_sell_main` (`sellID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sell_detail`
--

LOCK TABLES `tb_sell_detail` WRITE;
/*!40000 ALTER TABLE `tb_sell_detail` DISABLE KEYS */;
INSERT INTO `tb_sell_detail` VALUES (2,'XS20170331001','2004',5,2),(3,'XS20170331001','2002',20,1),(4,'XS20170331002','2004',5,2),(5,'XS20170331003','2004',5,4),(6,'XS20170331004','2002',20,2),(7,'XS20170331004','2002',20,2),(8,'XS20170401001','2002',20,1);
/*!40000 ALTER TABLE `tb_sell_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sell_main`
--

DROP TABLE IF EXISTS `tb_sell_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sell_main` (
  `sellID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '销售编号',
  `pzs` float DEFAULT NULL COMMENT '销售品种数',
  `je` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '总计金额',
  `ysjl` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '验收结论',
  `khname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客户名称',
  `xsdate` datetime DEFAULT NULL COMMENT '销售日期',
  `czy` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '操作员',
  `jsr` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '经办人',
  `jsfs` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '结算方式',
  PRIMARY KEY (`sellID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sell_main`
--

LOCK TABLES `tb_sell_main` WRITE;
/*!40000 ALTER TABLE `tb_sell_main` DISABLE KEYS */;
INSERT INTO `tb_sell_main` VALUES ('XS20170331001',2,'30.0','额','小李','2017-03-31 09:18:43','宫帅辉','宫帅辉','支付宝'),('XS20170331002',1,'10.0','哦','校长','2017-03-31 09:20:02','宫帅辉','宫帅辉','支付宝'),('XS20170331003',1,'20.0','哦','校长','2017-03-31 09:20:13','宫帅辉','宫帅辉','支付宝'),('XS20170331004',2,'80.0','哦','校长','2017-03-31 09:20:32','宫帅辉','宫帅辉','微信'),('XS20170401001',1,'20.0','哦','校长','2017-04-01 13:02:11','宫帅辉','宫帅辉','支付宝');
/*!40000 ALTER TABLE `tb_sell_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_spinfo`
--

DROP TABLE IF EXISTS `tb_spinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_spinfo` (
  `id` varchar(32) NOT NULL COMMENT '商品编号',
  `spname` varchar(50) DEFAULT NULL COMMENT '商品名',
  `jc` varchar(30) DEFAULT NULL COMMENT '简称',
  `cd` varchar(50) DEFAULT NULL COMMENT '产地',
  `dw` varchar(10) DEFAULT NULL COMMENT '商品计量单位',
  `gg` varchar(10) DEFAULT NULL COMMENT '商品规格',
  `bz` varchar(20) DEFAULT NULL COMMENT '包装',
  `ph` varchar(32) DEFAULT NULL COMMENT '批号',
  `pzwh` varchar(50) DEFAULT NULL COMMENT '批准文号',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `gysname` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_spinfo`
--

LOCK TABLES `tb_spinfo` WRITE;
/*!40000 ALTER TABLE `tb_spinfo` DISABLE KEYS */;
INSERT INTO `tb_spinfo` VALUES ('2001','ipad','平板','北京','台','33*20','精装','156498','147687','无','苏宁易购'),('2002','watch','表','北京','台','20*20','精装','141','827277','无','国美电器'),('2003','tv','电视','上海','台','1800*1920','简装','452524','147728','1','京东商城'),('2004','米4','手机','bei','t','15*10','简装','4527','4524','54','国美电器'),('2005','笔记本电脑','笔记本','浙江','台','44*33','精装','4146','654654987','额','京东商城');
/*!40000 ALTER TABLE `tb_spinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_userlist`
--

DROP TABLE IF EXISTS `tb_userlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_userlist` (
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pass` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `quan` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_userlist`
--

LOCK TABLES `tb_userlist` WRITE;
/*!40000 ALTER TABLE `tb_userlist` DISABLE KEYS */;
INSERT INTO `tb_userlist` VALUES ('宫帅辉','hui','123456','1');
/*!40000 ALTER TABLE `tb_userlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_xsth_detail`
--

DROP TABLE IF EXISTS `tb_xsth_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_xsth_detail` (
  `id` float NOT NULL,
  `xsthID` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `spid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `dj` float DEFAULT NULL,
  `sl` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `xsthID` (`xsthID`),
  CONSTRAINT `tb_xsth_detail_ibfk_1` FOREIGN KEY (`xsthID`) REFERENCES `tb_xsth_main` (`xsthID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售退货详细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_xsth_detail`
--

LOCK TABLES `tb_xsth_detail` WRITE;
/*!40000 ALTER TABLE `tb_xsth_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_xsth_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_xsth_main`
--

DROP TABLE IF EXISTS `tb_xsth_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_xsth_main` (
  `xsthID` varchar(30) COLLATE utf8_bin NOT NULL,
  `pzs` float DEFAULT NULL,
  `je` float DEFAULT NULL,
  `ysjl` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `khname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `thdate` datetime DEFAULT NULL,
  `czy` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `jsr` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `jsfs` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`xsthID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='销售退货主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_xsth_main`
--

LOCK TABLES `tb_xsth_main` WRITE;
/*!40000 ALTER TABLE `tb_xsth_main` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_xsth_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_sellview`
--

DROP TABLE IF EXISTS `v_sellview`;
/*!50001 DROP VIEW IF EXISTS `v_sellview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_sellview` AS SELECT 
 1 AS `sellID`,
 1 AS `spname`,
 1 AS `spid`,
 1 AS `gg`,
 1 AS `dj`,
 1 AS `sl`,
 1 AS `je`,
 1 AS `khname`,
 1 AS `xsdate`,
 1 AS `czy`,
 1 AS `jsr`,
 1 AS `jsfs`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_sellview`
--

/*!50001 DROP VIEW IF EXISTS `v_sellview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_sellview` AS select `tb_sell_detail`.`sellID` AS `sellID`,`tb_spinfo`.`spname` AS `spname`,`tb_sell_detail`.`spid` AS `spid`,`tb_spinfo`.`gg` AS `gg`,`tb_sell_detail`.`dj` AS `dj`,`tb_sell_detail`.`sl` AS `sl`,`tb_sell_main`.`je` AS `je`,`tb_sell_main`.`khname` AS `khname`,`tb_sell_main`.`xsdate` AS `xsdate`,`tb_sell_main`.`czy` AS `czy`,`tb_sell_main`.`jsr` AS `jsr`,`tb_sell_main`.`jsfs` AS `jsfs` from ((`tb_sell_main` join `tb_sell_detail` on((`tb_sell_main`.`sellID` = `tb_sell_detail`.`sellID`))) join `tb_spinfo` on((`tb_sell_detail`.`spid` = `tb_spinfo`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-06 13:10:24
