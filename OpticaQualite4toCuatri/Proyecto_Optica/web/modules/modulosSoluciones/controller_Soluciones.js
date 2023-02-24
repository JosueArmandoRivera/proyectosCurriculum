/* global Swal */

let indexSollucionesSeleccionado;
let soluciones;

let currentUser=localStorage.getItem("currentUser");
let e = JSON.parse(currentUser);
let token=e.usuario.lastToken;

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
export function addSoluciones() {    
    //let codigoBarras = document.getElementById("txtCodigoBarras").value;
       let codigoBarras= sanitizar(document.getElementById("txtCodigoBarras").value);
        
    //let nombre = document.getElementById("txtNombre").value;
      let  nombre = sanitizar(document.getElementById("txtNombre").value);
        
    //let marca = document.getElementById("txtMarca").value;
      let  marca = sanitizar(document.getElementById("txtMarca").value);
        
    //let precioVenta = document.getElementById("txtPreVenta").value;
      let  precioVenta = sanitizar(document.getElementById("txtPreVenta").value);

    //let precioCompra = document.getElementById("txtPreCompra").value;
      let precioCompra = sanitizar(document.getElementById("txtPreCompra").value);
        
    //let existencias = document.getElementById("txtExistencia").value;
      let existencias = sanitizar(document.getElementById("txtExistencia").value);

    // let idSolucion = document.getElementById("txtIdSolucion").value;
/*
    let Solucion = {};
    Solucion.numero_unico_soluciones = "RF01";
    Solucion.nombre = nombre;
    Solucion.marca = marca;
    Solucion.precio_venta = precio_venta;
    Solucion.precio_compra = precio_compra;
    Solucion.existencia = existencia;
    Solucion.descripcion = descripcion;
    Solucion.estatus = "Activo";
    soluciones.push(Solucion);*/
    let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
        precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias};
    
    let solucion=JSON.stringify({producto:producto});
    let parametros = new URLSearchParams({datos:solucion, token:token});
    
    //alert(JSON.stringify(solucion));
    fetch('api/solucion/insert',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response=>{return response.json()})
            .then(function (data){
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
                else{
                let msj ="Solucion guardada con ID: "+data.idSolucion;
                Swal.fire(msj, '', 'success'); 
            }
            /*.then(response=>response.json())
            .then(data=>{
                if(data.result){
                    alert(data.result);
            
                }
                else{
                let msj ="Solucion guardada con ID: "+data.idSolucion;
                Swal.fire(msj, '', 'success'); 
            }*/
                     });        
    clean();
    loadTabla();
    Swal.fire('Operación no realizada, logeate correctamente', '', 'error');
}

