-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: vastrum
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Category` (
  `CategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  `Decription` varchar(255) NOT NULL,
  PRIMARY KEY (`CategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `UserName` varchar(30) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Phone` int(20) NOT NULL,
  `Address` varchar(255) NOT NULL,
  PRIMARY KEY (`UserName`),
  CONSTRAINT `Customer_ibfk_1` FOREIGN KEY (`UserName`) REFERENCES `User` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES ('navin123','Navin P',2430708,'IITBHU varanasi'),('raghav123','Raghav Sangar',2424624,'Bengali tola, Benares'),('shay123','Amber Saxena',2424624,'IITBHU varanasi'),('vyomv1','Vyom Pathroliya',2430708,'224,Ravindra Apt,Electronic city, Bengaluru');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exhibit`
--

DROP TABLE IF EXISTS `Exhibit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Exhibit` (
  `UserName` varchar(30) NOT NULL,
  `Curator` varchar(30) NOT NULL,
  `Phone` int(20) NOT NULL,
  `City` varchar(30) NOT NULL,
  PRIMARY KEY (`UserName`),
  CONSTRAINT `Exhibit_ibfk_1` FOREIGN KEY (`UserName`) REFERENCES `User` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exhibit`
--

LOCK TABLES `Exhibit` WRITE;
/*!40000 ALTER TABLE `Exhibit` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exhibit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Orders` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Price` int(11) DEFAULT '0',
  `Deliveryaddr` varchar(255) NOT NULL,
  `Status` varchar(30) DEFAULT NULL,
  `UserName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `UserName` (`UserName`),
  CONSTRAINT `Orders_ibfk_1` FOREIGN KEY (`UserName`) REFERENCES `User` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (34,'2019-10-14',2298,'205, Baraghar, kolkata','placed','vyomv1'),(36,'2019-10-14',6125,'silos','placed','vyomv1'),(37,'2019-10-14',2124,'204, Baraghar, kolkata','placed','vyomv1'),(38,'2019-10-14',899,'New Delhi','placed','vyomv1'),(39,'2019-10-14',17388,'205, Baraghar, kolkata','placed','shay123');
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product` (
  `ProductId` int(11) NOT NULL AUTO_INCREMENT,
  `Price` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `SupplierId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductId`),
  KEY `SupplierId` (`SupplierId`),
  CONSTRAINT `Product_ibfk_2` FOREIGN KEY (`SupplierId`) REFERENCES `Supplier` (`SupplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (10,999,'Mehendi Halter Neck Cotton Slub Kurta','Description Supplier 10 Mehendi Halter Neck Cotton Slu 999 A beautiful kurta with a contemporary halter neck design, enhanced with handstitched lines. This dark green kurta has been handcrafted in cotton slub, prized for its earthy charm.',1),(11,1625,'Three Print Kalamkari Cotton Kurta','Three different Kalamkari block printed fabrics come together to create a beautiful kurta. Featuring traditional patterns in complementary colours, this anarkali kurta has been handcrafted in pure cotton.',3),(12,1299,'The Humble Lavender Kota Doriya Kali Overlay','This Lavender Kota doriya kali overlay with coconut shell wooden buttons is a full-sleeved front open piece which adds a formal and graceful look to your attire. This overlay has concealed placket and pockets in front, making it ideal for summers.',5),(13,1299,'Black Kurta With Kantha Embroidery','A classic black cotton kurta is given an elegant interpretation with white kantha-inspired embroidery on the sleeves. We recommend pairing this gorgeous piece with jeans and our black and white kantha mules for a perfectly coordinated look.',5),(14,1225,'The Easy Going Light Green Cotton Kurta','This light green cotton kurta with pintucks and a yoke on the front gathers on the sides. It is full sleeved, piped and has an A line fit, making it a light and easy piece of clothing for the summer.',5),(15,1449,'Off White Rayon Culottes','Off White Rayon Culottes',3),(16,899,'Gerua Cotton Slub Slip','This spaghetti sleeved slip has been handcrafted expertly in natural cotton slub. It comes with handstitched lines at the neck to offset the beautiful rust colour.',4),(17,899,'Kalamkari Cotton Slip','This simple, long slip has been handcrafted in pure cotton and enhanced with India\'s traditional Kalamkari block printed designs on a base of black. Wear this with a cape or a denim jacket for a fusion look.',4),(18,6375,'Grey Embroidered Kurta, Pallaz','This elegant set of 3 contains a beautiful kurta that has been carefully handcrafted in classy grey organdy. The kurta features tone-on-tone embroidery for a lovely finish, with flower motifs embroidered at the bottom. Handcrafted in luxurious Organdy, th',3),(19,1075,'Long Blue Cotton Kurta','This simple blue kurta is enhanced with its sleek cut and design. Handcrafted in pure, premium cotton, it comes in delightful shade of blue with a sleeveless design.',1);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProductOrder`
--

DROP TABLE IF EXISTS `ProductOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProductOrder` (
  `Quantity` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `OrderId` int(11) NOT NULL,
  PRIMARY KEY (`OrderId`,`ProductId`),
  KEY `ProductId` (`ProductId`),
  CONSTRAINT `ProductOrder_ibfk_1` FOREIGN KEY (`OrderId`) REFERENCES `Orders` (`OrderId`),
  CONSTRAINT `ProductOrder_ibfk_2` FOREIGN KEY (`ProductId`) REFERENCES `Product` (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProductOrder`
--

LOCK TABLES `ProductOrder` WRITE;
/*!40000 ALTER TABLE `ProductOrder` DISABLE KEYS */;
INSERT INTO `ProductOrder` VALUES (1,10,34),(1,13,34),(5,14,36),(1,14,37),(1,16,37),(1,16,38),(12,15,39);
/*!40000 ALTER TABLE `ProductOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reviews`
--

DROP TABLE IF EXISTS `Reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reviews` (
  `ProductId` int(11) NOT NULL,
  `Review` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`,`Review`),
  CONSTRAINT `Reviews_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `Product` (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reviews`
--

LOCK TABLES `Reviews` WRITE;
/*!40000 ALTER TABLE `Reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Store`
--

DROP TABLE IF EXISTS `Store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Store` (
  `UserName` varchar(30) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Owner` varchar(30) NOT NULL,
  `Phone` int(20) NOT NULL,
  `Address` varchar(255) NOT NULL,
  PRIMARY KEY (`UserName`),
  CONSTRAINT `Store_ibfk_1` FOREIGN KEY (`UserName`) REFERENCES `User` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Store`
--

LOCK TABLES `Store` WRITE;
/*!40000 ALTER TABLE `Store` DISABLE KEYS */;
/*!40000 ALTER TABLE `Store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supplier`
--

DROP TABLE IF EXISTS `Supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Supplier` (
  `SupplierId` int(11) NOT NULL AUTO_INCREMENT,
  `Company` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Phno` int(20) NOT NULL,
  PRIMARY KEY (`SupplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Supplier`
--

LOCK TABLES `Supplier` WRITE;
/*!40000 ALTER TABLE `Supplier` DISABLE KEYS */;
INSERT INTO `Supplier` VALUES (1,'KhanTraders','DD, Gwalior',789456123),(2,'Meshan','Maharaj Bada, Gwalior',957452463),(3,'KRKsuiting','Bengali tola, Benares',884611245),(4,'Kothari and Sons','Maharaj Bada, Gwalior',2428521),(5,'KareemSaris','Bengali tola, Benares',2430708);
/*!40000 ALTER TABLE `Supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `UserName` varchar(30) NOT NULL,
  `Pwd` varchar(255) DEFAULT NULL,
  `UserType` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('aasma.sky101','$2a$10$kFme3c5nMv7W47FDmC5GhekTWoTL0izredwSgRaYFio58XwjnMICm','admin'),('navin123','$2a$10$P8WfJSZCNqad.Wza9KC/mujPIz0NZ3erj.UG0AZLc/pD.UEMYqgOW','customer'),('raghav123','$2a$10$hLONbjGZprmYCvNt4xbhE.DjPAKFFRwX7ijTaZzyoLOkc5FjYdIze','customer'),('shay123','$2a$10$jklA.mjRHDFnSBnJNvj8de2wY.dJBRzwCRqj38k/ezRnQ./Ktvj9q','customer'),('vyomv1','$2a$10$UsHscgTjRsFNDvIAnNbx5O4MSSKjub7ffFqEe6JQiGQSha6aL50zK','customer');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-14 15:05:54
