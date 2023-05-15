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
-- Table structure for table `weapons_available`
--

DROP TABLE IF EXISTS `weapons_available`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weapons_available` (
  `WARRIOR_ID` int DEFAULT NULL,
  `WEAPON_ID` int DEFAULT NULL,
  KEY `WARRIOR_ID` (`WARRIOR_ID`),
  KEY `WEAPON_ID` (`WEAPON_ID`),
  CONSTRAINT `weapons_available_ibfk_1` FOREIGN KEY (`WARRIOR_ID`) REFERENCES `warriors` (`warrior_id`),
  CONSTRAINT `weapons_available_ibfk_2` FOREIGN KEY (`WEAPON_ID`) REFERENCES `weapons` (`weapon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapons_available`
--

LOCK TABLES `weapons_available` WRITE;
/*!40000 ALTER TABLE `weapons_available` DISABLE KEYS */;
INSERT INTO `weapons_available` VALUES (1,1),(2,1),(3,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(4,4),(5,4),(6,4),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(7,6),(8,6),(9,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(1,8),(2,8),(3,8),(4,8),(5,8),(6,8),(4,9),(5,9),(6,9),(7,9),(8,9),(9,9);
/*!40000 ALTER TABLE `weapons_available` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-15 17:44:47
