package listaEnlazada;
import java.util.List;
import java.util.ArrayList;
public class Teoria {
 public static void main(String[] args) {
  //clases wrapper o envoltorio
    Integer numero=42;
  int numero2=42; //es un primitivo
  Persona p1,p2; //declaracion de variables de tipo Persona, que es una clase definida en el mismo paquete. Estas variables pueden almacenar referencias a objetos de tipo Persona.
  p1=new Persona("Santiago Mina", 20); //creacion de un nuevo objeto Persona con el nombre "Santiago Mina" y la edad 20, y se asigna a la variable p1. El operador new se utiliza para crear una nueva instancia de la clase Persona, y el constructor de la clase se llama con los argumentos correspondientes para inicializar los atributos del objeto.
  p2=new Persona("Franco Poveda", 22); //creacion de un nuevo objeto Persona con el nombre "Franco Poveda" y la edad 22, y se asigna a la variable p2. El operador new se utiliza para crear una nueva instancia de la clase Persona, y el constructor de la clase se llama con los argumentos correspondientes para inicializar los atributos del objeto.
System.out.println(Integer.MAX_VALUE); //métodos estaticos de la clase Integer
System.out.println(Long.MAX_VALUE); //métodos estaticos de la clase Long
List<Persona> personas=new ArrayList<>(); //lista de objetos Persona, se crea una lista que puede almacenar objetos de tipo Persona. La clase ArrayList es una implementación de la interfaz List, que permite almacenar elementos en un orden específico y acceder a ellos mediante índices. En este caso, la lista se declara con el tipo genérico Persona, lo que significa que solo se pueden agregar objetos de tipo Persona a esta lista.
personas.add(p1); 
personas.add(p2); 
personas.add(p1);

for (Persona p : personas) {
    System.out.println(p);
}

for(int i=0; i<personas.size(); i++) {
   if(personas.get(i).getNombre().equals("Santiago Mina")) {
     System.out.println("Se ha eliminado a : " + personas.get(i).getNombre()); 
    personas.remove(i);
      
   }
}

System.out.println();
System.out.println(personas);

List<Integer> lista=new ArrayList<>(); //lista es una implementacion de la interfaz List, y se le asigna un objeto de tipo ArrayList, que es una clase que implementa la interfaz List. El tipo de dato que se va a almacenar en la lista es Integer, que es una clase wrapper para el tipo de dato int. Esto permite almacenar objetos Integer en la lista, en lugar de solo tipos primitivos int.
if(lista.add(numero))
    System.out.println("El numero se ha agregado a la lista");
lista.add(numero2); //hago un boxing, convierte el tipo primitivo int a un objeto Integer para poder almacenarlo en la lista, ya que la lista solo puede almacenar objetos y no tipos primitivos. El proceso de conversión automática de un tipo primitivo a su clase wrapper correspondiente se llama autoboxing. En este caso, el valor 42 se convierte automáticamente en un objeto Integer antes de ser agregado a la lista.
//se usa un bloque try - catch para manejar una posible excepción. En este caso, se intenta acceder al índice 2, que no existe en la lista ya que solo tiene dos elementos (en los índices 0 y 1). Si se lanza la excepción, se captura y se imprime un mensaje indicando que no se puede acceder a un índice que no existe en la lista.  
try{
System.out.println(lista.get(2));}
catch(Exception e){  //en caso de no estar seguro de que tipo de excepción se puede lanzar, se puede usar la clase Exception, que es la clase base para todas las excepciones en Java. Esto permite capturar cualquier tipo de excepción que pueda ocurrir en el bloque try, aunque no se recomienda capturar excepciones genéricas sin un manejo adecuado, ya que puede ocultar errores y dificultar la depuración del código. 
   System.out.println("Error: no se puede acceder a un índice que no existe en la lista");}
//System.out.println(lista.get(2));


int numero3=lista.get(1); //acá se hace un unboxing, convierte el objeto Integer almacenado en la lista en un tipo primitivo int para poder asignarlo a la variable numero3, que es de tipo int. El proceso de conversión automática de un objeto wrapper a su tipo primitivo correspondiente se llama unboxing. En este caso, el objeto Integer que contiene el valor 42 se convierte automáticamente en el valor primitivo int 42 antes de ser asignado a la variable numero3.
System.out.println(numero3);
for (Integer num : lista) 
    System.out.println(num);

System.out.println(lista.size()); //método size() de la clase List, que devuelve el número de elementos en la lista. En este caso, la lista contiene dos elementos (los números 42 y 42), por lo que el método size() devolverá 2.
System.out.println(lista.contains(42));

}   

}
