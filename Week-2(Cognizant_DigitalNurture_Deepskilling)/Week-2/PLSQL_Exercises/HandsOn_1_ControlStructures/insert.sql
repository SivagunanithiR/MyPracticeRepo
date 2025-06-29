BEGIN
    INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 1000, SYSDATE, 'N');
    INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1950-07-20','YYYY-MM-DD'), 15000, SYSDATE, 'N');
    INSERT INTO Customers VALUES (3, 'Ravi Kumar', TO_DATE('1960-01-10','YYYY-MM-DD'), 12000, SYSDATE, 'N');
    INSERT INTO Customers VALUES (4, 'Neha Sharma', TO_DATE('1975-11-25','YYYY-MM-DD'), 9500, SYSDATE, 'N');
    INSERT INTO Customers VALUES (5, 'Rahul Singh', TO_DATE('1945-08-18','YYYY-MM-DD'), 20000, SYSDATE, 'N');

    INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
    INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);
    INSERT INTO Accounts VALUES (3, 3, 'Savings', 12000, SYSDATE);
    INSERT INTO Accounts VALUES (4, 4, 'Checking', 9500, SYSDATE);
    INSERT INTO Accounts VALUES (5, 5, 'Savings', 20000, SYSDATE);

    INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
    INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');
    INSERT INTO Transactions VALUES (3, 3, SYSDATE, 500, 'Deposit');
    INSERT INTO Transactions VALUES (4, 4, SYSDATE, 800, 'Deposit');
    INSERT INTO Transactions VALUES (5, 5, SYSDATE, 1000, 'Withdrawal');

    INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));
    INSERT INTO Loans VALUES (2, 2, 10000, 6, SYSDATE, SYSDATE + 20);
    INSERT INTO Loans VALUES (3, 3, 15000, 7, SYSDATE, ADD_MONTHS(SYSDATE, 12));
    INSERT INTO Loans VALUES (4, 4, 8000, 4.5, SYSDATE, SYSDATE + 10);
    INSERT INTO Loans VALUES (5, 5, 25000, 6.5, SYSDATE, SYSDATE + 25);

    INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15','YYYY-MM-DD'));
    INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20','YYYY-MM-DD'));
    INSERT INTO Employees VALUES (3, 'Sneha Verma', 'Tester', 45000, 'QA', TO_DATE('2020-01-15','YYYY-MM-DD'));
    INSERT INTO Employees VALUES (4, 'Amit Patel', 'Support', 50000, 'Tech Support', TO_DATE('2018-09-01','YYYY-MM-DD'));
    INSERT INTO Employees VALUES (5, 'Kavita Reddy', 'Analyst', 55000, 'Finance', TO_DATE('2016-04-25','YYYY-MM-DD'));
END;
/

COMMIT;