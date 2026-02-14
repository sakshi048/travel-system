CREATE DATABASE BankAddCustomer;
SHOW DATABASES;

USE BankAddCustomer;

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    street VARCHAR(255),
    city VARCHAR(100)
);

SELECT * FROM cutomers


