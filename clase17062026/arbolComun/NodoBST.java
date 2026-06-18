package clase17062026.arbolComun;

public class NodoBST<T> {

    T dato;
    NodoBST<T> izquierdo;
    NodoBST<T> derecho;

    public NodoBST(T dato) {
        this.dato = dato;
    }
}

