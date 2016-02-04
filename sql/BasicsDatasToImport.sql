-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: library_java
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `books_book_genres`
--

DROP TABLE IF EXISTS `books_book_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_book_genres` (
  `book_genre_id` int(10) unsigned NOT NULL,
  `book_id` int(10) unsigned NOT NULL,
  KEY `FKsresn4de58im0e19bb23spmhy` (`book_id`),
  KEY `FK6yareg4guyetinbvtm715jeur` (`book_genre_id`),
  CONSTRAINT `FK6yareg4guyetinbvtm715jeur` FOREIGN KEY (`book_genre_id`) REFERENCES `tbl_books` (`id`),
  CONSTRAINT `FKsresn4de58im0e19bb23spmhy` FOREIGN KEY (`book_id`) REFERENCES `tbl_book_genres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_book_genres`
--

LOCK TABLES `books_book_genres` WRITE;
/*!40000 ALTER TABLE `books_book_genres` DISABLE KEYS */;
INSERT INTO `books_book_genres` VALUES (4,10),(4,12),(5,10),(5,12),(6,10),(6,11),(7,9);
/*!40000 ALTER TABLE `books_book_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_authors`
--

DROP TABLE IF EXISTS `tbl_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_authors` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `biography` text,
  `birthdate` date DEFAULT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_authors`
--

LOCK TABLES `tbl_authors` WRITE;
/*!40000 ALTER TABLE `tbl_authors` DISABLE KEYS */;
INSERT INTO `tbl_authors` VALUES (3,'Cet auteur a écrit plusieurs romans dont la célèbre saga des dunes.','1920-10-08','Frank','Herbert'),(4,'Cet auteur a écrit les fameux livres sur la Terre du Milieu.','1892-01-03','J.R.R','Tolkien'),(5,'Il est l\'auteur de la célèbre autpbiographie de Christopher McCandless et de Tragédie à l\'everest.','1954-04-12','Jon','Krakauer');
/*!40000 ALTER TABLE `tbl_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book_genres`
--

DROP TABLE IF EXISTS `tbl_book_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_book_genres` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ind_description` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book_genres`
--

LOCK TABLES `tbl_book_genres` WRITE;
/*!40000 ALTER TABLE `tbl_book_genres` DISABLE KEYS */;
INSERT INTO `tbl_book_genres` VALUES (9,'Autobiographie'),(10,'Aventure'),(11,'Fantasy'),(12,'Science-Fiction');
/*!40000 ALTER TABLE `tbl_book_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_books`
--

DROP TABLE IF EXISTS `tbl_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_books` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pages_number` smallint(5) unsigned DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `summary` text,
  `title` varchar(255) NOT NULL,
  `author_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ind_title` (`title`),
  KEY `FKpnger7d4inleo2jcnnsl8rakr` (`author_id`),
  CONSTRAINT `FKpnger7d4inleo2jcnnsl8rakr` FOREIGN KEY (`author_id`) REFERENCES `tbl_authors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_books`
--

LOCK TABLES `tbl_books` WRITE;
/*!40000 ALTER TABLE `tbl_books` DISABLE KEYS */;
INSERT INTO `tbl_books` VALUES (4,600,'Chilton Books','L’histoire débute en l’an 10191 après la création de la Guilde spatiale. L’empereur Shaddam IV exerce son pouvoir féodal3 sur tout l’univers connu. L’humanité a conquis une grande étendue de l’univers, notamment grâce à une mystérieuse substance dénommée « Épice » ou « Mélange ». L’Épice constitue un puissant stimulant cérébral et permet à certains humains de décupler leurs capacités psychiques. De plus, elle accroît considérablement la durée de vie et immunise le corps contre de nombreuses maladies. Son origine précise est un mystère et les quantités disponibles sont rarissimes ; elle est par ailleurs impossible à synthétiser. L\'ensemble de ces paramètres lui confère une valeur monétaire particulièrement élevée.','Dune',3),(5,300,'New English Library','Paul Atréides a triomphé de ses ennemis. En douze ans de guerre sainte, ses Fremen ont conquis l’univers. Partout flotte la bannière verte du Jihad des Atréides. Il est devenu l’Empereur Muad\'Dib, presque un Dieu, et il voit l’avenir. Ses ennemis, il les connait : la Guilde spatiale, le Bene Gesserit, l’ancienne Maison Impériale Corrino et évidemment le Bene Tleilax. Il sait quand et comment ils frapperont. Ils vont essayer de lui reprendre l’Épice qui donne la prescience, et peut-être percer le secret de son pouvoir.','Le Messie de Dune',3),(6,1000,'Allen & Unwin','Aux temps reculés qu\'évoque le récit, la Terre est peuplée d\'innombrables créatures étranges.','Le Seigneur des Anneaux, La communeauté de l\'anneau.',4),(7,224,'Random House','Voyage au bout de la solitude (Into the Wild) est un roman biographique de Christopher McCandless écrit par Jon Krakauer, publié en 1996. Il retrace l\'histoire véridique de ce jeune homme qui avait troqué la civilisation pour un retour à la vie sauvage, et y avait trouvé la mort. Il s\'agit d\'une version longue d\'un article de Krakauer, intitulé Death of an Innocent et paru dans le numéro de janvier 1993 de Outside.','Voyage au bout de la solitude',5);
/*!40000 ALTER TABLE `tbl_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,'ROLE_ADMIN',1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `enabled` tinyint(1) DEFAULT NULL,
  `password` varchar(500) NOT NULL,
  `username` varchar(100) NOT NULL,
  `user_role_id` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsy1luwgtc2qas77si4xlrkjtl` (`user_role_id`),
  CONSTRAINT `FKsy1luwgtc2qas77si4xlrkjtl` FOREIGN KEY (`user_role_id`) REFERENCES `user_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,1,'$2a$10$7C/PbqYZl9U51gLf9OYB0.ODQrB3MD2kbS16rIZ420UBf7Oy.cgoW','thomas',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-04 19:48:06
