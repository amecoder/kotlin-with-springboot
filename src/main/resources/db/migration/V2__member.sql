create sequence member_seq start with 1 increment by 50;

create table member
(
    id         bigint       not null,
    login_id   varchar(30)  not null,
    password   varchar(100) not null,
    name       varchar(10)  not null,
    birth_date date         not null,
    gender     varchar(10)   not null,
    email      varchar(30)  not null,
    primary key (id),
    constraint uk_member_login_id unique (login_id)
)
