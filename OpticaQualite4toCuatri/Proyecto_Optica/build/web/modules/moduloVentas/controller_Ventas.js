/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global Swal */

let productos;
let indexVS =0;
let ventaProducto=[];
let currentUser=localStorage.getItem("currentUser");
let e = JSON.parse(currentUser);

loadTablaVentas();

function normalizar(texto){
    texto=texto.toUpperCase();
    for(var i=0;i<texto.lenght;i++){
        texto=texto.replace("Á","A");
        texto=texto.replace("É","E");
        texto=texto.replace("Í","I");
        texto=texto.replace("Ó","O");
        texto=texto.replace("Ú","U");
        //texto=texto.replace("1","UNO");
    }
    return texto;    
}
function sanitizar(texto){
    for(var i=0;i<texto.length;i++){
        texto=texto.replace("(","");
        texto=texto.replace(")","");
        texto=texto.replace(";","");
        texto=texto.replace("°","");
        texto=texto.replace("\"","");
        texto=texto.replace("-","");
        texto=texto.replace("*","");
        texto=texto.replace("%","");
        texto=texto.replace(">>","");
        texto=texto.replace("<<","");
        texto=texto.replace("=","");
        texto=texto.replace("(","");
    }
    return texto;
}
export function loadTablaVentas() {   
    let datos={estatus:1};
    let parametros = new URLSearchParams(datos);
    fetch('api/ventas/getAll',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarVentas(data);
                    alert("Entra al else de cargar tabla");                
                }
            });
}
export function cargarVentas(data){
    productos = data;    
    let contenidoTV = "";
    
    for (let i=0;i<productos.length; i++) {
        let estatus =productos[i].estatus;
        let nombre =productos[i].nombre;//+"<br>"+ventas[i].Producto.marca;
        let codigoBarras =productos[i].codigoBarras;
        let precioVenta =productos[i].precioVenta;
        let existencias =productos[i].existencias;

        contenidoTV +="<tr>";//onclick='moduloVentas.selectVentas("+i+")';
        //contenidoTV +="<td>"+estatus+"</td>";
        contenidoTV +="<td>"+codigoBarras+"</td>";
        contenidoTV +="<td>"+nombre+"</td>";       
        contenidoTV +="<td>"+precioVenta + "</td>";
        contenidoTV +="<td>"+existencias + "</td>";
        contenidoTV +='<td><button onclick="moduloVentas.agregarCarrito('+i+');">Agregar</button></td>';
        contenidoTV +="</tr>";
    }
    document.getElementById("tblVentas").innerHTML = contenidoTV;
}
export function selectVentas(i){    
      alert("Seleccionaste un producto");

}
export function cleanVentas() {
    document.getElementById("txtBusquedaVentas").value = "";
}
export function buscarProducto(){
    let busqueda = document.getElementById("txtBusquedaVentas").value; 
    let parametros ={"buscar":busqueda};
    fetch('api/ventas/buscar?busqueda='+busqueda)
           .then(response => response.json())
            .then(function (data) {
                if (data.error) {
                    alert(data.error);
                }
                else {
                    cargarVentas(data);                     
                }
 });
 }
 export function agregarCarrito(i){
    let contenidoTV = "";
    let renglon =             
        contenidoTV +="<tr>";//onclick='moduloVentas.selectVentas("+i+")';        
        contenidoTV +="<td>"+productos[i].codigoBarras+"</td>";
        contenidoTV +="<td>"+productos[i].nombre+"</td>";       
        contenidoTV +="<td>"+productos[i].precioVenta+"</td>";
        contenidoTV +='<td><input type="number" value="1" id="txtCantidad' + indexVS + '"></td>';
        contenidoTV +='<td><input type="number" value="1" id="txtDescuento' + indexVS + '"</td>';        
        contenidoTV +="</tr>";
        document.getElementById("tblCarrito").innerHTML += contenidoTV;
        ventaProducto[indexVS]={'producto':productos[i],'cantidad':1,'precioUnitario':productos[i].precioVenta,'descuento':0};
        indexVS++;
 }
 
 export function generarCompra(){
     for (var i = 0; i < ventaProducto.length; i++) {
            ventaProducto[i].cantidad = document.getElementById("txtCantidad" + i).value;
            ventaProducto[i].descuento = document.getElementById("txtDescuento" + i).value;
        }
        let venta = {clave: Math.random() * 10000000, empleado: e};
        let dvp = {venta: venta, listaVentaProducto: ventaProducto};
        let datos = {datos: JSON.stringify(dvp)};
        let parametros = new URLSearchParams(datos);

        fetch("api/ventas/generarVenta", {
            method: 'POST',
            body: parametros,
            headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
        }).then(response => response.json())
                .then(data => {
                    if (data.error) {
                        alert(data.error);
                    } else {
                        Swal.fire("Exito!", "¡Venta correcta!", 'success');
                    }
                });
 }
 
/*export function buscarProducto(){
    let busqueda = document.getElementById("txtBusquedaVentas").value;
    let parametros ={"buscar":busqueda,token:token};
    fetch('api/ventas/buscar?busqueda='+busqueda)
           .then(response => response.json())
            .then(function (data) {
                if (data.error) {
                    alert(data.error);
                }
                if(data.exception != null){
                    Swal('Error','Error interno del servidor','error');
                    return;            
                }
                if(data.error !=null){
                    Swal('',data.error,'warning');
                    return;
                }
                if(data.errorperm != null){
                    Swal('','No tienes permiso para realizar esta operación','error');
                    return;
                }
                else {
                    cargarVentas(data);                     
                }
 });
 }
*/