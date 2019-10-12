create table user
(
  username varchar(200) not null,
  password varchar(200) not null,
  name varchar(200) not null,
  contact varchar(200) not null,
  email varchar(200) not null,
  house_no varchar(200) not null,
  street_name varchar(200) not null,
  city varchar(200) not null,
  account_no varchar(200) not null,
  role varchar(200) not null,
  primary key (username)
);

create table employee
(
  employee_id int not null auto_increment,
  name varchar(200) not null,
  contact varchar(200) not null,
  email varchar(200) not null,
  house_no varchar(200) not null,
  street_name varchar(200) not null,
  city varchar(200) not null,
  joining_date date not null,
  salary numeric(7,2) not null,
  account_no varchar(200) not null,
  primary key (employee_id)
);

create table supplier
(
  supplier_id int not null auto_increment,
  name varchar(200) not null,
  contact varchar(200) not null,
  email varchar(200) not null,
  house_no varchar(200) not null,
  street_name varchar(200) not null,
  city varchar(200) not null,
  account_no varchar(200) not null,
  primary key (supplier_id)
);


create table category
(
  category_id int not null auto_increment,
  name varchar(200) not null,
  employee_id int,
  primary key (category_id),
  foreign key (employee_id) references employee(employee_id) on delete set null
);

create table orders
(
  order_id int not null auto_increment,
  status varchar(255) not null,
  order_date date not null,
  username varchar(200),
  primary key (order_id),
  foreign key (username) references user(username) on delete set null
);

create table payment
(
  payment_id int not null auto_increment,
  payment_date date not null,
  method varchar(200) not null,
  price numeric(7,2) not null,
  order_id int,
  primary key (payment_id),
  foreign key (order_id) references orders(order_id) on delete set null
);

create table product
(
  product_id int not null auto_increment,
  name varchar(200) not null,
  selling_price numeric(7,2) not null,
  quantity_left int not null,
  category_id int,
  primary key (product_id),
  foreign key (category_id) references category(category_id) on delete cascade
);

create table feedback
(
  feedback_id int not null auto_increment,
  type int not null,
  rating int not null,
  comment varchar(255),
  order_id int,
  primary key (feedback_id),
  foreign key (order_id) references orders(order_id) on delete cascade
);

create table order_item
(
  ord_item_id int not null auto_increment,
  order_id int,
  product_id int,
  quantity int not null,
  primary key (ord_item_id, order_id),
  foreign key (order_id) references orders(order_id),
  foreign key (product_id) references product(product_id) on delete cascade
);

create table supply_order
(
  supply_order_id int not null auto_increment,
  supply_order_date date not null,
  supply_order_status varchar(200) not null,
  quantity int not null,
  price numeric(7,2) not null,
  product_id int,
  supplier_id int,
  employee_id int,
  primary key (supply_order_id),
  foreign key (product_id) references product(product_id) on delete set null,
  foreign key (supplier_id) references supplier(supplier_id) on delete set null,
  foreign key (employee_id) references employee(employee_id) on delete set null
);

-- create table works_for
-- (
--   manager int not null,
--   employee_id int not null,
--   primary key (manager, employee_id),
--   foreign key (manager) references employee(employee_id),
--   foreign key (employee_id) references employee(employee_id)
-- );

-- create table supplies
-- (
--   product_id int,
--   supplier_id int,
--   quantity int not null,
--   cost_price numeric(7,2) not null,
--   primary key (product_id, supplier_id),
--   foreign key (product_id) references product(product_id),
--   foreign key (supplier_id) references supplier(supplier_id)
-- );