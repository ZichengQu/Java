���ݿ�//297��308,415
һ��	ʹ��sqlplus�������ݿ�
	1.	��ʽ��
	1��	sqlplus���س�������û���������
	2��	sqlplus/nolog  ------conn scott/tiger
	3��	ʹ�ÿ��ӻ����棬developer��ע�⣺ʹ�ô������ӿ��ӻ�����ȴ�������ӣ�������޷�����޼���������Ҫ�������ü�������a.�رշ��� b.�������ü����ļ��޸�HOSTΪ��ǰIP�����޸�Ϊlocalhost����127.0.0.1������������ c.�ٿ��������������ӵ�½���ɡ���
	2.	�����ע�����
	1��	����sql����ԡ�;����β���س�ִ�С�
	2��	sql��䲻���ִ�Сд���ַ������⡣
	3.	Oracle�û���oracle��װ����Զ�����4���˻�����
	1��	sys�û��������û����������Ȩ�ޣ�����sysdba�����ݿ����Ա����ɫ���������ֵ����ͼȨ�ޣ��ܴ������ݿ⣬Ĭ������manager��
	2��	system�û�������Ա�������ڳ����û�������sysoper(ϵͳ����Ա)��ɫ�����ܴ����⡣
	4.	DB��Database���ݿ⣬��ϵ�����ݿ⣬�������ݽṹ���������ݵĲֿ⣬�Զ�ά��(�У��ֶΣ� �У�����)����ʽ�洢���ݡ�
	DBMS�����ݿ����ϵͳ��Oracle, mysql, sqlserver����
����	sql���
	1.	SQL ��Structed Query Language,�ṹ����ѯ���ԣ�
	2.	SQL���ࣺ
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
	3.	�������ͣ�
		char(n)�������ַ�����n���ֽ��������2000�ֽڡ�
		varchar2(n):�䳤�ַ�����n���ֽ��������4000�ֽڡ�
		number(n,m):n������λ���֣�m�����м�λС����
		date:ʱ�����ڣ�select sysdate from dual;
����SQL��DDL�� DML��TCL��DQL��
����Ĺ��ɣ�
	1.ǰ�ˣ�HTML��CSS��JS��JQuery
	2.��̨��Java
	3.���ݿ⣺Oracle�� Mysql�����׹����չ���

1.��װOracle

  �����û���
    sys�������û�  �������Ȩ��  ����sysdba��ɫ �����ݿ����Ա��
         �д������ݿ��Ȩ�� 
    system���������Ա  Ȩ�޽����ڳ�������Ա   

    scott:��ͨ�û� һ��������ϰ    scott -- tiger
	�����û���alter user scott account unlock
	�������룺alter user scott identified by tiger
   
2.��¼��ʽ
  1��sqlplus �س�
     �����û���
     ��������

  2��sqlplus/nolog
     conn scott/tiger

3.  DB��DataBase �������ݽṹ���������ݵĲֿ�(��ϵ�����ݿ�),�Զ�ά����ʽ�洢����(����У��ֶ���  ����У�����)
    DBMS�����ݿ����ϵͳ(mysql��oracle��SqlServer)
	
4.��������
    sqlplus  �����ݿ�
    conn  �û���/����    �������ݿ�
    show user; ��ʾ��ǰ�û�
    exit;  �Ͽ�����
    quit;  �Ͽ�����
	
5.SQL:�ṹ����ѯ����
  SQL�ķ��ࣺ
	  DDL ���ݶ�������  ���ڲ������ݶ��󣨱� ��ͼ ���� ������
	  DML ���ݲ�������  ������ɾ�ı��е�����(ͨ����������)
	  TCL �����������  �������ݵ��ύ�ͳ���
	  DQL ���ݲ�ѯ����  ���ڲ�ѯ���ݼ�¼
	  DCL ���ݿ�������  ����ִ��Ȩ�޷���
	  
	  DDL�����ݶ�������
		   ---���ڲ������ݿ���󣨱� ��ͼ ���� ������
		   CREATE���������������������
		   ALTER���޸ı����������Ľṹ
		   DROP��ɾ�������������Ľṹ
		   TRUNCATE����ձ�(ɾ���������ݣ�������ṹ) 
	  DML�����ݲ�������
		   ---������ɾ�ı��е�����(ͨ�����������������)
		   INSERT INTO�������ݲ��뵽����
		   DELETE��ɾ���������� ---- WHERE
		   UPDATE ���� SET�����±������� --- WHERE
		   
      TCL�������������
		   COMMIT���ύ--����
           ROLLBACK���ع�---����
   
      DQL�����ݲ�ѯ����
           SELECT ��ѯ*****

      DCL�����ݿ�������
           ����ִ��Ȩ�޷��� GRANT REVOKE
