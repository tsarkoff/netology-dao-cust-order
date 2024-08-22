select o.product_name, c.name, c.surname, o.date, o.amount
from contacts.CUSTOMERS as c
         inner join contacts.ORDERS as o
                    on c.id = o.customer_id
where lower(c.name) = lower(:customer_name);
