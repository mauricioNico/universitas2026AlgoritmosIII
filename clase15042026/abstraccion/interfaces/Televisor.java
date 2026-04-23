package abstraccion.interfaces;

public class Televisor implements Dispositivo {
    @Override
    public void encender() {
        System.out.println("El televisor se ha encendido.");
    }
}