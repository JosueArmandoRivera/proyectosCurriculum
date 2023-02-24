/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Presupuesto_lentes {
    int idPresupuestolentes;
    Presupuesto idPresupuesto;
    int alturaOblea;
    Tipo_Mica idTipoMica;
    Material idMaterial;
    Armazon idArmazon;
    

    public Presupuesto_lentes(int idPresupuestolentes, Presupuesto idPresupuesto, int alturaOblea, Tipo_Mica idTipoMica, Material idMaterial, Armazon idArmazon) {
        this.idPresupuestolentes = idPresupuestolentes;
        this.idPresupuesto = idPresupuesto;
        this.alturaOblea = alturaOblea;
        this.idTipoMica = idTipoMica;
        this.idMaterial = idMaterial;
        this.idArmazon = idArmazon;
        
    }

    public Presupuesto_lentes(Presupuesto idPresupuesto, int alturaOblea, Tipo_Mica idTipoMica, Material idMaterial ) {
        this.idPresupuesto = idPresupuesto;
        this.alturaOblea = alturaOblea;
        this.idTipoMica = idTipoMica;
        this.idMaterial = idMaterial;
        this.idArmazon = idArmazon;
        
    }

    public int getIdPresupuestolentes() {
        return idPresupuestolentes;
    }

    public void setIdPresupuestolentes(int idPresupuestolentes) {
        this.idPresupuestolentes = idPresupuestolentes;
    }

    public Presupuesto getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Presupuesto idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getAlturaOblea() {
        return alturaOblea;
    }

    public void setAlturaOblea(int alturaOblea) {
        this.alturaOblea = alturaOblea;
    }

    public Tipo_Mica getIdTipoMica() {
        return idTipoMica;
    }

    public void setIdTipoMica(Tipo_Mica idTipoMica) {
        this.idTipoMica = idTipoMica;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Armazon getIdArmazon() {
        return idArmazon;
    }

    public void setIdArmazon(Armazon idArmazon) {
        this.idArmazon = idArmazon;
    }

    

    @Override
    public String toString() {
        return "Presupuesto_lentes{" + "idPresupuestolentes=" + idPresupuestolentes +
                ", idPresupuesto=" + idPresupuesto + ", alturaOblea=" + alturaOblea + 
                ", idTipoMica=" + idTipoMica + ", idMaterial=" + idMaterial + ", idArmazon=" + idArmazon +
                 '}';
    }
    
    

}
