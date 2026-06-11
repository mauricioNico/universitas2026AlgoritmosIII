public class NodoDos<T> {
    private T valor;
    private NodoDos<T> izquierdo;
    private NodoDos<T> derecho;
    public NodoDos(T valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
    public T getValor() {
        return valor;
    }
    public NodoDos<T> getIzquierdo() {
        return izquierdo;
    }
    public NodoDos<T> getDerecho() {
        return derecho;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public void setIzquierdo(NodoDos<T> izquierdo) {
        this.izquierdo = izquierdo;
    }   
    public void setDerecho(NodoDos<T> derecho) {
        this.derecho = derecho;
    }
}
