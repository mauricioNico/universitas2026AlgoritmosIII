package teoria;
import java.util.Set;
import java.util.HashSet;
import Hash.Alumno;
public class App{
    public static void main(String[] args) {
        //llamar al constructor de HashSet
        Set<String> num=new HashSet<>();
        //le solicito me muestre el hashcode
        System.out.println("Mauricio".hashCode());

        num.add("Mauricio");
        num.add("Leonel");
        num.add("Laura");
        num.add("Mauricio");
//esta coleccion esta integrada por objetos Integer, para recorrerla
//foreach
for(String elemento: num)
    System.out.println(elemento);
Set<Alumno> a=new HashSet<>();
    a.add(new Alumno(1001,"Franco"));
    }
   }