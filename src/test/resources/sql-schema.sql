DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
     `item_name` VARCHAR(50) NOT NULL,
     `item_cost` FLOAT(2) NOT NULL,
     PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `items` TEXT,
    `itemIds` TEXT,
    `order_cost` FLOAT(2),
    PRIMARY KEY(`id`),
    FOREIGN KEY (`customer_id`) REFERENCES customers(id)
);
