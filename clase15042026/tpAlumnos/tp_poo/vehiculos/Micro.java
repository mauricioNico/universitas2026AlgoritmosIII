package tp_poo.vehiculos;

public class Micro extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("El micro arranca suave para no marear a los pasajeros.");
    }

    @Override
    public void frenar() {
        System.out.println("El micro frena de a poco usando el freno motor.");
    }
}
