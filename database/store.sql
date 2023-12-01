create database blog;
use blog;

create table user
(
    id int not null primary key auto_increment,
    name varchar(60) not null,
    profile_picture text,
    sex varchar(10),
    dob varchar(30),
    address text
);

create table post
(
    id int not null primary key auto_increment,
    content text,
    image text,
    time varchar(30),
    idSituation int,
    foreign key (idSituation) references situation(id),
    idCategory int,
    foreign key (idCategory) references category(id),
    idUser int,
    foreign key (idUser) references user(id)
);

create table situation
(
    id int not null primary key auto_increment,
    name varchar(20)
);

create table category
(
    id int not null primary key auto_increment,
    name varchar(20)
);

create table comment
(
    id int not null primary key auto_increment,
    time varchar(20),
    content text,
    idPost int,
    foreign key (idPost) references post(id),
    idUser int,
    foreign key (idUser) references user(id)
)

