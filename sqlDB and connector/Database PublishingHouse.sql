-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: publishing_house
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author` (
  `author_id` int NOT NULL AUTO_INCREMENT,
  `author_name` varchar(80) NOT NULL,
  `author_address` varchar(60) NOT NULL,
  `author_number_phone` varchar(45) NOT NULL,
  `author_email` varchar(60) DEFAULT NULL,
  `author_additional_info` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Вільшакова Анна Дмитрівна','вул. Одеська, 55','0998378944','ann@gmail.com','не вказано'),(6,'Грецько Антон Володимирович','вул. Небсної Сотні, 90','0997823390','antonG@gmail.com',NULL),(8,'Паньков Дмитро Олександрович','вул. Руська, 15','0952346777','dmP@gmail.com','Є співавтором'),(9,'Рушова Анна Олегівна','вул. Корабельна, 16А','0508976744','anna@gmail.com','Є приватною особою'),(10,'Панчошна Анастасія Олександрівіна','вул. Небесної Сотні, 10','0956661221','nastya@gmail.com','Студентка'),(12,'Ставшенко Олексій Миколаєвич','вул. Київська, 24','0995461234','oleksyiSt@gmail.com','з угруповання авторів'),(13,'Давидено Олександра Євгенівна','вул. Шевченка, 12','0953490088','oleksa@gmail.com',NULL),(14,'Ващук Анна Олегівна','вул. Театральна, 10','0983349056','vaAn@gmail.com','не вказано'),(16,'Дріщенко Артем Олегович','вул. Героїв Майдану, 44','0634569009','artem@gmail.com','Співавтор'),(17,'Денисова Анна Артемівна','вул. Одеська, 12','0991237895','',''),(19,'Липчук Олег Віталійович','вул. Небесної Сотні,12','0687893342','lypchuk@gmail.com',''),(20,'Ткачук Анна Сергіївна','вул. Кошового, 55','0681113456','tkachA@gmail.com',''),(21,'Носовий Антон Єгорович','вул. Білоуса, 78','0998005577','',''),(22,'Ставщук Андрій Миколайович','вул. М. Хвильового, 11','0954901221','andr@gmail.com','Початківець'),(23,'Лінтюк Софія Петрівна','вул. Соборна, 23','0687890901','sofa@gmail.com',''),(24,'Мутоєва Злата Володимирівна',' вул. Пилипа Орлика, 92','0667898319','zl@gmail.com',''),(27,'Тульчін Олександр Георгійович','вул. Макарова, 18','0991234455','tulO@gmail.com',''),(28,'Антощук Вадим Сергійович','вул. Героїв Майдану, 66','0667003322','','Має представника учасника');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `client_type` varchar(45) NOT NULL,
  `client_name` varchar(70) NOT NULL,
  `client_address` varchar(70) NOT NULL,
  `client_number_phone` varchar(45) NOT NULL,
  `client_email` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Організація','Мельник Катерина Олександрівна','вул. Кобринської, 11','0998907898','KM@gmail.com'),(2,'Організація','Литвинюк Дарія Максимівна','вул. Небесної Сотні, 4','0997656777','Dasha@gmail.com'),(5,'Приватна особа','Панчошна Анастасія Олександрівіна','вул. Небесної Сотні, 10','0956661221','nastya@gmail.com'),(8,'Угруповання авторів','Ільків Богдан Сергійович','вул. Руська, 33','0993747373','bodya@gmail.com'),(11,'Приватна особа','Липчук Олег Віталійович','вул. Небесної Сотні,12','0687893342','lypchuk@gmail.com'),(12,'Організація','Вівченко Володимир Анатолійович','вул. Коротченко, 24','0997862213',''),(13,'Угруповання авторів','Мельник Олена Вікторівна',' вул. Тулаєво, 68','0508971224','olench@gmail.com'),(14,'Організація','Дмитрук Олег Віталійович','вул. Вільшанова,14','0660987899','dmo@gmail.com'),(15,'Угруповання авторів','Ставшенко Олексій Миколаєвич','вул. Київська, 24','0992234314','oleksyiSt@gmail.com'),(16,'Приватна особа','Рушова Анна Олегівна','вул. Корабельна, 16А','0665679088','anna@gmail.com'),(17,'Приватна особа','Мутоєва Злата Володимирівна',' вул. Пилипа Орлика, 92','0667898319',NULL),(18,'Угруповання авторів','Бикова Анастасія Павлівна','вул. Кармелюка, 42','0981238999','anasta@gmail.com'),(19,'Організація','Носова Марія Олегівна','вул. Хмельницького, 77','0509991221','NTA@gmail.com'),(20,'Угруповання авторів','Волошин Дмитро Богданович','вул. Сухомлинського, 01','0997651234','prolisok@gmail.com'),(30,'Організація','Хащевий Дмитро Олегович','вул. Сухомлинського, 23','0666567879','Jerelo@gmail.com'),(58,'Представник учасника','Вдорник Лідія Миколаївна','вул. Сухомлинського, 10','0991234466','lidia@gmail.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keys_data`
