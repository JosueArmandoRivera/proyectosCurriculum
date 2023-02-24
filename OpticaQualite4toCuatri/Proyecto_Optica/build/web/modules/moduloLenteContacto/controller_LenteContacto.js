
/* global Swal */

let indexAccesoriosSeleccionado;
//let accesorios = [];
let lenteContacto;
export function addLenteContacto() {
    let codigoBarras = (document.getElementById("txtCodigoBarras").value);
    let nombre = (document.getElementById("txtNombre").value);
    let marca = document.getElementById("txtMarca").value;
    let precioCompra = document.getElementById("txtPrecioCompra").value;  
    let precioVenta = document.getElementById("txtPrecioVenta").value;
    let existencias = document.getElementById("txtExistencias").value;
    let keratometria = document.getElementById("txtKeratometria").value;
    let fotografia = document.getElementById("txtFotrografia").value;

    let producto={codigoBarras:codigoBarras,nombre:nombre, 
        marca:marca,precioCompra:precioCompra,
        precioVenta:precioVenta,existencias:existencias};
    
    let lenteContacto = JSON.stringify({producto:producto, keratometria:keratometria, fotografia:fotografia});
    
    let parametros = new URLSearchParams({datos:lenteContacto});
    alert(JSON.stringify(lenteContacto));
    fetch('api/lente_contacto/insert',
            {
                method:'POST',
                body:parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if(data.result){
                    alert(data.result);
                }
                else{
                let msj ="Lente Contacto guardado con ID: "+data.idLenteContacto;
                Swal.fire(msj, '', 'success'); 
            }
        });
    clean();
    loadTabla();
    Swal.fire('Lente Contacto Guardado!', '', 'success');
}

export function loadTabla() {
//    let cuerpo = "";
//    accesorios.forEach(function (accesorio) {
//        let registro =
//                '<tr onclick="moduloAccesorios.selectAccesorios(' + accesorios.indexOf(accesorio) + ');">' +
//                '<td>' + accesorio.nombre + '</td>' +
//                '<td>' + accesorio.marca + '</td>' +
//                '<td>' + accesorio.precio_venta + '</td>' +
//                '<td>' + accesorio.precio_compra + '</td>' +
//                '<td>' + accesorio.estatus + '</td></tr>';
//        cuerpo += registro;
//    });
//    console.log(cuerpo);
//    document.getElementById("tblAccesorios").innerHTML = cuerpo;
    alert("Clic en LoadTabla desde js controllerLenteContacto");
    let datos={estatus:1};
    let parametros = new URLSearchParams({datos});
    fetch('api/lente_contacto/getAll',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarEM(data);
                }
            });
}

