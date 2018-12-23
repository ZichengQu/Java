--SQL.day.02
--������
CREATE TABLE users(
      id number(10) primary key,--����
      name varchar2(20) unique,--Ψһ��ʶ
      salary number(10,2),
      create_time date default sysdate
);

--�鿴��ṹ(��command window���ã�SQL window����ʹ�ã�
desc ����

--�޸ı���
RENAME users to userplus

--���������ֶ�
ALTER TABLE userplus ADD(school varchar2(20))
ALTER TABLE userplus ADD(job varchar2(10))

--ɾ�����������ֶ�
ALTER TABLE userplus DROP(school)

--�޸ı��������ֶεĸ�ʽ
ALTER TABLE userplus MODIFY(salary number(10))
ALTER TABLE userplus MODIFY(username varchar2(20) unique)

--�޸ı����ֶ�����
ALTER TABLE userplus RENAME column name to username

--������������
      --ȫ�ֶβ�������
INSERT INTO userplus VALUES(1, '����', 8000,sysdate, '����Ա');
INSERT INTO userplus VALUES(2, '����', 8000,default, '����Ա');--��Ϊ������default sysdate�������������ֱ��дdefault
INSERT INTO userplus VALUES(3, '����', 8000,to_date('2018-12-01','YYYY-MM-DD'), '����Ա');
       --�����ֶβ���
INSERT INTO userplus(id, username, job) VALUES(4,'����','��Ʒ����');
INSERT INTO userplus(id, username, job, salary) VALUES(5,'����','��Ʒ����'��5000)

--���±�����������
UPDATE userplus SET salary=salary*10, job='�ܾ���' WHERE id=1;

--ɾ����������
DELETE FROM userplus WHERE salary>5000;

--�ύ����
commit;

--�ع�
rollback;

--��ѯ������������
SELECT * FROM userplus;

--��ѯ����������Ϣ
SELECT job, salary FROM userplus;
SELECT * FROM userplus WHERE job <> '�ܹ�ʦ';
SELECT salary*12 "��н" FROM userplus WHERE username='����';--����
SELECT salary*12 AS "��н" FROM userplus WHERE username='����';--����

--10.(1)�ַ�������
       --�����ַ���
SELECT CONCAT(ename, sal) from EMP;
SELECT CONCAT(CONCAT(ename, ': ') ,sal)from EMP;
SELECT ename||': '||sal as "����������" from EMP;
       --��ʾ�ַ�������
SELECT LENGTH(ename) from EMP;
       --ת��д
SELECT UPPER(ename) from EMP;
       --ȥ���ַ���ǰ��ָ������
SELECT TRIM('E' from 'EEHELLO WORLDEEE') from dual;
SELECT ename, trim('A' FROM ename) from emp; --ȥ��Ա������ǰ�������'A'
SELECT LTRIM('EEHELLO WORLDEEE', 'E') from dual;--ȥ��EEHELLO��ǰ���E
SELECT ename, ltrim(ename,'A') from emp;--ȥ��Ա������ǰ�������'A'
       --��λ����
select * from emp
select ename, LPAD(sal, 6, 0) AS salary from emp
       --substr��ȡ�ַ���
select substr('helloworldqqqqq',6,10) from dual;
       --INSTR�ַ�������
select instr('thinking in java','in',4,2) from dual;

--10.(2)���ֺ���
       --��ȡ��������������
select round(321.123,1) from dual;
       --��ȡ������������
select trunc(45.678,2), trunc(45.678,0), trunc(45.678), trunc(45.678,-1) from dual;
       --ȡ����
select ename, sal, mod(sal,1000) from emp;
       --����ȡ��
select ceil(45.678) from dual;
       --����ȡ��
select floor(45.678) from dual;
--10.(3)���ں���
       --ϵͳʱ�䣬��ȷ����
select sysdate from dual;
       --ʱ�������ȷ������
select systimestamp from dual;
       --TO_DATE(),����ת������
select to_date('2018-12-01 11:30','YYYY-MM-DD HH:MI:SS') from dual;
select to_date('2018-12-01 13:30','YYYY-MM-DD HH24:MI:SS') from dual;
       --TO_CHAR(),��DATE���ո��������ڸ�ʽת��Ϊ�ַ���
select ename, to_char(hiredate,'YYYY-MM-DD HH:MI:SS') from emp;
select ename, to_char(hiredate,'YYYY"��"MM"��"DD"��"') from emp;
       --LAST_DAY(date),����ָ�����������µ����һ��
select last_day(sysdate) from dual;
select last_day(to_date('2018-12-01 11:30','YYYY-MM-DD HH:MI:SS')) from dual;
       --ADD_MONTHS(date,i),����+-i����֮�������
select ename, hiredate, add_months(hiredate, 12*20) AS "20����" from emp;
       --MONTHS_BETWEEN(date1,date2):������������֮�������ٸ���
select ename,trunc(months_between(sysdate, hiredate)) from emp;
       --date�������������ݿ��п��Խ��м������������������������
select ename, sysdate-hiredate from emp;
       --LEAST(date1,date2):��ʾ����ʱ���е���Сֵ���������ͱ���һ�¡�
select least(sysdate,to_date('2018/12/09','YYYY-MM-DD')) from dual;
       --GREATEST(date1,date2):��ʾ����ʱ���е����ֵ���������ͱ���һ�¡�
select greatest(sysdate,to_date('2018/12/09','YYYY-MM-DD')) from dual;
       --EXTRACT(date from datetime):�Ӳ���datetime����ȡ����dateָ�������ݣ�������ȡ���ꡢ�¡��ա�
select extract(year from sysdate),extract(month from sysdate),extract(day from sysdate) from dual;
select extract(hour from systimestamp),extract(minute from systimestamp),extract(second from systimestamp) from dual;
select ename from emp where extract(year from hiredate) = 1980;

--10.(4)��ֵ������
select * from emp where comm is not null and comm != 0;
       --NVL(arg1,arg2):��nullת��Ϊ��nullֵ�����arg1Ϊnull������arg2�����򷵻ر���
select ename,nvl(comm,0) from emp;
select * from emp where nvl(comm,0)>0;
       --NVL(arg1,arg2),���arg1Ϊnull������arg2�����򷵻ر�������Ա�������루�¹��ʼӽ��𣨽������Ϊnull����
select ename, sal, comm, sal+nvl(comm,0) as "������" from emp;
       --NVL2(arg,res1,res2):���argΪnull���򷵻�res2,arg��Ϊnull�򷵻�res1.
select ename, sal, comm, nvl2(comm,comm+sal,sal) as"������" from emp;

--11.������ѯ���:
       --��ѯ����10�µ�Ա����Ϣ��
select * from emp where deptno = 10;
       --��ѯԱ������ְλ��'SALESMAN'��Ա����Ϣ
select * from emp where job = 'SALESMAN';

--12.��ѯ����:
       --��ѯְԱ����нˮ����2000��ְԱ��Ϣ
select ename, sal from emp where sal < 2000;
       --��ѯְԱ���в����ڲ���10��Ա����Ϣ
select * from emp where deptno <>10;
       --��ѯְԱ������1981��1��1���Ժ���ְ��ְԱ��Ϣ
select * from emp where hiredate > to_date('1981/01/01','YYYY/MM/DD');
       --��ѯнˮ����1000������ְλ��'CLERK'��ְԱ��Ϣ
select * from emp where sal>1000 and job='CLERK';
       --��ѯнˮ����1000������ְλ��'CLERK'��ְԱ��Ϣ
select * from emp where sal>1000 or job='CLERK';
       --NVL(arg1,arg2)��NVL2(arg,res1,res2)
       --��ѯнˮ����1000�����ҽ���Ϊnull��ְԱ��Ϣ
select * from emp where sal>1000 and comm>0;
select * from emp where sal>1000 and nvl(comm,0)>0;
select * from emp where (deptno=20 or deptno=30) and sal>800;
       --ģ����ѯ��LIKE
       --��ѯԱ������������'A'��ͷ��Ա����Ϣ
select * from emp where ename like 'ALLEN';
       --��ѯԱ�����������ڶ�����ĸ��'A'��Ա����Ϣ
select * from emp where ename like '_A%';
       --IN��NOT IN��
       --��ѯְλ�Ǿ������ְԱ��Ա����Ϣ
select * from emp where job in ('MANAGER','CLERK');
       --��ѯ���Ų���10��20��Ա��
select * from emp where deptno not in (10,20);
select * from emp where deptno <> all(10,20);
       --BETWEEN...AND...:��������ѯ����ĳ��ֵ��Χ���������ݡ�
       --��ѯнˮ��1500~3000֮���ְԱ��Ϣ
select * from emp where sal between 1500 and 3000;--[1500,3000]
       --��ѯ�Ⱦ�����͹��ʸߵ�Ա����Ϣ��
select * from emp where sal > any(select sal from emp where job='MANAGER');
       --��ѯԱ���Ĳ��ű��
select distinct(deptno) from emp;
select distinct deptno,job from emp;

--14.ORDER BY ����(д�������Ӿ����)
select ename, sal from emp order by sal;
select ename, sal from emp order by sal asc;
select * from emp where sal>2000 order by mgr desc;
       --�������򣬶�Ա�����е�ְԱ�����Ȱ��ղ��ű���������У��ٰ���нˮ�������С�
select ename, deptno, sal from emp order by deptno asc, sal desc;

--15.�ۺϺ���
       --MAX��MIN
select deptno,max(sal),min(sal) from emp group by deptno;
select max(hiredate),min(hiredate) from emp;
select ename from emp a where hiredate = (select max(hiredate) from emp);
             --ERROR:
select ename from emp a where hiredate = (select max(hiredate),min(hiredate) from emp);
             --RIGHT:
select ename from emp where hiredate in ((select min(hiredate) from emp), (select max(hiredate) from emp));
       --AVG��SUM
select avg(sal),sum(sal) from emp;
select avg(comm),sum(comm) from emp;--����nullֵ
       --COUNT
select count(*) from emp;
select count(comm) from emp;--����nullֵ
select count(*) from emp where comm is not null;
       --��ϣ���ۺϺ�������NULLֵʱ��
select avg(nvl(comm,0)) from emp;

--16.GROUP BY
select max(sal),min(sal),avg(sal) from emp group by deptno;
select deptno,max(sal),min(sal),avg(sal) from emp group by deptno;
select deptno,ename,max(sal),min(sal),avg(sal) from emp group by deptno,ename;
       --where���治��ʹ�þۺϺ���,����ִ��.
select max(sal),deptno from emp where max(sal)>4000 group by deptno;
       --��ѯ����������ʳ���4000�Ĳ����Լ�����ʡ�
select max(sal),deptno from emp group by deptno having max(sal)>4000;
       --�鿴���ű�ţ��Լ��ò��ŵ�ƽ�����ʣ�Ҫ���Ǹñ��ŵ�ƽ�����ʳ���2000��ְλ��PRESIDENT�Ĳ��ܲ���ͳ��)
