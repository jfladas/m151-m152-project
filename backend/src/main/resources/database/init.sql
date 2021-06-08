CREATE EXTENSION IF NOT EXISTS pgtask;

create sequence task_sequence start 1 increment 1;

create table task
(
    id int8 not null,
    title varchar(255) not null,
    description varchar(255) not null,
    status varchar(255) not null,
    duedate date not null,
    ispublic bit not null,
    creator int8 not null,
    primary key (id),
    foreign key (creator) references user(id)
);

create table user
(
    id int8 not null,
    username varchar(255) not null,
    password varchar(255) not null,
    fname varchar(255) not null,
    lname varchar(255) not null,
    email varchar(255) not null,
    isadmin bit not null,
    primary key (id)
);

create table task_user
(
    id int8 not null,
    task int8 not null,
    user int8 not null,
    primary key (id),
    foreign key (task) references task(id),
    foreign key (user) references user(id)
);