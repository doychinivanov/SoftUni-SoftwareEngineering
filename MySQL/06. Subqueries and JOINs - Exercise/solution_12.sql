SELECT c.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `mountains_countries` AS c
JOIN `mountains` AS m
ON c.`mountain_id` = m.`id`
JOIN `peaks` AS p
ON p.`mountain_id` = m.`id`
WHERE c.`country_code` = 'BG' AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;