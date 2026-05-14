package com.universitas;

import java.util.ArrayList;
import java.util.List;

public class Camion extends Vehiculo {

    private Motor motor;
    private List<Rueda> ruedas;
    private double capacidadCarga;

    public Camion(Marca marca, String modelo, String tipoMotor, int cilindrada, double capacidadCarga) {
        super(marca, modelo);
        this.motor = new Motor(tipoMotor, cilindrada);
        this.ruedas = new ArrayList<>();
        this.capacidadCarga = capacidadCarga;
    }

    public Motor getMotor() {
        return motor;
    }

    public List<Rueda> getRuedas() {
        return ruedas;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

   @Override
public void agregarRueda(Rueda rueda) {

    if (rueda == null) {
        throw new IllegalArgumentException(
                "La rueda no puede ser nula."
        );
    }

    if (ruedas.size() >= 10) {
        throw new IllegalArgumentException(
                "Un camión no puede tener más de 10 ruedas."
        );
    }

    ruedas.add(rueda);
}

    @Override
    public void mostrarInfo() {
        System.out.println("CAMION");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Motor: " + motor.getTipo() + " - " + motor.getCilindrada());
        System.out.println("Capacidad de carga: " + capacidadCarga);
        System.out.println("Ruedas: " + ruedas.size());
    }
}