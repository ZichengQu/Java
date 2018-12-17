--SQL.day.02
--创建表
CREATE TABLE users(
      id number(10) primary key,--主键
      name varchar2(20) unique,--唯一标识
      salary number(10,2),
      create_time date default sysdate
);

--查看表结构(在command window里用，SQL window不能使用）
desc 表名

--修改表名
RENAME users to userplus

--向表中添加字段
ALTER TABLE userplus ADD(school varchar2(20))
ALTER TABLE userplus ADD(job varchar2(10))

--删除表中已有字段
ALTER TABLE userplus DROP(school)

--修改表中已有字段的格式
ALTER TABLE userplus MODIFY(salary number(10))
ALTER TABLE userplus MODIFY(username varchar2(20) unique)

--修改表中字段名称
ALTER TABLE userplus RENAME column name to username

--向表中添加数据
      --全字段插入数据
INSERT INTO userplus VALUES(1, '张三', 8000,sysdate, '程序员');
INSERT INTO userplus VALUES(2, '张三', 8000,default, '程序员');--因为表中有default sysdate，所以这里可以直接写default
INSERT INTO userplus VALUES(3, '张三', 8000,to_date('2018-12-01','YYYY-MM-DD'), '程序员');
       --部分字段插入
INSERT INTO userplus(id, username, job) VALUES(4,'王五','产品经理');
INSERT INTO userplus(id, username, job, salary) VALUES(5,'王五','产品经理'，5000)

--更新表中已有数据
UPDATE userplus SET salary=salary*10, job='总经理' WHERE id=1;

--删除表中数据
DELETE FROM userplus WHERE salary>5000;

--提交事务
commit;

--回滚
rollback;

--查询表中所有数据
SELECT * FROM userplus;

--查询部分数据信息
SELECT job, salary FROM userplus;
SELECT * FROM userplus WHERE job <> '架构师';
SELECT salary*12 "年薪" FROM userplus WHERE username='王五';--别名
SELECT salary*12 AS "年薪" FROM userplus WHERE username='王五';--别名

--10.(1)字符串函数
       --连接字符串
SELECT CONCAT(ename, sal) from EMP;
SELECT CONCAT(CONCAT(ename, ': ') ,sal)from EMP;
SELECT ename||': '||sal as "姓名：工资" from EMP;
       --显示字符串长度
SELECT LENGTH(ename) from EMP;
       --转大写
SELECT UPPER(ename) from EMP;
       --去除字符串前后指定内容
SELECT TRIM('E' from 'EEHELLO WORLDEEE') from dual;
SELECT ename, trim('A' FROM ename) from emp; --去除员工名字前后的所有'A'
SELECT LTRIM('EEHELLO WORLDEEE', 'E') from dual;--去除EEHELLO的前面的E
SELECT ename, ltrim(ename,'A') from emp;--去除员工名字前面的所有'A'
       --补位函数
select * from emp
select ename, LPAD(sal, 6, 0) AS salary from emp
       --substr截取字符串
select substr('helloworldqqqqq',6,10) from dual;
       --INSTR字符串检索
select instr('thinking in java','in',4,2) from dual;

--10.(2)数字函数
       --截取，用于四舍五入
select round(321.123,1) from dual;
       --截取，无四舍五入
select trunc(45.678,2), trunc(45.678,0), trunc(45.678), trunc(45.678,-1) from dual;
       --取余数
select ename, sal, mod(sal,1000) from emp;
       --向上取整
select ceil(45.678) from dual;
       --向下取整
select floor(45.678) from dual;
--10.(3)日期函数
       --系统时间，精确到秒
select sysdate from dual;
       --时间戳，精确到毫秒
select systimestamp from dual;
       --TO_DATE(),日期转换函数
select to_date('2018-12-01 11:30','YYYY-MM-DD HH:MI:SS') from dual;
select to_date('2018-12-01 13:30','YYYY-MM-DD HH24:MI:SS') from dual;
       --TO_CHAR(),将DATE按照给定的日期格式转换为字符串
select ename, to_char(hiredate,'YYYY-MM-DD HH:MI:SS') from emp;
select ename, to_char(hiredate,'YYYY"年"MM"月"DD"日"') from emp;
       --LAST_DAY(date),返回指定日期所在月的最后一天
select last_day(sysdate) from dual;
select last_day(to_date('2018-12-01 11:30','YYYY-MM-DD HH:MI:SS')) from dual;
       --ADD_MONTHS(date,i),返回+-i个月之后的日期
select ename, hiredate, add_months(hiredate, 12*20) AS "20周年" from emp;
       --MONTHS_BETWEEN(date1,date2):计算两个日期之间相差多少个月
select ename,trunc(months_between(sysdate, hiredate)) from emp;
       --date日期类型在数据库中可以进行减法操作，结果是相差的天数：
select ename, sysdate-hiredate from emp;
       --LEAST(date1,date2):显示两个时间中的最小值。参数类型必须一致。
select least(sysdate,to_date('2018/12/09','YYYY-MM-DD')) from dual;
       --GREATEST(date1,date2):显示两个时间中的最大值。参数类型必须一致。
select greatest(sysdate,to_date('2018/12/09','YYYY-MM-DD')) from dual;
       --EXTRACT(date from datetime):从参数datetime中提取参数date指定的数据，比如提取：年、月、日。
select extract(year from sysdate),extract(month from sysdate),extract(day from sysdate) from dual;
select extract(hour from systimestamp),extract(minute from systimestamp),extract(second from systimestamp) from dual;
select ename from emp where extract(year from hiredate) = 1980;

--10.(4)空值函数：
select * from emp where comm is not null and comm != 0;
       --NVL(arg1,arg2):将null转变为非null值。如果arg1为null，返回arg2；否则返回本身。
select ename,nvl(comm,0) from emp;
select * from emp where nvl(comm,0)>0;
       --NVL(arg1,arg2),如果arg1为null，返回arg2；否则返回本身。计算员工月收入（月工资加奖金（奖金可能为null））
select ename, sal, comm, sal+nvl(comm,0) as "月收入" from emp;
       --NVL2(arg,res1,res2):如果arg为null，则返回res2,arg不为null则返回res1.
select ename, sal, comm, nvl2(comm,comm+sal,sal) as"月收入" from emp;

--11.基本查询语句:
       --查询部门10下的员工信息：
select * from emp where deptno = 10;
       --查询员工表中职位是'SALESMAN'的员工信息
select * from emp where job = 'SALESMAN';

--12.查询条件:
       --查询职员表中薪水低于2000的职员信息
select ename, sal from emp where sal < 2000;
       --查询职员表中不属于部门10的员工信息
select * from emp where deptno <>10;
       --查询职员表中在1981年1月1号以后入职的职员信息
select * from emp where hiredate > to_date('1981/01/01','YYYY/MM/DD');
       --查询薪水大于1000，并且职位是'CLERK'的职员信息
select * from emp where sal>1000 and job='CLERK';
       --查询薪水大于1000，或者职位是'CLERK'的职员信息
select * from emp where sal>1000 or job='CLERK';
       --NVL(arg1,arg2)，NVL2(arg,res1,res2)
       --查询薪水大于1000，并且奖金不为null的职员信息
select * from emp where sal>1000 and comm>0;
select * from emp where sal>1000 and nvl(comm,0)>0;
select * from emp where (deptno=20 or deptno=30) and sal>800;
       --模糊查询，LIKE
       --查询员工表中姓名以'A'开头的员工信息
select * from emp where ename like 'ALLEN';
       --查询员工表中姓名第二个字母是'A'的员工信息
select * from emp where ename like '_A%';
       --IN和NOT IN：
       --查询职位是经理或者职员的员工信息
select * from emp where job in ('MANAGER','CLERK');
       --查询部门不是10或20的员工
select * from emp where deptno not in (10,20);
select * from emp where deptno <> all(10,20);
       --BETWEEN...AND...:是用来查询符合某个值域范围条件的数据。
       --查询薪水在1500~3000之间的职员信息
select * from emp where sal between 1500 and 3000;--[1500,3000]
       --查询比经理最低工资高的员工信息。
select * from emp where sal > any(select sal from emp where job='MANAGER');
       --查询员工的部门编号
select distinct(deptno) from emp;
select distinct deptno,job from emp;

--14.ORDER BY 排序(写在所有子句最后)
select ename, sal from emp order by sal;
select ename, sal from emp order by sal asc;
select * from emp where sal>2000 order by mgr desc;
       --多列排序，对员工表中的职员排序，先按照部门编号正序排列，再按照薪水降序排列。
select ename, deptno, sal from emp order by deptno asc, sal desc;

--15.聚合函数
       --MAX和MIN
select deptno,max(sal),min(sal) from emp group by deptno;
select max(hiredate),min(hiredate) from emp;
select ename from emp a where hiredate = (select max(hiredate) from emp);
             --ERROR:
select ename from emp a where hiredate = (select max(hiredate),min(hiredate) from emp);
             --RIGHT:
select ename from emp where hiredate in ((select min(hiredate) from emp), (select max(hiredate) from emp));
       --AVG和SUM
select avg(sal),sum(sal) from emp;
select avg(comm),sum(comm) from emp;--忽略null值
       --COUNT
select count(*) from emp;
select count(comm) from emp;--忽略null值
select count(*) from emp where comm is not null;
       --不希望聚合函数忽略NULL值时：
select avg(nvl(comm,0)) from emp;

--16.GROUP BY
select max(sal),min(sal),avg(sal) from emp group by deptno;
select deptno,max(sal),min(sal),avg(sal) from emp group by deptno;
select deptno,ename,max(sal),min(sal),avg(sal) from emp group by deptno,ename;
       --where后面不能使用聚合函数,不能执行.
select max(sal),deptno from emp where max(sal)>4000 group by deptno;
       --查询部门中最大工资超过4000的部门以及最大工资。
select max(sal),deptno from emp group by deptno having max(sal)>4000;
       --查看部门编号，以及该部门的平均工资（要求是该本门的平均工资超过2000，职位是PRESIDENT的不能参与统计)
