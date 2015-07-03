/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/11/9 0:58:56                            */
/*==============================================================*/


drop table if exists groups;

drop table if exists groups_rights;

drop table if exists groups_role;

drop table if exists log;

drop table if exists menu;

drop table if exists organization;

drop table if exists rights;

drop table if exists role;

drop table if exists role_rights;

drop table if exists user;

drop table if exists user_groups;

drop table if exists user_rights;

drop table if exists user_role;

/*==============================================================*/
/* Table: groups                                                */
/*==============================================================*/
create table groups
(
   groups_id            int not null auto_increment,
   parent_id            int,
   name                 varchar(50),
   description          varchar(200),
   create_time          datetime,
   primary key (groups_id)
);

/*==============================================================*/
/* Table: groups_rights                                         */
/*==============================================================*/
create table groups_rights
(
   groups_right_id      int not null auto_increment,
   rights_id            int,
   groups_id            int,
   type                 int,
   primary key (groups_right_id)
);

/*==============================================================*/
/* Table: groups_role                                           */
/*==============================================================*/
create table groups_role
(
   groups_role_id       int not null auto_increment,
   groups_id            int,
   role_id              int,
   primary key (groups_role_id)
);

/*==============================================================*/
/* Table: log                                                   */
/*==============================================================*/
create table log
(
   log_id               int not null auto_increment,
   user_id              int,
   type                 int,
   content              varchar(200),
   create_time          datetime,
   primary key (log_id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int not null auto_increment,
   pid                  int,
   text                 varchar(50),
   state                varchar(10),
   checked              bool,
   url                  varchar(50),
   iconCls              varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: organization                                          */
/*==============================================================*/
create table organization
(
   organization_id      int not null auto_increment,
   parent_id            int,
   name                 varchar(50),
   description          varchar(200),
   create_time          datetime,
   primary key (organization_id)
);

/*==============================================================*/
/* Table: rights                                                */
/*==============================================================*/
create table rights
(
   rights_id            int not null auto_increment,
   parent_id            int,
   name                 varchar(50),
   description          varchar(200),
   create_time          datetime,
   primary key (rights_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              int not null auto_increment,
   parent_id            int,
   name                 varchar(50),
   description          varchar(200),
   create_time          datetime,
   primary key (role_id)
);

/*==============================================================*/
/* Table: role_rights                                           */
/*==============================================================*/
create table role_rights
(
   role_rights_id       int not null auto_increment,
   rights_id            int,
   role_id              int,
   type                 int,
   primary key (role_rights_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment,
   organization_id      int,
   userName             varchar(50),
   password             varchar(50),
   name                 varchar(50),
   sex                  varchar(10),
   mobile               varchar(20),
   email                varchar(50),
   create_time          datetime,
   login_time           datetime,
   last_login_time      datetime,
   login_count          int,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_groups                                           */
/*==============================================================*/
create table user_groups
(
   user_groups_id       int not null auto_increment,
   groups_id            int,
   user_id              int,
   primary key (user_groups_id)
);

/*==============================================================*/
/* Table: user_rights                                           */
/*==============================================================*/
create table user_rights
(
   user_rights_id       int not null auto_increment,
   user_id              int,
   rights_id            int,
   type                 int,
   primary key (user_rights_id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_role_id         int not null auto_increment,
   role_id              int,
   user_id              int,
   primary key (user_role_id)
);

alter table groups_rights add constraint FK_Relationship_14 foreign key (groups_id)
      references groups (groups_id) on delete restrict on update restrict;

alter table groups_rights add constraint FK_Relationship_15 foreign key (rights_id)
      references rights (rights_id) on delete restrict on update restrict;

alter table groups_role add constraint FK_Relationship_12 foreign key (groups_id)
      references groups (groups_id) on delete restrict on update restrict;

alter table groups_role add constraint FK_Relationship_13 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict;

alter table log add constraint FK_Relationship_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table role_rights add constraint FK_Relationship_8 foreign key (rights_id)
      references rights (rights_id) on delete restrict on update restrict;

alter table role_rights add constraint FK_Relationship_9 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict;

alter table user add constraint FK_Relationship_2 foreign key (organization_id)
      references organization (organization_id) on delete restrict on update restrict;

alter table user_groups add constraint FK_Relationship_3 foreign key (groups_id)
      references groups (groups_id) on delete restrict on update restrict;

alter table user_groups add constraint FK_Relationship_4 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_rights add constraint FK_Relationship_10 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table user_rights add constraint FK_Relationship_11 foreign key (rights_id)
      references rights (rights_id) on delete restrict on update restrict;

alter table user_role add constraint FK_Relationship_5 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict;

alter table user_role add constraint FK_Relationship_6 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