6.DDL ���ݶ�������
	�鿴�û�����ı�
		SELECT table_name FROM user_tables;--�û���������б��ᱻ�г���
	(1)������
		CREATE TABLE ���� (
			����(�ֶ���)  �������� [Ĭ��ֵ  Լ��],
			����(�ֶ���)  �������� [Ĭ��ֵ  Լ��],
			����(�ֶ���)  �������� [Ĭ��ֵ  Լ��],
			����(�ֶ���)  �������� [Ĭ��ֵ  Լ��]
		);
		CREATE TABLE users(
			id number(10) primary key,
			name varchar2(20) not null unique,
			salary number(10,2),
			create_time date default sysdate
		);
		id(����) �ص㣺���������ű���ÿһ���������ֵ������ͬ���ұ�����ֵ���ǿ���Ψһ��
		��������
			������������
			1����������ĸ��ͷ
			2��������1-30���ַ�֮��
			3������ֻ�ܰ���A-Z,a-z,0-9,_,$,��#
			4�����벻�ܺ��û������������������
			5�����벻����Oracle�ı�����
		��������:
			1��NUMBER:��ֵ����
			   NUMBER(X):x����λ��  
						 NUMBER(3)  ����ܴ��3λ��
			   NUMBER(X,Y):x��ʾ����λ  y��ʾ�����м�λ��С��
						   NUMBER(6,2) 8888.88
			2��CHAR:�����ַ���
			   CHAR(X):X��ʾ��ռ�����ֽ�   ����2000�ֽ�
			3��VARCHAR2:�䳤�ַ���
			   VARCHAR2(X):X��ʾ��ռ�����ֽ�(�������б�������ݳ��ȣ�ռ�õĿռ��Ǳ仯��)  ���4000�ֽ�
			4��DATE ʱ������ SELECT SYSDATE FROM DUAL;
			α��dualȷʵ��һ�ű���һ��ֻ��һ��һ�еı�ϰ���ϳ�Ϊα����Ϊ�����洢��������ݡ�
		�鿴��ṹ(��command window)��DESC table_name;
	(2)ɾ����
		DROP TABLE users;--ɾ�������ݺͽṹ
		TRUNCATE TABLE users;--ɾ�������ݣ�������ͱ�ṹ
	(3)�޸ı�(ALTER):
		�޸ı�����RENAME old_name TO new_name
		�޸ı�ṹ��
			���������ֶΣ�ֻ����ӵ���󣬲��ܲ��뵽���е������У���ALTER TABLE table_name ADD(�ֶ�������������[Ĭ��ֵ Լ��]), ���磺ALTER TABLE usersplus ADD(school varchar2(20))
			ɾ�����������ֶΣ� ALTER TABLE biaoming DROP(�ֶ����������磺ALTER TABLE userplus DROP(school��
			�޸ı��������ֶεĸ�ʽ��ALTER TABLE ���� MODIFY(�ֶ�������������[Ĭ��ֵ Լ��])�����磺ALTER TABLE userplus MODIFY(salary number(10))
			�޸ı����ֶ����ƣ�ALTER TABLE userplus RENAME column name to username
7.DML ���ݲ�������
	(1)�����������ݣ�
		ȫ�ֶβ������ݣ�INSERT INTO ���� VALUES(1, '����', 8000,sysdate, '����Ա'); ע�⣺values�е�����˳��Ҫ�Ͷ����ֶ�ʱһ�¡�
		�����ֶβ������ݣ�INSERT INTO ����(��Ҫ�������ݵ��ֶ�)VALUES(���ֶ�˳�����Ӧ������)��
	(2)�޸ı����������ݣ�
		���޸ı�������ʱ��ͨ�����where�Ӿ����޶�Ҫ�޸ĵļ�¼��������ֻ���޸�����where�����ļ�¼�������޸�ȫ��
		UPDATE ���� SET �ֶ���=���� WHERE �ֶ���=����
	(3)ɾ���������ݣ�
		DELETE FROM ���� WHERE �ֶ���=���ݡ�ͨ����where�Ӿ����ã�����ɾ�������������ݡ�
		��DDL����е�TRUNCATE���ͬ����ɾ�������ݵ����á�
		TRUNCATE��DELETE������DELETE������������ɾ�����ݣ���TRUNCATE�����е�����ȫ��ɾ����DELETE��DML���ԣ�����rollback��TRUNCATE������������ԣ�������Ч���޷�rollback.
		ɾ��ȫ����¼��DELETE FROM userplus(Ч�ʵ�); TRUNCATE TABLE userplus(Ч�ʸ�).
8.TCL�������������
	(1)commit:�ύ�� ����ͨ������ťȥ�ύ�����������ر����ݿ�ʱ��Ĭ���ύ��
	(2)rollback���ع���
	������ĸ����ԣ�
		ԭ����(Atomicity):
��	��		ԭ������ָ������������в���Ҫôȫ���ɹ�ȫ��Ӧ�ã�Ҫôȫ��ʧ�ܻع����������Ĳ�������ɹ��ͱ���Ҫ��ȫӦ�õ����ݿ⣬�������ʧ�����ܶ����ݿ����κ�Ӱ�졣
		һ����(Consistency):
			һ������ָһ������ִ��֮ǰ��ִ��֮�󶼱��봦��һ����״̬����ת����˵�������û�A���û�B���ߵ�Ǯ������һ����5000����ô����A��B֮�����ת�ˣ�ת�����ˣ���������������û���Ǯ�������Ӧ�û�����5000������������һ���ԡ�
		������(Isolation):
����		��������ָ�����������֮��Ҫ�໥���롣������û������������ݿ�ʱ���������ͬһ�ű�ʱ�����ݿ�Ϊÿһ���û����������񣬲��ܱ���������Ĳ��������š�
		�־���(Durability):
����		�־�����ָһ������һ�����ύ�ˣ���ô�����ݿ��е����ݵĸı���������Եģ������������ݿ�ϵͳ�������ϵ������Ҳ���ᶪʧ�ύ����Ĳ�����
9.DQL�����ݲ�ѯ����
	������ѯ�����SELECT�Ӿ��FROM�Ӿ���ɡ�
	SELECT��ָ����ʾ���ֶ����ƣ� FROM��ָ��������Դ��
	(1)��ѯ���У�SELECT * FROM ����;
	(2)��ѯ����������Ϣ��SELECT field1, field2 FROM table_name where �޶�����;
	ע�⣺SELECT������ʾ�ֶΣ����ʽ�������� <>�ǲ����ڡ����������ƽϳ��������ڲ�ѯ�����������ʾ���������б�����
	      SELECT salary*12 "��н" FROM userplus WHERE username='����';--����
		  SELECT salary*12 AS "��н" FROM userplus WHERE username='����';--����
		  �������������ֿ�ͷ���������ֻ���ſ�ͷ��������Ҫ��""���ϡ�
10.���ú���(���к���):4
	(1)�ַ���������13
		CONCAT(c1,c2),�����ַ�������c1,c2�����ֶ�ƴ����ʾ�����磺SELECT CONCAT(CONCAT(ename, ': ') ,sal)from EMP;
		||���Ӷ���ַ������š����磺SELECT ename||': '||sal as "����������" from EMP;
		LENGTH(ch):��ʾ�ַ������ȣ� ���磺SELECT LENGTH(ename) from EMP;
		UPPER(�ֶ���)��ת��д
		LOWER(�ֶ���): תСд
		INITCAP(�ֶ���): ֻ������ĸ��д
		TRIM():ȥ���ַ���ǰ��ָ�����ݡ����磨�Ҳ�д�ַ�������SELECT TRIM('E' from 'EEHELLO WORLDEEE') from dual; SELECT ename, trim('A' FROM ename) from emp; --ȥ��Ա������ǰ���'A'
		LTRIM('',''):ȥ���ַ��ش����ָ�����ݡ����磨���д�ַ�������SELECT LTRIM('EEHELLO WORLDEEE', 'E') from dual;
		RTRIM('',''):ȥ���ַ����Ҳ�ָ�����ݡ�
		LPAD(ch1, m, ch2): ��λ������ch1��Ҫ��ѯ��ʾ�����ݣ�mָ��λ��������λ������ʱ��ch2���в�λ����emp����ʹ����λ����sql��0����6λ�����磺select ename, LPAD(sal, 6, 0) AS salary from emp
		RPAD(ch1, m, ch2): �Ҳ�λ������
		SUBSTR��ch,m,n):��ȡ�ַ�������ȡch����ַ�������m��ʼ��ȡ������ȡn������mΪ���������ǴӺ���ǰ�����±��ѯ���Ӷ����н�ȡ��
		INSTR(ch1,ch2,m,n):����ch1��ch2���ֵ�λ�ã�m������ĸ�λ�ÿ�ʼ������n����ڼ��γ��֣���ָ��m��n��Ĭ��ֵ����1���±��1��ʼ����ƥ�����ݵ�ʱ�򷵻�0.
	(2)���ֺ�����5
		ROUND(n,m):�����������룬�����е�n�������κ�����(Ҫ�����������);m������������mȡ�������������뵽С������mλ��mȡ0���������뵽����λ(mȱʡ��Ĭ����0)��mȡ�������������뵽С����ǰmλ��
		TRUNC(n,m):��ȡ����û����������
		MOD(m,n):����m����n���������nΪ0��ֱ�ӷ���m��
		CEIL(n):����ȡ�������ڸ�������С������
		FLOOR(n):����ȡ����С�ڸ��������������
	(3)���ں���:11
		sysdate:���ص�ǰ��ϵͳʱ�䣬��ȷ���롣
		systimestamp:ʱ��������ص�ǰϵͳ���ں�ʱ�䣬��ȷ�����롣
		(1)TO_DATE():����ת���������൱��Java�е�SimpleDateFormat��parse()���������������ַ������ո��������ڸ�ʽת��ΪDate��
			select to_date('2018-12-01 11:30','YYYY-MM-DD HH:MI:SS') from dual;
			select to_date('2018-12-01 13:30','YYYY-MM-DD HH24:MI:SS') from dual;     
		(2)TO_CHAR():���ڽ�DATE���ո��������ڸ�ʽת��Ϊ�ַ�����
			select ename, to_char(hiredate,'YYYY-MM-DD HH:MI:SS') from emp;
			select ename, to_char(hiredate,'YYYY"��"MM"��"DD"��"') from emp;
		(3)LAST_DAY(date):����ָ�����������µ����һ�졣
		(4)ADD_MONTHS(date,i):��������date����i���º������ֵ����i�Ǹ��������õ��Ǽ�ȥi���º������ֵ��
		(5)MONTHS_BETWEEN(date1,date2):������������֮�������ٸ���;��date2ʱ���date1ʱ������õ���ֵ�������������ڼ���������£������õ���С��λ�Ľ����
		(6)date�������������ݿ��п��Խ��м������������������������select ename, sysdate-hiredate from emp;
		(7)LEAST(date1,date2):��ʾ����ʱ���е���Сֵ���������ͱ���һ�¡�
		(8)GREATEST(date1,date2):��ʾ����ʱ���е����ֵ���������ͱ���һ�¡�
		(9)EXTRACT(date from datetime):�Ӳ���datetime����ȡ����dateָ�������ݣ�������ȡ���ꡢ�¡��ա�
	(4)��ֵ������2
		null�ĺ��壺��ʱ���е�ĳЩ�ֶ�ֵ����δ֪����ʱ�����ڣ�ȡֵnull����Java���������͵�Ĭ��ֵΪnull����sql�У��κ��������;���ȡֵΪnull��
		null������ѯ:�������κ�ֵ�� is null �� is not null.
		NVL(arg1,arg2):��nullת��Ϊ��nullֵ�����arg1Ϊnull������arg2�����򷵻ر���arg1��arg2�������κβ������ͣ��������������������ͱ�����һ�µġ�
		NVL2(arg,res1,res2):���argΪnull���򷵻�res2,arg��Ϊnull�򷵻�res1.
11.������ѯ���
	(1)from�Ӿ�:select * from table_name;select����ָ��Ҫ��ѯ���У�fromָ��Ҫ���ĸ����в�ѯ��
	(2)where�Ӿ�:��select����п�����where�Ӿ���ʹ�ñȽϲ��������Ʋ�ѯ�����
12.��ѯ����
	(1)�Ƚ��������>,<,>=,<=,<>,=
	(2)�ؼ��֣�AND(����),OR(��)��AND���ȼ�����OR������ʹ��()�����OR�����ȼ�˳��
	(3)ģ����ѯ
		LIKE������ģ��ƥ���ַ���;
			  _��������һ���ַ�,%��������0~n���ַ���
	(4)IN��NOT IN��
		IN(list):ȡ���б�Χ�е����ݡ�
		NOT IN(list):ȡ�������ϴ��б��е����ݼ�¼��
	(5)BETWEEN...AND...:��������ѯ����ĳ��ֵ��Χ���������ݡ�
	(6)ALL��ANY: ALL��ANY���ܵ���ʹ�ã���Ҫ��ϵ��бȽϲ�����(>,<,>=,<=,<>,=)һ��ʹ�á�
		>ANY:������С
		<ANY:С�����
		>ALL:�������
		<ALL:С����С
	(7)DISTINCT():ȥ���ظ���select distinct(deptno) from emp; ȥ����ϵ��ظ���select distinct deptno,job from emp;
13.��������ȼ�
	();
	���������*,/,+,-;
	���ӷ�||;
	�Ƚ������=, >, <, >=, <=, <>, !=, is null(is not null), between...and..., in;
	�߼������not, and, or
	BETWEEN...AND...��AND������
		BETWEEN...AND...:ֻ�������Ƚ�һ���ֶ�ֵ
		AND:���������Ƚϲ�ͬ���ֶ�
14.ORDER BY�����򣬶Խ���������򣬱��������select�����һ���Ӿ䡣
			asc��д������desc��������������ֶ��а���null�����������ֵ��
			���Զ�����Ϊ�����׼ʱ�����Ȱ��յ�һ�н������������һ��������ͬ�����Եڶ��������Դ����ơ�
15.�ۺϺ���(���к��������麯��)
	(1)MAX��MIN:����ȡ���л���ʽ�������Сֵ����������ͳ���κ��������ͣ��������֡��ַ������ڡ�����NULLֵ��
	(2)AVG��SUM:����ͳ���л���ʽ��ƽ��ֵ���ܺͣ�ֻ�ܲ����������ͣ�����NULLֵ��
	(3)COUNT:����������еļ�¼����������NULLֵ��
	(4)�ۺϺ�����NULLֵ�Ĵ����ۺϺ�������NULLֵ��select count(comm)��avg(comm) from emp;--�Զ�����commΪnull�ļ�¼;
								�����ϣ������NULLֵ������Ҫʹ��NVL��NVL2:select count(nvl(comm,0)), avg(nvl(comm,0)) from emp;
16.GROUP BY:���顣�����������ָ���ֶν��з��顣������򣺸��ֶ��µ�ֵһ���ļ�¼������һ�顣
			���select��������˾ۺϺ�����ͬʱ�ֳ�����ĳһ�ֶ�ʱ����ô���ֶα��������group by�Ӿ��С�
			where���治��ʹ�þۺϺ���,��Ϊwhere�ǷǷ��麯���Ĺ����жϡ�select max(sal),deptno from emp where max(sal)>4000 group by deptno;--����ִ��
	HAVING:�Ƿ��飨�ۺϣ������Ĺ����ж�;�������GROUP BY֮�󣬲��ܵ�������;�����Է����Ľ����һ������;���簴���ŷ���󣬵õ�ÿ�����ŵ���߹��ʣ����Լ���������������
			��ѯ����������ʳ���4000�Ĳ����Լ������:select max(sal),deptno from emp group by deptno having max(sal)>4000;
17.SELECT���ִ�й��̣�
	(1)ͨ��FROM�Ӿ����ҵ���Ҫ��ѯ�ı�
	(2)ͨ��WHERE���зǷ��麯����ɸѡ�жϡ�
	(3)ͨ��GROUP BY�Ӿ���ɷ��������
	(4)ͨ��HAVING�Ӿ�����麯��ɸѡ�жϡ�
	(5)ͨ��SELECT�Ӿ�ѡ��Ҫ��ʾ���л���ʽ���麯����
	(6)ͨ��ORDER BY�Ӿ�������������
18.�����ܽ�
	���к����Ͷ��к����ķ��ಢ����˵����
		���к�����
			�ַ�����13��CONCAT(c1,c2), LENGTH(ch), UPPER(�ֶ���), LOWER(�ֶ���), INITCAP(�ֶ���), TRIM('e'FROM'ee'), LTRIM('ee','e'), RTRIM('ee','e'), LPAD(ch1, m, ch2), RPAD(ch1, m, ch2), SUBSTR��ch,m,n), INSTR(ch1,ch2,m,n)
			��ֵ����5��ROUND(n,m), TRUNC(n,m), MOD(m,n), CEIL(n), FLOOR(n)
			���ں���9��sysdate, systimestamp, LAST_DATE(date), ADD_MONTHS(date,i), MONTHS_BETWEEN(date1,date2), LEAST(date1,date2), GREATEST(date1,date2), EXTRACT(date from datetime)
			ת��������
				��ʾת����TO_DATE(), TO_CHAR()
				��ʽת���������������ַ�������ͨ����ת��Ϊ�ַ�����
			ͨ�ú���2��NVL(), NVL2()
			ע�⣺ͨ�����ڲ����������ݣ���������Ƕ�׶�㣬���ʱ������������ִ�С�
		���к���(�ۺϺ���)5��MAX()���ֵ, MIN()��Сֵ, SUM()���, AVG()ƽ��ֵ, COUNT()ͳ��
