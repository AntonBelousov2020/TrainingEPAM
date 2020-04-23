select title
from products;

-- Поиск products по title
select *
from products
where title = 'ACADEMY ACE';

-- Поиск products по price = 9.99 и category = 8 и отсортировать по category и price
select *
from products
where price = 9.99
  and category = 8
order by category, price;

-- Поиск products, у которых category = 8 или 15
select *
from products
where category in (8, 15);

-- Поиск products, у которых price между 10 и 20 (Используйте BETWEEN)
select *
from products
where price between 10 and 20;

-- Поиск orders, у которых orderdate между 2004-01-05 и 2004-02-05
select *
from orders
where orderdate between to_date('2004-01-05', 'YYYY-MM-DD') and to_date('2004-02-05', 'YYYY-MM-DD');

-- Сгруппировать данные в orders по полю customerid и посчитать количество отностительно каждого customerid
select customerid, count(customerid)
from orders
group by customerid
order by customerid;

-- Сгруппировать данные в orders по полям customerid и orderdate и просуммировать totalamount, при этом сумма
-- totalamount должна быть больше 100
select customerid, orderdate, sum(totalamount)
from orders
group by customerid, orderdate
having sum(totalamount) > 100;

-- Написать запрос к таблицам customer, orders, orderlines и products с использованием JOIN и вывести firstname, lastname,
-- title, orderdate
select c.firstname, c.lastname, o.orderdate, p.title
from customers c
         join orders o on c.customerid = o.customerid
         join orderlines ol on o.orderid = ol.orderid
         join products p on ol.prod_id = p.prod_id;

