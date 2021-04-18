DROP DATABASE IF EXISTS basketball;
DROP USER IF EXISTS basketball;

CREATE DATABASE basketball;
use basketball;

CREATE TABLE player (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    position ENUM ('PG', 'SG', 'SF', 'PF', 'C'),
    PRIMARY KEY (id)
);

CREATE USER 'basketball'@'%' IDENTIFIED BY 'basketball';
GRANT ALL PRIVILEGES ON basketball.* TO 'basketball'@'%';