create table Member_2(
	M_NAME varchar(50) not null primary key,
	M_ID varchar(60) not null,
	M_PW varchar(15) not null,
	M_PHONE varchar(100) not null,
	M_EMAIL_date varchar(60) not null
);


select * from Member_2;

create sequence Member_2_num_seq;

INSERT INTO Member_2 values('À§¼ºÀº','weeks1866','tjddms','weeks1844@naver.com','010-111-1111');

SQL*Plus desc;