--

DROP TABLE IF EXISTS `keys_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keys_data` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_login` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_role` varchar(50) NOT NULL,
  `permission_table_client` varchar(20) NOT NULL,
  `permission_table_publication` varchar(20) NOT NULL,
  `permission_table_author` varchar(20) NOT NULL,
  `permission_table_printing_house` varchar(20) NOT NULL,
  `permission_queries` varchar(20) NOT NULL,
  `permission_add_user` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keys_data`
--

LOCK TABLES `keys_data` WRITE;
/*!40000 ALTER TABLE `keys_data` DISABLE KEYS */;
INSERT INTO `keys_data` VALUES (1,'Vitalina','Vitalina2431','Власник','T','T','T','T','T','T'),(2,'admin1','12345','Адміністратор','F','T','F','T','T','F'),(3,'oper','6789','Оператор','T','T','F','T','T','F'),(4,'visitor','vis123','Гість','F','T','T','F','F','F'),(6,'admin2','54321','Адміністратор','T','T','T','T','F','T'),(7,'visitor2','vis12890','Гість','T','F','F','F','T','F'),(10,'oper2','90000','Оператор','F','F','F','F','F','F');
/*!40000 ALTER TABLE `keys_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordering`
--

DROP TABLE IF EXISTS `ordering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordering` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_numb` varchar(45) NOT NULL,
  `print_product_type` varchar(55) NOT NULL,
  `client_id` int NOT NULL,
  `publication_id` int NOT NULL,
  `printing_house_id` int NOT NULL,
  `order_start_date` date NOT NULL,
  `order_end_date` date NOT NULL,
  `order_status_fulfilment` varchar(45) NOT NULL,
  `order_price` double NOT NULL,
  `order_status_payment` varchar(45) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `publication_id_idx` (`order_id`,`publication_id`),
  KEY `client_id_idx` (`client_id`),
  KEY `printing_house_id_idx` (`printing_house_id`),
  KEY `publication_id_idx1` (`publication_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `printing-house_id` FOREIGN KEY (`printing_house_id`) REFERENCES `printing_house` (`printing_house_id`),
  CONSTRAINT `publication_id` FOREIGN KEY (`publication_id`) REFERENCES `publication` (`publication_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordering`
--

LOCK TABLES `ordering` WRITE;
/*!40000 ALTER TABLE `ordering` DISABLE KEYS */;
INSERT INTO `ordering` VALUES (1,'0000X01','Книга',2,1,1,'2024-03-14','2024-07-24','В очікуванні',14200,'Неоплачено'),(2,'0000X02','Книга',12,3,2,'2024-08-26','2024-10-08','У процесі',10000,'Оплачено'),(3,'0000X03','Сертифікат',1,5,1,'2024-01-29','2024-03-13','Виконано',3400,'Оплачено'),(4,'0000X04','Журнал',14,19,6,'2024-04-18','2024-06-22','У процесі',5600,'Оплачено'),(6,'0000X05','Постер',16,16,6,'2024-07-05','2024-09-05','Виконано',50000,'Оплачено'),(7,'0000X06','Газета',12,18,1,'2024-05-23','2024-08-23','У процесі',88000,'Оплачено'),(8,'0000X07','Постер',14,22,5,'2024-08-14','2024-09-14','Скасовано',2000,'Неоплачено'),(9,'0000X08','Візитка',8,21,1,'2024-09-11','2024-11-11','В очікуванні',12000,'Неоплачено'),(10,'0000X09','Бланк',19,24,2,'2024-08-07','2024-12-07','В очікуванні',3900,'Оплачено'),(19,'0000X10','Візитка',1,25,1,'2024-09-04','2024-09-27','Виконано',4000,'Оплачено'),(20,'0000X11','Книга',30,26,1,'2024-01-22','2024-04-22','Виконано',200000,'Оплачено'),(21,'0000X12','Журнал',17,27,5,'2024-06-03','2024-08-03','Виконано',4800,'Оплачено'),(22,'0000X13','Книга',30,28,5,'2024-06-04','2024-08-04','Виконано',12000,'Оплачено'),(23,'0000X14','Книга',15,29,5,'2024-05-06','2024-12-06','У процесі',7800,'Оплачено'),(24,'0000X15','Книга',16,30,9,'2024-02-07','2024-03-07','Виконано',9000,'Оплачено'),(25,'0000X16','Книга',14,31,9,'2024-09-02','2024-12-02','В очікуванні',9300,'Неоплачено'),(26,'0000X17','Газета',16,23,2,'2023-09-15','2023-11-06','Скасовано',3500,'Неоплачено'),(29,'0000Y18','Каталог',58,34,9,'2024-10-24','2025-01-30','В очікуванні',9500,'Оплачено');
/*!40000 ALTER TABLE `ordering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `printing_house`
--

DROP TABLE IF EXISTS `printing_house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `printing_house` (
  `printing_house_id` int NOT NULL AUTO_INCREMENT,
  `printing_house_name` varchar(100) NOT NULL,
  `printing_house_address` varchar(100) NOT NULL,
  `printing_house_number_phone` varchar(45) NOT NULL,
  `printing_house_email` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`printing_house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printing_house`
--

LOCK TABLES `printing_house` WRITE;
/*!40000 ALTER TABLE `printing_house` DISABLE KEYS */;
INSERT INTO `printing_house` VALUES (1,'Друкарня \"Принт Майстер\"','вул. Соборна, 10','0669876543','printmaster@i.ua'),(2,'Друкарня \"Золотий Друк\"','вул. Вознесенська, 40','0668925540','zolotDruk@gmail.com'),(5,'Друкарня \"Магнолія\"','вул. Кармелюка, 14','0992343892','mang@gmail.com'),(6,'Друкарня \'Олімп\'','вул. Сухомлинського, 23','0996785678',NULL),(9,'Друкарня \'Print\'','вул. Сторожинецька, 07','0998901221','print@gmail.com');
/*!40000 ALTER TABLE `printing_house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication` (
  `publication_id` int NOT NULL AUTO_INCREMENT,
  `publication_code` varchar(45) NOT NULL,
  `publication_name` varchar(70) NOT NULL,
  `publication_type_size` varchar(45) NOT NULL,
  `publication_number_pages` int NOT NULL,
  `publication_circulation` int NOT NULL,
  `publication_amount_printed_sheets` float NOT NULL,
  PRIMARY KEY (`publication_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
INSERT INTO `publication` VALUES (1,'00X88X88X11','\"Французькі оповідки\"','Книга А5',320,300,10),(3,'00X00X44X23','\"Кривавий вечір\"','Книга А4',735,125,61.2255),(5,'00X09X54X02','\"Сертифікат Учасника LLP\"','Сертифікат A4',110,120,9.163),(16,'00X21X82X82','\"Акції тижня Сільпо\"','Постер А1',100,100,50),(18,'00X09X77X33','\"Події тижня\"','Газета А2',4,2000,1),(19,'00X90X22X78','\"Секрети здорової іжі\"','Журнал A5',35,200,1.0938),(21,'00X11X11X82','\"Cofeeman\"','Візитка 90x50 мм',2,2000,0.008),(22,'00X33X12X12','\"Вітаємо!\"','Постер А2',1,1,0.25),(23,'00X22X88X00','\"Про Авторів\"','Газета А3',8,300,1),(24,'00X11X22X66','\"Опитувальник ГОР\"','Бланк А5',6,100,0.1875),(25,'00X33X88X22','\"Фірма Лотос\"','Візитка 90x50 мм',1,1000,0.004),(26,'00X71X66X33','\"Mafia\"','Книга А4',780,4000,64.974),(27,'00X21X44X21','\"Happy Holiday\"','Журнал A5',30,350,0.9375),(28,'00X12X88X22','\"Філософія Буття\"','Книга А5',450,10000,14.0625),(29,'00X09X88X82','\"Променто\"','Книга А4',900,40,74.97),(30,'00X45X99X29','\"Пригоди Лінди\"','Книга А5',300,700,9.375),(31,'00X34X90X89','\"LOL2 Wild Rift\"','Книга А5',110,500,3.4375),(33,'00X34X00X56','\"Університет ЧНУ\"','Брошура А5',2,800,0.0625),(34,'00X22X00X11','\"Тренд 2024\"','Каталог А5',45,200,1.4063);
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication_author`
--

DROP TABLE IF EXISTS `publication_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication_author` (
  `publication_author_id` int NOT NULL AUTO_INCREMENT,
  `publication_id` int NOT NULL,
  `author_id` int NOT NULL,
  PRIMARY KEY (`publication_author_id`),
  KEY `id_publication_idx` (`publication_id`),
  KEY `id_author_idx` (`author_id`),
  CONSTRAINT `id_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `id_publication` FOREIGN KEY (`publication_id`) REFERENCES `publication` (`publication_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication_author`
--

LOCK TABLES `publication_author` WRITE;
/*!40000 ALTER TABLE `publication_author` DISABLE KEYS */;
INSERT INTO `publication_author` VALUES (1,1,1),(2,1,6),(3,1,10),(4,3,10),(5,3,16),(6,5,6),(7,5,13),(8,5,17),(9,16,20),(10,18,22),(11,18,23),(12,19,9),(13,19,16),(14,19,20),(15,21,27),(16,22,6),(17,22,19),(18,22,8),(19,23,6),(20,24,17),(21,24,28),(22,25,1),(23,26,24),(24,26,14),(25,27,23),(26,28,9),(27,29,20),(28,29,1),(29,30,27),(30,30,12),(31,31,12),(32,33,10),(33,33,6),(34,33,13),(36,34,8),(37,16,1),(38,16,10),(39,26,1),(40,26,12),(41,1,12),(42,28,1),(43,28,10);
/*!40000 ALTER TABLE `publication_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'publishing_house'
--

--
-- Dumping routines for database 'publishing_house'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-04 16:25:30
