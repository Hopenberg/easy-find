drop table if exists customer;

CREATE TABLE customers (
    id int primary key auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null
);
