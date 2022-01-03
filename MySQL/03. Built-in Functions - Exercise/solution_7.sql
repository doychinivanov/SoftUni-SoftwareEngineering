SELECT `town_id`, `name`
FROM `towns`
WHERE LOWER(`name`) NOT REGEXP '^[rbd]'
ORDER BY `name`;