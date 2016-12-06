CREATE PROCEDURE `add_password`(`id` INT(11), `password` VARCHAR(100))
  BEGIN
INSERT INTO password_tables VALUES (id, password);
END