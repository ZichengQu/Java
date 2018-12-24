数据库//297，308,415
一、	使用sqlplus连接数据库
	1.	方式：
	1）	sqlplus，回车，输出用户名和密码
	2）	sqlplus/nolog  ------conn scott/tiger
	3）	使用可视化界面，developer。注意：使用窗口连接可视化工具却不能连接，会出现无服务或无监听错误，需要重新配置监听。（a.关闭服务。 b.根据配置监听文件修改HOST为当前IP，或修改为localhost，或127.0.0.1，或主机名。 c.再开启服务重新连接登陆即可。）
	2.	命令窗口注意事项：
	1）	所有sql语句以“;”结尾，回车执行。
	2）	sql语句不区分大小写，字符串除外。
	3.	Oracle用户（oracle安装后会自动生成4个账户）：
	1）	sys用户：超级用户，具有最高权限，具有sysdba（数据库管理员）角色，有数据字典和视图权限，能创建数据库，默认密码manager。
	2）	system用户：操作员，仅次于超级用户，具有sysoper(系统操作员)角色。不能创建库。
	4.	DB：Database数据库，关系型数据库，按照数据结构来管理数据的仓库，以二维表(列：字段； 行：数据)的形式存储数据。
	DBMS：数据库管理系统（Oracle, mysql, sqlserver…）
二、	sql语句
	1.	SQL （Structed Query Language,结构化查询语言）
	2.	SQL分类：
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
	3.	数据类型：
		char(n)：定长字符串，n是字节数。最多2000字节。
		varchar2(n):变长字符串，n是字节数。最多4000字节。
		number(n,m):n共多少位数字，m是其中几位小数。
		date:时间日期，select sysdate from dual;
三．SQL（DDL， DML，TCL，DQL）
软件的构成？
	1.前端：HTML，CSS，JS，JQuery
	2.后台：Java
	3.数据库：Oracle， Mysql（被甲骨文收购）

1.安装Oracle

  常用用户：
    sys：超级用户  具有最高权限  具有sysdba角色 （数据库管理员）
         有创建数据库的权限 
    system：管理操作员  权限仅次于超级管理员   

    scott:普通用户 一般用于练习    scott -- tiger
	解锁用户：alter user scott account unlock
	设置密码：alter user scott identified by tiger
   
2.登录方式
  1）sqlplus 回车
     输入用户名
     输入密码

  2）sqlplus/nolog
     conn scott/tiger

3.  DB：DataBase 按照数据结构来管理数据的仓库(关系型数据库),以二维表形式存储数据(表的列：字段名  表的行：数据)
    DBMS：数据库管理系统(mysql、oracle、SqlServer)
	
4.常用命令
    sqlplus  打开数据库
    conn  用户名/密码    连接数据库
    show user; 显示当前用户
    exit;  断开连接
    quit;  断开连接
	
5.SQL:结构化查询语言
  SQL的分类：
	  DDL 数据定义语言  用于操作数据对象（表 视图 序列 索引）
	  DML 数据操作语言  用于增删改表中的数据(通常伴随事务)
	  TCL 事务控制语言  用于数据的提交和撤销
	  DQL 数据查询语言  用于查询数据记录
	  DCL 数据控制语言  用于执行权限分配
	  
	  DDL：数据定义语言
		   ---用于操作数据库对象（表 视图 序列 索引）
		   CREATE：用来创建表或其他对象
		   ALTER：修改表或其他对象的结构
		   DROP：删除表或其他对象的结构
		   TRUNCATE：清空表(删除表中数据，保留表结构) 
	  DML：数据操作语言
		   ---用于增删改表中的数据(通常伴随事务控制语言)
		   INSERT INTO：将数据插入到表中
		   DELETE：删除表中数据 ---- WHERE
		   UPDATE 表名 SET：更新表中数据 --- WHERE
		   
      TCL：事务控制语言
		   COMMIT：提交--保存
           ROLLBACK：回滚---后退
   
      DQL：数据查询语言
           SELECT 查询*****

      DCL：数据控制语言
           用来执行权限分配 GRANT REVOKE
