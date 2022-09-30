CREATE TABLE hr(
    id bigserial PRIMARY KEY,
    first_name varchar(256) NOT NULL,
    lastname varchar(256) NOT NULL,
    login varchar(256) NOT NULL UNIQUE ,
    password varchar (256) NOT NULL,
    role varchar(64) NOT NULL,
    creation_date timestamp,
    active boolean,
    FOREIGN KEY (role) REFERENCES role(role)
);