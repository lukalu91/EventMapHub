CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  nome VARCHAR(255),
  cognome VARCHAR(255)
);

CREATE TABLE ludopoint (
    id BIGSERIAL PRIMARY KEY,
    userId BIGSERIAL,
    nome VARCHAR(255)
);

CREATE TABLE eventi (
    id BIGSERIAL PRIMARY KEY,
    ludoId BIGSERIAL,
    tipoId VARCHAR(255)
);


CREATE TABLE tipoevento (
    id VARCHAR(255) primary key,
    descrizione VARCHAR(255)
);

CREATE TABLE tavoli (
    id BIGSERIAL PRIMARY KEY,
    ludoId BIGSERIAL,
    posti integer,
    descrizione VARCHAR(255)
);