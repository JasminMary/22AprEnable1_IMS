drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
   `item_id` INT (11) NOT NULL AUTO_INCREMENT,
   `item_name` VARCHAR (40) DEFAULT NULL,
   `item_price` DOUBLE (8, 2) DEFAULT NULL,
   PRIMARY KEY (`item_id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
   `order_id` INT(11) NOT NULL AUTO_INCREMENT,
   `customer_id` INT(11),
   `item_id` INT(11),
   `amount` INT (10),
   `total_price` DOUBLE(12, 2),
   PRIMARY KEY (`order_id`),
   FOREIGN KEY (`customer_id`) REFERENCES customers(`id`),
   FOREIGN KEY (`item_id`) REFERENCES items(`item_id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
	`order_item_id` INT(11) NOT NULL AUTO_INCREMENT,
	`order_id` INT(11),
	`item_id` INT(11),
	PRIMARY KEY (order_item_id),
	FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`),
	FOREIGN KEY (`item_id`) REFERENCES items(`item_id`)
);
	


