package arbolComun;

import java.util.ArrayList;
import java.util.List;

public class NodoArbolSistema {
/**
 * atributos de un nodo en el árbol del sistema de archivos:
 * - nombre del nodo (archivo o carpeta)
 * - indicador de si es una carpeta o un archivo
 * ruta absoluta del nodo
 * referencia al nodo padre (null si es la raíz)
 * lista de nodos hijos (vacía si es un archivo)
 */
    private String nombre;
    private boolean esCarpeta;
    private String rutaAbsoluta;
    private NodoArbolSistema padre;
    private List<NodoArbolSistema> hijos;
/*
constructor que recibe el nombre del nodo, un indicador de si es una carpeta o un archivo, y la ruta absoluta. Inicializa la lista de hijos como vacía y establece el padre como null (se asignará posteriormente al agregarlo a otro nodo).
*/
    public NodoArbolSistema(String nombre, boolean esCarpeta, String rutaAbsoluta) {
        this.nombre = nombre;
        this.esCarpeta = esCarpeta;
        this.rutaAbsoluta = rutaAbsoluta;
        this.hijos = new ArrayList<>();
    }
/*
método para agregar un hijo al nodo. Establece la referencia al padre del hijo y lo agrega a la lista de hijos.
 */
    public void agregarHijo(NodoArbolSistema hijo) {
        hijo.setPadre(this);
        hijos.add(hijo);
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esCarpeta() {
        return esCarpeta;
    }

    public String getRutaAbsoluta() {
        return rutaAbsoluta;
    }

    public NodoArbolSistema getPadre() {
        return padre;
    }
/*
método para establecer la referencia al nodo padre. Este método es utilizado internamente al agregar un hijo a otro nodo para mantener la estructura del árbol correctamente.
*/
    public void setPadre(NodoArbolSistema padre) {
        this.padre = padre;
    }

    public List<NodoArbolSistema> getHijos() {
        return hijos;
    }
}
