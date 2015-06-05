# SQL Manager Lite for MySQL 5.5.0.45357
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : guestbook


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `guestbook`;

CREATE DATABASE `guestbook`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `guestbook`;

#
# Dropping database objects
#

DROP TABLE IF EXISTS `tbl_user_comments`;
DROP TABLE IF EXISTS `tbl_users`;

#
# Structure for the `tbl_users` table : 
#

CREATE TABLE `tbl_users` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `creation_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `email_address` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `password` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `username` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB
AUTO_INCREMENT=21 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;

#
# Structure for the `tbl_user_comments` table : 
#

CREATE TABLE `tbl_user_comments` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `comment` LONGTEXT COLLATE utf8_general_ci,
  `user_id` INTEGER(11) DEFAULT NULL,
  `creation_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_p3kt49w6eakrn4d0p5re708wh` (`user_id`) USING BTREE,
  CONSTRAINT `FK_p3kt49w6eakrn4d0p5re708wh` FOREIGN KEY (`user_id`) REFERENCES `tbl_users` (`id`)
) ENGINE=InnoDB
AUTO_INCREMENT=17 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;

#
# Data for the `tbl_users` table  (LIMIT 0,500)
#

INSERT INTO `tbl_users` (`id`, `address`, `creation_time`, `email_address`, `password`, `username`) VALUES
  (17,'Bangalore','2015-05-18 13:46:51','test@maplelabs.Com','test','test'),
  (18,'Bangalore','2015-05-18 13:47:21','user@maplelabs.Com','user','user'),
  (19,'test',NULL,'test','test','test'),
  (20,NULL,NULL,'maplelabsnutx@gmail.com.sb',NULL,'maplelabsnutx@gmail.com.sb');
COMMIT;

#
# Data for the `tbl_user_comments` table  (LIMIT 0,500)
#

INSERT INTO `tbl_user_comments` (`id`, `comment`, `user_id`, `creation_time`) VALUES
  (11,'test3',18,NULL),
  (12,'test2',18,NULL),
  (15,'test12',17,NULL),
  (16,'test13',17,NULL);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;