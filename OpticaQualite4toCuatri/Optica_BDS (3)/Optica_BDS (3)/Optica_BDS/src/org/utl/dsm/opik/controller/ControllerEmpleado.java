
package org.utl.dsm.opik.controller;

import java.sql.Connection;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;


/**
 *
 * @author Lenovo
 */
public class ControllerEmpleado {
    
    public int insert(Empleado e) throws Exception {
        //generar la consulta que vamos a enviar a la base de de datos
        String query = "{call insertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,"
                + "?,?,?,?,?)}";
        //Preparar las variables para recibir los valores de retorno
        int idPerosnaG = 0;
        int idUsuarioG = 0;
        int idEmpleado=0;
        String numUnicoG = "";
        String lastTokenG = "";
        
        //3.Conectarse a la BD
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();
        //4. generar el objetro que va a invocar el store produre
        CallableStatement cstmt = conn.prepareCall(query);
        //%. Asignar cada uno de los valores que se 
        cstmt.setString(1, e.getPersona().getNombre());
        cstmt.setString(2, e.getPersona().getApellidoPaterno());
        cstmt.setString(3, e.getPersona().getApellidoMaterno());
        cstmt.setString(4, e.getPersona().getGenero());
        cstmt.setString(5, e.getPersona().getFechaNacimiento());
        cstmt.setString(6, e.getPersona().getCalle());
        cstmt.setString(7, e.getPersona().getNumero());
        cstmt.setString(8, e.getPersona().getColonia());
        cstmt.setString(9, e.getPersona().getCp());
        cstmt.setString(10, e.getPersona().getCiudad());
        cstmt.setString(11, e.getPersona().getEstado());
        cstmt.setString(12, e.getPersona().getTelCasa());
        cstmt.setString(13, e.getPersona().getTelMovil());
        cstmt.setString(14, e.getPersona().getEmail());

        cstmt.setString(15, e.getUsuario().getNombre());
        cstmt.setString(16, e.getUsuario().getContrasenia());
        cstmt.setString(17, e.getUsuario().getRol());

        cstmt.registerOutParameter(18, Types.INTEGER);
        cstmt.registerOutParameter(19, Types.INTEGER);
        cstmt.registerOutParameter(20, Types.INTEGER);
        cstmt.registerOutParameter(21, Types.VARCHAR);
        cstmt.registerOutParameter(22, Types.VARCHAR);
        
        //6. ejecutar la instruccion 
        
        cstmt.executeUpdate();
        
        // 7. Recuperar los parametros de retorno 
        idPerosnaG = cstmt.getInt(18);
        idUsuarioG = cstmt.getInt(19);
        idEmpleado=cstmt.getInt(20);
        numUnicoG = cstmt.getString(21);
        lastTokenG =cstmt.getString(22);
        
        //8.Colocar los valores recuperados dentro del objeto
        
        e.getPersona().setIdPersona(idPerosnaG);
        e.getUsuario().setIdUsuario(idUsuarioG);
        e.setIdEmpleado(idEmpleado);
        e.setNumeroUnico(numUnicoG);
        e.getUsuario().setLastToken(lastTokenG);
        
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConMySQL.close();
        //10. Devolver el id que se genero
        return idEmpleado;

    }
    
    public void actualizar(Empleado e) throws Exception {

        String query = "{call actualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?)}";
        
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, e.getPersona().getNombre());
        cstmt.setString(2, e.getPersona().getApellidoPaterno());
        cstmt.setString(3, e.getPersona().getApellidoMaterno());
        cstmt.setString(4, e.getPersona().getGenero());
        cstmt.setString(5, e.getPersona().getFechaNacimiento());
        cstmt.setString(6, e.getPersona().getCalle());
        cstmt.setString(7, e.getPersona().getNumero());
        cstmt.setString(8, e.getPersona().getColonia());
        cstmt.setString(9, e.getPersona().getCp());
        cstmt.setString(10, e.getPersona().getCiudad());
        cstmt.setString(11, e.getPersona().getEstado());
        cstmt.setString(12, e.getPersona().getTelCasa());
        cstmt.setString(13, e.getPersona().getTelMovil());
        cstmt.setString(14, e.getPersona().getEmail());

