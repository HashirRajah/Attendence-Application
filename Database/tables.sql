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