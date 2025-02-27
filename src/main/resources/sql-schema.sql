drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
     `item_name` VARCHAR(50) NOT NULL,
     `item_cost` FLOAT(2) NOT NULL,
     PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `items` TEXT,
    `itemIds` TEXT,
    `order_cost` float,
    PRIMARY KEY(`id`),
    FOREIGN KEY (`customer_id`) REFERENCES customers(id)
);