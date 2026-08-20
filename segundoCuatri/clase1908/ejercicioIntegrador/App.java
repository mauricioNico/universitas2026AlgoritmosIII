package ejercicioIntegrador;

/**
 * Ejecuta un ejemplo de uso de {@link GrafoNoDirigido}.
 */
public class App {
    /**
     * Construye un grafo de ciudades, muestra sus conexiones y consulta el grado
     * de uno de sus vértices.
     *
     * @param args argumentos de línea de comandos; no se utilizan
     */
    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();

        grafo.agregarVertice("Buenos Aires");
        grafo.agregarVertice("Rosario");
        grafo.agregarVertice("Córdoba");
        grafo.agregarVertice("Mendoza");

        grafo.agregarArista("Buenos Aires", "Rosario");
        grafo.agregarArista("Buenos Aires", "Córdoba");
        grafo.agregarArista("Rosario", "Córdoba");
        grafo.agregarArista("Córdoba", "Mendoza");

        grafo.mostrar();
        System.out.println("Grado de Córdoba: "
                + grafo.obtenerGrado("Córdoba"));
    }

}
