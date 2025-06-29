BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name 
        FROM Loans l 
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.LoanID || 
                             ' is due soon for customer ' || rec.Name);
    END LOOP;
END;
/