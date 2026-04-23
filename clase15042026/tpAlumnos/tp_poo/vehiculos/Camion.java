package tp_poo.vehiculos;

public class Camion extends Vehiculo {
    //polimorfismo por redefinición (override)
    @Override
    public void acelerar() {
        System.out.println("El camión acelera lento por el peso de la carga.");
    }

    @Override
    public void frenar() {
        System.out.println("El camión frena con dificultad debido al peso de la carga.");
    }
}