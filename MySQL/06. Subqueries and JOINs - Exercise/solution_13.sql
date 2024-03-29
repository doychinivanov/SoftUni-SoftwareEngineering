SELECT c.`country_code`, COUNT(m.`mountain_range`) AS `mountain_range`
FROM `mountains_countries` AS c
JOIN `mountains` AS m
ON c.`mountain_id` = m.`id`
WHERE c.`country_code` IN ('BG', 'RU', 'US')
GROUP BY c.`country_code`
ORDER BY `mountain_range` DESC;