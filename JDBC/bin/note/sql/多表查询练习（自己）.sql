--1.�г��������ƺ���Щ���ŵ�Ա����Ϣ��ͬʱ�г���Щû��Ա���Ĳ���
select dname, e.* from dept d left outer join emp e on d.deptno=e.deptno;
--2.�г���ÿ�����Ź�����Ա��������ƽ�����ʡ�
select count(ename), avg(sal) from emp e right outer join dept d on d.deptno=e.deptno group by d.deptno;
--3.�г�����Ա�����������������ƺ͹��ʡ�
select ename, dname, sal from emp e, dept d where e.deptno=d.deptno;
--4.��ѯÿ�����ŵĲ��ű�ţ��������ƣ�������������߹��ʣ���͹��ʣ������ܺͣ�ƽ������
select d.deptno, dname, count(*), max(sal), min(sal), sum(sal), avg(sal) from emp e, dept d where d.deptno=e.deptno group by d.deptno, dname;
--5.��ѯÿ������������������������ţ�����������Ҫ�����û�о������Ա��Ϣ��
select count(e.ename), m.empno,m.ename from emp e left join emp m on e.mgr=m.empno group by m.empno,m.ename
--6.��ѯ������������2�Ĳ��ű�ţ��������ƣ���������
select d.deptno, d.dname, count(*) from emp e, dept d where e.deptno=d.deptno group by d.deptno, d.dname having count(*)>2;
--7.��ѯ����ƽ��������2500Ԫ���ϵĲ������Ƽ�ƽ�����ʡ�
select d.dname, avg(sal) from emp e, dept d where e.deptno=d.deptno group by d.dname having avg(sal)>2500;
--8.��ѯԱ����λ�в�����"SA"��ͷ����ƽ�������� 2500Ԫ���ϵĸ�λ��ƽ�����ʣ�����ƽ�����ʽ�������
select job, avg(sal) from emp where job not like 'SA%' group by job having avg(sal)>2500 order by avg(sal) desc
--9.��ʾ�������;����������������������Ա������͹��ʣ�û�о����KINGҲҪ��ʾ��
--��������͹���С��3000�ģ�����͹����ɸߵ�������
select m.empno, m.ename, min(e.sal) from emp e left outer join emp m 
on e.mgr=m.empno group by m.empno, m.ename having min(e.sal)>=3000 order by min(e.sal) desc;
--10.��ѯ����ƽ�����ʴ���2000������������2�Ĳ��ű�ţ��������ƣ���������������ƽ�����ʣ������ղ���������������
select d.deptno, d.dname, count(*), avg(sal) from emp e, dept d 
where e.deptno=d.deptno group by d.deptno, d.dname 
having count(*)>2 and avg(sal)>2000 order by count(*);
--11.��ѯ������͹��� ����10�Ų��� ��͹��ʵĲ��ŵı�š����Ƽ�������͹��ʡ�
select d.deptno, dname, min(sal) from emp e, dept d where d.deptno=e.deptno group by d.deptno, dname 
having min(sal)>(select min(sal) from emp where deptno = 10);
--12.��ʾ30�Ų��ŵĹ�Ա�����µĲ��ظ��Ĺ������ƣ�����ʾ30���ŵ����ڵء�
select distinct job, d.loc from emp e, dept d where d.deptno=e.deptno and e.deptno=30;
--13.��ѯ������'CHICAGO'��Ա����������߹��ʼ���͹��ʡ�
select count(empno),max(sal),min(sal) from emp e, dept d where d.deptno=e.deptno and loc='CHICAGO';
--14.ͳ�Ƹ������Ų�ְͬ���Ա��нˮ���ܺͣ�ƽ������,���ű�ţ���������,����λ�ã�ְ��
select sum(sal),avg(sal),d.deptno,dname,loc, job from emp e, dept d where d.deptno=e.deptno group by d.deptno,dname,loc, job;