export function loadTabla() {
    
    //let datos = {estatus: 1};
    let parametros = new URLSearchParams({estatus:1,token:token});

    fetch('api/solucion/getAll',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(function (data) {
                if (data.error) {
                    alert(data.error);
                }if(data.exception != null){
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
                    cargarEM(data);
                    
                }
            });
    /*let cuerpo = "";
    soluciones.forEach(function (Solucion) {
        let registro =
                '<tr onclick="moduloSoluciones.selectSoluciones(' + soluciones.indexOf(Solucion) + ');">' +
                '<td>' + Solucion.nombre + '</td>' +
                '<td>' + Solucion.marca + '</td>' +
                '<td>' + Solucion.existencia + '</td>' +
                '<td>' + Solucion.precio_venta + '</td>' +
                '<td>' + Solucion.precio_compra + '</td>' +
                '<td>' + Solucion.descripcion + '</td>' +
                '<td>' + Solucion.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblSoluciones").innerHTML = cuerpo;*/
        Swal.fire('Datos no cargados, logeate correctamente', '', 'error');

    
}
export function CargarInactivos() {
    //let datos = {estatus: 0};
    let parametros = new URLSearchParams({estatus:0,token:token});

    fetch('api/solucion/getAllb',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
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
                    cargarEM(data);
                }
            });
}
export function cargarEM(data) {
    soluciones = data;    
    let contenidoTE = "";
    for (let i=0;i<soluciones.length; i++) {
        contenidoTE += "<tr onclick='moduloSoluciones.selectSoluciones("+i+");'>";
        let estatus = soluciones[i].producto.estatus;
        contenidoTE += "<td>" + estatus + "</td>";
        let nombre =soluciones[i].producto.nombre+"<br>"+soluciones[i].producto.marca;
        contenidoTE +="<td>"+nombre+"</td>";
        let existencias =soluciones[i].producto.existencias;
        contenidoTE +="<td>"+existencias+"</td>";
        let precioCompra =soluciones[i].producto.precioCompra;
        contenidoTE +="<td>"+precioCompra +"</td>";
        let precioVenta =soluciones[i].producto.precioVenta;
        contenidoTE += "<td>" + precioVenta + "</td>";
        
        //contenidoTE += "<td><button onclick='moduloSoluciones.activarSoluciones("+i+");'>Activar</button></td>";
        ///Asì se pone un boton adentro de la fila!!! contenidoTE += "<td><button onclick='moduloSoluciones.deleteSoluciones("+i+");'>Eliminar</button></td>";
        contenidoTE += "</tr>";
    }
    document.getElementById("tblSoluciones").innerHTML = contenidoTE;
}
/*
export function cargarEM(data) {
    soluciones = data;    
    let contenidoTE = "";
    for (let i=0;i<soluciones.length; i++) {
        contenidoTE += "<select onclick='moduloSoluciones.selectSoluciones("+i+");'>";
        let estatus = soluciones[i].producto.estatus;
        contenidoTE += "<option>" + estatus + "</option>";
        let nombre =soluciones[i].producto.nombre+"<br>"+soluciones[i].producto.marca;
        contenidoTE +="<option>"+nombre+"</option>";
        let existencias =soluciones[i].producto.existencias;
        contenidoTE +="<option>"+existencias+"</option>";
        let precioCompra =soluciones[i].producto.precioCompra;
        contenidoTE +="<option>"+precioCompra +"</option>";
        let precioVenta =soluciones[i].producto.precioVenta;
        contenidoTE += "<option>" + precioVenta + "</option>";
        
        //contenidoTE += "<td><button onclick='moduloSoluciones.activarSoluciones("+i+");'>Activar</button></td>";
        ///Asì se pone un boton adentro de la fila!!! contenidoTE += "<td><button onclick='moduloSoluciones.deleteSoluciones("+i+");'>Eliminar</button></td>";
        contenidoTE += "</select>";
    }
    document.getElementById("tblSoluciones").innerHTML = contenidoTE;
}*/

export function selectSoluciones(i){    
    document.getElementById("txtCodigoBarras").value = soluciones[i].producto.codigoBarras;
    document.getElementById("txtIdSolucion").value = soluciones[i].idSolucion;
    document.getElementById("txtIdProducto").value = soluciones[i].producto.idProducto;
    document.getElementById("txtNombre").value = soluciones[i].producto.nombre;
    document.getElementById("txtMarca").value = soluciones[i].producto.marca;
    document.getElementById("txtPreVenta").value = soluciones[i].producto.precioVenta;
    document.getElementById("txtPreCompra").value = soluciones[i].producto.precioCompra;
    document.getElementById("txtExistencia").value = soluciones[i].producto.existencias;
    
}
//Select leyva y mio con lolis que no jaló
//export function selectSoluciones(i){    
//    document.getElementById("txtCodigoBarras").value = soluciones[i].producto.codigoBarras;
//    document.getElementById("txtIdSolucion").value = soluciones[i].idSolucion;
//    document.getElementById("txtIdProducto").value = soluciones[i].producto.idProducto;
//    document.getElementById("txtNombre").value = soluciones[i].producto.nombre;
//    document.getElementById("txtMarca").value = soluciones[i].producto.marca;
//    document.getElementById("txtPreVenta").value = soluciones[i].producto.precioVenta;
//    document.getElementById("txtPreCompra").value = soluciones[i].producto.precioCompra;
//    document.getElementById("txtExistencia").value = soluciones[i].producto.existencias;
//    
////    document.getElementById("btnUpdate").classList.remove("disabled");
////    document.getElementById("btnDelete").classList.remove("disabled");
////    document.getElementById("btnAdd").classList.add("disabled");
//   // indexSollucionesSeleccionado = i;
//    }
/*Select Leyva
export function selectSoluciones(index) {
    
    document.getElementById("txtCodigoBarras").value = soluciones[index].codigoBarras;
    document.getElementById("txtIdSolucion").value = soluciones[index].idSolucion;
    document.getElementById("txtIdProducto").value = soluciones[index].idProducto;
    document.getElementById("txtNombre").value = soluciones[index].nombre;
    document.getElementById("txtMarca").value = soluciones[index].marca;
    document.getElementById("txtPreVenta").value = soluciones[index].precioVenta;
    document.getElementById("txtPreCompra").value = soluciones[index].precioCompra;
    document.getElementById("txtExistencia").value = soluciones[index].existencias;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexSollucionesSeleccionado = index;
}
*/
export function clean() {
    document.getElementById("txtCodigoBarras").value = "";
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtPreVenta").value = "";
    document.getElementById("txtPreCompra").value = "";
    document.getElementById("txtIdSolucion").value = "";
    document.getElementById("txtExistencia").value = "";
    document.getElementById("txtIdProducto").value="";
    //document.getElementById("txtNombre").focus();
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
    //indexSollucionesSeleccionado = 0;
}


