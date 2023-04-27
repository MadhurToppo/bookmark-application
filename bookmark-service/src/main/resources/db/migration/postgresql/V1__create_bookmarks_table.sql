create sequence bookmarks_seq start with 1 increment by 50;

create table bookmarks (
    id bigint default nextval('bookmarks_seq') not null,
    creation_time timestamp(6) with time zone,
    name varchar(255) not null,
    url varchar(255) not null,
    primary key (id)
);
