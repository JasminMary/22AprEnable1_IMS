DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `order_items`;


CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `item_price` DOUBLE(10) DEFAULT NULL,
    PRIMARY KEY (`item_id`) 
);

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `orders` (
   `order_id` INT(11) NOT NULL AUTO_INCREMENT,
   `customer_id` INT(11),
   `order_amount` INT(11) DEFAULT 1,
   PRIMARY KEY (`order_id`),
   FOREIGN KEY (`customer_id`) REFERENCES customers(`id`)
);
CREATE TABLE IF NOT EXISTS `order_items` (
	`order_item_id` INT(11) NOT NULL AUTO_INCREMENT,
	`order_id` INT(11),
	`item_id` INT(11),
	PRIMARY KEY (order_item_id),
	FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`),
	FOREIGN KEY (`item_id`) REFERENCES items(`item_id`)
);


