-- liquibase formatted sql

--changeset tsarkoff:00001 failOnError:false
alter table contacts.customers
    add wallet int;
update contacts.customers set wallet = 100000;

--rollback drop table contacts.customers;