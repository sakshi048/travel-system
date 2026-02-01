-- Step 1: Create the Library database
CREATE DATABASE LibraryDB;

-- Step 2: Switch to the Library database
USE LibraryDB;

-- Step 3: Create the Book table
CREATE TABLE Book (
    isbn INT PRIMARY KEY,          -- Primary key ensures unique ISBN
    title VARCHAR(100),            -- Book title
    category VARCHAR(50),          -- Book category (e.g., IT, Fiction)
    price DECIMAL(10, 2)           -- Book price with two decimal precision
);

-- Step 4: Create the Book_author table
CREATE TABLE Book_author (
    isbn INT,                      -- Foreign key linking to the Book table
    author_name VARCHAR(100),      -- Author name
    FOREIGN KEY (isbn) REFERENCES Book(isbn)  -- Establishing referential integrity
);

-- Step 5: Create a view showing ISBN and price of all books
CREATE VIEW book_price AS 
SELECT isbn, price FROM Book;
