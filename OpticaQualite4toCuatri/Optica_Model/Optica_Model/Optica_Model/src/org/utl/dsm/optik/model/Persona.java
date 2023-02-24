/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Persona {
    int idPersona;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String genero;
    String fechaNacimiento;
    String calle;
    String numero;
    String colonia;
    String cp; 
    String ciudad;
    String estado;
    String telCasa;
    String telMovil;
    String email; 

    public Persona(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento, String calle, String numero, String colonia, String cp, String ciudad, String estado, String telCasa, String telMovil, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telCasa = telCasa;
        this.telMovil = telMovil;
        this.email = email;
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento, String calle, String numero, String colonia, String cp, String ciudad, String estado, String telCasa, String telMovil, String email) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telCasa = telCasa;
        this.telMovil = telMovil;
        this.email = email;
    }

    public Persona() {
       
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCp() {
        return cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", cp=" + cp + ", ciudad=" + ciudad + ", estado=" + estado + ", telCasa=" + telCasa + ", telMovil=" + telMovil + ", email=" + email + '}';
    }
    
}
