-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: localhost    Database: Library
-- ------------------------------------------------------
-- Server version	8.0.19-0ubuntu0.19.10.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `phieu_muon_sach`
--

DROP TABLE IF EXISTS `phieu_muon_sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_muon_sach` (
  `ma_muon_sach` varchar(10) NOT NULL,
  `ma_sach` varchar(10) NOT NULL,
  `tinh_trang_sach` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ma_muon_sach`,`ma_sach`),
  KEY `ma_sach` (`ma_sach`),
  CONSTRAINT `phieu_muon_sach_ibfk_1` FOREIGN KEY (`ma_muon_sach`) REFERENCES `sinh_vien_muon_sach` (`ma_muon_sach`),
  CONSTRAINT `phieu_muon_sach_ibfk_2` FOREIGN KEY (`ma_sach`) REFERENCES `sach` (`ma_sach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_muon_sach`
--

LOCK TABLES `phieu_muon_sach` WRITE;
/*!40000 ALTER TABLE `phieu_muon_sach` DISABLE KEYS */;
INSERT INTO `phieu_muon_sach` VALUES ('LBRI001','CDLVL01','Sách còn mới, không hư hỏng'),('LBRI002','LTWBE001','Tốt'),('LBRI002','THVDS01','Bình thường'),('LBRI003','TGDC01','Tốt'),('LBRI005','TDDGVN01','Mất bìa sau');
/*!40000 ALTER TABLE `phieu_muon_sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `ma_sach` varchar(10) NOT NULL,
  `ma_the_loai_sach` varchar(6) NOT NULL,
  `ten_sach` varchar(50) NOT NULL,
  `nha_XB` varchar(50) DEFAULT NULL,
  `tac_gia` varchar(50) DEFAULT NULL,
  `nam_XB` date DEFAULT NULL,
  `so_lan_XB` varchar(50) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `anh_bia` blob,
  PRIMARY KEY (`ma_sach`),
  KEY `ma_the_loai_sach` (`ma_the_loai_sach`),
  CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`ma_the_loai_sach`) REFERENCES `the_loai_sach` (`ma_the_loai_sach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('CDLVL01','VLY','Các định luật vật lý','Giáo dục','Nguyễn Thu Hiền','2011-05-04','2',300000,NULL),('LTWBE001','TIN','Lập trìn web back end','Hà Nội','Nguyễn xuân Khánh','2011-05-18','2',200000,NULL),('TDDGVN01','DIC','Từ điển dân gian việt Nam','Trẻ','Hoàng Anh Cơ','2003-05-05','1',310000,NULL),('TGDC01','VH','Tán gái đại cương','Thanh Niên','Hoàng Ngọc Thạch','2016-05-04','3',700000,NULL),('THVDS01','TOAN','Toán Học và đời sống','Tự do','Thanh Trần','2012-05-07','6',120000,NULL);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinh_vien_muon_sach`
--

DROP TABLE IF EXISTS `sinh_vien_muon_sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinh_vien_muon_sach` (
  `ma_muon_sach` varchar(10) NOT NULL,
  `ma_sinhvien` varchar(15) NOT NULL,
  `ngay_muon` date NOT NULL,
  `han_tra_sach` date DEFAULT NULL,
  `tinh_trang_TRA_CHUATRA` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ma_muon_sach`),
  KEY `ma_sinhvien` (`ma_sinhvien`),
  CONSTRAINT `sinh_vien_muon_sach_ibfk_1` FOREIGN KEY (`ma_sinhvien`) REFERENCES `sinhvien` (`ma_sinhvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinh_vien_muon_sach`
--

LOCK TABLES `sinh_vien_muon_sach` WRITE;
/*!40000 ALTER TABLE `sinh_vien_muon_sach` DISABLE KEYS */;
INSERT INTO `sinh_vien_muon_sach` VALUES ('LBRI001','SV0001','2020-05-01','2020-05-30','Tra'),('LBRI002','SV0005','2020-05-08','2020-05-31','Chua tra'),('LBRI003','SV0004','2019-05-02','2020-05-11','Chua tra'),('LBRI004','SV0003','2020-04-07','2020-05-06','Tra'),('LBRI005','SV0002','2020-05-08','2020-05-20','Chua tra');
/*!40000 ALTER TABLE `sinh_vien_muon_sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `ma_sinhvien` varchar(15) NOT NULL,
  `ma_the_thu_vien` varchar(15) NOT NULL,
  `ten_sinhvien` varchar(50) NOT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `dia_chi` varchar(500) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `so_dienthoai` varchar(11) DEFAULT NULL,
  `anh_sinhvien` blob,
  PRIMARY KEY (`ma_sinhvien`),
  KEY `ma_the` (`ma_the_thu_vien`),
  CONSTRAINT `sinhvien_ibfk_1` FOREIGN KEY (`ma_the_thu_vien`) REFERENCES `the_sinhvien` (`ma_the_thu_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES ('SV0001','LB0001','Trần Văn Thanh','2015-04-13','Huế','gmail1','111111111',NULL),('SV0002','LB0002','Hoàng Ngọc Thạch','2015-04-22','Đà Nằng','gmail2','222222222',NULL),('SV0003','LB0003','Nguyễn Xuân Khánh','2002-04-15','Cần Thơ','gmail3','333333333',NULL),('SV0004','LB0004','Dung Dung','2015-04-29','Quảng Trị','gmail4','444444444',NULL),('SV0005','LB0005','Hiền Hiền','2015-07-15','Quảng Bình','gmail5','555555555',NULL);
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the_loai_sach`
--

DROP TABLE IF EXISTS `the_loai_sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `the_loai_sach` (
  `ma_the_loai_sach` varchar(6) NOT NULL,
  `ten_the_loai` varchar(20) NOT NULL,
  `mo_ta` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ma_the_loai_sach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_loai_sach`
--

LOCK TABLES `the_loai_sach` WRITE;
/*!40000 ALTER TABLE `the_loai_sach` DISABLE KEYS */;
INSERT INTO `the_loai_sach` VALUES ('DIC','Dictionary','Từ điển tra cứu'),('TIN','Tin Học','Sách về tin học'),('TOAN','Toán Học','Sách về Toán học'),('VH','Văn Học','Sách về văn học'),('VLY','Vật Lý','Sách về Vật lý');
/*!40000 ALTER TABLE `the_loai_sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the_sinhvien`
--

DROP TABLE IF EXISTS `the_sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `the_sinhvien` (
  `ma_the_thu_vien` varchar(6) NOT NULL,
  `tai_khoan` varchar(15) NOT NULL,
  `mat_khau` varchar(15) NOT NULL,
  `ngay_tao` date DEFAULT NULL,
  PRIMARY KEY (`ma_the_thu_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_sinhvien`
--

LOCK TABLES `the_sinhvien` WRITE;
/*!40000 ALTER TABLE `the_sinhvien` DISABLE KEYS */;
INSERT INTO `the_sinhvien` VALUES ('LB0001','TKLB0001','123456','2020-04-15'),('LB0002','TKLB0002','123456','2020-04-13'),('LB0003','TKLB0003','123456','2018-04-11'),('LB0004','TKLB0004','123456','2018-04-30'),('LB0005','TKLB0005','123456','2017-04-10');
/*!40000 ALTER TABLE `the_sinhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04  9:37:18