export function cargarEM(data) {
    lenteContacto = data;
    let contenidoTE = "";
    for (var i=0;i<lenteContacto.length; i++) {
        contenidoTE +="<tr onclick='moduloLenteContacto.selectLenteContacto("+ i + ");'>";
        let estatus = lenteContacto[i].producto.estatus;
        contenidoTE += "<td>" + estatus + "</td>";        
        let nombre = lenteContacto[i].producto.nombre+"<br>"+lenteContacto[i].producto.marca;
        contenidoTE += "<td>" + nombre + "</td>";    
        let existencias = lenteContacto[i].producto.existencias;
        contenidoTE += "<td>" + existencias + "</td>";        
        let precioCompra = lenteContacto[i].producto.precioCompra;
        contenidoTE += "<td>" + precioCompra + "</td>";        
        let precioVenta = + lenteContacto[i].producto.precioVenta;
        contenidoTE += "<td>" + precioVenta + "</td>";
        let keratometria = lenteContacto[i].keratometria;
        contenidoTE += "<td>" + keratometria + "</td>";
        let fotografia = lenteContacto[i].fotografia;
        contenidoTE += "<td>" + fotografia + "</td>";        
       // contenidoTE += "<td><button onclick='cargarFrmLC(" + i + ");'>Ver</button></td>";
        contenidoTE += "<td><button onclick='moduloLenteContacto.activarLenteContacto(" + i + ");'>Activar</button></td>";
        contenidoTE += "<td><button onclick='moduloLenteContacto.deleteLenteContacto(" + i + ");'>Eliminar</button></td>";
        contenidoTE += "</tr>";
    }
    document.getElementById("tblLenteContacto").innerHTML = contenidoTE;
}
/*export function cargarEM(data) {
    lenteContacto = data;
    let contenidoTE = "";
    for (var i = 0; i < lenteContacto.length; i++) {

        contenidoTE += "<tr>";
        let estatus = lenteContacto[i].estatus;
        contenidoTE += "<td>" + estatus + "</td>";
        
        let nombre = lenteContacto[i].producto.nombre + " " + lenteContacto[i].producto.marca;
        contenidoTE += "<td>" + nombre + "</td>";
        
        let precioCompra = + "$ " + lenteContacto[i].precioCompra;
        contenidoTE += "<td>" + precioCompra + "</td>";
        
        let precioVenta = +"$ "+ lenteContacto[i].precioVenta;
        contenidoTE += "<td>" + precioVenta + "</td>";
        
        let existencias = lenteContacto[i].existencias;
        contenidoTE += "<td>" + existencias + "</td>";
        
        let keratometria = lenteContacto[i].keratometria;
        
        contenidoTE += "<td>" + keratometria + "</td>";
        
        let fotografia = lenteContacto[i].fotografia;
        contenidoTE += "<td>" + fotografia + "</td>";
        
        
        contenidoTE += "<td><button onclick='cargarFrmLC(" + i + ");'>Ver</button></td>";
        contenidoTE += "<td><button onclick='activar(" + i + ");'>Activar</button></td>";
        contenidoTE += "<td><button onclick='eliminar(" + i + ");'>Eliminar</button></td>";
        contenidoTE += "</tr>";
    }
    document.getElementById("tblLenteContacto").innerHTML = contenidoTE;
}
*/
export function CargarInactivos() {
    alert("inactivos");
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});

    fetch('api/lente_contacto/getAllb',
            {
                method:'POST',
                body:(parametros),
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

function cargarFrmLC(i){
    document.getElementById("txtCodigoBarras").value = lenteContacto[i].producto.codigoBarras;
    document.getElementById("txtNombre").value =lenteContacto[i].producto.nombre;
    document.getElementById("txtMarca").value =lenteContacto[i].producto.marca;
    document.getElementById("txtPrecioCompra").value =lenteContacto[i].producto.precioCompra;
    document.getElementById("txtPrecioVenta").value =lenteContacto[i].producto.precioVenta;
    document.getElementById("txtExistencias").value =lenteContacto[i].producto.existencias;
    //document.getElementById("txtIdProducto").value = lenteContacto[i].producto.idProducto; 
    //document.getElementById("txtIdLenteContacto").value =lenteContacto[i].idLenteContacto;
    document.getElementById("txtKeratometria").value =lenteContacto[i].keratometria;
    document.getElementById("txtFotrografia").value =lenteContacto[i].fotografia;
    
}
//export function selectLenteContacto(index) así se llamaba la función
//Adentro en vez de i iba index
export function selectLenteContacto(i) {
    document.getElementById("txtCodigoBarras").value = lenteContacto[i].producto.codigoBarras;
    document.getElementById("txtNombre").value = lenteContacto[i].producto.nombre;
    document.getElementById("txtMarca").value = lenteContacto[i].producto.marca;
    document.getElementById("txtPrecioVenta").value = lenteContacto[i].producto.precioVenta;
    document.getElementById("txtPrecioCompra").value = lenteContacto[i].producto.precioCompra;
    document.getElementById("txtExistencias").value = lenteContacto[i].producto.existencias;
    document.getElementById("txtIdProducto").value = lenteContacto[i].producto.idProducto; 
    document.getElementById("txtIdLenteContacto").value =lenteContacto[i].idLenteContacto;
    document.getElementById("txtKeratometria").value =lenteContacto[i].keratometria;
    document.getElementById("txtFotrografia").value =lenteContacto[i].fotografia;     
//    document.getElementById("btnUpdate").classList.remove("disabled");
//    document.getElementById("btnDelete").classList.remove("disabled");
//    document.getElementById("btnAdd").classList.add("disabled");
//    indexAccesoriosSeleccionado = index;
}

export function clean() {
    document.getElementById("txtIdProducto").value = "";
    document.getElementById("txtIdLenteContacto").value = "";
    document.getElementById("txtCodigoBarras").value = "";
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtPrecioCompra").value = "";
    document.getElementById("txtPrecioVenta").value = "";
    document.getElementById("txtExistencias").value = "";
    document.getElementById("txtKeratometria").value = "";
    document.getElementById("txtFotrografia").value = "";

    //document.getElementById("txtNombre").focus();
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
    indexAccesoriosSeleccionado = 0;
}

export function updateLenteContacto() {
 
 let codigoBarras = document.getElementById("txtCodigoBarras").value;
 let nombre = document.getElementById("txtNombre").value;
 let marca = document.getElementById("txtMarca").value;
 let precioVenta = document.getElementById("txtPrecioVenta").value;
 let precioCompra = document.getElementById("txtPrecioCompra").value;
 let existencias = document.getElementById("txtExistencias").value;   
 let Keratometria = document.getElementById("txtKeratometria").value;
 let fotografia = document.getElementById("txtFotrografia").value;    
 
 let idProducto = document.getElementById("txtIdProducto").value;
 let idLenteContacto = document.getElementById("txtIdLenteContacto").value;
 
 let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
     precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias, idProducto:idProducto};
 
 let lenteContacto=JSON.stringify({producto:producto, idLenteContacto:idLenteContacto,keratometria:Keratometria, fotografia:fotografia});
 let parametros = new URLSearchParams({datos:lenteContacto});
    
    
    Swal.fire({
        title: 'Quieres modificar los datos de lente de contacto?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Aceptar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {

/*
            let accesorio = {};
            accesorio.numero_unico_accesorios = numero_unico_accesorios;
            accesorio.nombre = nombre;
            accesorio.marca = marca;
            accesorio.precio_venta = precio_venta;
            accesorio.precio_compra = precio_compra;
            accesorio.estatus = "Activo";
            accesorios[indexAccesoriosSeleccionado] = accesorio;
*/            
        fetch('api/lente_contacto/actualizar',
            {
                method:'POST',
                body:(parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(data => {
                //let msj = "empleado actualizado con ID: " + data.idEmpleado;
                //alert(msj);
                if (data.result) {
                    alert(data.result);
                } else {
            clean();
            loadTabla();
            Swal.fire('Producto actualizado!', '', 'success');    
                 }
            });
        }
    });
}

export function deleteLenteContacto() {
     
 let codigoBarras = document.getElementById("txtCodigoBarras").value;
 let nombre = document.getElementById("txtNombre").value;
 let marca = document.getElementById("txtMarca").value;
 let precioVenta = document.getElementById("txtPrecioVenta").value;
 let precioCompra = document.getElementById("txtPrecioCompra").value;
 let existencias = document.getElementById("txtExistencias").value;
 let idProducto = document.getElementById("txtIdProducto").value;
 let idLenteContacto = document.getElementById("txtIdLenteContacto").value;    
 let Keratometria = document.getElementById("txtKeratometria").value;
 let fotografia = document.getElementById("txtFotrografia").value;    
 let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
     precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias, idProducto:idProducto};
 
 let lenteContacto=JSON.stringify({producto:producto, idLenteContacto:idLenteContacto,keratometria:Keratometria, fotografia:fotografia});
 let parametros = new URLSearchParams({datos:lenteContacto});
    
    
    Swal.fire({
        title: 'Quieres eliminar el accesorio?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch('api/lente_contacto/delete',
    {
        method:'POST',
        body:parametros,
        headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
    }).then(response=>response.json())
    .then(data=>{
        if(data.error){
            alert(data.error);
        }
        else{
    clean();
    loadTabla();
    Swal.fire('Producto Eliminado!', '', 'success');
                }
                     });
        }
    });
}
export function activarLenteContacto(i) {
     
 let codigoBarras = document.getElementById("txtCodigoBarras").value;
 let nombre = document.getElementById("txtNombre").value;
 let marca = document.getElementById("txtMarca").value;
 let precioVenta = document.getElementById("txtPrecioVenta").value;
 let precioCompra = document.getElementById("txtPrecioCompra").value;
 let existencias = document.getElementById("txtExistencias").value;
 let idProducto = document.getElementById("txtIdProducto").value;
 let idLenteContacto = document.getElementById("txtIdLenteContacto").value;    
 let Keratometria = document.getElementById("txtKeratometria").value;
 let fotografia = document.getElementById("txtFotrografia").value;    
 let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
     precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias, idProducto:idProducto};
 
 let lenteContacto=JSON.stringify({producto:producto, idLenteContacto:idLenteContacto,keratometria:Keratometria, fotografia:fotografia});
 let parametros = new URLSearchParams({datos:lenteContacto});
    
    
    Swal.fire({
        title: 'Quieres activar el lente de contacto?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch('api/lente_contacto/activar',
    {
        method:'POST',
        body:parametros,
        headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
    }).then(response=>response.json())
    .then(data=>{
        if(data.error){
            alert(data.error);
        }
        else{
    clean();
    loadTabla();
    Swal.fire('Producto Activado!', '', 'success');
                }
                     });
        }
    });
}
export function buscarLenteContacto(){
    let busqueda = document.getElementById("txtBusquedaLenteContacto").value;
    let parametros ={"buscar":busqueda};
    fetch('api/lente_contacto/buscar?busqueda='+busqueda)
           .then(response => response.json())
            .then(data => {
                //let msj = "empleado actualizado con ID: " + data.idEmpleado;
                //alert(msj);
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarEM(data);                     
                }
 });
 }
 

fetch("modules/moduloLenteContacto/data_lenteContacto.json")
        .then(response => {
            return response.json();
        })
        .then(function (jsondata) {
            lenteContacto = jsondata;
            console.log(lenteContacto);
            loadTabla();
        }
);
