# Bank-System

## Preparation for database

```sql
-- create a user
CREATE USER 'admin'@'localhost' IDENTIFIED BY '123456';

GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';

ALTER USER 'admin'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';

-- create a schema and table
CREATE DATABASE  IF NOT EXISTS `bank_tracker`;
USE `bank_tracker`;
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `value` int default 0, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES 
	(1,'Yilin','Wang','yilin@uci.edu', 10000),
	(2,'Tina','Qi','tina@uci.edu', 20000);

UNLOCK TABLES;
```

