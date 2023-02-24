/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

import java.io.File;

/**
 *
 * @author Lenovo
 */
public class Armazon {
 int idAramazon ;
 Producto idProducto;
 Producto producto;
 String modelo;
 String color;
 String dimeciones;
 String descripcion;
 File fotografia; 

    public Armazon(int idAramazon, Producto idProducto, Producto producto, String modelo, String color, String dimeciones, String descripcion, File fotografia) {
        this.idAramazon = idAramazon;
        this.idProducto = idProducto;
        this.producto = producto;
        this.modelo = modelo;
        this.color = color;
        this.dimeciones = dimeciones;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
    }

    public Armazon(Producto idProducto, Producto producto, String modelo, String color, String dimeciones, String descripcion, File fotografia) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.modelo = modelo;
        this.color = color;
        this.dimeciones = dimeciones;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
    }

    public int getIdAramazon() {
        return idAramazon;
    }

    public void setIdAramazon(int idAramazon) {
        this.idAramazon = idAramazon;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDimeciones() {
        return dimeciones;
    }

    public void setDimeciones(String dimeciones) {
        this.dimeciones = dimeciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public File getFotografia() {
        return fotografia;
    }

    public void setFotografia(File fotografia) {
        this.fotografia = fotografia;
    }

    @Override
    public String toString() {
        return "Armazon{" + "idAramazon=" + idAramazon + ", idProducto=" + idProducto + ", producto=" + producto.toString() + ", modelo=" + modelo + ", color=" + color + ", dimeciones=" + dimeciones + ", descripcion=" + descripcion + ", fotografia=" + fotografia + '}';
    }
 
}
