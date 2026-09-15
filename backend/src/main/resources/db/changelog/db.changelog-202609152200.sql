--liquibase formatted sql

--changeset tasks:1
CREATE TABLE IF NOT EXISTS tasks
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    description TEXT,
    priority SMALLINT,
    criticality SMALLINT
    );
--rollback DROP TABLE tasks;
