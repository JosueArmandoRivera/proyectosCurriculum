
package org.utl.dsm.rest;

/**
 *
 * @author Lenovo
 */

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import or.utl.dsm.optica.BD.ControllerEmpleado;
import org.utl.dsm.model.Empleado;
import org.utl.optica.controller.ConexionMySQL;
/*
import org.utl.dsm.opik.controller.ControllerEmpleado;
import org.utl.dsm.optik.model.Empleado;
*/

@Path("empleado")
public class EmpleadoRest extends Application{
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert (@FormParam("datos")@DefaultValue("")String datos){
       Gson gson = new Gson();
       Empleado e = new Empleado();
       
       e=gson.fromJson(datos, Empleado.class);
       String out = "";
       ControllerEmpleado objCE = new  ControllerEmpleado();
       /* ControllerEmpleado objCE =new ControllerEmpleado();*/
        try {
            objCE.insert(e);
            out= gson.toJson(e);
        } catch (Exception ex) {
           out = "{result:"+ex.toString()+"}"; 
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getAll(@FormParam("estatus")@DefaultValue("1")String estatus)
    {
        String out="";
        //Aqui se resive el parametro
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            List<Empleado> empleados = objCE.getAll(estatus);
           Gson gs=new Gson();
            out = gs.toJson(empleados);
           
        } catch (Exception ex) {
            System.out.println(ex.toString());
           out = "{\"error\":\""+ex.toString()+"\"}";
        }
     return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
