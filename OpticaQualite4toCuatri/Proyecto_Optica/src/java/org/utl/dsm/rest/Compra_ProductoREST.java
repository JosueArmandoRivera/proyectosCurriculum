/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.opik.controller.ControllerCompra_Producto;
import org.utl.dsm.opik.controller.ControllerSoluciones;
import org.utl.dsm.optik.model.Compra_Producto;
import org.utl.dsm.optik.model.Solucion;


@Path("Compra_Producto")
public class Compra_ProductoREST {
    @Path("getAll")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
       String out = "";
        try {
            ControllerCompra_Producto objCP = new ControllerCompra_Producto();
            List<Compra_Producto> Compra_Producto = objCP.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(Compra_Producto);
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "(\"error\":\""+ex.toString()+"\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
