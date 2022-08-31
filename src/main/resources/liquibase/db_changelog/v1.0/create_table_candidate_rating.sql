CREATE TABLE candidate_rating(
    candidate_id BIGINT NOT NULL,
    rating NUMERIC DEFAULT '0',
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);