
create view order_details as select o.id,o.total_cost,o.date as order_date,d.name as discount,p.method as payment_method,p.status as payment_status from orders as o  left join payment as p on o.payment_id = p.id left join discount_coupons as d on p.discount_id = d.id;



 select o.id,o.date as order_date,p.name as product_name,ppc.price as product_price,ppc.color as product_color,o.total_cost as total_cost, u.name as user_name, u.email from orders as o inner join order_product_list as opc on o.id=opc.order_id inner join product_price_and_color as ppc on ppc.id = opc.product_price_and_color_id inner join  products as p on p.id=ppc.product_id inner join users as u on u.id=o.user_id;



