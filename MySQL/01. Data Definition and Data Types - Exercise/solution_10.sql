ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY(`id`),
CHANGE `username` `username` VARCHAR(30) NOT NULL UNIQUE;