package com.universitas;

/**
 * Representa un servicio técnico para vehículos.
 * Esta clase depende de Vehiculo, ya que lo usa como parámetro,
 * pero no lo almacena como atributo.
 */
public class ServicioVehiculo {

    /**
     * Realiza un service general al vehículo.
     *
     * @param vehiculo vehículo a inspeccionar
     */
    public void realizarService(Vehiculo vehiculo) {
        System.out.println(">>> Realizando service general del vehículo...");
        vehiculo.mostrarInfo();
    }

    /**
     * Simula un cambio de aceite.
     *
     * @param vehiculo vehículo al que se le cambia el aceite
     */
    public void cambiarAceite(Vehiculo vehiculo) {
        System.out.println(">>> Cambiando aceite del vehículo " +
                vehiculo.getMarca() + " " + vehiculo.getModelo());
    }

    /**
     * Simula un diagnóstico técnico.
     *
     * @param vehiculo vehículo a diagnosticar
     */
    public void diagnosticar(Vehiculo vehiculo) {
        System.out.println(">>> Ejecutando diagnóstico sobre " +
                vehiculo.getMarca() + " " + vehiculo.getModelo());
    }
}