create table students(
id integer primary key,
name varchar(25) not null,
email varchar(25),
dob date
);
create table advisors(
aid integer primary key,
name varchar(25) not null,
email varchar(25),
specialization varchar(25)
);
create table courses(
cid integer primary key,
title varchar(50) not null,
description varchar(50),
instructor varchar(25) not null
);
alter table students
add advisorid integer;
alter table students
add foreign key(advisorid) references advisors(aid);
create table enrols(
studentid integer,
courseid integer,
primary key(studentid, courseid),
foreign key(studentid) references students(id) on delete cascade,
foreign key(courseid) references courses(cid) on delete cascade
);
