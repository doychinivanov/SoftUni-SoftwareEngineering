SELECT c.`country_name`, r.`river_name`
FROM `countries_rivers` AS cc
JOIN `rivers` AS r
ON cc.`river_id` = r.`id`
RIGHT JOIN `countries` AS c
ON cc.`country_code` = c.`country_code`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;