select deptno, avg(sal) from emp where job<>'PRESIDENT' group by deptno having avg(sal)>2000;

--19.������ѯ
       --��ѯÿ��Ա�����ڲ�������
select ename, dname from emp, dept where emp.deptno=dept.deptno;
       --�鿴Ա�����֡����ʡ���������
select ename, sal, dname from emp e, dept d where e.deptno=d.deptno and loc='CHICAGO';
       --KING�����﹤���Լ����Ĳ��ű���Ƕ��٣�
select ename, e.deptno, loc from emp e, dept d where e.deptno=d.deptno and ename='KING';

--20.��������
       --������
select ename, dname from emp inner join dept on emp.deptno=dept.deptno;
       --������
              --���ٴ�һ�����и�������
create table empc as select * from emp;
             --��empc���в���һ�����ݣ����ź�Ϊ50
insert into empc(empno, ename, deptno)values(1000,'JACK',50);
select * from empc;
       --�������ӣ���ѯԱ���ı�š��������Լ��������ƣ������������κβ��ŵ�Ա����
select empno, ename, dname, empc.deptno from empc left outer join dept on empc.deptno=dept.deptno;
       --��������,��ѯԱ���ı�š��������Լ��������ƣ������κ�û��Ա���Ĳ��š�
select empno, ename, dname, c.deptno from empc c right outer join dept d on c.deptno=d.deptno;
       --ȫ�����ӣ���ѯԱ���ı�š��������Լ��������ƣ������������κβ��ŵ�Ա����Ҳ�����κ�û��Ա���Ĳ��š�
