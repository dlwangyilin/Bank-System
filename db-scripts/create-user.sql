CREATE USER 'admin'@'localhost' IDENTIFIED BY '123456';

GRANT ALL PRIVILEGES ON * . * TO 'admin'@'localhost';

ALTER USER 'admin'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';