SQL(结构化查询语言),此笔记主要针对于MySQL version 5.5;
1.SQL分类：
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
			REVOKE: 撤销权限。
			grant…create…view…to…scott;
2.Mysql基本介绍:
	启动和停止Mysql服务：mysql是一种C/S结构的软件(客户端和服务器),服务端对应的软件：mysqld.exe,	客户端: mysql.exe;
	cmd命令行方式: 开启服务: net start mysql; 关闭服务: net stop mysql;
	系统服务方式: 此电脑，管理，服务，MySQL;
	cmd登陆mysql: mysql -uroot -proot, 若未配置环境变量，则需进入到MySQL里的bin目录下再用cmd登陆mysql。
	-uroot：表示用户是root，是默认的用户;
	-proot：表示用户的密码是root;
	退出mysql: exit或quit;
3.Mysql服务端架构:
	(1)数据库管理系统(最外层):DBMS,专门管理服务器端的所有内容。
	(2)数据库(第二层):DB,专门用于存储数据的仓库(可以有多个)。
	(3)二维数据表(第三层):TABLE,专门用于存储实体的数据。
	(4)字段(第四层):Field,具体存储某种类型的数据(实际的存储单元)。
4.数据库基本操作:
	(1)创建数据库: create database [if not exists] 数据库名 [charset 字符集];--if not exits如果不存在则创建，[可写可不写].字符集若不指定则按默认字符集编码;
		create database if not exists t_user charset utf8;
	(2)显示数据库:
		显示全部数据库:	show databases;
		显示部分数据库:	show databases like '匹配模式';	_:匹配当前位置的单个字符;%:匹配指定位置的多个字符;
						获取以my开头的数据库: show databases like 'my%';
	(3)选择数据库: use 数据库名;--use t_user;
	(4)修改数据库: 
		1)修改数据库字符集: alter database 数据库名 charset 字符集;	--alter database t_user charset gbk
		2)删除数据库: drop database 数据库名; --drop database t_user;
	(5)数据表操作:
		1)创建数据表: create table 表名(字段名 字段类型[字段属性], 字段名 字段类型[字段属性], ...);
			例子:create table user(
					username varchar(10),
					password varchar(10)
					);
		2)显示数据表:
			显示所有表: show tables;
			显示部分表:	show tables like '匹配模式';
		3)显示表结构: desc 表名;
		4)修改表结构: 5.5版本之后的数据库名不能修改
			修改表名: rename table 旧表名 to 新表名; --rename table user to t_user;
			修改表选项: alter table 表名 charset utf8;
			新增字段: alter table 表名 add 新字段名 字段类型[字段属性] [位置first/after字段名]; --alter table t_user add id int first; alter table t_user add age int;
			修改字段名: alter table 表名 change 旧字段名 新字段名 字段类型[字段属性] [新位置]; --alter table t_user change age nianling int;
			修改字段类型: alter table 表名 modify 字段名 新类型[新属性] [新位置]; --alter table t_user modify username varchar(20);
			删除字段: alter table 表名 drop 字段名; --alter table t_user drop nianling;
		5)删除表结构: drop table 表名[,表名2];可以同时删除多个数据表。
		6)清空表中数据: truncate table 表名;不可以同时清空多个数据表。
5.数据基础操作:
	插入操作: insert into 表名[(字段列表)] values(对应字段列表);
			  insert into 表名 values(对应全部字段);
	查询操作: select * from 表名; --*表示匹配所有的字段.
			  select 字段列表 from 表名;--字段列表使用","分隔.
	删除操作: delete from 表名 where 条件; --通常删除部分数据，所以加where条件。
			  truncate table 表名;
	更新操作: update 表名 set 字段名=新值 where 条件; --通常修改部分字段的值，所以加where条件。
