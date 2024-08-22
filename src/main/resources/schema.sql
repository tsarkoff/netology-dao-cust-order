-- create if not exists schema contacts;
create schema contacts;

create table contacts.CUSTOMERS
(
    id           bigserial,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int          not null default 18,
    phone_number varchar(20),
    city         varchar(255),
    primary key (id)
);

CREATE INDEX customers_name_idx
    ON contacts.CUSTOMERS (name);

insert into contacts.CUSTOMERS (id, name, surname, age, phone_number, city)
values (1, 'Ivan', 'Ivanov', 18, '+7-095', 'Moscow'),
       (2, 'Alexey', 'Petrov', 38, '+7-111', 'Vladivostok'),
       (3, 'Jan', 'Chanson', 28, '+3-102', 'Helsinki'),
       (4, 'Alexey', 'Popov', 48, '+7-222', 'Samara'),
       (5, 'John', 'Jackson', 58, '+7-095', 'Moscow');

create table contacts.ORDERS
(
    id           bigserial,
    date         varchar(255) not null,
    customer_id  bigserial    not null,
    product_name varchar(255) not null,
    amount       int,
    primary key (id),
    foreign key (customer_id) references contacts.CUSTOMERS (id)
);

CREATE INDEX orders_product_name_idx
    ON contacts.ORDERS (product_name);

insert into contacts.ORDERS (date, customer_id, product_name, amount)
values ('2024-08-01', 1, 'Bread', 10),
       ('2024-08-05', 2, 'Milk', 5),
       ('2024-08-05', 2, 'Cake', 10),
       ('2024-07-02', 3, 'Butter', 500),
       ('2024-07-20', 4, 'Meat', 5),
       ('2024-07-20', 4, 'Bread', 5),
       ('2024-07-20', 4, 'Ketchup', 5),
       ('2024-08-15', 5, 'Cake', 3);
