USE `soft_uni`;
DROP function IF EXISTS `ufn_get_salary_level`;

DELIMITER $$
USE `soft_uni`$$
CREATE FUNCTION `ufn_get_salary_level` (`employee_salary` DOUBLE)
RETURNS TEXT
DETERMINISTIC
BEGIN
RETURN (
	CASE
		WHEN `employee_salary` < 30000 THEN 'Low'
        WHEN `employee_salary` <= 50000 THEN 'Average'
        ELSE 'High'
	END
);
END$$

DELIMITER ;

