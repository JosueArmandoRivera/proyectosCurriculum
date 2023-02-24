/* global Swal */

let indexArmazonesSeleccionado;
let armazones = [];



export function addArmazon() {
    let numero_unico_armazones,
            nombre,
            Marca,
            Modelo,
            color,
            Dimensiones,
            existencia,
            precio_venta,
            precio_compra,
            descripcion;

    numero_unico_armazones = document.getElementById("txtNumUnico").value;
    nombre = document.getElementById("txtNombre").value;
    precio_venta = document.getElementById("txtPreVenta").value;
    precio_compra = document.getElementById("txtPreCompra").value;
    Marca = document.getElementById("txtMarca").value;
    Modelo = document.getElementById("txtModelo").value;
    color = document.getElementById("txtColor").value;
    Dimensiones = document.getElementById("txtDimensiones").value;
    existencia = document.getElementById("txtExistencia").value;
    descripcion = document.getElementById("txtDescripcion").value;


    let Armazon = {};
    Armazon.numero_unico_armazones = "RF01";
    Armazon.nombre = nombre;
    Armazon.precio_venta = precio_venta;
    Armazon.precio_compra = precio_compra;
    Armazon.Marca = Marca;
    Armazon.Modelo = Modelo;
    Armazon.color = color;
    Armazon.Dimensiones = Dimensiones;
    Armazon.existencia = existencia;
    Armazon.descripcion = descripcion;
    Armazon.estatus = "Activo";
    armazones.push(Armazon);
    clean();
    loadTabla();
    Swal.fire('Registro Guardado!', '', 'success');

}

export function loadTabla() {
    let cuerpo = "";
    armazones.forEach(function (Armazon) {
        let registro =
                '<tr onclick="moduloArmazones.selectArmazones(' + armazones.indexOf(Armazon) + ');">' +
                '<td>' + Armazon.nombre + '</td>' +
                '<td>' + Armazon.Marca + '</td>' +
                '<td>' + Armazon.Modelo + '</td>' +
                '<td>' + Armazon.color + '</td>' +
                '<td>' + Armazon.Dimensiones + '</td>' +
                '<td>' + Armazon.existencia + '</td>' +
                '<td>' + Armazon.precio_venta + '</td>' +
                '<td>' + Armazon.precio_compra + '</td>' +
                '<td>' + Armazon.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblArmazon").innerHTML = cuerpo;

}

export function selectArmazones(index) {
    document.getElementById("txtNumUnico").value = armazones[index].numero_unico_armazones;
    document.getElementById("txtNombre").value = armazones[index].nombre;
    document.getElementById("txtPreVenta").value = armazones[index].precio_venta;
    document.getElementById("txtPreCompra").value = armazones[index].precio_compra;
    document.getElementById("txtMarca").value = armazones[index].Marca;
    document.getElementById("txtModelo").value = armazones[index].Modelo;
    document.getElementById("txtColor").value = armazones[index].color;
    document.getElementById("txtDimensiones").value = armazones[index].Dimensiones;
    document.getElementById("txtExistencia").value = armazones[index].existencia;
    document.getElementById("txtDescripcion").value = armazones[index].descripcion;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexArmazonesSeleccionado = index;
}

export function clean() {
    document.getElementById("txtNumUnico").value = "";
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtPreVenta").value = "";
    document.getElementById("txtPreCompra").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtModelo").value = "";
    document.getElementById("txtColor").value = "";
    document.getElementById("txtDimensiones").value = "";
    document.getElementById("txtExistencia").value = "";
    document.getElementById("txtDescripcion").value = "";

    document.getElementById("txtNombre").focus();
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
    indexArmazonesSeleccionado = 0;
}

export function updateArmazon() {
    Swal.fire({
        title: '¿Estas seguro que quieres modificar?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Aceptar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            let numero_unico_armazones,
                    nombre,
                    Marca,
                    Modelo,
                    color,
                    Dimensiones,
                    existencia,
                    precio_venta,
                    precio_compra,
                    descripcion;

            numero_unico_armazones = document.getElementById("txtNumUnico").value;
            nombre = document.getElementById("txtNombre").value;
            precio_venta = document.getElementById("txtPreVenta").value;
            precio_compra = document.getElementById("txtPreCompra").value;
            Marca = document.getElementById("txtMarca").value;
            Modelo = document.getElementById("txtModelo").value;
            color = document.getElementById("txtColor").value;
            Dimensiones = document.getElementById("txtDimensiones").value;
            existencia = document.getElementById("txtExistencia").value;
            descripcion = document.getElementById("txtDescripcion").value;

            let Armazon = {};
            Armazon.numero_unico_armazones = "RF01";
            Armazon.nombre = nombre;
            Armazon.precio_venta = precio_venta;
            Armazon.precio_compra = precio_compra;
            Armazon.Marca = Marca;
            Armazon.Modelo = Modelo;
            Armazon.color = color;
            Armazon.Dimensiones = Dimensiones;
            Armazon.existencia = existencia;
            Armazon.descripcion = descripcion;
            Armazon.estatus = "Activo";
            armazones[indexArmazonesSeleccionado] = Armazon;
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}

export function deleteArmazon() {
    Swal.fire({
        title: 'Quieres eliminar el cliente?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            armazones[indexArmazonesSeleccionado].estatus = "Inactivo";
            clean();
            loadTabla();
        }
    });
}
export function searchCliente() {
    let filtro = document.getElementById("txtBusqueda Cliente").value;
    let resultados = armazones.filter(element => element.nombre === filtro);
    let cuerpo = "";
    resultados.forEach(function (Armazon) {
        let registro =
                '<tr onclick="moduloCliente.selectCliente (' + armazones.indexOf(armazones) + ');">' +
                '<td>' + armazones.nombre + '</td>' +
                '<td>' + armazones.apellido_paterno + '' + armazones.apellido_materno + '</td>' +
                '<td>' + armazones.genero + '</td>' +
                '<td>' + armazones.telefono_movil + '</td>' +
                '<td>' + armazones.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblClientes").innerHTML = cuerpo;



}
fetch("modules/moduloArmazones/data_Armazones.json")
        .then(response => {
            return response.json();
        })
        .then(function (jsondata) {
            Armazones = jsondata;
            console.log(Armazones);
            loadTabla();
        }
        );
