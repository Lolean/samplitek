DROP TABLE IF EXISTS samples
CREATE TABLE samples {
    id SERIAL PRIMARY KEY,
    'name' VARCHAR(50) NOT NULL,
    'genre' VARCHAR(20),
    'instrument' VARCHAR(50) NOT NULL,
    'creator' VARCHAR(20) NOT NULL,
    'bpm' INT(1)

    };


