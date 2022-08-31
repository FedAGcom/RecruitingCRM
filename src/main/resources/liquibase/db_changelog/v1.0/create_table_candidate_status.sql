CREATE TABLE candidate_status(
    candidate_id int NOT NULL ,
    status enum_status_type DEFAULT 'NEW' NOT NULL,
    FOREIGN KEY (candidate_id) REFERENCES candidate(id)
);