export function updateSoluciones() {
    Swal.fire({
        title: '¿Quieres modificar la solucion?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Aceptar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            /*let numero_unico_soluciones,
                    nombre,
                    marca,
                    existencia,
                    precio_venta,
                    precio_compra,
                    descripcion;

            numero_unico_soluciones = document.getElementById("txtNumUnico").value;
            nombre = document.getElementById("txtNombre").value;
            marca = document.getElementById("txtMarca").value;
            precio_venta = document.getElementById("txtPreVenta").value;
            precio_compra = document.getElementById("txtPreCompra").value;
            descripcion = document.getElementById("txtDescripcion").value;
            existencia = document.getElementById("txtExistencia").value;

            let Solucion = {};
            Solucion.numero_unico_soluciones = numero_unico_soluciones;
            Solucion.nombre = nombre;
            Solucion.marca = marca;
            Solucion.precio_venta = precio_venta;
            Solucion.precio_compra = precio_compra;
            Solucion.descripcion = descripcion;
            Solucion.existencia = existencia;
            Solucion.estatus = "Activo";
            soluciones[indexSollucionesSeleccionado] = Solucion;*/
    let codigoBarras = document.getElementById("txtCodigoBarras").value;
    let nombre = document.getElementById("txtNombre").value;
    let marca = document.getElementById("txtMarca").value;
    let precioVenta = document.getElementById("txtPreVenta").value;
    let precioCompra = document.getElementById("txtPreCompra").value;
    let existencias = document.getElementById("txtExistencia").value;
    let idSolucion = document.getElementById("txtIdSolucion").value;
    let idProducto = document.getElementById("txtIdProducto").value;
    
    let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
        precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias,idProducto:idProducto};
    
    let solucion =JSON.stringify({producto:producto,idSolucion:idSolucion});
    let parametros = new URLSearchParams({datos:solucion,token:token});
    
        fetch('api/solucion/actualizar',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}

            }).then(response => response.json())
            .then(function (data) {
                if (data.result) {
                    alert(data.result);
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
                else{
            clean();
            loadTabla();
            Swal.fire('Producto actualizado!', '', 'success');
            }
                
            });
    
    
        }
    });
}

export function buscarSolucion(){
    let busqueda = document.getElementById("txtBusquedaSolucion").value;
    let parametros ={"buscar":busqueda,token:token};
    fetch('api/solucion/buscar?busqueda='+busqueda)
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
                    cargarEM(data);                     
                }
 });
 }
 
/*export function deleteSoluciones(i){
    let idSolucion = document.getElementById("txtIdSolucion").value;
    let parametros = new URLSearchParams({idSolucion: idSolucion});
    fetch('api/solucion/delete',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())            
              .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarEM(data);
                    let msj = "empleado eliminado con ID: " + idSolucion;
                alert(msj);
                }
            });
}*/





export function deleteSoluciones(i) {
    
    let codigoBarras = document.getElementById("txtCodigoBarras").value;
    let nombre = document.getElementById("txtNombre").value;
    let marca = document.getElementById("txtMarca").value;
    let precioVenta = document.getElementById("txtPreVenta").value;
    let precioCompra = document.getElementById("txtPreCompra").value;
    let existencias = document.getElementById("txtExistencia").value;
    let idProducto = document.getElementById("txtIdProducto").value;
    let idSolucion = document.getElementById("txtIdSolucion").value;    
    let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
        precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias, idProducto:idProducto};
    
    let solucion=JSON.stringify({producto:producto, idSolucion:idSolucion});
    let parametros = new URLSearchParams({datos:solucion,token:token});
    //    
