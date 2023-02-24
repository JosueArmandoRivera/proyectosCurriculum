
/* global Swal */

let indexAccesoriosSeleccionado;
let accesorios = [];

export function addAccesorios() {
    let numero_unico_accesorios,
            nombre,
            marca,
            precio_venta,
            precio_compra;

    numero_unico_accesorios = document.getElementById("txtNumUnico").value;
    nombre = document.getElementById("txtNombre").value;
    marca = document.getElementById("txtMarca").value;
    precio_venta = document.getElementById("txtPreVenta").value;
    precio_compra = document.getElementById("txtPreCompra").value;


    let accesorio = {};
    accesorio.numero_unico_accesorios = "RF01";
    accesorio.nombre = nombre;
    accesorio.marca = marca;
    accesorio.precio_venta = precio_venta;
    accesorio.precio_compra = precio_compra;
    accesorio.estatus = "Activo";
    accesorios.push(accesorio);
    clean();
    loadTabla();
    Swal.fire('Accesorios Guardado!', '', 'success');
}

export function loadTabla() {
    let cuerpo = "";
    accesorios.forEach(function (accesorio) {
        let registro =
                '<tr onclick="moduloAccesorios.selectAccesorios(' + accesorios.indexOf(accesorio) + ');">' +
                '<td>' + accesorio.nombre + '</td>' +
                '<td>' + accesorio.marca + '</td>' +
                '<td>' + accesorio.precio_venta + '</td>' +
                '<td>' + accesorio.precio_compra + '</td>' +
                '<td>' + accesorio.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblAccesorios").innerHTML = cuerpo;

}

export function selectAccesorios(index) {
    document.getElementById("txtNumUnico").value = accesorios[index].numero_unico_accesorios;
    document.getElementById("txtNombre").value = accesorios[index].nombre;
    document.getElementById("txtMarca").value = accesorios[index].marca;
    document.getElementById("txtPreVenta").value = accesorios[index].precio_venta;
    document.getElementById("txtPreCompra").value = accesorios[index].precio_compra;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexAccesoriosSeleccionado = index;
}

export function clean() {
    document.getElementById("txtNumUnico").value = "";
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtMarca").value = "";
    document.getElementById("txtPreVenta").value = "";
    document.getElementById("txtPreCompra").value = "";

    //document.getElementById("txtNombre").focus();
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
    indexAccesoriosSeleccionado = 0;
}

export function updateAccesorios() {
    Swal.fire({
        title: 'Quieres modificar el accesorio?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Aceptar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            let numero_unico_accesorios,
                    nombre,
                    marca,
                    precio_venta,
                    precio_compra;

            numero_unico_accesorios = document.getElementById("txtNumUnico").value;
            nombre = document.getElementById("txtNombre").value;
            marca = document.getElementById("txtMarca").value;
            precio_venta = document.getElementById("txtPreVenta").value;
            precio_compra = document.getElementById("txtPreCompra").value;

            let accesorio = {};
            accesorio.numero_unico_accesorios = numero_unico_accesorios;
            accesorio.nombre = nombre;
            accesorio.marca = marca;
            accesorio.precio_venta = precio_venta;
            accesorio.precio_compra = precio_compra;
            accesorio.estatus = "Activo";
            accesorios[indexAccesoriosSeleccionado] = accesorio;
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}

export function deleteAccesorios() {
    Swal.fire({
        title: 'Quieres eliminar el accesorio?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            accesorios[indexAccesoriosSeleccionado].estatus = "Inactivo";
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}

fetch("modules/modulosAccesorios/data_Accesorios.json")
        .then(response => {
            return response.json();
        })
        .then(function (jsondata) {
            accesorios = jsondata;
            console.log(accesorios);
            loadTabla();
        }
        );

