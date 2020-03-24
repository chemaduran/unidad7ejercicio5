package alixar;

public class principal {

    public static void main(String[] args) {

        // Iniciamos el proceso de introducir aspirantes
        IntroducirAspirantes introduccion = new IntroducirAspirantes();
	    introduccion.introducir_aspirantes();

	    // Iniciamos el proceso de introducir las calificaciones
        Calificaciones calificaciones = new Calificaciones();
        calificaciones.poner_notas();

        // Iniciar el proceso de listar las calificaciones con los datos de aspirantes
        Aprobados aprobados = new Aprobados();
        aprobados.cargar_aspirantes();
        aprobados.cargar_notas();
        aprobados.calcular_medias();
        aprobados.generarInforme();
    }
}
