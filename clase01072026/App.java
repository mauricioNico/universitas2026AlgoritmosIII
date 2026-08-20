import java.util.HashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) {
        Map<Integer, Alumno> alumnos = new HashMap<>();
        Alumno alumno1 = new Alumno("Juan", 20);
        Alumno alumno2 = new Alumno("Juan", 20);

     alumnos.put(1, alumno1);
        alumnos.put(2, alumno2);
        alumnos.put(3, new Alumno("Pedro", 21));

        System.out.println("alumno1 equals alumno2: " + alumno1.equals(alumno2));
        System.out.println("alumno1 hashCode: " + alumno1.hashCode());
        System.out.println("alumno2 hashCode: " + alumno2.hashCode());
        System.out.println("alumnos map size: " + alumnos.size());
        System.out.println("alumnos map: " + alumnos);
    }
}
