1~10 homework:
--1、向USERS表中插入性别字段，并指定默认值为男
alter table userplus add(sex char(2) default '男');
--2、删除名字是张三的人的信息
delete from userplus where username='张三';
--3、查询USERS表中用户的姓名
select username from userplus;
--4、查询每个用户的工资是多少
select username, salary from userplus;
--5、查看阿三的工资
select salary from userplus where username='阿三';
--6、查询每个用户的年薪
select salary*12 as "年薪" from userplus;
--7、查询用户工资大于2000的用户信息
select * from userplus where salary > 2000;
--8、将 姓名 工资 连接显示
select username||': '||salary as "姓名：工资" from userplus;
--9、查询USERS表中每个用户的名字长度
select username,length(username) from userplus;
--10、查询名字3位以上的用户编号、姓名、工资、工作
select id, username, salary, job from userplus where length(username)>=3;

10~12 homework:
--1、请查询表DEPT中所有部门的情况。
select * from dept;
--2、查询表DEPT中的部门号、部门名称两个字段的所有信息。
select deptno, dname from dept;
--3、请从表EMP中查询10号部门工作的雇员姓名和工资。
select ename, sal from emp where deptno=10;
--4、请从表EMP中查找工种是职员CLERK或经理MANAGER的雇员姓名、工资。
select ename, sal from emp where job in ('CLERK','MANAGER');
--5、请在EMP表中查找部门号在10－30之间的雇员的姓名、部门号、工资、工作。
select ename, deptno, sal, job from emp where deptno between 10 and 30;
--6、请从表EMP中查找姓名以J开头所有雇员的姓名、工资、职位。
select ename, sal, job from emp where ename like 'J%';
--7、请从表EMP中查找工资低于2000的雇员的姓名、工作、工资，并按工资降序排列。
select ename, job, sal from emp where sal<2000 order by sal desc;
--8、在表EMP中查询所有工资高于JONES的所有雇员姓名、工作和工资。
select ename, job, sal from emp where sal>(select sal from emp where ename='JONES');
--9、列出没有对应部门表信息的所有雇员的姓名、工作以及部门号。
select ename, job, deptno from emp where deptno not in(select deptno from dept);
--10、查找工资在1000～3000之间的雇员所在部门的所有人员信息
select * from emp where deptno in (select distinct deptno from emp where sal between 1000 and 3000);
--11、查询所有雇员的姓名、SAL与COMM之和。
select ename, sal, comm, NVL2(comm,comm+sal,sal) from emp;
--12、查询所有在CHICAGO工作的经理MANAGER和销售员SALESMAN的姓名、工资
select ename, sal from emp where deptno=(select deptno from dept where loc='CHICAGO') and job in('MANAGER','SALESMAN');
select a.ename, a.sal from emp a, dept b where a.deptno=b.deptno and b.loc='CHICAGO' and a.job in('MANAGER','SALESMAN');
--13、查询显示每个雇员加入公司的准确时间，按××××年××月××日 时分秒显示。
select ename, to_char(hiredate,'YYYY"年"MM"月"DD"日" HH:MI:SS') from emp;

13~18 homework:
select * from dept
select * from emp
--1.列出至少有一个员工的所有部门。
select deptno from emp group by deptno having count(empno)>=1;
--2.列出薪金比“SMITH”多的所有员工。
select * from emp where sal>(select sal from emp where ename='SMITH');
--3.列出最低薪金大于1500的各种工作。
select distinct(job) from emp group by job having min(sal)>1500;
--4.查询部门20,30 中的岗位不是"CLERK"或"SALESMAN"的所有员工信息
select * from emp where deptno in (20,30) and job not in('CLERK','SALESMAN');
--5.查询比平均员工工资高的员工信息
select * from emp where sal > (select avg(sal) from emp);
--6.找出部门10中所有经理和部门20中所有办事员的详细资料。 
select * from emp where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK');
--7.显示不带有“R”的雇员姓名。 
select ename from emp where ename not like '%R%';
--8.显示雇员姓名，根据其服务年限，将最老的雇员排在最前面。 
select ename, hiredate from emp order by hiredate asc;
--9.对于每个雇员，显示其加入公司的天数 
select ename, trunc(sysdate-hiredate+1) as "天数" from emp;
--10.查询各个职位的平均工资是多少？
select job, avg(sal) from emp group by job;
--11.查看每个部门有多少人
select deptno, count(*) from emp group by deptno;
--12.查看每个职位的平均工资与工资总和
select job, avg(sal),sum(sal) from emp group by job;
--13.查出emp表中所有部门的最高薪水和最低薪水，部门编号为10的部门不显示。
select deptno, max(sal), min(sal) from emp where deptno<>10 group by deptno;
--14.查询出名字中有“A”字符，并且薪水在1000以上（不包括1000）的所有员工信息。
select * from emp where ename like '%A%' and sal>1000;
--15.显示薪水最高人的职位。
select job from emp where sal=(select max(sal) from emp);
select job from emp where sal>=all(select sal from emp);
--16.列出所有员工的年工资,按年薪从低到高排序。 
select ename, sal*12 as "年薪" from emp order by sal;

