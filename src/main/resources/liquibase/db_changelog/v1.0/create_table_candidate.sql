CREATE TABLE candidate (
    id BIGSERIAL PRIMARY KEY,
    first_name varchar(256) NOT NULL,
    lastname varchar(256) NOT NULL,
    phone_number varchar(256) NOT NULL,
    email varchar(256) NOT NULL,
    residence varchar(256),
    country varchar(256),
    city varchar(256),
    position varchar(256) NOT NULL,
    salary numeric NOT NULL,
    birthdate date NOT NULL,
    creation_date timestamp DEFAULT current_timestamp,
    hr_id bigint DEFAULT '1',
    status varchar(64) DEFAULT 'NEW',
    total_rating numeric DEFAULT '0',
    cv_link varchar(256) NOT NULL,
    vacancy_id bigint,
    delete boolean DEFAULT FALSE,
    FOREIGN KEY (hr_id) REFERENCES hr(id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancy(id)
);