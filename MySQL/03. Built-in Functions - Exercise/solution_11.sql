SELECT
`peak_name`,
`river_name`,
LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS `mixed`
FROM `peaks`, `rivers`
WHERE LOWER(RIGHT(`peak_name`, 1)) = LOWER(LEFT(`river_name`, 1))
ORDER BY `mixed`;