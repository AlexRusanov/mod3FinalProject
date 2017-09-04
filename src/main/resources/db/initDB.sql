DROP TABLE IF EXISTS voting;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS bills;
DROP TABLE IF EXISTS sessions;
DROP TABLE IF EXISTS deputies;

CREATE TABLE deputies(
  id       SERIAL PRIMARY KEY,
  name     TEXT NOT NULL,
  surname  TEXT NOT NULL,
  gender   INTEGER NOT NULL,
  birthday TIMESTAMP WITH TIME ZONE NOT NULL,
  fraction TEXT NOT NULL
);

CREATE TABLE sessions(
  id     SERIAL PRIMARY KEY,
  agenda TEXT NOT NULL,
  date   TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE bills(
  id              SERIAL PRIMARY KEY,
  title           TEXT NOT NULL,
  author          TEXT NOT NULL,
  deputy_id       INTEGER,
  submission_date TIMESTAMP WITH TIME ZONE NOT NULL,
  text            TEXT NOT NULL,
  session_id      INTEGER,
  FOREIGN KEY (deputy_id) REFERENCES deputies (id) ON DELETE CASCADE,
  FOREIGN KEY (session_id) REFERENCES sessions (id) ON DELETE CASCADE
);

CREATE TABLE users (
  id          SERIAL PRIMARY KEY,
  email       TEXT NOT NULL UNIQUE,
  password    TEXT NOT NULL,
  deputy_id   INTEGER,
  role        INTEGER NOT NULL,
  FOREIGN KEY (deputy_id) REFERENCES deputies (id) ON DELETE CASCADE
);

CREATE TABLE voting(
  id SERIAL PRIMARY KEY,
  bill_id INTEGER NOT NULL,
  deputy_id INTEGER NOT NULL,
  vote INTEGER NOT NULL,
  FOREIGN KEY (bill_id) REFERENCES bills (id) ON DELETE CASCADE,
  FOREIGN KEY (deputy_id) REFERENCES deputies (id) ON DELETE CASCADE
);