19~21 homework:
select * from emp;
select * from salgrade;
--1.显示员工表中的不重复的岗位job 
select distinct(job) from emp;
--2.查询10部门工资大于3000的员工信息，要求按员工的入职时间由前到后排序 
select * from emp where deptno=10 and sal>3000 order by hiredate;
--3.列出各个部门的MANAGER 的最低薪金
select deptno,min(sal) from emp where job='MANAGER' group by deptno;
--4.查询所有员工的工作地点，包括没有员工的地点也要显示
select ename,loc from dept d left outer join emp e on d.deptno=e.deptno;
--5.查询所有的员工信息和部门名称，包括不属于任何部门的员工
select empno, ename, dname, e.deptno from emp e left outer join dept d on e.deptno=d.deptno;
--6.列出和"SCOTT"从事相同工作的所有员工及部门名称
select empno, ename, job, dname from emp e,dept d where e.deptno=d.deptno and job=(select job from emp where ename='SCOTT');
--7.列出受雇日期早于直接上级的所有员工的编号，姓名，部门名称
select empno, ename, e.deptno, dname from emp e,dept d where e.deptno=d.deptno and hiredate<(select hiredate from emp m where e.mgr=m.empno);
--8.列出职位为“CLERK”的员工姓名和其所在部门名称，部门人数
select ename, dname, t.b from emp e, dept d, (select deptno,count(*) b from emp group by deptno) t where e.deptno=d.deptno and e.deptno=t.deptno and job='CLERK';
--9.查询至少有4个员工的部门的部门名称
select e.deptno, count(*),dname from emp e, dept d where e.deptno=d.deptno group by e.deptno,dname having count(*)>4;
select d.dname from dept d where deptno in (select deptno from emp group by deptno having count(*)>4);
       --自己写的
select d.deptno, d.dname, t.count from emp e, dept d, (select count(*) count from emp a group by deptno) t where e.deptno=d.deptno and t.count>4;
--10.查询工资高于30号部门的所有员工的工资的员工姓名、工资及部门名称
select ename, sal, e.deptno, dname from emp e,dept d where sal>(select max(sal) from emp where deptno=30);
--11.查询出“KING”所在部门的部门编号、部门名称以及该部门里的员工人数
select e.deptno, dname, count(*) from emp e,dept d where e.deptno=d.deptno and e.deptno=( select deptno from emp where ename='KING') group by e.deptno,dname;
      --自己写的，不太好：
select e.deptno, dname, e.deptno,(select count(*) count from emp where deptno= (select deptno from emp where ename='KING')) from emp e, dept d where e.deptno=d.deptno and ename='KING';
--12.查询平均工资最高的部门的部门编号、部门名称和该部门的平均工资
select e.deptno, d.dname, avg(sal) from emp e, dept d where e.deptno=d.deptno group by e.deptno,d.dname having avg(sal)>=all(select avg(sal) from emp group by deptno);
       --自己写的
select deptno from emp group by deptno having avg(sal)>=all(select avg(sal) from emp group by deptno);
--13.工资等级为2等级的 员工信息及其所在部门的信息
select * from emp e,dept d, salgrade s where e.deptno=d.deptno and s.grade=2 and e.sal between s.losal and s.hisal;
       --自己写的
select e.ename, e.sal from emp e,dept d, (select losal, hisal from salgrade where grade=2) t where e.deptno=d.deptno and e.sal between t.losal and t.hisal;
--14.10号部门的部门信息  人员信息 工资等级
select d.*,e.*,s.grade from emp e,dept d, salgrade s where e.deptno=d.deptno and e.deptno=10 and e.sal between s.losal and s.hisal;
       --自己写的
select ename, sal, (select t.grade from salgrade t where e.sal between t.losal and t.hisal) grade from emp e where deptno=10;
--15.查询最高领导者的薪水等级 
select grade from salgrade where (select sal from emp where mgr is null) between losal and hisal
       --自己写的
select ename, sal, (select t.grade from salgrade t where e.sal between t.losal and t.hisal) grade from emp e where mgr is null;
--16.SQL语句的执行过程及其每条子句的作用？
FROM,WHERE,GROUP BY,HAVING,SELECT,ORDER BY
--17.数据库的运算符类型及优先级？
();算术运算符*,/,+,-;连接符||;比较运算符=, >, <, >=, <=, <>, !=, is null(is not null), between...and..., in;逻辑运算符not, and, or
--18.数据库的函数分类？
DDL,DML,TCL,DQL,DCL
字符,数值,日期,转换
--19.事务的四个特性
原子性    
一致性 
隔离性
持久性

