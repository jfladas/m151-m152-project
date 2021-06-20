ALTER SEQUENCE task_sequence OWNED BY task.id;

ALTER TABLE task ALTER COLUMN id SET DEFAULT nextval('task_sequence');

insert into task (title, description, status, duedate, ispublic, creator)
values ('Title', 'Description', 'Status', 'Duedate', 1, 1);

insert into user (username, password, fname, lname, email, isadmin)
values ('admin', 'password', 'Admin', 'User',  'admin@mail.com', 1);