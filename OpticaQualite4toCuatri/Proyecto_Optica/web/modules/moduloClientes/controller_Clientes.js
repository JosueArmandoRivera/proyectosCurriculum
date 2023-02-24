/* global Swal */

let indexClienteSeleccionado;
let clientes = [];

//AGREGAR CLIENTEEE

export function agregarCliente() {
    const terminos = document.getElementById('terminos');
    if (campos.nombre && campos.telefono_movil && campos.correo && campos.apellidoPaterno) {
        addCliente();
        Swal.fire('Registro Guardado!', '', 'success');
    } else {
        Swal.fire('Rellena todos los campos!', '', 'error');
    }
}

export function addCliente() {
    let numero_unico_cliente,
            nombre,
            apellido_paterno,
            apellido_materno,
            genero,
            rfc,
            telefono,
            telefono_movil,
            correo_electronico;

    numero_unico_cliente = document.getElementById("txtNumUnico").value;
    nombre = document.getElementById("txtNombre").value;
    apellido_paterno = document.getElementById("txtApePaterno").value;
    apellido_materno = document.getElementById("txtApeMaterno").value;
    telefono = document.getElementById("txtTelefono").value;
    telefono_movil = document.getElementById("txtMovil").value;
    correo_electronico = document.getElementById("txtCorreo").value;
    rfc = document.getElementById("txtRfc").value;
    genero = document.getElementById("txtGenero").value;
    ;

    let cliente = {};
    cliente.numero_unico_cliente = "RF01";
    cliente.nombre = nombre;
    cliente.apellido_paterno = apellido_paterno;
    cliente.apellido_materno = apellido_materno;
    cliente.telefono = telefono;
    cliente.telefono_movil = telefono_movil;
    cliente.correo_electronico = correo_electronico;
    cliente.rfc = rfc;
    cliente.genero = genero;
    cliente.estatus = "Activo";
    clientes.push(cliente);
    clean();
    loadTabla();
    Swal.fire('Registro Guardado!', '', 'success');
}

//CARGAR TABLA

