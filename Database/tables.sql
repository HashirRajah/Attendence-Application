CREATE DATABASE attendance_application_db;
USE attendance_application_db;

CREATE TABLE department
(
    deptId INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE modules
(
    module_code VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE programs
(
    progId INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    progType VARCHAR(255) UNIQUE,
    deptId INT FOREIGN KEY REFERENCES department,
    degreeType VARCHAR(255) CHECK(degreeType IN ('BSc', 'MSc', 'PhD'))
);

CREATE TABLE students
(
    studId INT IDENTITY(1,1) PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    gender CHAR(1) CHECK(gender IN ('M', 'F')),
    address VARCHAR(255),
    email VARCHAR(255) CHECK(email LIKE '%___@___%'),
    contact INT,
    progId INT FOREIGN KEY REFERENCES programs
);

CREATE TABLE lecturer
(
    l_username VARCHAR(255) PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    gender CHAR(1) CHECK(gender IN ('M', 'F')),
    address VARCHAR(255),
    email VARCHAR(255) CHECK(email LIKE '%___@___%'),
    contact INT,
    type VARCHAR(255) CHECK(type IN ('Part-time', 'Full-time'))
);

CREATE TABLE admin
(
    a_username VARCHAR(255) PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    gender CHAR(1) CHECK(gender IN ('M', 'F')),
    address VARCHAR(255),
    email VARCHAR(255) CHECK(email LIKE '%___@___%'),
    contact INT,
);

CREATE TABLE class
(
    classId INT IDENTITY(1,1) PRIMARY KEY,
    mode VARCHAR(12) CHECK(mode IN ('face to face', 'blended', 'online')),
    type VARCHAR(255),
    duration TIME,
    starttime TIME,
    grName VARCHAR(255),
    grLevel TINYINT,
    progId INT FOREIGN KEY REFERENCES programs
);

CREATE TABLE room
(
    module_code VARCHAR(255) FOREIGN KEY REFERENCES modules,
    l_username VARCHAR(255) FOREIGN KEY REFERENCES lecturer,
    classId INT FOREIGN KEY REFERENCES class
        PRIMARY KEY (module_code,l_username, classId)
);

CREATE TABLE groups
(
    grName VARCHAR(255),
    grLevel TINYINT,
    progId INT FOREIGN KEY REFERENCES programs
        PRIMARY KEY (grName,grLevel)
);

CREATE TABLE attendance
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    date DATE,
    classId INT FOREIGN KEY REFERENCES class,
    week TINYINT,
    semester TINYINT,
    status VARCHAR(9) CHECK (status IN ('postponed', 'cancelled', 'completed'))
);

-- CREATE TABLE student_attendance
-- (
--     student_id INT FOREIGN KEY REFERENCES students,
--     presence VARCHAR(12) CHECK(presence IN('present', 'absent')),
-- );

--Changes
-- DROP TABLE modules
-- DROP TABLE room

-- ALTER TABLE room
-- ADD FOREIGN KEY (l_username) REFERENCES lecturer (l_username);

-- ALTER TABLE room
-- ADD PRIMARY KEY (module_code,l_username);

ALTER TABLE students
ADD date_of_birth DATE;

ALTER TABLE lecturer
ADD date_of_birth DATE;

ALTER TABLE admin
ADD date_of_birth DATE;



CREATE TABLE setting
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    theme VARCHAR(255)
);

INSERT INTO setting
    (theme)
VALUES('Default');

CREATE TABLE enroll
(
    date DATE,
    studId INT FOREIGN KEY REFERENCES students,
    module_code VARCHAR(255) FOREIGN KEY REFERENCES modules
        PRIMARY KEY (date, studId, module_code)
);

--inserts for users

--student

INSERT INTO students
    (fname, lname, gender, address, email, contact, progId, date_of_birth)
VALUES
    ( 'Khizar', 'Panchoo', 'M', 'Mesnil', 'khizarp06@gmial.com', 59844124, NULL, '10-10-1999'),
    ( 'Mayur', 'Mohabeer', 'M', 'Dubreui', 'mayur@gmial.com', 53245354, NULL, '10-10-1990'),
    ( 'Hashir', 'Rajah', 'M', 'Beau Bassin', 'hashir@gmial.com', 53424562, NULL, '10-10-1990');

--Lecturer

INSERT INTO lecturer
    (l_username, fname, lname, gender, address, email, contact, [type], date_of_birth)
VALUES
    ( 'Gsathan', 'Gavin' , 'Sathan' , 'M' , 'Quatre Bornes' , 'sathan@gmail.com', 59867432 , 'Full-time', '10-10-1990'),
    ( 'SCheerkoot', 'Sudha' , 'Cheerkoot' , 'F' , 'Quatre Bornes' , 'cheerkoot@gmail.com', 59367432 , 'Full-time', '10-10-1990' ),
    ( 'AChutoo', 'Anwar' , 'Chutoo' , 'M' , 'Quatre Bornes' , 'chutoo@gmail.com', 59347432 , 'Full-time', '10-10-1990' );


--Admin

INSERT INTO admin
    (a_username, fname, lname, gender, address, email, contact, date_of_birth)
VALUES
    ( 'Admin1', 'John' , 'Smith' , 'M' , 'Port-Louis' , 'admin1@gmail.com', 59834867, '10-10-1990'),
    ( 'Admin2', 'Harry' , 'Style' , 'M' , 'Port-Louis' , 'admin2@gmail.com', 54334867, '10-10-1990'),
    ( 'Admin3', 'John' , 'Smith' , 'M' , 'Port-Louis' , 'admin3@gmail.com', 59835367, '10-10-1990' );


CREATE TABLE users
(
    username VARCHAR(255) PRIMARY KEY,
    passwordHash VARCHAR(255) NOT NULL,
    userType VARCHAR(10) CHECK(userType IN('admin', 'lecturer', 'student')) NOT NULL
);

--users--
INSERT INTO users
VALUES
    ( 'Admin1', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918' , 'admin'),
    ( 'Admin2', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918' , 'admin'),
    ( 'Admin3', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918' , 'admin'),
    ( 'AChutoo', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8' , 'lecturer'),
    ( 'SCheerkoot', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8' , 'lecturer'),
    ( 'Gsathan', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8' , 'lecturer'),
    ( '1', 'be64ae89ddd24e225434de95d501711339baeee18f009ba9b4369af27d30d60' , 'student'),
    ( '2', 'be64ae89ddd24e225434de95d501711339baeee18f009ba9b4369af27d30d60' , 'student'),
    ( '3', 'be64ae89ddd24e225434de95d501711339baeee18f009ba9b4369af27d30d60' , 'student');


-- ALTER TABLE programs 
-- DROP CONSTRAINT ;


INSERT INTO department
    ( name)
VALUES
    ('Faculty of Information, Communication and Digital Technologies'),
    ('Faculty of Engineering');

INSERT INTO programs
    (name , progType, deptId, degreeType)
VALUES
    ('Computer Science', 'Full Time', 1, 'BSc'),
    ('Civil Engineering', NULL, 2, 'MSc');

SELECT * FROM programs;