/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Solucion {
    int idSolucion;
    Producto producto;

    public Solucion() {
    }

    public Solucion(Producto producto) {
        this.producto = producto;
    }

    public Solucion(int idSolucion, Producto producto) {
        this.idSolucion = idSolucion;
        this.producto = producto;
    }

    public int getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(int idSolucion) {
        this.idSolucion = idSolucion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Solucion{" + "idSolucion=" + idSolucion + ", producto=" + producto.toString() + '}';
    }
}
