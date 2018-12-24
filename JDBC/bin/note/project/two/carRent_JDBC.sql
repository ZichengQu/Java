--����
create table car(
       brand varchar2(10) not null,
       vehicleId varchar2(20) not null unique,
       perRent number(4) not null,
       type varchar2(20) not null
);
create table bus(
       brand varchar2(10) not null,
       vehicleId varchar2(20) not null unique,
       perRent number(4) not null,
       seat number(2) not null
);
create table truck(
       brand varchar2(10) not null,
       vehicleId varchar2(20) not null unique,
       perRent number(4) not null,
       tonnage number(2) not null
);
create table rented(
       brand varchar2(10) not null,
       vehicleId varchar2(20) not null unique,
       perRent number(4) not null,
       type varchar2(20),
       seat number(2),
       tonnage number(2)
);
--��������
insert into car values('����','��NY28588',800,'X6');
insert into car values('����','��CNY3284',600,'550i');
insert into car values('���','��NT37465',300,'������');
insert into car values('���','��NT96968',600,'GL8');
insert into bus values('��','��6566754',800,16);
insert into bus values('����','��8696997',800,16);
insert into bus values('��','��9696996',1500,34);
insert into bus values('����','��8696998',1500,34);
insert into truck values('һ�����','��MH98725',50,5);
insert into truck values('�������','��L593216',50,5);
insert into truck values('һ�����','��NU98631',50,10);
insert into truck values('�������','��CY56312',50,10);
--�鿴��
select * from car;
select * from bus;
select * from truck;
select * from rented;
--ɾ����
drop table car;
drop table bus;
drop table truck;
drop table rented;

  
