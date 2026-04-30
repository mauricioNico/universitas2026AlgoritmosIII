package com.universitas;

/**
 * Clase principal para probar el modelo.
 */
public class App {

    public static void main(String[] args) 
    {Marca marcaAuto = Marca.TOYOTA;
        Marca marcaCamion = Marca.FORD;
        Auto auto = new Auto(marcaAuto, "Corolla", "Nafta", 1800);
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16));
        auto.agregarRueda(new Rueda("Michelin", 16)); // Intento de agregar una rueda extra (debería lanzar excepción)

        Camion camion = new Camion(marcaCamion, "R450", "Diesel", 13000, 20000);
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
        camion.agregarRueda(new Rueda("Pirelli", 22));
VehiculoGenerico<Integer, String> moto =
        new VehiculoGenerico<>(Marca.HONDA, "XR150", "Moto", 150, "Enduro");

VehiculoGenerico<Double, String> barco =
        new VehiculoGenerico<>(Marca.YAMAHA, "WaveRunner", "Barco", 3.5, "Motor fuera de borda");

VehiculoGenerico<Integer, Boolean> avion =
        new VehiculoGenerico<>(Marca.BOEING, "737", "Avión", 180, true);
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
        servicio.realizarService(moto);
        servicio.realizarService(barco);
        servicio.realizarService(avion);
    }
}