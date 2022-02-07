USE `soft_uni`;
DROP procedure IF EXISTS `usp_get_employees_from_town`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_employees_from_town` (`town_name_param` TEXT)
BEGIN
	SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    JOIN `addresses` AS a
    USING (`address_id`)
    JOIN `towns` AS t
    USING (`town_id`)
    WHERE t.`name` = `town_name_param`
    ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
END$$

DELIMITER ;

