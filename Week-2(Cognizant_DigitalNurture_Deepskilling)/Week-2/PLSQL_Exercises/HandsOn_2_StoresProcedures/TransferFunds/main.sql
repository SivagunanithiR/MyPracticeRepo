select * from Accounts;
CREATE OR REPLACE PROCEDURE TransferFunds(
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) AS
    insufficient_funds EXCEPTION;
    from_balance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_account FOR UPDATE;

    -- Check if funds are sufficient
    IF from_balance < amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;

    DBMS_OUTPUT.PUT_LINE('Transferred ₹' || amount || 
                         ' from Account ' || from_account || 
                         ' to Account ' || to_account);
EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in Account ' || from_account);
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in TransferFunds: ' || SQLERRM);
END;
/


BEGIN
    TransferFunds(1, 2, 500);
END;
/

select * from Accounts;
