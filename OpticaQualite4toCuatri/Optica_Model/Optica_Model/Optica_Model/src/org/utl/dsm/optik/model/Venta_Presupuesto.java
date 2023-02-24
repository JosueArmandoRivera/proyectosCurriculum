/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Venta_Presupuesto {
    Venta idVenta;
    Presupuesto idpresupuesto;
   int cantidad;
   double precioUnitario;
   double descuento;
   

    public Venta_Presupuesto(Venta idVenta, Presupuesto idpresupuesto, int cantidad, double precioUnitario, double descuento) {
        this.idVenta = idVenta;
        this.idpresupuesto = idpresupuesto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        
    }

    public Venta_Presupuesto(Presupuesto idpresupuesto, int cantidad, double precioUnitario, double descuento) {
        this.idpresupuesto = idpresupuesto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public Presupuesto getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(Presupuesto idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    

    @Override
    public String toString() {
        return "Venta_Presupuesto{" + "idVenta=" + idVenta + ", idpresupuesto=" + idpresupuesto + ", cantidad=" + cantidad
                + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento +
                ", venta=" + '}';
    }
   
}
