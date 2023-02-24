let moduloCliente;
let moduloEmpleados;
let moduloTratamiento;
let moduloAccesorios;
let moduloGraduacion;
let moduloLenteContacto;
let moduloSoluciones;
let moduloArmazones;
let moduloCompras;
let moduloVentas;

function cargarModuloVenta(){
    fetch("modules/moduloVentas/view_Ventas.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloVentas/controller_Ventas.js").then(
                                function (controller) {
                                    moduloVentas = controller;
                                }
                        );
                    }
            );
}
function cargarModuloLogin(){
    
    fetch("index.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../js/controllerLogin.js").then(
                                function (controller) {
                                    moduloSoluciones = controller;
                                }
                        );
                    }
            );
}

function cargarModuloSoluciones() {
    fetch("modules/modulosSoluciones/view_Soluciones.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/modulosSoluciones/controller_Soluciones.js").then(
                                function (controller) {
                                    moduloSoluciones = controller;
                                }
                        );
                    }
            );
}

function cargarModuloCompras() {
    fetch("modules/moduloCompras/view_Compras.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloCompras/controller_Compras.js").then(
                                function (controller) {
                                    moduloCompras = controller;
                                }
                        );
                    }
            );
}
function cargarModuloEmpleados() {
    fetch("modules/moduloEmpleados/view_Empleados.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloEmpleados/controller_Empleado.js").then(
                                function (controller) {
                                    moduloEmpleados = controller;
                                }
                        );
                    }
            );
}
function cargarModuloClientes() {
    fetch("modules/moduloClientes/view_Clientes.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloClientes/controller_Clientes.js").then(
                                function (controller) {
                                    moduloCliente = controller;
                                }
                        );
                    }
            );
}

function cargarModuloTratamientos() {
    fetch("modules/moduloTratamientos/view_Tratamientos.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloTratamientos/controller_Tratamientos.js").then(
                                function (controller) {
                                    moduloTratamiento = controller;
                                }
                        );
                    }
            );
}
function cargarModuloAccesorios() {
    fetch("modules/moduloAccesorios/view_Accesorios.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloAccesorios/controller_Accesorios.js").then(
                                function (controller) {
                                    moduloAccesorios = controller;
                                }
                        );
                    }
            );
}
function cargarModuloGraduaciones() {
    fetch("modules/moduloGraduaciones/view_Graduaciones.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloGraduaciones/controller_Graduaciones.js").then(
                                function (controller) {
                                    moduloGraduacion = controller;
                                }
                        );
                    }
            );
}
function cargarModuloArmazones() {
    fetch("modules/moduloArmazones/view_Armazones.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloArmazones/controller_Armazones.js").then(
                                function (controller) {
                                    moduloArmazones = controller;
                                }
                        );
                    }
            );
}
function cargarModuloLenteContacto() {
    fetch("modules/moduloLenteContacto/view_LenteContacto.html")
            .then(
                    function (response) {
                        return response.text();
                    }
            )
            .then(
                    function (html) {
                        document.getElementById("contenedorPrincipal").innerHTML = html;
                        import ("../modules/moduloLenteContacto/controller_LenteContacto.js").then(
                                function (controller) {
                                    moduloLenteContacto = controller;
                                }
                        );
                    }
            );
}
