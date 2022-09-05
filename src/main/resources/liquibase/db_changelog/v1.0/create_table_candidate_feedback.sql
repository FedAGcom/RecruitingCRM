CREATE TABLE candidate_feedback(
    id BIGSERIAL PRIMARY KEY,
    candidate_id BIGINT NOT NULL,
    hr_id BIGINT NOT NULL,
    rating INTEGER NOT NULL,
    comment VARCHAR(2000),
    FOREIGN KEY (candidate_id) REFERENCES candidate(id),
    FOREIGN KEY (hr_id) REFERENCES hr(id)
);