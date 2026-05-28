package listaEnlazada;

public class ListaDoble {

    /*
     * Cabeza:
     * primer nodo de la lista.
     */
    private Nodo cabeza;

    /*
     * Cola:
     * último nodo de la lista.
     * 
     * Permite recorrer la lista
     * en sentido inverso.
     */
    private Nodo cola;

    public ListaDoble() {

        this.cabeza = null;

        this.cola = null;
    }

    /*
     * Agregar un nuevo nodo al final
     * de la lista doblemente enlazada.
     * 
     * Además de enlazar el siguiente,
     * también se enlaza el anterior.
     */
    public void agregar(int dato) {

        Nodo nuevoNodo = new Nodo(dato); //nuevoNodo es una instancia de la clase Nodo, creada con el valor dato. Es una instancia local al método agregar(), y se utiliza para representar el nuevo nodo que se va a agregar a la lista doblemente enlazada. El constructor de la clase Nodo se llama con el valor dato para inicializar el atributo dato del nuevo nodo, y los atributos siguiente y anterior se inicializan en null por defecto. 

        /*
         * Si la lista está vacía,
         * cabeza y cola apuntan
         * al mismo nodo.
         */
        if (cabeza == null) {

            cabeza = nuevoNodo;

            cola = nuevoNodo;

        } else {

            /*
             * El último nodo apunta al nuevo.
             */
            cola.setSiguiente(nuevoNodo);

            /*
             * El nuevo nodo apunta al anterior.
             */
            nuevoNodo.setAnterior(cola);

            /*
             * Actualizar cola.
             */
            cola = nuevoNodo;
        }
    }

    /*
     * Buscar un nodo por valor.
     */
    public Nodo buscar(int valor) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.getDato() == valor) {

                return actual;
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    /*
     * Eliminar un nodo de la lista doble.
     * 
     * Se actualizan:
     * - enlaces siguientes
     * - enlaces anteriores
     */
    public void eliminar(int valor) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.getDato() == valor) {

                Nodo anterior =
                        actual.getAnterior();

                Nodo siguiente =
                        actual.getSiguiente();

                /*
                 * Caso:
                 * eliminar cabeza.
                 */
                if (anterior == null) {

                    cabeza = siguiente;

                } else {

                    anterior.setSiguiente(siguiente);
                }

                /*
                 * Caso:
                 * eliminar cola.
                 */
                if (siguiente == null) {

                    cola = anterior;

                } else {

                    siguiente.setAnterior(anterior);
                }

                return;
            }

            actual = actual.getSiguiente();
        }
    }

    /*
     * Calcular tamaño de la lista.
     */
    public int calcularTamaño() {

        int tamaño = 0;

        Nodo actual = cabeza;

        while (actual != null) {

            tamaño++;

            actual = actual.getSiguiente();
        }

        return tamaño;
    }
 /*
    *Obtener la posición de un nodo por valor.
    * Recorre la lista desde la cabeza
     */
public int obtenerPosicion(int valor) {

        int posicion = 0;

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.getDato() == valor) {

                return posicion;
            }

            actual = actual.getSiguiente();

            posicion++;
        }

        return -1; // Retorna -1 si el nodo no se encuentra
    }


    /*
     * Imprimir lista en orden normal.
     */
    public void imprimir() {

        Nodo actual = cabeza;

        System.out.print("cabeza → ");

        while (actual != null) {

            System.out.print(
                    "[" + actual.getDato() + "]"
            );

            System.out.print(" ⇄ ");

            actual = actual.getSiguiente();
        }

        System.out.println("null");
    }

    /*
     * Imprimir lista en orden inverso.
     * 
     * Se comienza desde cola y
     * se recorre utilizando
     * referencias anteriores.
     */
    public void imprimirReversa() {

        Nodo actual = cola;

        System.out.print("cola → ");

        while (actual != null) {

            System.out.print(
                    "[" + actual.getDato() + "]"
            );

            System.out.print(" ⇄ ");

            actual = actual.getAnterior();
        }

        System.out.println("null");
    }
}