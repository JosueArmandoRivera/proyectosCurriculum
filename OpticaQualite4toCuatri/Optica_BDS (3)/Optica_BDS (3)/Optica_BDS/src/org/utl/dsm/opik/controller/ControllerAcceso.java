
package org.utl.dsm.opik.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;



public class ControllerAcceso {
   //El throws va en l REST, 
/*public boolean acceder(Usuario usuario) throws Exception{
    String query = "SELECT * FROM v_Empleados WHERE usuario=? and contrasenia=?";
   
    boolean e = false;
    
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection connection = objConMySQL.open();
    PreparedStatement pstmt = connection.prepareCall(query);
   
    pstmt.setString(1,usuario.getNombre());
    pstmt.setString(2,usuario.getContrasenia());

    ResultSet rs = pstmt.executeQuery();
    
    if(rs.next())
        e = true;
    
    rs.close();
    pstmt.execute();
    pstmt.close();
    connection.close();
    objConMySQL.close();
   
    pstmt.close();
    connection.close();
    //return r; 

    return e;
}*/
public Empleado acceder(String usuario, String contrasenia) throws Exception{
    String query = "SELECT * FROM v_Empleado WHERE usuario=? AND contrasenia=?";      
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection connection = objConMySQL.open();
    PreparedStatement pstmt = connection.prepareCall(query);
    ResultSet rs = null;
   
    pstmt.setString(1,usuario);
    pstmt.setString(2,contrasenia);
    rs = pstmt.executeQuery();
    Empleado e = null;
    if(rs.next()){
     e=fill(rs);
    }
    rs.close();
    pstmt.close();
//    connection.close();
    objConMySQL.close();    
    return e;
}
private Empleado fill(ResultSet rs) throws Exception{
        Empleado e = new Empleado ();
        //Persona p = new Persona ();
       /* p.setIdPersona(rs.getInt("idPersona"));
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
        e.setUsuario(new Usuario());*/
        e.getUsuario().setContrasenia(rs.getString("contrasenia"));
        //e.getUsuario().setIdUsuario(rs.getInt("idUsuario"));
        e.getUsuario().setNombre(rs.getString("nombre"));
        /*e.getUsuario().setRol(rs.getString("rol"));
        e.getUsuario().setLastToken(rs.getString("lastToken"));
        e.getUsuario().setDateLastToken(rs.getString("dateLastToken"));
        e.setPersona(p);*/
        return e;        
    }

public void guardarToken(int idUsuario, String token) throws Exception{
    //String query = "UPDATE usuario SET lastToken=?, dateLastToken= NOW() WHERE idUsuario=?";
    String query = "{call generearTokens(?,?)}"; 
    
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection connection = objConMySQL.open();

    //PreparedStatement preparedStatement = connection.prepareCall(query);
    CallableStatement clmt = connection.prepareCall(query);
    clmt.setInt(1,idUsuario);
    clmt.setString(2,token);
    
    clmt.executeUpdate();
    clmt.close();
    connection.close();
    objConMySQL.close();
}

/*
ASÍ SERÍA SI QUEREMOS PEDIR TODO EL OBJETO
public void guardarToken(Empleado empleado) throws Exception{
    String query = "UPDATE usuario SET lastToken=?, dateLastToken= NOW() WHERE idUsuario=?";
    
   
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection connection = objConMySQL.open();

    PreparedStatement preparedStatement = connection.prepareCall(query);
    
    preparedStatement.setString(1,empleado.getUsuario().getLastToken());
    preparedStatement.setInt(2,empleado.getUsuario().getIdUsuario());

    
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
    objConMySQL.close();
}*/

public boolean eliminarToken(Empleado e)throws SQLException{
    boolean r=false;
    String query = "Update usuario SET lastToken ='' where idUsuario = ?";
    
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection connection = objConMySQL.open();
    
    PreparedStatement preparedStatement = connection.prepareCall(query);
    preparedStatement.setInt(1,e.getUsuario().getIdUsuario());

    preparedStatement.execute();
    r=true;
    preparedStatement.close();
    connection.close();
    objConMySQL.close();
    return r;
}
public boolean validarToken(String t)throws SQLException{
    boolean r = false;
    String query ="SELECT * FROM v_empleado WHERE lastToken='"+t+"'";
        
    ConexionMySQL objConMySQL = new ConexionMySQL();
    Connection connection = objConMySQL.open();
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    if(rs.next())
        r = true;
    stmt.close();
    connection.close();
    objConMySQL.close();
    return r;
}


}

