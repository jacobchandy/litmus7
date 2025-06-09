CREATE TABLE students(
student_id INTEGER PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
email VARCHAR(50) NOT NULL UNIQUE,
dob DATE
);
CREATE TABLE advisors(
advisor_id INTEGER PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
email VARCHAR(50) NOT NULL UNIQUE,
specialization VARCHAR(50) NOT NULL
);
CREATE TABLE courses(
course_id INT PRIMARY KEY,
title VARCHAR(50) NOT NULL,
description VARCHAR(255),
instructor VARCHAR(50) NOT NULL,
);
ALTER TABLE students
ADD advisor_id INTEGER;
ALTER TABLE students
ADD FOREIGN KEY(advisor_id) REFERENCES advisors(advisor_id);
CREATE TABLE student_course_map(
student_id INTEGER,
course_id INTEGER,
PRIMARY KEY(student_id, course_id),
FOREIGN KEY(student_id) REFERENCES students(student_id) ON DELETE CASCADE,
FOREIGN KEY(course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
