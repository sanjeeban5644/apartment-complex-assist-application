CREATE TABLE apt_core.t_resident_map (
    resident_id BIGSERIAL PRIMARY KEY,
    unique_user_number VARCHAR(255) NOT NULL,
    apartment_number VARCHAR(255) NOT NULL
);
