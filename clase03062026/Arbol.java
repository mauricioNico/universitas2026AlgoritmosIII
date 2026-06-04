import java.util.LinkedList;
import java.util.Queue;

/*
 * Clase que representa un Árbol Binario de Búsqueda (BST).
 *
 * Regla fundamental:
 *
 *      Izquierda < Nodo < Derecha
 *
 * Cada nuevo dato se inserta respetando esa regla.
 *
 * Ejemplo:
 *
 *          50
 *        /    \
 *      30      70
 *     / \     / \
 *   20  40  60  80
 *
 * Los árboles permiten realizar búsquedas más eficientes que una lista
 * porque no es necesario recorrer todos los elementos.
 */
public class Arbol {

    private NodoArbol raiz;

    /*
     * Constructor.
     * Inicialmente el árbol está vacío.
     */
    public Arbol() {
        this.raiz = null;
    }

    /*
     * Método público de inserción.
     * El usuario solamente invoca insertar().
     *
     * El trabajo real lo realiza insertarRecursivo().
     */
    public void insertar(int dato) {

    raiz = insertarRecursivo(
            raiz,
            dato);

    System.out.println("\nInsertado: " + dato);

    imprimirArbol();
}

    /*
     * Inserción recursiva.
     *
     * Caso base:
     * Si encontramos una referencia null,
     * creamos allí el nuevo nodo.
     */
    private NodoArbol insertarRecursivo(NodoArbol nodo, int dato) {

        if (nodo == null) {
            return new NodoArbol(dato);
        }

        /*
         * Si el dato es menor,
         * se inserta en el subárbol izquierdo.
         */
        if (dato < nodo.getValor()) {

            nodo.setIzquierdo(
                    insertarRecursivo(
                            nodo.getIzquierdo(),
                            dato));

        }
        /*
         * Si el dato es mayor,
         * se inserta en el subárbol derecho.
         */
        else if (dato > nodo.getValor()) {

            nodo.setDerecho(
                    insertarRecursivo(
                            nodo.getDerecho(),
                            dato));
        }

        /*
         * Si el dato ya existe,
         * no se inserta.
         */
        else {

            System.out.println(
                    "El dato " + dato +
                    " ya existe en el árbol.");
        }

        return nodo;
    }

    /*
     * Método público de búsqueda.
     */
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    /*
     * Búsqueda recursiva.
     */
    private boolean buscarRecursivo(
            NodoArbol nodo,
            int dato) {

        /*
         * Llegamos a una rama vacía.
         */
        if (nodo == null) {
            return false;
        }

        /*
         * Encontrado.
         */
        if (dato == nodo.getValor()) {
            return true;
        }

        /*
         * Buscar a la izquierda.
         */
        if (dato < nodo.getValor()) {

            return buscarRecursivo(
                    nodo.getIzquierdo(),
                    dato);
        }

        /*
         * Buscar a la derecha.
         */
        return buscarRecursivo(
                nodo.getDerecho(),
                dato);
    }

    /*
     * ==================================================
     * RECORRIDOS DFS
     * ==================================================
     */

    /*
     * PREORDEN
     *
     * Raíz
     * Izquierda
     * Derecha
     */
    public void preOrden() {

        System.out.print("PreOrden: ");

        preOrdenRecursivo(raiz);

        System.out.println();
    }

    private void preOrdenRecursivo(
            NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        System.out.print(
                nodo.getValor() + " ");

        preOrdenRecursivo(
                nodo.getIzquierdo());

        preOrdenRecursivo(
                nodo.getDerecho());
    }

    /*
     * INORDEN
     *
     * Izquierda
     * Raíz
     * Derecha
     *
     * En un BST devuelve
     * los elementos ordenados.
     */
    public void inOrden() {

        System.out.print("InOrden: ");

        inOrdenRecursivo(raiz);

        System.out.println();
    }

    private void inOrdenRecursivo(
            NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        inOrdenRecursivo(
                nodo.getIzquierdo());

        System.out.print(
                nodo.getValor() + " ");

        inOrdenRecursivo(
                nodo.getDerecho());
    }

    /*
     * POSTORDEN
     *
     * Izquierda
     * Derecha
     * Raíz
     */
    public void postOrden() {

        System.out.print("PostOrden: ");

        postOrdenRecursivo(raiz);

        System.out.println();
    }

    private void postOrdenRecursivo(
            NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        postOrdenRecursivo(
                nodo.getIzquierdo());

        postOrdenRecursivo(
                nodo.getDerecho());

        System.out.print(
                nodo.getValor() + " ");
    }

    /*
     * ==================================================
     * BFS
     * ==================================================
     *
     * Breadth First Search
     * Recorrido por niveles.
     *
     * Utiliza una Queue (FIFO).
     */
    public void bfs() {

        System.out.print("BFS: ");

        if (raiz == null) {

            System.out.println(
                    "Árbol vacío");

            return;
        }

        Queue<NodoArbol> cola =
                new LinkedList<>();

        /*
         * La raíz entra primero.
         */
        cola.offer(raiz);

        while (!cola.isEmpty()) {

            NodoArbol actual =
                    cola.poll();

            System.out.print(
                    actual.getValor() + " ");

            /*
             * Hijo izquierdo.
             */
            if (actual.getIzquierdo()
                    != null) {

                cola.offer(
                        actual.getIzquierdo());
            }

            /*
             * Hijo derecho.
             */
            if (actual.getDerecho()
                    != null) {

                cola.offer(
                        actual.getDerecho());
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
        NodoArbol nodo,
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
            prefijo +
            (esIzquierdo ? "│   " : "    "),
            true);

    imprimirArbolRecursivo(
            nodo.getDerecho(),
            prefijo +
            (esIzquierdo ? "│   " : "    "),
            false);
}
}
