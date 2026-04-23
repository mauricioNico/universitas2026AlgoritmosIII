package ejemplosJava.clases;

public class Micro extends Vehiculo {
    private int cant_asientos;

    public int getCant_asientos() {
        return cant_asientos;
    }

    public void setCant_asientos(int cant_asientos) {
        this.cant_asientos = cant_asientos;
    }
    @Override
    public String toString() {
       
        return super.toString()+", cantidad de asientos: " + cant_asientos;
    }
}
