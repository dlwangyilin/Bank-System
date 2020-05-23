# Bank-System

## Preparation for database

```sql
-- create a user
CREATE USER 'admin'@'localhost' IDENTIFIED BY '123456';

GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';

ALTER USER 'admin'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';

-- create a schema and table
DROP DATABASE  IF EXISTS `bank_tracker_with_pass`;

CREATE DATABASE  IF NOT EXISTS `bank_tracker_with_pass`;
USE `bank_tracker_with_pass`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `value` int default 0, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://bcrypt-generator.com/
--
-- Default passwords here are: 123456
--

INSERT INTO `user` (username,password,first_name,last_name,email,value)
VALUES 
('yilin','$2y$12$ELJHwK70Z3bjWcyTGJbQteDGm.Lhck9zPI4EoQ4IXWTsQDcPEsZiS','Yilin','Wang','yilin@uci.edu',1000),
('tina','$2y$12$anq24VsTQJzg1w8TnUM3weId3U9TwJ9TqfGspLNeynj8YYB49NnDi','Tianyu','Qi','tina@uci.edu',1000),
('admin','$2y$12$KF6xs8TnkXw4nETZmZEGcuSC0qv2ArDVY4xGc4dVH.pB0ckScA.wK','Xizi','Wang','xizi@uci.edu',1000);


--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `role` (name)
VALUES 
('ROLE_CUSTOMER'),('ROLE_ADMIN');

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(3, 1),
(3, 2)
```

