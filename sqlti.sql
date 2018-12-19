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





