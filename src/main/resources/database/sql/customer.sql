CREATE TABLE IF NOT EXISTS customers
(
    customer_id   VARCHAR(50) PRIMARY KEY,
    email         VARCHAR(255) UNIQUE NOT NULL,
    first_name    VARCHAR(100)        NOT NULL,
    last_name     VARCHAR(100)        NOT NULL,
    phone         VARCHAR(20),
    date_of_birth DATE,
    gender        VARCHAR(10) CHECK (gender IN ('male', 'female', 'other')),
    address       TEXT,
    city          VARCHAR(100),
    country       VARCHAR(100),
    postal_code   VARCHAR(20),
    is_active     BOOLEAN          DEFAULT TRUE,
    created_at    TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP        DEFAULT CURRENT_TIMESTAMP
);