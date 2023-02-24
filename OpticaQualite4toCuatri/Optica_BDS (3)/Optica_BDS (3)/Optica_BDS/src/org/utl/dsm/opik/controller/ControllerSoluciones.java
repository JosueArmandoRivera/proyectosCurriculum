/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.opik.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Solucion;
import org.utl.dsm.optik.model.Usuario;

/**
 *
 * @author Dell
 */
public class ControllerSoluciones {
    public int insert(Solucion s) throws Exception{
        String query = "{call insertar_solucion(?,?,?,?,?,?,?,?)}";        
        int idProductoG =0;
        int idSolucion=0;
        
        //3.Conectarse a la BD
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();
        //4. generar el objetro que va a invocar el store produre
        CallableStatement cstmt = conn.prepareCall(query);
        //%. Asignar cada uno de los valores que se 
        cstmt.setString(1, s.getProducto().getCodigoBarras());
        cstmt.setString(2, s.getProducto().getNombre());
        cstmt.setString(3, s.getProducto().getMarca());
        cstmt.setDouble(4, s.getProducto().getPrecioCompra());
        cstmt.setDouble(5, s.getProducto().getPrecioVenta());
        cstmt.setInt(6, s.getProducto().getExistencias());
        
        cstmt.registerOutParameter(7, Types.INTEGER);
        cstmt.registerOutParameter(8, Types.INTEGER);
        
         //6. ejecutar la instruccion 
        
        cstmt.executeUpdate();
        
        // 7. Recuperar los parametros de retorno 
        idProductoG = cstmt.getInt(7);
        idSolucion = cstmt.getInt(8);
       //8.Colocar los valores recuperados dentro del objeto
        
        s.getProducto().setIdProducto(idProductoG);        
        s.setIdSolucion(idSolucion);
                
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConMySQL.close();
        //10. Devolver el id que se genero
        return idSolucion;
    }
    
    public List<Solucion> getAll (String filtro) throws Exception{
        String sql = "Select * from v_solucion where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Solucion> solucion = new ArrayList<>();
        
        while(rs.next())
        solucion.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return solucion;
    }
       public List<Solucion> getAllb (String filtro) throws Exception{
        String sql = "Select * from v_solucion where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Solucion> solucion = new ArrayList<>();
        
        while(rs.next())
        solucion.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return solucion;
    }
    
    
    private Solucion fill(ResultSet rs) throws Exception{
       Solucion s = new Solucion ();
        Producto p = new Producto ();
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombre(rs.getString("nombre"));
        p.setCodigoBarras(rs.getString("codigoBarras"));
        p.setMarca(rs.getString("marca"));
        p.setPrecioCompra(rs.getDouble("precioCompra"));
        p.setPrecioVenta(rs.getDouble("precioVenta"));        
        p.setExistencias(rs.getInt("existencias"));
        p.setEstatus(rs.getInt("estatus"));        
        s.setIdSolucion(rs.getInt("idSolucion"));      
        s.setProducto(p);
        return s;
    }
    public void actualizar(Solucion s) throws Exception {

        String query = "{call actualizarSolucion(?,?,?,?,?,?,?,?)}";
        
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, s.getProducto().getCodigoBarras());
        cstmt.setString(2, s.getProducto().getNombre());
        cstmt.setString(3, s.getProducto().getMarca());
        cstmt.setDouble(4, s.getProducto().getPrecioCompra());
        cstmt.setDouble(5, s.getProducto().getPrecioVenta());
        cstmt.setInt(6, s.getProducto().getExistencias());        
        cstmt.setInt(7, s.getProducto().getIdProducto());
        cstmt.setInt(8, s.getIdSolucion());        
        cstmt.executeUpdate();
    }
    
    /* public int delete (int idSolucion) throws Exception{
        
        String query = "{CALL eliminarSolucion(?)}";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();        
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        connMySQL.close();
        return idSolucion;
    }*/
    
     
    public void delete (Solucion s) throws Exception{        
        String query = "{CALL eliminarSolucion(?)}";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();        
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setDouble(1, s.getProducto().getIdProducto());
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        connMySQL.close();
    }
    public void activar (Solucion s) throws Exception{        
        String query = "{CALL activarSolucion(?)}";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();        
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setDouble(1, s.getProducto().getIdProducto());
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        connMySQL.close();
    }    
    public List<Solucion> search(String busqueda) throws Exception{
        String sql = "SELECT * from v_solucion where codigoBarras LIKE'%"+busqueda+"%' OR nombre LIKE '%"+busqueda+"%' OR marca LIKE '%"+busqueda+"%' OR precioCompra LIKE '%"+busqueda+"%' OR precioVenta LIKE '%"+busqueda+"%' OR existencias LIKE '%"+busqueda+"%';";
       
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();  
              
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Solucion>soluciones = new ArrayList<>();
        while(rs.next()){
            soluciones.add(fill(rs));
        }
        rs.close();
        stmt.close();
        connMySQL.close();
        return soluciones;
    }
    //DELETE USANDO TODO EL OBJETO
//     public void delete (Solucion s) throws Exception{
////        String sql = "CALL eliminarEmpleado("+idEmpleado+")";
//        String query = "{CALL eliminarSolucion(?)}";
//        ConexionMySQL connMySQL = new ConexionMySQL();
//        Connection conn = connMySQL.open();
//        
//        CallableStatement cstmt = conn.prepareCall(query);
//        cstmt.executeUpdate();
//        cstmt.close();
//        conn.close();
//        connMySQL.close();   
//    }

    
}
