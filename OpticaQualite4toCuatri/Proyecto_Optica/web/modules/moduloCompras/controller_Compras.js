/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let Compra_Producto;
fetch("modules/modulosSoluciones/data_Soluciones.json")
        .then(response => {
            return response.json();
        })
        .then(function (jsondata) {
            soluciones = jsondata;
            console.log(soluciones);
            loadTabla();
        }
        );

export function addSoluciones() {    
    let codigoBarras = document.getElementById("txtCodigoBarras").value;
    let nombre = document.getElementById("txtNombre").value;
    let marca = document.getElementById("txtMarca").value;
    let precioVenta = document.getElementById("txtPreVenta").value;
    let precioCompra = document.getElementById("txtPreCompra").value;
    let existencias = document.getElementById("txtExistencia").value;
    let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
        precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias};
    
    let solucion=JSON.stringify({producto:producto});
    let parametros = new URLSearchParams({datos:solucion});
    
    //alert(JSON.stringify(solucion));
    fetch('api/solucion/insert',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response=>response.json())
            .then(data=>{
                if(data.result){
                    alert(data.result);
                }
                else{
                let msj ="Solucion guardada con ID: "+data.idSolucion;
                Swal.fire(msj, '', 'success'); 
            }
                     });
        
    clean();
    loadTabla();
    Swal.fire('Solucion Guardado!', '', 'success');
}


export function loadTabla() {
    
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});

    fetch('api/Compra_Producto/getAll',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarEM(data);
                }
            });
}

export function cargarEM(data) {
    Compra_Producto = data;    
    let contenidoTE = "";
    for (let i=0;i<Compra_Producto.length; i++) {
        contenidoTE +="<tr onclick='moduloLenteContacto.selectLenteContacto("+ i + ");'>";
        let estatus = Compra_Producto[i].producto.estatus;
        contenidoTE += "<td>" + estatus + "</td>";        
        let nombre = Compra_Producto[i].producto.nombre+"<br>"+Compra_Producto[i].producto.marca;
        contenidoTE += "<td>" + nombre + "</td>";    
        let existencias = Compra_Producto[i].producto.existencias;
        contenidoTE += "<td>" + existencias + "</td>";
        let cantidad = Compra_Producto[i].Compra_Producto.cantidad;
        contenidoTE += "<td>" + cantidad + "</td>";
        let precioCompra = Compra_Producto[i].producto.precioCompra;
        contenidoTE += "<td>" + precioCompra + "</td>";
        let precioUnitario = Compra_Producto[i].Compra_Producto.precioUnitario;
        contenidoTE += "<td>" + precioUnitario + "</td>";
       // contenidoTE += "<td><button onclick='cargarFrmLC(" + i + ");'>Ver</button></td>";
       // contenidoTE += "<td><button onclick='moduloLenteContacto.activarLenteContacto(" + i + ");'>Activar</button></td>";
        //contenidoTE += "<td><button onclick='moduloLenteContacto.deleteLenteContacto(" + i + ");'>Eliminar</button></td>";
        contenidoTE += "</tr>";
    }
    document.getElementById("tblCompras").innerHTML = contenidoTE;
}

export function selectSoluciones(i){    

    document.getElementById("txtIdCompra").value = Compra_Producto[i].compra.idCompra;
    document.getElementById("txtIdProducto").value = Compra_Producto[i].producto.idProducto;
    document.getElementById("txtPrecioUnitario").value = Compra_Producto[i].precioUnitario;
    document.getElementById("txtCantidad").value = Compra_Producto[i].cantidad;    
    // document.getElementById("txtNombre").value = Compra_Producto[i].producto.nombre;

    //document.getElementById("txtMarca").value = Compra_Producto[i].producto.marca;
    document.getElementById("txtPreVenta").value = Compra_Producto[i].producto.precioVenta;
    document.getElementById("txtPreCompra").value = Compra_Producto[i].producto.precioCompra;
    document.getElementById("txtExistencia").value = Compra_Producto[i].producto.existencias;
}

export function clean() {
    document.getElementById("txtCodigoBarras").value = "";
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtPreVenta").value = "";
    document.getElementById("txtPreCompra").value = "";
    document.getElementById("txtIdSolucion").value = "";
    document.getElementById("txtExistencia").value = "";
    document.getElementById("txtIdProducto").value="";
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
}
export function buscarSolucion(){
    let busqueda = document.getElementById("txtBusquedaSolucion").value;
    let parametros ={"buscar":busqueda};
    fetch('api/solucion/buscar?busqueda='+busqueda)
           .then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarEM(data);                     
                }
 });
 }
 


