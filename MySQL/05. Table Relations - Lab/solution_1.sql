CREATE TABLE `mountains` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(100) NOT NULL
);

CREATE TABLE `peaks` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(100) NOT NULL,
    `mountain_id` INT NOT NULL,
    CONSTRAINT fk_peaks_mountain
    FOREIGN KEY (`mountain_id`)
    REFERENCES `mountains`(`id`)
    ON DELETE CASCADE
);