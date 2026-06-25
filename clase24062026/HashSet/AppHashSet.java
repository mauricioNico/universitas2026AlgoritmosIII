package HashSet;
import java.util.*;
import Hash.Alumno;
public class AppHashSet {
    public static void main(String[] args) {
          Set<Alumno> a=new HashSet<>();
       //   Alumno alum=new Alumno(42,"Susana");
       //   System.out.println(alum.hashCode());
Alumno a1 =
        new Alumno(11, "Juan");
System.out.println(a1.hashCode());
Alumno a2 =
        new Alumno(11, "Juan");
        System.out.println(a2.hashCode());

a.add(a1);
a.add(a2);
System.out.println(a);/*
          System.out.println(a.add(new Alumno(10,"José")));
          System.out.println(a.add(new Alumno(10,"Matías")));
          a.add(alum);
          System.out.println(a.contains(alum));
          a.remove(alum);
          System.out.println(a);*/
          
    }
  
    
}
