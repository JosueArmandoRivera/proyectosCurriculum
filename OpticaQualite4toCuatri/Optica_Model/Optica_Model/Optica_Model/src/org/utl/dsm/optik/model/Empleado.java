/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;


public class Empleado {
 private int idEmpleado;
 private String numeroUnico;
 private int estatus;
// private Empleado empleado;
 private Persona persona;
 private Usuario usuario;

    public Empleado() {
    }
    
    public Empleado(int idEmpleado, String numeroUnico, int estatus, Empleado empleado, Persona persona, Usuario usuario) {
        this.idEmpleado = idEmpleado;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
//        this.empleado = empleado;
        this.persona = persona;
        this.usuario=usuario;
    }

    public Empleado(String numeroUnico, int estatus, Empleado empleado, Persona persona, Usuario usuario) {
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
//        this.empleado = empleado;
        this.persona = persona;
        this.usuario=usuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public int getEstatus() {
        return estatus;
    }

//    public Empleado getEmpleado() {
//        return empleado;
//    }

    public Persona getPersona() {
        return persona;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

//    public void setEmpleado(Empleado empleado) {
//        this.empleado = empleado;
//    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + ", persona=" + persona.toString() + ", usuario=" + usuario.toString() + '}';
    }
    

   
 
    
 
}
