CREATE TABLE Clients (Id INT PRIMARY KEY, person_firstname VARCHAR(255) NOT NULL, person_lastname VARCHAR(255) NOT NULL, person_age INT NOT NULL, person_balance INT NOT NULL);


INSERT INTO Clients
VALUES (1,'Timur','Muhametov',19, 56494),
       (2,'Zahar','Harko',26, 100),
       (3,'Arina','Panina',19,10002342);

SELECT*FROM Clients