6.列类型(字段类型):
	1)整数类型:
		Tinyint: 迷你整形，系统采用一个字节来保存的整形，1个字节等于8位，最大能表示的数值是0~255.
				mysql默认的为整形增加负数，实际表示的区间为-128~127.
		Smallint: 小整形，系统采用两个字节来保存的整形，能表示0~65535.
		Mediumint: 中整形，系统采用三个字节来保存数据.
		int: 整形，标准整形系统采用四个字节来保存数据.
		bigint: 比int范围还要大.
		例子:
			创建数据表:
				create table t_int(
					num1 tinyint,
					num2 smallint,
					num3 mediumint,
					num4 int,
					num5 bigint
				);
			insert into t_int values(-128,255,255,255,255);
			insert into t_int values(255,255,255,255,255); --会报错，因为最大范围为-128~127.
		无符号标识设定:
			无符号: 表示存储的数据再当前字段中没有负数(只有正数，区间为0~255).
				在类型之后加上一个unsigned。
				alter table t_int add num6 tinyint unsigned first;
				insert into t_int values(255,-128,255,255,255,255);
	2)小数类型:浮点型和定点型;
		浮点型(精度类型): 是一种有可能丢失精度的数据类型，数据有可能不那么准确(尤其是在超出范围的时候).
			float: 单精度浮点型(4个字节)，大概7位左右的精确度。float(M,D)表示一共存储M个有效数字，其中小数部分占D位。
				例子:
					create table t_float(
						f1 float,
						f2 float(7,2),
						f3 float(12,2)
					);
					insert into t_float values (123.456,12345.67,12345678.90);--f3的数据会丢失,12345679.00; 注意: 如果数据精度丢失，那么浮点型是按照四舍五入的方式进行计算。
			double: 双精度浮点型(8个字节)，大概15位左右的精确度，数据有可能不那么准确(尤其是在超出范围的时候).
		定点型:能够保证精确的小数(小数部分可能不精确，超出长度会四舍五入)，整数部分一定精确。涉及到钱的时候有可能使用定点数。
			decimal(M,D):M表示总长度,最大值不能超过65,D表示小数部分长度，最长不能超过30。
				例子:
					create table t_decimal(
						f1 float(10,2),
						d2 decimal(10,2)
					);
					insert into t_decimal values(12345678.90,12345678.90);--f1:12345679.00	| d2:12345678.90
					insert into t_decimal values(99999999.99,99999999.99);--f1:100000000.00	| d2:99999999.99
					insert into t_decimal values(99999999.99,99999999.999);--error
	3)时间日期类型:
		Date:日期类型 YYYY-mm-dd
		Time:时间类型 HH:ii:ss
		Datetime:日期时间类型 YYYY-mm-dd HH:ii:ss
		Timestamp:时间戳类型 mysql中的时间戳只是表示从格林威治时间开始，但是格式依然是 YYYY-mm-dd HH:ii:ss
	4)字符串类型:
		char: 定长字符串,指定长度后,系统一定会分配指定的空间用于存储数据;char(L) L(0~255)代表字符数，哪怕只使用了一个字符，系统也分配L个字符长度;
		varchar: 变长字符串，指定长度后，系统会根据实际存储的数据来计算长度分配合适的空间; varchar(L) L(0~65535)代表字符数;
		text: 长文本;
