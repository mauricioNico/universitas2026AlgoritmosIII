package arbolComun;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBST<T extends Comparable<T>> {

    private NodoBST<T> raiz;

    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoBST<T> insertarRecursivo(NodoBST<T> actual, T dato) {

        if (actual == null) {
            return new NodoBST<>(dato);
        }

        if (dato.compareTo(actual.dato) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, dato);
        } else if (dato.compareTo(actual.dato) > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, dato);
        }

        return actual;
    }

    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(NodoBST<T> actual, T dato) {

        if (actual == null) {
            return false;
        }

        if (dato.compareTo(actual.dato) == 0) {
            return true;
        }

        if (dato.compareTo(actual.dato) < 0) {
            return buscarRecursivo(actual.izquierdo, dato);
        } else {
            return buscarRecursivo(actual.derecho, dato);
        }
    }

    public void recorrerBFS() {

        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<NodoBST<T>> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {

            NodoBST<T> actual = cola.poll();

            System.out.println(actual.dato);

            if (actual.izquierdo != null) {
                cola.offer(actual.izquierdo);
            }

            if (actual.derecho != null) {
                cola.offer(actual.derecho);
            }
        }
    }
}
