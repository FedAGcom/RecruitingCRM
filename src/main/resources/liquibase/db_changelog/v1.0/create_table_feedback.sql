CREATE TABLE feedback(
    id BIGSERIAL PRIMARY KEY,
    candidate_id BIGINT NOT NULL,
    hr_id BIGINT NOT NULL,
    rating INTEGER NOT NULL,
    comment VARCHAR(2000),
    created timestamp NOT NULL,
    updated timestamp,
    deleted boolean,
    FOREIGN KEY (candidate_id) REFERENCES candidate(id),
    FOREIGN KEY (hr_id) REFERENCES hr(id)
);