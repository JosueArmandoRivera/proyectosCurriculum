package org.dsm.registroalumnosexamen1erparcial;

import android.widget.EditText;

public class Alumno{
    int id;
    String matricula;
    String nombre;
    String primerApellido;
    String segundoApellido;
    String cuatrimestre;
    String email;
    String grupo;

    public Alumno() {
    }

    public Alumno(int id, String matricula, String nombre, String primerApellido, String segundoApellido, String cuatrimestre, String email, String grupo) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cuatrimestre = cuatrimestre;
        this.email = email;
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
