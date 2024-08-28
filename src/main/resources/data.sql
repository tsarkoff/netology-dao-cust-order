-- data.sql executed AFTER Hibernate creates Tables in DataBase if:
--  spring.jpa.defer-datasource-initialization=true
-- spring.sql.init.mode=always
-- spring.jpa.hibernate.ddl-auto=update
-- Liquibase MUST BE turned OFF in this case (excluded from pom.xml and application.properties)

insert into public.CUSTOMER (id, name, surname, age, phone_number, city, gender)
values (1, 'Ivan', 'Ivanov', 18, '+7-095', 'Moscow', 'male'),
       (2, 'Alexey', 'Petrov', 38, '+7-111', 'Vladivostok', 'male'),
       (3, 'Jan', 'Chanson', 28, '+3-102', 'Helsinki', 'male'),
       (4, 'Alexey', 'Popov', 48, '+7-222', 'Samara', 'male'),
       (5, 'John', 'Jackson', 58, '+7-095', 'Moscow', 'male');
insert into public.CART (date, customer_id, product_name, amount)
values ('2024-08-01', 1, 'Bread', 10),
       ('2024-08-05', 2, 'Milk', 5),
       ('2024-08-05', 2, 'Cake', 10),
       ('2024-07-02', 3, 'Butter', 500),
       ('2024-07-20', 4, 'Meat', 5),
       ('2024-07-20', 4, 'Bread', 5),
       ('2024-07-20', 4, 'Ketchup', 5),
       ('2024-08-15', 5, 'Cake', 3);