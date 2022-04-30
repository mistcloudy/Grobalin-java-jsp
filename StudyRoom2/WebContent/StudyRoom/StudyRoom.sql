CREATE table S_RESIST(
S_STUDYCODE varchar2(10) PRIMARY KEY, --스터디번호, pk
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


select * from tab;

create sequence S_RESIST_seq
start with 1 --시작값
increment by 1 --증가량
nomaxvalue --최대값
nocache
nocycle;

alter table s_resist drop column s_startday ;
alter table s_resist drop column s_endday;
alter table s_resist add(s_startday varchar2(20));
alter table s_resist add(s_endday varchar2(20));


CREATE table S_MEMBER(
M_MEMCODE VARCHAR2(10) PRIMARY KEY NOT NULL, --회원코드
M_NAME VARCHAR2(50) NOT NULL -- 이름
);
insert into S_MEMBER values('1','홍길동');
insert into S_MEMBER values('2','강감찬');
insert into S_MEMBER values('3','몰루');

update s_member set m_name = '몰라' where m_memcode='3';

select * from S_RESIST;
SELECT * FROM S_MEMBER;
drop table S_RESIST;
drop table s_member;

update S_RESIST set S_TITLE='내년', S_CONTENT='내년', S_AREA='강남', S_LANNAME='일본어', S_LEVEL='초급', S_WEEK='평일', S_PARTTIME='14:00', S_CHATLINK='kaoo'  where S_STUDYCODE='6';
select S_TITLE, S_CONTENT, S_COUNT, S_AREA, S_LANNAME, S_LEVEL, S_WEEK, S_PARTTIME, S_WRITEDAY from S_RESIST where S_STUDYCODE='4';

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


select * from (select S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = '초급' and S_WEEK= '평일' ;
select * from (select S_TITLE,S_LANNAME, S_LEVEL, S_AREA, S_WEEK, S_PARTTIME, S_COUNT, S_WRITEDAY from S_RESIST order by S_STUDYCODE desc) where S_LEVEL = '초급'