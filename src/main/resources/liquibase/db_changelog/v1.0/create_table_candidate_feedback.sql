CREATE TABLE candidate_feedback(
    feedback_id BIGSERIAL PRIMARY KEY,
    candidate_id BIGINT NOT NULL,
    hr_id BIGINT NOT NULL,
    comment VARCHAR(2000),
    rating SMALLINT NOT NULL,
    FOREIGN KEY (hr_id) REFERENCES hr(id),
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);