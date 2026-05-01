CREATE OR REPLACE FUNCTION apt_core.get_user_sequence()
RETURNS VARCHAR AS $func$
DECLARE
    seq_num INT;
BEGIN
    seq_num := nextval('apt_core.user_seq');
    RETURN LPAD(seq_num::TEXT, 5, '0');
END;
$func$ LANGUAGE plpgsql;