create table users
(
    id       bigserial,
    username varchar(50) not null unique,
    password varchar(80) not null,
    email    varchar(50) unique,
    primary key (id)
);

insert into users(username,password,email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i','user@mail.ru'),
       ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i','admin@mail.ru');

create table roles
(
    id   serial,
    name varchar(50) not null
);

create table users_roles
(
    user_id  bigint not null,
    roles_id bigint not null,
    primary key (user_id, roles_id),
    foreign key (user_id) references users (id),
    foreign key (roles_id) references roles(id)
);

insert into roles(name)
values ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_MAIN_ADMIN');


insert into users_roles (user_id, roles_id)
values (1, 1),
       (2, 2),
       (2, 3);






