drop database if exists Blog;

create database Blog;

Use Blog;

create table user(
userid int primary key auto_increment,
`username` varchar(40) not null unique,
`password` varchar(15) not null,
`enabled` boolean not null);

create table role(
roleid int primary key auto_increment,
`role` varchar(30) not null
);

create table user_role(
userid int not null,
roleid int not null, 
primary key(`userid`,`roleid`),
foreign key (`userid`) references `user`(`userid`),
foreign key (`roleid`) references `role`(`roleid`));

create table content(
contentid int primary key auto_increment,
userid int not null,
blog text not null,
creationdate date not null,
postdate date not null,
title varchar(40) not null,
category varchar(60) not null,
foreign key (`userid`) references `user`(`userid`));

create table tags(
tagid int primary key auto_increment,
`tag` varchar (40) not null);

create table content_tags(
contentid int not null, 
tagid int not null, 
primary key(`contentid`,`tagid`),
foreign key (`contentid`) references `content`(`contentid`),
foreign key (`tagid`) references `tags`(`tagid`));







