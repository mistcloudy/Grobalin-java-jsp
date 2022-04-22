/* not null : mandatory 필수 , not null 사용하지 않으면
   default : dbms 가 insert 시 자동으로 넣어 주는 값 (초기치) */


create table Usera(
	M_ID VARCHAR2(50) not null primary key, --아이디
	M_MEMCODE VARCHAR2(10) not null, --회원코드, FK
	M_NAME VARCHAR2(50) not null, --이름
	M_PW VARCHAR2(50) not null, --비밀번호
	M_PWC VARCHAR2(50) not null, --비밀번호 확인
	M_PHONE VARCHAR2(20) not null, --핸드폰 번호
	M_EMAIL VARCHAR2(200) not null, --이메일 주소
	reg_date timestamp default current_timestamp
);

show tables;
select * from tab;


