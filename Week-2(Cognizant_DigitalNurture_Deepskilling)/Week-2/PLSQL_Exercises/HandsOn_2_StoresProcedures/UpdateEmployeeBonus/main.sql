select * from Employees;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonus_percent / 100))
    WHERE Department = dept_name;

    DBMS_OUTPUT.PUT_LINE('Bonuses applied for department: ' || dept_name);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in UpdateEmployeeBonus: ' || SQLERRM);
END;
/

COMMIT;

BEGIN
    UpdateEmployeeBonus('HR', 10);
END;
/

SELECT * FROM Employees;