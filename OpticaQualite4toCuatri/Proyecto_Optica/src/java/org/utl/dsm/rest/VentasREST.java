/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.opik.controller.ControllerAcceso;
import org.utl.dsm.opik.controller.ControllerLenteContacto;
import org.utl.dsm.opik.controller.ControllerSoluciones;
import org.utl.dsm.opik.controller.ControllerVentas;
import org.utl.dsm.optik.model.DetalleVentaProducto;
import org.utl.dsm.optik.model.Lente_Contacto;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Solucion;

/**
 *
 * @author Dell
 */
@Path("ventas")
public class VentasREST {    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
       String out ="";
        try {
            ControllerVentas objCE = new ControllerVentas();
            List<Producto> producto = objCE.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(producto);
        }catch(Exception ex){
            System.out.println(ex.toString());            
            out = "{\"error\":\""+ex.toString()+"\"}";   
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("busqueda") @DefaultValue("Lente") String busqueda){
       String out = "";
        try {
            ControllerVentas objCS = new ControllerVentas();
            List<Producto> producto = objCS.search(busqueda);
            Gson gs = new Gson();
            out = gs.toJson(producto);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
//            out = "{\"error\":\""+ex.toString()+"\"}";
            out = "{\"result\":\"" + ex.toString() +"\"}";

        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("generarVenta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("datos") @DefaultValue("") String datos){
    boolean r=false;
    Gson gs = new Gson();
    DetalleVentaProducto dvp = new DetalleVentaProducto();
    ControllerVentas cv = new ControllerVentas();
    dvp=gs.fromJson(datos, DetalleVentaProducto.class);
    r=cv.generarVenta(dvp);
    String out = "";
    if(r){
        out ="""
             {"result":"Correcto"}
             """;
    }else{
        out="""
            {"error":"error en el servidor"}
            """;
    }    
        return Response.status(Response.Status.OK).entity(out).build();
    
    }
    
}
