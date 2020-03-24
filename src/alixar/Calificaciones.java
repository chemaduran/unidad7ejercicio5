package alixar;

import java.awt.image.ImageProducer;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Calificaciones {
    private final int NUM_PRUEBAS = 3;
    ArrayList<Integer> lista_ids = new ArrayList<>();
    HashMap<Integer, ArrayList<Double>> mapa_notas = new HashMap<>();

    public Calificaciones() {
        cargar_ids();
    }

    private void cargar_ids() {
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("ids_aspirantes.dat"))) {
            lista_ids = (ArrayList<Integer>) fichero.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void poner_notas() {
        Scanner sc = new Scanner(System.in);
        // Para cada aspirante, insertar la lista de notas de cada prueba de la oposición

        for (Integer id : lista_ids ) {
            ArrayList<Double> notas = new ArrayList<>();
            for (int i = 0; i < NUM_PRUEBAS; i++) {
                System.out.println("Introduzca la nota de la prueba número " + i +" del aspirante número " + id);
                Double nota = sc.nextDouble();
                sc.nextLine();
                notas.add(nota);
            }
            mapa_notas.put(id, notas);
        }
        guardar_notas();
    }

    private void guardar_notas() {
        try (ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("calificaciones.dat"))) {
            fichero.writeObject(mapa_notas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
