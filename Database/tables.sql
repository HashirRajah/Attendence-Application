CREATE DATABASE attendence_application_db;
USE attendence_application_db;

CREATE TABLE department
(
    deptId INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE modules
(
    moduleId INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE programs
(
    progId INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    progType VARCHAR(255) UNIQUE,
    deptId INT FOREIGN KEY REFERENCES department,
    degreeType VARCHAR(255) CHECK(degreeType IN ('BSc', 'MSc', 'PHd'))
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
    progId INT FOREIGN KEY REFERENCES programs,
    password VARCHAR(255)
);

CREATE TABLE lecturer
(
    l_username INT IDENTITY(1,1) PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    gender CHAR(1) CHECK(gender IN ('M', 'F')),
    address VARCHAR(255),
    email VARCHAR(255) CHECK(email LIKE '%___@___%'),
    contact INT,
    type VARCHAR(255) CHECK(type IN ('Part-time', 'Full-time')),
    password VARCHAR(255)
);

CREATE TABLE admin
(
    a_username INT IDENTITY(1,1) PRIMARY KEY,
    fname VARCHAR(255),
    lname VARCHAR(255),
    gender CHAR(1) CHECK(gender IN ('M', 'F')),
    address VARCHAR(255),
    email VARCHAR(255) CHECK(email LIKE '%___@___%'),
    contact INT,
    password VARCHAR(255)
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
    moduleId INT FOREIGN KEY REFERENCES modules,
    l_username INT FOREIGN KEY REFERENCES lecturer,
    classId INT FOREIGN KEY REFERENCES class
)

CREATE TABLE groups
(
    grName VARCHAR(255),
    grLevel TINYINT,
    progId INT FOREIGN KEY REFERENCES programs
);

CREATE TABLE attendance
(
    studId INT FOREIGN KEY REFERENCES students,
    date DATE,
    classId INT FOREIGN KEY REFERENCES class,
    presence VARCHAR(12) CHECK (presence IN ('present', 'absent')),
    week TINYINT,
    semester TINYINT,
    status VARCHAR(9) CHECK (status IN ('postponed', 'cancelled', 'completed'))
);