export function loadTabla() {
    let cuerpo = "";
    clientes.forEach(function (cliente) {
        let registro =
                '<tr onclick="moduloCliente.selectCliente(' + clientes.indexOf(cliente) + ');">' +
                '<td>' + cliente.nombre + '</td>' +
                '<td>' + cliente.apellido_paterno + ' ' + cliente.apellido_materno + '</td>' +
                '<td>' + cliente.genero + '</td>' +
                '<td>' + cliente.telefono_movil + '</td>' +
                '<td>' + cliente.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblClientes").innerHTML = cuerpo;

}

//SELECCIONAR CLIENTE

export function selectCliente(index) {
    document.getElementById("txtNumUnico").value = clientes[index].numero_unico_cliente;
    document.getElementById("txtNombre").value = clientes[index].nombre;
    document.getElementById("txtApePaterno").value = clientes[index].apellido_paterno;
    document.getElementById("txtApeMaterno").value = clientes[index].apellido_materno;
    document.getElementById("txtTelefono").value = clientes[index].telefono;
    document.getElementById("txtMovil").value = clientes[index].telefono_movil;
    document.getElementById("txtCorreo").value = clientes[index].correo_electronico;
    document.getElementById("txtRfc").value = clientes[index].rfc;
    document.getElementById("txtGenero").value = clientes[index].genero;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexClienteSeleccionado = index;
}

//LIMPIAR TABLA

export function clean() {
    document.getElementById("txtNumUnico").value = "";
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtApePaterno").value = "";
    document.getElementById("txtApeMaterno").value = "";
    document.getElementById("txtTelefono").value = "";
    document.getElementById("txtMovil").value = "";
    document.getElementById("txtCorreo").value = "";
    document.getElementById("txtRfc").value = "";

    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
    indexClienteSeleccionado = 0;
}

// ACTUALIAR CLIENTE

export function updateCliente() {
    Swal.fire({
        title: '¿Estas seguro que quieres modificar?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Aceptar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            let numero_unico_cliente,
                    nombre,
                    apellido_paterno,
                    apellido_materno,
                    genero,
                    rfc,
                    telefono,
                    telefono_movil,
                    correo_electronico;

            numero_unico_cliente = document.getElementById("txtNumUnico").value;
            nombre = document.getElementById("txtNombre").value;
            apellido_paterno = document.getElementById("txtApePaterno").value;
            apellido_materno = document.getElementById("txtApeMaterno").value;
            telefono = document.getElementById("txtTelefono").value;
            telefono_movil = document.getElementById("txtMovil").value;
            correo_electronico = document.getElementById("txtCorreo").value;
            rfc = document.getElementById("txtRfc").value;

            genero = document.getElementById("txtGenero").value;

            let cliente = {};
            cliente.numero_unico_cliente = numero_unico_cliente;
            cliente.nombre = nombre;
            cliente.apellido_paterno = apellido_paterno;
            cliente.apellido_materno = apellido_materno;
            cliente.telefono = telefono;
            cliente.telefono_movil = telefono_movil;
            cliente.correo_electronico = correo_electronico;
            cliente.rfc = rfc;
            cliente.genero = genero;
            cliente.estatus = "Activo";
            clientes[indexClienteSeleccionado] = cliente;
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}

//BUSCAR CLIENTE
export function searchCliente() {
    let filtro = document.getElementById("txtBusquedaCliente").value;
    let resultados = clientes.filter(element => element.nombre === filtro || element.apellido_paterno === filtro || element.apellido_materno === filtro || element.genero === filtro);
    let cuerpo = "";
    resultados.forEach(function (cliente) {
        let registro =
                '<tr onclick="moduloCliente.selectCliente (' + clientes.indexOf(cliente) + ');">' +
                '<td>' + cliente.nombre + '</td>' +
                '<td>' + cliente.apellido_paterno + ' ' + cliente.apellido_materno + '</td>' +
                '<td>' + cliente.genero + '</td>' +
                '<td>' + cliente.telefono_movil + '</td>' +
                '<td>' + cliente.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblClientes").innerHTML = cuerpo;

}

//BORRAR CLIENTE

export function deleteCliente() {
    Swal.fire({
        title: 'Quieres eliminar el cliente?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            clientes[indexClienteSeleccionado].estatus = "Inactivo";
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });

}

//VALIDACIONES

const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
    apellidoPaterno: /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
    apellidoMaterno: /^[a-zA-ZÀ-ÿ\s]{1,40}$/,
    correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
    telefono: /^\d{7,14}$/, // 7 a 14 numeros.
    telefono_movil: /^\d{7,14}$/, // 7 a 14 numeros.
    rfc: /^[a-zA-Z0-9\_\-]{4,16}$/
};

const campos = {
    nombre: false,
    correo: false,
    telefono: false,
    telefono_movil: false,
    rfc: false,
    apellidoMaterno: false,
    apellidoPaterno: false
};

const validarFormulario = (e) => {
    switch (e.target.name) {
        case "nombre":
            validarCampo(expresiones.nombre, e.target, 'nombre');
            break;
        case "password":
            validarCampo(expresiones.password, e.target, 'password');
            validarPassword2();
            break;
        case "correo":
            validarCampo(expresiones.correo, e.target, 'correo');
            break;
        case "telefono_movil":
            validarCampo(expresiones.telefono_movil, e.target, 'telefono_movil');
            break;
        case "apellidoPaterno":
            validarCampo(expresiones.apellidoPaterno, e.target, 'apellidoPaterno');
            break;
    }
};

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

fetch("modules/moduloClientes/data_Clientes.json")
        .then(response => {
            return response.json();
        })
        .then(function (jsondata) {
            clientes = jsondata;
            console.log(clientes);
            loadTabla();
        }
        );