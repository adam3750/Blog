drop database if exists CMSBlog;
create database CMSBlog;
use CMSBlog;

create table user(
userid int primary key auto_increment,
username varchar(30) not null unique,
displayname varchar(30) not null,
password varchar(100) not null,
enabled boolean not null);

create table role(
roleid int primary key auto_increment,
role varchar(30) not null);

create table user_role(
user_id int not null,
role_id int not null,
primary key(user_id,role_id),
foreign key (user_id) references user(userid),
foreign key (role_id) references role(roleid));

create table content(
contentid int primary key auto_increment,
userid int not null,
title varchar(40) not null,
category varchar(60) not null,
creationdate date not null,
postdate date not null,
showpost boolean default false,
foreign key (userid) references user(userid));

create table tags(
tagid int primary key auto_increment,
title varchar (40) not null,
description varchar (200) null,
robot varchar (40) null);

create table content_tags(
contentid int not null,
tagid int not null,
primary key(contentid,tagid),
foreign key (contentid) references content(contentid),
foreign key (tagid) references tags(tagid));

insert into user(userid,username,displayname,password,enabled)
  values(1,"admin", "James T. Kirk", "$2a$10$mMUe6Z7nq9ANZ/ezjVzZLOk.xbIdSdJ5BznOsmH2Luz.xPB/J43X2", true),
      (2,"user", "Scotty", "$2a$10$mMUe6Z7nq9ANZ/ezjVzZLOk.xbIdSdJ5BznOsmH2Luz.xPB/J43X2",true);
insert into role(roleid,role)
  values(1,"ROLE_ADMIN"), (2,"ROLE_USER");
insert into user_role(user_id,role_id)
  values(1,1),(1,2),(2,2);