package alixar;

import java.io.Serializable;

public class Aspirante implements Comparable, Serializable {
    private String nombre;
    private String DNI;
    private String telefono;
    private Double media;

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Aspirante(String nombre, String DNI, String telefono) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Object o) {
        Aspirante e = (Aspirante) o;
        return this.nombre.compareTo(e.nombre);
    }
}
