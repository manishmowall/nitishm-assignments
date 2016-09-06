create database ecommerce_application;
 create domain id_type varchar(10) check (value ~ '^[a-zA-Z0-9]+$' and length(value) >= 8 and length(value) <=10);
 create table products( id id_type primary key not null, name text not null);
 
 create table user_type(id id_type primary key not null, name text not null);

  create table discount_coupons(id id_type primary key not null, type text not null,name text not null);
  
alter table products add constraint my_unique_constraint_products UNIQUE(id);

 alter table discount_coupons add constraint my_unique_constraint_discount_coupons UNIQUE(id);

 alter table user_type add constraint my_unique_constraint_user_type UNIQUE(id);

 create table product_price_and_color(id id_type primary key not null, price real not null, color text not null, product_id id_type not null references products(id));

 create table users( id id_type primary key not null unique, name text not null, email text not null, passwd varchar(15) not null check (length(passwd) >=8), user_type_id id_type not null references user_type(id));

 create table orders( id id_type primary key not null unique, total_cost real not null, date timestamp not null, user_id id_type not null references users(id));

create table order_product_list(id id_type primary key not null unique, product_id id_type not null references products(id),order_id id_type not null references orders(id));

create table payment( id id_type primary key not null unique,status text not null,method text not null,date timestamp not null,discount_id id_type not null references discount_coupons(id), order_id id_type not null references orders(id));

 alter table orders alter date set default now();
------------------------------------------------------------------------------------------------------------------------
modification
=============
drop table order_product_list;

create table order_product_list(id id_type primary key not null unique,product_price_and_color_id id_type not null references product_price_and_color(id),order_id id_type not null references orders(id));

 delete FROM payment ;

 alter table payment drop column order_id ;


alter table payment drop column order_id ;

 delete from orders;

  alter table orders add column payment_id id_type null references payment(id);

 alter table orders drop column total_cost;


 alter table orders add column total_cost real default 0; 

create function cal_order_cost()returns trigger as $$
declare costsum real;
BEGIN
select into costsum sum(p.price) from product_price_and_color as p,order_product_list as ord where ord.product_price_and_color_id=p.id and ord.order_id=NEW.order_id;
update orders set total_cost = costsum where id=NEW.order_id;return NEW;
end; $$
language plpgsql;

create  trigger addcost after insert on order_product_list for each row execute procedure cal_order_cost();


create function payment_function(o_id id_type,m text,d_id id_type,s text) returns void as $$
declare p_id id_type;
BEGIN
perform payment_id from orders as o where o.order_id=o_id and payment_id is NOT NULL;
IF FOUND then
select payment_id into p_id from orders as p where o.order_id = o_id;
update payment set status = s,discount_id=d_id,method=m,date=now() where id=p_id ;
else
insert into (status,method,date,discount_id)payment values(s,m,now(),d_id);
select id into p_id from payment where status=s,method=m,discount_id=d_id;
update orders set payment_id=p_id where id=o_id; 
end if;
end; $$
language plpgsql;

