/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.eclipse.jdt.internal.compiler.codegen.ConstantPool.Out;
//import static java.lang.System.out;
import org.utl.dsm.opik.controller.ControllerAcceso;
import org.utl.dsm.opik.controller.ControllerEmpleado;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Usuario;

/**
 * @author Dell
 */
@Path("log")
public class AccesoREST extends Application {

    /*@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@POST
//Esta linea nos indica que recibo en el front y que voy a hacer con el
public Response loginMio(@FormParam("usuario")@DefaultValue("") String usuario){

    //Paso 1 Hacer un match entre el front y el back y el Gson lo que hace es hacer el match de un json con un String gracias a los geter y seters 
    Gson gson = new Gson();
    //Paso 2 Hacer la conversión El .Class es la definición del objeto. De esa cadenota llamada usuario creamos el objeto user
    Usuario user = new Usuario();
    user = gson.fromJson(usuario, Usuario.class);
        
    ControllerAcceso objCA = new ControllerAcceso();
    String out="";
    
    try {
       // objCA.acceder(user);
    } catch (Exception ex) {
        Logger.getLogger(AccesoREST.class.getName()).log(Level.SEVERE, null, ex);
        out = "{result:" + ex.toString() +"}";
    }
    
 return Response.status(Response.Status.OK).entity(Out).build();

}*/
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("in")
    public Response login(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(datos,Usuario.class);
        String out = null;
        ControllerAcceso objCL = new ControllerAcceso();
        Empleado e = null;

        try{
            //e = objCL.acceder(usuario.getNombre(), usuario.getContrasenia());
            objCL.acceder(usuario.getNombre(), usuario.getContrasenia());
            if (e != null) {
                e.getUsuario().setLastToken();
                out = new Gson().toJson(e);
                objCL.guardarToken(e.getUsuario().getIdUsuario(),e.getUsuario().getLastToken());
            }else {
                out = """
                  {"error":"Usuario y/o contrasena incorrectas! Está entrando al else del try de in en AccesoREST"}
                  """;
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            out = """
                  {"exception":"%s"}
                  """;
            out = String.format(out, ex.toString());
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    /*
    @Path("in")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response login(@FormParam("datos")@DefaultValue("")String datos) throws Exception {
        
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(datos, Usuario.class);
        String out = null;        
        ControllerAcceso ca = new ControllerAcceso();
        Empleado empleado = null;
        try {
            empleado = ca.acceder(usuario.getNombre(), usuario.getContrasenia());
            //empleado = ca.acceder(usuario);
            if (empleado != null) {
                empleado.getUsuario().setLastToken();
                //Así lo tenía out = gson.toJson(empleado);
                out = new Gson().toJson(empleado);
                ca.guardarToken(empleado.getUsuario().getIdUsuario(), empleado.getUsuario().getLastToken());
            } else {
                out = """
                   {"error":"Usuario y/o contrasena incorrectas!"}
                      """;
            }}catch (Exception ex) {
            ex.printStackTrace();
            out = """
                  {"exception" : "%s"}
                  """;
            out = String.format(out, ex.toString());
        } /* Esto lo tenía en lugar del catch antes de este
            catch (JsonParseException jpe) {
            out = """
                    {"error":"Formato de datos no valido."}
                  """;
            jpe.printStackTrace();
        } catch (Exception e) {
            out = """
                    {"error":"Acceso no concedido."}
                  """;
            e.printStackTrace();
        }//
        return Response.status(Response.Status.OK).entity(out).build();
    }*/
    @Path("out")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response logOut(@FormParam("empleado") @DefaultValue("") String e) throws Exception {
        String out = null;
        Empleado empleado = null;
        ControllerAcceso ca = null;
        Gson gson = new Gson();
        try {
            empleado = gson.fromJson(e, Empleado.class);
            ca = new ControllerAcceso();

            if (ca.eliminarToken(empleado)) {
                out = """
                {"ok":"Eliminación de Token correcta"}
              """;
            } else {
                out = """
                {"error":"Eliminación de Token no realizada"}
              """;
            }
        } catch (JsonParseException jpe) {
            out = """
                {"error":"Formato de datos no válido."}
              """;
            jpe.printStackTrace();
        } catch (Exception ex) {
            out = """
                {"error":"Acceso no concedido."}
              """;
            ex.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
}
