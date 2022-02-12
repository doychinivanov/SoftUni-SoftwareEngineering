USE `soft_uni`;
DROP function IF EXISTS `ufn_is_word_comprised`;

DELIMITER $$
USE `soft_uni`$$
CREATE FUNCTION ufn_is_word_comprised(`set_of_letters` varchar(50), `word` varchar(50))  
RETURNS BIT
DETERMINISTIC
BEGIN
	RETURN `word` REGEXP(CONCAT('^[', `set_of_letters`, ']+$'));
END$$

DELIMITER ;