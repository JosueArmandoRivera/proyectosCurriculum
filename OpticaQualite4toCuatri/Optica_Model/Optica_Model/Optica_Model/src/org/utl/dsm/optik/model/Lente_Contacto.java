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
public class Lente_Contacto {
    int idLenteContacto;
    Producto producto;
    int keratometria;
    String fotografia;

    public Lente_Contacto() {
    }

    public Lente_Contacto(Producto producto, int keratometria, String fotografia) {
        this.producto = producto;
        this.keratometria = keratometria;
        this.fotografia = fotografia;
    }

    public Lente_Contacto(int idLenteContacto, Producto producto, int keratometria, String fotografia) {
        this.idLenteContacto = idLenteContacto;
        this.producto = producto;
        this.keratometria = keratometria;
        this.fotografia = fotografia;
    }

    public int getIdLenteContacto() {
        return idLenteContacto;
    }

    public void setIdLenteContacto(int idLenteContacto) {
        this.idLenteContacto = idLenteContacto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getKeratometria() {
        return keratometria;
    }

    public void setKeratometria(int keratometria) {
        this.keratometria = keratometria;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    @Override
    public String toString() {
        return "Lente_Contacto{" + "idLenteContacto=" + idLenteContacto + ", producto=" + producto.toString() + ", keratometria=" + keratometria + ", fotografia=" + fotografia + '}';
    }
    
    
    
}
