package alixar;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Aprobados {
    HashMap<Integer, ArrayList<Double>> mapa_notas = new HashMap<>();
    HashMap<Integer, Aspirante> mapa_aspirantes = new HashMap<>();
    TreeSet<Aspirante> aprobados = new TreeSet<>();

    public void cargar_notas() {
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("calificaciones.dat"))) {
            mapa_notas = (HashMap<Integer, ArrayList<Double>>) fichero.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargar_aspirantes() {
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("aspirantes.dat"))) {
            mapa_aspirantes = (HashMap<Integer, Aspirante>) fichero.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void calcular_medias() {
        for (Integer id : mapa_aspirantes.keySet()) {
            mapa_aspirantes.get(id).setMedia(calcularMedia(id));
            aprobados.add(mapa_aspirantes.get(id));
        }
    }

    private Double calcularMedia(Integer id) {
        ArrayList<Double> notas = mapa_notas.get(id);
        Double suma = 0.0;
        for (Double nota : notas ) {
            suma += nota;
        }
        Double media = suma / notas.size();
        return media;
    }

    public void generarInforme() {
        System.out.println("NOMBRE            DNI   CALIFICACIÓN MEDIA");
        System.out.println("----------------  ---   ------------------");
        for (Aspirante a : aprobados) {
            System.out.println(a.getNombre() + " " + a.getDNI() + " " + a.getMedia());
        }
    }
}
