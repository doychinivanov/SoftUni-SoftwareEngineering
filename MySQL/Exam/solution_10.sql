USE `online_store`;
DROP function IF EXISTS `udf_customer_products_count`;

DELIMITER $$
USE `online_store`$$
CREATE FUNCTION `udf_customer_products_count` (`name` VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (
		SELECT COUNT(o.`id`) 
		FROM `customers` AS c
		LEFT JOIN `orders` AS o
        ON c.`id` = o.`customer_id`
		LEFT JOIN `orders_products` AS op
        ON o.`id` = op.`order_id`
		LEFT JOIN `products` AS `p`
        ON op.`product_id` = p.`id`
		WHERE c.`first_name` = `name`
) ;
END$$

DELIMITER ;