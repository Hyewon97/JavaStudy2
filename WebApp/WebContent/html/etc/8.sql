create table notice(
idx number(11) primary key,
name nvarchar2(30) not null,
email nvarchar2(40) not null,
phone nvarchar2(13) not null,
address nvarchar2(40) not null,
created timestamp not null,
updated timestamp not null);

create sequence idx_seq start with 1 increment by 1 maxvalue 9999;