select deptno, avg(sal) from emp where job<>'PRESIDENT' group by deptno having avg(sal)>2000;

--19.关联查询
       --查询每个员工所在部门名称
select ename, dname from emp, dept where emp.deptno=dept.deptno;
       --查看员工名字、工资、部门名称
select ename, sal, dname from emp e, dept d where e.deptno=d.deptno and loc='CHICAGO';
       --KING在哪里工作以及他的部门编号是多少？
select ename, e.deptno, loc from emp e, dept d where e.deptno=d.deptno and ename='KING';

--20.连接种类
       --内连接
select ename, dname from emp inner join dept on emp.deptno=dept.deptno;
       --外连接
              --快速从一个表中复制数据
create table empc as select * from emp;
             --向empc表中插入一条数据，部门号为50
insert into empc(empno, ename, deptno)values(1000,'JACK',50);
select * from empc;
       --左外连接，查询员工的编号、姓名、以及部门名称，包括不属于任何部门的员工。
select empno, ename, dname, empc.deptno from empc left outer join dept on empc.deptno=dept.deptno;
       --右外连接,查询员工的编号、姓名、以及部门名称，包括任何没有员工的部门。
select empno, ename, dname, c.deptno from empc c right outer join dept d on c.deptno=d.deptno;
       --全外连接，查询员工的编号、姓名、以及部门名称，包括不属于任何部门的员工，也包括任何没有员工的部门。
