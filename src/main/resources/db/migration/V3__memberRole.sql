create sequence member_role_seq start with 1 increment by 50;

CREATE TABLE member_role
(
    id        BIGINT   NOT NULL,
    role      SMALLINT NOT NULL,
    member_id BIGINT,
    CONSTRAINT pk_memberrole PRIMARY KEY (id)
);

ALTER TABLE member_role
    ADD CONSTRAINT FK_MEMBER_ROLE_MEMBER_ID FOREIGN KEY (member_id) REFERENCES member (id);