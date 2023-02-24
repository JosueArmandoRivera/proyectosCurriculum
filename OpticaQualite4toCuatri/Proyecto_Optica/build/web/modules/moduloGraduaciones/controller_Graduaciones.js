let indexGraduacionesSeleccionado;
let graduaciones = [];

export function addGraduacion(){
    let numero_unico_graduaciones, 
        Cilindro_izq,
        Cilindro_der,
        esfera_izq,
        esfera_der,
        eje_izq,
        eje_der,
        dip_izq,
        dip_der;

    numero_unico_graduaciones = document.getElementById("txtNumUnico").value;
    Cilindro_izq = document.getElementById("CilIzq").value;
    Cilindro_der = document.getElementById("CilDer").value;
    esfera_izq = document.getElementById("EsfeIzq").value;
    esfera_der = document.getElementById("EsfeDer").value;
    eje_izq = document.getElementById("EjeIzq").value;
    eje_der = document.getElementById("EjeDer").value;
    dip_izq = document.getElementById("DipIzq").value;
    dip_der = document.getElementById("DipDer").value;
   
    
    let graduacion = {};
    graduacion.numero_unico_graduaciones =  "RF01";
    graduacion.cilndro_izq = Cilindro_izq;
    graduacion.Cilindro_der = Cilindro_der;
    graduacion.esfera_izq = esfera_izq;
    graduacion.esfera_der = esfera_der;
    graduacion.eje_izq = eje_izq;
    graduacion.eje_der = eje_der;
    graduacion.dip_izq = dip_izq;
    graduacion.dip_der = dip_der;
    graduacion.estatus = "Activo";
    graduaciones.push(graduacion);
    clean();
    loadTabla();
    Swal.fire('Graduación Guardado!', '', 'success');
}

export function loadTabla(){
    let cuerpo = "";
    graduaciones.forEach(function (graduacion){
        let registro =  
                '<tr onclick="moduloGraduacion.selectGraduacion('+ graduaciones.indexOf(graduacion) +');">'+
                '<td>' + graduacion.Cilindro_izq + '</td>' +
                '<td>' + graduacion.Cilindro_der + '</td>' +
                '<td>' + graduacion.esfera_izq +'</td>' +
                '<td>' + graduacion.esfera_der + '</td>'+
                '<td>' + graduacion.eje_izq + '</td>' +
                '<td>' + graduacion.eje_der + '</td>' +
                '<td>' + graduacion.dip_izq +'</td>' +
                '<td>' + graduacion.dip_der + '</td>' +
                '<td>' + graduacion.estatus + '</td></tr>' ; 
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblGraduaciones").innerHTML = cuerpo;
    
}

export function selectGraduacion(index){
    document.getElementById("txtNumUnico").value = graduaciones[index].numero_unico_graduaciones;
    document.getElementById("CilIzq").value = graduaciones[index].Cilindro_izq ;
    document.getElementById("CilDer").value = graduaciones[index].Cilindro_der;
    document.getElementById("EsfeIzq").value = graduaciones[index].esfera_izq;
    document.getElementById("EsfeDer").value = graduaciones[index].esfera_der ;
    document.getElementById("EjeIzq").value = graduaciones[index].eje_izq;
    document.getElementById("EjeDer").value = graduaciones[index].eje_der;
    document.getElementById("DipIzq").value = graduaciones[index].dip_izq;
    document.getElementById("DipDer").value = graduaciones[index].dip_der;
    document.getElementById("btnUpdate").classList.remove("disabled");
    document.getElementById("btnDelete").classList.remove("disabled");
    document.getElementById("btnAdd").classList.add("disabled");
    indexGraduacionesSeleccionado = index;
}

export function clean(){
    document.getElementById("txtNumUnico").value = "";
    document.getElementById("CilIzq").value = "" ;
    document.getElementById("CilDer").value = "";
    document.getElementById("EsfeIzq").value = "";
    document.getElementById("EsfeDer").value = "";
    document.getElementById("EjeIzq").value = "" ;
    document.getElementById("EjeDer").value = "";
    document.getElementById("DipIzq").value = "";
    document.getElementById("DipDer").value = "";
    //document.getElementById("txtNombre").focus();
    document.getElementById("btnAdd").classList.remove("disabled");
    indexGraduacionesSeleccionado = 0;
}

export function updateGraduacion(){
    let numero_unico_graduaciones, 
        Cilindro_izq,
        Cilindro_der,
        esfera_izq,
        esfera_der,
        eje_izq,
        eje_der,
        dip_izq,
        dip_der;

    numero_unico_graduaciones = document.getElementById("txtNumUnico").value;
    Cilindro_izq = document.getElementById("CilIzq").value;
    Cilindro_der = document.getElementById("CilDer").value;
    esfera_izq = document.getElementById("EsfeIzq").value;
    esfera_der = document.getElementById("EsfeDer").value;
    eje_izq = document.getElementById("EjeIzq").value;
    eje_der = document.getElementById("EjeDer").value;
    dip_izq = document.getElementById("DipIzq").value;
    dip_der = document.getElementById("DipDer").value;
    
    let graduacion = {};
    graduacion.Cilindro_izq = Cilindro_izq;
    graduacion.Cilindro_der = Cilindro_der;
    graduacion.esfera_izq = esfera_izq;
    graduacion.esfera_der = esfera_der;
    graduacion.eje_izq = eje_izq;
    graduacion.eje_der = eje_der;
    graduacion.dip_izq = dip_izq;
    graduacion.dip_der = dip_der;
    graduacion.estatus = "Activo";
    graduaciones[indexGraduacionesSeleccionado] = graduacion;
    clean();
    loadTabla();
    Swal.fire('Modificado correctamente!', '', 'success');
}

export function deleteTratamiento(){
    Swal.fire({
        title:'Quieres eliminar el cliente?',
        showCancelButton: true,
        showConfirmButton: true,
        confirmButtonText: 'Eliminar',
        CancelButtonText: 'Cancelar'
    }).then((result)=> {
        if (result.isConfirmed){
            graduaciones[indexGraduacionesSeleccionado].estatus = "Inactivo";
            clean();
            loadTabla();
            Swal.fire('Realizado!', '', 'success');
        }
    });
}
export function searchCliente() {
    let filtro = document.getElementById("txtBusqueda Cliente").value;
    let resultados = graduaciones.filter(element => element.nombre === filtro);
    let cuerpo = "";
    resultados.forEach(function (graduacion) {
        let registro =
                '<tr onclick="moduloCliente.selectCliente (' + graduaciones.indexOf(graduaciones) + ');">' +
                '<td>' + graduaciones.nombre + '</td>' +
                '<td>' + graduaciones.apellido_paterno + '' + graduaciones.apellido_materno + '</td>' +
                '<td>' + graduaciones.genero + '</td>' +
                '<td>' + graduaciones.telefono_movil + '</td>' +
                '<td>' + graduaciones.estatus + '</td></tr>';
        cuerpo += registro;
    });
    console.log(cuerpo);
    document.getElementById("tblGraduaciones").innerHTML = cuerpo;


    
    }
fetch("modules/moduloGraduaciones/data_Graduaciones.json")
        .then(response =>{
            return response.json();
        })
        .then(function(jsondata){
                graduaciones = jsondata;
                console.log(graduaciones);
                loadTabla();
            }            
        );