7.列属性(字段属性): 在mysql中一共有6个属性null,默认值,列描述,主键,唯一键,自动增长;
	创建数据表:
	1)not null/default:
		create table t_user(
			name varchar(10) not null,
			age int default 18
		);
		insert into t_user(name) values('Tony'); insert into t_user values('Tom',default);
	2)comment:
		create table t_user(
			name varchar(10) not null comment '用户名非空', --用户名不能为空
			age int default 18
		);
		查看comment必须通过查看建表语句: show create table t_user;
	3)primary key: 主键,在同一张表内有且仅有一个字段，里面的值具有唯一性;主键一旦增加，那么对应的字段有数据要求:当前字段不能为、当前字段不能重复;
		创建主键:
			随表创建:
				第一种:直接在需要当作主键的字段后，增加primary key属性来确定主键;
					create table t_user(
						name varchar(10) primary key,
						age int
					);
				第二种:在所有字段之后增加primary key选项， primary key(字段信息);
					create table t_user(
						name varchar(10),
						age int,
						primary key(name)
					);
			表后增加: alter table 表名 add primary key(字段);
	4)auto_increment:自动增长,当给定某个字段的某个属性之后，该列的数据在没有提供确定数据的时候，系统会根据之前已经存在的数据进行自动递增后，填充数据;
		alter table t_user add id int auto_increment;
		create table t_user(
			id int auto_increment,
			name varchar(10),
			age int,
			primary key(id)
		);
		insert into t_user(name,age) values('Tony',18);--id=1;
		insert into t_user values(2,'Mary',18);--id=2;
		insert into t_user(name,age) values('Jack',18);--id=3;
		自动增长通常用于逻辑主键.
	5)unique key:唯一键,用来保证对应的字段中的数据是唯一的;主键也可以用来保证字段数据唯一性，但是一张表中只能有一个主键;
		要求:一张表中可以有多个;允许字段数据为null，null可以有多个(null不参与比较);
		创建唯一键:
			直接在表字段之后增加唯一键标识符: unique [key]
			在所有的字段之后使用 unique key(字段列表[,字段列表,...])
			在创建完表后也可以增加唯一键;	alter table 表名 add unique key(字段列表[,字段列表,...]);
