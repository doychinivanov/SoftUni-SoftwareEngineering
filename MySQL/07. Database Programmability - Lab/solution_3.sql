USE `soft_uni`;
DROP procedure IF EXISTS `usp_raise_salary_by_id`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_raise_salary_by_id` (`_id` INT)
BEGIN
	IF ((SELECT COUNT(*) FROM `employees` WHERE `employee_id` = `_id`) = 1)
    THEN
		UPDATE `employees`
        SET `salary` = `salary` * 1.05
        WHERE `employee_id` = `_id`;
    END IF;
END$$

DELIMITER ;