USE `soft_uni`;
DROP procedure IF EXISTS `usp_get_employees_salary_above`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_employees_salary_above` (`salary_param` DOUBLE(19, 4))
BEGIN
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` >= `salary_param`
    ORDER BY `first_name`, `last_name`, `employee_id` ASC;
END$$

DELIMITER ;