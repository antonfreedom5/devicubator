create database thebanklist;
use thebanklist;

create table user(
	userid int primary key auto_increment,
    name varchar(45),
    surName varchar(45)
);
create table account(
	accountid int primary key auto_increment,
    account int,
    userid int,
    foreign key (userid) references user (userid)
);

insert into user (name, surName)
	values ('Vasily', 'Petrov'),
			('Artur', 'Bustrov'),
            ('Ilya', 'Semenov'),
            ('Olga', 'Ivanova'),
            ('Adam', 'Lavrov'),
            ('Inna', 'Morozova'),
            ('Ignat', 'Frolov'),
            ('Petr', 'Somov'),
            ('Maria', 'Fedotova'),
            ('Anna', 'Savko');

insert into account (account, userid)
	values (123, 1),
			(234, 2),
            (534, 3),
            (654, 4),
            (132, 5),
            (421, 6),
            (567, 7),
            (233, 8),
            (765, 9),
            (154, 10);
            
select *
from user, account;            
            
select name, surName, account 
from user, account
where user.userid = account.userid;
