let indexCTratamientoSeleccionado;
let tratamientos = [];

export function addTratamiento(){
    let numero_unico_tratamientos, 
        nombre,
        precio_venta,
        precio_compra;

    numero_unico_tratamientos = document.getElementById("txtNumUnico").value;
    nombre = document.getElementById("txtNombre").value;
    precio_venta = document.getElementById("txtPreVenta").value;
    precio_compra = document.getElementById("txtPreCompra").value;
   
    
    let tratamiento = {};
    tratamiento.numero_unico_tratamientos =  "RF01";
    tratamiento.nombre = nombre;
    tratamiento.precio_venta = precio_venta;
    tratamiento.precio_compra = precio_compra;
    tratamiento.estatus = "Activo";
    tratamientos.push(tratamiento);
    clean();
    loadTabla();
}

export function loadTabla(){
    let cuerpo = "";
    tratamientos.forEach(function (tratamiento){
        let registro =  
                '<tr onclick="moduloTratamiento.selectTratamiento('+ tratamientos.indexOf(tratamiento) +');">'+
                '<td>' + tratamiento.nombre + '</td>' +
                '<td>' + tratamiento.precio_venta + '</td>' +
                '<td>' + tratamiento.precio_compra +'</td>' +
                '<td>' + tratamiento.estatus + '</td></tr>' ; 
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblTratamiento").innerHTML = cuerpo;
    
}

export function selectTratamiento(index){
    document.getElementById("txtNumUnico").value = tratamientos[index].numero_unico_tratamientos;
    document.getElementById("txtNombre").value = tratamientos[index].nombre ;
    document.getElementById("txtPreVenta").value = tratamientos[index].precio_venta;
    document.getElementById("txtPreCompra").value = tratamientos[index].precio_compra;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexCTratamientoSeleccionado = index;
}

export function clean(){
    document.getElementById("txtNumUnico").value = "";
    document.getElementById("txtNombre").value = "" ;
    document.getElementById("txtPreVenta").value = "";
    document.getElementById("txtPreCompra").value = "";
    
    document.getElementById("txtNombre").focus();
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
    indexCTratamientoSeleccionado = 0;
}

export function updateTratamiento() {
     let numero_unico_tratamientos, 
        nombre,
        precio_venta,
        precio_compra;

    numero_unico_tratamientos = document.getElementById("txtNumUnico").value;
    nombre = document.getElementById("txtNombre").value;
    precio_venta = document.getElementById("txtPreVenta").value;
    precio_compra = document.getElementById("txtPreCompra").value;

    let tratamiento = {};
    tratamiento.numero_unico_tratamientos = numero_unico_tratamientos;
    tratamiento.nombre = nombre;
    tratamiento.precio_venta = precio_venta;
    tratamiento.precio_compra = precio_compra;
    tratamiento.estatus = "Activo";
    tratamientos[indexCTratamientoSeleccionado] = tratamiento;
    clean();
    loadTabla();
}

export function deleteTratamiento(){
    tratamientos[indexCTratamientoSeleccionado].estatus = "Inactivo";
    clean();
    loadTabla();
}
export function searchCliente() {
    let filtro = document.getElementById("txtBusqueda Cliente").value;
    let resultados = tratamientos.filter(element => element.nombre === filtro);
    let cuerpo = "";
    resultados.forEach(function (tratamiento) {
        let registro =
                '<tr onclick="moduloCliente.selectCliente (' + tratamientos.indexOf(tratamientos) + ');">' +
                '<td>' + tratamientos.nombre + '</td>' +
                '<td>' + tratamientos.apellido_paterno + '' + tratamientos.apellido_materno + '</td>' +
                '<td>' + tratamientos.genero + '</td>' +
                '<td>' + tratamientos.telefono_movil + '</td>' +
                '<td>' + tratamientos.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblClientes").innerHTML = cuerpo;


    
    }
fetch("modules/moduloTratamientos/data_Tratamientos.json")
        .then(response =>{
            return response.json();
        })
        .then(function(jsondata){
                tratamientos = jsondata;
                console.log(tratamientos);
                loadTabla();
            }            
        );
