CREATE TABLE customers(
customer_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
city VARCHAR(50),
signup_date DATE
);

CREATE TABLE orders(
order_id INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT NOT NULL,
order_date DATE NOT NULL,
total_amount DECIMAL(10,2) NOT NULL,
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE products(
product_id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(100) NOT NULL,
category VARCHAR(50) ,
price DECIMAL(10,2) NOT NULL
);

CREATE TABLE orderdetails(
order_detail_id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT NOT NULL,
price DECIMAL(10,2) NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (product_id) REFERENCES products(product_id)
);


INSERT INTO products(product_name, category, price) VALUES ("Laptop", "Electronics","70000");
INSERT INTO products(product_name, category, price) VALUES ("Mouse", "Electronics","2000");
INSERT INTO products(product_name, category, price) VALUES ("AC", "Appliances","30000");
INSERT INTO products(product_name, category, price) VALUES ("Refridgerator", "Appliances","20000");
INSERT INTO products(product_name, category, price) VALUES ("Washing Machine", "Appliances","10000");
INSERT INTO products(product_name, category, price) VALUES ("Shirt", "Fashion","1000");
INSERT INTO products(product_name, category, price) VALUES ("Socks", "Fashion","500");

INSERT INTO customers(name, email, city,signup_date) VALUES ("John Smith","johnsmith@gmail.com","Kochi","2025-06-06");
INSERT INTO customers(name, email, city,signup_date) VALUES ("Jacob Prince","jacob@gmail.com","Thrissur","2020-05-01");
INSERT INTO customers(name, email, city,signup_date) VALUES ("Jerry Tom","jerry@gmail.com","Delhi","2022-04-01");
INSERT INTO customers(name, email, city,signup_date) VALUES ("Alan Jaison","alan@gmail.com","Mumbai","2019-03-10");

INSERT INTO orders(customer_id, order_date, total_amount) VALUES (1,"2025-06-06","80000");
INSERT INTO orders(customer_id, order_date, total_amount) VALUES (2,"2023-09-10","52000");
INSERT INTO orders(customer_id, order_date, total_amount) VALUES (3,"2024-10-12","2000");
INSERT INTO orders(customer_id, order_date, total_amount) VALUES (3,"2025-10-12","4000");

INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (1,100,1,70000);
INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (1,104,1,10000);
INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (2,101,1,2000);
INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (2,102,1,30000);
INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (2,103,1,20000);
INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (3,105,2,2000);
INSERT INTO orderdetails(order_id,product_id, quantity, price) VALUES (4,105,4,4000);

SELECT * FROM customers;

SELECT * FROM orders WHERE DATEDIFF(CURDATE(),order_date)<=30;

SELECT product_name, price FROM products;

SELECT count(product_id) as total_products
FROM products
GROUP BY category;

SELECT * FROM customers
where city = "Mumbai";

SELECT * FROM orders
WHERE total_amount > 5000;

SELECT * FROM customers
where signup_date >= "2024-01-01";

SELECT name, order_date, total_amount
FROM orders
JOIN customers
on customers.customer_id=orders.customer_id;

SELECT product_name, order_id
FROM orderdetails
JOIN products ON products.product_id = orderdetails.product_id
ORDER BY order_id;

SELECT name
FROM customers
LEFT JOIN orders
ON customers.customer_id=orders.customer_id
WHERE order_id is NULL;

SELECT customer_id, SUM(total_amount) as total_spent
FROM orders
GROUP BY customer_id;

SELECT product_name, SUM(quantity) as total_quantity
FROM products
JOIN orderdetails
ON products.product_id = orderdetails.product_id
GROUP BY products.product_id;

SELECT customer_id, AVG(total_amount) as average_spent
FROM orders
GROUP BY customer_id;

SELECT products.category, SUM(orderdetails.price) as total_sales
FROM products
JOIN orderdetails
ON products.product_id = orderdetails.product_id
GROUP BY products.category;

SELECT customer_id, SUM(total_amount) as total_spent
FROM orders 
GROUP BY customer_id
HAVING total_spent > (SELECT AVG(total_amount) FROM orders);

SELECT product_name
FROM products
WHERE product_id NOT IN (SELECT product_id FROM orderdetails);

SELECT customer_id, MAX(order_date) as last_order_date
FROM orders
GROUP BY customer_id;

SELECT SUM(total_amount) as total_revenue
FROM orders
GROUP BY customer_id
ORDER BY total_revenue DESC;

SELECT customers.name, COUNT(orders.customer_id) as order_count
FROM customers
LEFT JOIN orders
ON orders.customer_id = customers.customer_id
GROUP BY customers.customer_id
ORDER BY order_count DESC
LIMIT 3;

SELECT product_id, COUNT(DISTINCT customer_id) as unique_customers
FROM orderdetails
JOIN orders
on orders.order_id = orderdetails.order_id
GROUP BY product_id;