19.������ѯ��
	(1)���ʵ��Ӧ��������Ҫ�����ݣ���������Ҫ��ѯ�������������ϵı����ֲ�ѯ�������Ӳ�ѯ�����Ӳ�ѯͨ�����������໥��ϵ�ĸ��ӹ�ϵ��
	(2)�����������һ�ű��������г�Ϊ�������������ı��ڹ�����ϵ�����ڶ��һ����
	(3)�����֮��Ĺ�ϵ��һ�Զ�(���)����Զ�(ͨ�������ű�����ϵ)��һ��һ��
	(4)N�ű�Ĺ�����ѯ������Ҫ(N-1)����������;��ֵ���ӣ����=����;����ָ����������������ֵѿ�����(ָ������������ÿ�����ÿһ�к��������ÿһ������ϣ���������Ľ����)��	
	(5)�ܽ᣺
			���Ը����������ͨ������ָ���ֶ������ĸ������������ֶ�������ͬ�����ָ��������Դ��
			ֻ���������������Ľ�����Żᱻ��ѯ������(����deptno40��û���ˣ���˲��ᱻ��ʾ����)��
			���й�����������ͬʱ�������������͹������������ݲŻᱻ��ѯ������
20.�������ࣺ
	?�����ӣ����������������������ļ�¼�������Ϻ͵�ֵ����û������ֻ��д����ͬ��
			�﷨����1 INNER JOIN ��2 ON ��������;(INNER����ʡ��)
	�����ӣ����������������������ݼ�¼����Щ�������Ҫ������Щ���������������ļ�¼����Ҫʹ�������ӡ�������Ͳ��������������Ľ��ȫ����ѯ������
			create table empc as select * from emp;--���ٴ�һ�����и�������
			insert into empc(empno, ename, deptno)values(1000,'JACK',50);
	�������ӣ�(����ȫ�����ұ�Ĳ���)�������ļ�¼���ڱ����ӵ��ұ����ҳ����������ļ�¼��֮ƥ�䣬����Ҳ��������ƥ�����null��ʾ��
				�﷨����1 LEFT OUTER JOIN ��2 ON ��������;(OUTER����ʡ��)
	�������ӣ�(�ұ��ȫ�������Ĳ���)�����ұ�ļ�¼���ڱ����ӵ�������ҳ����������ļ�¼��֮ƥ�䣬����Ҳ������ұ�ƥ�����null��ʾ��
				�﷨����1 RIGHT OUTER JOIN ��2 ON ��������;(OUTER����ʡ��)
	ȫ�����ӣ����ط������������б�ļ�¼��û����֮ƥ��ģ���null��ʾ(����������Ӻ������ӵĲ���)��
				�﷨����1 FULL OUTER JOIN ��2 ON ��������;(OUTER����ʡ��)
	?�����ӣ����ӵ���������ͬһ�������е�һ���ֶο��Զ�Ӧ��ǰ��������ֶΡ�
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
21.�Ӳ�ѯ��
	Ϊ�˸���ѯ�ṩ���ݶ�����ִ�еĲ�ѯ�������Ӳ�ѯ���Ӳ�ѯ��Ƕ��������SQL����е�SELECT��䡣�Ӳ�ѯǶ�������������ѯ�򸸲�ѯ��
	ע�����
		(1)�Ӳ�ѯ��Ҫд�������С�
		(2)�Ӳ�ѯ��Ҫд����������Ҷˡ�
		(3)�Ӳ�ѯ����д��WHERE��HAVING��FROM�Ӿ��С�
		(4)�Ӳ�ѯ��ͨ����дORDER BY��
	�Ӳ�ѯ��WHERE�Ӿ��У����ݷ��ؽ���Ĳ�ͬ���Ӳ�ѯ��Ϊ�����Ӳ�ѯ�������Ӳ�ѯ�������Ӳ�ѯ��
		(1)�����Ӳ�ѯ������һ��һ�����ݣ�Ҫ��ʹ�õ��в�����(>,>=,<,<=,<>,=)
		(2)�����Ӳ�ѯ�����ض������ݣ�ʹ�ö��в�����(in,all,any)
		(3)�����Ӳ�ѯ: ͨ�����ڽ����ڶ��β�ѯ����������FROM�Ӿ��С�
					ͳ�Ƶ����Լ����ʵ������ڲ���ƽ�����ʵ�Ա����Ϣ��
						a.����ͳ�Ʋ���ƽ�����ʣ�select avg(sal) aa, deptno from emp group by deptno
						b.Ա������С��<����ƽ�����ʣ�select sal, ename, e.deptno from emp e, (select avg(sal) aa, deptno from emp group by deptno) t where e.deptno=t.deptno and e.sal<aa;						
		(4)EXISTS�ؼ��֣����Ӳ�ѯ����Ҫ���õ�����ѯ���ֶ����ݣ�ʹ��EXISTS�ؼ��֡���EXISTS��ߵ��Ӳ�ѯ���ٷ���һ�����ݣ���������������true��		 
						select deptno, dname from dept d where EXISTS (select * from emp e where e.deptno=d.deptno);--EXISTS�ؼ��֣��г�����Щ��Ա���Ĳ��Ų�����Ϣ
	�Ӳ�ѯ��HAVING�Ӿ���
