1~10 homework:
--1����USERS���в����Ա��ֶΣ���ָ��Ĭ��ֵΪ��
alter table userplus add(sex char(2) default '��');
--2��ɾ���������������˵���Ϣ
delete from userplus where username='����';
--3����ѯUSERS�����û�������
select username from userplus;
--4����ѯÿ���û��Ĺ����Ƕ���
select username, salary from userplus;
--5���鿴�����Ĺ���
select salary from userplus where username='����';
--6����ѯÿ���û�����н
select salary*12 as "��н" from userplus;
--7����ѯ�û����ʴ���2000���û���Ϣ
select * from userplus where salary > 2000;
--8���� ���� ���� ������ʾ
select username||': '||salary as "����������" from userplus;
--9����ѯUSERS����ÿ���û������ֳ���
select username,length(username) from userplus;
--10����ѯ����3λ���ϵ��û���š����������ʡ�����
select id, username, salary, job from userplus where length(username)>=3;

10~12 homework:
--1�����ѯ��DEPT�����в��ŵ������
select * from dept;
--2����ѯ��DEPT�еĲ��źš��������������ֶε�������Ϣ��
select deptno, dname from dept;
--3����ӱ�EMP�в�ѯ10�Ų��Ź����Ĺ�Ա�����͹��ʡ�
select ename, sal from emp where deptno=10;
--4����ӱ�EMP�в��ҹ�����ְԱCLERK����MANAGER�Ĺ�Ա���������ʡ�
select ename, sal from emp where job in ('CLERK','MANAGER');
--5������EMP���в��Ҳ��ź���10��30֮��Ĺ�Ա�����������źš����ʡ�������
select ename, deptno, sal, job from emp where deptno between 10 and 30;
--6����ӱ�EMP�в���������J��ͷ���й�Ա�����������ʡ�ְλ��
select ename, sal, job from emp where ename like 'J%';
--7����ӱ�EMP�в��ҹ��ʵ���2000�Ĺ�Ա�����������������ʣ��������ʽ������С�
select ename, job, sal from emp where sal<2000 order by sal desc;
--8���ڱ�EMP�в�ѯ���й��ʸ���JONES�����й�Ա�����������͹��ʡ�
select ename, job, sal from emp where sal>(select sal from emp where ename='JONES');
--9���г�û�ж�Ӧ���ű���Ϣ�����й�Ա�������������Լ����źš�
select ename, job, deptno from emp where deptno not in(select deptno from dept);
--10�����ҹ�����1000��3000֮��Ĺ�Ա���ڲ��ŵ�������Ա��Ϣ
select * from emp where deptno in (select distinct deptno from emp where sal between 1000 and 3000);
--11����ѯ���й�Ա��������SAL��COMM֮�͡�
select ename, sal, comm, NVL2(comm,comm+sal,sal) from emp;
--12����ѯ������CHICAGO�����ľ���MANAGER������ԱSALESMAN������������
select ename, sal from emp where deptno=(select deptno from dept where loc='CHICAGO') and job in('MANAGER','SALESMAN');
select a.ename, a.sal from emp a, dept b where a.deptno=b.deptno and b.loc='CHICAGO' and a.job in('MANAGER','SALESMAN');
--13����ѯ��ʾÿ����Ա���빫˾��׼ȷʱ�䣬����������������¡����� ʱ������ʾ��
select ename, to_char(hiredate,'YYYY"��"MM"��"DD"��" HH:MI:SS') from emp;

