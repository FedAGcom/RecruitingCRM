CREATE TABLE hr_to_role(
    hr_id bigint,
    role enum_role_type,
    PRIMARY KEY (hr_id, role),
    FOREIGN KEY (hr_id) REFERENCES hr(id)
);