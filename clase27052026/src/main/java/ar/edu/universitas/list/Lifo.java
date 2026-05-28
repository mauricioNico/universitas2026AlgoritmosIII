package ar.edu.universitas.list;
import java.util.Deque;
import java.util.LinkedList;
public class Lifo {
    /*
    LIFO significa "Last In, First Out" (último en entrar, primero en salir). 
    Es una estructura de datos en la que el último elemento agregado es el primero en ser removido. 
    En Java, la interfaz Deque (Double Ended Queue) se puede usar para implementar una pila (stack) 
    que sigue el principio LIFO. La clase LinkedList es una implementación común de Deque.
    El objeto es LinkedList, que implementa la interfaz Deque, se utiliza para crear una pila.
    Internamente LinkedList mantiene una lista enlazada de nodos, donde cada nodo contiene un elemento 
    y referencias al nodo anterior y siguiente.
    */
    public static void main(String[] args) {
        /*
        El objeto pila bien podria ser un ArrayDeqeue, pero LinkedList es una implementación 
        común de Deque y es fácil de usar para este propósito. ArrayDeqe es un poco mas eficiente 
        en términos de memoria y rendimiento,  pero LinkedList es más flexible y fácil de entender 
        para este ejemplo.  
        */
        Deque <Integer> pila = new LinkedList<>();
        //el método push() agrega el elemento al tope de la pila (cabeza de la lista)
        pila.push(1); 
        pila.push(2);
        pila.push(3);

        System.out.println("Pila: " + pila);
//pop remueve y devuelve el elemento en el tope de la pila (cabeza de la lista)
        System.out.println("Desapilando: " + pila.pop());
              System.out.println("Pila después de desapilar: " + pila);
//se puede ver el elemento en el tope de la pila sin removerlo usando peek()
        System.out.println("Elemento en el tope de la pila: " + pila.peek());     
//vuelvo a imprimir la pila para mostrar que peek() no removió el elemento
        System.out.println("Pila después de peek: " + pila);         
    }
}
