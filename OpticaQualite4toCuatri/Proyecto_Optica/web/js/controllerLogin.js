/*let acceso;

export function addLenteContacto() {
    /*let codigoBarras = (document.getElementById("txtCodigoBarras").value);
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
   // clean();
  //  loadTabla();
//    Swal.fire('Lente Contacto Guardado!', '', 'success');
}

function login(){
    var user, pass;
    user = document.getElementById("user").value;
    pass = document.getElementById("pass").value;
       
   if(user == "Armando" && pass=="123"){
        window.location="Home.html";
    }else{
        alert("Usuario o contraseña incorrecta")
    }

}
async function encriptar(texto){
    const encoder = new TextEncoder();
    const data = encoder.code(texto);
    const hash = await crypto.subtle.digest('SHA-256', data);
    const hashArray = Array.from(new UintArray(hash));
    const hashHex = hashArray.map((b)=> b.toString(16).padStart(2,'0')).join('');
    return hashHex;
}
function validarAcceso(){
    let username = document.getElementById("user").value;
    let password = document.getElementById("pass").value;
    
    encriptar(password).then((textoEncriptado)=>{
        alert(textoEncriptado.toString());
        let usuario = {"usuario":JSON.stringify({"nombre":username, "contrasenia":password})};
    })
}

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