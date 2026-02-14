CREATE DATABASE userDB;
show databases;
use userDB;


CREATE TABLE  account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender ENUM('Male', 'Female'),
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    age INT,
    gender VARCHAR(50),
    username VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);
select * from account;


select * from login;



show tables;