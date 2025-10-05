CREATE TABLE users (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),  -- UUID (PK)
    user_id VARCHAR(50) UNIQUE NOT NULL,                      -- 사용자가 입력한 ID
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);