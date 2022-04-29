CREATE TABLE S_JOIN(
    S_JOINCODE number(10) primary key not null,
    S_STUDYCODE VARCHAR2(10)not null,
    M_MEMCODE VARCHAR2(10) not null,
    SJ_NAME VARCHAR2 (50),
    SJ_DATE DATE DEFAULT SYSDATE ,
    SJ_JOINDAY DATE,
    SJ_TITLE VARCHAR2 (100),
    SJ_CONTENT VARCHAR2 (1000),
    SJ_SUBMITYN VARCHAR2 (1) default 'N' not null
);


drop table S_JOIN;

drop sequence S_JOIN_seq;

create SEQUENCE S_JOIN_seq

start with 1

increment by 1

nomaxvalue

nocache

nocycle;