CREATE TABLE events (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,

    sport_id BIGINT NOT NULL,
    created_by UUID NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_event_sport
        FOREIGN KEY (sport_id)
        REFERENCES sports(id),

    CONSTRAINT fk_event_user
        FOREIGN KEY (created_by)
        REFERENCES users(id)
);