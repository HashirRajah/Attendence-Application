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
    deptId INT REFERENCES department,
    degreeType VARCHAR(255) CHECK(degreeType IN ('BSc', 'MSc', 'PHd'))
);