------------------------------------------------------
-- Export file for user AUTORDER                    --
-- Created by Administrator on 2017-09-27, 17:08:28 --
------------------------------------------------------

spool autorder.log

prompt
prompt Creating table AU_PERMISSION
prompt ============================
prompt
create table AUTORDER.AU_PERMISSION
(
  FSTR_PERMISSIONID VARCHAR2(10) not null,
  FSTR_PERMISSION   VARCHAR2(20) not null,
  FSTR_DESCIPTION   VARCHAR2(100) not null,
  FSTR_AVALIABLE    VARCHAR2(5) not null,
  FDATE_CREATE      DATE,
  FDATE_UPDATE      DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column AUTORDER.AU_PERMISSION.FSTR_PERMISSIONID
  is 'Ȩ��ID';
comment on column AUTORDER.AU_PERMISSION.FSTR_PERMISSION
  is 'Ȩ����';
comment on column AUTORDER.AU_PERMISSION.FSTR_DESCIPTION
  is '����';
comment on column AUTORDER.AU_PERMISSION.FSTR_AVALIABLE
  is '�Ƿ����';
comment on column AUTORDER.AU_PERMISSION.FDATE_CREATE
  is '��������';
comment on column AUTORDER.AU_PERMISSION.FDATE_UPDATE
  is '��������';
alter table AUTORDER.AU_PERMISSION
  add constraint AU_PERMISSION_PK primary key (FSTR_PERMISSIONID)
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
alter table AUTORDER.AU_PERMISSION
  add constraint AU_PERMISSION_UK unique (FSTR_PERMISSION)
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

prompt
prompt Creating table AU_RESOURCE
prompt ==========================
prompt
create table AUTORDER.AU_RESOURCE
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
comment on column AUTORDER.AU_RESOURCE.FSTR_RESOURCEID
  is '��ԴID';
comment on column AUTORDER.AU_RESOURCE.FSTR_RESOURCE
  is '��Դ��';
comment on column AUTORDER.AU_RESOURCE.FSTR_DESCRIPTION
  is '��Դ����';
comment on column AUTORDER.AU_RESOURCE.FINT_AVALIABLE
  is '�Ƿ����';
comment on column AUTORDER.AU_RESOURCE.FDATE_CREATE
  is '��������';
comment on column AUTORDER.AU_RESOURCE.FDATE_UPDATE
  is '��������';
alter table AUTORDER.AU_RESOURCE
  add constraint AU_RESOURCE_PK primary key (FSTR_RESOURCEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AUTORDER.AU_RESOURCE
  add constraint AU_RESOURCE_UK unique (FSTR_RESOURCE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table AU_RL_PERMISSION_RESOURCE
prompt ========================================
prompt
create table AUTORDER.AU_RL_PERMISSION_RESOURCE
(
  FSTR_PERMISSIONID VARCHAR2(10) not null,
  FSTR_RESOUREID    VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table AUTORDER.AU_RL_PERMISSION_RESOURCE
  add constraint AU_RL_P2R_PK primary key (FSTR_PERMISSIONID, FSTR_RESOUREID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table AU_RL_ROLE_PERMISSION
prompt ====================================
prompt
create table AUTORDER.AU_RL_ROLE_PERMISSION
(
  FSTR_ROLEID       VARCHAR2(10) not null,
  FSTR_PERMISSIONID VARCHAR2(10) not null
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
alter table AUTORDER.AU_RL_ROLE_PERMISSION
  add constraint AU_RL_R2P_PK primary key (FSTR_ROLEID, FSTR_PERMISSIONID)
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

prompt
prompt Creating table AU_RL_USER_ROLE
prompt ==============================
prompt
create table AUTORDER.AU_RL_USER_ROLE
(
  FSTR_USERID VARCHAR2(10) not null,
  FSTR_ROLEID VARCHAR2(10) not null
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
alter table AUTORDER.AU_RL_USER_ROLE
  add constraint AU_RL_U2R_PK primary key (FSTR_USERID, FSTR_ROLEID)
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

prompt
prompt Creating table AU_ROLE
prompt ======================
prompt
create table AUTORDER.AU_ROLE
(
  FSTR_ROLEID      VARCHAR2(10) not null,
  FSTR_ROLE        VARCHAR2(20) not null,
  FSTR_DESCRIPTION VARCHAR2(100) not null,
  FSTR_AVALIABLE   VARCHAR2(5) not null,
  FDATE_CREATE     DATE,
  FDATE_UPDATE     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column AUTORDER.AU_ROLE.FSTR_ROLEID
  is '��ɫID';
comment on column AUTORDER.AU_ROLE.FSTR_ROLE
  is '��ɫ��';
comment on column AUTORDER.AU_ROLE.FSTR_DESCRIPTION
  is '��ɫ����';
comment on column AUTORDER.AU_ROLE.FSTR_AVALIABLE
  is '�Ƿ����';
comment on column AUTORDER.AU_ROLE.FDATE_CREATE
  is '��������';
comment on column AUTORDER.AU_ROLE.FDATE_UPDATE
  is '��������';
alter table AUTORDER.AU_ROLE
  add constraint AU_ROLE_PK primary key (FSTR_ROLEID)
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
alter table AUTORDER.AU_ROLE
  add constraint AU_ROLE_UK unique (FSTR_ROLE)
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

prompt
prompt Creating table AU_USER
prompt ======================
prompt
create table AUTORDER.AU_USER
(
  FSTR_USERID   VARCHAR2(10) not null,
  FSTR_USERNAME VARCHAR2(20) not null,
  FSTR_PASSWORD VARCHAR2(100) not null,
  FSTR_SALT     VARCHAR2(32) not null,
  FSTR_LOCKED   VARCHAR2(5) not null,
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
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column AUTORDER.AU_USER.FSTR_USERID
  is '�û�ID';
comment on column AUTORDER.AU_USER.FSTR_USERNAME
  is '�û���';
comment on column AUTORDER.AU_USER.FSTR_PASSWORD
  is '��������';
comment on column AUTORDER.AU_USER.FSTR_SALT
  is '��';
comment on column AUTORDER.AU_USER.FSTR_LOCKED
  is '�Ƿ�����';
comment on column AUTORDER.AU_USER.FDATE_CREATE
  is '����ʱ��';
comment on column AUTORDER.AU_USER.FDATE_UPDATE
  is '����ʱ��';
alter table AUTORDER.AU_USER
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

prompt
prompt Creating table UM_DUTY
prompt ======================
prompt
create table AUTORDER.UM_DUTY
(
  FSTR_DUTYCODE VARCHAR2(3) not null,
  FSTR_DUTY     VARCHAR2(20) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column AUTORDER.UM_DUTY.FSTR_DUTYCODE
  is 'ְ����';
comment on column AUTORDER.UM_DUTY.FSTR_DUTY
  is 'ְ��';
alter table AUTORDER.UM_DUTY
  add constraint UM_USER_PK primary key (FSTR_DUTYCODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table AUTORDER.UM_DUTY
  add constraint UM_USER_UK unique (FSTR_DUTY)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table UM_USER
prompt ======================
prompt
create table AUTORDER.UM_USER
(
  FSTR_USERID    VARCHAR2(10) not null,
  FSTR_NAME      VARCHAR2(20) not null,
  FSTR_SEX       VARCHAR2(5),
  FINT_AGE       NUMBER(2),
  FSTR_PHONE     VARCHAR2(14) not null,
  FSTR_ADDRESS   VARCHAR2(200),
  FSTR_DUTYCODE  VARCHAR2(3),
  FSTR_ENABLE    VARCHAR2(5) not null,
  FSTR_ENDRIVER  VARCHAR2(5),
  FSTR_CARNUMBER VARCHAR2(10),
  FDAT_CREATE    DATE default sysdate,
  FDAT_UPDATE    DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on table AUTORDER.UM_USER
  is '�û���';
comment on column AUTORDER.UM_USER.FSTR_USERID
  is '�û����';
comment on column AUTORDER.UM_USER.FSTR_NAME
  is '����';
comment on column AUTORDER.UM_USER.FSTR_SEX
  is '�Ա�';
comment on column AUTORDER.UM_USER.FINT_AGE
  is '����';
comment on column AUTORDER.UM_USER.FSTR_PHONE
  is '�ֻ�';
comment on column AUTORDER.UM_USER.FSTR_ADDRESS
  is '��ַ';
comment on column AUTORDER.UM_USER.FSTR_DUTYCODE
  is 'ְ����';
comment on column AUTORDER.UM_USER.FSTR_ENABLE
  is '�Ƿ�����';
comment on column AUTORDER.UM_USER.FSTR_ENDRIVER
  is '�Ƿ��Ǽ�ʻԱ';
comment on column AUTORDER.UM_USER.FSTR_CARNUMBER
  is '���ƺ�';
comment on column AUTORDER.UM_USER.FDAT_CREATE
  is '����ʱ��';
comment on column AUTORDER.UM_USER.FDAT_UPDATE
  is '����ʱ��';
alter table AUTORDER.UM_USER
  add constraint PK_UM_USER primary key (FSTR_USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating sequence SEQ_AU_USER
prompt =============================
prompt
create sequence AUTORDER.SEQ_AU_USER
minvalue 1
maxvalue 999999999
start with 4
increment by 1
nocache;


spool off
