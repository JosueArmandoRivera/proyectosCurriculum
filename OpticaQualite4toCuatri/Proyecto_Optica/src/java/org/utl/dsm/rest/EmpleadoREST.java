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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.opik.controller.ControllerEmpleado;
import org.utl.dsm.optik.model.Empleado;

@Path("empleado")
public class EmpleadoREST extends Application {
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Empleado e = new Empleado();

        e = gson.fromJson(datos, Empleado.class);
        String out = "";
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.insert(e);
            out = gson.toJson(e);
        } catch (Exception ex) {
            out = "{result:" + ex.toString() +"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Empleado e = new Empleado();
        e = gson.fromJson(datos, Empleado.class);
        String out = "";
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.actualizar(e);
            out = gson.toJson(e);
        } catch (Exception ex) {
            out = "{result:" + ex.toString() +"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
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
    }/*
    @Path("getAll")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
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
    
    @Path("delete")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response delete(@FormParam("idEmpleado") @DefaultValue("0") int idEmpleado){
       String out = "";
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            int empleados = objCE.delete(idEmpleado);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "(\"error\":\""+ex.toString()+"\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
 
@Path("activar")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response activar(@FormParam("idEmpleado") @DefaultValue("0") int idEmpleado){
       String out = "";
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            int empleados = objCE.activar(idEmpleado);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "(\"error\":\""+ex.toString()+"\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("busqueda") @DefaultValue("Gabriel") String busqueda){
       String out = "";
        try {
            ControllerEmpleado objCS = new ControllerEmpleado();
            List<Empleado> empleado = objCS.search(busqueda);
            Gson gs = new Gson();
            out = gs.toJson(empleado);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
