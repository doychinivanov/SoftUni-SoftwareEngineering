USE `exam_prep`;
DROP function IF EXISTS `udf_users_photos_count`;

DELIMITER $$
USE `exam_prep`$$
CREATE FUNCTION `udf_users_photos_count` (username_param VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
	RETURN 
    (
		SELECT COUNT(up.`user_id`) FROM `users` AS u
		JOIN `users_photos` AS up
		ON u.`id` = up.`user_id`
		WHERE u.`username` = `username_param`
    );
END$$

DELIMITER ;

