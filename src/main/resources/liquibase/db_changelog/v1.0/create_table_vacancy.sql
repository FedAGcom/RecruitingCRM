CREATE TABLE vacancy (
    id BIGSERIAL PRIMARY KEY,
    title varchar(256) NOT NULL,
    position varchar(256) NOT NULL,
    salary numeric NOT NULL,
    creation_date timestamp NOT NULL,
    comment varchar(256) NOT NULL,
    description varchar(256),
    status enum_vacancy_state DEFAULT 'PREPARED'
);