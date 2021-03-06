CREATE TABLE users (
  id SERIAL PRIMARY KEY,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(60) NOT NULL
);

CREATE TABLE role (
	id SERIAL PRIMARY KEY,
	name VARCHAR(45) NOT NULL
);
INSERT INTO role (name) VALUES ('ROLE_USER');

CREATE TABLE user_role (
	id_users INTEGER NOT NULL,
	id_role INTEGER NOT NULL
);
ALTER TABLE user_role ADD CONSTRAINT user_fk
FOREIGN KEY (id_users) REFERENCES users (id);
ALTER TABLE user_role ADD CONSTRAINT role_fk
FOREIGN KEY (id_role) REFERENCES role (id);
