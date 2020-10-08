DROP TABLE IF EXISTS dealers;

CREATE TABLE dealers (
  id IDENTITY PRIMARY KEY,
  identifier UUID NOT NULL DEFAULT random_uuid(),
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX idx_identifier ON dealers(identifier);