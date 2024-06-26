create table error_log (
                           id bigint generated by default as identity,
                           insert_dt timestamp(6),
                           update_dt timestamp(6),
                           uri varchar(255) not null,
                           message clob not null,
                           primary key (id)
);

create table lecture (
                         id bigint generated by default as identity,
                         code varchar(5) not null,
                         name varchar(255) not null,
                         max_count int not null,
                         insert_dt timestamp(6),
                         update_dt timestamp(6),
                         primary key (id)
);

create table member (
                        id bigint generated by default as identity,
                        email varchar(255) not null,
                        name varchar(255) not null,
                        insert_dt timestamp(6),
                        update_dt timestamp(6),
                        primary key (id)
);

create table reservation (
                             id bigint generated by default as identity,
                             status varchar(255) not null,
                             insert_dt timestamp(6),
                             member_id bigint,
                             store_lecture_id bigint,
                             update_dt timestamp(6),
                             primary key (id)
);

create table store (
                       id bigint generated by default as identity,
                       code varchar(5) not null,
                       name varchar(255) not null,
                       address varchar(255) not null,
                       insert_dt timestamp(6),
                       update_dt timestamp(6),
                       primary key (id)
);

create table store_lecture (
                               id bigint generated by default as identity,
                               store_id bigint,
                               lecture_id bigint,
                               lecture_dt timestamp(6),
                               insert_dt timestamp(6),
                               update_dt timestamp(6),
                               primary key (id)
);