13~18 homework:
select * from dept
select * from emp
--1.�г�������һ��Ա�������в��š�
select deptno from emp group by deptno having count(empno)>=1;
--2.�г�н��ȡ�SMITH���������Ա����
select * from emp where sal>(select sal from emp where ename='SMITH');
--3.�г����н�����1500�ĸ��ֹ�����
select distinct(job) from emp group by job having min(sal)>1500;
--4.��ѯ����20,30 �еĸ�λ����"CLERK"��"SALESMAN"������Ա����Ϣ
select * from emp where deptno in (20,30) and job not in('CLERK','SALESMAN');
--5.��ѯ��ƽ��Ա�����ʸߵ�Ա����Ϣ
select * from emp where sal > (select avg(sal) from emp);
--6.�ҳ�����10�����о���Ͳ���20�����а���Ա����ϸ���ϡ� 
select * from emp where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK');
--7.��ʾ�����С�R���Ĺ�Ա������ 
select ename from emp where ename not like '%R%';
--8.��ʾ��Ա������������������ޣ������ϵĹ�Ա������ǰ�档 
select ename, hiredate from emp order by hiredate asc;
--9.����ÿ����Ա����ʾ����빫˾������ 
select ename, trunc(sysdate-hiredate+1) as "����" from emp;
--10.��ѯ����ְλ��ƽ�������Ƕ��٣�
select job, avg(sal) from emp group by job;
--11.�鿴ÿ�������ж�����
select deptno, count(*) from emp group by deptno;
--12.�鿴ÿ��ְλ��ƽ�������빤���ܺ�
select job, avg(sal),sum(sal) from emp group by job;
--13.���emp�������в��ŵ����нˮ�����нˮ�����ű��Ϊ10�Ĳ��Ų���ʾ��
select deptno, max(sal), min(sal) from emp where deptno<>10 group by deptno;
--14.��ѯ���������С�A���ַ�������нˮ��1000���ϣ�������1000��������Ա����Ϣ��
select * from emp where ename like '%A%' and sal>1000;
--15.��ʾнˮ����˵�ְλ��
select job from emp where sal=(select max(sal) from emp);
select job from emp where sal>=all(select sal from emp);
--16.�г�����Ա�����깤��,����н�ӵ͵������� 
select ename, sal*12 as "��н" from emp order by sal;

19~21 homework:
select * from emp;
select * from salgrade;
--1.��ʾԱ�����еĲ��ظ��ĸ�λjob 
select distinct(job) from emp;
--2.��ѯ10���Ź��ʴ���3000��Ա����Ϣ��Ҫ��Ա������ְʱ����ǰ�������� 
select * from emp where deptno=10 and sal>3000 order by hiredate;
--3.�г��������ŵ�MANAGER �����н��
select deptno,min(sal) from emp where job='MANAGER' group by deptno;
--4.��ѯ����Ա���Ĺ����ص㣬����û��Ա���ĵص�ҲҪ��ʾ
select ename,loc from dept d left outer join emp e on d.deptno=e.deptno;
--5.��ѯ���е�Ա����Ϣ�Ͳ������ƣ������������κβ��ŵ�Ա��
select empno, ename, dname, e.deptno from emp e left outer join dept d on e.deptno=d.deptno;
--6.�г���"SCOTT"������ͬ����������Ա������������
select empno, ename, job, dname from emp e,dept d where e.deptno=d.deptno and job=(select job from emp where ename='SCOTT');
--7.�г��ܹ���������ֱ���ϼ�������Ա���ı�ţ���������������
select empno, ename, e.deptno, dname from emp e,dept d where e.deptno=d.deptno and hiredate<(select hiredate from emp m where e.mgr=m.empno);
--8.�г�ְλΪ��CLERK����Ա�������������ڲ������ƣ���������
select ename, dname, t.b from emp e, dept d, (select deptno,count(*) b from emp group by deptno) t where e.deptno=d.deptno and e.deptno=t.deptno and job='CLERK';
--9.��ѯ������4��Ա���Ĳ��ŵĲ�������
select e.deptno, count(*),dname from emp e, dept d where e.deptno=d.deptno group by e.deptno,dname having count(*)>4;
select d.dname from dept d where deptno in (select deptno from emp group by deptno having count(*)>4);
       --�Լ�д��
select d.deptno, d.dname, t.count from emp e, dept d, (select count(*) count from emp a group by deptno) t where e.deptno=d.deptno and t.count>4;
--10.��ѯ���ʸ���30�Ų��ŵ�����Ա���Ĺ��ʵ�Ա�����������ʼ���������
select ename, sal, e.deptno, dname from emp e,dept d where sal>(select max(sal) from emp where deptno=30);
--11.��ѯ����KING�����ڲ��ŵĲ��ű�š����������Լ��ò������Ա������
select e.deptno, dname, count(*) from emp e,dept d where e.deptno=d.deptno and e.deptno=( select deptno from emp where ename='KING') group by e.deptno,dname;
      --�Լ�д�ģ���̫�ã�
select e.deptno, dname, e.deptno,(select count(*) count from emp where deptno= (select deptno from emp where ename='KING')) from emp e, dept d where e.deptno=d.deptno and ename='KING';
--12.��ѯƽ��������ߵĲ��ŵĲ��ű�š��������ƺ͸ò��ŵ�ƽ������
select e.deptno, d.dname, avg(sal) from emp e, dept d where e.deptno=d.deptno group by e.deptno,d.dname having avg(sal)>=all(select avg(sal) from emp group by deptno);
       --�Լ�д��
