create database grupo19;
CREATE USER 'grupo2022'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
GRANT ALL PRIVILEGES ON grupo19.* TO 'grupo2022'@'localhost';