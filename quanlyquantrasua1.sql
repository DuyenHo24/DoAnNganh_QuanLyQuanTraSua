-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlyquantrasua
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban` (
  `ma_ban` int NOT NULL AUTO_INCREMENT,
  `vi_tri` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mieu_ta` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ma_ban`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban`
--

LOCK TABLES `ban` WRITE;
/*!40000 ALTER TABLE `ban` DISABLE KEYS */;
INSERT INTO `ban` VALUES (1,'a','a'),(2,'Giữa','Bàn 2 người'),(3,'Cánh trái','Bàn 3 người'),(6,'Cánh phải','Bàn 3 người'),(10,'Cánh trái','Bàn 2 người'),(11,'Giữa','Bàn 5 người'),(12,'Giữa','Bàn 3 người');
/*!40000 ALTER TABLE `ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ct_hoadon`
--

DROP TABLE IF EXISTS `ct_hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ct_hoadon` (
  `ma_hd` int NOT NULL,
  `ma_mon` int NOT NULL,
  `so_luong` int NOT NULL,
  `don_gia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ma_hd`,`ma_mon`),
  KEY `fk_cthoadon_mon_idx` (`ma_mon`),
  CONSTRAINT `fk_cthoadon_hoadon` FOREIGN KEY (`ma_hd`) REFERENCES `hoa_don` (`ma_hd`),
  CONSTRAINT `fk_cthoadon_mon` FOREIGN KEY (`ma_mon`) REFERENCES `mon` (`ma_mon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_hoadon`
--

LOCK TABLES `ct_hoadon` WRITE;
/*!40000 ALTER TABLE `ct_hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `ct_hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `ma_hd` int NOT NULL AUTO_INCREMENT,
  `ngay_gio_-mua` datetime NOT NULL,
  `ma_nv` int NOT NULL,
  PRIMARY KEY (`ma_hd`),
  KEY `fk_hoadon_nhanvien_idx` (`ma_nv`),
  CONSTRAINT `fk_hoadon_nhanvien` FOREIGN KEY (`ma_nv`) REFERENCES `nhan_vien` (`ma_nv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon_ban`
--

DROP TABLE IF EXISTS `hoadon_ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon_ban` (
  `ma_hd` int NOT NULL,
  `ma_ban` int NOT NULL,
  PRIMARY KEY (`ma_hd`,`ma_ban`),
  KEY `fk_hdban_ban_idx` (`ma_ban`),
  CONSTRAINT `fk_hdban_ban` FOREIGN KEY (`ma_ban`) REFERENCES `ban` (`ma_ban`),
  CONSTRAINT `fk_hdban_hoadon` FOREIGN KEY (`ma_hd`) REFERENCES `hoa_don` (`ma_hd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon_ban`
--

LOCK TABLES `hoadon_ban` WRITE;
/*!40000 ALTER TABLE `hoadon_ban` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon_ban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_mon`
--

DROP TABLE IF EXISTS `loai_mon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_mon` (
  `ma_loai` int NOT NULL AUTO_INCREMENT,
  `ten_loai` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ma_loai`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_mon`
--

LOCK TABLES `loai_mon` WRITE;
/*!40000 ALTER TABLE `loai_mon` DISABLE KEYS */;
INSERT INTO `loai_mon` VALUES (1,'Trà sữa'),(2,'Trà'),(3,'Cà phê'),(4,'Đá xay'),(5,'Soda'),(6,'Thức ăn nhẹ'),(7,'aaaaa'),(8,'Thức ăn nhanh');
/*!40000 ALTER TABLE `loai_mon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon`
--

DROP TABLE IF EXISTS `mon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon` (
  `ma_mon` int NOT NULL AUTO_INCREMENT,
  `ten_mon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `don_vi_tinh` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gia_tien` decimal(10,0) NOT NULL,
  `hinh_anh_mon` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loai_mon` int NOT NULL,
  PRIMARY KEY (`ma_mon`),
  KEY `fk_mon_loaimon_idx` (`loai_mon`),
  CONSTRAINT `fk_mon_loaimon` FOREIGN KEY (`loai_mon`) REFERENCES `loai_mon` (`ma_loai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon`
--

LOCK TABLES `mon` WRITE;
/*!40000 ALTER TABLE `mon` DISABLE KEYS */;
/*!40000 ALTER TABLE `mon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `ma_nv` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ten` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ngay_sinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gioi_tinh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dien_thoai` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ten_tkhoan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mat_khau` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chuc_vu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ma_nv`),
  UNIQUE KEY `ten_tkhoan_UNIQUE` (`ten_tkhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (1,'Hồ','Duyên','2000-07-24','Nữ','0812881212','duyen.24.07.dh@gmail.com','DuyenHo24','123456','Quản Lý'),(2,'Nguyễn','An','2017-08-01','Nam','123456789','an123@gmail.com','an123','1234','Nhân viên'),(3,'Trần','Tú','1999-07-01','Nữ','0949459780','trantu1999@gmail.com','trantu_0107','01071999','Nhân viên'),(4,'Nguyễn','Minh','2021-08-31','Nam','0919234567','minhnguyen123@gmail.com','minh@56','123456','Nhân viên'),(5,'Ho','Duyen','2021-08-30','Nữ','0909876564','duyen12@gmail.com','duyen00','123','Nhân viên'),(7,'Nguyen','Minh Anh','1990-07-30','Nữ','0984658264','minh312@gmail.com','',NULL,'Nhân viên'),(9,'test1','test','2021-09-28','Nam','0987654321','duyen12@gmail.com','a','a','Quản Lý');
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'quanlyquantrasua'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-12 18:45:36
