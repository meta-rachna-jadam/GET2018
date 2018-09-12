CREATE DATABASE employeePortal;
USE employeePortal;

CREATE  TABLE employee (
    emp_code INT NOT NULL AUTO_INCREMENT ,
    first_name VARCHAR(45) NOT NULL ,
    middle_name VARCHAR(45) NULL ,
    dob DATE NOT NULL ,
    gender VARCHAR(6) NOT NULL ,
    primary_contact_no VARCHAR(15) NOT NULL ,
    secondary_contact_no VARCHAR(15) NULL ,
    email_id VARCHAR(100) NOT NULL ,
    skype_id VARCHAR(100) NOT NULL ,
    profile_picture VARCHAR(100) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    enabled BOOLEAN NOT NULL DEFAULT true,
    PRIMARY KEY (emp_code),
    UNIQUE (email_id)     
);
select * from employee;
CREATE TABLE jobTitle (
    job_code INT NOT NULL AUTO_INCREMENT ,
    job_title VARCHAR(100) NOT NULL ,
    PRIMARY KEY (job_code)
);
select * from jobTitle;
CREATE TABLE userRoles (
    user_role_id INT NOT NULL AUTO_INCREMENT ,
    username VARCHAR(100) NOT NULL ,
    role VARCHAR(100) NOT NULL ,
    PRIMARY KEY (user_role_id)
);
select * from project;
select * from jobDetails;
select * from employeeSkills;
CREATE TABLE employeeSkills (
    emp_skill_id INT NOT NULL AUTO_INCREMENT ,
    emp_code INT NOT NULL ,
    skill_code INT NOT NULL ,
    PRIMARY KEY (emp_skill_id),
    FOREIGN KEY (emp_code)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (skill_code)
    REFERENCES skills(skill_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE skills (
    skill_id INT NOT NULL AUTO_INCREMENT ,
    skill_name VARCHAR(100) NOT NULL ,
    PRIMARY KEY (skill_id)
);


CREATE TABLE project (
    project_id INT NOT NULL AUTO_INCREMENT ,
    description TEXT NOT NULL ,
    start_date DATE NOT NULL ,
    end_date DATE NULL ,
    project_logo VARCHAR(100) NOT NULL DEFAULT 'D:\HTML Pages\Capture.PNG',
    enabled BOOLEAN NOT NULL DEFAULT true,
    PRIMARY KEY (project_id)
);
truncate table project;
select * from project;

#ALTER TABLE skills ADD enabled BOOLEAN NOT NULL DEFAULT true
#AFTER skill_name;

CREATE TABLE address (
    address_id INT NOT NULL AUTO_INCREMENT ,
    emp_code INT NOT NULL ,
    add_line_1 VARCHAR(100) NOT NULL ,
    add_line_2 VARCHAR(100) NULL ,
    city VARCHAR(100) NOT NULL ,
    state VARCHAR(100) NOT NULL ,
    pincode VARCHAR(50) NOT NULL ,
    PRIMARY KEY (address_id),
    FOREIGN KEY (emp_code)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE jobDetails (
    emp_code INT NOT NULL,
    job_detail_id INT NOT NULL AUTO_INCREMENT ,
    date_of_joining DATE NOT NULL ,
    total_exp INT NOT NULL ,
    job_code INT NOT NULL ,
    reporting_mgr INT NOT NULL ,
    team_lead INT NOT NULL ,
    curr_proj_id INT NOT NULL ,
    PRIMARY KEY (job_detail_id),
    FOREIGN KEY (emp_code)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (job_code)
    REFERENCES jobTitle(job_code)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (reporting_mgr)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (team_lead)
    REFERENCES employee(emp_code)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY (curr_proj_id)
    REFERENCES project(project_id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO skills (skill_name) values
('Salesforce'),
('Android'),
('IOS'),
('Hadoop'),
('IOT');

select * from skills;
select * from project;