create database blog;
use blog;
drop database blog;

create table user
(
    id              int         not null primary key auto_increment,
    name            varchar(60) not null,
    profile_picture text,
    sex             varchar(10),
    dob             varchar(30),
    address         text
);

create table post
(
    id          int not null primary key auto_increment,
    content     text,
    image       text,
    time        varchar(30),
    idSituation int,
    foreign key (idSituation) references situation (id),
    idCategory  int,
    foreign key (idCategory) references category (id),
    idUser      int,
    foreign key (idUser) references user (id)
);

create table situation
(
    id   int not null primary key auto_increment,
    name varchar(20)
);

create table category
(
    id   int not null primary key auto_increment,
    name varchar(20)
);

create table comment
(
    id      int not null primary key auto_increment,
    time    varchar(20),
    content text,
    image   text,
    idPost  int,
    foreign key (idPost) references post (id),
    idUser  int,
    foreign key (idUser) references user (id)
);

-- Find All Comment
select c.*, u.name
from comment c
         join user u on u.id = c.idUser;

-- Find All Post
select p.*, c.name as categoryName, s.name as situationName, u.name as userName
from post p
         join category c on c.id = p.idCategory
         join situation s on p.idSituation = s.id
         join user u on p.idUser = u.id;

-- Add Post
insert into post(content, image, time, idSituation, idCategory, idUser)
values (?, ?, ?, ?, ?, ?);

-- Update Post
update post
set content     = ?,
    image       = ?,
    time        = ?,
    idSituation = ?,
    idCategory  = ?,
    idUser      = ?
where id = ?;

-- Delete Post
delete
from post
where id = ?;

