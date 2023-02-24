/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Material {
    int idMaterial;
    String nombre;
    double precioVenta;
    double precioCompra;

    public Material(int idMaterial, String nombre, double precioVenta, double precioCompra) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }

    public Material(String nombre, double precioVenta, double precioCompra) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
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

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", precioCompra=" + precioCompra + '}';
    }
    
}
