CREATE DATABASE `car_rental`;

USE `car_rental`;

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `category` VARCHAR(50) NOT NULL,
    `daily_rate` INT,
    `weekly_rate` INT,
    `monthly_rate` INT,
    `weekend_rate` INT
);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `plate_number` VARCHAR(50) NOT NULL,
    `make` VARCHAR(50),
    `model` VARCHAR(50),
    `car_year` INT(4),
    `doors` INT,
    `picture` BLOB,
    `car_condition` VARCHAR(50),
    `avaliable` BOOLEAN,
    `category_id` INT NOT NULL,
    CONSTRAINT fk_cars_categoris
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `customers` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `driver_licence_number` VARCHAR(30) NOT NULL,
    `full_name` VARCHAR(50),
    `address` VARCHAR(50),
    `city` VARCHAR(50),
    `zip_code` INT,
    `notes` TEXT
);

CREATE TABLE `rental_orders` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `employee_id` INT NOT NULL,
    CONSTRAINT fk_rental_orders_emplyees
    FOREIGN KEY (`employee_id`) REFERENCES `employees`(`id`),
    `customer_id` INT NOT NULL,
    CONSTRAINT fk_rentail_orders_customers
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`),
    `car_id` INT NOT NULL,
	CONSTRAINT fk_rentail_orders_cars
    FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`),
    `car_condition` VARCHAR(50),
    `tank_level` INT,
    `kilometrage_start` INT,
    `kilometrage_end` INT,
    `total_kilometrage` INT,
    `start_date` DATE,
    `end_date` DATE,
    `total_days` INT,
    `rate_applied` INT,
    `tax_rate` INT,
    `order_status` VARCHAR(50),
    `notes` TEXT
);

INSERT INTO `categories` (`category`) VALUES ('Sedan'), ('Minivan'), ('Jeep');
 
INSERT INTO `cars` (`plate_number`, `make`, `model`, `car_condition`, `category_id`)
VALUES ('2423', 'Tesla', 'Model S', 'great', 1), ('2424', 'Tesla', 'Model X', 'good', 2), ('2425', 'Tesla', 'Model Y', 'perfect', 3);

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES ('Ivan', 'Ivanov','PM'), ('George', 'Georgiev','Programmer'), ('Stoqn', 'Stoqnov','CEO');

INSERT INTO `customers` (`driver_licence_number` ,`full_name`) 
VALUES ('234234', 'Ivanov'), ('234234234', 'Georgiev'), ('43241324', 'Stoqnov');

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_condition`, `car_id`)
VALUES (1, 1, 1, 1), (2, 2, 2, 2),(3, 3, 3, 3);