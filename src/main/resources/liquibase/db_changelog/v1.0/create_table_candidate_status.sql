CREATE TABLE candidate_status(
    id bigserial PRIMARY KEY NOT NULL,
    candidate_id int NOT NULL ,
    status enum_status_type DEFAULT 'NEW' NOT NULL,
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);