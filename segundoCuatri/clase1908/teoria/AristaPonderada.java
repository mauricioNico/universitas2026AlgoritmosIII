package teoria;

/**
 * Representa una conexión hacia un destino con una distancia expresada en kilómetros.
 *
 * @param destino nombre del vértice de destino
 * @param km distancia no negativa hasta el destino, en kilómetros
 */
public record AristaPonderada(String destino, int km) {
    /**
     * Valida los componentes al construir una arista ponderada.
     *
     * @param destino nombre del vértice de destino
     * @param km distancia no negativa hasta el destino, en kilómetros
     * @throws IllegalArgumentException si {@code destino} es {@code null} o está vacío,
     *                                  o si {@code km} es negativo
     */
   public AristaPonderada {
      if (destino == null || destino.isEmpty()) {
         throw new IllegalArgumentException("El destino no puede ser nulo o vacío");
      }
      if (km < 0) {
         throw new IllegalArgumentException("La distancia en km no puede ser negativa");
      }
   }
}
