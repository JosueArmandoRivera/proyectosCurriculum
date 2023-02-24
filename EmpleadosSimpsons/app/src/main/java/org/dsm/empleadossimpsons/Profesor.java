package org.dsm.empleadossimpsons;

public class Profesor {

    private String IdEmpleado;
    private String Nombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private int Edad;
    private String Email;
    private int Sueldo;

    public Profesor(String idEmpleado, String nombre, String primerApellido, String segundoApellido, int edad, String email, int sueldo) {
        IdEmpleado = idEmpleado;
        Nombre = nombre;
        PrimerApellido = primerApellido;
        SegundoApellido = segundoApellido;
        Edad = edad;
        Email = email;
        Sueldo = sueldo;
    }

    public Profesor() {
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
    }
}


