CREATE TABLE vacancy (
    id BIGSERIAL PRIMARY KEY,
    title varchar(256) NOT NULL,
    position varchar(256) NOT NULL,
    salary numeric NOT NULL,
    creation_date timestamp NOT NULL,
    comment varchar(256),
    description varchar(256) NOT NULL,
    status varchar(64) DEFAULT 'PREPARED',
    active boolean,
    FOREIGN KEY (status) REFERENCES vacancy_status(status)
);