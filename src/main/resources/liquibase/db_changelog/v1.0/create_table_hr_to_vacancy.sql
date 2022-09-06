create table hr_to_vacancy(
    hr_id BIGINT NOT NULL,
    vacancy_id BIGINT NOT NULL,
    PRIMARY KEY (hr_id, vacancy_id),
    FOREIGN KEY (hr_id) REFERENCES hr(id),
    FOREIGN KEY (vacancy_id) REFERENCES vacancy(id)
);