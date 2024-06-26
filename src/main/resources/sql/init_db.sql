CREATE TYPE level_enum AS ENUM ('Trainee', 'Junior', 'Middle', 'Senior');

CREATE TABLE IF NOT EXISTS worker (
    ID BIGSERIAL PRIMARY KEY,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000),
    BIRTHDAY DATE CHECK (EXTRACT(YEAR FROM BIRTHDAY) > 1900),
    LEVEL level_enum NOT NULL,
    SALARY INTEGER CHECK (SALARY BETWEEN 100 AND 100000)
);

CREATE TABLE IF NOT EXISTS client(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000)
);

CREATE TABLE IF NOT EXISTS project(
	id BIGSERIAL PRIMARY KEY,
	client_id BIGINT,
	start_date TIMESTAMP,
	finish_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS project_worker(
	project_id BIGINT NOT NULL,
	worker_id BIGINT NOT NULL,
	PRIMARY KEY(project_id, worker_id),
	FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);