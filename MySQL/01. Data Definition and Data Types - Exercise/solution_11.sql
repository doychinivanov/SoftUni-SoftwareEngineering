CREATE DATABASE `movies`;

USE `movies`;

CREATE TABLE `directors` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `director_name` VARCHAR(20) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `genre_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(50) NOT NULL,
    `director_id` INT NOT NULL,
    CONSTRAINT fk_movies_directors
    FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`),
    `copyright_year` YEAR(4) NOT NULL,
    `length` VARCHAR(30) NOT NULL,
    `genre_id` INT NOT NULL,
    CONSTRAINT fk_movies_genres
    FOREIGN KEY (`genre_id`) REFERENCES `genres`(`id`),
    `category_id` INT NOT NULL,
    CONSTRAINT fk_movies_categories
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`),
    `rating` INT NOT NULL,
	`notes` TEXT
);

INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Pesho', 'blah');
INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Pesho', 'blah');
INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Pesho', 'blah');
INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Pesho', 'blah');
INSERT INTO `directors` (`director_name`, `notes`) VALUES ('Pesho', 'blah');

INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('horror', 'blah');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('mistery', 'blah');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('drama', 'blah');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('anime', 'blah');
INSERT INTO `genres` (`genre_name`, `notes`) VALUES ('crime', 'blah');

INSERT INTO `categories` (`category_name`, `notes`) VALUES ('test', 'blah');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('test1', 'blah');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('test2', 'blah');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('test3', 'blah');
INSERT INTO `categories` (`category_name`, `notes`) VALUES ('test4', 'blah');

INSERT INTO `movies` (`title`,  `director_id`,  `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES('test1', 1, 2000, 'length',  1, 1, 3.2, 'blah');

INSERT INTO `movies` (`title`,  `director_id`,  `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES('test2', 2, 2000, 'length', 2, 2, 3.2, 'blah');

INSERT INTO `movies` (`title`,  `director_id`,  `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES('test3', 3, 2000, 'length', 3, 3, 3.2, 'blah');

INSERT INTO `movies` (`title`,  `director_id`,  `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES('test4', 4, 2000, 'length', 4, 4, 3.2, 'blah');

INSERT INTO `movies` (`title`,  `director_id`,  `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES('test5', 5, 2000, 'length', 5, 5, 3.2, 'blah');