/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.18-log : Database - hairsal
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hairsal` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hairsal`;

/*Table structure for table `apointment` */

DROP TABLE IF EXISTS `apointment`;

CREATE TABLE `apointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(255) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(255) NOT NULL,
  `service_id` int(11) NOT NULL,
  `master_id` int(11) NOT NULL,
  `notes` text,
  PRIMARY KEY (`id`),
  KEY `service_id` (`service_id`),
  KEY `master_id` (`master_id`),
  CONSTRAINT `apointment_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  CONSTRAINT `apointment_ibfk_2` FOREIGN KEY (`master_id`) REFERENCES `master` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `apointment` */

insert  into `apointment`(`id`,`name`,`surname`,`email`,`date`,`time`,`created_date`,`phone`,`service_id`,`master_id`,`notes`) values (5,'Styopa','Khachatryan','karen.x.2008@gmail.com','2019-11-14','15:50','2019-11-23 10:50:39','09333335',1,1,'mjhgf'),(6,'valod','valodyan','valod@gmail.com','2019-11-15','04:50','2019-11-23 12:24:00','09333335',2,4,'Hairhdgjhfgjfkj'),(7,'Styopa','','','2019-11-21','08:50','2019-11-23 19:13:41','09333335',3,4,'sdghfjdths');

/*Table structure for table `gallery` */

DROP TABLE IF EXISTS `gallery`;

CREATE TABLE `gallery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `gallery` */

insert  into `gallery`(`id`,`pic_url`,`date`,`description`) values (14,'1574523721115_677463191796400img_3.jpg','2019-11-13 00:00:00','Our Gallery Pic');

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `master` */

insert  into `master`(`id`,`name`,`surname`,`pic_url`) values (1,'Styopa','Khachatryan','1574408796015_562527755377299person_3.jpg'),(2,'Styopa','Khachatryan','1574409085114_562816854727600person_3.jpg'),(3,'poxos','Khachatryan','1574409287015_563018755329100img_3.jpg'),(4,'Haircat','valodyan','1574409407910_563139649582300img_3.jpg'),(5,'poxos','valodyan','1574521305455_675047531827200person_1.jpg'),(6,'poxos','poxosyan','1574521957956_675700032895500hero_bg_3.jpg'),(7,'poxos','poxosyan','1574521967109_675709185553900hero_bg_3.jpg');

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `description` text,
  `pic_url` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `service` */

insert  into `service`(`id`,`name`,`price`,`description`,`pic_url`) values (1,'Hair Cut',1000,'ls;dkzjhfx',NULL),(2,'Hair Wash',500,'zljhmgfbvsdhd',NULL),(3,'Styopa',50,'fghkkf','1574396043620_549775326505400ico1sanr.jpg'),(4,'gggg',50,'ggggg','1574521835739_6755778160660001574396043620_549775326505400ico1sanr.jpg'),(5,'Haircat',50,'sdfg','1574521946825_675688901531500img_1.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
