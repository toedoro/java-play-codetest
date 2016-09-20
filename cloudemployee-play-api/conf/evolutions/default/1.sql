# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table employee (
  id                            bigint not null,
  name                          varchar(255),
  duetime                       timestamp,
  jointime                      timestamp,
  constraint pk_employee primary key (id)
);
create sequence employee_seq;


# --- !Downs

drop table if exists employee;
drop sequence if exists employee_seq;

