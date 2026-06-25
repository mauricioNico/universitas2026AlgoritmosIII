package HashMap;
import java.util.HashMap;
import java.util.Map;
import Hash.Alumno;

public class AppHashMap {

    public static void main(String[] args) {

        Map<Integer, Alumno> alumnos = new HashMap<>();
Map<String,String>usuario=new HashMap<>();
usuario.put("123456$","admin");
usuario.put("123456$","admin2");
        alumnos.put(23, new Alumno(23, "Juan"));
        alumnos.put(14, new Alumno(14, "Ana"));
        alumnos.put(33, new Alumno(33, "Luis"));
        alumnos.put(44, new Alumno(44, "Sofía"));
        alumnos.put(53, new Alumno(53, "Pedro"));
//interacción entre objetos, paso de mensaje
        Alumno buscado = alumnos.get(33);
System.out.println("Usuario: "+usuario.get("123456$"));
        System.out.println("Alumno encontrado: " + buscado.getNombre()+" con legajo: "+buscado.getLegajo());

        System.out.println();
        System.out.println("Listado completo:");
/*
        for (Map.Entry<Integer, Alumno> entrada : alumnos.entrySet()) {
            System.out.println("Clave: " + entrada.getKey()
                    + " - Valor: " + entrada.getValue());
        }
*/
System.out.println(alumnos);
    }
}