22.��ҳ��ѯ��
	�ҵ�Ա�����й�����ߵ�ǰ�������������򣩣�select * from emp order by sal desc;
	select rownum, t1.* from (select * from emp order by sal desc) t1 where rownum <=3;
	ROWNUM:α�У�ϵͳ�Զ����ɵ�һ�У�������ʾ�к�;
		ROWNUM��ORACLE�����е�������ʾ�кţ�Ĭ��ֵ����ʼֵ��1���ڲ�ѯ����������Լ�һ����ORACLE��ֻ��ʹ���Ӳ�ѯ��MySql�з�ҳ�����򵥡�
		/*��ѯ��6~10����¼,���ַ���*/ select * from (select rownum rn, e.* from emp e) t where t.rn between 6 and 10;
									  select t1.* from (select rownum rn,emp.* from emp where rownum<=10) t1 where rn between 6 and 10;
		/*���ʽ����ѡ6~10����¼��ԭ���Ƚ����ټ�α�У��ٵ��±�ѡ��Χ*/
		select * from (select rownum rn, e.* from (select * from emp order by sal desc) e) t where t.rn between 6 and 10;
		select * from(select rownum rn, e.* from (select * from emp order by sal desc)e where rownum<10) where rn>=6;
		ҳ�룺page��ÿҳ���pageSizeΪ5����һҳ1~5���ڶ�ҳ6~10������ҳ11~15. start=(page-1)pageSize+1; end=pageSize*page;
