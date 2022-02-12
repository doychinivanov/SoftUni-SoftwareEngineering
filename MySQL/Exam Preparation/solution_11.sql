USE `exam_prep`;
DROP procedure IF EXISTS `udp_modify_user`;

DELIMITER $$
USE `exam_prep`$$
CREATE PROCEDURE `udp_modify_user` (`address_param` VARCHAR(30), `town_param` VARCHAR(30))
BEGIN
	IF(
	(
		SELECT a.`address` FROM `addresses` AS a
        WHERE `address_param` = a.`address` AND `town_param` = a.`town`
	)
	IS NOT NULL)
    THEN UPDATE `users` AS u
	JOIN `addresses` AS aa
    ON u.`id` = aa.`user_id`
    SET u.`age` = u.`age` + 10
    WHERE aa.`address` = `address_param` AND aa.`town` = `town_param`;
    END IF;
END$$

DELIMITER ;

