CREATE TABLE hr(
    id bigserial PRIMARY KEY,
    first_name varchar(256) NOT NULL,
    lastName varchar(256) NOT NULL,
    password varchar (256) NOT NULL,
    role enum_role_type DEFAULT 'USER' NOT NULL,
    created timestamp NOT NULL
);