select empno, ename, dname, c.deptno from empc c full outer join dept d on c.deptno=d.deptno;
       --�����ӣ���ѯÿ��Ա�����ϼ��쵼
select e.ename, m.ename from emp e, emp m where e.mgr=m.empno;
select e.ename emp, m.ename mgr from emp e left outer join emp m on e.mgr=m.empno;
       --��ѯSMITH����˾���ĸ����й���
       --��ֵ����
select e.ename emp, m.ename mgr, d.loc mgrloc 
from emp e, emp m, dept d 
where e.mgr=m.empno and m.deptno=d.deptno and e.ename='SMITH';
       --������
select e.ename emp, m.ename mgr, d.loc mgrloc 
from emp e inner join emp m 
on e.mgr=m.empno and e.ename='SMITH'
inner join dept d
on m.deptno=d.deptno;

--(�����ӵ���һ��д��):��ѯÿһ��Ա����ͬʱ������Ա���Ĳ��ű�Ų�ѯ���ŵ���Ϣ������ѯ�������ţ���Ա���Ĳ�����Ϣ����null
select e.ename, e.sal, e.deptno from empc e;--ERROR
       --Solution 1.
select e.ename, e.sal,
(select d.deptno from dept d where d.deptno=e.deptno) deptno 
from empc e;--RIGHT
       --Solution 2.������������д����Ϊ����Ҫ��Ҫд��d.deptno
