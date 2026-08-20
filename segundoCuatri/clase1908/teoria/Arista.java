package teoria;

/**
 * Representa una arista dirigida entre un vértice de origen y uno de destino.
 */
public class Arista {
    private final Vertice origen;
    private final Vertice destino;

    /**
     * Crea una arista con los extremos indicados.
     *
     * @param origen vértice desde el que parte la arista
     * @param destino vértice al que llega la arista
     * @throws IllegalArgumentException si {@code origen} o {@code destino} es {@code null}
     */
    public Arista(Vertice origen, Vertice destino) {
        if (origen == null || destino == null) {
            throw new IllegalArgumentException("El origen y el destino no pueden ser nulos");
        }
        this.origen = origen;
        this.destino = destino;
    }

    /**
     * Obtiene el vértice de origen.
     *
     * @return el origen de la arista
     */
    public Vertice getOrigen() {
        return origen;
    }

    /**
     * Obtiene el vértice de destino.
     *
     * @return el destino de la arista
     */
    public Vertice getDestino() {
        return destino;
    }
}
