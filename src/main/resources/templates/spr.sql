create database CurrencyDB;
create user 'springuser'@'%' identified by 'user';
grant all on CurrencyDB.* to 'springuser'@'%';
SET GLOBAL time_zone = '+2:00';