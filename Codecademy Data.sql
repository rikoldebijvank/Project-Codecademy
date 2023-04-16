INSERT INTO Course (CourseName, Subject, IntroductionText, Difficulty, Chapters)
VALUES 
('English For Beginners', 'English', 'This course teaches English to beginners', 'BEGINNER', 4),
('Algebra','Math', 'This is an advanced algebra course', 'ADVANCED', 9),
('Dutch For Internationals', 'Dutch', 'The perfect course for someone who wants to live in the Netherlands', 'BEGINNER', 5),
('Data Science Using Python', 'Data Science', 'This course uses Python to visualize large amounts of data', 'EXPERT', 4),
('Beginners Guide for SQL', 'SQL', 'Using SQL we will store data into our own database', 'BEGINNER', 10)

INSERT INTO Student (Email, Name, DateOfBirth, Gender, Address, PostalCode, Country)
VALUES
('lucaspeeters@gmail.com', 'Lucas Peeters', '2005-03-20', 'M', 'Dorpsstraat 7', '2412 RH', 'Netherlands'),
('thijsdejong@hotmail.com', 'Thijs De Jong', '1999-11-05', 'M', 'Kerkstraat 10', '2352 SL', 'Netherlands'),
('koendevries@gmail.com', 'Koen De Vries', '2006-12-09', 'M', 'Molenweg 1', '6422 AA', 'Netherlands'),
('sannebakker@gmail.com', 'Sanne Bakker', '2000-01-01', 'F', 'Sportlaan 4', '2345 DF', 'Netherlands'),
('elinevisser@gmail.com', 'Eline Visser', '2001-08-02', 'F', 'Nieuwstraat 4', '9438 AL', 'Netherlands')

<<<<<<< HEAD
INSERT INTO Registration (CourseName, StudentEmail, Date, CourseFinished)
VALUES
('English For Beginners', 'lucaspeeters@gmail.com', '2022-05-01', 0),
('Algebra', 'thijsdejong@hotmail.com', '2020-11-19', 0),
('Data Science Using Python', 'koendevries@gmail.com', '2023-04-15', 0),
('Beginners Guide for SQL', 'sannebakker@gmail.com', '2023-01-01', 0),
('Beginners Guide for SQL', 'elinevisser@gmail.com', '2022-04-22', 0),
('Beginners Guide for SQL', 'lucaspeeters@gmail.com', '2023-01-11', 1)
=======
INSERT INTO Registration (CourseName, StudentEmail, Date)
VALUES
('English For Beginners', 'lucaspeeters@gmail.com', '2022-05-01'),
('Algebra', 'thijsdejong@hotmail.com', '2020-11-19'),
('Data Science Using Python', 'koendevries@gmail.com', '2023-04-15'),
('Beginners Guide for SQL', 'sannebakker@gmail.com', '2023-01-01'),
('Beginners Guide for SQL', 'elinevisser@gmail.com', '2022-04-22')
>>>>>>> statistics

INSERT INTO ContactPerson (Name, Email)
VALUES
('Willem Jansen', 'willemjansen@gmail.com'),
('Ina de Jong', 'inadejong@gmail.com')

INSERT INTO Speaker (SpeakerID, Name, Organization)
VALUES
(1, 'Tijn de Vos', 'Avans')

INSERT INTO Module (Title, Version, ID, ContactPersonName, Description, ModuleNumber)
VALUES
('English Alphabet', 1, 1, 'Willem Jansen', 'In this module we will learn how to pronounce the letters of the English alphabet.', 1),
('Solving for X', 2, 2, 'Ina de Jong', 'This module will teach you how to solve for X', 1),
('Introduction to Python', 1, 3, 'Ina de Jong', 'We will discuss the basics of Python and how it interacts with Data Science', 1),
('Dutch Alphabet', 4, 4, 'Willem Jansen', 'This module will teach you how to pronounce the letters of the Dutch alphabet', 1),
('Basic Commands', 1, 5, 'Ina de Jong', 'We will teach you the basic commands of SQL', 1),
('Using JOIN', 2, 6, 'Ina de Jong', 'You will learn how to join two tables', 1)

INSERT INTO Webcast (Title, ID, SpeakerId, URL, Description, TimeInMinutes, Views)
VALUES
('Pronunciation', 1, 1, 'https://randomwebsite.com', 'We will go over the pronunciation of basic words', 10, 10),
('Completing the Square', 2, 1, 'https://randomwebsite.com', 'We will go over how to complete the square in an equation', 30, 20),
('Graphs', 3, 1, 'https://randomwebsite.com', 'We will see how graphs can show data in a readable way', 15, 8),
('Pronunciation of Dutch Sounds', 4, 1, 'https://randomwebsite.com', 'We will go over the pronunciation of basic sounds', 20, 12),
('CRUD Operations', 5, 1, 'https://randomwebsite.com', 'We will go over the CRUD operations', 25, 25)


INSERT INTO ContentItem (ContentID, PublicationDate, Status, CourseName, ModuleID, WebcastID)
VALUES
(1, '2019-05-05', 'ACTIVE', 'English For Beginners', 1, NULL),
(2, '2019-05-06', 'ACTIVE', 'English For Beginners', NULL, 1),
(3, '2019-05-07', 'ACTIVE', 'Algebra', 2, NULL),
(4, '2019-05-08', 'ACTIVE', 'Algebra', NULL, 2),
(5, '2019-05-09', 'ACTIVE', 'Data Science Using Python', 3, NULL),
(6, '2019-05-10', 'ACTIVE', 'Data Science Using Python', NULL, 3),
(7, '2019-05-11', 'ACTIVE', 'Dutch For Internationals', 4, NULL),
(8, '2019-05-12', 'ACTIVE', 'Dutch For Internationals', NULL, 4),
(9, '2019-05-13', 'ACTIVE', 'Beginners Guide for SQL', 5, NULL),
(10, '2019-05-14', 'ACTIVE', 'Beginners Guide for SQL', NULL, 5),
(11, '2019-05-05', 'ARCHIVED', 'Beginners Guide for SQL', 6, NULL)

INSERT INTO ViewedContent (ContentID, StudentEmail, PercentageViewed)
VALUES
(1, 'lucaspeeters@gmail.com', 70),
<<<<<<< HEAD
(2, 'thijsdejong@hotmail.com', 10),
(3, 'koendevries@gmail.com', 20),
(4, 'sannebakker@gmail.com', 90),
(5, 'elinevisser@gmail.com', 100),
(5, 'sannebakker@gmail.com', 30),
(5, 'thijsdejong@hotmail.com', 15),
(6, 'lucaspeeters@gmail.com', 5),
(7, 'koendevries@gmail.com', 65),
(10, 'lucaspeeters@gmail.com', 100)
=======
(2, 'lucaspeeters@gmail.com', 10),
(3, 'thijsdejong@hotmail.com', 20),
(4, 'thijsdejong@hotmail.com', 90),
(5, 'koendevries@gmail.com', 100),
(6, 'koendevries@gmail.com', 5),
(9, 'sannebakker@gmail.com', 65),
(9, 'elinevisser@gmail.com', 100),
(10, 'sannebakker@gmail.com', 100),
(10, 'elinevisser@gmail.com', 100)
>>>>>>> statistics
