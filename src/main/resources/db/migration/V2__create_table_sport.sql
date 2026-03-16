CREATE TABLE sports (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,

    created_by UUID NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_sport_user
        FOREIGN KEY (created_by)
        REFERENCES users(id)
);