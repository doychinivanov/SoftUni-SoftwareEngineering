SELECT `town_id`, `name`
FROM `towns`
WHERE LOWER(`name`) REGEXP '^[mkbe]'
ORDER BY `name`;