
import java.util.TreeSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

       Set<Alumno> alumnos = new TreeSet<>();
//nombre y legajo, ordenados por legajo
        alumnos.add(new Alumno("Juan", 200));
        alumnos.add(new Alumno("Juan", 400));
        alumnos.add(new Alumno("Ana", 100));
        alumnos.add(new Alumno("Pedro", 300));

        System.out.println(alumnos);
    }
}