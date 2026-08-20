package teoria;

/**
 * Demuestra la creación de vértices y de una arista dirigida entre ellos.
 */
public class GrafoGeneral {
    /**
     * Construye una arista de ejemplo y muestra sus extremos en la consola.
     *
     * @param args argumentos de línea de comandos; no se utilizan
     */
     public static void main(String[] args) {
        Vertice v1 = new Vertice("La Plata");
        Vertice v2 = new Vertice("Buenos Aires");
    Arista a1 = new Arista(v1, v2);
        System.out.println("Arista: " + a1.getOrigen().getNombre() + " -> " + a1.getDestino().getNombre());
    }}
    

