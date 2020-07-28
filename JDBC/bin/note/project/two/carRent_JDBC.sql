--建表
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
--插入数据
insert into car values('宝马','京NY28588',800,'X6');
insert into car values('宝马','京CNY3284',600,'550i');
insert into car values('别克','京NT37465',300,'林荫大道');
insert into car values('别克','京NT96968',600,'GL8');
insert into bus values('金杯','京6566754',800,16);
insert into bus values('金龙','京8696997',800,16);
insert into bus values('金杯','京9696996',1500,34);
insert into bus values('金龙','京8696998',1500,34);
insert into truck values('一汽解放','京MH98725',50,5);
insert into truck values('重庆红岩','京L593216',50,5);
insert into truck values('一汽解放','京NU98631',50,10);
insert into truck values('重庆红岩','京CY56312',50,10);
--查看表
select * from car;
select * from bus;
select * from truck;
select * from rented;
--删除表
drop table car;
drop table bus;
drop table truck;
drop table rented;

  
