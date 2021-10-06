-- 서브쿼리(SUBQUERY) SQL 문제입니다.

/*문제1.
현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?*/
select count(*) as "직원 수"
from salaries
where to_date = '9999-01-01' and salary > (select avg(salary)
				from salaries
                where to_date='9999-01-01'
                );
                
/*문제2. 
현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다.*/
select e.emp_no,concat(first_name,' ',last_name) as 이름,dept_no,salary
from employees e,salaries s,dept_emp d
where e.emp_no = s.emp_no and e.emp_no = d.emp_no and s.to_date = '9999-01-01' and salary in (
																	select max(salary)
																	from employees e,dept_emp d,salaries s
																	where e.emp_no = d.emp_no and e.emp_no = s.emp_no
																	group by dept_no
                                                                    )
order by salary desc;                                                                    
                       

/*문제3.
현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요.*/
select e.emp_no,concat(first_name,' ',last_name) as name,salary
from employees e,salaries s
where e.emp_no = s.emp_no and s.to_date = '9999-01-01' and salary > any ( select avg(salary)
										 from salaries s,dept_emp d
                                         where s.emp_no = d.emp_no
                                         group by dept_no);



/*문제4.
현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.*/

/*문제5.
현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.*/

/*문제6.
평균 연봉이 가장 높은 부서는?*/

/*문제7.
평균 연봉이 가장 높은 직책?*/

/*문제8.
현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.*/

