-- Create Schema
CREATE SCHEMA IF NOT EXISTS apt_core;

-- 1. Apartment Type Master
CREATE TABLE IF NOT EXISTS apt_core.t_apartment_type_master (
    type_id BIGSERIAL PRIMARY KEY,
    type_code VARCHAR(20) NOT NULL UNIQUE,
    type_desc VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 2. Apartment
CREATE TABLE IF NOT EXISTS apt_core.t_apartment (
    apartment_id BIGSERIAL PRIMARY KEY,
    apartment_number VARCHAR(10) NOT NULL UNIQUE,
    type_code VARCHAR(20) NOT NULL,
    availability BOOLEAN NOT NULL DEFAULT TRUE,
    carpet_area DECIMAL(10, 2) NOT NULL,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 3. Amenities Master
CREATE TABLE IF NOT EXISTS apt_core.t_amenities_master (
    amenity_id BIGSERIAL PRIMARY KEY,
    amenity_code VARCHAR(20) NOT NULL UNIQUE,
    amenity_desc VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 4. Amenities Booking
CREATE TABLE IF NOT EXISTS apt_core.t_amenities_booking (
    booking_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    amenity_code VARCHAR(20) NOT NULL,
    booking_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_id VARCHAR(50),
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 5. Complaint Master
CREATE TABLE IF NOT EXISTS apt_core.t_complaint_master (
    complaint_id BIGSERIAL PRIMARY KEY,
    complaint_code VARCHAR(20) NOT NULL UNIQUE,
    complaint_desc VARCHAR(150) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 6. User Info
CREATE TABLE IF NOT EXISTS apt_core.t_user_info (
    user_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    aadhar VARCHAR(12) NOT NULL UNIQUE,
    mobile VARCHAR(10) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    unique_user_number VARCHAR(20) NOT NULL UNIQUE,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 7. Resident Map
CREATE TABLE IF NOT EXISTS apt_core.t_resident_map (
    resident_id BIGSERIAL PRIMARY KEY,
    unique_user_number VARCHAR(20) NOT NULL,
    apartment_number VARCHAR(20) NOT NULL,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 8. Complaint
CREATE TABLE IF NOT EXISTS apt_core.t_complaint (
    complaint_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    complaint_code VARCHAR(20) NOT NULL,
    priority VARCHAR(10) NOT NULL, -- LOW, MEDIUM, HIGH
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 9. User Type Master
CREATE TABLE IF NOT EXISTS apt_core.t_user_type_master (
    type_id BIGSERIAL PRIMARY KEY,
    type_code VARCHAR(20) NOT NULL UNIQUE,
    type_desc VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

ALTER TABLE apt_core.t_user_type_master
ADD CONSTRAINT chk_type_code
CHECK (type_code IN ('OWNER', 'TENANT', 'ADMIN', 'GUARD','STAFF'));

-- 10. User Mapping
CREATE TABLE IF NOT EXISTS apt_core.t_user_mapping (
    user_map_id BIGSERIAL PRIMARY KEY,
    unique_user_number VARCHAR(20) NOT NULL,
    type_code VARCHAR(20) NOT NULL,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 11. Workflow Status Master
CREATE TABLE IF NOT EXISTS apt_core.t_workflow_status_master (
    status_id BIGSERIAL PRIMARY KEY,
    status_code VARCHAR(20) NOT NULL UNIQUE,
    status_desc VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- 12. Workflow Diary
CREATE TABLE IF NOT EXISTS apt_core.t_workflow_diary (
    workflow_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    status_code VARCHAR(20) NOT NULL,
    complaint_id BIGINT NOT NULL,
    -- Auditable fields
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(50)
);

-- Seed Data
INSERT INTO apt_core.t_user_type_master (type_code, type_desc, is_active, created_at, created_by)
VALUES ('OWNER', 'Apartment Owner', true, NOW(), 'SYSTEM'),
       ('TENANT', 'Tenant / Renter', true, NOW(), 'SYSTEM'),
       ('ADMIN', 'Complex Administrator', true, NOW(), 'SYSTEM'),
       ('GUARD', 'Security Guard', true, NOW(), 'SYSTEM'),
       ('STAFF', 'Maintenance Staff', true, NOW(), 'SYSTEM');

INSERT INTO apt_core.t_apartment_type_master (type_code, type_desc, is_active, created_at, created_by)
VALUES ('1BHK', '1 Bedroom Hall Kitchen', true, NOW(), 'SYSTEM'),
       ('2BHK', '2 Bedroom Hall Kitchen', true, NOW(), 'SYSTEM'),
       ('3BHK', '3 Bedroom Hall Kitchen', true, NOW(), 'SYSTEM'),
       ('STUDIO', 'Studio Apartment', true, NOW(), 'SYSTEM'),
       ('DUPLEX', 'Duplex Apartment', true, NOW(), 'SYSTEM');

INSERT INTO apt_core.t_amenities_master (amenity_code, amenity_desc, is_active, created_at, created_by)
VALUES ('GYM', 'Gymnasium / Fitness Center', true, NOW(), 'SYSTEM'),
       ('POOL', 'Swimming Pool', true, NOW(), 'SYSTEM'),
       ('CLUBHOUSE', 'Club House', true, NOW(), 'SYSTEM'),
       ('TERRACE', 'Terrace / Rooftop Area', true, NOW(), 'SYSTEM'),
       ('PARKING', 'Visitor Parking Slot', true, NOW(), 'SYSTEM');

INSERT INTO apt_core.t_complaint_master (complaint_code, complaint_desc, is_active, created_at, created_by)
VALUES ('PLUMBING', 'Plumbing / Water Leakage Issue', true, NOW(), 'SYSTEM'),
       ('ELECTRICAL', 'Electrical Fault or Power Issue', true, NOW(), 'SYSTEM'),
       ('LIFT', 'Elevator / Lift Malfunction', true, NOW(), 'SYSTEM'),
       ('NOISE', 'Noise Complaint from Neighbour', true, NOW(), 'SYSTEM'),
       ('CLEANLINESS', 'Cleanliness / Sanitation Complaint', true, NOW(), 'SYSTEM');

INSERT INTO apt_core.t_workflow_status_master (status_code, status_desc, is_active, created_at, created_by)
VALUES ('OPEN', 'Complaint Raised / Open', true, NOW(), 'SYSTEM'),
       ('ASSIGNED', 'Assigned to Staff', true, NOW(), 'SYSTEM'),
       ('IN_PROGRESS', 'Work In Progress', true, NOW(), 'SYSTEM'),
       ('RESOLVED', 'Issue Resolved', true, NOW(), 'SYSTEM'),
       ('CLOSED', 'Complaint Closed', true, NOW(), 'SYSTEM');

-- Sequence and Function
CREATE SEQUENCE IF NOT EXISTS apt_core.user_seq
START 1
INCREMENT 1;


CREATE OR REPLACE FUNCTION apt_core.get_user_sequence()
RETURNS VARCHAR AS $func$
DECLARE
    seq_num INT;
BEGIN
    seq_num := nextval('apt_core.user_seq');
    RETURN LPAD(seq_num::TEXT, 5, '0');
END;
$func$ LANGUAGE plpgsql;