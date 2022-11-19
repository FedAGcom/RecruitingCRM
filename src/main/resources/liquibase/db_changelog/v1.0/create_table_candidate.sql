CREATE TABLE candidate (
    id BIGSERIAL PRIMARY KEY,
    first_name varchar(256) NOT NULL,
    lastname varchar(256) NOT NULL,
    email varchar(256) NOT NULL,
    position varchar(256) NOT NULL,
    salary numeric NOT NULL,
    creation_date timestamp NOT NULL,
    hr_id bigint NOT NULL,
    status enum_candidate_state DEFAULT 'NEW',
    vacancy_id bigint NOT NULL ,
    FOREIGN KEY (hr_id) REFERENCES hr(id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancy(id)
);