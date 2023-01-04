CREATE DATABASE JAVA_MCA;
USE JAVA_MCA;

CREATE TABLE students (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

DELIMITER //
CREATE PROCEDURE get_student_details(IN p_id INTEGER, OUT p_name VARCHAR(255), OUT p_address VARCHAR(255), OUT p_age INTEGER)
BEGIN
    SELECT name, address, age INTO p_name, p_address, p_age FROM students WHERE id = p_id;
END //
DELIMITER ;