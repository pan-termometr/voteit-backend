create table tag
(
    id serial primary key,
    tagname varchar(30) not null unique
)
;