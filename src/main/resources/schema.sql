CREATE TABLE coordinates (
    lat VARCHAR (30)  ,
    lon VARCHAR (30) ,
    PRIMARY KEY (lat, lon)
);

CREATE TABLE IF NOT EXISTS users (
    username VARCHAR (15) PRIMARY KEY ,
    password VARCHAR (100),
    enabled SMALLINT
);

CREATE TABLE IF NOT EXISTS authorities (
    username varchar(15),
    authority varchar(25),
    FOREIGN KEY (username) references users(username)
);

INSERT INTO users (username, password, enabled)
VALUES
('user', '{noop}user', 1);

INSERT INTO authorities (username, authority)
VALUES
('user', 'ROLE_USER');