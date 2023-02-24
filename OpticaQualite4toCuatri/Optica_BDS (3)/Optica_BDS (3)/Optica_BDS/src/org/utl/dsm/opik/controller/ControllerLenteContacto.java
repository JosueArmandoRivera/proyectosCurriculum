
package org.utl.dsm.opik.controller;


import java.sql.Connection;
import org.utl.dsm.optik.db.ConexionMySQL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.model.Lente_Contacto;
import org.utl.dsm.optik.model.Producto;

public class ControllerLenteContacto {
    public int insert(Lente_Contacto LC) throws Exception {
        //generar la consulta que vamos a enviar a la base de de datos
        String query = "{call insertarLente_Contacto(?,?,?,?,?,?,?,?,?,?)}";
        //Preparar las variables para recibir los valores de retorno
        int idProductoG=0;
        int idLenteContacto=0;
        
        //String codigoBarras = "";
        
        //3.Conectarse a la BD
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();
        //4. generar el objetro que va a invocar el store produre
        CallableStatement cstmt = conn.prepareCall(query);
        //%. Asignar cada uno de los valores que se 
        cstmt.setString(1, LC.getProducto().getCodigoBarras());
        cstmt.setString(2, LC.getProducto().getNombre());
        cstmt.setString(3, LC.getProducto().getMarca());
        cstmt.setDouble(4, LC.getProducto().getPrecioCompra());
        cstmt.setDouble(5, LC.getProducto().getPrecioVenta());
        cstmt.setInt(6, LC.getProducto().getExistencias());
        
        cstmt.setInt(7, LC.getKeratometria());
        cstmt.setString(8, LC.getFotografia());
        
        cstmt.registerOutParameter(9, Types.INTEGER);
        cstmt.registerOutParameter(10, Types.INTEGER);
        //6. ejecutar la instruccion 
        
        cstmt.executeUpdate();
        
        // 7. Recuperar los parametros de retorno 
        idProductoG = cstmt.getInt(9);
        idLenteContacto = cstmt.getInt(10);
        
        
        //8.Colocar los valores recuperados dentro del objeto
        
        LC.getProducto().setIdProducto(idProductoG);
        LC.setIdLenteContacto(idLenteContacto);
       
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConMySQL.close();
        //10. Devolver el id que se genero
        return idLenteContacto;
  
}
       public List<Lente_Contacto> getAllb (String filtro) throws Exception{
        String sql = "Select * from v_lente_contacto where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Lente_Contacto> lenteContacto = new ArrayList<>();
        
        while(rs.next())
            lenteContacto.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return lenteContacto;
        
    }
    
    public List<Lente_Contacto> getAll (String filtro) throws Exception{
        String sql = "Select * from v_lente_contacto where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Lente_Contacto> lenteContacto = new ArrayList<>();
        
        while(rs.next())
        lenteContacto.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return lenteContacto;
        
    }
    
        private Lente_Contacto fill(ResultSet rs) throws Exception{
        Lente_Contacto LC = new Lente_Contacto ();        
        Producto p = new Producto ();
        
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombre(rs.getString("nombre"));
        p.setCodigoBarras(rs.getString("codigoBarras"));
        p.setMarca(rs.getString("marca"));
        p.setPrecioCompra(rs.getDouble("precioCompra"));
        p.setPrecioVenta(rs.getDouble("precioVenta"));
        p.setExistencias(rs.getInt("existencias"));        
        p.setEstatus(rs.getInt("estatus"));
        
        LC.setIdLenteContacto(rs.getInt("idLenteContacto"));        
        LC.setKeratometria(rs.getInt("keratometria"));        
        LC.setFotografia(rs.getString("fotografia"));        
        LC.setProducto(new Producto());
        
        LC.setProducto(p);
         
        return LC;
    }
        public void delete (Lente_Contacto lc) throws Exception{        
        String query = "{CALL eliminarLenteContacto(?)}";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();        
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setDouble(1, lc.getProducto().getIdProducto());
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        connMySQL.close();
    }    
    public void activar (Lente_Contacto lc) throws Exception{        
        String query = "{CALL activarLenteContacto(?)}";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();        
        CallableStatement cstmt = conn.prepareCall(query);
        cstmt.setDouble(1, lc.getProducto().getIdProducto());
        cstmt.executeUpdate();
        cstmt.close();
        conn.close();
        connMySQL.close();
    }    
    public List<Lente_Contacto> search(String busqueda) throws Exception{
        String sql = "SELECT * from v_lente_contacto where codigoBarras LIKE'%"+busqueda+"%' OR nombre LIKE '%"+busqueda+"%' OR marca LIKE '%"+busqueda+"%' OR precioCompra LIKE '%"+busqueda+"%' OR precioVenta LIKE '%"+busqueda+"%' OR existencias LIKE '%"+busqueda+"%' OR keratometria LIKE '%"+busqueda+"%'  ;";
       
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();  
              
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Lente_Contacto>lenteContacto = new ArrayList<>();
        while(rs.next()){
            lenteContacto.add(fill(rs));
        }
        rs.close();
        stmt.close();
        connMySQL.close();
        return lenteContacto;
    }


    public void actualizar(Lente_Contacto lc) throws Exception {

        String query = "{call actualizarLenteContacto(?,?,?,?,?,?,?,?,?,?)}";
        
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, lc.getProducto().getCodigoBarras());
        cstmt.setString(2, lc.getProducto().getNombre());
        cstmt.setString(3, lc.getProducto().getMarca());
        cstmt.setDouble(4, lc.getProducto().getPrecioCompra());
        cstmt.setDouble(5, lc.getProducto().getPrecioVenta());
        cstmt.setInt(6, lc.getProducto().getExistencias());        
        
        cstmt.setInt(7, lc.getKeratometria());
        cstmt.setString(8, lc.getFotografia());
        cstmt.setInt(9, lc.getProducto().getIdProducto());

        cstmt.setInt(10, lc.getIdLenteContacto());        
        cstmt.executeUpdate();
    }
   
}
