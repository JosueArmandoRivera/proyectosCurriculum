/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.opik.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.DetalleVentaProducto;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Producto;
import org.utl.dsm.optik.model.Venta_Producto;

/**
 *
 * @author Dell
 */
public class ControllerVentas {

    public List<Producto> getAll(String filtro) throws Exception {
        String sql = "Select * from v_Producto where estatus =" + filtro + ";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Producto> producto = new ArrayList<>();

        while (rs.next()) {
            producto.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return producto;
    }

    private Producto fill(ResultSet rs) throws Exception {
        Producto p = new Producto();
        p.setIdProducto(rs.getInt("idProducto"));
        p.setEstatus(rs.getInt("estatus"));
        p.setNombre(rs.getString("nombre"));
        p.setCodigoBarras(rs.getString("codigoBarras"));
        p.setMarca(rs.getString("marca"));
        p.setPrecioVenta(rs.getDouble("precioVenta"));
        p.setExistencias(rs.getInt("existencias"));
        return p;
    }

    public List<Producto> search(String busqueda) throws Exception {
        //  String sql = "SELECT * from v_solucion where codigoBarras LIKE'%"+busqueda+"%' OR nombre LIKE '%"+busqueda+"%' OR marca LIKE '%"+busqueda+"%' OR precioCompra LIKE '%"+busqueda+"%' OR precioVenta LIKE '%"+busqueda+"%' OR existencias LIKE '%"+busqueda+"%';";
        String sql = "SELECT * from v_Producto where codigoBarras LIKE'%" + busqueda + "%' OR estatus LIKE '%" + busqueda + "%' OR nombre LIKE '%" + busqueda + "%' OR marca LIKE '%" + busqueda + "%' OR precioVenta LIKE '%" + busqueda + "%' OR existencias LIKE '%" + busqueda + "%';";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Producto> producto = new ArrayList<>();
        while (rs.next()) {
            producto.add(fill(rs));
        }
        rs.close();
        stmt.close();
        connMySQL.close();
        return producto;
    }
    public boolean generarVenta(DetalleVentaProducto dvp) {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
       Statement stm = null;
        ResultSet rs = null;
        boolean r = false;
        try {
            conn.setAutoCommit(false);
            String query1 = "INSERT INTO venta(clave, idEmpleado) VALUES (" + dvp.getVenta().getClave() + "," + dvp.getVenta().getEmpleado().getIdEmpleado() + ");";
            stm = conn.createStatement();
            stm.execute(query1);

            String query2 = "SELECT LAST_INSERT_ID()";
            rs = stm.executeQuery(query2);

            if (rs.next()) {
                dvp.getVenta().setIdVenta(rs.getInt(1));
            }

            for (int i = 0; i < dvp.getListaVentaProducto().size(); i++) {
                String query3 = "INSERT INTO venta_producto VALUES(" + dvp.getVenta().getIdVenta() + "," + dvp.getListaVentaProducto().get(i).getProducto().getIdProducto() + "," + dvp.getListaVentaProducto().get(i).getCantidad() + "," + dvp.getListaVentaProducto().get(i).getPrecioUnitario() + "," + dvp.getListaVentaProducto().get(i).getDescuento() + ");";
                stm.execute(query3);
            }
            
            conn.commit();
            conn.setAutoCommit(true);
            rs.close();
            stm.close();
            conn.close();
            r = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVentas.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
                conn.setAutoCommit(true);
                rs.close();
                stm.close();
                conn.close();
                r = false;
            } catch  (SQLException ex1){
                Logger.getLogger(ControllerVentas.class.getName()).log(Level.SEVERE, null, ex1);
                r = false;
            }
        }
        return r;
    }
}
