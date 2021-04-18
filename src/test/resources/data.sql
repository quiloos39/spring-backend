CREATE SCHEMA basketball;

CREATE TABLE basketball.player (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL,
    position ENUM ('PG', 'SG', 'SF', 'PF', 'C'),
    PRIMARY KEY (id)
);
