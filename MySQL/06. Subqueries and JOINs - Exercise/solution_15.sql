SELECT c.`continent_code`, c.`currency_code`, COUNT(c.`country_name`) AS `currency_usage`
FROM `countries` AS c
GROUP BY c.`continent_code`, c.`currency_code`
HAVING `currency_usage` = (
	SELECT COUNT(`country_code`) AS `count`
    FROM `countries` AS c1
    WHERE c1.`continent_code` = c.`continent_code`
    GROUP BY `currency_code`
    ORDER BY `count` DESC
    LIMIT 1
) AND `currency_usage` > 1
ORDER BY c.`continent_code`, c.`currency_code`;