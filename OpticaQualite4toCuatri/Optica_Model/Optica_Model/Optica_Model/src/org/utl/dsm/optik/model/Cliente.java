/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Cliente {
    int idCliente;
    String numeroUnico;
    int estatus;
    Cliente cliente;
    Persona persona;

    public Cliente(int idCliente, String numeroUnico, int estatus, Cliente cliente, Persona persona) {
        this.idCliente = idCliente;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.cliente = cliente;
        this.persona = persona;
    }

    public Cliente(String numeroUnico, int estatus, Cliente cliente, Persona persona) {
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.cliente = cliente;
        this.persona = persona;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + ", cliente=" + cliente.toString() + ", persona=" + persona.toString() + '}';
    }
    
    
}
