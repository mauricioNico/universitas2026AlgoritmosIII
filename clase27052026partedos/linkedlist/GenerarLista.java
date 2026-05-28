package linkedlist;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GenerarLista {

    public static void main(String[] args) {
        List<Persona> lista = new LinkedList<>(); //voy a generar un objeto de tipo linkedList que va a
        //implementar la interfaz List, y va a contener objetos de tipo Persona
        /*
        * el método add() se utiliza para agregar elementos a la lista. 
        En este caso, estamos agregando objetos de tipo Persona a la lista. 
        Cada objeto Persona se crea utilizando el constructor de la clase Persona, 
        que toma un nombre y una edad como parámetros. 
        */
lista.add(new Persona("Juan", 30));
lista.add(new Persona("Maria", 25));
lista.add(new Persona("Pedro", 40));
        System.out.println("Lista de personas:");
/* impresion de la lista, se puede hacer con foreach o directamente system.out.println */
        for (Persona persona : lista) {
            System.out.println(persona);
        }
   /* para obtener el tamaño de la lista
   imprimir la lista en orden inverso utilizando el método size que devuelve el tamaño de la lista */
            System.out.println("\nLista de personas en orden inverso:");
            for (int i = lista.size() - 1; i >= 0; i--) { //i tomará 2, 1 y 0, que son los índices 
            // de los elementos en la lista
                System.out.println(lista.get(i));
            }
   

        /*
        para encontrar!
   obtener la posición de un elemento en la lista utilizando el método indexOf(). 
   Este método devuelve el índice de la primera aparición del elemento en la lista, o -1 si
   el elemento no se encuentra en la lista.
   */
  Scanner scanner = new Scanner(System.in);
   System.out.println("Ingresar el elemento a buscar:");
    String nombreBuscado = scanner.nextLine(); // Leemos la entrada del usuario
boolean encontrado = false; // Variable para indicar si se encontró el elemento
    for(Persona persona : lista) {
    if(persona.getNombre().equalsIgnoreCase(nombreBuscado)) {
        System.out.println("Elemento encontrado en la posición: " + lista.indexOf(persona));
        encontrado = true;
        break;
    }
    
} 
if(!encontrado) 
    System.out.println("Elemento no encontrado en la lista.");
/* eliminar un elemento de la lista */
    System.out.println("Ingresar el nombre de la persona a eliminar:");
    String nombreEliminar = scanner.nextLine();
    boolean eliminado = false;
    for (Persona persona : lista) {
        if (persona.getNombre().equalsIgnoreCase(nombreEliminar)) {
            lista.remove(persona);  //remove para eliminar el elemento de la lista
            System.out.println("Elemento eliminado de la lista.");
            eliminado = true;
            break;
        }
    }
    if (!eliminado) {
        System.out.println("Elemento no encontrado en la lista.");
    }
/**
 * tambien a partir del índice se puede obtener un elemento utilizando el método get() de la lista.
 * 
 */
System.out.println("Elemento en la posición 0 (cabeza de la lista): " + lista.get(0));
    scanner.close();
    }}  