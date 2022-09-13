CREATE TABLE hr_to_role(
    hr_id BIGINT NOT NULL ,
    role varchar(64) NOT NULL ,
    PRIMARY KEY (hr_id, role),
    FOREIGN KEY (hr_id) REFERENCES hr(id),
    FOREIGN KEY (role) REFERENCES role(role)
);