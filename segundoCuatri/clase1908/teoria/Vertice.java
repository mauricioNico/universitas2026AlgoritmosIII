package teoria;

/**
 * Representa un vértice identificado por un nombre no nulo ni vacío.
 */
public class Vertice {
    private final String nombre;

    /**
     * Crea un vértice con el nombre indicado.
     *
     * @param nombre nombre que identifica al vértice
     * @throws IllegalArgumentException si {@code nombre} es {@code null} o está vacío
     */
    public Vertice(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del vértice no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre que identifica al vértice.
     *
     * @return el nombre del vértice
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve una representación textual del vértice y de su nombre.
     *
     * @return la representación textual del vértice
     */
    @Override
    public String toString() {
        return "Vertice [nombre=" + nombre + "]";
    }
}
