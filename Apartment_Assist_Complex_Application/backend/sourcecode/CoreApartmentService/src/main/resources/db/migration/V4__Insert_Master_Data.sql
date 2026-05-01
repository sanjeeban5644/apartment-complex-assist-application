-- t_user_type_master
INSERT INTO apt_core.t_user_type_master (type_code, type_desc, is_active, created_at, created_by)
VALUES ('OWNER',   'Apartment Owner',          true, NOW(), 'SYSTEM'),
       ('TENANT',  'Tenant / Renter',           true, NOW(), 'SYSTEM'),
       ('ADMIN',   'Complex Administrator',     true, NOW(), 'SYSTEM'),
       ('GUARD',   'Security Guard',            true, NOW(), 'SYSTEM'),
       ('STAFF',   'Maintenance Staff',         true, NOW(), 'SYSTEM');

-- t_apartment_type_master
INSERT INTO apt_core.t_apartment_type_master (type_code, type_desc, is_active, created_at, created_by)
VALUES ('1BHK',    '1 Bedroom Hall Kitchen',   true, NOW(), 'SYSTEM'),
       ('2BHK',    '2 Bedroom Hall Kitchen',   true, NOW(), 'SYSTEM'),
       ('3BHK',    '3 Bedroom Hall Kitchen',   true, NOW(), 'SYSTEM'),
       ('STUDIO',  'Studio Apartment',          true, NOW(), 'SYSTEM'),
       ('DUPLEX',  'Duplex Apartment',          true, NOW(), 'SYSTEM');

-- t_amenities_master
INSERT INTO apt_core.t_amenities_master (amenity_code, amenity_desc, is_active, created_at, created_by)
VALUES ('GYM',       'Gymnasium / Fitness Center',  true, NOW(), 'SYSTEM'),
       ('POOL',      'Swimming Pool',                true, NOW(), 'SYSTEM'),
       ('CLUBHOUSE', 'Club House',                   true, NOW(), 'SYSTEM'),
       ('TERRACE',   'Terrace / Rooftop Area',       true, NOW(), 'SYSTEM'),
       ('PARKING',   'Visitor Parking Slot',         true, NOW(), 'SYSTEM');

-- t_complaint_master
INSERT INTO apt_core.t_complaint_master (complaint_code, complaint_desc, is_active, created_at, created_by)
VALUES ('PLUMBING',   'Plumbing / Water Leakage Issue',      true, NOW(), 'SYSTEM'),
       ('ELECTRICAL', 'Electrical Fault or Power Issue',     true, NOW(), 'SYSTEM'),
       ('LIFT',       'Elevator / Lift Malfunction',         true, NOW(), 'SYSTEM'),
       ('NOISE',      'Noise Complaint from Neighbour',      true, NOW(), 'SYSTEM'),
       ('CLEANLINESS','Cleanliness / Sanitation Complaint',  true, NOW(), 'SYSTEM');

-- t_workflow_status_master
INSERT INTO apt_core.t_workflow_status_master (status_code, status_desc, is_active, created_at, created_by)
VALUES ('OPEN',        'Complaint Raised / Open',           true, NOW(), 'SYSTEM'),
       ('ASSIGNED',    'Assigned to Staff',                 true, NOW(), 'SYSTEM'),
       ('IN_PROGRESS', 'Work In Progress',                  true, NOW(), 'SYSTEM'),
       ('RESOLVED',    'Issue Resolved',                    true, NOW(), 'SYSTEM'),
       ('CLOSED',      'Complaint Closed',                  true, NOW(), 'SYSTEM');