6.DDL 数据定义语言
	查看用户定义的表：
		SELECT table_name FROM user_tables;--用户定义的所有表都会被列出来
	(1)创建表
		CREATE TABLE 表名 (
			列名(字段名)  数据类型 [默认值  约束],
			列名(字段名)  数据类型 [默认值  约束],
			列名(字段名)  数据类型 [默认值  约束],
			列名(字段名)  数据类型 [默认值  约束]
		);
		CREATE TABLE users(
			id number(10) primary key,
			name varchar2(20) not null unique,
			salary number(10,2),
			create_time date default sysdate
		);
		id(主键) 特点：该列在整张表中每一行所保存的值都不相同，且必须有值（非空且唯一）
		命名规则：
			表名和列名：
			1）必须以字母开头
			2）必须在1-30个字符之间
			3）必须只能包含A-Z,a-z,0-9,_,$,和#
			4）必须不能和用户定义的其他对象重名
			5）必须不能是Oracle的保留字
		数据类型:
			1）NUMBER:数值类型
			   NUMBER(X):x代表位数  
						 NUMBER(3)  最多能存放3位数
			   NUMBER(X,Y):x表示共几位  y表示其中有几位是小数
						   NUMBER(6,2) 8888.88
			2）CHAR:定长字符串
			   CHAR(X):X表示共占多少字节   最多放2000字节
			3）VARCHAR2:变长字符串
			   VARCHAR2(X):X表示共占多少字节(根据其中保存的数据长度，占用的空间是变化的)  最多4000字节
			4）DATE 时间日期 SELECT SYSDATE FROM DUAL;
			伪表：dual确实是一张表，是一张只有一行一列的表，习惯上称为伪表，因为它不存储具体的数据。
		查看表结构(在command window)：DESC table_name;
	(2)删除表：
		DROP TABLE users;--删除表数据和结构
		TRUNCATE TABLE users;--删除表数据，保留表和表结构
	(3)修改表(ALTER):
		修改表名：RENAME old_name TO new_name
		修改表结构：
			向表中添加字段（只能添加到最后，不能插入到现有的序列中）：ALTER TABLE table_name ADD(字段名，数据类型[默认值 约束]), 例如：ALTER TABLE usersplus ADD(school varchar2(20))
			删除表中已有字段： ALTER TABLE biaoming DROP(字段名），例如：ALTER TABLE userplus DROP(school）
			修改表中已有字段的格式：ALTER TABLE 表名 MODIFY(字段名，数据类型[默认值 约束])，例如：ALTER TABLE userplus MODIFY(salary number(10))
			修改表中字段名称：ALTER TABLE userplus RENAME column name to username
7.DML 数据操作语言
	(1)向表中添加数据：
		全字段插入数据：INSERT INTO 表名 VALUES(1, '张三', 8000,sysdate, '程序员'); 注意：values中的数据顺序要和定义字段时一致。
		部分字段插入数据：INSERT INTO 表名(想要插入数据的字段)VALUES(与字段顺序相对应的数据)。
	(2)修改表中已有数据：
		在修改表中数据时，通常添加where子句来限定要修改的记录，这样就只能修改满足where条件的记录。否则修改全表。
		UPDATE 表名 SET 字段名=数据 WHERE 字段名=数据
	(3)删除表中数据：
		DELETE FROM 表名 WHERE 字段名=数据。通常与where子句连用，否则删除表中所有数据。
		在DDL语句中的TRUNCATE语句同样有删除表数据的作用。
		TRUNCATE和DELETE的区别：DELETE可以有条件的删除数据，但TRUNCATE将表中的数据全部删除；DELETE是DML语言，可以rollback，TRUNCATE是事务控制语言，立即生效，无法rollback.
		删除全部记录：DELETE FROM userplus(效率低); TRUNCATE TABLE userplus(效率高).
8.TCL：事务控制语言
	(1)commit:提交； 可以通过语句或按钮去提交，或者正常关闭数据库时会默认提交。
	(2)rollback：回滚；
	事务的四个特性：
		原子性(Atomicity):
　	　		原子性是指事务包含的所有操作要么全部成功全部应用，要么全部失败回滚。因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。
		一致性(Consistency):
			一致性是指一个事务执行之前和执行之后都必须处于一致性状态。拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还得是5000，这就是事务的一致性。
		隔离性(Isolation):
　　		隔离性是指多个并发事务之间要相互隔离。当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰。
		持久性(Durability):
　　		持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。
9.DQL：数据查询语言
	基本查询语句由SELECT子句和FROM子句组成。
	SELECT：指定显示的字段名称； FROM：指定数据来源。
	(1)查询所有：SELECT * FROM 表名;
	(2)查询部分数据信息：SELECT field1, field2 FROM table_name where 限定条件;
	注意：SELECT可以显示字段，表达式，函数， <>是不等于。若函数名称较长，不利于查询结果的列名显示，可以起列别名。
	      SELECT salary*12 "年薪" FROM userplus WHERE username='王五';--别名
		  SELECT salary*12 AS "年薪" FROM userplus WHERE username='王五';--别名
		  别名不能以数字开头，若以数字或符号开头，别名需要用""括上。
10.常用函数(单行函数):4
	(1)字符串函数：13
		CONCAT(c1,c2),连接字符串，将c1,c2两个字段拼接显示。例如：SELECT CONCAT(CONCAT(ename, ': ') ,sal)from EMP;
		||连接多个字符串符号。例如：SELECT ename||': '||sal as "姓名：工资" from EMP;
		LENGTH(ch):显示字符串长度， 例如：SELECT LENGTH(ename) from EMP;
		UPPER(字段名)：转大写
		LOWER(字段名): 转小写
		INITCAP(字段名): 只有首字母大写
		TRIM():去除字符串前后指定内容。例如（右侧写字符串）：SELECT TRIM('E' from 'EEHELLO WORLDEEE') from dual; SELECT ename, trim('A' FROM ename) from emp; --去除员工名字前后的'A'
		LTRIM('',''):去除字符回串左侧指定内容。例如（左侧写字符串）：SELECT LTRIM('EEHELLO WORLDEEE', 'E') from dual;
		RTRIM('',''):去除字符串右侧指定内容。
		LPAD(ch1, m, ch2): 左补位函数，ch1是要查询显示的内容，m指定位数，数据位数不足时由ch2进行补位。在emp表中使用左补位，将sql用0补齐6位。例如：select ename, LPAD(sal, 6, 0) AS salary from emp
		RPAD(ch1, m, ch2): 右补位函数。
		SUBSTR（ch,m,n):截取字符串，截取ch这个字符串，从m开始截取，共截取n个，若m为负数，则是从后向前进行下标查询，从而进行截取。
		INSTR(ch1,ch2,m,n):查找ch1中ch2出现的位置，m代表从哪个位置开始检索，n代表第几次出现，不指定m和n，默认值都是1。下标从1开始，无匹配数据的时候返回0.
	(2)数字函数：5
		ROUND(n,m):用于四舍五入，参数中的n可以是任何数字(要被处理的数字);m必须是整数，m取整数则四舍五入到小数点后第m位，m取0则四舍五入到整数位(m缺省，默认是0)，m取负数则四舍五入到小数点前m位。
		TRUNC(n,m):截取数字没有四舍五入
		MOD(m,n):返回m除以n后的余数，n为0则直接返回m。
		CEIL(n):向上取整，大于该数的最小整数。
		FLOOR(n):向下取整，小于该数的最大整数。
	(3)日期函数:11
		sysdate:返回当前的系统时间，精确到秒。
		systimestamp:时间戳，返回当前系统日期和时间，精确到毫秒。
		(1)TO_DATE():日期转换函数，相当于Java中的SimpleDateFormat的parse()方法，将给定的字符串按照给定的日期格式转换为Date。
			select to_date('2018-12-01 11:30','YYYY-MM-DD HH:MI:SS') from dual;
			select to_date('2018-12-01 13:30','YYYY-MM-DD HH24:MI:SS') from dual;     
		(2)TO_CHAR():用于将DATE按照给定的日期格式转换为字符串。
			select ename, to_char(hiredate,'YYYY-MM-DD HH:MI:SS') from emp;
			select ename, to_char(hiredate,'YYYY"年"MM"月"DD"日"') from emp;
		(3)LAST_DAY(date):返回指定日期所在月的最后一天。
		(4)ADD_MONTHS(date,i):返回日期date加上i个月后的日期值，若i是负数，则获得的是减去i个月后的日期值。
		(5)MONTHS_BETWEEN(date1,date2):计算两个日期之间相差多少个月;若date2时间比date1时间晚，会得到负值，除非两个日期间隔是整数月，否则会得到带小数位的结果。
		(6)date日期类型在数据库中可以进行减法操作，结果是相差的天数：select ename, sysdate-hiredate from emp;
		(7)LEAST(date1,date2):显示两个时间中的最小值。参数类型必须一致。
		(8)GREATEST(date1,date2):显示两个时间中的最大值。参数类型必须一致。
		(9)EXTRACT(date from datetime):从参数datetime中提取参数date指定的数据，比如提取：年、月、日。
	(4)空值函数：2
		null的含义：有时表中的某些字段值数据未知或暂时不存在，取值null。在Java中引用类型的默认值为null，在sql中，任何数据类型均可取值为null。
		null条件查询:不等于任何值， is null 和 is not null.
		NVL(arg1,arg2):将null转变为非null值。如果arg1为null，返回arg2；否则返回本身。arg1和arg2可以是任何参数类型，但两个参数的数据类型必须是一致的。
		NVL2(arg,res1,res2):如果arg为null，则返回res2,arg不为null则返回res1.
11.基本查询语句
	(1)from子句:select * from table_name;select用于指定要查询的列，from指定要从哪个表中查询。
	(2)where子句:在select语句中可以在where子句中使用比较操作符限制查询结果。
12.查询条件
	(1)比较运算符：>,<,>=,<=,<>,=
	(2)关键字：AND(并且),OR(或)，AND优先级高于OR，可以使用()来提高OR的优先级顺序。
	(3)模糊查询
		LIKE：可以模糊匹配字符串;
			  _代表任意一个字符,%代表任意0~n个字符。
	(4)IN和NOT IN：
		IN(list):取出列表范围中的数据。
		NOT IN(list):取出不符合此列表中的数据记录。
	(5)BETWEEN...AND...:是用来查询符合某个值域范围条件的数据。
	(6)ALL和ANY: ALL和ANY不能单独使用，需要配合单行比较操作符(>,<,>=,<=,<>,=)一起使用。
		>ANY:大于最小
		<ANY:小于最大
		>ALL:大于最大
		<ALL:小于最小
	(7)DISTINCT():去除重复：select distinct(deptno) from emp; 去除组合的重复：select distinct deptno,job from emp;
13.运算符优先级
	();
	算术运算符*,/,+,-;
	连接符||;
	比较运算符=, >, <, >=, <=, <>, !=, is null(is not null), between...and..., in;
	逻辑运算符not, and, or
	BETWEEN...AND...和AND的区别：
		BETWEEN...AND...:只能用来比较一个字段值
		AND:可以用来比较不同的字段
14.ORDER BY：排序，对结果集的排序，必须出现在select的最后一个子句。
			asc或不写：升序；desc：降序。若排序的字段中包含null，则看作是最大值。
			当以多列作为排序标准时，首先按照第一列进行排序，如果第一列数据相同，再以第二列排序，以此类推。
15.聚合函数(多行函数，分组函数)
	(1)MAX和MIN:用来取得列或表达式的最大、最小值。可以用来统计任何数据类型，包括数字、字符和日期。忽略NULL值。
	(2)AVG和SUM:用来统计列或表达式的平均值和总和，只能操作数字类型，忽略NULL值。
	(3)COUNT:用来计算表中的记录条数。忽略NULL值。
	(4)聚合函数对NULL值的处理：聚合函数忽略NULL值，select count(comm)，avg(comm) from emp;--自动忽略comm为null的记录;
								如果不希望忽略NULL值，则需要使用NVL或NVL2:select count(nvl(comm,0)), avg(nvl(comm,0)) from emp;
16.GROUP BY:分组。将结果集按照指定字段进行分组。分组规则：该字段下的值一样的记录被看做一组。
			如果select里面出现了聚合函数，同时又出现了某一字段时，那么该字段必须出现在group by子句中。
			where后面不能使用聚合函数,因为where是非分组函数的过滤判断。select max(sal),deptno from emp where max(sal)>4000 group by deptno;--不能执行
	HAVING:是分组（聚合）函数的过滤判断;必须跟在GROUP BY之后，不能单独存在;用来对分组后的结果进一步限制;比如按部门分组后，得到每个部门的最高工资，可以继续限制输出结果。
			查询部门中最大工资超过4000的部门以及最大工资:select max(sal),deptno from emp group by deptno having max(sal)>4000;
17.SELECT语句执行过程：
	(1)通过FROM子句中找到需要查询的表。
	(2)通过WHERE进行非分组函数的筛选判断。
	(3)通过GROUP BY子句完成分组操作。
	(4)通过HAVING子句完成组函数筛选判断。
	(5)通过SELECT子句选择要显示的列或表达式及组函数。
	(6)通过ORDER BY子句进行排序操作。
18.函数总结
	单行函数和多行函数的分类并举例说明：
		单行函数：
			字符函数13：CONCAT(c1,c2), LENGTH(ch), UPPER(字段名), LOWER(字段名), INITCAP(字段名), TRIM('e'FROM'ee'), LTRIM('ee','e'), RTRIM('ee','e'), LPAD(ch1, m, ch2), RPAD(ch1, m, ch2), SUBSTR（ch,m,n), INSTR(ch1,ch2,m,n)
			数值函数5：ROUND(n,m), TRUNC(n,m), MOD(m,n), CEIL(n), FLOOR(n)
			日期函数9：sysdate, systimestamp, LAST_DATE(date), ADD_MONTHS(date,i), MONTHS_BETWEEN(date1,date2), LEAST(date1,date2), GREATEST(date1,date2), EXTRACT(date from datetime)
			转换函数：
				显示转换：TO_DATE(), TO_CHAR()
				隐式转换：其它类型与字符串连接通常会转换为字符串。
			通用函数2：NVL(), NVL2()
			注意：通常用于操作单行数据，可以任意嵌套多层，多层时由内向外依次执行。
		多行函数(聚合函数)5：MAX()最大值, MIN()最小值, SUM()求和, AVG()平均值, COUNT()统计
