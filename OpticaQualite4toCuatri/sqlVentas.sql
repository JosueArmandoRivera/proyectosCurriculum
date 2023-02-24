drop view v_Producto;

create view v_Producto as
select p.idProducto,p.estatus,p.codigoBarras,p.nombre,p.marca,p.precioVenta,p.existencias from producto p;

select * from v_Producto;
select * from producto;
SELECT * from v_Producto where codigoBarras LIKE'%%'  OR estatus LIKE '%%' OR nombre LIKE '%%' OR marca LIKE '%%' OR precioVenta LIKE '%%' OR existencias LIKE '%%'; 
select * from Solucion where "estatus"=1;


