
select * from LOANS;

-- 1. Apply 1% discount for customers above 60
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.DOB, c.Name 
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        IF MONTHS_BETWEEN(SYSDATE, rec.DOB)/12 > 60 THEN
            UPDATE Loans 
            SET InterestRate = InterestRate - 1 
            WHERE LoanID = rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Discount applied to LoanID: ' || rec.LoanID || 
                                 ' (Customer: ' || rec.Name || ')');
        END IF;
    END LOOP;
END;
/


select * from LOANS;