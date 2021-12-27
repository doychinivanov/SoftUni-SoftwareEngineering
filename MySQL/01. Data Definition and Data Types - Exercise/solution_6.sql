CREATE TABLE `people` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(200) NOT NULL,
    `picture` BLOB,
    `height` FLOAT(5, 2),
    `weight` FLOAT(5,2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO `people`
VALUES
(1, 'Pesho', 'asdf', 1.8, 70.5, 'M', '31.12.2021', 'no bio'),
(2, 'Ivan', 'asdf', 1.8, 70.5, 'M', '31.12.2021', 'no bio'),
(3, 'Georgi', 'asdf', 1.8, 70.5, 'M', '31.12.2021', 'no bio'),
(4, 'Maria', 'asdf', 1.8, 70.5, 'F', '31.12.2021', 'no bio'),
(5, 'Dasha', 'asdf', 1.8, 70.5, 'F', '31.12.2021', 'no bio');