23.DECODE����
	DECODE(����1��ֵ1�����1��ֵ2�����2...[,Ĭ��ֵ]);�ò�������ȥ��ֵƥ�䣬ƥ�䵽������ʾ��Ӧ�Ľ��;��ƥ������ʾĬ��ֵ��Ĭ��ֵ����������ʾnull(�൱��Java�е�switch)��
	--��ѯְԱ������ְԱ��ְλ���㽱������ְλ�ֱ���'MANAGER','SALESMAN','ANALYST'ʱ��������ֱ���нˮ��1.2,1.1,1.05��������Ϊԭ����нˮֵ��
	select ename, job, sal, decode(job,'MANAGER',sal*1.2,'SALESMAN',sal*1.1,'ANALYST',sal*1.05,sal) "����" from emp;
	select * from emp order by decode(job,'MANAGER','1','SALESMAN','2','ANALYST','3');--�Զ�������
24.���Ϻ���
	(1)UNION��������������ѯ�����������union(�����ظ����ݣ�������), union all(�������ظ����ݣ�������);
		select * from emp where sal>1500 union select * from emp where deptno=20;--����֮���ܹ�9����¼
	(2)INTERSECT������ͬʱ����������������е����ݡ�
	(3)MINUS���������������
	(4)ʹ�ü��Ϻ�����ԭ�����еĲ�ѯ������ܲ�������ͬһ�ű����ұ����֮���޹�����
	(5)ע�����a.��Ӧ���е�������Ҫƥ�䡣
				 b.�е�����Ҫ����˳��д��
				 c.�е�����Ҫһ�£������һ��ʱ����nullȥ���䲻ƥ����С�
