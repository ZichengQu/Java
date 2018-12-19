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





