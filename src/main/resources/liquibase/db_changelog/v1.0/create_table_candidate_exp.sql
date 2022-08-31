CREATE TABLE candidate_exp(
    exp_id BIGSERIAL PRIMARY KEY,
    candidate_id bigint NOT NULL,
    position varchar(256) NOT NULL,
    comment varchar(256),
    start_work DATE,
    end_work DATE,
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);