select empno, ename, dname, c.deptno from empc c full outer join dept d on c.deptno=d.deptno;
       --自连接，查询每个员工的上级领导
select e.ename, m.ename from emp e, emp m where e.mgr=m.empno;
select e.ename emp, m.ename mgr from emp e left outer join emp m on e.mgr=m.empno;
       --查询SMITH的上司在哪个城市工作
       --等值连接
select e.ename emp, m.ename mgr, d.loc mgrloc 
from emp e, emp m, dept d 
where e.mgr=m.empno and m.deptno=d.deptno and e.ename='SMITH';
       --内连接
select e.ename emp, m.ename mgr, d.loc mgrloc 
from emp e inner join emp m 
on e.mgr=m.empno and e.ename='SMITH'
inner join dept d
on m.deptno=d.deptno;

--(外连接的另一种写法):查询每一个员工的同时，根据员工的部门编号查询部门的信息，若查询不到部门，该员工的部门信息就是null
select e.ename, e.sal, e.deptno from empc e;--ERROR
       --Solution 1.
select e.ename, e.sal,
(select d.deptno from dept d where d.deptno=e.deptno) deptno 
from empc e;--RIGHT
       --Solution 2.正常的外连接写法：为满足要求，要写成d.deptno
select e.ename, e.sal,d.deptno 
from empc e left outer join dept d 
on e.deptno=d.deptno;
       --Solution 3.当三张表时(例子不是三张表)，这种方法比较简单一些
select e.ename, e.sal,
(select d.dname from dept d where d.deptno=e.deptno) dname,
(select d.loc from dept d where d.deptno=e.deptno) loc
from empc e;

--21.子查询
       --WHERE:
       --单行子查询：查询大于部门号20的最高工资的员工信息
select ename, sal from emp where sal>(select max(sal) from emp where deptno=20);
       --单行子查询：查询与SCOTT同部门的员工信息
select ename, job from emp where deptno=(select deptno from emp where ename='SCOTT')
       --单行子查询：查找薪水比整个机构平均薪水高的员工
