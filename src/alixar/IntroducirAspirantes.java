package alixar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IntroducirAspirantes {
    HashMap<Integer, Aspirante> mapa_aspirantes = new HashMap<>();
    ArrayList<Integer> lista_ids = new ArrayList<>();
    static int num_aspirante = 0;

    public void introducir_aspirantes() {
        boolean seguir_introduciendo = true;
        Scanner sc = new Scanner(System.in);
        while (seguir_introduciendo) {
            System.out.println("DNI: ");
            String dni = sc.nextLine();
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Telefono: ");
            String telefono = sc.nextLine();
            InsertaAspirante(nombre, dni, telefono);
            System.out.println("¿Desea insertar otro aspirante? [s/n]");
            String opcion = sc.nextLine();
            if (opcion.equalsIgnoreCase("n")) {
                seguir_introduciendo = false;
            }
        }
        guardarFicheros();
    }

    public void InsertaAspirante(String nombre, String DNI, String telefono) {
        mapa_aspirantes.put(num_aspirante, new Aspirante(nombre, DNI, telefono));
        lista_ids.add(num_aspirante);
        num_aspirante++;
    }

    public void guardarFicheros() {
        try (ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("aspirantes.dat"))) {
            fichero.writeObject(mapa_aspirantes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("ids_aspirantes.dat"))) {
            fichero.writeObject(lista_ids);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
