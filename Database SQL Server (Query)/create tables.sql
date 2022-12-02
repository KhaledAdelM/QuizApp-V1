use QuizApp

create table Users (
  Id int identity(1 ,1) primary key,
  fullName nvarchar (20) NOT NULL ,
  username nvarchar (50) NOT NULL primary key,
  email nvarchar (50) NOT NULL,
  phone int NOT NULL,
  password nvarchar (50) NOT NULL,
  score int DEFAULT(0),
  numOfModule int foreign key references Module (numOfModule) ,
)

create table Module (
  numOfModule int primary key, 
  module nvarchar (20)
)


create table Quiz (
  Id int identity( 99000 ,1) primary key,
  quizName varchar (50) NOT NULL,
  tag varchar(50) NOT NULL,
  details varchar (100) NOT NULL
)


create table Question (
  Id int identity( 1 ,1) primary key,
  IdQuiz int NOT NULL foreign key references Quiz (Id) on delete cascade on update cascade,
  question varchar (250) NOT NULL,
)

create table Choices (
  Id int identity( 999000 ,1) primary key,
  IdQuestion int NOT NULL foreign key references Question (Id) on delete cascade on update cascade,
  choice varchar (100) NOT NULL,
  answer bit default (0) 
)

create table DegreeQuizzes (
  IdUser int NOT NULL foreign key references Users (Id) on delete cascade on update cascade,
  IdQuiz int NOT NULL foreign key references Quiz (Id) on delete cascade on update cascade,
  degree int NOT NULL
)

create table Favorites (
  IdUser int NOT NULL foreign key references Users (Id) on delete cascade on update cascade,
  IdQuiz int NOT NULL foreign key references Quiz (Id)  on delete cascade on update cascade,
)

create table messages (
  Id int identity( 1 ,1) primary key,
  fullName nvarchar (20) NOT NULL,
  email nvarchar (50) NOT NULL,
  phoneNumber int NOT NULL,
  massage nvarchar (250) NOT NULL,
)

create table socialMedia (
  facebook nvarchar (150),
  twitter nvarchar (150),
  github nvarchar (150),
  youtube nvarchar (150),
  webSite nvarchar (150),
)