USE `soft_uni`;
DROP procedure IF EXISTS `usp_raise_salaries`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_raise_salaries` (`department_name_param` VARCHAR(50))
BEGIN
	UPDATE `employees`
		JOIN `departments` AS d
		USING(`department_id`)
	SET `salary` = `salary` * 1.05
    WHERE d.`name` = `department_name_param`;
END$$

DELIMITER ;