19.关联查询：
	(1)概念：实际应用中所需要的数据，经常会需要查询两个或两个以上的表，这种查询叫做连接查询，连接查询通常建立存在相互关系的父子关系。
	(2)外键：保存另一张表主键的列称为外键。含有外键的表，在关联关系中属于多的一方。
	(3)表与表之间的关系：一对多(外键)，多对多(通过第三张表建立关系)，一对一。
	(4)N张表的关联查询最少需要(N-1)个连接条件;等值连接：外键=主键;若不指定连接条件，会出现笛卡尔积(指做关联操作的每个表的每一行和其它表的每一行做组合，是无意义的结果集)。	
	(5)总结：
			可以给表起别名，通过别名指定字段属于哪个表；若两个表字段名称相同则必须指明数据来源。
			只有满足连接条件的结果，才会被查询出来。(比如deptno40里没有人，因此不会被显示出来)。
			若有过滤条件，需同时满足连接条件和过滤条件的数据才会被查询出来。
20.连接种类：
	?内连接：返回所有满足连接条件的记录，功能上和等值连接没有区别，只是写法不同。
			语法：表1 INNER JOIN 表2 ON 连接条件;(INNER可以省略)
	外连接：返回满足连接条件的数据记录，有些情况下需要返回那些不满足连接条件的记录，需要使用外连接。将满足和不满足连接条件的结果全部查询出来。
			create table empc as select * from emp;--快速从一个表中复制数据
			insert into empc(empno, ename, deptno)values(1000,'JACK',50);
	左外连接：(左表的全部，右表的部分)根据左表的记录，在被连接的右表中找出符合条件的记录与之匹配，如果找不到与左表匹配的用null表示。
				语法：表1 LEFT OUTER JOIN 表2 ON 连接条件;(OUTER可以省略)
	右外连接：(右表的全部，左表的部分)根据右表的记录，在被连接的左表中找出符合条件的记录与之匹配，如果找不到与右表匹配的用null表示。
				语法：表1 RIGHT OUTER JOIN 表2 ON 连接条件;(OUTER可以省略)
	全外连接：返回符合条件的所有表的记录，没有与之匹配的，用null表示(结果是左连接和右连接的并集)。
				语法：表1 FULL OUTER JOIN 表2 ON 连接条件;(OUTER可以省略)
	?自连接：连接的两个表都是同一个表，表中的一个字段可以对应当前表的其它字段。
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
21.子查询：
	为了给查询提供数据而首先执行的查询语句叫做子查询。子查询是嵌入在其它SQL语句中的SELECT语句。子查询嵌入的语句称作主查询或父查询。
	注意事项：
		(1)子查询需要写在括号中。
		(2)子查询需要写在运算符的右端。
		(3)子查询可以写在WHERE，HAVING，FROM子句中。
		(4)子查询中通常不写ORDER BY。
	子查询在WHERE子句中：根据返回结果的不同，子查询分为单行子查询，多行子查询及多列子查询。
		(1)单行子查询：返回一行一列数据，要求使用单行操作符(>,>=,<,<=,<>,=)
		(2)多行子查询：返回多行数据，使用多行操作符(in,all,any)
		(3)多列子查询: 通常用于建立在二次查询，常出现在FROM子句中。
					统计低于自己工资低于所在部门平均工资的员工信息：
						a.分组统计部门平均工资：select avg(sal) aa, deptno from emp group by deptno
						b.员工工资小于<部门平均工资：select sal, ename, e.deptno from emp e, (select avg(sal) aa, deptno from emp group by deptno) t where e.deptno=t.deptno and e.sal<aa;						
		(4)EXISTS关键字：在子查询中需要引用到主查询的字段数据，使用EXISTS关键字。若EXISTS后边的子查询至少返回一行数据，则整个条件返回true。		 
						select deptno, dname from dept d where EXISTS (select * from emp e where e.deptno=d.deptno);--EXISTS关键字：列出来那些有员工的部门部门信息
	子查询在HAVING子句中