//    fetch('api/solucion/delete',
//            {
//                method:'POST',
//                body:parametros,
//                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
//            }).then(response=>response.json())
//            .then(data=>{
//                if(data.error){
//                    alert(data.error);
//                }
//                else{
//            clean();
//            loadTabla();
//            Swal.fire('Producto Eliminado!', '', 'success');
//        }
//                     });
//    
//    //alert(JSON.stringify(solucion));
    Swal.fire({
        title: 'Quieres eliminar la solucion?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
           // soluciones[indexSollucionesSeleccionado].estatus = "Inactivo";
        fetch('api/solucion/delete',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response=>response.json())
            .then(function (data){
                if(data.error){
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
                else{
            clean();
            loadTabla();
            Swal.fire('Producto Eliminado!', '', 'success');
        }
         });       
        }
    });
}

export function activarSoluciones(i) {
    
    let codigoBarras = document.getElementById("txtCodigoBarras").value;
    let nombre = document.getElementById("txtNombre").value;
    let marca = document.getElementById("txtMarca").value;
    let precioVenta = document.getElementById("txtPreVenta").value;
    let precioCompra = document.getElementById("txtPreCompra").value;
    let existencias = document.getElementById("txtExistencia").value;
    let idProducto = document.getElementById("txtIdProducto").value;
    let idSolucion = document.getElementById("txtIdSolucion").value;    
    let producto={codigoBarras:codigoBarras,nombre:nombre,marca:marca,
        precioCompra:precioCompra,precioVenta:precioVenta,existencias:existencias, idProducto:idProducto};
    
    let solucion=JSON.stringify({producto:producto, idSolucion:idSolucion});
    let parametros = new URLSearchParams({datos:solucion,token:token});
      Swal.fire({
        title: '¿Quieres activar la solucion?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Activar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
           // soluciones[indexSollucionesSeleccionado].estatus = "Inactivo";
        fetch('api/solucion/activar',
            {
                method:'POST',
                body:parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response=>response.json())
            .then(function (data){
                if(data.error){
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
                else{
            clean();
            loadTabla();
            Swal.fire('Producto Activado!', '', 'success');
        }
             });    
        }
    });
}

//VALIDACIONES
const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    codigoBarras: /^[a-zA-Z\s]{1,120}$/,
    nombre: /^[a-zA-ZÀ-ÿ\s]{1,45}$/, // Letras y espacios, pueden llevar acentos.
    marca: /^[a-zA-ZÀ-ÿ\s]{1,45}$/,
    existencias: /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
    precioCompra: /^\d{7,14}$/,
    precioVenta: /^\d{7,14}$/ // 7 a 14 numeros.
    //telefono_movil: /^\d{7,14}$/, // 7 a 14 numeros.
    
};

const campos = {
    codigoBarras: false,
    nombre: false,
    marca: false,
    existencias: false,
    precioCompra: false,
    precioVenta: false
};

const validarFormulario = (e) => {
    switch (e.target.name) {
        case "nombre":
            validarCampo(expresiones.nombre, e.target, 'nombre');
            break;
        case "marca":
            validarCampo(expresiones.marca, e.target, 'marca');
           // validarPassword2();
            break;
        case "existencias":
            validarCampo(expresiones.existencias, e.target, 'existencias');
            break;
        case "precioCompra":
            validarCampo(expresiones.telefono_movil, e.target, 'precioCompra');
            break;
        case "precioVenta":
            validarCampo(expresiones.apellidoPaterno, e.target, 'precioVenta');
            break;
    }
};
//AUN  NO SÉ QUE HACE EST, CHECAR!!!
const validarCampo = (expresion, input, campo) => {
    if (expresion.test(input.value)) {
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
        campos[campo] = true;
    } else {
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
        campos[campo] = false;
    }
};


inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => {
    e.preventDefault();

    const terminos = document.getElementById('terminos');
    if (campos.nombre && campos.telefono_movil && campos.correo && campos.apellidoPaterno && terminos.checked) {
        formulario.reset();

        document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
        }, 5000);

        document.querySelectorAll('.formulario__grupo-correcto').forEach((icono) => {
            icono.classList.remove('formulario__grupo-correcto');
        });
    } else {
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
    }
});
//HASTÁ AQUÍ COMPIÉ Y PEGUE DEL PROYECTO PASADO
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

