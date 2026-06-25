package casero;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Clase que representa un Árbol Binario de Búsqueda genérico.
 *
 * T extends Comparable<T> significa que el dato guardado en el árbol
 * debe saber compararse con otro dato del mismo tipo.  
 *
 * Ejemplos válidos:
 * Integer, Double, String, Persona si Persona implementa Comparable.
 * Comparable es una interfaz que define el método compareTo, 
 * que se utiliza para comparar objetos. Los genéricos son tipos de dato objeto, wrapper clases o clases
 * envoltorio de tipos primitivos (Integer, Double, etc.). int es diferente de Integer, ya que int 
 * es un tipo de dato primitivo y no puede ser utilizado como un tipo genérico.
 * o objetos personalizados que implementen la interfaz Comparable.
 */


public class Arbol<T extends Comparable<T>> {

    private NodoArbol<T> raiz; //al ser NodoArbol<T> es un nodo que contiene un dato de tipo T, 
    // y referencias a sus hijos izquierdo y derecho.

//este es el constructor de la clase Arbol, se inicializa la raíz del árbol como null, 
// lo que indica que el árbol está vacío al momento de su creación.
    public Arbol() {
        this.raiz = null;
    }

    public void insertar(T dato) {

        raiz = insertarRecursivo(raiz, dato);

        System.out.println("\nInsertado: " + dato);

        imprimirArbol();
    }

    private NodoArbol<T> insertarRecursivo(NodoArbol<T> nodo, T dato) {

        if (nodo == null) {
            return new NodoArbol<>(dato);
        }

        int comparacion = dato.compareTo(nodo.getValor()); //no necesito poner dato.toString() o 
        // nodo.getValor().toString() porque compareTo ya devuelve un entero que indica la relación entre 
        // los objetos, y en la firma de la clase Arbol se especifica que T debe extender Comparable<T>, 
        // lo que garantiza que el método compareTo funcione correctamente con objetos de tipo T (porque los T
        // se pueden comparar). 
        // El método compareTo devuelve un valor negativo si el objeto actual es menor que el 
        // objeto comparado, cero si son iguales y un valor positivo si es mayor. 
        // Esto permite determinar dónde insertar el nuevo dato en el árbol binario de búsqueda.


        if (comparacion < 0) {

            nodo.setIzquierdo(
                    insertarRecursivo(
                            nodo.getIzquierdo(),
                            dato));

        } else if (comparacion > 0) {

            nodo.setDerecho(
                    insertarRecursivo(
                            nodo.getDerecho(),
                            dato));

        } else {

            System.out.println(
                    "El dato " + dato +
                    " ya existe en el árbol.");
        }

        return nodo;
    }

    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(NodoArbol<T> nodo, T dato) {

        if (nodo == null) {
            return false;
        }

        int comparacion = dato.compareTo(nodo.getValor());

        if (comparacion == 0) {
            return true;
        }

        if (comparacion < 0) {
            return buscarRecursivo(
                    nodo.getIzquierdo(),
                    dato);
        }

        return buscarRecursivo(
                nodo.getDerecho(),
                dato);
    }

    public void preOrden() {

        System.out.print("PreOrden: ");

        preOrdenRecursivo(raiz);

        System.out.println();
    }

    private void preOrdenRecursivo(NodoArbol<T> nodo) {

        if (nodo == null) {
            return;
        }

        System.out.print(nodo.getValor() + " ");

        preOrdenRecursivo(nodo.getIzquierdo());

        preOrdenRecursivo(nodo.getDerecho());
    }

    public void inOrden() {

        System.out.print("InOrden: ");

        inOrdenRecursivo(raiz);

        System.out.println();
    }

    private void inOrdenRecursivo(NodoArbol<T> nodo) {

        if (nodo == null) {
            return;
        }

        inOrdenRecursivo(nodo.getIzquierdo());

        System.out.print(nodo.getValor() + " ");

        inOrdenRecursivo(nodo.getDerecho());
    }

    public void postOrden() {

        System.out.print("PostOrden: ");

        postOrdenRecursivo(raiz);

        System.out.println();
    }

    private void postOrdenRecursivo(NodoArbol<T> nodo) {

        if (nodo == null) {
            return;
        }

        postOrdenRecursivo(nodo.getIzquierdo());

        postOrdenRecursivo(nodo.getDerecho());

        System.out.print(nodo.getValor() + " ");
    }

    public void bfs() {

        System.out.print("BFS: ");

        if (raiz == null) {
            System.out.println("Árbol vacío");
            return;
        }

        List<NodoArbol<T>> cola = new LinkedList<>();

        cola.offer(raiz);

        while (!cola.isEmpty()) {

            NodoArbol<T> actual = cola.poll();

            System.out.print(actual.getValor() + " ");

            if (actual.getIzquierdo() != null) {
                cola.offer(actual.getIzquierdo());
            }

            if (actual.getDerecho() != null) {
                cola.offer(actual.getDerecho());
            }
        }

        System.out.println();
    }

    public void imprimirArbol() {

        if (raiz == null) {
            System.out.println("Árbol vacío");
            return;
        }

        System.out.println(raiz.getValor());

        imprimirArbolRecursivo(
                raiz.getIzquierdo(),
                "",
                true);

        imprimirArbolRecursivo(
                raiz.getDerecho(),
                "",
                false);
    }

    private void imprimirArbolRecursivo(
            NodoArbol<T> nodo,
            String prefijo,
            boolean esIzquierdo) {

        if (nodo == null) {
            return;
        }

        System.out.println(
                prefijo +
                (esIzquierdo ? "├── " : "└── ")
                + nodo.getValor());

        imprimirArbolRecursivo(
                nodo.getIzquierdo(),
                prefijo + (esIzquierdo ? "│   " : "    "),
                true);

        imprimirArbolRecursivo(
                nodo.getDerecho(),
                prefijo + (esIzquierdo ? "│   " : "    "),
                false);
    }
}