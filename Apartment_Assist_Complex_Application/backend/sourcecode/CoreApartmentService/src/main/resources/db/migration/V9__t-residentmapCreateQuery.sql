ALTER TABLE apt_core.t_resident_map
    ADD COLUMN created_at TIMESTAMP NOT NULL,
    ADD COLUMN created_by VARCHAR(50) NOT NULL,
    ADD COLUMN updated_at TIMESTAMP,
    ADD COLUMN updated_by VARCHAR(50);
