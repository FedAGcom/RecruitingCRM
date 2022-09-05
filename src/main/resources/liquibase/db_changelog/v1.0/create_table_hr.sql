CREATE TABLE hr(
    id bigserial PRIMARY KEY,
    first_name varchar(256) NOT NULL,
    lastname varchar(256) NOT NULL,
    login varchar(256) NOT NULL,
    password varchar (256) NOT NULL,
    role enum_role_type DEFAULT 'USER',
    creation_date timestamp NOT NULL
);