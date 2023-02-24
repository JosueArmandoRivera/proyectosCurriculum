/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;


public class Compra_Producto {
    Compra idCompra;
    Producto idProducto;
    double precioUnitario;
    int cantidad;

    public Compra_Producto() {
    }
    
    
    
    public Compra_Producto(Compra idCompra, Producto idProducto, double precioUnitario, int cantidad) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        
    }

    public Compra_Producto(Producto idProducto, double precioUnitario, int cantidad, Compra compra, Producto producto) {
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    @Override
    public String toString() {
        return "Compra_Producto{" + "idCompra=" + idCompra + ", idProducto=" + idProducto + ", precioUnitario=" + precioUnitario + 
                ", cantidad=" + cantidad +'}';
    }
    
}
