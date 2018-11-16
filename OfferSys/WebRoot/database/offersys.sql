-- MySQL dump 10.13  Distrib 5.5.45, for Win32 (x86)
--
-- Host: localhost    Database: offerSys
-- ------------------------------------------------------
-- Server version	5.5.45

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
-- Table structure for table `dvrdetail`
--

DROP TABLE IF EXISTS `dvrdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dvrdetail` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `imageId` varchar(255) NOT NULL,
  `productType` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `lcd` varchar(255) NOT NULL,
  `frontCamera` varchar(255) NOT NULL,
  `videoFormat` varchar(255) NOT NULL,
  `frameRate` varchar(255) NOT NULL,
  `photoResolution` varchar(255) NOT NULL,
  `photoFormat` varchar(255) NOT NULL,
  `storageCard` varchar(255) NOT NULL,
  `cardCapacity` varchar(255) NOT NULL,
  `rearCamera` varchar(255) NOT NULL,
  `gsensor` varchar(255) NOT NULL,
  `gps` varchar(255) NOT NULL,
  `wifi` varchar(255) NOT NULL,
  `tvout` varchar(255) NOT NULL,
  `hdmi` varchar(255) NOT NULL,
  `wdr` varchar(255) NOT NULL,
  `adas` varchar(255) NOT NULL,
  `usb` varchar(255) NOT NULL,
  `powerSource` varchar(255) NOT NULL,
  `batter` varchar(255) NOT NULL,
  `mic` varchar(255) NOT NULL,
  `speaker` varchar(255) NOT NULL,
  `language` varchar(255) NOT NULL,
  `operatingTemperature` varchar(255) NOT NULL,
  `storageTemperature` varchar(255) NOT NULL,
  `weight` varchar(100) DEFAULT NULL,
  `dimension` varchar(100) DEFAULT NULL,
  `htmlStatic` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dvrdetail`
--

LOCK TABLES `dvrdetail` WRITE;
/*!40000 ALTER TABLE `dvrdetail` DISABLE KEYS */;
INSERT INTO `dvrdetail` VALUES (30,'/CPR-2710小.jpg','Car DVR','CPR-2710','MSC8328P','2.7\"(320X240)','CMOS:2M,GC2023;lens:4G,D=144，H=112，V=59','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 128G','YES;CMOS:1M,H62;lens:4E,D=170，H=105;1280*720P@30fps','YES','NO','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.5A','300mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','122X48X26.8MM',0),(13,'/CPR-1522小.jpg','Car DVR','CPR-1522','NT96223','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R,D=100,H=87,V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','34g','60*42*25.9mm',0),(12,'/CPR-1510.jpg','Car DVR','CPR-1510','AC5202B','1.5\"（480X240）','CMOS:1M, JX-H62;Lens:4G+1R,D=100，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','42g','59*49.5*35mm',0),(10,'/CPR-2002-111.jpg','Car DVR','CPR-2002','MSC8328P','2.0\"（480X240）','CMOS:2M,GC2023/OV2710;lens:4G+1R,D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support:128G','YES(Option);CVBS 0.3M VGA','YES','YES(Option)','NO','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.0A','Super Capacitor 2.7V/4.7F*2','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','51.6g','71*47*37.6mm',0),(43,'/CPR-2002-111.jpg','Car DVR','CPR-2002Q','MSC8328Q','2.0\"（480X240）','CMOS:4M,OV4689;Lens:4G+1R,D=130，H=100，V=80','H.264 AVI','2K,2560*1440@30fps;1920*1080@30fps;1280*720@30fps','4M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M,VGA@30fps','YES','YES(Option)','NO','NO','NO','YES','YES(Option)','USB2.0','MinUSB  5V/1.5A','Super Capacitor 2.7V/4.7F*2','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','51.6g','71*47*37.6mm',0),(11,'/CPR-1508小.jpg','Car DVR','CPR-1508J','AC5202B','1.5\"（480X240）','CMOS:1M, JX-H62;Lens:4G+1R, D=100，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','37g ','48*53.3*30.4mm',0),(7,'/CPR-4005.jpg','Car DVR','CPR-4005','MSC8328P','4.0\" IPS（800X480）','CMOS:2M,SENSOR GC2023/OV2710;lens:4G D=130，H=100，V=80','H.264 MOV','1920*1080@30fps;1280*720P@30fps','3M','JPEG','TF Card','Support:128G','YES(Option);CVBS 0.3M VGA;AHD,720P,1.0M','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','112g','109*60.5*11mm',0),(47,'/CPR-2005.jpg','Car DVR','CPR-2005','NT96658','2.0\"（480X240）','CMOS:2M,GC2023/OV2710','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 32G','YES(Option);CVBS 0.3M VGA','YES','NO','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(14,'/CRP-1523---小.jpg','Car DVR','CPR-1523','NT96223','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R; D=100，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','40g','66.2*43*32.15mm',0),(15,'/CPR-1525---小.jpg','Car DVR','CPR-1525','NT96223','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R, D=103，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','38.4g','66*42.75*31mm',0),(16,'/CPR-1509小.jpg','Car DVR','CPR-1509','NT96223','1.5\"（480X240）','CMOS:1M, JX-H62;lens:4G+1R, D=100，H=87，V=65','AVI','1280*720P@30fps;640*480@30fps','1M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','38.4g','66*42.75*31mm',0),(57,'/CPR-5001--11.jpg','Car DVR','CPR-5001sc','AC5401','4.0\" IPS（800X480)','CMOS:2M,GC2023;lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M,640*480@30fps;AHD,1.0M,1280*720@30fps','YES','YES(Option);external','YES(Option)','NO','NO','YES','NO','USB2.0','MinUSB 5V/1.5A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','243g','380*88*10mm',0),(18,'/CPR-2401小.JPG','Car DVR','CPR-2401W','MSC8328P','2.31\"(320X240)','CMOS:2M,GC2023/OV2710;lens:4G+1R, D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 128G','NO','YES','YES(Option)','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.5A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','68g','74*62.5*33.5mm',0),(48,'/CPR-2002-111.jpg','Car DVR','CPR-2002A','MSC8336/8339D','2.0\"(480X240)','CMOS:2M;GC2023/OV2710;Lens:4G+1R,D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);AHD,2.0M,1920*1080@30fps;AHD,1.0M,1280*720@30fps','YES','YES(Option)','NO','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.5A','Super Capacitor 2.7V/4.7F*2','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','51*62*32MM',0),(20,'/CPR-3007.jpg','Car DVR','CPR-3007','MSC8328P','3.0\" (960X240)','CMOS:2M,SENSOR GC2023/OV2710;CMOS:4M,SENSOR GC4603/OV4689;lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080 @ 30fps&1280*720P @ 30fps','3M','JPEG','TF Card','Support 128G','NO','YES','YES(Option)','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','USB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','152g','91*63*46mm',0),(21,'/CPR-1511.png','Car DVR','CPR-1511','AC5202B','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R,D=100，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','42g','59*49.5*35mm',0),(22,'/CPR-4303-1小.jpg','Car DVR','CPR-4303','AC5202B','4.3\"（480X272）','CMOS:1M, H62;Lens:4G D=100，H=87，V=45','AVI','1280*720P 30fps;680*480P 30fps','12M（interpolation）','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MIN USB 5V/1.0A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','234g','340*83*16mm',0),(23,'/CPR-4308&5008小.jpg','Car DVR','CPR-4308','AC5202B','4.3\"（480X272）','CMOS:1M, H62;Lens:4G D=100，H=87，V=65','AVI','1280*720P@30fps;80*480P@30fps','12M（interpolation）','JPEG','TF Card','Support 32G','NO','YES','N0','NO','NO','NO','NO','NO','USB2.0','MIN USB 5V/1.0A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','300g','320.5*95*18MM',0),(24,'/CPR-5001--11.jpg','Car DVR','CPR-5001','MSC8328P','5\"IPS（854*480）','CMOS:2M,GC2023;lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M,640*480@30fps;AHD,1.0M,1280*720@30fps','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.5A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','243g','380*88*10mm',0),(25,'/CPR-4308&5008小.jpg','Car DVR','CPR-5008','MSC8328P','5\"IPS（854*480）','CMOS:2M,SENSOR GC2023;lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P @ 30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M,640*480@30fps;AHD,1.0M,1280*720@30fps','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.5A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','300g','320.5*95*18MM',0),(42,'/CPR-1516小.jpg','Car DVR','CPR-1516','NT96223','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R,D=100，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','Min USB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','32g','66.5*43.4*32.1mm',0),(27,'/CPR-2406.jpg','Car DVR','CPR-2406','GPL1248','2.4\" ','CMOS:1M,SENSOR JX-H42/H62;lens:4G, D=100，H=87，V=65','AVI','1280*720@30fps;680*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','130mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','','',0),(49,'/CPR-4308&5008小.jpg','Car DVR','CPR-5008H','MSC8328P','5\"IPS（854*480）','CMOS:2M,GC2023;Lens:4G,D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P @ 30fps','3M','JPEG','TF Card','Support 128G','YES(Option);AHD,1.0M,720P','YES','YES(Option)','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.5A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','300g','320.5*95*18MM',0),(29,'/CPR-2705.jpg','Car DVR','CPR-2705','GP1248','2.7\"(320X240)','CMOS:1M,SENSOR JX-H42/H62;lens:4G, D=100，H=87，V=65','AVI','1280*720@30fps;680*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','130mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','','',0),(31,'/CPR2702小.jpg','Car DVR','CPR-2702W','MSC8328P','2.7\"(320X240)','CMOS:2M,SENSOR GC2023/OV2710;CMOS:4M,SENSOR GC4603/OV4689;lens:4G,D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 128G','NO','YES','YES(Option)','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MicroUSB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','75g','81.8*61.87*34.4mm',0),(32,'/CPR-2720小.jpg','Car DVR 全景','CPR-2720','C23 ARM Cortex A5 盈方微','2.7\"TFT(320X240)4:3 ','CMOS:3M,AR0330;Lens;7G, H=360°,V=220°','H.264 AVI','1920*1080@30fps&1280*720P@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','YES(Option)','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','260mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','91*78*30mm',0),(50,'/CPR-2002--1小.jpg','Car DVR','CPR-2002SC','GPCV2248','2.0\"（480X240）','CMOS:1M, JX-H62;Lens:4G+1R,D=130，H=100，V=80','AVI','1280*720@30fps;640*480@30fps','1M','JPEG','TF Card','Support: 32G','NO','YES','YES(Option)','NO','NO','NO','YES','NO','USB 2.0','MIN USB 5V/1.0A','Super Capacitor: 2.7V/4.7F*2','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','51.6g','71*47*37.6mm',0),(51,'/CPR-4002小.jpg','Car DVR','CPR-4002','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(36,'/CPR-1512小.jpg','Car DVR','CPR-1512','AC5202B','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R, D=100，H=87，V=65','AVI','1280*720@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','42g','59*49.5*35mm',0),(37,'/CPR-1513小.jpg','Car DVR','CPR-1513','AC5202B','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R,D=100，H=87，V=65','AVI','1280*720P@30fps;640*480@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','42g','59*49.5*35mm',0),(38,'/CPR-3001小.jpg','Car DVR','CPR-3001','MSC8336','3.0\" (960X240)','CMOS:2M, GC2023;lens:4G, D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS, 0.3M ,640*480@30fps;AHD, 1.0M ,1280*720@30fps','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','123g','88*53.5*32.5mm',0),(39,'/CPR-3002.jpg','Car DVR','CPR-3002','MSC8336','3.0\" (960X240)','CMOS:2M,GC2023;lens:4G, D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS, 0.3M ,640*480@30fps;AHD, 1.0M ,1280*720@30fps','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.0A','140mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','120g','88*53.5*32.5mm',0),(40,'/CPR-3003.jpg','Car DVR','CPR-3003','MSC8336','3.0\" (960X240)','CMOS:2M,GC2023;lens:4G, D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS, 0.3M ,640*480@30fps;AHD, 1.0M ,1280*720@30fps','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','MinUSB 5V/1.0A','140 mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','85g','88*53.5*32.5mm',0),(41,'/CPR-1518小.jpg','Car DVR','CPR-1515','NT96223','1.5\"（480X240）','CMOS:1M,JX-H62;lens:4G+1R,D=100，H=87，V=65','AVI','1280*720P@30fps;640*480P@30fps','3M','JPEG','TF Card','Support 32G','NO','YES','NO','NO','NO','NO','NO','NO','USB2.0','MinUSB 5V/1.0A','80mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','32g','66.5*44.5*34mm',0),(46,'/CPR-4001.jpg','Car DVR','CPR-4001','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023/OV2710;lens:4G D=130，H=100，V=80','H.264 MOV','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option),external','YES(Option)','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','110g','91*78*30mm',0),(45,'/CPR-2403小-1.jpg','Car DVR','CPR-2403','MSC8336/MSC8339','2.4\" IPS（240*320)','CMOS:2.1M,AR0238','H.264 MOV','1920*1080@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);AHD,2.0M,1920*1080@30fps;AHD,1.0M,1280*720@30fps','YES','NO','YES(optional)','NO','NO','YES','YES(optional)','USB2.0','MinUSB 5V/1.5A','180mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','86.8G','71.5*63*42mm',0),(52,'/CPR-4003.jpg','Car DVR','CPR-4003','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option)','NO','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(53,'/CPR-4006.jpg','Car DVR','CPR-4006','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option),external','NO','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(54,'/CPR-4007.jpg','Car DVR','CPR-4007','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option),external','NO','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(55,'/CPR-4008.jpg','Car DVR','CPR-4008','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option),external','NO','NO','NO','YES','YES(Option)','USB2.0','Min USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(56,'/CPR-4009.jpg','Car DVR','CPR-4009','MSC8328P','4.0\" IPS（800X480)','CMOS:2M,SENSOR GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720P@30fp','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M VGA;AHD,1.0M 720P','YES','YES(Option),external','NO','NO','NO','YES','YES(Option)','USB2.0','USB 5V/1.0A','150mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(58,'/CPR-4308&5008小.jpg','Car DVR','CPR-5008sc','AC5401','4.0\" IPS（800X480)','CMOS:2M,GC2023;Lens:4G D=130，H=100，V=80','H.264 AVI','1920*1080@30fps;1280*720@30fps','3M','JPEG','TF Card','Support 128G','YES(Option);CVBS,0.3M,640*480@30fps;AHD,1.0M,1280*720@30fps','YES','YES(Option);external','YES(Option)','NO','NO','YES','NO','USB2.0','MinUSB 5V/1.5A','350mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','243g','380*88*10mm',0),(59,'/CPR-3010.jpg','Car DVR','CPR-3010','MSC8336','3.0\" (960X240)',' AHD,CMOS:2M,','H.264 AVI','1920*1080@30fps，1280*720@30fps','3M','JPEG','TF Card','Support 128G',' AHD,CMOS:1M,1280*720@30fps','YES','YES(Option)','YES(Option)','NO','NO','YES','NO','USB2.0','USB 5V/1.5A','140mAh','YES','YES(Option)','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(60,'/CPR-1002.jpg','Car DVR','CPR-1002','AC5401','\\','CMOS:2M,GC2023;lens:4G+1R,D=130，H=100，V=80','H.264','1920*1080@30fps','3M','JPEG','TF Card','Support 128G','NO','YES','YES(Option)','YES','NO','NO','YES','NO','USB2.0','MicroUSB  5V/1.5A','300mAh','YES','YES','Multi-language','-10℃--- +60','-20℃--- +70','TBD','73*38.7*59.3mm',0);
/*!40000 ALTER TABLE `dvrdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpsdetail`
--

DROP TABLE IF EXISTS `gpsdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gpsdetail` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `imageId` varchar(255) NOT NULL,
  `productType` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `os` varchar(255) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `lcd` varchar(255) NOT NULL,
  `tp` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `rom` varchar(255) NOT NULL,
  `dvr` varchar(255) NOT NULL,
  `camera` varchar(255) NOT NULL,
  `card` varchar(255) NOT NULL,
  `multimedia` varchar(255) NOT NULL,
  `tools` varchar(255) NOT NULL,
  `bluetooth` varchar(255) NOT NULL,
  `fmt` varchar(255) NOT NULL,
  `avin` varchar(255) NOT NULL,
  `tv` varchar(255) NOT NULL,
  `speaker` varchar(255) NOT NULL,
  `mic` varchar(255) NOT NULL,
  `usb` varchar(255) NOT NULL,
  `charger` varchar(255) NOT NULL,
  `battery` varchar(255) NOT NULL,
  `language` varchar(255) NOT NULL,
  `operatingTemperature` varchar(255) NOT NULL,
  `storageTemperature` varchar(255) NOT NULL,
  `weight` varchar(100) DEFAULT NULL,
  `dimension` varchar(100) DEFAULT NULL,
  `htmlStatic` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpsdetail`
