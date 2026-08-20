package ejercicioIntegrador;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Representa un grafo no dirigido cuyos vértices se identifican mediante cadenas.
 * Cada arista se almacena en ambos sentidos, por lo que la relación entre dos
 * vértices es bidireccional. Los vértices y sus vecinos se mantienen ordenados.
 */
public class GrafoNoDirigido {
    private final Map<String, Set<String>> adyacencias = new TreeMap<>();

    /**
     * Agrega un vértice al grafo. Si ya existe, conserva su conjunto de vecinos.
     *
     * @param vertice nombre del vértice que se desea agregar
     * @throws IllegalArgumentException si {@code vertice} es {@code null} o está vacío
     */
    public void agregarVertice(String vertice) {
        validarVertice(vertice);
        adyacencias.putIfAbsent(vertice, new TreeSet<>());
    }

    /**
     * Agrega una arista bidireccional entre dos vértices existentes. Si la arista
     * ya existe, el grafo no se modifica.
     *
     * @param a primer extremo de la arista
     * @param b segundo extremo de la arista
     * @throws IllegalArgumentException si alguno de los vértices no existe en el grafo
     */
    public void agregarArista(String a, String b) {
        validarExistencia(a);
        validarExistencia(b);
        adyacencias.get(a).add(b);
        adyacencias.get(b).add(a);
    }
    /**
     * Obtiene una vista de solo lectura de los vecinos de un vértice.
     *
     * @param vertice vértice cuyos vecinos se desean consultar
     * @return conjunto no modificable y ordenado de vértices vecinos
     * @throws IllegalArgumentException si el vértice no existe en el grafo
     */
    public Set<String> obtenerVecinos(String vertice) {
        validarExistencia(vertice);
        return Collections.unmodifiableSet(adyacencias.get(vertice));
    }
    /**
     * Calcula el grado de un vértice, es decir, su cantidad de vecinos.
     *
     * @param vertice vértice cuyo grado se desea calcular
     * @return cantidad de vecinos del vértice
     * @throws IllegalArgumentException si el vértice no existe en el grafo
     */
    public int obtenerGrado(String vertice) {
        return obtenerVecinos(vertice).size();
    }
    /**
     * Comprueba si dos vértices existentes están conectados directamente.
     *
     * @param a primer vértice que se desea comprobar
     * @param b segundo vértice que se desea comprobar
     * @return {@code true} si existe una arista entre ambos; {@code false} en caso contrario
     * @throws IllegalArgumentException si alguno de los vértices no existe en el grafo
     */
    public boolean existeArista(String a, String b) {
        validarExistencia(a);
        validarExistencia(b);
        return adyacencias.get(a).contains(b);
    }
    /**
     * Muestra el grafo en la salida estándar como una lista de adyacencia.
     * Cada línea contiene un vértice y el conjunto de vértices conectados
     * directamente con él, con el formato
     * {@code vértice -> [vecino1, vecino2, ...]}.
     * Tanto los vértices como sus listas de vecinos se muestran en orden
     * alfabético. Un vértice sin vecinos se representa como
     * {@code vértice -> []}.
     */
    public void mostrar() {
        adyacencias.forEach((vertice, vecinos) ->
            System.out.println(vertice + " -> " + vecinos));
    }
    /**
     * Valida que un nombre pueda utilizarse como vértice.
     *
     * @param vertice nombre que se desea validar
     * @throws IllegalArgumentException si {@code vertice} es {@code null} o está vacío
     */
    private void validarVertice(String vertice) {
        if (vertice == null || vertice.isEmpty()) {
            throw new IllegalArgumentException("El vértice no puede ser nulo o vacío.");
        }
    }

    /**
     * Valida que un vértice se encuentre registrado en el grafo.
     *
     * @param vertice vértice cuya existencia se desea verificar
     * @throws IllegalArgumentException si el vértice no existe en el grafo
     */
    private void validarExistencia(String vertice) {
        if (!adyacencias.containsKey(vertice)) {
            throw new IllegalArgumentException("El vértice " + vertice + " no existe en el grafo.");
        }
    }
}
