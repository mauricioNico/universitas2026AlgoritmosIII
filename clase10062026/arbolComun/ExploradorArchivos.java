package arbolComun;

public class ExploradorArchivos {

    private NodoArbolSistema raiz;

    public ExploradorArchivos(NodoArbolSistema raiz) {
        this.raiz = raiz;
    }

    public NodoArbolSistema getRaiz() {
        return raiz;
    }

    /*
     * Busca un archivo o carpeta por nombre utilizando DFS recursivo.
     */
    public NodoArbolSistema buscar(String nombreBuscado) {

        return buscarRecursivo(
                raiz,
                nombreBuscado);
    }

    private NodoArbolSistema buscarRecursivo(
            NodoArbolSistema actual,
            String nombreBuscado) {

        if (actual.getNombre()
                .equalsIgnoreCase(nombreBuscado)) {

            return actual;
        }

        for (NodoArbolSistema hijo :
                actual.getHijos()) {

            NodoArbolSistema encontrado =
                    buscarRecursivo(
                            hijo,
                            nombreBuscado);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    /*
     * Muestra la estructura completa del árbol.
     */
    public void mostrarEstructura() {

        mostrarRecursivo(
                raiz,
                "");
    }

    private void mostrarRecursivo(
            NodoArbolSistema actual,
            String espacios) {

        String tipo =
                actual.esCarpeta()
                        ? "[CARPETA] "
                        : "[ARCHIVO] ";

        System.out.println(
                espacios
                        + tipo
                        + actual.getNombre());

        for (NodoArbolSistema hijo :
                actual.getHijos()) {

            mostrarRecursivo(
                    hijo,
                    espacios + "   ");
        }
    }

    /*
     * Reconstruye la ruta completa
     * utilizando las referencias al padre.
     */
    public String obtenerRutaCompleta(
            NodoArbolSistema nodo) {

        StringBuilder ruta =
                new StringBuilder();

        NodoArbolSistema actual = nodo;

        while (actual != null) {

            if (ruta.length() == 0) {

                ruta.insert(
                        0,
                        actual.getNombre());

            } else {

                ruta.insert(
                        0,
                        actual.getNombre() + "\\");
            }

            actual = actual.getPadre();
        }

        return ruta.toString();
    }
}