8.数据查询:
	(1)简单查询:
		查询所有列: select * from 表名;
		查询指定列: select 字段1, 字段2 from 表名;
		去重: select distinct 字段 from 表名;
		在查询列表中可以使用算术表达式: select empno as "员工编号", ename '员工姓名', sal*12 年薪 from emp;--起别名时: as可以使用，也可以不使用;别名可以使用单双引号，甚至可以不用引号;
	(2)条件查询: select 字段列表 from 表名 [where 查询条件];
		1)使用=作为查询条件或使用<>和!=作为查询条件或使用<,<=,>,>=作为查询条件，适用于数据库的三种主要类型(数值型,字符串类型,日期型);注意:在使用字符串类型和日期类型的数据时，必须要使用''或"";
			select * from emp where sal = 800;--查询工资是800的员工信息;
			select * from emp where ename = '武松';--查询员工姓名是"武松"的员工信息;
			select * from emp where hiredate != "1981-02-22";--查询雇佣日期不是"1981-02-22"的员工信息;
			select * from emp where sal <> 800;--查询工资不是800的员工信息;
			补充:
				mysql在window平台上面默认不区分大小写,linux平台上区分大小写;--数据库里的名字是"SMITH";
				select ename from emp where binary ename="smith";--我们可以使用binary让mysql在window平台上也严格区分大小写;
				select * from emp where binary lower(ename)="smith";--在数据库严格区分大小写的情况下，忽略字符串大小写;
		2)使用between and 作为查询条件，在特定范围之内:
			select * from emp where sal between 1600 and 3000;--包括1600和3000;
			select * from emp where hiredate between "1981-02-22" and "1981-05-01";
		3)使用is null或is not null作为查询条件,对于null的判断不能使用=和!=和<>,而是要使用 is null进行判断;
		4)使用and作为查询条件,and也可以使用&&来代替;
			select * from emp where sal>1200 && deptno=20;--查询工资大于1200并且部门号为20的员工的信息;
		5)使用or作为查询条件,or也可以使用||来代替;
		6)and的优先级比or高:
			select * from emp where sal>1200&&(deptno=20||30);--查询工资大于1200并且部门编号为20或30的员工;
		7)使用in作为查询条件,in表示包含的意思:
			select * from emp where job in("推销员","分析师");
		8)使用not作为查询条件:
			select * from emp where sal!=1600 and sal!=3000;
			select * from emp where sal not in(1600,3000);
			select * from emp where sal not(sal=1600 or sal=3000);
		9)使用like执行模糊查询: %表示0~多个任意的字符,	_表示一个任意的字符;
			select * from emp where ename like "李%";--查询名字以"李"开头的员工信息;
		10)使用order by子句给查询结果排序: 可以按照单个字段排序,也可以按照多个字段排序;
			select * from emp order by sal desc;--asc升序(默认升序,可不写),desc降序;
			按照多个字段排序,每个字段可以指定不同的排序规则
			select * from emp where sal>1200 order by deptno [asc], sal desc;--查询工资大于1200的员工信息,并按照deptno升序(默认升序,可不写)和sal降序排列;
	(3)数据库函数: 
		单行函数: 
			1)lower(str): 把字符型数据转换为小写的字符;
			2)upper(str): 把字符型数据转换为大写的字符;
			3)substr(被截取字符串的名字,起始下标,截取长度): 截取字符串;
				select substr(ename,2,1) from emp;--从员工名字的第二个字符开始截取,截取一个字符长度;
			4)length(str): 返回字符串占用的字节数;gbk一个汉字占两个字节,utf8是三个字节;
			5)char_length(str): 返回字符串中有多少个字符;
				select ename, length(ename)/3 from emp;--查询员工的名字以及名字的长度;
				select ename, char_length(ename) from emp;
			6)trim(): 去除字符串型数据的前后空格;
				select trim(" 1 2 3 ");--1 2 3,oracle中必须写某一个表,mysql中不写的话,默认从系统表中查询;
			7)round(): 对数值型数据进行四舍五入操作;
				select round(176.56);--默认精确到个位;
				select round(176.56,1);--精确到小数点后1位;
				select round(176.56,-1);--精确到小数点前1位;
			8)ifnull(): 空值处理函数,null表示没有数据;在算术中如果出现null,结果肯定是null;
				select (sal+ifnull(comm,0))*12 "年薪" from emp;
			9)case when函数: 执行分支语句的函数;
				--匹配工作岗位,当为经理时,薪水上调10%,当为分析师时,薪水上调50%,其它岗位不变;
				select empno,ename,job,sal as '原来的薪水', (case job when '经理' then sal*1.1 when '分析师' then sal*1.5 else sal end) as '新的薪水' from emp;
			10)str_to_date(str,format): 把字符串转换为日期的函数
				select * from emp where hiredate = "1981-02-22";
				--mysql会自动的调用str_to_date(str,format)函数,把字符型数据转换为日期型的数据,然后再去和hiredate进行比较;
				--mysql默认的日期格式是"年-月-日";上面语句的实际执行过程如下:
				select * from emp where hiredate = str_to_date("1981-02-22","%Y-%m-%d");--注意: 使用str_to_date(str,format)的时候,日期字符串需与format字符串的格式一致,转换才能成功;
				--在mysql中提供了一个now()函数,可以获得当前时间点的日期对象(年月日);
				update emp set hiredate=now() where empno=7521;
			11)date_format(date,format): 把日期型的数据转换为特定格式的字符串
				select ename, hiredate from emp;
				--mysql会自动的调用date_format(date,format)函数,把日期型数据转换为字符串型的数据;实际执行过程如下:
				select ename,date_format(hiredate,"%Y-%m-%d") from emp;--只要指定一个日期模板就可以把日期型的数据转换为任意格式的字符串;
		多行函数(聚合函数,分组函数): 
			注意事项:
				1)多行函数会自动忽略空值(null),不需要手动用where排除空值;
				2)多行函数不能出现在where子句中;
				3)多行函数不能嵌套;
			常用多行函数:
				1)sum(): 求总和;
					--查询emp表的月收入总和:
					select sum(sal+comm) from emp;--错误的,将sal+comm的结果不为null的求和了;
					select sum(sal+ifnull(comm,0)) from emp;--正确的;
					select sum(sal)+sum(comm) from emp;--正确的;
				2)count(): 查询数据总和;
					count(*): 查询所有的 记录总数;
					count(字段): 查询指定字段不为null的数据总数;
				3)avg(): 查询平均值; select avg(sal) from emp;
				4)max(): 查询最大值; select max(sal),max(hiredate) from emp;
				5)min(): 查询最小值; select min(sal),min(hiredate) from emp;
	(4)分组查询: 分组查询需要使用group by子句;把数据按照特定的条件划分为多组,然后分别使用组函数进行查询;把数据划分为多少组,最终就会得到多少条结果;
		语法: select 查询列表 from 表名 group by 分组字段;
		规则: 出现在查询列表中的字段,要么出现在组函数中,要么出现在group by中;或者分组字段仅仅出现在group by子句中;
		例子:
		1)按照单个字段进行分组:
			select deptno,max(sal) from emp group by deptno;--把所有的员工按照部门编号分组,查询最高工资;
			按照部门编号分组,查询最高工资以及最高工资的员工姓名
			select ename,max(sal),deptno from emp group by deptno;--错误的,出现在查询列表中的ename即没有出现在组函数中,也没有出现在group by子句中,这是不符合规则的;这样的语句在Oracle中无法执行,mysql中能够执行,但结果不符合预期需求;
		2)按照多个字段进行分组:
			select deptno,job,max(sal) from emp group by deptno,job;--按照部门编号和职位进行分组,查询最高工资;
		3)对分组之后的数据进行过滤,需要使用having子句:
			select deptno,avg(sal) as '平均工资' from emp group by deptno having avg(sal)>2000;--按照部门编号分组,查询平均工资,并且显示平均工资大于2000的记录;
			select deptno,avg(sal) avgsal from emp group by deptno having avgsal>2000;--与上一条等效;
			select deptno,avg(sal) from emp where comm is null group by deptno having avg(sal)>2000 order by avg(sal);--把津贴为null的员工按照部门编号分组查询平均工资,并且显示平均工资大于2000的数据,然后按照平均工资排序(升序);
		4)查询句式及顺序:
			select 查询列表
			from 表名
			where 查询条件
			group by 分组条件
			having 查询条件
			order by 排序条件
			from,where,group by,having,select,order by;
	(5)limit子句(方言): 用来限定查询结果的起始行以及总行数。
		分页查询:limit 起始行,页大小; 起始行=(页的索引-1)*页大小; 页大小=页大小;
		例如：select * from emp limit 4,3;--查询起始行为第5行，一共查询3行记录。
		例子:EmpManageByMysql: https://github.com/ZichengQu/Java/tree/JavaWeb/JSP/EmpManageByMysql
				public static Connection getConnection(){//使用JDBC连接mysql数据库
					Connection conn = null;
					try {
						//加载驱动
						Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/empdb";//指定连接的数据库名称为empdb
						String user = "root";
						String password = "root";
						//获取连接对象
						conn = DriverManager.getConnection(url, user, password);
						System.out.println("使用DBUtil连接Oracle成功!");
					} catch (Exception e) {
						e.printStackTrace();
					}
					return conn;
				}
	(6)多表查询:
		按照连接的方式:
			1)内连接: 可以查询满足一一对应关系的数据: 例如这个员工有所属的部门,这个部门有所属的员工,这样的数据满足一一对应的关系,可以使用内连接查询出来;
				内连接分类:
					等值连接: 建立在父子表关系上,用等号来连接两个表;
						select ename,sal,job,e.deptno,dname from emp e, dept where e.deptno=dept.deptno and e.deptno=20;--查询员工表及其部门信息;
						select ename,sal,job,e.deptno,dname from emp e inner join dept on e.deptno=dept.deptno and e.deptno=20;--可以使用and或where在其后追加条件;
					非等值连接: 两个表之间没有父子关系,用非等号来连接两个表;
						select e.empno, e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal;--CREATE TABLE salgrade(grade INT PRIMARY KEY, losal INT, hisal INT);插入数据;
						select e.empno, e.ename, e.sal, s.grade from emp e INNER JOIN salgrade s on e.sal between s.losal and s.hisal;--与上一条等效;
					自连接: 使用别名将一个表虚拟成两个表(父子表),然后再这两个表上作等值连接;
						select e.empno "员工编号",e.ename "员工姓名",m.empno "经理编号", m.ename "经理姓名" from emp e,emp m where e.mgr=m.empno;--查询员工的信息及其直接领导的信息
			2)外连接: 可以查询不满足一一对应关系的数据: 例如有的员工没有所属部门,有的部门没有员工,这样的数据不满足一一对应的关系,可以使用外连接查询出来;
				外连接分类:
					左外连接(left outer join): 可以把左表中不满足对应关系的数据查询出来;
						select * from emp left join dept on emp.deptno=dept.deptno;
					右外连接(right outer join): 可以把右表中不满足对应关系的数据查询出来;
						select * from emp right join dept on emp.deptno=dept.deptno;
					全外连接(full outer join)(不支持): 可以把左右两个表中不满足对应关系的数据查询出来;
						select * from emp full join dept on emp.deptno=dept.deptno;--mysql不支持全外连接,因此此查询语句会报错;
	(7)子查询: 用来给主查询提供查询条件或查询数据而首先执行的一个查询;主查询使用子查询的结果;子查询必须要放在()里面;
		子查询分类:
			1)出现在where中的子查询,用来给主查询提供查询条件;
				select * from emp where sal<(select avg(sal) from emp);--查询工资比平均工资低的员工信息;
			2)出现在from后面的子查询,用来给主查询提供数据的;
			3)出现在查询列表中的子查询,功能类似于外连接的效果(了解);
				select e.empno,e.ename,e.job,e.sal,e.deptno,(select dname from dept d where e.deptno=d.deptno) dname from emp e;
	(8)union: 使用union把两个结果合并成一个结果
		union(会合并相同的数据), union all(不会合并相同的数据);
		注意: 合并两个查询结果的时候,要求两个查询结果的结果必须要一致(查询字段的个数,字段的类型,字段的顺序必须要一致);
		select * from emp where sal>1500 union select * from emp where deptno=20;
