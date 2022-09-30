CREATE TYPE enum_role_type AS ENUM('USER', 'ADMIN', 'USER_INACTIVE', 'ADMIN_INACTIVE');
-- CREATE TYPE enum_candidate_state AS ENUM('NEW', 'ACCEPT', 'CV_APPROVE', 'INTERVIEW_APPOINTED',
--     'INTERVIEW_PASSED', 'ON_APPROVAL', 'OFFER', 'PROBATION',
--     'STAFF', 'DENIAL_BY_HR', 'DENIAL_BY_CANDIDATE');
--CREATE TYPE enum_vacancy_state AS ENUM('PREPARED', 'OPEN', 'CLOSE', 'ARCHIVE');

CREATE CAST (character varying as enum_role_type) WITH INOUT AS IMPLICIT;
-- CREATE CAST (character varying as enum_candidate_state) WITH INOUT AS IMPLICIT;
--CREATE CAST (character varying as enum_vacancy_state) WITH INOUT AS IMPLICIT;