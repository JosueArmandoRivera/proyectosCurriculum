/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Tratamiento {
    int idTratamiento;
    String nombre;
    double precioVenta;
    double precioCompra;
    int estatus;

    public Tratamiento(int idTratamiento, String nombre, double precioVenta, double precioCompra, int estatus) {
        this.idTratamiento = idTratamiento;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.estatus = estatus;
    }

    public Tratamiento(String nombre, double precioVenta, double precioCompra, int estatus) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.estatus = estatus;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + idTratamiento + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra + ", estatus=" + estatus + '}';
    }
    
}
