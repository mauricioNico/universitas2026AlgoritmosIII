package ar.edu.universitas.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fifo {

    /*
     * FIFO significa "First In, First Out"
     * (primero en entrar, primero en salir).
     * 
     * Es una estructura de datos donde el primer
     * elemento agregado será el primero en salir.
     * 
     * En Java, la interfaz Queue representa el
     * comportamiento de una cola FIFO.
     * 
     * LinkedList es una clase concreta que implementa
     * varias interfaces, entre ellas:
     * 
     * - List
     * - Queue
     * - Deque
     * 
     * Internamente LinkedList utiliza una lista
     * doblemente enlazada de nodos.
     * 
     * Cada nodo contiene:
     * - el dato
     * - una referencia al nodo siguiente
     * - una referencia al nodo anterior
     */

    public static void main(String[] args) {

        /*
         * Acá vemos ejemplos de polimorfismo.
         * 
         * El objeto real creado es LinkedList,
         * pero puede ser referenciado mediante
         * distintos tipos:
         * 
         * Queue -> comportamiento FIFO
         * List -> comportamiento de lista general
         * LinkedList -> acceso a todos los métodos
         * concretos de LinkedList
         * 
         * El tipo de referencia determina qué métodos
         * estarán disponibles en compilación.
         */

        Queue<Integer> cola1 = new LinkedList<>();

        LinkedList<Integer> cola2 = new LinkedList<>();

        List<Integer> lista = new LinkedList<>();

        /*
         * En Queue se recomienda usar:
         * 
         * - offer() para agregar
         * - poll() para remover
         * - peek() para consultar el primero
         * 
         * Podríamos usar add() en lugar de offer(),
         * pero si ocurre un problema al insertar:
         * 
         * - add() lanza excepción
         * - offer() devuelve false
         * 
         * Esto puede ocurrir en implementaciones
         * con capacidad limitada, por ejemplo:
         * ArrayBlockingQueue.
         */

        cola1.offer(1);
        cola1.offer(2);
        cola1.offer(3);

        System.out.println("Cola FIFO usando Queue:");
        System.out.println("Cola: " + cola1);

        System.out.println("Desencolando: " + cola1.poll());

        System.out.println("Cola después de desencolar: " + cola1);

        System.out.println();

        /*
         * Acá usamos directamente LinkedList.
         * 
         * Tenemos acceso a métodos específicos
         * como removeFirst().
         */

        cola2.add(10);
        cola2.add(20);
        cola2.add(30);

        System.out.println("Cola usando LinkedList:");

        System.out.println("Cola2: " + cola2);

        System.out.println("Desencolando de Cola2: "
                + cola2.removeFirst());

        System.out.println("Cola2 después de desencolar: "
                + cola2);

        System.out.println();

        /*
         * Aunque el objeto real es LinkedList,
         * al usar una referencia List solamente
         * tendremos disponibles los métodos
         * definidos en la interfaz List.
         */

        lista.add(100);
        lista.add(200);
        lista.add(300);

        System.out.println("Lista usando referencia List:");

        System.out.println(lista);
    }
}