9.数据库事务处理:
	1)把多个相关的操作捆绑成一个整体,要么都成功,要么都失败;
	2)只有DML(数据操作语言)语句才会引起一个事务;
	3)事务的四个特性：
		原子性(Atomicity):
　	　		原子性是指事务包含的所有操作要么全部成功全部应用，要么全部失败回滚。因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。
		一致性(Consistency):
			一致性是指一个事务执行之前和执行之后都必须处于一致性状态。拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还得是5000，这就是事务的一致性。
		隔离性(Isolation):
　　		隔离性是指多个并发事务之间要相互隔离。当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰。
		持久性(Durability):
　　		持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作。
	4)mysql管理事务的默认方式是: 自动提交;
		start transaction: 关闭本次自动提交事务;
		关闭自动提交之后执行的第一个DML语句会引起一个事务;在事务开启之后,只要事务没有结束,执行的所有DML操作都是隶属于同一个事务的;事务中对数据的修改被保存在内存中;只有当前事务可以查询到这些修改;
			insert into dept values(50,"","");
			insert into dept values(60,"","");
			update dept set dname="研发部",loc="沈阳" where deptno>40;
			select * from dept;
		关闭事务
			commit: 提交结束事务的时候,事务中对数据库的修改被永久的保存到数据库中,所有的会话可以查询到这些修改;
			rollback: 回滚结束事务的时候,事务中对数据库的修改被全部放弃,数据库恢复到事务开始之前的状态;
	5)事务的隔离级别:
		并发事务问题:
			脏读: 读到另一个事务的未提交更新数据,即读到了脏数据;
			不可重复读: 对同一记录的两次读取不一致,因为另一个事务对该记录进行了修改;
			幻读(虚读): 对同一张表的两次查询不一致,因为另一个事务插入了一条记录;
		四大隔离级别:
			串行化: serializable;
				不会出现任何并发问题,因为它对同一数据的访问是串行的(非并发访问),性能最差;
			可重复读: repeatable read --mysql默认的隔离级别
				可防止脏读和不可重复读,性能比serializable好;
			读取已提交: read committed --oracle默认的隔离级别
				防止脏读,性能比repeatable read好;
			读取未提交的数据: read uncommitted --会脏读
				可能出现任何事务并发问题;性能最好;
		mysql的隔离级别:
			mysql的默认隔离级别为repeatable read,可以通过 select @@tx_isoliation 查看;
			也可以通过 set transaction isolationlevel [4选1] 来设置当前连接的隔离级别;
			
			
			
			