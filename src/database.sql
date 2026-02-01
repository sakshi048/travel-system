CREATE DATABASE database;

SHOW DATABASES;

USE database;

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