select ename, job, sal from emp where sal>(select avg(sal) from emp);
       --多行子查询：查询部门有SALESMAN但职位不是SALESMAN的员工的信息。
select * from emp where deptno in (select deptno from emp where job='SALESMAN') and job<>'SALESMAN';
       --多行子查询：查询比10号部门某个员工工资相等的员工信息
select * from emp where sal = any (select sal from emp where deptno = 10);
       --多列子查询：??????????????????????????????????????????????????????????????????????????
       --EXISTS关键字：列出来那些有员工的部门信息
select deptno, dname from dept d where EXISTS (select * from emp e where e.deptno=d.deptno);
       --HAVING:
       --查询最低工资高于部门30的最低工资的部门信息
select min(sal) from emp group by deptno having min(sal)<(select min(sal) from emp where deptno=30);
       
--22.分页查询
       --查询rownum大于2的所有记录
select  rownum, e.* from emp e where rownum>2;--ERROR，因为没有任何记录。
select rownum, e.* from emp e where rownum>=1;
select rownum, e.* from emp e where rownum<6;
       --找到员工表中工资最高的前三名（降序排序）：
               --ERROR
select rownum, e.* from emp e order by sal desc where rownum<=3;
               --RIGHT
select * from emp order by sal desc;--先降序，再把它当成一张表，再去选rownum小于等于3的行。
select rownum, t1.* from (select * from emp order by sal desc) t1 where rownum <=3;
       --查询第6~10条记录(两种方法）
select * from (select rownum rn, e.* from emp e) t where t.rn between 6 and 10;
select t1.* from (select rownum rn, emp.* from emp where rownum<=10) t1 where rn between 6 and 10;
       --工资降序后选6~10条记录：原表先降序，再加伪列，再当新表选范围。
select * from (select rownum rn, e.* from (select * from emp order by sal desc) e) t where t.rn between 6 and 10;

--23.DECODE(参数1，值1，结果1，值2，结果2...[,默认值]);
       --查询职员表，根据职员的职位计算奖励金额，当职位分别是'MANAGER','SALESMAN','ANALYST'时，奖励金分别是薪水的1.2,1.1,1.05倍，其它为原本的薪水值。
select ename, job, sal, decode(job,'MANAGER',sal*1.2,'SALESMAN',sal*1.1,'ANALYST',sal*1.05,sal) "奖金" from emp;
select decode(job,'MANAGER','VIP','ANALYST','VIP','OPERATION') from emp;
       --分组操作，不能起别名
select decode(job,'MANAGER','VIP','ANALYST','VIP','OPERATION') job, count(*) from emp group by decode(job,'MANAGER','VIP','ANALYST','VIP','OPERATION');
       --自定义排序
select * from emp order by decode(job,'MANAGER','1','SALESMAN','2','ANALYST','3');

--24
       --union
         --工资大于1500或20号部门下的员工
select * from emp where sal>1500 or deptno=20;
         --工资大于1500的
select * from emp where sal>1500;--7条记录       
         --20号部门下的员工
select * from emp where deptno=20;--5条记录
         --并集运算：union(忽略重复数据，9条记录，并排序), union all(不忽略重复数据，12条记录，不排序)
select * from emp where sal>1500 union select * from emp where deptno=20;--并集之后，总共9条记录
       --INTERSECT，交集
select * from emp where sal>1500 INTERSECT select * from emp where deptno=20;
       --MINUS差集：两个结果相减。
         --1981年入职员工(不包括总裁和经理)
select * from emp where to_char(hiredate,'YYYY')='1981';
select * from emp where job in ('PRESIDENT','MANAGER');
select * from emp where to_char(hiredate,'YYYY')='1981' MINUS select * from emp where job in ('PRESIDENT','MANAGER');
       --注意事项：
select empno,ename from emp where to_char(hiredate,'YYYY')='1981' MINUS select null,ename from emp where job in ('PRESIDENT','MANAGER');

--25.DDL语句管理表：
CREATE tablespace YYP datafile 'e:/YYP.dbf' size 100m autoextend on next 10m;--创建
drop tablespace YYP;--删除（取消和文件的关联，不会删除文件）（取消关联之后，可以手动删除）。
create user zicheng identified by qqq default tablespace YYP;--创建用户
drop user zicheng cascade;--删除用户
alter user zicheng identified by eee;--修改密码
grant connect to zicheng;--授权
grant dba to zicheng;--分配角色
      --使用子查询的方式创建表：
create table emp as select * from scott.emp;--只复制表结构和表数据，不会复制列的约束。
create table dept as select * from scott.dept where 1=2;--只复制表结构，无数据,因为1=2为false。
insert into dept select * from scott.dept;--只复制表数据,但前提是表的结构与已有表结构一致。
select * from dept;

--26.列的约束
       --检查约束
CREATE TABLE users(
      id number(10) primary key,--主键
      name varchar2(20) unique,--唯一标识
      sex varchar2(2) check(sex in ('男' ,'女')),--检查约束
      salary number(10,2) check(salary>3000),
      create_time date default sysdate
);
insert into users values(1,'admin','男',3500,default);
       --外键约束
create table category(
       id number(10) primary key,
       cname varchar2(10)
);
create table books(
       book_id number(10) primary key,
       book_name varchar2(20) not null,
       price number(10,2) check(price>100),--检查约束
       cid number(10)  not null references category(id)--外键约束
       --foreign key(cid) references category(id)--另一种外键约束的方式
);
                 --可以不在定义表中建立外键约束，单独用此语句也可实现外键约束。
alter table books add foreign key(cid) references category(id);
            --例子：
insert into category values(1,'小说');
insert into category values(2,'文学');
insert into category values(3,'传记');
select * from category;
insert into books values(1,'西游记',101,1);
select * from books;
            --不能删除外键，因为从表中有相关的已建立关联的外键约束
delete from category where id=1;
delete from books where cid=1;--删除外键关联的两种方法
update books set cid=null where cid=1;--然后再删除主表中的数据就ok。

--27.视图
       --创建一个简单视图v_emp_10来显示部门10中的员工的编码、姓名和薪水。
create view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10;
       --修改视图就是替换该视图的子查询，使用create or replace view 视图名 即可，若视图不存在就创建，存在就替换。创建视图时，可以给列赋予别名。
create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10;
       --查询视图
select * from v_emp_10;
       --视图的DML操作,会修改原表的数据
insert into v_emp_10 values(1,'Tony',8888,50)
select * from emp;
       --with check option
create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10 with check option
       --with read only只读，不能对视图进行DML操作。
create or replace view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10 with read only;
       --创建一个视图v_emp_salary,把职员表中的数据按部门分组，获得每个部门的平均薪水、薪水总和、最低薪水。
create view v_emp_salary as select d.dname, avg(sal) avg_sal,sum(sal) sum_sal,min(sal) min_sal,max(sal) max_sal from emp e, dept d where e.deptno=d.deptno group by d.deptno, d.dname;
select * from v_emp_salary;
       --drop view 视图名称：删除视图
drop view v_emp_slary;

--28.序列
     --建表、建立序列、插入基表、删除序列
CREATE TABLE users(
      id number(10) primary key,--主键
      name varchar2(20), --unique,--唯一标识
      salary number(10,2),
      create_time date default sysdate
);
      --建立序列：create sequence 序列名 start with **(起始数据) increment by **(步长,每次增加几，可正可负) maxvalue **(最大值) / minvalue **(最小值);
create sequence users_seq start with 100 increment by 10;--建立序列,第一次一定要用nextval，不能用currval
insert into users(id,name)values(users_seq.nextval,'马冬梅');--插入基表
select users_seq.currval from dual;--查看当前序列值。
drop sequence users_seq;--删除序列
     --循环插入
begin
    for i in  1..10000
    loop
        insert into users(id,name,salary) values( users_seq.nextval,'瞬间爆炸',8888);
    end loop;
    commit;
end;

--29.索引
    --创建索引：create [unique] index 索引名称 on 表名(列名)
create index idx_users_name on users(name);--在users表的ename列上建立索引
    --添加多列索引：
create index idx_users_salary on users(name,salary);
    --查询过程中自动应用索引，不需要单独去制定，提高查询速度。
select users.* from users order by name, salary;
    --重构索引（索引是平衡二叉树，修改表后，最好重构一下索引的平衡二叉树）
alter index 索引名称 rebuild;--经常修改数据的表，不建议建立索引。
    --删除索引：
drop index idx_users_salary;









--练习
create table student(
       id number(10) not null,
       name varchar2(20),
       hobby varchar2(100),
       school varchar2(20),
       create_time date
);
--修改表名student_t
rename student to student_t;
--添加字段：科目project，成绩score
alter table student_t add(project varchar2(20), score number(3));
--删除学校字段
alter table student_t drop(school);
--修改字段格式
alter table student_t modify(create_time varchar2(20) default sysdate);
--修改表中字段名称，name改为stu_name
alter table student_t rename column name to stu_name;

