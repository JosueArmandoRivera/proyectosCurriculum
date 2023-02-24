/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.dsm.opik.controller;

import org.utl.dsm.optik.db.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.optik.db.ConexionMySQL;
import org.utl.dsm.optik.model.Empleado;
import org.utl.dsm.optik.model.Persona;
import org.utl.dsm.optik.model.Usuario;

/**
 *
 * @author Lenovo
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//probarConexion();        
        probarInsert();
    }

    public static void probarConexion() {
        try {
            ConexionMySQL objConexion = new ConexionMySQL();
            Connection conexion = objConexion.open();
            System.out.println(conexion.toString());
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void probarInsert() {
        //1 Crear un objeto de persona y cargarlo
        Persona p = new Persona("Ivan", "Mancilla",
                "Ulloa", "H", "09/04/2003", "Hermanegildo Bustos", "921", "Jardines de la pradera",
                "37570", "Leon", "Guanajuato", "4777060950", "4773234748", "21000403@utleon.edu.mx");
///2. Crear un objeto de usuario y cargarlo
        Usuario u = new Usuario();
        u.setNombre("Alvizo1");
        u.setContrasenia("Admin");
        u.setRol("Empleado");
        //3. Empleado
        Empleado e = new Empleado();
        e.setPersona(p);
        e.setUsuario(u);
        System.out.println(e.toString());
//4  Invocar el metodo de iinsercion del empleado 
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.insert(e);
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(e.toString());

    }

    public static void probraGetAll() {
        try {
            ControllerEmpleado objCE = new ControllerEmpleado();
            List<Empleado> empleados = objCE.getAll("Activo");
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println(empleados.get(i).toString());
            }

        } catch (Exception ex) {
            System.out.println("ex.toString()");
        }

    }
}
