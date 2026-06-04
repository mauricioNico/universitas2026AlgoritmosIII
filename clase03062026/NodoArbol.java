public class NodoArbol{
    private int valor;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    public NodoArbol(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
    public int getValor() {
        return valor;
    }
    public NodoArbol getIzquierdo() {
        return izquierdo;
    }
    public NodoArbol getDerecho() {
        return derecho;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }   
    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
    
}