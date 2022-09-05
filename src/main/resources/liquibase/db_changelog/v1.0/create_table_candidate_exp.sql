CREATE TABLE candidate_exp(
    id BIGSERIAL PRIMARY KEY,
    candidate_id bigint NOT NULL,
    position varchar(256) NOT NULL,
    comment varchar(256),
    date_start DATE,
    date_end DATE,
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);


