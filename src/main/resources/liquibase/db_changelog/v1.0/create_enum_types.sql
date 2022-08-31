CREATE TYPE enum_role_type AS ENUM('USER', 'ADMIN');
CREATE TYPE enum_status_type AS ENUM('NEW', 'ACCEPTED_IN_WORK', 'CV_APPROVED', 'INTERVIEW_ASSIGNED',
    'INTERVIEW_PASSED', 'IN_APPROVAL', 'OFFER', 'PROBATION',
    'IN_STAFF', 'DENIAL_BY_HR', 'DENIAL_BY_CANDIDATE');
CREATE CAST (character varying as enum_role_type) WITH INOUT AS IMPLICIT;
CREATE CAST (character varying as enum_status_type) WITH INOUT AS IMPLICIT;