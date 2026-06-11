public class ArbolDos<T> {
    private NodoDos<T> raiz;

    public ArbolDos() {
        this.raiz = null;
    }

    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private NodoDos<T> insertarRecursivo(NodoDos<T> nodo, T valor) {
        if (nodo == null) {
            return new NodoDos<>(valor);
        }

        if (valor.toString().compareTo(nodo.getValor().toString()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), valor));
        } else if (valor.toString().compareTo(nodo.getValor().toString()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), valor));
        }

        return nodo;
    }
    
}
