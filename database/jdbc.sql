
CREATE TABLE Book (
    isbn INT PRIMARY KEY,
    title VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10, 2)
);

CREATE TABLE Book_author (
    isbn INT,
    author_name VARCHAR(100),
    FOREIGN KEY (isbn) REFERENCES Book(isbn)
);

SELECT * FROM Book WHERE price BETWEEN 300 AND 500;
SELECT MAX(price) FROM Book;

SELECT B.isbn, COUNT(A.author_name) AS author_count 
FROM Book B JOIN Book_author A ON B.isbn = A.isbn
GROUP BY B.isbn;

UPDATE Book SET price = price * 1.10;
DELETE FROM Book WHERE category = 'IT';

CREATE VIEW book_price AS 
SELECT isbn, price FROM Book;

UPDATE Book SET price = price * 1.10 WHERE category = 'IT';
DELETE FROM Book WHERE category = 'IT';