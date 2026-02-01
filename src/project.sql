CREATE DATABASE project;

SHOW DATABASES;

USE project;

CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender ENUM('Male', 'Female'),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE login (
    email VARCHAR(255) UNIQUE,
    username VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    age INT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

SELECT * FROM users;
SELECT * FROM account;
SELECT * FROM login;

SHOW TABLES;

CREATE TABLE packages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    state VARCHAR(50),
    package_name VARCHAR(100),
    description TEXT,
    price DECIMAL(10,2)
);
INSERT INTO packages (state, package_name, description, price)
VALUES ('Goa', 'Beach Getaway', 'A 3-day stay at a beach resort', 15000.00),
       ('Maharashtra', 'Heritage Tour', 'Explore the ancient caves and temples', 20000.00),
       ('Rajasthan', 'Desert Safari', 'Experience the desert with a camel ride', 18000.00),
       ('Uttarakhand', 'Mountain Retreat', 'A peaceful retreat in the Himalayas', 25000.00);

SELECT * FROM  packages;
