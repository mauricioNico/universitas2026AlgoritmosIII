import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno("Juan", 8));
        alumnos.add(new Alumno("Ana", 5));
        alumnos.add(new Alumno("Pedro", 9));
        alumnos.add(new Alumno("María", 4));
        alumnos.add(new Alumno("Carlos", 7));

        System.out.println("=== TODOS LOS ALUMNOS ===");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }

        /*
         * Implementación funcional:
         * la variable filtro almacena una función.
         *
         * alumno -> alumno.getNota() >= 6
         *
         * recibe un Alumno y devuelve true o false.
         * filtro se crea a partir de una clase anónima que implementa la interfaz FiltroAlumno.
         * es como si tuvieramos una clase class FiltroAlumnoAnonimo implements FiltroAlumno {

    @Override
    public boolean aceptar(Alumno alumno) {
        return alumno.getNota() >= 6;
    }

}
         */
        FiltroAlumno filtro =
                alumno -> alumno.getNota() >= 6;

        System.out.println("\n=== ALUMNOS APROBADOS ===");

        for (Alumno alumno : alumnos) {

            if (filtro.aceptar(alumno)) {
                System.out.println(alumno);
            }

        }

    }
}
