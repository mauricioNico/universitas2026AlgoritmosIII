package funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Alumno>alumnos=new ArrayList<>();
        alumnos.add(new Alumno(1001, "Ana", "Gómez", 20, 8.5, "Programación"));
        alumnos.add(new Alumno(1002, "Juan", "Pérez", 22, 6.4, "Redes"));
        alumnos.add(new Alumno(1003, "Lucía", "Fernández", 19, 9.1, "Programación"));
        alumnos.add(new Alumno(1004, "Martín", "López", 25, 5.8, "Sistemas"));
        alumnos.add(new Alumno(1005, "Sofía", "Martínez", 21, 7.3, "Redes"));
        alumnos.add(new Alumno(1006, "Pedro", "Suárez", 23, 4.9, "Programación"));
        alumnos.add(new Alumno(1007, "Camila", "Torres", 20, 8.9, "Sistemas"));
    /*    for(Alumno a: alumnos)
            System.out.println(a);*/
    //devover los alumnos con programación funcional
    //alumnos.forEach(a->System.out.println(a));
    //analogo
    //1)
    //alumnos.stream().forEach(a->System.out.println(a));
    //2)
    //alumnos.stream().filter(a->a.getPromedio()>=7).forEach(a->System.out.println(a.getNombre()+" "+a.getPromedio()));
    //3)
    //alumnos.stream().filter(a->a.getPromedio()<7).forEach(a->System.out.println(a.getNombre()+" "+a.getPromedio()));
    //4) Mostrar solo los alumnos de materia Programación
    //alumnos.stream().filter(a->a.getCarrera().equalsIgnoreCase("programación")).forEach(a->System.out.println(a));
    //5) Mapeo de datos
    //alumnos.stream().map(a->a.getApellido()+", "+a.getNombre()).forEach(nombreCompleto->System.out.println(nombreCompleto));
    //6) ordenamiento 
    //alumnos.stream().sorted(alumnos.stream().sorted((a2,a1)->Double.compare(a1.getPromedio(),a2.getPromedio())).forEach(a->System.out.println(a.getApellido()+": "+a.getPromedio()));).forEach(a->System.out.println(a.getApellido()+": "+a.getPromedio()));
    //7) Contar por cada carrera cuantos alumnos hay
    //Map<String,Long>cantidadPorCarrera=alumnos.stream().collect(Collectors.groupingBy(a->a.getCarrera(),Collectors.counting()));
    //System.out.println(cantidadPorCarrera);
    //8) Promedio general
    //double promedioGeneral=alumnos.stream().mapToDouble(a->a.getPromedio()).average().orElse(0);
    //System.out.println("Promedio general: "+promedioGeneral);
    //9) Alumno con mejor o menor nota promedio
    //Alumno mejorPromedio=alumnos.stream().min((a1,a2)->Double.compare(a1.getPromedio(),a2.getPromedio())).orElse(null);
    //System.out.println(mejorPromedio);
    //10) Crear una lista nueva a partir de la original con los nombres completos, el resultado en pantalla es el mismo que en la ejercitación número 5
 //   List<String>nombreCompleto=alumnos.stream().map(a->a.getApellido()+", "+a.getNombre()).collect(Collectors.toList());
//nombreCompleto.forEach(nc->System.out.println(nc));    
//Verificar si existe algún alumno con una nota específica o verificar si todos aprobaron
boolean verificacion1=alumnos.stream().anyMatch(a->a.getPromedio()==10);
boolean verificacion2=alumnos.stream().allMatch(a->a.getPromedio()>=7);
String respuesta=verificacion1?"Hay un 10":"No hay un 10";
String respuesta2=verificacion2?"Aprobaron todos":"No todos aprobaron";
System.out.println(respuesta2);
    }
}
