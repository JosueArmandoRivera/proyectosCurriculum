
let empleados;

function insertar() {
    let nom = (document.getElementById("txtnombre").value);
    let app = (document.getElementById("txtapePaterno").value);
    let apm = (document.getElementById("txtapeMaterno").value);
    let g = (document.getElementById("txtgenero").value);
    let fechaNac = document.getElementById("txtfechaNac").value;
    fechaNac = formatDate(fechaNac);
    let calle = document.getElementById("txtcalle").value;
    let num = document.getElementById("txtnumeroCasa").value;
    let col = document.getElementById("txtcolonia").value;
    let cp = document.getElementById("txtcp").value;
    let ciudad = document.getElementById("txtciudad").value;
    let estado = document.getElementById("txtestado").value;
    let telCal = document.getElementById("txtnumCasa").value;
    let telMovil = document.getElementById("txtnumMovil").value;
    let email = document.getElementById("txtemail").value;

    let us = document.getElementById("txtusuario").value;
    let contrasennia = document.getElementById("txtcontrasenia").value;
    let rol = document.getElementById("txtrol").value;

    let usuario ={nombreUsuario:us, contrasenia:contrasennia, rol:rol};

    let persona ={nombre:nom,apellidoPaterno:app,apellidoMaterno:apm,
        genero:g,fechaNacimiento:fechaNac,calle:calle,numero:num,
        colonia:col,cp:cp,ciudad:ciudad,estado:estado,telCasa:telCal,
        telMovil:telMovil,email:email};

    let empleado = JSON.stringify({usuario:usuario,persona:persona});//Aquí puse persona a Persona y Usuario a usuario, por si es el nombre de las clases de model
    //toma un json lo que hace esdevolver en una cadena todos los datos o atributos
    //JSON.stringify convierte a cadena
    let parametros = new URLSearchParams({datos:empleado});

     alert(JSON.stringify({datos:empleado}));
    
    
    
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
    
//
//    fetch('api/empleado/insert',
//            {
//                method:'POST',
//                body:parametros,
//                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
//            }).then(response=>response.json())
//              .then(data=>{
//                let msj="empleado insertado con ID:"+data.idEmpleado;
//                alert(msj);
//            });
}

function fechas() {
    fecha = document.getElementById("txtfechaNac").value;
    fecha = formaterarFecha(fecha);
}
function formatDate() {
    let fecha = document.getElementById("txtfechaNac").value;
    let anio = fecha.toString().substr(0, 4);
    let mes = fecha.toString().substr(5, 2);
    let dia = fecha.toString().substr(8, 2);

    let fechaFormat = (dia + "/" + mes + "/" + anio);
    return fechaFormat;
}


function catalogoEmpleados() {
    let datos = {estatus:1};
    let parametros = new URLSearchParams({datos});

    fetch("api/empleado/getAll",
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error != null) {
                    alert(data.error);
                } else {
                    cargarTablaE(data);
                }
            });
}

function cargarTablaE(data) {
    
    empleados = data;
    let contenidoTE = "";
    for (var i=0;i<empleados.length;i++) {
        contenidoTE+="<tr>";
        let nombre=empleados[i].persona.nombre+" "+
                   empleados[i].persona.apellidoPaterno+" "+
                   empleados[i].persona.apellidoMaterno;
        contenidoTE +="<td>"+nombre+"</td>";
        let correo =empleados[i].persona.email;
        contenidoTE +="<td>"+correo+"</td>";
        let domicilio = empleados[i].persona.calle+" "+
                        empleados[i].persona.numero+" "+
                        empleados[i].persona.colonia+" "+
                        empleados[i].persona.cp+" "+
                        empleados[i].persona.ciudad+" "+
                        empleados[i].persona.estado;
        contenidoTE +="<td>"+domicilio+"</td>";
        let telefonos=empleados[i].persona.telCasa+" "+
                      empleados[i].persona.telMovil;
        contenidoTE +="<td>"+telefonos+"</td>";
        let usuario =empleados[i].usuario.nombreUsuario+" "+ //le agregué .nombreUsuario+" "+
                     empleados[i].usuario.rol;//le agregué esta linea
                    contenidoTE +="<td>"+usuario+"</td>";//Le agregué esta columna
                    contenidoTE+="<td><button onclick='cargarFrmE("+i+");'>ver</button></td>";
                  /*contenidoTE+='<tr onclick="cargarFrmE(' +i+ ');">' +
                        '<td>' + nombre + '</td>' +
                        '<td>' + correo + '</td>' +
                        '<td>' + domicilio + '</td>' +
                        '<td>' + telefonos + '</td>' +
                        '<td>' + usuario + '</td></tr>';
        contenidoTE += nombre;
    
    console.log(contenidoTE);
    document.getElementById("tbEmpleados").innerHTML = contenidoTE;
*/
        contenidoTE+="</tr>";      
    }
        document.getElementById("tbEmpleados").innerHTML = contenidoTE;
}

