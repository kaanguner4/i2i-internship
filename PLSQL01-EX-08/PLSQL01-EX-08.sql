SET SERVEROUTPUT ON;

DECLARE
    input_str VARCHAR2(30) := 'acbbcadefghkkhgfed'; -- veya 'abbcddfggfca'
    i         INTEGER;
    ch        CHAR(1);
BEGIN
    DBMS_OUTPUT.PUT_LINE('String: ' || input_str);
    FOR i IN 1 .. LENGTH(input_str) LOOP
        ch := SUBSTR(input_str, i, 1);
        DBMS_OUTPUT.PUT_LINE(ch);
    END LOOP;
END;
/
