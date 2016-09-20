# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  id                            bigint not null,
  name                          varchar(255),
  duetime                       timestamp,
  jointime                      timestamp,
  constraint pk_customer primary key (id)
);
create sequence customer_seq;


# --- !Downs

drop table if exists customer;
drop sequence if exists customer_seq;

