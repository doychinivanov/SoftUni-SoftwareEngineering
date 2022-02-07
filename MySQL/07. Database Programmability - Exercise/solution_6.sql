USE `soft_uni`;
DROP procedure IF EXISTS `usp_get_employees_by_salary_level`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_employees_by_salary_level` (`salary_type` VARCHAR(7))
BEGIN
	SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    WHERE ufn_geT_salary_level(e.`salary`) = `salary_type`
    ORDER BY `first_name` DESC, `last_name` DESC;
END$$

DELIMITER ;

