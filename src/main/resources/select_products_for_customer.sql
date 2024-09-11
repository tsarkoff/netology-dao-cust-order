select o.product_name
from public.CUSTOMER as c
         inner join public.CART as o
                    on c.id = o.customer_id
where lower(c.name) = lower('?1');
