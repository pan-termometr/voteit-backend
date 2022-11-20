create table voteit
(
    id serial primary key,
    title varchar(80) not null,
    description varchar(300) not null,
    url varchar(2048) not null unique,
    thumbnail varchar(2048),
    votes_up integer not null,
    votes_down integer not null,
    for_adult_only boolean not null ,
    app_user_id integer references app_user not null,
    creation_date timestamp not null
)
;