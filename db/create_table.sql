CREATE TABLE cars (
  id VARCHAR(255) primary key,
  nome VARCHAR(255),
  cognome VARCHAR(255)
);

CREATE TABLE ludopoint (
       id VARCHAR(255) primary key,
       userId VARCHAR(255),
       nome VARCHAR(255)
);

CREATE TABLE eventi (
    id VARCHAR(255) primary key,
    ludoId VARCHAR(255),
    tipoId VARCHAR(255)
);

CREATE TABLE eventi (
    id VARCHAR(255) primary key,
    ludoId VARCHAR(255),
    tipoId VARCHAR(255)
);

CREATE TABLE tipoevento (
        id VARCHAR(255) primary key,
        descrizione VARCHAR(255)
);

CREATE TABLE tavoli (
    id VARCHAR(255) primary key,
    ludoId VARCHAR(255),
    posti integer,
    descrizione VARCHAR(255)
);