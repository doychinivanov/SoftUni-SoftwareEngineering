USE `online_store`;
DROP procedure IF EXISTS `udp_reduce_price`;

USE `online_store`;
DROP procedure IF EXISTS `online_store`.`udp_reduce_price`;
;

DELIMITER $$
USE `online_store`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `udp_reduce_price`(`category_name` VARCHAR(50))
BEGIN
	UPDATE `products` AS p
	JOIN `categories` AS c
    ON p.`category_id` = c.`id`
	JOIN `reviews` AS r
    ON p.`review_id` = r.`id`	
    SET p.`price` = p.`price` * 0.7
	WHERE r.`rating` < 4 AND c.`name` = `category_name`;
END$$

DELIMITER ;
;