25.DDL�������
	(1)������ռ䣺�߼���λ��ͨ�������½�һ����Ŀ���ͻ��´�����ռ䣬�ڱ�ռ��д����û���������
		���л���system���﷨��CREATE tablespace ��ռ����� datafile '�ļ���·��' size ��С autoextend on �Զ���չ next ÿ����չ�Ĵ�С;
	(2)ɾ����ռ䣺drop tablespace ��ռ�����
	(3)�����û���create user �û��� identified by ���� default tablespace ��ռ������;
	(4)ɾ���û���drop user �û��� cascade;
	(5)�����û����룺alter user �û��� identified by ����;
	(6)��Ȩ��grant connect to �û���;
	(7)�����ɫ��grant dba to �û���;
	(8)ʹ���Ӳ�ѯ�ķ�ʽ������(�л������´������û�֮�󣩣�
	ֻ���Ʊ�ṹ�ͱ����ݣ����Ḵ���е�Լ����create table emp as select * from scott.emp;--
	�����ѯ����н�������Ǹ��Ʊ�ṹ�����ݣ����û�н�������Ǹ��Ʊ�ṹ��create table dept as select * from scott.dept where 1=2;--ֻ���Ʊ�ṹ��������,��Ϊ1=2Ϊfalse��
	ֻ���Ʊ�����(�����������û��values�ؼ���):insert into ���� ��ѯ��� (��Ľṹ�����б�ṹһ��):insert into dept select * from scott.dept;
26.�е�Լ����Լ����Ҫ������Լ���������ݵĹ���
	����Լ����primary key ����Ϊ�գ�����Ψһ��
	�ǿ�Լ����not null 
	ΨһԼ����unique
	���Լ����check(����) ��MySql���ǿ���д�ģ���MySql��ֱ�Ӻ��Լ�顣price number(10,2) check(price>100),--���Լ�����ڴ������ʱ��ֱ��д(��primary key, not null, uniqueһ��λ�û�֮��)
	���Լ������Ҫ������Լ���ӱ�A�еļ�¼�����Ǵ���������B��(��֤����������)��
		(1)references �����(��������), --�ڴ������ʱ��ֱ��д(��primary key, not null, unique, checkһ��λ�û�֮��)
		(2)foreign key(�Լ�������) references �����(��������)--��һ�����Լ���ķ�ʽ��д�����һ�����ŵ�ǰ��
		(3)alter table books add foreign key(cid) references category(id);--���Բ��ڶ�����н������Լ���������ô����Ҳ��ʵ�����Լ����
27.��ͼ�����ݿ����֮һ����ͼ��sql��������ֵĽ�ɫ�ͱ���ȫ��ͬ������ͼ������һ����ʵ���ڵı�����Ӧ����һ����ѯ���Ľ��������ͼ���ͱ�������һ������
	���ã��򻯸��Ӳ�ѯ�������������ݷ��ʡ�
	(1)��������ͼ������������Ȩ�ޣ�ʹ��system�û���Ȩ����ͼ��Ȩ��䣺grant create view to �û�����
							create view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10;
	(2)�޸���ͼ�����滻����ͼ���Ӳ�ѯ��ʹ��create or replace view ��ͼ�� ���ɣ�����ͼ�����ھʹ��������ھ��滻��������ͼʱ�����Ը��и��������
							create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10;
	(3)��ѯ��ͼ���������б������Ա���Ϊ׼������ԭ������select * from v_emp_10;
	(4)��ͼ��DML����(������)������ͼ����DML�������Ƕ���ͼ������Դ�Ļ�������в�����
		a.�������ݣ���ͼ�п��������ֶζ�������Ĭ��ֵ�����Բ���Υ������������Ӧ�ֶε�Լ�������翴�������ֶε�not null��Լ������������ʧ�ܣ���
		b.Ϊ��ͼ��Ӽ��ѡ����Ա������ͼ����DML����ʱ��Ⱦ�������������ڴ��������with check option
			create or replace view v_emp_10 as select empno id,ename name,sal,deptno from emp where deptno=10 with check option;--���ܶԻ�������deptno10��������ݽ���DML������
		c.with read only��ֻ�������ܶ���ͼ����DML���������û������ͼ��ִ��DML�����ı�Ҫ���ڽ�����ͼʱ����Ϊֻ�������������������֤��ͼ��Ӧ�Ļ��������ݲ��ᱻ�Ƿ��޸ġ�
			create or replace view v_emp_10 as select empno,ename,sal,deptno from emp where deptno=10 with read only;--with read onlyֻ�������ܶ���ͼ����DML������
	(5)��ͼ�����Ӳ�ѯ�Ĳ�ͬ����Ϊ����ͼ�͸�����ͼ�����Ӳ�ѯ�а������к��������ʽ����麯��ʱ������ͼ��һ��������ͼ��������ͼ���ܽ���DML���������ұ��뱻�Ӳ�ѯ�еı��ʽ�������������
	(6)ɾ����ͼ��DROP VIEW ��ͼ���ơ�
28.���У�sequence����������Ψһ����ֵ�����ݿ����ͨ����Ϊ�������ֵ�������Ƕ��������ݿ�������в��������ڱ�
	(1)�������У�create sequence ������ [start with **(��ʼ����) increment by **(����,ÿ�����Ӽ��������ɸ�) maxvalue **(���ֵ) / minvalue **(��Сֵ)];			
	(2)������������α��:nextval/*��ȡ���е��¸�ֵ*/ ,currval/*��ȡ���еĵ�ǰֵ*/
						�����д����Ժ������ִ��nextval��֮�����ʹ��currval����ȡ���еĵ�һ��ֵ����ʹ������ֵΪusers������µļ�¼��
						select users_seq.currval from dual;--�鿴��ǰ����ֵ��
	(3)ɾ������:drop sequence users_seq;
	(4)���ӣ�
		create sequence users_seq start with 100 increment by 10;--��������,��һ��һ��Ҫ��nextval��������currval
		insert into users(id,name)values(users_seq.nextval,'Tony');--�������
		select users_seq.currval from dual;--�鿴��ǰ����ֵ��
		drop sequence users_seq;--ɾ������

29.������һ����߲�ѯЧ�ʵĻ���(�������ֵ��Ŀ¼)��������Ϊ����������ȥ�ء�����������������ֶΣ�����Ϊ�����������
    ?(1)����������create [unique] index �������� on ����(����)
				create index idx_users_name on users(ename);--��users���ename���Ͻ�������
    (2)��Ӷ���������create index idx_users_salary on users(name,salary);
    (3)��ѯ�������Զ�Ӧ������������Ҫ����ȥ�ƶ�����߲�ѯ�ٶȡ�
				select users.* from users order by name, salary;
    (4)�ع�������������ƽ����������޸ı������ع�һ��������ƽ���������
				alter index �������� rebuild;--�����޸����ݵı������齨��������
    (5)ɾ��������drop index idx_users_salary;