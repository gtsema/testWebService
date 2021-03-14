DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id              SERIAL PRIMARY KEY   ,
    username        VARCHAR(16) NOT NULL ,
    email           VARCHAR(64) NOT NULL ,
    phone_number    VARCHAR(32) NOT NULL ,
    status          VARCHAR(8)  NOT NULL ,
    last_activity   timestamp
);

DROP TYPE status;

CREATE TYPE status AS ENUM ('ONLINE', 'AWAY', 'OFFLINE');
