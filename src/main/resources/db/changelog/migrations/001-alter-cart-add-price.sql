-- liquibase formatted sql

--changeset tsarkoff:001 failOnError:false
alter table public.cart
    add price decimal;
-- update public.cart set price = 100;

--rollback drop table contacts.customers;