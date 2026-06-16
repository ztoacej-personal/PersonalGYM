create table T_Person (
	id					numeric(22, 0) primary key,
	name				varchar2(100),
	birth_date			date,
	party_type			varchar2(100),
	login_id			varchar2(100),
	password			varchar2(100),
	gender				smallInt,
	reg_date			date default sysdate,
	update_date			date default sysdate		
);

create table T_Org (
	id					numeric(22, 0) primary key,
	name				varchar2(100),
	birth_date			date,
	party_type			varchar2(100),
	reg_date			date default sysdate,
	update_date			date default sysdate		
);

create table T_Post (
	id					numeric(22, 0) primary key,
	name				varchar2(100),
	birth_date			date,
	party_type			varchar2(100),
	descript			varchar2(2000),
	reg_date			date default sysdate,
	update_date			date default sysdate		
);
