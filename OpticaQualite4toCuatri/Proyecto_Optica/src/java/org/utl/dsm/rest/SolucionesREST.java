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
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.opik.controller.ControllerAcceso;
import org.utl.dsm.opik.controller.ControllerSoluciones;
import org.utl.dsm.optik.model.Solucion;
/**
 *
 * @author Dell
 */
@Path("solucion")

public class SolucionesREST extends Application{
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("datos") @DefaultValue("") String datos,@FormParam("token") @DefaultValue("") String token) {
        Gson gson = new Gson();
        Solucion s = new Solucion();

        String out = "";
        ControllerSoluciones objCS = new ControllerSoluciones();
        ControllerAcceso ca =new ControllerAcceso();
        try {
            if(ca.validarToken(token)){
            s = gson.fromJson(datos, Solucion.class);
            objCS.insert(s);
            out = gson.toJson(s);    
            }
            else{
            out="""
                 {"error":"Credenciales incorrectas"}
               """;
            }            
        } catch (Exception ex) {
            out = "{\"result\":\"" + ex.toString() +"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos,@FormParam("token") @DefaultValue("") String token) {
        Gson gson = new Gson();
        Solucion s = new Solucion();

        s = gson.fromJson(datos, Solucion.class);
        String out = "";
        ControllerSoluciones objCS = new ControllerSoluciones();
        ControllerAcceso ca =new ControllerAcceso();

        try {
            
             if(ca.validarToken(token)){
            s = gson.fromJson(datos, Solucion.class);
            objCS.actualizar(s);
            out = gson.toJson(s);
            }
            else{
            out="""
                 {"error":"Credenciales incorrectas"}
               """;
            } 
        } catch (Exception ex) {
            out = "{\"result\":\"" + ex.toString() +"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus,@FormParam("token") @DefaultValue("") String token){
       String out = "";
               ControllerAcceso ca =new ControllerAcceso();

        try {            
             if(ca.validarToken(token)){           
//            s = gson.fromJson(datos, Solucion.class);
            ControllerSoluciones objCE = new ControllerSoluciones();
            List<Solucion> soluciones = objCE.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(soluciones);
            
            }
            else{
            out="""
                 {"error":"Credenciales incorrectas"}
               """;
            } 
            
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "(\"error\":\""+ex.toString()+"\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllb")
    @POST
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAllb(@FormParam("estatus") @DefaultValue("0") String estatus,@FormParam("token") @DefaultValue("") String token){
       String out = "";
       ControllerAcceso ca =new ControllerAcceso();

        try {
        if(ca.validarToken(token)){    
            ControllerSoluciones objCS = new ControllerSoluciones();
            List<Solucion> soluciones = objCS.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(soluciones);
        }else{
        out="""
            {"error":"Credenciales incorrectas"}
            """;
        }
        } catch (Exception ex) {
            System.out.println("ex.toString()");
            out = "{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
//    @Path("delete")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response delete(@FormParam("datos") @DefaultValue("") String datos,@FormParam("token")@DefaultValue("")String token){
//        Gson gson = new Gson();
//        Solucion s = new Solucion();
//        
//        s = gson.fromJson(datos, Solucion.class);
//        String out = "";
//        ControllerSoluciones objCA = new ControllerSoluciones();
//        ControllerAcceso ca = new ControllerAcceso();
//        try {
//            if(ca.validarToken(token)){
//            objCA.delete(s);
//            out = gson.toJson(s);}
//            else{
//                out="""
//                    {"error":"Credenciales no válidas"}
//                    """;
//            }
//        } catch (Exception ex) {
//            System.out.println("ex.toString()");
//            out = "{\"error\":\""+ex.toString()+"\"}";
//            
//            /*ex.printStackTrace();
//            out = """
//                  {"result": "error"}
//                     """;*/
//        }
//        return Response.status(Response.Status.OK).entity(out).build();
//    }
//    
//    @Path("activar")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response activar(@FormParam("datos") @DefaultValue("") String datos,@FormParam("token")@DefaultValue("")String token){
//        Gson gson = new Gson();
//        Solucion s = new Solucion();
//        
//        s = gson.fromJson(datos, Solucion.class);
//        String out = "";
//        ControllerSoluciones objCA = new ControllerSoluciones();
//        ControllerAcceso ca = new ControllerAcceso();
//        try {
//            if(ca.validarToken(token)){
//            objCA.activar(s);
//            out = gson.toJson(s);}
//            else{
//            out="""
//                {"error":"Credenciales no válidas"}
//                 """;
//            }
//        } catch (Exception ex) {
//            System.out.println("ex.toString()");
//            out = "{\"error\":\""+ex.toString()+"\"}";
//            
//            /*ex.printStackTrace();
//            out = """
//                  {"result": "error"}
//                     """;*/
//        }
//        return Response.status(Response.Status.OK).entity(out).build();
//    }
//    
//    /*Mandando Solo el iD
//    @Path("delete")
//    @POST
//    @Produces (MediaType.APPLICATION_JSON)
//    public Response delete(@FormParam("idSolucion") @DefaultValue("0") int idSolucion){
//       String out = "";
//        try {
//            ControllerSoluciones objCS = new ControllerSoluciones();
//            int soluciones = objCS.delete(idSolucion);
//            Gson gs = new Gson();
//            out = gs.toJson(soluciones);
//        } catch (Exception ex) {
//            System.out.println("ex.toString()");
//            out = "(\"error\":\""+ex.toString()+"\")";
//        }
//        return Response.status(Response.Status.OK).entity(out).build();
//    }*/
// 
////    
////@Path("activar")
////    @POST
////    @Produces (MediaType.APPLICATION_JSON)
////    public Response activar(@FormParam("datos") @DefaultValue("") int idSolucion){
////       String out = "";
////        try {
////            ControllerEmpleado objCE = new ControllerEmpleado();
////            int soluciones = objCE.activar(idSolucion);
////            Gson gs = new Gson();
////            out = gs.toJson(soluciones);
////        } catch (Exception ex) {
////            System.out.println("ex.toString()");
////            out = "(\"error\":\""+ex.toString()+"\")";
////        }
////        return Response.status(Response.Status.OK).entity(out).build();
////    }
//    
//    @Path("buscar")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response search(@QueryParam("busqueda") @DefaultValue("prue") String busqueda,@FormParam("token")@DefaultValue("")String token){
//       String out = "";
//       ControllerAcceso ca = new ControllerAcceso(); 
//       try {
//           if(ca.validarToken(token)){
//            ControllerSoluciones objCS = new ControllerSoluciones();
//            List<Solucion> soluciones = objCS.search(busqueda);
//            Gson gs = new Gson();
//            out = gs.toJson(soluciones);}
//           else{
//           out="""
//               {"error":"Credenciales no incorrectas"}
//               """;
//           }
//        } catch (Exception ex) {
//            System.out.println("ex.toString()");
//            out = "{\"error\":\""+ex.toString()+"\"}";
//        }
//        return Response.status(Response.Status.OK).entity(out).build();
//    }
    

}
