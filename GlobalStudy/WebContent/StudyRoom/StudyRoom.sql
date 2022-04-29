
insert into S_RESIST (S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME,S_LEVEL,S_WEEK,S_PARTTIME,
S_CHATLINK)
values(S_RESIST_seq.nextval,'1','홍길동','바람','자네','강남','일본어','초급','평일','13:00~14:00','kakao');
insert into S_RESIST (S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME,S_LEVEL,S_WEEK,S_PARTTIME,
S_CHATLINK)
values(S_RESIST_seq.nextval,'1','홍길동','봄이다','봄보보봄','신촌','영어','중급','평일','13:00~14:00','kakao');
insert into S_RESIST (S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME,S_LEVEL,S_WEEK,S_PARTTIME,
S_CHATLINK)
values(S_RESIST_seq.nextval,'2','강감찬','여름이다','나츤차ㅡ나츠','홍대','일본어','고급','평일','13:00~14:00','kakao');
insert into S_RESIST (S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME,S_LEVEL,S_WEEK,S_PARTTIME,
S_CHATLINK)
values(S_RESIST_seq.nextval,'2','강감찬','가을이다','아키아키아키','인천-부평','일본어','중급','주말','13:00~14:00','kakao');
insert into S_RESIST (S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME,S_LEVEL,S_WEEK,S_PARTTIME,
S_CHATLINK)
values(S_RESIST_seq.nextval,'3','몰루','겨울이다','후유우우','건대','중국어','초급','주말','13:00~14:00','kakao');
insert into S_RESIST (S_STUDYCODE,M_MEMCODE,M_NAME,S_TITLE,S_CONTENT,S_AREA,S_LANNAME,S_LEVEL,S_WEEK,S_PARTTIME,
S_CHATLINK)
values(S_RESIST_seq.nextval,'3','몰루','내년이다','라아ㅣㄴ네넨','판교/분당','일본어','고급','주말','13:00~14:00','kakao');
select m_memcode from s_member where m_id='test';
<!-- -->
select * from s_join;
select * from s_resist;
select * from s_member;
delete from s_member where M_id='test';

CREATE table S_RESIST(
S_STUDYCODE number PRIMARY KEY, --스터디번호, pk
M_MEMCODE VARCHAR2(10) not null, --회원코드, FK
M_NAME VARCHAR2(50) not null, -- 회원이름
S_TITLE VARCHAR2(100) NOT NULL, -- 스터디 제목
S_CONTENT VARCHAR2(4000) NOT NULL, -- 스터디 내용
S_COUNT NUMBER DEFAULT 0, -- 조회수
S_AREA VARCHAR2(20) NOT NULL, -- 지역
S_LANNAME VARCHAR2(50) NOT NULL, -- 언어명
S_LEVEL VARCHAR2(20) NOT NULL, --언어 레벨
S_WEEK VARCHAR2(10) NOT NULL, -- 스터디 요일/ 평일OR주말 중 입력
S_PARTTIME VARCHAR2(50) NOT NULL, -- 스터디 시간/ 13:00 ~ 14:00
S_CHATLINK VARCHAR2(100) NOT NULL, -- 채팅수단
S_DELETEYN VARCHAR2(5) DEFAULT 'N', -- 삭제여부/ DEFAULT값 N-> 삭제 안함 <-> Y: 삭제
S_WRITEDAY DATE default sysdate ,  -- 최근작성일자(작성일자/ 수정일자)
S_STARTDAY varchar2(20), -- 시작 일자
S_ENDDAY VARCHAR2(20), -- 종료 일자
CONSTRAINT M_MEMCODE_FK FOREIGN KEY(M_MEMCODE) REFERENCES S_MEMBER
);

CREATE table S_MEMBER(
M_MEMCODE VARCHAR2(10) PRIMARY KEY NOT NULL, --회원코드
M_ID VARCHAR2(50) NOT NULL,
M_PW VARCHAR2(50) NOT NULL,
M_NAME VARCHAR2(50) NOT NULL, -- 이름
M_LANNAME VARCHAR2(50) NOT NULL,
M_LEVEL VARCHAR2(50) NOT NULL,
M_EMAIL VARCHAR2(200) NOT NULL,
M_PHONE VARCHAR2(30) NOT NULL
);

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

create sequence S_RESIST_seq
start with 1 --시작값
increment by 1 --증가량
nomaxvalue --최대값
nocache
nocycle;

create sequence S_MEMBER_seq
start with 1 --시작값
increment by 1 --증가량
nomaxvalue --최대값
nocache;

create SEQUENCE S_JOIN_seq
start with 1
increment by 1
nomaxvalue
nocache
nocycle;

drop table S_RESIST;
drop table s_member;
drop table s_join;
drop sequence s_join_seq;
drop sequence s_member_seq;
drop sequence s_resist_seq;
