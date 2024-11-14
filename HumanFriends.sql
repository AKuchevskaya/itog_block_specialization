-- Создаем базу данных и подключаем ее

DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE HumanFriends;
USE HumanFriends;

-- Создаем и заполняем три таблицы с домашними животными

CREATE TABLE Cats (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT);
INSERT INTO Cats (Name, BirthDate, Commands) VALUES
('Wiskes', '2019-04-15', 'Sit, Pounce'),
('Smude', '2021-06-20', 'Sit, Pounce, Scratch'),
('Opra', '2022-11-28', 'Meow, Scratch, Jump');

CREATE TABLE Dogs (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT);
INSERT INTO Dogs (Name, BirthDate, Commands) VALUES
('Difo', '2021-01-04', 'Sit, Stay, Fetch'),
('Wuddy', '2019-11-18', 'Sit, Paw, Bark'),
('Belka', '2024-09-16', 'Sit, Stay, Roll');

CREATE TABLE Hamsters (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT);
INSERT INTO Hamsters (Name, BirthDate, Commands) VALUES
('Bammy', '2022-03-20', 'Roll, Hide'),
('Peanut', '2023-10-06', 'Roll, Spin'),
('Liver', '2023-06-30', 'Roll, Jump');

-- Создаем и заполняем три таблицы с вьючными животными

CREATE TABLE Horses (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT);
INSERT INTO Horses (Name, BirthDate, Commands) VALUES
('Sahara', '2016-02-29', 'Walk, Run, Gallop'),
('Sandy', '2015-08-14', 'Trot, Canter');

CREATE TABLE Camels (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT);
INSERT INTO Camels (Name, BirthDate, Commands) VALUES
('Kilu', '2014-05-05', 'Walk, Carry Load'),
('Duna', '2018-11-02', 'Walk, Sit');

CREATE TABLE Donkeys (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT);
INSERT INTO Donkeys (Name, BirthDate, Commands) VALUES
('Balu', '2014-05-05', 'Walk, Kick'),
('Burro', '2020-03-19', 'Walk, Bray, Kick');

-- Создаем таблицы с домашними(DomesticAnimals) и вьючными животными(PackAnimals)

CREATE TABLE DomesticAnimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT,
	Type VARCHAR(15));

CREATE TABLE PackAnimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(15),
    BirthDate DATE,
    Commands TEXT,
	Type VARCHAR(15));

-- Заполняем две таблицы данными

INSERT INTO DomesticAnimals (Name, BirthDate, Commands, Type)
SELECT Name, BirthDate, Commands, 'Cat'
FROM Cats;
INSERT INTO DomesticAnimals (Name, BirthDate, Commands, Type)
SELECT Name, BirthDate, Commands, 'Dog'
FROM Dogs;
INSERT INTO DomesticAnimals (Name, BirthDate, Commands, Type)
SELECT Name, BirthDate, Commands, 'Hamster'
FROM Hamsters;

INSERT INTO PackAnimals (Name, BirthDate, Commands, Type)
SELECT Name, BirthDate, Commands, 'Horse'
FROM Horses;
INSERT INTO PackAnimals (Name, BirthDate, Commands, Type)
SELECT Name, BirthDate, Commands, 'Camel'
FROM Camels;
INSERT INTO PackAnimals (Name, BirthDate, Commands, Type)
SELECT Name, BirthDate, Commands, 'Donkey'
FROM Donkeys;

-- Удаляем из таблицы с вьючными животными верблюдов

DELETE FROM PackAnimals WHERE Type = 'Camel';

-- Создаем новую таблицу с вьючными животными без верблюдов

CREATE TABLE NewPackAnimals AS
SELECT ID, Name, BirthDate, Commands, Type FROM PackAnimals WHERE Type IN ('Horse', 'Donkey');

-- Создаем таблицу с молодыми животными, добавляя столбик с возрастом в месяцах
CREATE TABLE YoungAnimals AS
SELECT ID, Name, Type, BirthDate, Commands,
	TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths
FROM DomesticAnimals
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;

-- Создаем общую таблицу со всеми животными

CREATE TABLE AllAnimals AS
SELECT ID, Name, BirthDate, Commands, Type, 'DomesticAnimals' AS Classes
FROM DomesticAnimals
UNION ALL
SELECT ID, Name, BirthDate, Commands, Type, 'PackAnimals' AS Classes
FROM PackAnimals
WHERE Type IN ('Horse', 'Donkey');
