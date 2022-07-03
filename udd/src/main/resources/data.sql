----------------------------------------AUTHORITIES----------------------------------------
insert into authority_table (name) values ('admin');
insert into authority_table (name) values ('client');

----------------------------------------USERS----------------------------------------
insert into user_table (email, password, first_name, last_name)
values ('marko@gmail.com', '$2a$10$VpH.INOqjymPVNZ986HWkuTWPXMjk68d5AD/9Iu5gO846LsNj2g62', 'marko', 'markovic');

insert into user_table (email, password, first_name, last_name)
values ('ivan@gmail.com', '$2a$10$VpH.INOqjymPVNZ986HWkuTWPXMjk68d5AD/9Iu5gO846LsNj2g62', 'ivan', 'ivanovic');

insert into user_authority (user_id, authority_id) values (1, 2);
insert into user_authority (user_id, authority_id) values (2, 2);
