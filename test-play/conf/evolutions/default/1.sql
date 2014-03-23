# Tasks schema

# --- !Ups

CREATE TABLE project (
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE task (
    id integer NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE project;
DROP TABLE task;
