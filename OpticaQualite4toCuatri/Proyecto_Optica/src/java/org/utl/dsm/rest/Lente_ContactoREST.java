
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.opik.controller.ControllerLenteContacto;
import org.utl.dsm.optik.model.Lente_Contacto;


@Path("lente_contacto")
public class Lente_ContactoREST extends Application {
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Lente_Contacto lc = new Lente_Contacto();

        lc = gson.fromJson(datos, Lente_Contacto.class);
        String out = "";
        ControllerLenteContacto objCLC = new ControllerLenteContacto();
        
        try {
            objCLC.insert(lc);
            out = gson.toJson(lc);
        } catch (Exception ex) {
            out = "{\"result\":\"" + ex.toString() +"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
       String out = "";
        try {
            ControllerLenteContacto objCE = new ControllerLenteContacto();
            List<Lente_Contacto> lenteContacto = objCE.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(lenteContacto);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Lente_Contacto s = new Lente_Contacto();

        s = gson.fromJson(datos, Lente_Contacto.class);
        String out = "";
        ControllerLenteContacto objCS = new ControllerLenteContacto();
        try {
            objCS.actualizar(s);
            out = gson.toJson(s);
        } catch (Exception ex) {
            out = "{\"result\":\"" + ex.toString() +"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
  
    @Path("getAllb")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAllb(@FormParam("estatus") @DefaultValue("0") String estatus){
       String out = "";
        try {
            ControllerLenteContacto objCS = new ControllerLenteContacto();
            List<Lente_Contacto> soluciones = objCS.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(soluciones);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
     //Delete Palomino
    @Path("delete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Lente_Contacto lc = new Lente_Contacto();
        
        lc = gson.fromJson(datos, Lente_Contacto.class);
        String out = "";
        ControllerLenteContacto objCA = new ControllerLenteContacto();
        try {
            objCA.delete(lc);
            out = gson.toJson(lc);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
            
            /*ex.printStackTrace();
            out = """
                  {"result": "error"}
                     """;*/
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("activar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activar(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Lente_Contacto lc = new Lente_Contacto();
        
        lc = gson.fromJson(datos, Lente_Contacto.class);
        String out = "";
        ControllerLenteContacto objCA = new ControllerLenteContacto();
        try {
            objCA.activar(lc);
            out = gson.toJson(lc);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
            
            /*ex.printStackTrace();
            out = """
                  {"result": "error"}
                     """;*/
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("busqueda") @DefaultValue("prue") String busqueda){
       String out = "";
        try {
            ControllerLenteContacto objCS = new ControllerLenteContacto();
            List<Lente_Contacto> soluciones = objCS.search(busqueda);
            Gson gs = new Gson();
            out = gs.toJson(soluciones);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    
    
/*
    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Lente_Contacto lc = new Lente_Contacto();

        lc = gson.fromJson(datos, Lente_Contacto.class);
        String out = "";
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.actualizar(lc);
            out = gson.toJson(lc);
        } catch (Exception ex) {
            out = "{result:" + ex.toString() +"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @Path("getAllb")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAllb(@FormParam("estatus") @DefaultValue("0") String estatus){
       String out = "";
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            List<Empleado> empleados = objCE.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "(\"error\":\""+ex.toString()+"\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
  */  
}