22.分页查询：
	找到员工表中工资最高的前三名（降序排序）：select * from emp order by sal desc;
	select rownum, t1.* from (select * from emp order by sal desc) t1 where rownum <=3;
	ROWNUM:伪列，系统自动生成的一列，用来表示行号;
		ROWNUM是ORACLE中特有的用来表示行号，默认值或起始值是1，在查询出结果后，再自加一。在ORACLE中只能使用子查询。MySql中分页方法简单。
		/*查询第6~10条记录,两种方法*/ select * from (select rownum rn, e.* from emp e) t where t.rn between 6 and 10;
									  select t1.* from (select rownum rn,emp.* from emp where rownum<=10) t1 where rn between 6 and 10;
		/*工资降序后选6~10条记录：原表先降序，再加伪列，再当新表选范围*/
		select * from (select rownum rn, e.* from (select * from emp order by sal desc) e) t where t.rn between 6 and 10;
		select * from(select rownum rn, e.* from (select * from emp order by sal desc)e where rownum<10) where rn>=6;
		页码：page，每页最多pageSize为5，第一页1~5，第二页6~10，第三页11~15. start=(page-1)pageSize+1; end=pageSize*page;
23.DECODE函数
	DECODE(参数1，值1，结果1，值2，结果2...[,默认值]);用参数依次去和值匹配，匹配到了则显示相应的结果;无匹配则显示默认值，默认值不存在则显示null(相当于Java中的switch)。
	--查询职员表，根据职员的职位计算奖励金额，当职位分别是'MANAGER','SALESMAN','ANALYST'时，奖励金分别是薪水的1.2,1.1,1.05倍，其它为原本的薪水值。
	select ename, job, sal, decode(job,'MANAGER',sal*1.2,'SALESMAN',sal*1.1,'ANALYST',sal*1.05,sal) "奖金" from emp;
	select * from emp order by decode(job,'MANAGER','1','SALESMAN','2','ANALYST','3');--自定义排序
