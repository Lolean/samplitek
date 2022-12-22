CREATE TABLE IF NOT EXISTS samples (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    genre VARCHAR(20),
    instrument VARCHAR(50) NOT NULL,
    creator VARCHAR(20) NOT NULL,
    bpm INT
    );

insert into samples(name,genre,instrument,creator,bpm)  values ('amen break','breakbeat','drum','amen brothers', 170);
insert into samples(name,genre,instrument,creator,bpm)  values ('test','test','test','test', 69);


