--insert into userss (username,password,enabled) values('zhd','123',true);

insert into users (username,PASSWORD,enabled,phone,email) values('user','user',true,'1','1@163.com');
insert into users (username,PASSWORD,enabled,phone,email) values('admin','admin',true,'2','2@163.com');
insert into users (username,PASSWORD,enabled,phone,email) values('3','3',true,'3','3@163.com');
insert into users (username,PASSWORD,enabled,phone,email) values('4','4',true,'4','4@163.com');


insert into authorities (username,authority) values('user','ROLE_USER');
insert into authorities (username,authority) values('admin','ROLE_ADMIN');
insert into authorities (username,authority) values('3','READ');
insert into authorities (username,authority) values('4','READ');


insert into permissions (authority,url) values('READ','/');
insert into permissions (authority,url) values('ROLE_USER','/user');
insert into permissions (authority,url) values('ROLE_ADMIN','/admin');