        cstmt.setString(15, e.getUsuario().getNombre());
        cstmt.setString(16, e.getUsuario().getContrasenia());
        cstmt.setString(17, e.getUsuario().getRol());

        cstmt.setInt(18, e.getPersona().getIdPersona());
        cstmt.setInt(19, e.getUsuario().getIdUsuario());
        cstmt.setInt(20, e.getIdEmpleado());
        
        cstmt.executeUpdate();

    }
    
    public List<Empleado> getAllb (String filtro) throws Exception{
        String sql = "Select * from v_empleado where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Empleado> empleados = new ArrayList<>();
        
        while(rs.next())
            empleados.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleados;        
    }    
   public List<Empleado> getAll (String filtro) throws Exception{
        String sql = "Select * from v_empleado where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Empleado> empleados = new ArrayList<>();
        
        while(rs.next())
            empleados.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleados;        
    }
    /*
    public List<Empleado> getAll (String filtro) throws Exception{
        String sql = "Select * from v_empleado where estatus ="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List <Empleado> empleados = new ArrayList<>();
        
        while(rs.next())
        empleados.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleados;
    }*/
    
    public int delete (int idEmpleado) throws Exception{
        String sql = "CALL eliminarEmpleado("+idEmpleado+")";
// String sql = "UPDATE empleado SET estatus = 0 WHERE idEmpleado ="+idEmpleado+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.execute();
        pstmt.close();
        connMySQL.close();
        return idEmpleado;
    }

public int activar (int idEmpleado) throws Exception{
        String sql = "CALL activarEmpleado("+idEmpleado+")";
       // String sql = "UPDATE empleado SET estatus = 1 WHERE idEmpleado ="+idEmpleado+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.execute();
        pstmt.close();
        connMySQL.close();
        return idEmpleado;
    }    
    private Empleado fill(ResultSet rs) throws Exception{
        Empleado e = new Empleado ();
        Persona p = new Persona ();
        p.setIdPersona(rs.getInt("idPersona"));
        p.setNombre(rs.getString("nombre"));
        p.setApellidoPaterno(rs.getString("apellidoPaterno"));
        p.setApellidoMaterno(rs.getString("apellidoMaterno"));
        p.setGenero(rs.getString("genero"));
        p.setFechaNacimiento(rs.getString("fechaNacimiento"));
        p.setCalle(rs.getString("calle"));
        p.setNumero(rs.getString("numero"));
        p.setColonia(rs.getString("colonia"));
        p.setCp(rs.getString("cp"));
        p.setCiudad(rs.getString("ciudad"));
        p.setEstado(rs.getString("estado"));
        p.setTelCasa(rs.getString("telcasa"));
        p.setTelMovil(rs.getString("telmovil"));
        p.setEmail(rs.getString("email"));
        e.setNumeroUnico(rs.getString("numeroUnico"));
        e.setIdEmpleado(rs.getInt("idEmpleado"));
        e.setEstatus(rs.getInt("estatus"));
        e.setUsuario(new Usuario());
        e.getUsuario().setContrasenia(rs.getString("contrasenia"));
        e.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
        e.getUsuario().setNombre(rs.getString("nombre"));
        e.getUsuario().setRol(rs.getString("rol"));
        e.getUsuario().setLastToken(rs.getString("lastToken"));
  //      e.getUsuario().setDateLastToken(rs.getString("dateLastToken"));
        e.setPersona(p);
        return e;        
    }
    public List<Empleado> search(String busqueda) throws Exception{
        String sql = "SELECT * FROM v_empleado where nombre LIKE '%"+busqueda+"%' OR apellidoPaterno LIKE '%"+busqueda+"%' OR apellidoMaterno LIKE '%"+busqueda+"%' OR ciudad LIKE '%"+busqueda+"%' OR cp LIKE '%"+busqueda+"%' OR estado LIKE '%"+busqueda+"%';";
       
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();  
              
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Empleado> empleado = new ArrayList<>();
        while(rs.next()){
            empleado.add(fill(rs));
        }
        rs.close();
        stmt.close();
        connMySQL.close();
        return empleado;
    }    
}
              