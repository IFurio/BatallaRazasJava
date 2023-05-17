-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: batalla_races
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `warriors`
--

DROP TABLE IF EXISTS `warriors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warriors` (
  `warrior_id` int NOT NULL,
  `warrior_name` varchar(45) NOT NULL,
  `warrior_image_path` varchar(100) DEFAULT NULL,
  `race` varchar(15) NOT NULL,
  `health_points` int NOT NULL,
  `damage_points` int NOT NULL,
  `speed_points` int NOT NULL,
  `defense_points` int NOT NULL,
  `agility_points` int NOT NULL,
  `race_points` int NOT NULL,
  `warrior_sprite` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`warrior_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warriors`
--

LOCK TABLES `warriors` WRITE;
/*!40000 ALTER TABLE `warriors` DISABLE KEYS */;
INSERT INTO `warriors` VALUES (1,'Legolas','M3-Programacio/Images/warrior11.png','Elf',40,4,7,2,7,19,'M3-Programacio/Images/warrior1.png'),(2,'Isildur','M3-Programacio/Images/warrior21.png','Elf',40,4,7,2,7,19,'M3-Programacio/Images/warrior2.png'),(3,'Eru','M3-Programacio/Images/warrior31.png','Elf',40,4,7,2,7,19,'M3-Programacio/Images/warrior3.png'),(4,'Arthur Pendragon','M3-Programacio/Images/warrior41.png','Human',50,5,5,3,6,20,'M3-Programacio/Images/warrior4.png'),(5,'Siegfried ','M3-Programacio/Images/warrior51.png','Human',50,5,5,3,6,20,'M3-Programacio/Images/warrior5.png'),(6,'Sir William Wallace','M3-Programacio/Images/warrior61.png','Human',50,5,5,3,6,20,'M3-Programacio/Images/warrior6.png'),(7,'Brokk','M3-Programacio/Images/warrior71.png','Dwarf',60,6,3,4,5,21,'M3-Programacio/Images/warrior7.png'),(8,'Guldrak','M3-Programacio/Images/warrior81.png','Dwarf',60,6,3,4,5,21,'M3-Programacio/Images/warrior8.png'),(9,'Krumgrom','M3-Programacio/Images/warrior91.png','Dwarf',60,6,3,4,5,21,'M3-Programacio/Images/warrior9.png');
/*!40000 ALTER TABLE `warriors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 17:58:53