select e.ename, e.sal,d.deptno 
from empc e left outer join dept d 
on e.deptno=d.deptno;
       --Solution 3.�����ű�ʱ(���Ӳ������ű�)�����ַ����Ƚϼ�һЩ
select e.ename, e.sal,
(select d.dname from dept d where d.deptno=e.deptno) dname,
(select d.loc from dept d where d.deptno=e.deptno) loc
from empc e;

--21.�Ӳ�ѯ
       --WHERE:
       --�����Ӳ�ѯ����ѯ���ڲ��ź�20����߹��ʵ�Ա����Ϣ
select ename, sal from emp where sal>(select max(sal) from emp where deptno=20);
       --�����Ӳ�ѯ����ѯ��SCOTTͬ���ŵ�Ա����Ϣ
select ename, job from emp where deptno=(select deptno from emp where ename='SCOTT')
       --�����Ӳ�ѯ������нˮ����������ƽ��нˮ�ߵ�Ա��
select ename, job, sal from emp where sal>(select avg(sal) from emp);
       --�����Ӳ�ѯ����ѯ������SALESMAN��ְλ����SALESMAN��Ա������Ϣ��
select * from emp where deptno in (select deptno from emp where job='SALESMAN') and job<>'SALESMAN';
       --�����Ӳ�ѯ����ѯ��10�Ų���ĳ��Ա��������ȵ�Ա����Ϣ
select * from emp where sal = any (select sal from emp where deptno = 10);
       --�����Ӳ�ѯ��??????????????????????????????????????????????????????????????????????????
       --EXISTS�ؼ��֣��г�����Щ��Ա���Ĳ�����Ϣ
select deptno, dname from dept d where EXISTS (select * from emp e where e.deptno=d.deptno);
       --HAVING:
       --��ѯ��͹��ʸ��ڲ���30����͹��ʵĲ�����Ϣ
select min(sal) from emp group by deptno having min(sal)<(select min(sal) from emp where deptno=30);
       
--22.��ҳ��ѯ
       --��ѯrownum����2�����м�¼
select  rownum, e.* from emp e where rownum>2;--ERROR����Ϊû���κμ�¼��
select rownum, e.* from emp e where rownum>=1;
select rownum, e.* from emp e where rownum<6;
       --�ҵ�Ա�����й�����ߵ�ǰ�������������򣩣�
               --ERROR
select rownum, e.* from emp e order by sal desc where rownum<=3;
               --RIGHT
