DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(255) NOT NULL UNIQUE,
    PRICE FLOAT NOT NULL
);