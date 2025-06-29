select * from Customers;

-- 2. Set VIP flag for customers with balance > 10000
BEGIN
    UPDATE Customers 
    SET IsVIP = 'Y' 
    WHERE Balance > 10000;

    DBMS_OUTPUT.PUT_LINE('VIP flag updated for eligible customers.');
END;
/
COMMIT;

select * from Customers;
