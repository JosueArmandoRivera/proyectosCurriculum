/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optik.model;

/**
 *
 * @author Lenovo
 */
public class Presupuesto_lentescontacto {
    int idpresupuesto_lentescontacto;
    Examen_vista idExamenVista;
    Lente_Contacto idLenteContacto;
    String clave;
   

    public Presupuesto_lentescontacto(int idpresupuesto_lentescontacto, Examen_vista idExamenVista, Lente_Contacto idLenteContacto, String clave) {
        this.idpresupuesto_lentescontacto = idpresupuesto_lentescontacto;
        this.idExamenVista = idExamenVista;
        this.idLenteContacto = idLenteContacto;
        this.clave = clave;
        
    }

    public Presupuesto_lentescontacto(Examen_vista idExamenVista, Lente_Contacto idLenteContacto, String clave) {
        this.idExamenVista = idExamenVista;
        this.idLenteContacto = idLenteContacto;
        this.clave = clave;
       
    }

    public int getIdpresupuesto_lentescontacto() {
        return idpresupuesto_lentescontacto;
    }

    public void setIdpresupuesto_lentescontacto(int idpresupuesto_lentescontacto) {
        this.idpresupuesto_lentescontacto = idpresupuesto_lentescontacto;
    }

    public Examen_vista getIdExamenVista() {
        return idExamenVista;
    }

    public void setIdExamenVista(Examen_vista idExamenVista) {
        this.idExamenVista = idExamenVista;
    }

    public Lente_Contacto getIdLenteContacto() {
        return idLenteContacto;
    }

    public void setIdLenteContacto(Lente_Contacto idLenteContacto) {
        this.idLenteContacto = idLenteContacto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    @Override
    public String toString() {
        return "Presupuesto_lentescontacto{" + "idpresupuesto_lentescontacto=" + idpresupuesto_lentescontacto + 
                ", idExamenVista=" + idExamenVista + ", idLenteContacto=" + idLenteContacto + 
                ", clave=" + clave + ", examenvista=" + '}';
    }
    
}
