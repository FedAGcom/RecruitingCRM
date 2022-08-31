CREATE TABLE hr_to_candidate(
    id bigserial PRIMARY KEY NOT NULL,
    hr_id BIGINT NOT NULL,
    candidate_id BIGINT NOT NULL,
    FOREIGN KEY (hr_id) REFERENCES hr(id),
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);