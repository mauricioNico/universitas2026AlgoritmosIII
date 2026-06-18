package clase17062026.arbolComun;

import java.io.File;
/* 
 * Clase que implementa un explorador de archivos basado en un árbol de nodos. Cada nodo representa un archivo o una carpeta en el sistema de archivos. La clase permite construir el árbol a partir de una ruta inicial, mostrar la estructura del árbol, buscar nodos por nombre y obtener la ruta completa de un nodo específico. Utiliza recursión para construir y mostrar el árbol, y para realizar búsquedas dentro del mismo.
 */
public class ExploradorArchivos {

    private NodoArbolSistema raiz;

    public ExploradorArchivos(String rutaInicial) {
        File archivo = new File(rutaInicial);

        if (!archivo.exists()) {
            throw new IllegalArgumentException("La ruta indicada no existe.");
        }

        this.raiz = construirArbol(archivo);
    }

    private NodoArbolSistema construirArbol(File file) {

        NodoArbolSistema nodo = new NodoArbolSistema(
                file.getName(),
                file.isDirectory(),
                file.getAbsolutePath()
        );

        if (file.isDirectory()) {

            File[] hijos = file.listFiles();

            if (hijos != null) {
                for (File hijo : hijos) {
                    NodoArbolSistema nodoHijo = construirArbol(hijo);
                    nodo.agregarHijo(nodoHijo);
                }
            }
        }

        return nodo;
    }

    public void mostrarEstructura() {
        mostrarRecursivo(raiz, "");
    }

    private void mostrarRecursivo(NodoArbolSistema actual, String espacios) {

        String tipo = actual.esCarpeta() ? "[CARPETA] " : "[ARCHIVO] ";

        System.out.println(espacios + tipo + actual.getNombre());

        for (NodoArbolSistema hijo : actual.getHijos()) {
            mostrarRecursivo(hijo, espacios + "   ");
        }
    }

    public NodoArbolSistema buscar(String nombreBuscado) {
        return buscarRecursivo(raiz, nombreBuscado);
    }

    private NodoArbolSistema buscarRecursivo(NodoArbolSistema actual, String nombreBuscado) {

        if (actual.getNombre().equalsIgnoreCase(nombreBuscado)) {
            return actual;
        }

        for (NodoArbolSistema hijo : actual.getHijos()) {

            NodoArbolSistema encontrado = buscarRecursivo(hijo, nombreBuscado);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    public String obtenerRutaCompleta(NodoArbolSistema nodo) {
        return nodo.getRutaAbsoluta();
    }

    public NodoArbolSistema getRaiz() {
        return raiz;
    }
}

