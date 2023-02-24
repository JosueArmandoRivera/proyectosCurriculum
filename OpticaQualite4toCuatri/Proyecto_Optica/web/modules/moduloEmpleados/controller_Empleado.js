
/* global Swal */

let indexempleadosSeleccionado;
//let empleados = [];
let empleados;
/*export function agregarEmpleado() {
    const terminos = document.getElementById('terminos');
    if (campos.nombre && campos.telefono && campos.rfc && campos.correo && campos.apellidoPaterno && campos.usuario && campos.password) {
        addEmpleado();
        Swal.fire('Registro Guardado!', '', 'success');
    } else {
        Swal.fire('Rellena todos los campos!', '', 'error');
    }
}*/

export function addEmpleado() {
    alert("Agregar Empleado");
    let nom = (document.getElementById("txtNombre").value);
    let app = (document.getElementById("txtApellidoPaterno").value);
    let apm = (document.getElementById("txtApellidoMaterno").value);
    let g = (document.getElementById("txtGenero").value);
    let fechaNac = document.getElementById("txtFechaNacimiento").value;
    let calle = document.getElementById("txtCalle").value;
    let num = document.getElementById("txtNumero").value;
    let col = document.getElementById("txtColonia").value;
    let cp = document.getElementById("txtCp").value;
    let ciudad = document.getElementById("txtCiudad").value;
    let estado = document.getElementById("txtEstado").value;
    let telCal = document.getElementById("txtnumCasa").value;
    let telMovil = document.getElementById("txttelMovil").value;
    let email = document.getElementById("txtEmail").value;

    fechaNac = fechaNac[8] + fechaNac[9] + "/" + fechaNac[5] + fechaNac[6] + "/" + fechaNac[0] + fechaNac[1] + fechaNac[2] + fechaNac[3];

    let us = document.getElementById("txtNombreUsuario").value;
    let contrasennia = document.getElementById("txtContraseña").value;
    let rol = document.getElementById("txtRol").value;

    let persona = {nombre: nom, apellidoPaterno: app, apellidoMaterno: apm,
        genero: g, fechaNacimiento: fechaNac, calle: calle, numero: num,
        colonia: col, cp: cp, ciudad: ciudad, estado: estado, telCasa: telCal,
        telMovil: telMovil, email: email};

    let usuario = {nombre: us, contrasennia: contrasennia, rol: rol};

    let  empleado = JSON.stringify({persona: persona, usuario: usuario});
    //toma un json lo que hace esdevolver en una cadena todos los datos o atributos
    let parametros = new URLSearchParams({datos: empleado});

    fetch('api/empleado/insert',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                let msj = "empleado insertado con ID:" + data.idEmpleado;
                alert(msj);
                     });
    clean();
    loadTabla();
    //CargarTbl();
}