select * from emp order by sal desc;--�Ƚ����ٰ�������һ�ű���ȥѡrownumС�ڵ���3���С�
select rownum, t1.* from (select * from emp order by sal desc) t1 where rownum <=3;
       --��ѯ��6~10����¼(���ַ�����
select * from (select rownum rn, e.* from emp e) t where t.rn between 6 and 10;
select t1.* from (select rownum rn, emp.* from emp where rownum<=10) t1 where rn between 6 and 10;
       --���ʽ����ѡ6~10����¼��ԭ���Ƚ����ټ�α�У��ٵ��±�ѡ��Χ��
select * from (select rownum rn, e.* from (select * from emp order by sal desc) e) t where t.rn between 6 and 10;

--23.DECODE(����1��ֵ1�����1��ֵ2�����2...[,Ĭ��ֵ]);
       --��ѯְԱ������ְԱ��ְλ���㽱������ְλ�ֱ���'MANAGER','SALESMAN','ANALYST'ʱ��������ֱ���нˮ��1.2,1.1,1.05��������Ϊԭ����нˮֵ��
select ename, job, sal, decode(job,'MANAGER',sal*1.2,'SALESMAN',sal*1.1,'ANALYST',sal*1.05,sal) "����" from emp;
select decode(job,'MANAGER','VIP','ANALYST','VIP','OPERATION') from emp;
       --������������������
select decode(job,'MANAGER','VIP','ANALYST','VIP','OPERATION') job, count(*) from emp group by decode(job,'MANAGER','VIP','ANALYST','VIP','OPERATION');
       --�Զ�������
select * from emp order by decode(job,'MANAGER','1','SALESMAN','2','ANALYST','3');

--24
       --union
         --���ʴ���1500��20�Ų����µ�Ա��
select * from emp where sal>1500 or deptno=20;
         --���ʴ���1500��
select * from emp where sal>1500;--7����¼       
         --20�Ų����µ�Ա��
select * from emp where deptno=20;--5����¼
         --�������㣺union(�����ظ����ݣ�9����¼��������), union all(�������ظ����ݣ�12����¼��������)
select * from emp where sal>1500 union select * from emp where deptno=20;--����֮���ܹ�9����¼
       --INTERSECT������
select * from emp where sal>1500 INTERSECT select * from emp where deptno=20;
       --MINUS���������������
         --1981����ְԱ��(�������ܲú;���)
select * from emp where to_char(hiredate,'YYYY')='1981';
select * from emp where job in ('PRESIDENT','MANAGER');
select * from emp where to_char(hiredate,'YYYY')='1981' MINUS select * from emp where job in ('PRESIDENT','MANAGER');
       --ע�����
select empno,ename from emp where to_char(hiredate,'YYYY')='1981' MINUS select null,ename from emp where job in ('PRESIDENT','MANAGER');

--25.DDL�������
CREATE tablespace YYP datafile 'e:/YYP.dbf' size 100m autoextend on next 10m;--����
drop tablespace YYP;--ɾ����ȡ�����ļ��Ĺ���������ɾ���ļ�����ȡ������֮�󣬿����ֶ�ɾ������
create user zicheng identified by qqq default tablespace YYP;--�����û�
drop user zicheng cascade;--ɾ���û�
alter user zicheng identified by eee;--�޸�����
grant connect to zicheng;--��Ȩ
grant dba to zicheng;--�����ɫ
      --ʹ���Ӳ�ѯ�ķ�ʽ������
create table emp as select * from scott.emp;--ֻ���Ʊ�ṹ�ͱ����ݣ����Ḵ���е�Լ����
create table dept as select * from scott.dept where 1=2;--ֻ���Ʊ�ṹ��������,��Ϊ1=2Ϊfalse��
insert into dept select * from scott.dept;--ֻ���Ʊ�����,��ǰ���Ǳ�Ľṹ�����б�ṹһ�¡�
select * from dept;

--26.�е�Լ��
       --���Լ��
CREATE TABLE users(
      id number(10) primary key,--����
      name varchar2(20) unique,--Ψһ��ʶ
      sex varchar2(2) check(sex in ('��' ,'Ů')),--���Լ��
      salary number(10,2) check(salary>3000),
      create_time date default sysdate
);
insert into users values(1,'admin','��',3500,default);
       --���Լ��
create table category(
       id number(10) primary key,
       cname varchar2(10)
);
create table books(
       book_id number(10) primary key,
       book_name varchar2(20) not null,
       price number(10,2) check(price>100),--���Լ��
       cid number(10)  not null references category(id)--���Լ��
       --foreign key(cid) references category(id)--��һ�����Լ���ķ�ʽ
);
                 --���Բ��ڶ�����н������Լ���������ô����Ҳ��ʵ�����Լ����
alter table books add foreign key(cid) references category(id);
            --���ӣ�
insert into category values(1,'С˵');
insert into category values(2,'��ѧ');
insert into category values(3,'����');
select * from category;
insert into books values(1,'���μ�',101,1);
select * from books;
				 --����ɾ���������Ϊ�ӱ�������ص��ѽ������������Լ��
delete from category where id=1;
delete from books where cid=1;--ɾ��������������ַ���
update books set cid=null where cid=1;--Ȼ����ɾ�������е����ݾ�ok��

--27.��ͼ
       --����һ������ͼv_emp_10����ʾ����10�е�Ա���ı��롢������нˮ��
create view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10;
       --�޸���ͼ�����滻����ͼ���Ӳ�ѯ��ʹ��create or replace view ��ͼ�� ���ɣ�����ͼ�����ھʹ��������ھ��滻��������ͼʱ�����Ը��и��������
create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10;
       --��ѯ��ͼ
select * from v_emp_10;
       --��ͼ��DML����,���޸�ԭ�������
insert into v_emp_10 values(1,'Tony',8888,50)
select * from emp;
       --with check option
create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10 with check option
       --with read onlyֻ�������ܶ���ͼ����DML������
create or replace view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10 with read only;
       --����һ����ͼv_emp_salary,��ְԱ���е����ݰ����ŷ��飬���ÿ�����ŵ�ƽ��нˮ��нˮ�ܺ͡����нˮ��
create view v_emp_salary as select d.dname, avg(sal) avg_sal,sum(sal) sum_sal,min(sal) min_sal,max(sal) max_sal from emp e, dept d where e.deptno=d.deptno group by d.deptno, d.dname;
select * from v_emp_salary;
       --drop view ��ͼ���ƣ�ɾ����ͼ
drop view v_emp_slary;

--28.����
     --�����������С��������ɾ������
CREATE TABLE users(
      id number(10) primary key,--����
      name varchar2(20), --unique,--Ψһ��ʶ
      salary number(10,2),
      create_time date default sysdate
);
      --�������У�create sequence ������ start with **(��ʼ����) increment by **(����,ÿ�����Ӽ��������ɸ�) maxvalue **(���ֵ) / minvalue **(��Сֵ);
create sequence users_seq start with 100 increment by 10;--��������,��һ��һ��Ҫ��nextval��������currval
insert into users(id,name)values(users_seq.nextval,'��÷');--�������
select users_seq.currval from dual;--�鿴��ǰ����ֵ��
drop sequence users_seq;--ɾ������
     --ѭ������
begin
    for i in  1..10000
    loop
        insert into users(id,name,salary) values( users_seq.nextval,'˲�䱬ը',8888);
    end loop;
    commit;
end;

--29.����
    --����������create [unique] index �������� on ����(����)
create index idx_users_name on users(name);--��users���ename���Ͻ�������
    --��Ӷ���������
create index idx_users_salary on users(name,salary);
    --��ѯ�������Զ�Ӧ������������Ҫ����ȥ�ƶ�����߲�ѯ�ٶȡ�
select users.* from users order by name, salary;
    --�ع�������������ƽ����������޸ı������ع�һ��������ƽ���������
alter index �������� rebuild;--�����޸����ݵı������齨��������
    --ɾ��������
drop index idx_users_salary;









--��ϰ
create table student(
       id number(10) not null,
       name varchar2(20),
       hobby varchar2(100),
       school varchar2(20),
       create_time date
);
--�޸ı���student_t
rename student to student_t;
--����ֶΣ���Ŀproject���ɼ�score
alter table student_t add(project varchar2(20), score number(3));
--ɾ��ѧУ�ֶ�
alter table student_t drop(school);
--�޸��ֶθ�ʽ
alter table student_t modify(create_time varchar2(20) default sysdate);
--�޸ı����ֶ����ƣ�name��Ϊstu_name
alter table student_t rename column name to stu_name;

