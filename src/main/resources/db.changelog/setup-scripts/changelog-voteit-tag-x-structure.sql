create table voteit_tag_x
(
    voteit_id integer references voteit not null,
    tag_id integer references tag not null
)
;