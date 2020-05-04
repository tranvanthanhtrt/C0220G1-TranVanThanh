select productCode, productName, buyprice, quantityInStock
from products
where buyprice > 56.76
  and quantityInStock > 10;
SELECT productCode, productName, buyprice, textDescription
FROM products
         INNER JOIN productlines
                    ON products.productline = productlines.productline
WHERE buyprice > 56.76
  AND buyprice < 95.59;
select productCode, productName, buyPrice, quantityInStock, productVendor, productLine
from products
where productLine = 'Classic Cars'
   OR productVendor = 'Min Lin Diecast';
select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers
         left join orders on customers.customerNumber = orders.customerNumber
order by customerName;
select customers.customerNumber, customerName, phone, paymentDate, amount
from customers
         inner join payments
                    on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas';
select status, count(*) as 'So luong status'
from orders
group by status;
select status, count(orderNumber) as 'Soluong order'
from orders
group by status
order by `Soluong order`;
select status, sum(quantityOrdered * priceEach) as amount
from orders
         inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by status;
select orderNumber, sum(quantityOrdered * priceEach) as total,count(orderNumber)as soluongorder
from orderdetails
group by orderNumber;
select year(orderDate) as year, sum(quantityOrdered * priceEach) as total,count(status) as soluongshipped
from orders
         inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year
having year > 2003;