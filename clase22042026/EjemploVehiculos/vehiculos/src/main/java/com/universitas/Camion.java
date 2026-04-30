package com.universitas;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un camión.
 */
public class Camion extends Vehiculo {

    private Motor motor;
    private List<Rueda> ruedas;
    private double capacidadCarga;

    /**
     * Constructor del camión.
     *
     * @param marca           marca del camión
     * @param modelo          modelo del camión
     * @param tipoMotor       tipo de motor
     * @param cilindrada      cilindrada del motor
     * @param capacidadCarga  capacidad de carga en kg
     */
    public Camion(Marca marca, String modelo, String tipoMotor, int cilindrada, double capacidadCarga) {
        super(marca, modelo);
        this.motor = new Motor(tipoMotor, cilindrada);
        this.ruedas = new ArrayList<>();
        this.capacidadCarga = capacidadCarga;
    }

    /**
     * Agrega una rueda al camión.
     *
     * @param rueda rueda a agregar
     */
    public void agregarRueda(Rueda rueda) {
        if (rueda == null) {
            throw new IllegalArgumentException("La rueda no puede ser nula.");
        }
        if (ruedas.size() >= 10) {
            throw new IllegalStateException("Un camión no puede tener más de 10 ruedas en este modelo.");
        }
        ruedas.add(rueda);
    }

    /**
     * Devuelve el motor del camión.
     *
     * @return motor
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Devuelve la lista de ruedas.
     *
     * @return ruedas
     */
    public List<Rueda> getRuedas() {
        return ruedas;
    }

    /**
     * Devuelve la capacidad de carga.
     *
     * @return capacidad de carga en kg
     */
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== CAMIÓN ===");
        System.out.println("Marca: " + getMarca().getNombre());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Capacidad de carga: " + capacidadCarga + " kg");
        motor.mostrarInfo();
        System.out.println("Cantidad de ruedas: " + ruedas.size());

        for (int i = 0; i < ruedas.size(); i++) {
            System.out.print("Rueda " + (i + 1) + ": ");
            ruedas.get(i).mostrarInfo();
        }
    }
}
