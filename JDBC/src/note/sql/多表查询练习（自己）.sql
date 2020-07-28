--1.列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门
select dname, e.* from dept d left outer join emp e on d.deptno=e.deptno;
--2.列出在每个部门工作的员工数量、平均工资。
select count(ename), avg(sal) from emp e right outer join dept d on d.deptno=e.deptno group by d.deptno;
--3.列出所有员工的姓名、部门名称和工资。
select ename, dname, sal from emp e, dept d where e.deptno=d.deptno;
--4.查询每个部门的部门编号，部门名称，部门人数，最高工资，最低工资，工资总和，平均工资
select d.deptno, dname, count(*), max(sal), min(sal), sum(sal), avg(sal) from emp e, dept d where d.deptno=e.deptno group by d.deptno, dname;
--5.查询每个经理所管理的人数，经理编号，经理姓名，要求包括没有经理的人员信息。
select count(e.ename), m.empno,m.ename from emp e left join emp m on e.mgr=m.empno group by m.empno,m.ename
--6.查询部门人数大于2的部门编号，部门名称，部门人数
select d.deptno, d.dname, count(*) from emp e, dept d where e.deptno=d.deptno group by d.deptno, d.dname having count(*)>2;
--7.查询部门平均工资在2500元以上的部门名称及平均工资。
select d.dname, avg(sal) from emp e, dept d where e.deptno=d.deptno group by d.dname having avg(sal)>2500;
--8.查询员工岗位中不是以"SA"开头并且平均工资在 2500元以上的岗位及平均工资，并按平均工资降序排序。
select job, avg(sal) from emp where job not like 'SA%' group by job having avg(sal)>2500 order by avg(sal) desc
--9.显示经理号码和经理姓名，这个经理所管理员工的最低工资，没有经理的KING也要显示，
--不包括最低工资小于3000的，按最低工资由高到低排序。
select m.empno, m.ename, min(e.sal) from emp e left outer join emp m 
on e.mgr=m.empno group by m.empno, m.ename having min(e.sal)>=3000 order by min(e.sal) desc;
--10.查询部门平均工资大于2000，且人数大于2的部门编号，部门名称，部门人数，部门平均工资，并按照部门人数升序排序。
select d.deptno, d.dname, count(*), avg(sal) from emp e, dept d 
where e.deptno=d.deptno group by d.deptno, d.dname 
having count(*)>2 and avg(sal)>2000 order by count(*);
--11.查询部门最低工资 高于10号部门 最低工资的部门的编号、名称及部门最低工资。
select d.deptno, dname, min(sal) from emp e, dept d where d.deptno=e.deptno group by d.deptno, dname 
having min(sal)>(select min(sal) from emp where deptno = 10);
--12.显示30号部门的雇员所从事的不重复的工作名称，并显示30部门的所在地。
select distinct job, d.loc from emp e, dept d where d.deptno=e.deptno and e.deptno=30;
--13.查询工作在'CHICAGO'的员工人数，最高工资及最低工资。
select count(empno),max(sal),min(sal) from emp e, dept d where d.deptno=e.deptno and loc='CHICAGO';
--14.统计各个部门不同职务的员工薪水的总和，平均工资,部门编号，部门名称,部门位置，职务
select sum(sal),avg(sal),d.deptno,dname,loc, job from emp e, dept d where d.deptno=e.deptno group by d.deptno,dname,loc, job;
