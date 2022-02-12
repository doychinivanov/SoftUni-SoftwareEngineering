USE `soft_uni`;
DROP procedure IF EXISTS `usp_get_towns_starting_with`;

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_towns_starting_with` (`start_param` TEXT)
BEGIN
	SELECT `name` AS `town_name`
    FROM `towns`
    WHERE `name` LIKE CONCAT(`start_param`, '%')
    ORDER BY `name`;
END$$

DELIMITER ;

