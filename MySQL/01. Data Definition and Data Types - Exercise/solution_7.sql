CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` DATETIME NOT NULL,
    `is_deleted` BOOLEAN
);

INSERT INTO `users`
VALUES
(1, 'Pesho', 'asdf', 'blah', '31.12.2021', true),
(2, 'Ivan', 'asdf', 'blah', '31.12.2021', false),
(3, 'Georgi', 'asdf', 'blah', '31.12.2021', true),
(4, 'Maria', 'asdf', 'blah', '31.12.2021', true),
(5, 'Dasha', 'asdf', 'blah', '31.12.2021', false);