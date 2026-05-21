package listaEnlazada;

public class Nodo {

    private int dato;

    /*
     * Referencia al siguiente nodo.
     * 
     * Permite enlazar los nodos entre sí formando
     * la estructura de la lista enlazada.
     */
    //el atributo siguiente es un atributo recursivo (de la misma clase), ya que es una referencia a otro nodo de la misma clase. Esto permite crear una estructura de datos en la que cada nodo puede apuntar a otro nodo, formando así una cadena de nodos que constituye la lista enlazada.
    private Nodo siguiente;

    /*
     * Referencia al nodo anterior.
     * 
     * Se utiliza en listas doblemente enlazadas
     * para poder recorrer la lista hacia atrás.
     */
    private Nodo anterior;

    /*
     * Constructor del nodo.
     * 
     * Inicializa:
     * - el dato almacenado
     * - siguiente en null
     * - anterior en null
     */
    public Nodo(int dato) {

        this.dato = dato;

        this.siguiente = null;

        this.anterior = null;
    }

    /*
     * Getter y setter del dato
     */
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    /*
     * Getter y setter del nodo siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /*
     * Getter y setter del nodo anterior
     */
    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}