function cargarFrmE(i){
    alert(empleados[i].persona.nombre);
    document.getElementById("txtnombre").value=empleados[i].persona.nombre;
    document.getElementById("txtapePaterno").value=empleados[i].persona.apellidoPaterno;
    document.getElementById("txtapeMaterno").value=empleados[i].persona.apellidoMaterno;
    document.getElementById("txtgenero").value=empleados[i].persona.genero;
    document.getElementById("txtfechaNac").value=empleados[i].persona.fechaNacimiento;
    document.getElementById("txtcalle").value=empleados[i].persona.calle;
    document.getElementById("txtnumeroCasa").value=empleados[i].persona.numero;
    document.getElementById("txtcolonia").value=empleados[i].persona.colonia;
    document.getElementById("txtcp").value=empleados[i].persona.cp;
    document.getElementById("txtciudad").value=empleados[i].persona.ciudad;
    document.getElementById("txtestado").value=empleados[i].persona.estado;
    document.getElementById("txtnumCasa").value=empleados[i].persona.telCasa;
    document.getElementById("txtnumMovil").value=empleados[i].persona.telMovil;
    document.getElementById("txtemail").value=empleados[i].persona.email;
    document.getElementById("txtusuario").value=empleados[i].usuario.nombre;
    document.getElementById("txtcontrasenia").value=empleados[i].usuario.contrasennia;
    document.getElementById("txtrol").value=empleados[i].usuario.rol;
    
//    document.getElementById("txtnombre").value=empleados[i].persona.nombre;
//    document.getElementById("txtnombre").value=empleados[i].persona.nombre;
//    document.getElementById("txtnombre").value=empleados[i].persona.nombre;
//    document.getElementById("txtnombre").value=empleados[i].persona.nombre;
//    document.getElementById("txtnombre").value=empleados[i].persona.nombre;
    
}
function Limpiar(i){
    document.getElementById("txtnombre").value="";
    document.getElementById("txtapePaterno").value="";
    document.getElementById("txtapeMaterno").value="";
    document.getElementById("txtgenero").value="";
    document.getElementById("txtfechaNac").value="";
    document.getElementById("txtcalle").value="";
    document.getElementById("txtnumeroCasa").value="";
    document.getElementById("txtcolonia").value="";
    document.getElementById("txtcp").value="";
    document.getElementById("txtciudad").value="";
    document.getElementById("txtestado").value="";
    document.getElementById("txtnumCasa").value="";
    document.getElementById("txtnumMovil").value="";
    document.getElementById("txtemail").value="";
    document.getElementById("txtusuario").value="";
    document.getElementById("txtcontrasenia").value="";
    document.getElementById("txtrol").value="";
}


function actualizar (){
    let nom = (document.getElementById("txtnombre").value);
    let app = (document.getElementById("txtapePaterno").value);
    let apm = (document.getElementById("txtapeMaterno").value);
    let g = (document.getElementById("txtgenero").value);
    let fechaNac = document.getElementById("txtfechaNac").value;
    fechaNac = formatDate(fechaNac);
    let calle = document.getElementById("txtcalle").value;
    let num = document.getElementById("txtnumeroCasa").value;
    let col = document.getElementById("txtcolonia").value;
    let cp = document.getElementById("txtcp").value;
    let ciudad = document.getElementById("txtciudad").value;
    let estado = document.getElementById("txtestado").value;
    let telCal = document.getElementById("txtnumCasa").value;
    let telMovil = document.getElementById("txtnumMovil").value;
    let email = document.getElementById("txtemail").value;
    let us = document.getElementById("txtusuario").value;
    let contrasennia = document.getElementById("txtcontrasenia").value;
    let rol = document.getElementById("txtrol").value;

    let persona ={nombre:nom,apellidoPaterno:app,apellidoMaterno:apm,
        genero:g,fechaNacimiento:fechaNac,calle:calle,numero:num,
        colonia:col,cp:cp,ciudad:ciudad,estado:estado,telCasa:telCal,
        telMovil:telMovil,email:email};

    let usuario = {nombreUsuario:us, contrasennia:contrasennia, rol:rol};
//
//    let empleado = JSON.stringify({Persona:persona,Usuario:usuario});//Aquí puse persona a Persona y Usuario a usuario, por si es el nombre de las clases de model
//    //toma un json lo que hace esdevolver en una cadena todos los datos o atributos
//    let parametros = new URLSearchParams({datos:empleado});
//
//    fetch('api/empleado/upDateDatos',
//            {
//                method:'POST',
//                body:parametros,
//                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
//            }).then(response=>response.json())
//            .then(data=>{
//                let msj="empleado actualizado con ID:"+data.idEmpleado;
//                alert(msj);
//            });
    let empleado = JSON.stringify({persona:persona,usuario:usuario});
    let parametros = new URLSearchParams({datos:empleado});
    
    alert(JSON.stringify({datos:empleado}));
    
    fetch('api/empleado/insert',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                let msj ="Empleado insertado con el ID: " + data.idEmpleado;
                alert(msj);
            });
}