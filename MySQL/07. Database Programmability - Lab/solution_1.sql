USE `soft_uni`;
DROP function IF EXISTS `ufn_count_employees_by_town`;

DELIMITER $$
USE `soft_uni`$$
CREATE FUNCTION `ufn_count_employees_by_town`(`town_name_param` VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (
	SELECT COUNT(*)
    FROM `employees` AS e
    JOIN `addresses` AS a
    ON a.`address_id` = e.`address_id`
    JOIN `towns` AS t
    USING(`town_id`)
    WHERE t.`name` = `town_name_param`
    GROUP BY t.`name`
);
END$$

DELIMITER ;