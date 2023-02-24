



function insertar(){
let nom =(document.getElementById("txNombre").value);
let app =(document.getElementById("txtApellidoP").value);
let apm =(document.getElementById("txtApellidoM").value);
let g =(document.getElementById("txtGenero").value);
let fechaNac =(document.getElementById("txtFecha").value);
let calle =(document.getElementById("txtCalle").value);
let num =(document.getElementById("txtNumero").value);
let colonia =(document.getElementById("txtColonia").value);
let cp =(document.getElementById("txtCP").value);
let ciudad =(document.getElementById("txtEstado").value);
let estado =(document.getElementById("txtTelC").value);
let telCal =(document.getElementById("txtTelM").value);
let telMo =(document.getElementById("txtCiudad").value);
let email =(document.getElementById("txtEmail").value);

let us = document.getElementById("nombreUsuario").value;
let contrasenia = document.getElementById("contrasenia").value;
let rol = document.getElementById("rol").value;


let persona = {nombre:nom, apellidoPaterno:app, apellidoMaterno:apm, genero:g,fechaNacimiento:fechaNac, calle:calle, numero:num, colonia:col,
               cp:cp, ciudad:ciudad,estado:estado, telCal:telCal,telMo:telMo, email:email};
let usuario = {nombre:us, contrasenia:contrasenia, rol:rol};


let empleado = JSON.stringify({usuario:usuario, persona:persona});
//Toma el json y te devuelve una cadena
let parametros = new URLSearchParams({datos:JSON.stringify(empleado)});




fetch('api/empleado/insert',
        {
            method= 'POST',
            body= (parametros),
            headers:{'Content-type':'application/x-www-' }  
        }).then(response=>response.json())
        then(data=>{
            let msj="empleado insertado como ID:" + data.idEmepleado;
            alert(msj);
        });



}