package abstraccion.interfaces;

public class Computadora implements Dispositivo {
    @Override
    public void encender() {
        System.out.println("La computadora se ha encendido.");
    }
    @Override //los métodos default también pueden ser sobreescritos
    public void mostrarInfo() {
        System.out.println("Computadora equipada con procesador Intel y 16GB de RAM.    ");
          }
}
