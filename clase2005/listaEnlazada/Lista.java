package listaEnlazada;

public class Lista {

    /*
     * La cabeza representa el inicio
     * de la lista enlazada.
     */
    private Nodo cabeza;

    public Lista() {

        this.cabeza = null;
    }

    /*
     * Agregar un nuevo nodo al final de la lista.
     * 
     * Si la lista está vacía:
     * el nuevo nodo se convierte en cabeza.
     * 
     * Si no:
     * se recorre hasta el último nodo y
     * se enlaza el nuevo nodo al final.
     */
    public void agregar(int dato) {

        Nodo nuevoNodo = new Nodo(dato);

        if (cabeza == null) {

            cabeza = nuevoNodo;

        } else {

            Nodo actual = cabeza;

            /*
             * Recorrer la lista hasta encontrar
             * el último nodo.
             */
            while (actual.getSiguiente() != null) {

                actual = actual.getSiguiente();
            }

            /*
             * Enlazar el último nodo con el nuevo.
             */
            actual.setSiguiente(nuevoNodo);
        }
    }

    /*
     * Buscar un nodo por valor.
     * 
     * Recorre la lista desde la cabeza
     * hasta encontrar el dato buscado.
     * 
     * Devuelve:
     * - el nodo encontrado
     * - null si no existe
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
     * Eliminar un nodo de la lista.
     * 
     * Casos posibles:
     * - eliminar cabeza
     * - eliminar nodo intermedio
     * - eliminar último nodo
     */
    public void eliminar(int valor) {

        Nodo actual = cabeza;

        Nodo anterior = null;

        /*
         * Recorrer la lista buscando el nodo.
         */
        while (actual != null) {

            if (actual.getDato() == valor) {

                /*
                 * Caso especial:
                 * eliminar la cabeza.
                 */
                if (anterior == null) {

                    cabeza = actual.getSiguiente();

                } else {

                    /*
                     * El nodo anterior pasa a apuntar
                     * al siguiente del nodo actual,
                     * salteando el nodo eliminado.
                     */
                    anterior.setSiguiente(
                            actual.getSiguiente()
                    );
                }

                return;
            }

            anterior = actual;

            actual = actual.getSiguiente();
        }
    }

    /*
     * Calcular el tamaño de la lista.
     * 
     * Recorre todos los nodos
     * contando elementos.
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
     * Imprimir la lista enlazada.
     * 
     * Permite visualizar:
     * cabeza → nodo → nodo → null
     */
    public void imprimir() {

        Nodo actual = cabeza;

        System.out.print("cabeza → ");

        while (actual != null) {

            System.out.print(
                    "[" + actual.getDato() + "]"
            );

            System.out.print(" → ");

            actual = actual.getSiguiente();
        }

        System.out.println("null");
    }
}