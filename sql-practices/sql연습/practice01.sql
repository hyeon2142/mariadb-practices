-- Basic Query
use webdb;

-- create
create table pet(
	name varchar(20),
    onwer varchar(20),
    sepecies varchar(20),
    gender char(1),
    birth DATE,
    death DATE
);

-- 테이블 구조
desc pet;

-- 테이블 삭제
drop table pet;

-- 조회
select * from pet;

-- 컬럼 수정
ALTER table pet change sepecies species varchar(20);

-- 데이터 삽입
insert into pet values('김민수','이동현','dog','m','1994-01-02',null);

-- 데이터 삭제 (delete)
delete from pet where name = '김민수';

-- load data local infile
load data local infile 'c:\\pet.txt' into table pet;

-- 조회연습 1 : where
-- 1990년 이후에 태어난 아이들
select name, sepecies, birth from pet
where birth > '1990-00-00';

-- Gwen과 함께 사는 아이들
select name, sepecies, owner from pet
where owner = 'Gwen';

-- null 다루기 1
select name from pet
where death is null;

-- update death
update pet set death = null where name != 'Bowser';

-- like 검색 (패턴 매칭)
select name from pet where name like 'b%';

-- 집계 (통계) 함수
select count(*) from pet;
select count(death) from pet;


