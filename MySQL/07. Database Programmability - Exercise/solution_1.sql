USE `soft_uni`;
DROP procedure IF EXISTS `usp_get_employees_salary_above_35000`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` > 35000
    ORDER BY `first_name`, `last_name`, `salary` ASC;
END$$

DELIMITER ;