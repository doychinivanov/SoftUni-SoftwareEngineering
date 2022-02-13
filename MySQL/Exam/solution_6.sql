SELECT p.`id`, b.`id` AS `brand_id`, p.`name`, p.`quantity_in_stock` FROM `brands` AS b
JOIN `products` AS p
ON b.`id` = p.`brand_id`
WHERE p.`price` > 1000 AND p.`quantity_in_stock` < 30
ORDER BY p.`quantity_in_stock`, p.`id`;