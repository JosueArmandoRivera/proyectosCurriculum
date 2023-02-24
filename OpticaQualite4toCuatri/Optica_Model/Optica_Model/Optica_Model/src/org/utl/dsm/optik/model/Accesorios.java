/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Accesorios {
   int idAccesorios;
   Producto idproducto;
   

    public int getIdAccesorios() {
        return idAccesorios;
    }

    public void setIdAccesorios(int idAccesorios) {
        this.idAccesorios = idAccesorios;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

  

    public Accesorios(Producto idproducto ) {
        this.idproducto = idproducto;
        
    }

    public Accesorios(int idAccesorios, Producto idproducto) {
        this.idAccesorios = idAccesorios;
        this.idproducto = idproducto;
       
    }

    @Override
    public String toString() {
        return "Accesorios{" + "idAccesorios=" + idAccesorios + ", idproducto=" + idproducto +  '}';
    }

}
