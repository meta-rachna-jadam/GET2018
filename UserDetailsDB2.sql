CREATE DATABASE userDetails2;
USE userDetails2;

CREATE  TABLE users (
    username VARCHAR(100) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    enabled BOOLEAN NOT NULL DEFAULT true,
    PRIMARY KEY (username)
);
DROP TABLE role;
CREATE  TABLE role (
    roleId INT NOT NULL AUTO_INCREMENT ,
    username VARCHAR(100) NOT NULL ,
    role VARCHAR(50) NOT NULL ,
    FOREIGN KEY (username)
    REFERENCES users(username)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    PRIMARY KEY (roleId)
);

INSERT INTO users (username, password) VALUES
('rachna',12345),
('yash',12345),
('rageeni',12345),
('rajat',12345);

INSERT INTO role (username, role) VALUES
('rachna', 'ADMIN'),
('rajat', 'USER');


SELECT * FROM users;
SELECT * FROM role;


select username, password, enabled from users where username='rachna';
select username, role from role where username='rachna';

select u.username, u.password, r.role from users u left join role r on r.username = u.username where r.role is not null;