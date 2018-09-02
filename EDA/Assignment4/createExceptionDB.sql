CREATE DATABASE excetionDB;
USE excetionDB;

CREATE  TABLE  exceptions (
    exceptionsId INT NOT NULL AUTO_INCREMENT ,
    className TEXT NOT NULL ,
    exceptionName TEXT NOT NULL ,
    exceptionDescription TEXT NOT NULL ,
    PRIMARY KEY (exceptionsId) 
);