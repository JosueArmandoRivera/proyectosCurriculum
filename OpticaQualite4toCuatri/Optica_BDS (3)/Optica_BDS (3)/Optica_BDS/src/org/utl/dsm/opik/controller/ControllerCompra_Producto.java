/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.opik.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Compra;
import org.utl.dsm.optik.model.Compra_Producto;

/**
 *
 * @author Dell
 */
public class ControllerCompra_Producto {
    
   public List<Compra_Producto> getAll (String filtro) throws Exception{
        String sql = "Select * from v_Compra_Producto where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Compra_Producto> empleados = new ArrayList<>();
        
        while(rs.next())
            empleados.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleados;        
    }
   
    private Compra_Producto fill(ResultSet rs) throws Exception{
        Compra_Producto e = new Compra_Producto ();
        Compra p = new Compra ();
        p.setIdCompra(rs.getInt("idCompra"));
       // p.setIdEmpleado(rs.getInt("idEmpleado"));
       
        //e.setIdProducto(rs.getInt("IdProducto"));
        e.setPrecioUnitario(rs.getDouble("precioUnitario"));
        e.setCantidad(rs.getInt("cantidad"));
        e.setIdCompra(new Compra());
        e.getIdCompra().setIdCompra(rs.getInt("idCompra"));
  //      e.getUsuario().setDateLastToken(rs.getString("dateLastToken"));
        e.setIdCompra(p);
        return e;        
    }
    
}
