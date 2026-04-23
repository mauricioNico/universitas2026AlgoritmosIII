package com.universitas;

/**
 * Clase principal para probar el modelo.
 */
public class App {

    public static void main(String[] args) {
        Auto auto = new Auto("Toyota", "Corolla", "Nafta", 1800);
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16)); // Intento de agregar una rueda extra (debería lanzar excepción)

        Camion camion = new Camion("Scania", "R450", "Diesel", 13000, 20000);
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));

        ServicioVehiculo servicio = new ServicioVehiculo();

        System.out.println();
        auto.mostrarInfo();

        System.out.println();
        camion.mostrarInfo();

        System.out.println();
        servicio.realizarService(auto);
        servicio.cambiarAceite(auto);
        servicio.diagnosticar(auto);

        System.out.println();
        servicio.realizarService(camion);
        servicio.cambiarAceite(camion);
        servicio.diagnosticar(camion);
    }
}