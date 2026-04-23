package tp_poo.vehiculos;
public class Auto extends Vehiculo {

    @Override
    public void acelerar() {
        System.out.println("El auto acelera rápido: brum brum!");
    }
    
    @Override
    public void frenar() {
        System.out.println("El auto clava los frenos con ABS.");
    }
}