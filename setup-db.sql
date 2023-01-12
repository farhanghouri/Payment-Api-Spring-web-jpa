create database payment;
use payment;

CREATE TABLE payment_methods (
  id int AUTO_INCREMENT,
  name varchar(255),
  display_name varchar(255),
  payment_type varchar(255),
   PRIMARY KEY (`id`)
);

CREATE TABLE payment_plans (
  id int AUTO_INCREMENT,
  payment_id int,
  net_amount DECIMAL(10 , 2),
  tax DECIMAL(10 , 2),
  gross_amount DECIMAL(10 , 2),
  currency varchar(255),
  duration varchar(255),
   PRIMARY KEY (`id`),
   FOREIGN KEY (payment_id) REFERENCES payment_methods(id)
);


INSERT INTO employees.payment_methods
(id, name, display_name, payment_type)
VALUES(17, 'credit', 'Alfa Lebanon', 'MOBILE_CARRIER');
INSERT INTO employees.payment_methods
(id, name, display_name, payment_type)
VALUES(18, 'debit', 'Alfa Lebanon', 'MOBILE_CARRIER');


INSERT INTO employees.payment_plans
(id, payment_id, net_amount, tax, gross_amount, currency, duration)
VALUES(12, 17, 5.99, 2.00, 5.99, 'USD', 'Month');
INSERT INTO employees.payment_plans
(id, payment_id, net_amount, tax, gross_amount, currency, duration)
VALUES(13, 18, 5.99, 3.00, 10.99, 'USD', 'Daily');

