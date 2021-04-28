-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: farmacie
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `categorii_medicamente`
--

DROP TABLE IF EXISTS `categorii_medicamente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorii_medicamente` (
  `id_categorii_medicamente` int NOT NULL AUTO_INCREMENT,
  `cod_medicament` int NOT NULL,
  `nume_categorie` varchar(45) NOT NULL,
  PRIMARY KEY (`id_categorii_medicamente`),
  KEY `cod_categorie_idx` (`cod_medicament`),
  CONSTRAINT `cod_categorie` FOREIGN KEY (`cod_medicament`) REFERENCES `medicament` (`cod_edicament`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorii_medicamente`
--

LOCK TABLES `categorii_medicamente` WRITE;
/*!40000 ALTER TABLE `categorii_medicamente` DISABLE KEYS */;
INSERT INTO `categorii_medicamente` VALUES (1,3,'antibiotic');
/*!40000 ALTER TABLE `categorii_medicamente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comanda` (
  `cod_comanda` int NOT NULL AUTO_INCREMENT,
  `cod_farmacie` int NOT NULL,
  `nume_pacient` varchar(100) DEFAULT NULL,
  `data_livrare` date DEFAULT NULL,
  PRIMARY KEY (`cod_comanda`),
  KEY `cod_farmacie_idx` (`cod_farmacie`),
  CONSTRAINT `cod_farmacie` FOREIGN KEY (`cod_farmacie`) REFERENCES `farmacie` (`cod_farmacie`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (1,1,'Ana','2020-09-11'),(2,1,'Ana','2020-09-11'),(3,4,'Mihai','2019-09-11'),(4,7,'Ionut','2020-09-23'),(5,4,'Mihai','2020-08-15'),(6,3,'Maria','2020-08-05');
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `farmacie`
--

DROP TABLE IF EXISTS `farmacie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `farmacie` (
  `cod_farmacie` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(50) NOT NULL,
  `adresa` varchar(100) DEFAULT NULL,
  `oras` varchar(50) NOT NULL,
  `nr_telefon` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cod_farmacie`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `farmacie`
--

LOCK TABLES `farmacie` WRITE;
/*!40000 ALTER TABLE `farmacie` DISABLE KEYS */;
INSERT INTO `farmacie` VALUES (1,'Farmacia Dona',' strada AAA nr. 4 ','Timisoara ',' 0256765678'),(2,'Farmacia Operei',' strada DDD nr. 44 ','Timisoara ',' 0267934423'),(3,'Farmacia Vlad',' strada ZZZ nr. 51 ','Timisoara ',' 0764834008'),(4,'Farmacia Dona',' strada NNNNNN nr. 1 ','Iasi ',' 0711111111'),(5,'Farmacia Catena',' strada EEE nr. 31 ','Cluj ',' 0788888888'),(6,'Farmacia Dristor',' strada GGGGG nr. 63 ','Bucuresti ',' 0777777777'),(7,'Farmacia Dona',' strada RRRR nr. 9 ','Bucuresti ',' 0713245555'),(8,'Farmacia Dona','strada DD nr 15','Cluj ','0785368976');
/*!40000 ALTER TABLE `farmacie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicament` (
  `cod_edicament` int NOT NULL AUTO_INCREMENT,
  `nume_medicament` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_edicament`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicament`
--

LOCK TABLES `medicament` WRITE;
/*!40000 ALTER TABLE `medicament` DISABLE KEYS */;
INSERT INTO `medicament` VALUES (1,'Algocalmin'),(2,'Paracetamol'),(3,'Augumentin'),(4,'Nurofen');
/*!40000 ALTER TABLE `medicament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamente_comandate`
--

DROP TABLE IF EXISTS `medicamente_comandate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamente_comandate` (
  `cod_medicamente_comandate` int NOT NULL AUTO_INCREMENT,
  `cod_comanda` int NOT NULL,
  `cod_medicament` int NOT NULL,
  `cantitate` int NOT NULL,
  PRIMARY KEY (`cod_medicamente_comandate`),
  KEY `cod_comanda_idx` (`cod_comanda`),
  CONSTRAINT `cod_comanda` FOREIGN KEY (`cod_comanda`) REFERENCES `comanda` (`cod_comanda`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamente_comandate`
--

LOCK TABLES `medicamente_comandate` WRITE;
/*!40000 ALTER TABLE `medicamente_comandate` DISABLE KEYS */;
INSERT INTO `medicamente_comandate` VALUES (1,1,1,10),(9,2,2,2),(10,3,3,7),(11,6,3,17);
/*!40000 ALTER TABLE `medicamente_comandate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stoc`
--

DROP TABLE IF EXISTS `stoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cod_farmacie` int NOT NULL,
  `cod_medicament` int NOT NULL,
  `cantitate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cod_medicament_idx` (`cod_medicament`),
  KEY `id_farmacie_idx` (`cod_farmacie`),
  CONSTRAINT `id_farmacie` FOREIGN KEY (`cod_farmacie`) REFERENCES `farmacie` (`cod_farmacie`),
  CONSTRAINT `id_medicament` FOREIGN KEY (`cod_medicament`) REFERENCES `medicament` (`cod_edicament`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stoc`
--

LOCK TABLES `stoc` WRITE;
/*!40000 ALTER TABLE `stoc` DISABLE KEYS */;
INSERT INTO `stoc` VALUES (1,4,4,'500'),(2,5,4,'30'),(3,6,4,'360'),(4,1,4,'0'),(5,5,1,'500'),(6,8,1,'100');
/*!40000 ALTER TABLE `stoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-28 18:25:09
