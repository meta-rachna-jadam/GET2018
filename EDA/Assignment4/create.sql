CREATE DATABASE employeeFriendsBook;
USE employeeFriendsBook;

CREATE TABLE employee (
    employeeId INT NOT NULL AUTO_INCREMENT  ,
    firstName VARCHAR(45) NOT NULL ,
    lastName VARCHAR(45) NULL ,
    dateOfBirth DATE NOT NULL ,
    emailId VARCHAR(100) NOT NULL ,
    age TINYINT NOT NULL ,
    contactNumber VARCHAR(15) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    profileImage BLOB NULL ,
    companyId INT NOT NULL ,
    PRIMARY KEY (employeeId),
    UNIQUE (emailId),
    FOREIGN KEY (companyId)
    REFERENCES company(companyId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
     
);


CREATE TABLE company (
    companyId INT NOT NULL AUTO_INCREMENT ,
    companyName VARCHAR(100) NOT NULL ,
    PRIMARY KEY (companyId)
);

INSERT INTO company (companyName) values 
('Google'),
('Microsoft'),
('Metacube'),
('UXArmy'),
('Infosis'),
('TCS'),
('Tech. Mahindra');

SELECT employeeId, age, firstName, lastName, dateOfBirth, emailID, contactNumber, companyId 
FROM employee WHERE emailID = 'rachna@gmail.com';

create table friends (
    friendListId int not null AUTO_INCREMENT,
    employeeId int not null,
    employeeFriendId int not null,
    PRIMARY KEY (friendListId),
    FOREIGN KEY (employeeId)
    REFERENCES employee(employeeId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    FOREIGN KEY (employeeFriendId)
    REFERENCES employee(employeeId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
    
);
insert into friends (employeeId, employeeFriendId) values
(1,2),
(1,3),
(2,1),
(2,3),
(3,1),
(3,2);
select * from company;
select * from employee;
select * from friends;
SELECT employeeFriendId FROM friends WHERE employeeId = 1;