--

LOCK TABLES `gpsdetail` WRITE;
/*!40000 ALTER TABLE `gpsdetail` DISABLE KEYS */;
INSERT INTO `gpsdetail` VALUES (2,'/GPS-4360小.jpg','GPS navigation','GPS-4360','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','4.3\"TFT  480*272','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC ','USB2.0','MinUSB 5V/1A','650mAh','Multi-language','-10℃--- +60','-20℃--- +70','135g','117.5*77.4*11.8mm',0),(3,'/GPS-4362.jpg','GPS navigation','GPS-4362','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','4.3\"TFT  480*272','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','650mAh','Multi-language','-10℃--- +60','-20℃--- +70','135.6g','122.26*78.57*10.95mm',0),(4,'/GPS-4363小.jpg','GPS navigation','GPS-4363','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','4.3\"TFT  480*272','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','650mAh','Multi-language','-10℃--- +60','-20℃--- +70','125.7g','118.65*79.7*10.7mm',0),(5,'/GPS-4369.jpg','GPS navigation','GPS-4369','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','4.3\"TFT  480*272','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','650mAh','Multi-language','-10℃--- +60','-20℃--- +70','122.4g','119*78*12.23mm',0),(6,'/GPS-5006A.jpg','GPS navigation','GPS-5006A','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','1050mAh','Multi-language','-10℃--- +60','-20℃--- +70','172.6g','136*88*14mm',0),(7,'/GPS-5048.jpg','GPS navigation','GPS-5048','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','1050mAh','Multi-language','-10℃--- +60','-20℃--- +70','170.2g','134.9*85.9*12.7mm',0),(8,'/GPS-5051小.jpg','GPS navigation','GPS-5051','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','830mAh','Multi-language','-10℃--- +60','-20℃--- +70','168.4g','133*88*12.1mm',0),(9,'/GPS-5054小.jpg','GPS navigation','GPS-5054','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','1050mAh','Multi-language','-10℃--- +60','-20℃--- +70','173.5g','134.2*84.2*13mm',0),(10,'/GPS-5060小.jpg','GPS navigation','GPS-5060','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','830mAh','Multi-language','-10℃--- +60','-20℃--- +70','168.7g','132*83.9*11.5mm',0),(11,'/GPS-5062小.jpg','GPS navigation','GPS-5062','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','830mAh','Multi-language','-10℃--- +60','-20℃--- +70','162.3g','135.24*83.97*10.93MM',0),(12,'/GPS-5063小.jpg','GPS navigation','GPS-5063','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','830mAh','Multi-language','-10℃--- +60','-20℃--- +70','160.8g','133.14*84*10.7mm',0),(13,'/GPS-5069小.jpg','GPS navigation','GPS-5069','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1A','830mAh','Multi-language','-10℃--- +60','-20℃--- +70','161.4g','133*84*11.7mm',0),(14,'/GPS-5095小.jpg','GPS navigation','GPS-5095','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','5\"TFT  480*272/ HD 800*480 (optional)','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','YES(optional)','CMOS:1M,OV9712;1280*720@30fps;Lens:4G, D=128，H=99，V=73','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','YES(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2A','830mAh','Multi-language','-10℃--- +60','-20℃--- +70','195.7g','135.4*84.5*12.9mm',0),(15,'/GPS-7011小.jpg','GPS navigation','GPS-7011','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','268.2g','178.5*113*13.1mm',0),(16,'/GPS-7012小.jpg','GPS navigation','GPS-7012','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','287.4g','181.42*112.8*13.55mm',0),(17,'/GPS-7013小.jpg','GPS navigation','GPS-7013','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','277.5g','183.75*114.28*12.88mm',0),(18,'/GPS-7014小.jpg','GPS navigation','GPS-7014','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1100mAh','Multi-language','-10℃--- +60','-20℃--- +70','249.6g','177.7*110.8*14.7mm',0),(19,'/GPS-7019小.jpg','GPS navigation','GPS-7019','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','269.4g','179.6*113.5*13.2mm',0),(20,'/GPS-7026小.jpg','GPS navigation','GPS-7026','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','273.2g','180*113*13.2mm',0),(21,'/GPS-7027小.jpg','GPS navigation','GPS-7027','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','249.6g','177.7*110.8*14.7mm',0),(22,'/GPS-7028小.jpg','GPS navigation','GPS-7028','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','280.4g','181.67*112.4*13.35mm',0),(23,'/GPS-7051小.jpg','GPS navigation','GPS-7051','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','269.4g','179.6*113.5*13.2mm',0),(24,'/GPS-7095小.jpg','GPS navigation','GPS-7095','Windows CE 6.0','MSB2531  ARM Cortex A7 800MHZ','7\"TFT HD 800*480','high sensitive touch panel','128M/256M(opational)','4GB/8GB/16G(optional)','YES(optional)','CMOS:1M,OV9712;1280*720@30fps;Lens:4G, D=128，H=99，V=73','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Build-in Bluetooth(optional);Support DUN','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2A','1600mAh','Multi-language','-10℃--- +60','-20℃--- +70','285g','174.4*108.29*14mm',0);
/*!40000 ALTER TABLE `gpsdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manual`
--

DROP TABLE IF EXISTS `manual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manual` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `objName` varchar(255) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `fileName` varchar(255) NOT NULL,
  `fileSize` int(10) NOT NULL,
  `author` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manual`
--

LOCK TABLES `manual` WRITE;
/*!40000 ALTER TABLE `manual` DISABLE KEYS */;
INSERT INTO `manual` VALUES (7,'DVR','CPR20702使用说明书','CPR2702B行车记录仪说明书20160718.docx',1896086,'hxm'),(4,'GPS','GPS7095使用说明书','GPS-DVR-FM-ISDB-T_英文说明书.doc',8480875,'hxm'),(6,'PND','PND7013使用说明书','PND7013_guide.docx',158969,'hxm'),(8,'DVR','CPR1508使用说明书','CPR-1508 英文说明书.doc',1048576,'hxm'),(9,'DVR','CPR1523使用说书英文版','CPR-1523 英文说明书.doc',129024,'hxm'),(10,'DVR','CPR1505使用说明书','CPR1505说明书20170804.doc',360960,'hxm'),(11,'DVR','CPR2002说胆书','cpr2002说明书.docx',893826,'hxm');
/*!40000 ALTER TABLE `manual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mirrordetail`
--

DROP TABLE IF EXISTS `mirrordetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mirrordetail` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `imageId` varchar(255) NOT NULL,
  `productType` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `os` varchar(255) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `lcd` varchar(255) NOT NULL,
  `tp` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `rom` varchar(255) NOT NULL,
  `dvr` varchar(255) NOT NULL,
  `frontCamera` varchar(255) NOT NULL,
  `realCamera` varchar(255) NOT NULL,
  `card` varchar(255) NOT NULL,
  `multimedia` varchar(255) NOT NULL,
  `tools` varchar(255) NOT NULL,
  `gps` varchar(255) NOT NULL,
  `bluetooth` varchar(255) NOT NULL,
  `wifi` varchar(255) NOT NULL,
  `avin` varchar(255) NOT NULL,
  `fmt` varchar(255) NOT NULL,
  `band` varchar(255) NOT NULL DEFAULT 'No',
  `gsensor` varchar(255) NOT NULL,
  `speaker` varchar(255) NOT NULL,
  `mic` varchar(255) NOT NULL,
  `usb` varchar(255) NOT NULL,
  `charger` varchar(255) NOT NULL,
  `battery` varchar(255) NOT NULL,
  `language` varchar(255) NOT NULL,
  `operatingTemperature` varchar(255) NOT NULL,
  `storageTemperature` varchar(255) NOT NULL,
  `weight` varchar(100) DEFAULT NULL,
  `dimension` varchar(100) DEFAULT NULL,
  `htmlStatic` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mirrordetail`
--

LOCK TABLES `mirrordetail` WRITE;
/*!40000 ALTER TABLE `mirrordetail` DISABLE KEYS */;
INSERT INTO `mirrordetail` VALUES (2,'/CPR-6801.jpg','Android LTE Mirror','CPR-6801','Android 5.1','MT8735 Quad-Core Cortex-A7@1.3GHz','6.86\" TFT 480*1280','Capacitive Touch Screen,5points touch','1GB','8GB/16G(optional)','','CMOS:2M,C2023/OV2710;lens:4G,D=130，H=100，V=80;1920*1080@30fps;1280*720@30fps','YES(optional);CVBS,0.3M,640*480@30fps;AHD,1.0M,1280*720@30fps','Max 32G','Motion detection,Time laps,Parking mode,Event recording,Loop recording;Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer;','Support calendar and calculator','Built-in GPS+AGPS','YES(optional);','Build-in WIFI,802.11b/g/n','YES(optional)','YES(optional)','GSM:B3,B8;WCDMA:B1,B8;TDS-CDMA:B34,B39;FDD-LTE:B1,B3;TDD-LTE:B38,B39,B40,B41','YES','Build-in1.5WSpeaker','Build-inMIC','USB2.0','MinUSB 5V/2A','650mAh','Multi-language','-10℃---+60','-20℃---+70','TBD','315.25*82.05*24.2mm',0),(3,'/CPR-2405.jpg','3G Car DVR','CPR-3008','Android core','MT6582 Quad-Core 1.3GHz','3\"IPS 854*480','Capacitive Touch','512M LPDDR3','4G/8GB/16G/32G(optional)','','CMOS:2M,PS5220;Lens:4G,D=140，H=100，V=80;1920*1080@30fps;1280*720@30fps','YES(optional)','Max 128G','Motion detection,Time laps,Parking mode,Event recording,Loop recording;android and IOS  APP  support;','\\','YES','NO','Support for wifi hotspots','\\','\\','GSM:900/1800; WCDMA:B1/B8,or B1/B5','YES','Build-in 1.5W Speaker','Build-in MIC','\\','BMW line  9V-25V','650mAh Poly-lithium battery','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(4,'/CPR-1006.jpg','Android LTE DVR','CPR-4010','Android5.1','MT8735 Quad-Core Cortex -A7 @1.3GHz;Mali-T720 MP2 450MHz','4.0\"TFT 854*480','Capacitive Touch Screen','1GB','8GB/16G(optional)','','CMOS:2M,OV2718;Lens:6G,D=170，H=130;1920*1080@30fps;1280*720@30fps','YES(optional);CVBS,0.3M ,640*480;AHD,1.0M,1280*720@30fps','Max 32G','Motion detection,Time laps,Parking mode,Event recording,Loop recording','Support calendar and calculator','Built-in GPS+AGPS','YES','YES, WIFI,802.11b/g/n','YES(optional)','YES(optional)','GSM:B3,B8; WCDMA:B1; TDS-CDMA:B34,B39; FDD-LTE:B1,B3,B5,B8; TDD-LTE:B38,B39,B40,B41;','YES','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2.5A','650mAh','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0),(5,'/CPR-1006-1.jpg','Android LTE Mirror','CPR-1006','Android5.1','MT3561 Quad-Core Cortex -A7 @1.3GHz;Mali-T720 MP2 450MHz','\\','\\','1GB','8GB/16G(optional)','\\','ADAS sensor:H=551280*720@15fps','DFMS sensor:H=651280*720@15fps','Max 32G','ADAS:LDWS,FCWS,SAG;Driver Fatigue Monitor System','Support calendar and calculator','Built-in GPS+AGPS','NO','Build-in WIFI,802.11b/g/n','NO','NO','GSM:B3,B8;WCDMA:B1; TDS-CDMA:B34,B39; FDD-LTE:B1,B3,B5; TDD-LTE:B38,B39,B40,B41;','YES(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','9-36V','\\','Multi-language','-30℃--- +75','-30℃--- +80','TBD','TBD',0);
/*!40000 ALTER TABLE `mirrordetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pnddetail`
--

DROP TABLE IF EXISTS `pnddetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pnddetail` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `imageId` varchar(255) NOT NULL,
  `productType` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `os` varchar(255) NOT NULL,
  `cpu` varchar(255) NOT NULL,
  `lcd` varchar(255) NOT NULL,
  `tp` varchar(255) NOT NULL,
  `ram` varchar(255) NOT NULL,
  `rom` varchar(255) NOT NULL,
  `dvr` varchar(255) NOT NULL,
  `frontCamera` varchar(255) NOT NULL,
  `realCamera` varchar(255) NOT NULL,
  `card` varchar(255) NOT NULL,
  `multimedia` varchar(255) NOT NULL,
  `tools` varchar(255) NOT NULL,
  `gps` varchar(255) NOT NULL,
  `bluetooth` varchar(255) NOT NULL,
  `wifi` varchar(255) NOT NULL,
  `avin` varchar(255) NOT NULL,
  `fmt` varchar(255) NOT NULL,
  `tv` varchar(255) NOT NULL,
  `band` varchar(255) NOT NULL,
  `gsensor` varchar(255) NOT NULL,
  `speaker` varchar(255) NOT NULL,
  `mic` varchar(255) NOT NULL,
  `usb` varchar(255) NOT NULL,
  `charger` varchar(255) NOT NULL,
  `battery` varchar(255) NOT NULL,
  `language` varchar(255) NOT NULL,
  `operatingTemperature` varchar(255) NOT NULL,
  `storageTemperature` varchar(255) NOT NULL,
  `weight` varchar(100) DEFAULT NULL,
  `dimension` varchar(100) DEFAULT NULL,
  `htmlStatic` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pnddetail`
--

LOCK TABLES `pnddetail` WRITE;
/*!40000 ALTER TABLE `pnddetail` DISABLE KEYS */;
INSERT INTO `pnddetail` VALUES (3,'/PND-5003.jpg','PND navigation','PND-5003','Android4.4/Android 6.0','MT8127/MT8163  Quad Core Cortex A53 1.3GHz','5\"TFT HD 800X480','Capacitive Touch Screen ,5 points touch','512M/1GB (opational)','4G/8GB/16G(optional)','Build-in DVR 1080P@30fps(optional)','CMOS:2M,SENSOR GC2023/OV2710;lens:4G; D=130，H=100，V=80','0.3M CVBS(optional)','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Built-in GPS+AGPS','YES(optional)','Build-in WIFI,802.11b/g/n','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg/DVB-T2(optional)','GSM/WCDMA/TDS-CDMA/FDD-LTE/TDD-LTE;GSM:900/1800;WCDMA:BAND1/8;TDS-CDMA:BAND34/39;FDD-LTE:BAND1/3;TDD-LTE:BAND38/39/40/41;WCDMA:UL-5.76MbpsDL-21Mbps;TDS-CDMA:UL-2.2MbpsDL-2.8Mbps;LTE:UL-50MbpsDL-150Mbps','YES(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','	1000mAh Poly-lithium battery','Multi-language','-10℃--- +60','-20℃--- +70','188g','135*84*12.8mm',0),(4,'/PND-5005小.jpg','PND navigation','PND-5005','Android4.4/Android 6.0','MT8127/MT8163  Quad Core Cortex A53 1.3GHz','5\"TFT HD 800X480','Capacitive Touch Screen ,5 points touch','512M/1GB (opational)','4G/8GB/16G(optional)','Build-in DVR 1080P@30fps(optional)','CMOS:2M,SENSOR GC2023/OV2710;lens:4G; D=130，H=100，V=80','0.3M CVBS(optional)','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Built-in GPS+AGPS','YES(optional)','Build-in WIFI,802.11b/g/n','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg/DVB-T2(optional)','NO','YES(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/1.5A','	1000 mAh Poly-lithium battery','Multi-language','-10℃--- +60','-20℃--- +70','287.3g','133*88*13.6mm',1),(5,'/PND-5301.jpg','PND navigation','PND-5301','Android 5.0','MT8382 1.3 GHz 4 core','5\"TFT HD 800X480','Capacitive Touch Screen ,5 points touch','512M/1GB (opational)','4G/8GB/16G(optional)','Build-in DVR 1080P@30fps(optional)','CMOS:2M, GC2023;lens:4G,D=130，H=100，V=80','YES(optional);0.3M ,CVBS,VGA','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Built-in GPS+AGPS','YES(optional)','Build-in WIFI,802.11b/g/n','YES(optional)','YES(optional)','NO','WCDMA:2100MHz;GSM:850MHz.900MHz,1800MHz,1900MHz','YES(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2A','	830 mAh Poly-lithium battery','Multi-language','-10℃--- +60','-20℃--- +70','285g','174.4*108.3*14mm',0),(6,'/PND-7013小.JPG','PND navigation','PND-7013','Android4.4/Android 6.0','MT8127/MT8163  Quad Core Cortex A53 1.3GHz','7\"TFT HD 800X480','Capacitive Touch Screen ,5 points touch','512M/1GB (opational)','4G/8GB/16G(optional)','Build-in DVR 1080P@30fps(optional)','CMOS:2M,SENSOR GC2023/OV2710;lens:4G; D=130，H=100，V=80','0.3M CVBS(optional)','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Built-in GPS+AGPS','YES(optional)','Build-in WIFI,802.11b/g/n','YES(optional)','YES(optional)','Build-in Digital TV ISDB-T 1-Seg/DVB-T2(optional)','NO','YES(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2A','	2000 mAh Poly-lithium battery','Multi-language','-10℃--- +60','-20℃--- +70','310g','180*112*14mm',0),(8,'/PND-7502小.jpg','PND navigation','PND-7502','Android 6.0','MT8163  Quad Core Cortex A53 1.3GHz','7\"TFT HD 1024X600','Capacitive Touch Screen ,5 points touch','512M/1GB (opational)','4G/8GB/16G(optional)','NO','NO','NO','Max 32G','Support Multimedia Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Built-in GPS+AGPS','YES(optional)','Build-in WIFI,802.11b/g/n','YES(optional)','YES(optional)','ISDB-T Full SEG(optional)','NO','YES(optional)','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2A','	1100 mAh Poly-lithium battery','Multi-language','-10℃--- +60','-20℃--- +70','254g','179.2*103*15.2mm',0),(12,'/PND-4501.jpg','PND navigation','PND-4501','Android5.1','MT8735Quad-Cortex-A7@1.3GHz','4.5\"TFT IPS 854×480','Capacitive Touch Screen ,5 points touch','1GB','8GB/16G(optional)','Build-in DVR 1080P@30fps','CMOS:2M,GC2023/OV2710;lens:4G, D=130，H=100，V=80','YES(optional);0.3M ,CVBS ,VGA','Max 32G','Support Multimedia ;Video Player;Audio Player;Ebook Reader;Photo Viewer','Support calendar and calculator','Built-in GPS+AGPS','YES(optional)','Build-in WIFI,802.11a/b/g/n','YES(optional)','YES(optional)','NO','GSM:900/1800;WCDMA:B1,B8;TDS-CDMA:B34,B39;FDD-LTE:B1,B3;TDD-LTE:B38,B39,B40,B41;','YES','Build-in 1.5W Speaker','Build-in MIC','USB2.0','MinUSB 5V/2A','420 mAh','Multi-language','-10℃--- +60','-20℃--- +70','TBD','112*69*49.8MM',0),(13,'/PND-7801-02.jpg','PND navigation','PND-7801','Android5.1','MT8735  Quad Core Cortex A53 1.3GHz;Mali-T720 MP2 450MHz','7.84\"TFT 400*1280','Capacitive Touch Screen ','1G/2GB (opational)','8GB/16G/32G(optional)','Yes','CMOS:2M,Lens:6G,D=170，H=140;1920*1080@30fps','CMOS:1M,Lens:4G, D=130，H=100;1280*720@30fps','Max 128G','Motion detection,Parking mode,Event recording,Loop recording,Collision video lock;ADAS(LDWS,FCWS,SAG)(optional);fatigue driving detection(optional)','calendar and calculator;Support Multimedia Video Player,Audio Player,Ebook Reader,Photo Viewer','GPS+AGPS','Yes(optional),Bluetooth hands-free calling','WIFI,802.11b/g/n','Yes(optional)','Yes(optional),','NO','GSM:B3,B8;WCDMA:B1,B8;TD-SCDMA:B34,B39;FDD-LTE:B1,B3,B5;TDD-LET:B38,B39,B40,B41','Yes','1.5W Speaker','Build-in MIC','USB2.0','5V/5A','\\','Multi-language','-10℃--- +60','-20℃--- +70','TBD','TBD',0);
/*!40000 ALTER TABLE `pnddetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `passWord` varchar(255) NOT NULL,
  `permissions` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','123',3),(6,'wsh','123',1),(3,'hxm','123',15),(4,'wzx','123',15),(5,'guest','123',1);
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

-- Dump completed on 2018-10-30  9:23:44
