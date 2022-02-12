USE `soft_uni`;
DROP function IF EXISTS `ufn_calculate_future_value`;

DELIMITER $$
USE `soft_uni`$$
CREATE FUNCTION `ufn_calculate_future_value` (`initial_sum` DECIMAL(19,4), `interest_rat` DECIMAL(19,4), `years` INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
RETURN `initial_sum` * POW((1 + `interest_rat`), `years`);
END$$

DELIMITER ;

