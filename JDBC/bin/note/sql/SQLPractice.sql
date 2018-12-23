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

--小总结：
--SQL语句的执行过程及其每条子句的作用？
(1)通过FROM子句中找到需要查询的表。
(2)通过WHERE进行非分组函数的筛选判断。
(3)通过GROUP BY子句完成分组操作。
(4)通过HAVING子句完成组函数筛选判断。
(5)通过SELECT子句选择要显示的列或表达式及组函数。
(6)通过ORDER BY子句进行排序操作。

--数据库的运算符类型及优先级？
();
算术运算符*,/,+,-;
连接符||;
比较运算符=, >, <, >=, <=, <>, !=, is null(is not null), between...and..., in;
逻辑运算符not, and, or

--数据库的函数分类？
单行函数：CONCAT(c1,c2), LENGTH(ch), UPPER(字段名), LOWER(字段名), INITCAP(字段名), TRIM('e'FROM'ee'), LTRIM('ee','e'), RTRIM('ee','e'), LPAD(ch1, m, ch2), RPAD(ch1, m, ch2), SUBSTR（ch,m,n), INSTR(ch1,ch2,m,n)
数值函数：ROUND(n,m), TRUNC(n,m), MOD(m,n), CEIL(n), FLOOR(n)
日期函数：sysdate, systimestamp, LAST_DATE(date), ADD_MONTHS(date,i), MONTHS_BETWEEN(date1,date2), LEAST(date1,date2), GREATEST(date1,date2), EXTRACT(date from datetime)聚合函数：count(),avg(),sum(),max(),min(),
转换函数：
        显示转换：TO_DATE(), TO_CHAR()
        隐式转换：其它类型与字符串连接通常会转换为字符串。
通用函数：NVL(), NVL2()
多行函数(聚合函数)：MAX()最大值, MIN()最小值, SUM()求和, AVG()平均值, COUNT()统计

--结构化查询语言分类和作用？
SQL分类：
		DDL：数据定义语言，用于操作数据对象（表，视图，序列，索引）。
				CREATE：创建表或其它对象。
				ALTER：修改表或其它对象结构。
				DROP：删除表或其它对象。
				TRUNCATE：删除表数据，保留表结构。清空表的操作。
		DML：数据操作语言（通常需要伴随TCL），用于增删改表中的数据。
				INSERT INTO：将数据插入表中。
				DELETE：删除表中数据。
				UPDATE SET：更新表中数据。
		TCL：事务控制语言。
				COMMIT：提交。
				ROLLBACK：回滚。
		DQL：数据查询语言
				SELECT：查询数据。
		DCL：数据控制语言。
				GRANT：授予权限。
				grant…create…view…to…scott;
				
--事务的特性？
原子性(Atomicity):
　	原子性是指事务包含的所有操作要么全部成功，要么全部失败回滚。因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。
一致性(Consistency):
	一致性是指一个事务执行之前和执行之后都必须处于一致性状态。拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还得是5000，这就是事务的一致性。
隔离性(Isolation):
　　隔离性是当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离。
持久性(Durability):
　　持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。

--Oracle数据库自带语法和通用标准的SQL99语法？
Oracle数据库自带语法：
	(1)笛卡儿积：
	(2)内连接：a.等值连接
			   b.非等值连接:输出员工编号、姓名、工资、工资等级：select e.empno, e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal;
			   c.左外连接：select empno, ename, dname from emp e, dept d where e.deptno=d.deptno(+);--查询员工的编号，姓名，部门名称，包括不属于任何部门的员工。
			   d.右外连接：select empno, ename, dname from emp e, dept d where e.deptno(+)=d.deptno;--查询员工的编号，姓名，部门名称，包括没有员工的部门。
			   e.自连接：
通用标准的SQL99语法：
	(1)交叉连接：交叉连接和笛卡尔积的连接模式相同，都是表1中的每一行都与表2中的所有行建立一次连接。select * from emp cross join dept;
	(2)自然连接：select * from emp natural join dept;--若能够匹配到等值条件（外键约束或相同的列），那么就是等值连接的结果.根据dept进行等值连接。
				select * from emp natural join salgrade;--若不能匹配到等值条件，那么结果就是交叉连接。
	(3)左外连接：left outer join
	(4)右外连接：right outer join
	(5)全外连接：full outer join
	
--数据中的约束？
主键约束：primary key 不能为空，必须唯一。
非空约束：not null 
唯一约束：unique
检查约束：check(条件) 在MySql中是可以写的，但MySql会直接忽略检查。price number(10,2) check(price>100),--检查约束，在创建表的时候直接写(和primary key, not null, unique一个位置或之后)
外键约束：主要是用来约束从表A中的记录必须是存在于主表B中(保证数据完整性)。
	(1)references 外表名(外表的列名), --在创建表的时候直接写(和primary key, not null, unique, check一个位置或之后)
	(2)foreign key(自己的列名) references 外表名(外表的列名)--另一种外键约束的方式，写在最后一个括号的前面
	(3)alter table books add foreign key(cid) references category(id);--可以不在定义表中建立外键约束，单独用此语句也可实现外键约束。

--用一条sql语句查出emp表中工资从大到小排在4，5，6位工资？
select * from (select rownum rn, e.* 
from (select ename, sal from emp order by sal desc) e where rownum<=6)t 
where t.rn >=4;