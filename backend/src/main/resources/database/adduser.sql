ALTER SEQUENCE user_sequence OWNED BY user.id;

ALTER TABLE user ALTER COLUMN id SET DEFAULT nextval('user_sequence');

insert into user (username, password, fname, lname, email, isadmin)
values ('user', 'password', 'Standard', 'User',  'user@mail.com', 0);

insert into user (username, password, fname, lname, email, isadmin)
values ('admin', 'password', 'Admin', 'User',  'admin@mail.com', 1);