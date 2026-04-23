package instituto;
import poli.*;
public class App {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Juan", "Perez", 12345678, "A001");
        Profesor profesor1 = new Profesor("Maria", "Gomez", 87654321, new String[]{"Matematica", "Fisica"});

        System.out.println("Datos del alumno:");
        alumno1.mostrarDatos();

        System.out.println("\nDatos del profesor:");
        profesor1.mostrarDatos();
   Gato gato1 = new Gato("Michi");
        Perro perro1 = new Perro("Firulais");

        gato1.hacerSonido();

        perro1.hacerSonido();
    }
}
