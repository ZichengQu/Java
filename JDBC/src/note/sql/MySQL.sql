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
	limit子句(方言): 用来限定查询结果的起始行以及总行数。
		分页查询:limit 起始行,页大小; 起始行=(页的索引-1)*页大小; 页大小=页大小;
		例如：select * from emp limit 4,3;--查询起始行为第5行，一共查询3行记录。
9.EmpManageByMysql: 
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
			
				
			