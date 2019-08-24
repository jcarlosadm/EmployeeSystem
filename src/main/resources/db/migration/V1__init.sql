CREATE TABLE users (
id bigserial NOT NULL,
email varchar(255) NOT NULL,
last_name varchar(255) NULL,
name varchar(255) NOT NULL,
"password" varchar(255) NOT NULL,
CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER TABLE users OWNER TO docker;
GRANT ALL ON TABLE users TO docker;

CREATE TABLE roles (
id bigserial NOT NULL,
"name" varchar(60) NULL,
CONSTRAINT roles_pkey PRIMARY KEY (id),
CONSTRAINT uk_nb4h0p6txrmfc0xbrd1kglp9t UNIQUE (name)
);

-- Permissions

ALTER TABLE roles OWNER TO docker;
GRANT ALL ON TABLE roles TO docker;

CREATE TABLE user_roles (
user_id int8 NOT NULL,
role_id int8 NOT NULL,
CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id),
CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES roles(id),
CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Permissions

ALTER TABLE user_roles OWNER TO docker;
GRANT ALL ON TABLE user_roles TO docker;

insert into users (email, last_name, name, password) VALUES ('leandro@mail.com', 'sales', 'leandro', '$2a$10$CUUvpT7S8rc6kCxm9lF4ped5mFb2OiwME682tbQg3SjO7FiOVykUu');
INSERT INTO roles (name) VALUES('ROLE_USER');
INSERT INTO roles (name) VALUES('ROLE_ADMIN');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);