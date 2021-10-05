-- 집계(통계) SQL 문제입니다.

/*문제 1. 
최고임금(salary)과  최저임금을 “최고임금, “최저임금”프로젝션 타이틀로 함께 출력해 보세요. 두 임금의 차이는 얼마인가요? 함께 “최고임금 – 최저임금”이란 타이틀로 출력해 보세요.*/
select Max(salary) as "최고임금", Min(salary) as "최저임금", Max(salary)-Min(salary) as "최고임금 - 최저임금"
from salaries;

/*문제2.
마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요.
예) 2014년 07월 10일*/
select date_format(Max(hire_date),'%Y년 %m월 %e일')
from employees;


/*문제3.
가장 오래 근속한 직원의 입사일은 언제인가요? 다음 형식으로 출력해주세요.
즉 titles 테이블의 to_date - from_date 값이 가장 큰 사람의 hire_date를 출력
예) 2014년 07월 10일*/

select date_format(Min(hire_date),'%Y년 %m월 %e일')
from employees;
																	


/*문제4.
현재 이 회사의 평균 연봉은 얼마입니까?*/
select avg(salary)
from salaries;

/*문제5.
현재 이 회사의 최고/최저 연봉은 얼마입니까?*/
select Max(salary) as "최고 연봉",Min(salary) as "최저 연봉"
from salaries;

/*문제6.
최고 어린 사원의 나이와 최 연장자의 나이는?*/
select Max(birth_date) as "가장 어린 사원", Min(birth_date) as "최 연장자"
from employees; 
