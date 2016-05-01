create database cdio3;
use cdio3;
create table users(id int, navn varchar(20), ini varchar(20), cpr varchar(11), password varchar(20), position varchar(20), primary key(id));
insert into users(id, navn, ini, cpr, password, position) values (1, "test", "t", "121212-1991","testpass","admin");
insert into users(id, navn, ini, cpr, password, position) values (2, "Magnus", "MJ", "121112-1991", "password", "farmaceut");


