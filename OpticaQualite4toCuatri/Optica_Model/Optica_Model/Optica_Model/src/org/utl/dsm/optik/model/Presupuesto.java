/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Presupuesto {
    int idPresupuesto;
    int idExamenVista;
    String clave;   

    public Presupuesto(int idPresupuesto, int idExamenVista, String clave) {
        this.idPresupuesto = idPresupuesto;
        this.idExamenVista = idExamenVista;
        this.clave = clave;
    }

    public Presupuesto(int idExamenVista, String clave) {
        this.idExamenVista = idExamenVista;
        this.clave = clave;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getIdExamenVista() {
        return idExamenVista;
    }

    public void setIdExamenVista(int idExamenVista) {
        this.idExamenVista = idExamenVista;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Presupuesto{" + "idPresupuesto=" + idPresupuesto + ", idExamenVista=" + idExamenVista + ", clave=" + clave + '}';
    }
    
}