24.集合函数
	(1)UNION并集：将两个查询结果进行排序。union(忽略重复数据，并排序), union all(不忽略重复数据，不排序);
		select * from emp where sal>1500 union select * from emp where deptno=20;--并集之后，总共9条记录
	(2)INTERSECT交集：同时存在于两个结果集中的数据。
	(3)MINUS差集：两个结果相减。
	(4)使用集合函数的原因：所有的查询结果可能不是来自同一张表，并且表与表之间无关联。
	(5)注意事项：a.对应的列的类型需要匹配。
				 b.列的类型要按照顺序写。
				 c.列的数量要一致，如果不一致时，用null去补充不匹配的列。
25.DDL语句管理表：
	(1)创建表空间：逻辑单位，通常我们新建一个项目，就会新创建表空间，在表空间中创建用户来创建表。
		先切换到system，语法：CREATE tablespace 表空间名称 datafile '文件的路径' size 大小 autoextend on 自动拓展 next 每次扩展的大小;
	(2)删除表空间：drop tablespace 表空间名称
	(3)创建用户：create user 用户名 identified by 密码 default tablespace 表空间的名称;
	(4)删除用户：drop user 用户名 cascade;
	(5)更改用户密码：alter user 用户名 identified by 密码;
	(6)授权：grant connect to 用户名;
	(7)分配角色：grant dba to 用户名;
	(8)使用子查询的方式创建表(切换完了新创建的用户之后）：
	只复制表结构和表数据，不会复制列的约束：create table emp as select * from scott.emp;--
	如果查询语句有结果，就是复制表结构和数据，如果没有结果，就是复制表结构：create table dept as select * from scott.dept where 1=2;--只复制表结构，无数据,因为1=2为false。
	只复制表数据(添加语句里可以没有values关键字):insert into 表名 查询语句 (表的结构与已有表结构一致):insert into dept select * from scott.dept;
26.列的约束：约束主要是用来约束表中数据的规则。
	主键约束：primary key 不能为空，必须唯一。
	非空约束：not null 
	唯一约束：unique
	检查约束：check(条件) 在MySql中是可以写的，但MySql会直接忽略检查。price number(10,2) check(price>100),--检查约束，在创建表的时候直接写(和primary key, not null, unique一个位置或之后)
	外键约束：主要是用来约束从表A中的记录必须是存在于主表B中(保证数据完整性)。
		(1)references 外表名(外表的列名), --在创建表的时候直接写(和primary key, not null, unique, check一个位置或之后)
		(2)foreign key(自己的列名) references 外表名(外表的列名)--另一种外键约束的方式，写在最后一个括号的前面
		(3)alter table books add foreign key(cid) references category(id);--可以不在定义表中建立外键约束，单独用此语句也可实现外键约束。
27.视图：数据库对象之一，视图在sql语句中体现的角色和表完全相同，但视图并不是一个真实存在的表，它对应的是一个查询语句的结果集（视图名和表名不能一样）。
	作用：简化复杂查询，可以限制数据访问。
	(1)创建简单视图（单表）：若无权限，使用system用户授权，视图授权语句：grant create view to 用户名。
							create view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10;
	(2)修改视图就是替换该视图的子查询，使用create or replace view 视图名 即可，若视图不存在就创建，存在就替换。创建视图时，可以给列赋予别名。
							create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10;
	(3)查询视图：列名若有别名，以别名为准，不是原列名。select * from v_emp_10;
	(4)视图的DML操作(不建议)：对视图进行DML操作就是对视图数据来源的基础表进行操作。
		a.插入数据：视图中看不见的字段都被插入默认值，所以不能违反基础表中相应字段的约束（比如看不见的字段的not null等约束，否则会插入失败）。
		b.为视图添加检查选项可以避免对视图进行DML操作时污染基础表的情况，在创建语句后加with check option
			create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10 with check option;--不能对基础表中deptno10以外的数据进行DML操作。
		c.with read only：只读，不能对视图进行DML操作。如果没有在视图上执行DML操作的必要，在建立视图时声明为只读来避免这种情况，保证视图对应的基础表数据不会被非法修改。
			create or replace view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10 with read only;--with read only只读，不能对视图进行DML操作。
	(5)视图根据子查询的不同，分为简单视图和复杂视图，当子查询中包含单行函数、表达式或分组函数时，该视图是一个复杂视图。复杂视图不能进行DML操作，并且必须被子查询中的表达式或函数定义别名。
	(6)删除视图：DROP VIEW 视图名称。
28.序列：sequence是用来生成唯一数字值的数据库对象，通常作为表的主键值。序列是独立的数据库对象，序列并不依附于表。
	(1)创建序列：create sequence 序列名 [start with **(起始数据) increment by **(步长,每次增加几，可正可负) maxvalue **(最大值) / minvalue **(最小值)];			
	(2)序列中有两个伪列:nextval/*获取序列的下个值*/ ,currval/*获取序列的当前值*/
						当序列创建以后必须先执行nextval，之后才能使用currval。获取序列的第一个值，并使用序列值为users表插入新的记录。
						select users_seq.currval from dual;--查看当前序列值。
	(3)删除序列:drop sequence users_seq;
	(4)例子：
		create sequence users_seq start with 100 increment by 10;--建立序列,第一次一定要用nextval，不能用currval
		insert into users(id,name)values(users_seq.nextval,'Tony');--插入基表
		select users_seq.currval from dual;--查看当前序列值。
		drop sequence users_seq;--删除序列

29.索引：一种提高查询效率的机制(类似于字典的目录)，经常作为过滤条件、去重、排序或链接条件的字段，可以为其添加索引。
    ?(1)创建索引：create [unique] index 索引名称 on 表名(列名)
				create index idx_users_name on users(ename);--在users表的ename列上建立索引
    (2)添加多列索引：create index idx_users_salary on users(name,salary);
    (3)查询过程中自动应用索引，不需要单独去制定，提高查询速度。
				select users.* from users order by name, salary;
    (4)重构索引（索引是平衡二叉树，修改表后，最好重构一下索引的平衡二叉树）
				alter index 索引名称 rebuild;--经常修改数据的表，不建议建立索引。
    (5)删除索引：drop index idx_users_salary;