select deptno from emp group by deptno having avg(sal)>=all(select avg(sal) from emp group by deptno);
--13.���ʵȼ�Ϊ2�ȼ��� Ա����Ϣ�������ڲ��ŵ���Ϣ
select * from emp e,dept d, salgrade s where e.deptno=d.deptno and s.grade=2 and e.sal between s.losal and s.hisal;
       --�Լ�д��
select e.ename, e.sal from emp e,dept d, (select losal, hisal from salgrade where grade=2) t where e.deptno=d.deptno and e.sal between t.losal and t.hisal;
--14.10�Ų��ŵĲ�����Ϣ  ��Ա��Ϣ ���ʵȼ�
select d.*,e.*,s.grade from emp e,dept d, salgrade s where e.deptno=d.deptno and e.deptno=10 and e.sal between s.losal and s.hisal;
       --�Լ�д��
select ename, sal, (select t.grade from salgrade t where e.sal between t.losal and t.hisal) grade from emp e where deptno=10;
--15.��ѯ����쵼�ߵ�нˮ�ȼ� 
select grade from salgrade where (select sal from emp where mgr is null) between losal and hisal
       --�Լ�д��
select ename, sal, (select t.grade from salgrade t where e.sal between t.losal and t.hisal) grade from emp e where mgr is null;
--16.SQL����ִ�й��̼���ÿ���Ӿ�����ã�
FROM,WHERE,GROUP BY,HAVING,SELECT,ORDER BY
--17.���ݿ����������ͼ����ȼ���
();���������*,/,+,-;���ӷ�||;�Ƚ������=, >, <, >=, <=, <>, !=, is null(is not null), between...and..., in;�߼������not, and, or
--18.���ݿ�ĺ������ࣿ
DDL,DML,TCL,DQL,DCL
�ַ�,��ֵ,����,ת��
--19.������ĸ�����
ԭ����    
һ���� 
������
�־���

--С�ܽ᣺
--SQL����ִ�й��̼���ÿ���Ӿ�����ã�
(1)ͨ��FROM�Ӿ����ҵ���Ҫ��ѯ�ı�
(2)ͨ��WHERE���зǷ��麯����ɸѡ�жϡ�
(3)ͨ��GROUP BY�Ӿ���ɷ��������
(4)ͨ��HAVING�Ӿ�����麯��ɸѡ�жϡ�
(5)ͨ��SELECT�Ӿ�ѡ��Ҫ��ʾ���л���ʽ���麯����
(6)ͨ��ORDER BY�Ӿ�������������

--���ݿ����������ͼ����ȼ���
();
���������*,/,+,-;
���ӷ�||;
�Ƚ������=, >, <, >=, <=, <>, !=, is null(is not null), between...and..., in;
�߼������not, and, or

--���ݿ�ĺ������ࣿ
���к�����CONCAT(c1,c2), LENGTH(ch), UPPER(�ֶ���), LOWER(�ֶ���), INITCAP(�ֶ���), TRIM('e'FROM'ee'), LTRIM('ee','e'), RTRIM('ee','e'), LPAD(ch1, m, ch2), RPAD(ch1, m, ch2), SUBSTR��ch,m,n), INSTR(ch1,ch2,m,n)
��ֵ������ROUND(n,m), TRUNC(n,m), MOD(m,n), CEIL(n), FLOOR(n)
���ں�����sysdate, systimestamp, LAST_DATE(date), ADD_MONTHS(date,i), MONTHS_BETWEEN(date1,date2), LEAST(date1,date2), GREATEST(date1,date2), EXTRACT(date from datetime)�ۺϺ�����count(),avg(),sum(),max(),min(),
ת��������
        ��ʾת����TO_DATE(), TO_CHAR()
        ��ʽת���������������ַ�������ͨ����ת��Ϊ�ַ�����
ͨ�ú�����NVL(), NVL2()
���к���(�ۺϺ���)��MAX()���ֵ, MIN()��Сֵ, SUM()���, AVG()ƽ��ֵ, COUNT()ͳ��

--�ṹ����ѯ���Է�������ã�
SQL���ࣺ
		DDL�����ݶ������ԣ����ڲ������ݶ��󣨱���ͼ�����У���������
				CREATE�����������������
				ALTER���޸ı����������ṹ��
				DROP��ɾ�������������
				TRUNCATE��ɾ�������ݣ�������ṹ����ձ�Ĳ�����
		DML�����ݲ������ԣ�ͨ����Ҫ����TCL����������ɾ�ı��е����ݡ�
				INSERT INTO�������ݲ�����С�
				DELETE��ɾ���������ݡ�
				UPDATE SET�����±������ݡ�
		TCL������������ԡ�
				COMMIT���ύ��
				ROLLBACK���ع���
		DQL�����ݲ�ѯ����
				SELECT����ѯ���ݡ�
		DCL�����ݿ������ԡ�
				GRANT������Ȩ�ޡ�
				grant��create��view��to��scott;
				
