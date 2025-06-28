DECLARE
    v_student_name   VARCHAR2(50) := 'Sivagunanithi';
    v_marks          NUMBER := 87;
    v_grade          CHAR(1);
BEGIN
    DBMS_OUTPUT.PUT_LINE('Student Name: ' || v_student_name);
    DBMS_OUTPUT.PUT_LINE('Marks Scored: ' || v_marks);

    -- Using IF-ELSIF-ELSE control structure
    IF v_marks >= 90 THEN
        v_grade := 'A';
    ELSIF v_marks >= 80 THEN
        v_grade := 'B';
    ELSIF v_marks >= 70 THEN
        v_grade := 'C';
    ELSIF v_marks >= 60 THEN
        v_grade := 'D';
    ELSE
        v_grade := 'F';
    END IF;

    DBMS_OUTPUT.PUT_LINE('Grade Assigned: ' || v_grade);

    -- Using CASE control structure (best practice for readability)
    CASE 
        WHEN v_grade = 'A' THEN
            DBMS_OUTPUT.PUT_LINE('Excellent Performance');
        WHEN v_grade = 'B' THEN
            DBMS_OUTPUT.PUT_LINE('Very Good');
        WHEN v_grade = 'C' THEN
            DBMS_OUTPUT.PUT_LINE('Good');
        WHEN v_grade = 'D' THEN
            DBMS_OUTPUT.PUT_LINE('Needs Improvement');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Fail');
    END CASE;
END;
/
