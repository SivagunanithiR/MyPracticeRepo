-- Step 1: Create a sample table (if not already exists)
CREATE TABLE employees (
    emp_id       NUMBER PRIMARY KEY,
    emp_name     VARCHAR2(100),
    salary       NUMBER,
    department   VARCHAR2(50),
    bonus        NUMBER
);

-- Step 2: Insert sample data (for testing)
INSERT INTO employees VALUES (101, 'Rahul', 45000, 'HR', NULL);
INSERT INTO employees VALUES (102, 'Priya', 60000, 'IT', NULL);
INSERT INTO employees VALUES (103, 'Amit', 30000, 'Sales', NULL);

-- Step 3: Create the stored procedure
CREATE OR REPLACE PROCEDURE calculate_bonus(p_emp_id IN NUMBER) AS
    v_salary     NUMBER;
    v_dept       VARCHAR2(50);
    v_bonus      NUMBER;
BEGIN
    -- Fetch salary and department for the given employee
    SELECT salary, department INTO v_salary, v_dept
    FROM employees
    WHERE emp_id = p_emp_id;

    -- Apply bonus logic
    IF v_dept = 'HR' THEN
        v_bonus := v_salary * 0.10;
    ELSIF v_dept = 'IT' THEN
        v_bonus := v_salary * 0.15;
    ELSIF v_dept = 'Sales' THEN
        v_bonus := v_salary * 0.08;
    ELSE
        v_bonus := v_salary * 0.05;
    END IF;

    -- Update bonus in the table
    UPDATE employees
    SET bonus = v_bonus
    WHERE emp_id = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('Bonus calculated and updated: ' || v_bonus);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Step 4: Execute the procedure
BEGIN
    calculate_bonus(102);
END;
/

-- Step 5: Verify the result
SELECT * FROM employees WHERE emp_id = 102;
