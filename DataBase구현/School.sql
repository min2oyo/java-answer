-- made by 진민

-- 데이터베이스
drop database school; -- 삭제
create database school;	-- 생성
show databases; -- 확인
use school; -- 사용

-- 테이블
drop table student;	-- 삭제
create table student (	-- 생성
	stdNo bigint primary key,	-- 필드.학번
    name varchar(4) not null,	-- 필드.이름
    phNum char(13), -- 필드.연락처
    gender enum("남자", "여자") not null, -- 필드.성별
    regDate datetime default now() -- 필드.등록날짜
);
desc student; -- 구성 확인
select * from student; -- 데이터 보기