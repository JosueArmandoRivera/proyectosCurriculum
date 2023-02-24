/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

import java.util.List;

/**
 *
 * @author Dell
 */
public class DetalleVentaProducto {
    Venta venta;
    List<Venta_Producto>listaVentaProducto;

    public DetalleVentaProducto() {
    }

    public DetalleVentaProducto(Venta venta, List<Venta_Producto> listaVentaProducto) {
        this.venta = venta;
        this.listaVentaProducto = listaVentaProducto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta_Producto> getListaVentaProducto() {
        return listaVentaProducto;
    }

    public void setListaVentaProducto(List<Venta_Producto> listaVentaProducto) {
        this.listaVentaProducto = listaVentaProducto;
    }
    
    
}