--��������ԣ�
ԭ����(Atomicity):
��	ԭ������ָ������������в���Ҫôȫ���ɹ���Ҫôȫ��ʧ�ܻع����������Ĳ�������ɹ��ͱ���Ҫ��ȫӦ�õ����ݿ⣬�������ʧ�����ܶ����ݿ����κ�Ӱ�졣
һ����(Consistency):
	һ������ָһ������ִ��֮ǰ��ִ��֮�󶼱��봦��һ����״̬����ת����˵�������û�A���û�B���ߵ�Ǯ������һ����5000����ô����A��B֮�����ת�ˣ�ת�����ˣ���������������û���Ǯ�������Ӧ�û�����5000������������һ���ԡ�
������(Isolation):
�����������ǵ�����û������������ݿ�ʱ���������ͬһ�ű�ʱ�����ݿ�Ϊÿһ���û����������񣬲��ܱ���������Ĳ��������ţ������������֮��Ҫ�໥���롣
�־���(Durability):
�����־�����ָһ������һ�����ύ�ˣ���ô�����ݿ��е����ݵĸı���������Եģ������������ݿ�ϵͳ�������ϵ������Ҳ���ᶪʧ�ύ����Ĳ�����

--Oracle���ݿ��Դ��﷨��ͨ�ñ�׼��SQL99�﷨��
Oracle���ݿ��Դ��﷨��
	(1)�ѿ�������
	(2)�����ӣ�a.��ֵ����
			   b.�ǵ�ֵ����:���Ա����š����������ʡ����ʵȼ���select e.empno, e.ename, e.sal, s.grade from emp e, salgrade s where e.sal between s.losal and s.hisal;
			   c.�������ӣ�select empno, ename, dname from emp e, dept d where e.deptno=d.deptno(+);--��ѯԱ���ı�ţ��������������ƣ������������κβ��ŵ�Ա����
			   d.�������ӣ�select empno, ename, dname from emp e, dept d where e.deptno(+)=d.deptno;--��ѯԱ���ı�ţ��������������ƣ�����û��Ա���Ĳ��š�
			   e.�����ӣ�
ͨ�ñ�׼��SQL99�﷨��
	(1)�������ӣ��������Ӻ͵ѿ�����������ģʽ��ͬ�����Ǳ�1�е�ÿһ�ж����2�е������н���һ�����ӡ�select * from emp cross join dept;
	(2)��Ȼ���ӣ�select * from emp natural join dept;--���ܹ�ƥ�䵽��ֵ���������Լ������ͬ���У�����ô���ǵ�ֵ���ӵĽ��.����dept���е�ֵ���ӡ�
				select * from emp natural join salgrade;--������ƥ�䵽��ֵ��������ô������ǽ������ӡ�
	(3)�������ӣ�left outer join
	(4)�������ӣ�right outer join
	(5)ȫ�����ӣ�full outer join
	
--�����е�Լ����
����Լ����primary key ����Ϊ�գ�����Ψһ��
�ǿ�Լ����not null 
ΨһԼ����unique
���Լ����check(����) ��MySql���ǿ���д�ģ���MySql��ֱ�Ӻ��Լ�顣price number(10,2) check(price>100),--���Լ�����ڴ������ʱ��ֱ��д(��primary key, not null, uniqueһ��λ�û�֮��)
���Լ������Ҫ������Լ���ӱ�A�еļ�¼�����Ǵ���������B��(��֤����������)��
	(1)references �����(��������), --�ڴ������ʱ��ֱ��д(��primary key, not null, unique, checkһ��λ�û�֮��)
	(2)foreign key(�Լ�������) references �����(��������)--��һ�����Լ���ķ�ʽ��д�����һ�����ŵ�ǰ��
	(3)alter table books add foreign key(cid) references category(id);--���Բ��ڶ�����н������Լ���������ô����Ҳ��ʵ�����Լ����

--��һ��sql�����emp���й��ʴӴ�С����4��5��6λ���ʣ�
select * from (select rownum rn, e.* 
from (select ename, sal from emp order by sal desc) e where rownum<=6)t 
where t.rn >=4;