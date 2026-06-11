package casero;
public class NodoArbol<T> {
//T implica que es un generico, es decir, puede ser de cualquier tipo de dato 
// (Integer, String, Object, etc.) se establece el tipo en ejecución, lo que proporciona
//  flexibilidad y reutilización del código.
    T dato;
    NodoArbol<T> izquierdo;
    NodoArbol<T> derecho;

    //Constructor   
    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
    //Getters y Setters
    public T getValor() {
        return dato;
    }
    public NodoArbol<T> getIzquierdo() {
        return izquierdo;
    }
    public NodoArbol<T> getDerecho() {
        return derecho;
    }
    public void setIzquierdo(NodoArbol<T> izquierdo) {
        this.izquierdo = izquierdo;
    }
    public void setDerecho(NodoArbol<T> derecho) {
        this.derecho = derecho;
    }
    public void setValor(T dato) {
        this.dato = dato;
    }
}
