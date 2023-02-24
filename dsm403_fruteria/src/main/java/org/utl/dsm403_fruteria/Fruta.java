package org.utl.dsm403_fruteria;

public class Fruta {
    private int idFruta;
    private String nombre;
    private double catidad;
    private String presetacion;

    public Fruta() {
    }

    public Fruta(int idFruta, String nombre, double catidad, String presetacion) {
        this.idFruta = idFruta;
        this.nombre = nombre;
        this.catidad = catidad;

        this.presetacion = presetacion;
    }

    public int getIdFruta() {

        return idFruta;
    }

    public void setIdFruta(int idFruta) {

        this.idFruta = idFruta;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public double getCatidad() {

        return catidad;
    }

    public void setCatidad(double catidad) {

        this.catidad = catidad;
    }

    public String getPresetacion() {

        return presetacion;
    }

    public void setPresetacion(String presetacion) {

        this.presetacion = presetacion;
    }
}
