CREATE VIEW v_employees_job_title AS
SELECT 
CONCAT_WS(' ', `first_name`, `middle_name`, `last_name`) AS `full_name`,
`job_title`
FROM `employees`;