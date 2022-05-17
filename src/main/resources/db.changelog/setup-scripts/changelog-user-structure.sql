create table app_user
(
    id serial primary key,
    username varchar(30) not null unique,
    password varchar(128) not null,
    email varchar(320) not null unique
)
;