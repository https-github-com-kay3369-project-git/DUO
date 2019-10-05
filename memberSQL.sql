create table member(
id varchar2(10) NOT NULL primary key,
pwd varchar2(20) NOT NULL,
nick_name varchar2(20) not null,
email varchar2(30),
address varchar2(80),
gender varchar2(4) not null,
birth varchar2(10), --date 형식으로 해야하는데 입력 불편해서 일단 var로 했습니다.
phone varchar2(13),
point number not null,
photo varchar2(200),
admin number(1) not null
);

select * from member;

drop table member;

commit;