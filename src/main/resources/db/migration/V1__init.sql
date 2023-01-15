CREATE TABLE IF NOT EXISTS samples (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    genre VARCHAR(20),
    instrument VARCHAR(50) NOT NULL,
    creator VARCHAR(20) NOT NULL,
    bpm INT
    );




