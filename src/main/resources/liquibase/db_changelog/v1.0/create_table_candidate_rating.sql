CREATE TABLE candidate_rating(
    id bigserial PRIMARY KEY NOT NULL,
    candidate_id BIGINT NOT NULL,
    rating NUMERIC DEFAULT '0',
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);