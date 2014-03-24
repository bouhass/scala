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

CREATE TABLE project_tasks (
  project_id integer NOT NULL,
  task_id integer NOT NULL,
  PRIMARY KEY (project_id, task_id),
  KEY project_id_fk (project_id),
  KEY task_id_fk (task_id),
  CONSTRAINT project_id_fk FOREIGN KEY (project_id) REFERENCES project (id),
  CONSTRAINT task_id_fk FOREIGN KEY (task_id) REFERENCES task (id)
);

# --- !Downs

DROP TABLE project;
DROP TABLE task;
DROP TABLE project_tasks;
