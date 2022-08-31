CREATE TABLE candidate (
    id bigserial PRIMARY KEY,
    first_name varchar(256) NOT NULL,
    lastName varchar(256) NOT NULL,
    dob date NOT NULL,
    telephone varchar(256) NOT NULL,
    email varchar(256) NOT NULL,
    citizenship varchar(256),
    residence varchar(256),
    position varchar(256) NOT NULL,
    salary numeric NOT NULL,
    created timestamp NOT NULL,
    cv varchar(256)NOT NULL
);