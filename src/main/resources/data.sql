insert into java301.users (first_name, last_name, email, phone, password) values ('Zach', 'Smith',  'zsmith@smoothie.com', '1234567890', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Julie', 'Williams', 'jwilliams@smoothie.com', '1234561234', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Sven', 'Bjergson', 'sbjergson@smoothie.com', '1234564321', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Allison', 'Johns', 'ajohns@smoothie.com', '1234565566', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Michael', 'Pabst', 'mpabst@smoothie.com', '1234561289', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('David', 'Anderson', 'danderson@smoothie.com', '1234165346', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Dana', 'Carter', 'dcarter@smoothie.com', '1234162146', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Ashley', 'Weston', 'aweston@smoothie.com', '1234165379', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Jason', 'Fredrick', 'jfredrick@smoothie.com', '1234165346', 'password');
insert into java301.users (first_name, last_name, email, phone, password) values ('Evelynn', 'Rogers', 'erogers@smoothie.com', '1234166269', 'password');

insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'zsmith@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'jwilliams@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'sbjergson@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'ajohns@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'mpabst@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'danderson@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'dcarter@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'aweston@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'jfredrick@smoothie.com'), 'USER');
insert into java301.user_roles (user_id, role) values ((select id from java301.users where email = 'erogers@smoothie.com'), 'USER');

insert into java301.products (product_name, price, manufacturer, condition) values ('product1', '1', 'manufacturer1', 'x');
insert into java301.products (product_name, price, manufacturer, condition) values ('product 2', '1', 'manufacturer2', 'x');
insert into java301.products (product_name, price, manufacturer, condition) values ('product 3', '1', 'manufacturer3', 'x');
insert into java301.products (product_name, price, manufacturer, condition) values ('product 4', '1', 'manufacturer4', 'x');
insert into java301.products (product_name, price, manufacturer, condition) values ('product 5', '1', 'manufacturer5', 'x');

insert into java301.transactions (user_id, product_id, transaction_date) values (1, 1, 'January 30th, 2016');
insert into java301.transactions (user_id, product_id, transaction_date) values (2, 1, 'January 30th, 2016');
insert into java301.transactions (user_id, product_id, transaction_date) values (3, 1, 'January 30th, 2016');
insert into java301.transactions (user_id, product_id, transaction_date) values (4, 1, 'January 30th, 2016');
insert into java301.transactions (user_id, product_id, transaction_date) values (5, 1, 'January 30th, 2016');
insert into java301.transactions (user_id, product_id, transaction_date) values (6, 1, 'January 30th, 2016');