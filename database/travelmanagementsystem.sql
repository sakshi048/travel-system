-- Step 1: Create the Employee table
CREATE TABLE IF NOT EXISTS Employee (
    empname VARCHAR(50) PRIMARY KEY,
    street VARCHAR(100),
    city VARCHAR(50),
    date_of_joining DATE
);  

-- Step 2: Create the Manages table
CREATE TABLE IF NOT EXISTS Manages (
    empname VARCHAR(50),
    manager_name VARCHAR(50),
    FOREIGN KEY (empname) REFERENCES Employee(empname),
    FOREIGN KEY (manager_name) REFERENCES Employee(empname)
);  

-- Step 3: Create the Works table
CREATE TABLE IF NOT EXISTS Works (
    empname VARCHAR(50),
    company_name VARCHAR(50),
    salary DECIMAL(10, 2),
    FOREIGN KEY (empname) REFERENCES Employee(empname)
);  

-- Step 4: Create the Company table
CREATE TABLE IF NOT EXISTS Company (
    company_name VARCHAR(50) PRIMARY KEY,
    city VARCHAR(50)
);  

-- Step 5: Insert records into the Employee table
INSERT INTO Employee (empname, street, city, date_of_joining) VALUES 
('John', '123 St', 'OldCity', '2023-01-15'),
('Alice', '456 St', 'OldCity', '2023-01-10'),
('Bob', '789 St', 'NewCity', '2023-01-12'); 

-- Step 6: Insert records into the Works table
INSERT INTO Works (empname, company_name, salary) VALUES 
('John', 'ABCCorporation', 50000),
('Alice', 'ABCCorporation', 55000),
('Bob', 'XYZCorp', 60000); 

-- Step 7: Insert records into the Company table
INSERT INTO Company (company_name, city) VALUES 
('ABCCorporation', 'OldCity'),
('XYZCorp', 'NewCity'); 

-- Step 8: Insert records into the Manages table
INSERT INTO Manages (empname, manager_name) VALUES 
('John', 'Alice'),
('Alice', 'Bob'); 

-- Step 9: Show all tables in the database
SHOW TABLES;  

-- Step 10: Select query for employees and their associated companies
SELECT E.empname, E.city, W.company_name, W.salary 
FROM Employee E 
JOIN Works W ON E.empname = W.empname;

-- Disable SQL Safe Mode to allow updates without a key column
SET SQL_SAFE_UPDATES = 0;

-- Step 11: Update the city of employee John to 'Mumbai'
UPDATE Employee
SET city = 'Mumbai'
WHERE empname = 'John';

-- Step 12: Increase the salary of employees working at ABCCorporation by 10%
UPDATE Works
SET salary = salary * 1.10
WHERE company_name = 'ABCCorporation';

-- Step 13: Select employees who share the same city with their managers
SELECT E.empname
FROM Employee E
JOIN Manages M ON E.empname = M.empname
JOIN Employee Mgr ON Mgr.empname = M.manager_name
WHERE E.city = Mgr.city;

-- Step 14: Select employees with a salary higher than the average salary of their company
SELECT W.empname, W.company_name, W.salary
FROM Works W
WHERE W.salary > (
    SELECT AVG(W2.salary)
    FROM Works W2
    WHERE W2.company_name = W.company_name
);

-- Re-enable SQL Safe Mode
SET SQL_SAFE_UPDATES = 1;
