/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function login(){
    var user, pass;
    user = document.getElementById("user").value;
    pass = document.getElementById("pass").value;
       
   if(user == "Armando" && pass=="123"){
        window.location="Home.html";
    }else{
        alert("Usuario o contraseña incorrecta");
    }
}

/*async function encriptar(texto){
    const encoder = new TextEncoder();
    const data = encoder.encode(texto);
    const hash = await crypto.subtle.digest('SHA-256', data);
    const hashArray = Array.from(new Uint8Array(hash));
    const hashHex = hashArray.map((b)=> b.toString(16).padStart(2,'0')).join('');
    return hashHex;
}*/
async function encriptar(texto) {
    const encoder = new TextEncoder();
    const data = encoder.encode(texto);
    const hash = await crypto.subtle.digest('SHA-256', data);
    const hashArray = Array.from(new Uint8Array(hash));
    const hashHex = hashArray.map((b) => b.toString(16).padStart(2, '0')).join('');
    return hashHex;
}

function normalizar(texto){
    texto=texto.toUpperCase();
    for(var i=0;i<texto.lenght;i++){
        texto
    }
}

function iniciarSesion() {
    let usuario = document.getElementById("user").value;
    let contrasenia = document.getElementById("pass").value;

    encriptar(contrasenia).then((textoEncriptado) => {

        let datos = JSON.stringify({
            nombreUsuario: usuario, contrasenia: contrasenia
        });

        let parametros = new URLSearchParams({datos: datos});
        fetch('api/log/in',
                {
                    method: 'POST',
                    body: parametros,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
                })
                .then(response => {
                    return response.json();
                })
                .then(function(data){
                    if (data.exception != null) {
                        Swal.fire('Error', 'Error interno del servidor!', 'error');
                    }
                    if (data.error != null) {
                        //Swal.fire('error', data.error, 'warning');                       
                        alert(data.error);
                        return;
                    } else {
                        Swal.fire('¡Acceso Correcto!', "Bienvenido " + data.usuario.nombreUsuario, 'success');
                        localStorage.setItem('currentUser', JSON.stringify(data));
                        window.location = "Home.html";
                    }
                });
    });
}

/* La descompuo Lolis
 
function validarAcceso(){     
    let username = document.getElementById("user").value;
    let password = document.getElementById("pass").value;
    const textoEncriptado = encriptar(password);
    
        //alert(textoEncriptado.toString());
        let datos =JSON.stringify({"nombre":username,"contrasenia":textoEncriptado});
        //  let usuario ={"usuario": JSON.stringify({"nombre":username,"contrasenia":password});
        //let params = new URLSearchParams(usuario);
         let params = new URLSearchParams({datos:datos});        
         //alert(username);
         //alert(password);
         alert(textoEncriptado);
         //Va en llaves por que es formato JSON
        fetch('api/log/in',
               {
                method: "POST",
                body: params,               
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
        })               
                .then(response =>{
                        return response.json();
                    })
                    .then(function (data){
                        if(data.exception !== null){
                           // Swal.fire('Error','Error interno del servidor',"warning"); 
                           alert("Error interno del servidor");
                        }
                        if(data.error !== null){
                            //Swal.fire('Error',data.error,"warning");
                            //return;
                            alert("Error interno del servidor");
                        }
                        else{
                            alert("Bienvenido"+ data.persona.nombre);
                            localStorage.setItem("currentUser", JSON.stringify(data));
                            //alert(localStorage.getItem("currentUser"));
                            window.location.replace("Home.html");                  
                        }
                    });   
}*/
function cerrarSesion(){
    let e  = localStorage.getItem('currentUser');
    let empleado = {"empleado":e};
    let parametros = new URLSearchParams(empleado);
    fetch('api/log/out',
               {
                method: "POST",
                body: parametros,
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
                })               
                .then(response =>{
                        return response.json();
                    })
                    .then(function (data){
                        if(data.exception != null){
                            Swal.fire('Error','Error interno del servidor',"warning");   
                        }
                        if(data.error != null){
                            Swal.fire('',data.error,"warning");
                            return;
                        }
                        else{
                            alert("Bye ");
                            localStorage.removeItem("currentUser");
                            //alert(localStorage.getItem("currentUser"));
                           // window.location.replace("index.html");                  
                        }
                    });    
}
function normalizar(texto){
    return texto;
}
/*
function validarAcceso(){
    let username = document.getElementById("user").value;
    let password = document.getElementById("pass").value;
    
    encriptar(password).then((textoEncriptado)=>{
        alert(textoEncriptado.toString());
        let usuario = {"usuario":JSON.stringify({"nombre":username,"contrasenia":contrasenia})};
        let params = new URLSearchParams(usuario);
        
        fetch('api/log/in',
               {method: "POST",
                headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'}
                body: params
                   })
                    .then(response = >{
                        return response.json();
                    })
                            .then(function (data){
                                if(data.exception != null)
                                {
                            Swal.fire('', 'Error interno del servidor. Intente nuevamente');
                                return;
                                }
                                if(data.error != null){
                                    Swal.fire('',data.error, 'Warning');
                                    return;
                                }
                                if(data.usuario.rol==='Administrador')
                            })
    }
}*/