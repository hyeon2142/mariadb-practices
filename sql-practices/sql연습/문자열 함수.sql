-- 함수 : 문자열 함수

-- uppser
select upper('buSan'), upper('busan'), upper('Douzone');
select upper(first_name) from employees;

-- lower
select lower('buSan'), lower('busan'), lower('Douzone');
select lower(first_name) from employees;

-- substring(문자열, index, length)
select substring('Hello Wolrd', 3, 2);

-- 예제) 1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date
from employees
where hire_date = substring(hire_date, 1, 4);

-- lpad ,rpad
select lpad('1234',10, '-');
select rpad('1234',10, '-');

-- 예제) 직원들의 월급을 오른쪽 정렬 (빈공간은 *)
select lpad(salary, 10, '*') from salaries;

-- trim, ltrim, rtrim
select concat('---', ltrim(' hello '),  '---'),
	   concat('---', rtrim(' hello '),  '---'),
	   concat('---', trim(both ' '  from '  hello  '), '---');

-- pow(x, y), power(x,y) x의 y승
select pow(2,10), power(10,2);

-- sign(x)
select sign(20), sign(-100), sign(0);

-- greatest(x,y, ....), least(x,y, ....)
select greatest(10,40,20,30), least(10,40,20,30);
select greatest('b','A','C'), greatest('hello', 'hellp', 'hellq');

