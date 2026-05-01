ALTER TABLE apt_core.t_user_type_master
ADD CONSTRAINT chk_type_code
CHECK (type_code IN ('OWNER', 'TENANT', 'ADMIN', 'GUARD','STAFF'));