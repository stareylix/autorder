prompt PL/SQL Developer import file
prompt Created on 2017年9月21日 星期四 by Administrator
set feedback off
set define off
prompt Dropping AU_PERMISSION...
drop table AU_PERMISSION cascade constraints;
prompt Dropping AU_RESOURCE...
drop table AU_RESOURCE cascade constraints;
prompt Dropping AU_RL_PERMISSION_RESOURCE...
drop table AU_RL_PERMISSION_RESOURCE cascade constraints;
prompt Dropping AU_RL_ROLE_PERMISSION...
drop table AU_RL_ROLE_PERMISSION cascade constraints;
prompt Dropping AU_RL_USER_ROLE...
drop table AU_RL_USER_ROLE cascade constraints;
prompt Dropping AU_ROLE...
drop table AU_ROLE cascade constraints;
prompt Dropping AU_USER...
drop table AU_USER cascade constraints;
prompt Creating AU_PERMISSION...
create table AU_PERMISSION
(
  FSTR_PERMISSIONID VARCHAR2(10) not null,
  FSTR_PERMISSION   VARCHAR2(20) not null,
  FSTR_DESCIPTION   VARCHAR2(100) not null,
  FINT_AVALIABLE    INTEGER not null,
  FDATE_CREATE      DATE,
  FDATE_UPDATE      DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column AU_PERMISSION.FSTR_PERMISSIONID
  is '权限ID';
comment on column AU_PERMISSION.FSTR_PERMISSION
  is '权限名';
comment on column AU_PERMISSION.FSTR_DESCIPTION
  is '描述';
comment on column AU_PERMISSION.FINT_AVALIABLE
  is '是否可用';
comment on column AU_PERMISSION.FDATE_CREATE
  is '创建日期';
comment on column AU_PERMISSION.FDATE_UPDATE
  is '更新日期';
alter table AU_PERMISSION
  add constraint AU_PERMISSION_PK primary key (FSTR_PERMISSIONID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AU_PERMISSION
  add constraint AU_PERMISSION_UK unique (FSTR_PERMISSION)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating AU_RESOURCE...
create table AU_RESOURCE
(
  FSTR_RESOURCEID  VARCHAR2(10) not null,
  FSTR_RESOURCE    VARCHAR2(200) not null,
  FSTR_DESCRIPTION VARCHAR2(100) not null,
  FINT_AVALIABLE   INTEGER not null,
  FDATE_CREATE     DATE,
  FDATE_UPDATE     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column AU_RESOURCE.FSTR_RESOURCEID
  is '资源ID';
comment on column AU_RESOURCE.FSTR_RESOURCE
  is '资源名';
comment on column AU_RESOURCE.FSTR_DESCRIPTION
  is '资源描述';
comment on column AU_RESOURCE.FINT_AVALIABLE
  is '是否可用';
comment on column AU_RESOURCE.FDATE_CREATE
  is '创建日期';
comment on column AU_RESOURCE.FDATE_UPDATE
  is '更新日期';
alter table AU_RESOURCE
  add constraint AU_RESOURCE_PK primary key (FSTR_RESOURCEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AU_RESOURCE
  add constraint AU_RESOURCE_UK unique (FSTR_RESOURCE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating AU_RL_PERMISSION_RESOURCE...
create table AU_RL_PERMISSION_RESOURCE
(
  FSTR_PERMISSIONID VARCHAR2(10) not null,
  FSTR_RESOUREID    VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table AU_RL_PERMISSION_RESOURCE
  add constraint AU_RL_P2R_PK primary key (FSTR_PERMISSIONID, FSTR_RESOUREID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating AU_RL_ROLE_PERMISSION...
create table AU_RL_ROLE_PERMISSION
(
  FSTR_ROLEID       VARCHAR2(10) not null,
  FSTR_PERMISSIONID VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table AU_RL_ROLE_PERMISSION
  add constraint AU_RL_R2P_PK primary key (FSTR_ROLEID, FSTR_PERMISSIONID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating AU_RL_USER_ROLE...
create table AU_RL_USER_ROLE
(
  FSTR_USERID VARCHAR2(10) not null,
  FSTR_ROLEID VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table AU_RL_USER_ROLE
  add constraint AU_RL_U2R_PK primary key (FSTR_USERID, FSTR_ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating AU_ROLE...
create table AU_ROLE
(
  FSTR_ROLEID      VARCHAR2(10) not null,
  FSTR_ROLE        VARCHAR2(20) not null,
  FSTR_DESCRIPTION VARCHAR2(100) not null,
  FINT_AVALIABLE   INTEGER not null,
  FDATE_CREATE     DATE,
  FDATE_UPDATE     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column AU_ROLE.FSTR_ROLEID
  is '角色ID';
comment on column AU_ROLE.FSTR_ROLE
  is '角色名';
comment on column AU_ROLE.FSTR_DESCRIPTION
  is '角色描述';
comment on column AU_ROLE.FINT_AVALIABLE
  is '是否可用';
comment on column AU_ROLE.FDATE_CREATE
  is '创建日期';
comment on column AU_ROLE.FDATE_UPDATE
  is '更新日期';
alter table AU_ROLE
  add constraint AU_ROLE_PK primary key (FSTR_ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AU_ROLE
  add constraint AU_ROLE_UK unique (FSTR_ROLE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating AU_USER...
create table AU_USER
(
  FSTR_USERID   VARCHAR2(10) not null,
  FSTR_USERNAME VARCHAR2(20) not null,
  FSTR_PASSWORD VARCHAR2(100) not null,
  FSTR_SALT     VARCHAR2(32) not null,
  FINT_LOCKED   INTEGER not null,
  FDATE_CREATE  DATE,
  FDATE_UPDATE  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column AU_USER.FSTR_USERID
  is '用户ID';
comment on column AU_USER.FSTR_USERNAME
  is '用户名';
comment on column AU_USER.FSTR_PASSWORD
  is '加盐密码';
comment on column AU_USER.FSTR_SALT
  is '盐';
comment on column AU_USER.FINT_LOCKED
  is '是否锁定，0未锁定，1锁定';
comment on column AU_USER.FDATE_CREATE
  is '创建时间';
comment on column AU_USER.FDATE_UPDATE
  is '更新时间';
alter table AU_USER
  add constraint AU_USER_PK primary key (FSTR_USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for AU_PERMISSION...
alter table AU_PERMISSION disable all triggers;
prompt Disabling triggers for AU_RESOURCE...
alter table AU_RESOURCE disable all triggers;
prompt Disabling triggers for AU_RL_PERMISSION_RESOURCE...
alter table AU_RL_PERMISSION_RESOURCE disable all triggers;
prompt Disabling triggers for AU_RL_ROLE_PERMISSION...
alter table AU_RL_ROLE_PERMISSION disable all triggers;
prompt Disabling triggers for AU_RL_USER_ROLE...
alter table AU_RL_USER_ROLE disable all triggers;
prompt Disabling triggers for AU_ROLE...
alter table AU_ROLE disable all triggers;
prompt Disabling triggers for AU_USER...
alter table AU_USER disable all triggers;
prompt Loading AU_PERMISSION...
prompt Table is empty
prompt Loading AU_RESOURCE...
prompt Table is empty
prompt Loading AU_RL_PERMISSION_RESOURCE...
prompt Table is empty
prompt Loading AU_RL_ROLE_PERMISSION...
prompt Table is empty
prompt Loading AU_RL_USER_ROLE...
prompt Table is empty
prompt Loading AU_ROLE...
prompt Table is empty
prompt Loading AU_USER...
insert into AU_USER (FSTR_USERID, FSTR_USERNAME, FSTR_PASSWORD, FSTR_SALT, FINT_LOCKED, FDATE_CREATE, FDATE_UPDATE)
values ('3', 'xiaoming', 'dbfa8cb01888b6b8e49053f06aed4af7', 'a4e1e22ec7a3b667483aaa1eb2c587e2', 0, to_date('20-09-2017 10:26:48', 'dd-mm-yyyy hh24:mi:ss'), null);
commit;
prompt 1 records loaded
prompt Enabling triggers for AU_PERMISSION...
alter table AU_PERMISSION enable all triggers;
prompt Enabling triggers for AU_RESOURCE...
alter table AU_RESOURCE enable all triggers;
prompt Enabling triggers for AU_RL_PERMISSION_RESOURCE...
alter table AU_RL_PERMISSION_RESOURCE enable all triggers;
prompt Enabling triggers for AU_RL_ROLE_PERMISSION...
alter table AU_RL_ROLE_PERMISSION enable all triggers;
prompt Enabling triggers for AU_RL_USER_ROLE...
alter table AU_RL_USER_ROLE enable all triggers;
prompt Enabling triggers for AU_ROLE...
alter table AU_ROLE enable all triggers;
prompt Enabling triggers for AU_USER...
alter table AU_USER enable all triggers;
set feedback on
set define on
prompt Done.