//Para Cargar la tabla de activos
//export function loadTabla() {
//    alert("Clic en loadTabla");
//    let datos ={estatus:1};
//    let parametros = new URLSearchParams({datos});
//
//    fetch('api/empleado/getAll',
//            {
//                method:'POST',
//                body:(parametros),
//                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
//            }).then(response => response.json())
//            .then(data => {
//                if (data.error) {
//                    alert(data.error);
//                } else {
//                    cargarEM(data);
//                }
//            });          
//}
export function loadTabla() {    
    let datos = {estatus: 1};
    let parametros = new URLSearchParams({datos});

    fetch('api/empleado/getAll',
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
//Cargar Inactivos
}
    export function cargarInactivos() {
    let datos = {estatus: 0};
    let parametros = new URLSearchParams({datos});

    fetch('api/empleado/getAllb',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
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
    empleados = data;
    let contenidoTE = "";
    for (var i=0;i<empleados.length;i++) {

        contenidoTE += "<tr onclick='moduloEmpleado.cargarFrmE("+ i +");'>";
        let estatus = empleados[i].estatus;
        contenidoTE += "<td>" + estatus + "</td>";
        let nombre = empleados[i].persona.nombre + "<br>" + empleados[i].persona.apellidoPaterno + " " + empleados[i].persona.apellidoMaterno;
        contenidoTE += "<td>" + nombre + "</td>";
        let domicilio = empleados[i].persona.calle + " #" + empleados[i].persona.numero + ", " + empleados[i].persona.colonia + ", CP " + empleados[i].persona.cp;
        contenidoTE += "<td>" + domicilio + "</td>";
        let telefonos = empleados[i].persona.telCasa + "<br>" + empleados[i].persona.telMovil;
        contenidoTE += "<td>" + telefonos + "</td>";
        let correo = empleados[i].persona.email;
        contenidoTE += "<td>" + correo + "</td>";
        let usuario = empleados[i].usuario.nombre;
        contenidoTE += "<td>" + usuario + "</td>";
        contenidoTE += "<td><button onclick='moduloEmpleado.activar("+ i +");'>Activar</button></td>";
        contenidoTE += "<td><button onclick='moduloEmpleado.eliminar("+ i +");'>Eliminar</button></td>";
        contenidoTE += "</tr>";
    }
    document.getElementById("tblEmpleados").innerHTML = contenidoTE;
}

/*
export function loadTabla() {
    let cuerpo = "";
    empleados.forEach(function (empleado) {
        let registro =
                '<tr onclick="moduloEmpleado.selectEmpleados(' + empleados.indexOf(empleado) + ');">' +
                '<td>' + empleado.nombre + '</td>' +
                '<td>' + empleado.apellido_paterno + ' ' + empleado.apellido_materno + '</td>' +
                '<td>' + empleado.genero + '</td>' +
                '<td>' + empleado.telefono_movil + '</td>' +
                '<td>' + empleado.estatus + '</td>' +
                '<td>' + empleado.usuario + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblEmpleados").innerHTML = cuerpo;

}*/
export function cargarFrmE(i) {
    document.getElementById("txtNombre").value = empleados[i].persona.nombre;
    document.getElementById("txtApellidoPaterno").value = empleados[i].persona.apellidoPaterno;
    document.getElementById("txtApellidoMaterno").value = empleados[i].persona.apellidoMaterno;
    document.getElementById("txtGenero").value = empleados[i].persona.genero;
    document.getElementById("txtFechaNacimiento").value = empleados[i].persona.fechaNacimiento;
    document.getElementById("txtCalle").value = empleados[i].persona.calle;
    document.getElementById("txtNumero").value = empleados[i].persona.numero;
    document.getElementById("txtColonia").value = empleados[i].persona.colonia;
    document.getElementById("txtCp").value = empleados[i].persona.cp;
    document.getElementById("txtCiudad").value = empleados[i].persona.ciudad;
    document.getElementById("txtEstado").value = empleados[i].persona.estado;
    document.getElementById("txtnumCasa").value = empleados[i].persona.telCasa;
    document.getElementById("txttelMovil").value = empleados[i].persona.telMovil;
    document.getElementById("txtEmail").value = empleados[i].persona.email;
    document.getElementById("txtNombreUsuario").value = empleados[i].usuario.nombre;
    document.getElementById("txtContraseña").value = empleados[i].usuario.contrasennia;
    document.getElementById("txtRol").value = empleados[i].usuario.rol;
    document.getElementById("txtIDpersona").value = empleados[i].persona.idPersona;
    document.getElementById("txtIDusuario").value = empleados[i].usuario.idUsuario;
    document.getElementById("txtIdEmpleado").value = empleados[i].idEmpleado;
    document.getElementById("txtNumUnico").value = empleados[i].numeroUnico;
}



export function selectEmpleados(index) {
    document.getElementById("txtNumUnico").value = empleados[index].numero_unico_empleado;
    document.getElementById("txtNombre").value = empleados[index].nom;
    document.getElementById("txtApellidoPaterno").value = empleados[index].app;
    document.getElementById("txtApellidoMaterno").value = empleados[index].apm;
    document.getElementById("txtTelefono").value = empleados[index].telefono;
    document.getElementById("txtMovil").value = empleados[index].telefono_movil;
    document.getElementById("txtCorreo").value = empleados[index].correo_electronico;
    document.getElementById("txtRfc").value = empleados[index].rfc;
    document.getElementById("txtGenero").value = empleados[index].g;
    document.getElementById("txtNombreUsuario").value = empleados[index].us;
    document.getElementById("txtContrasenia").value = empleados[index].contrasenia;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexempleadosSeleccionado = index;
}

export function clean() {
    document.getElementById("txtNombre").value = "";
    document.getElementById("txtApellidoPaterno").value = "";
    document.getElementById("txtApellidoMaterno").value = "";
    document.getElementById("txtGenero").value = "";
    document.getElementById("txtFechaNacimiento").value = "";
    document.getElementById("txtCalle").value = "";
    document.getElementById("txtNumero").value = "";
    document.getElementById("txtColonia").value = "";
    document.getElementById("txtCp").value = "";
    document.getElementById("txtCiudad").value = "";
    document.getElementById("txtEstado").value = "";
    document.getElementById("txtnumCasa").value = "";
    document.getElementById("txttelMovil").value = "";
    document.getElementById("txtEmail").value = "";
    document.getElementById("txtNombreUsuario").value = "";
    document.getElementById("txtContraseña").value = "";
    document.getElementById("txtRol").value = "";
    document.getElementById("txtIDpersona").value = "";
    document.getElementById("txtIDusuario").value = "";
    document.getElementById("txtIdEmpleado").value = "";

    
    document.getElementById("btnUpdate").classList.add("disabled");
    document.getElementById("btnDelete").classList.add("disabled");
    document.getElementById("btnAdd").classList.remove("disabled");
   
   
    
    indexempleadosSeleccionado = 0;
}

export function updateEmpleado() {
    Swal.fire({
        title: 'Quieres modificar el empleado?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Aceptar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            let numero_unico_empleado,
                    nombre,
                    apellido_paterno,
                    apellido_materno,
                    genero,
                    rfc,
                    telefono,
                    telefono_movil,
                    correo_electronico,
                    usuario,
                    contrasenia;

            numero_unico_empleado = document.getElementById("txtNumUnico").value;
            nombre = document.getElementById("txtNombre").value;
            apellido_paterno = document.getElementById("txtApePaterno").value;
            apellido_materno = document.getElementById("txtApeMaterno").value;
            telefono = document.getElementById("txtTelefono").value;
            telefono_movil = document.getElementById("txtMovil").value;
            correo_electronico = document.getElementById("txtCorreo").value;
            rfc = document.getElementById("txtRfc").value;
            genero = document.getElementById("txtGenero").value;
            usuario = document.getElementById("txtUsuario").value;
            contrasenia = document.getElementById("txtContrasenia").value;

            let empleado = {};
            empleado.numero_unico_empleado = numero_unico_empleado;
            empleado.nombre = nombre;
            empleado.apellido_paterno = apellido_paterno;
            empleado.apellido_materno = apellido_materno;
            empleado.telefono = telefono;
            empleado.telefono_movil = telefono_movil;
            empleado.correo_electronico = correo_electronico;
            empleado.rfc = rfc;
            empleado.genero = genero;
            empleado.usuario = usuario;
            empleado.contrasenia = contrasenia;
            empleado.estatus = "Activo";
            empleados[indexempleadosSeleccionado] = empleado;
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}
//Para seleccionar la fila
/*export function cargarFrmE(i) {
    document.getElementById("txtNombre").value = empleados[i].persona.nombre;
    document.getElementById("txtApellidoPaterno").value = empleados[i].persona.apellidoPaterno;
    document.getElementById("txtApellidoMaterno").value = empleados[i].persona.apellidoMaterno;
    document.getElementById("txtGenero").value = empleados[i].persona.genero;
    document.getElementById("txtFechaNacimiento").value = empleados[i].persona.fechaNacimiento;
    document.getElementById("txtCalle").value = empleados[i].persona.calle;
    document.getElementById("txtNumero").value = empleados[i].persona.numero;
    document.getElementById("txtColonia").value = empleados[i].persona.colonia;
    document.getElementById("txtCp").value = empleados[i].persona.cp;
    document.getElementById("txtCiudad").value = empleados[i].persona.ciudad;
    document.getElementById("txtEstado").value = empleados[i].persona.estado;
    document.getElementById("txtnumCasa").value = empleados[i].persona.telCasa;
    document.getElementById("txttelMovil").value = empleados[i].persona.telMovil;
    document.getElementById("txtEmail").value = empleados[i].persona.email;
    document.getElementById("txtNombreUsuario").value = empleados[i].usuario.nombre;
    document.getElementById("txtContraseña").value = empleados[i].usuario.contrasenia;
    document.getElementById("txtRol").value = empleados[i].usuario.rol;
    document.getElementById("txtIDpersona").value = empleados[i].persona.idPersona;
    document.getElementById("txtIDusuario").value = empleados[i].usuario.idUsuario;
    document.getElementById("txtIdEmpleado").value = empleados[i].idEmpleado;
}
*/
export function deleteEmpleado() {
    Swal.fire({
        title: 'Quieres eliminar el empleado?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            empleados[indexempleadosSeleccionado].estatus = "Inactivo";
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}/*
export function searchEmpleados() {
    let filtro = document.getElementById("txtBusquedaEmpleados").value;
    let resultados = empleados.filter(element => element.nombre === filtro || element.apellido_paterno === filtro || element.apellido_materno === filtro || element.genero === filtro);
    let cuerpo = "";
        resultados.forEach(function (empleado) {
        let registro =
                '<tr onclick="moduloEmpleado.selectEmpleados(' + empleados.indexOf(empleado) + ');">' +
                '<td>' + empleado.nom + ' ' + empleado.app + ' ' + empleado.apm + '</td>' +
                '<td>' + empleado.g + '</td>' +
                '<td>' + empleado.telMovil + '</td>' +
                '<td>' + empleado.telCal   + '</td>' +
                '<td>' + empleado.us       + '</td>' +
                '<td>' + empleado.email    + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblEmpleados").innerHTML = cuerpo;
}*/
export function searchEmpleados(){
    let busqueda = document.getElementById("txtBusquedaEmpleados").value;
    let parametros ={"buscar":busqueda};
    fetch('api/empleado/buscar?busqueda='+busqueda)
           .then(response => response.json())
            .then(data => {
                //let msj = "empleado actualizado con ID: " + data.idEmpleado;
                //alert(msj);
                if (data.error !=null) {
                    alert(data.error);
                } else {
                    cargarEM(data);                     
                }
 });
 }

const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
/*
const expresiones = {
	usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
	nombre: /^[a-zA-ZÁ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^.{4,12}$/, // 4 a 12 digitos.
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	telefono: /^\d{7,14}$/, // 7 a 14 numeros.
        rfc: /^[a-zA-Z0-9\_\-]{4,16}$/,
        apellidoPaterno:/^[a-zA-ZÀ-ÿ\s]{1,40}$/
};

const campos = {
	usuario: false,
	nom: false,
        app: false,
        apm: false,
        g: false,
        estado: false,
        telMovil: false,
        email: false,
        cp: false,
        fechaNac: false,
	password: false,
	correo: false,
	telefono: false,
        rfc: false,
        apellidoPaterno: false
};
*/
/*
const validarFormulario = (e) => {
	switch (e.target.name) {
		case "usuario":
			validarCampo(expresiones.usuario, e.target, 'usuario');
		break;
		case "nom":
			validarCampo(expresiones.nombre, e.target, 'nombre');
		break;
		case "password":
			validarCampo(expresiones.password, e.target, 'password');
			validarPassword();
		break;
		case "password2":
			validarPassword2();
		break;
		case "email":
			validarCampo(expresiones.correo, e.target, 'correo');
		break;
		case "telefono":
			validarCampo(expresiones.telefono, e.target, 'telefono');
		break;
                case "rfc":
			validarCampo(expresiones.rfc, e.target, 'rfc');
		break;
                 case "apellidoPaterno":
			validarCampo(expresiones.apellidoPaterno, e.target, 'apellidoPaterno');
		break;
	}
};
*//*
const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
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
	if(campos.nombre && campos.telefono && campos.rfc && campos.correo && campos.apellidoPaterno && campos.usuario && campos.password && terminos.checked ){
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
*/
fetch("modules/moduloEmpleados/data_Empleados.json")
        .then(response => {
            return response.json();
        })
        .then(function (jsondata) {
            empleados = jsondata;
            console.log(empleados);
            loadTabla();
        }
        );
