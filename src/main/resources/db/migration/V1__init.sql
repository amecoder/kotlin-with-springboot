create table word_count
(
    cnt  integer      not null,
    word varchar(255) not null
        primary key
);

alter table word_count
    owner to postgres;

