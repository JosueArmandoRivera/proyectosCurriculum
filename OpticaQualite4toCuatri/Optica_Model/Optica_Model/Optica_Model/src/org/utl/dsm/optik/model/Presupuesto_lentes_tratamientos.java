/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Presupuesto_lentes_tratamientos {
    int idPresupuestoLentes;
    int idTrataimento;
   

    public Presupuesto_lentes_tratamientos(int idPresupuestoLentes, int idTrataimento) {
        this.idPresupuestoLentes = idPresupuestoLentes;
        this.idTrataimento = idTrataimento;
        
    }

    public Presupuesto_lentes_tratamientos(int idTrataimento, Tratamiento tratamiento) {
        this.idTrataimento = idTrataimento;
        
    }

    public int getIdPresupuestoLentes() {
        return idPresupuestoLentes;
    }

    public void setIdPresupuestoLentes(int idPresupuestoLentes) {
        this.idPresupuestoLentes = idPresupuestoLentes;
    }

    public int getIdTrataimento() {
        return idTrataimento;
    }

    public void setIdTrataimento(int idTrataimento) {
        this.idTrataimento = idTrataimento;
    }

    

    @Override
    public String toString() {
        return "Presupuesto_lentes_tratamientos{" + "idPresupuestoLentes=" + idPresupuestoLentes +'}';
    }
    
}
