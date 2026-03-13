CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    sport_id BIGINT NOT NULL,
    created_by UUID NOT NULL,

    CONSTRAINT fk_event_sport
        FOREIGN KEY (sport_id)
        REFERENCES sports(id),

    CONSTRAINT fk_event_creator
        FOREIGN KEY (created_by)
        REFERENCES users(id)
);