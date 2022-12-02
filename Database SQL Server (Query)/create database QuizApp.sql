create database QuizApp
on
primary (
name = QuizApp ,
filename = ##/QuizApp.mdf',
size = 10MB ,
filegrowth = 5%
)
log on (
name = QuizApp ,
filename = '##/QuizApp.ldf',
size = 9MB ,
filegrowth = 5%
)
