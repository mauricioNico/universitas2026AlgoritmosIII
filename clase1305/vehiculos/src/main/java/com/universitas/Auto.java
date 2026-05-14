package com.universitas;

import java.util.ArrayList;
import java.util.List;

public class Auto extends Vehiculo {

    private Motor motor;
    private List<Rueda> ruedas;

    public Auto(Marca marca, String modelo, String tipoMotor, int cilindrada) {
        super(marca, modelo);
        this.motor = new Motor(tipoMotor, cilindrada);
        this.ruedas = new ArrayList<>();
    }

    public Motor getMotor() {
        return motor;
    }

    public List<Rueda> getRuedas() {
        return ruedas;
    }

@Override
public void agregarRueda(Rueda rueda) {

    if (rueda == null) {
        throw new IllegalArgumentException("La rueda no puede ser nula.");
    }

    if (ruedas.size() >= 5) {
        throw new IllegalArgumentException("Un auto no puede tener más de 5 ruedas.");
    }

    if (!ruedas.isEmpty()) {
        int diametroReferencia = ruedas.get(0).getDiametro();

        if (rueda.getDiametro() != diametroReferencia) {
            throw new IllegalArgumentException(
                    "Todas las ruedas del auto deben tener la misma medida."
            );
        }
    }

    ruedas.add(rueda);
}

    @Override
    public void mostrarInfo() {
        System.out.println("AUTO");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Motor: " + motor.getTipo() + " - " + motor.getCilindrada());
        System.out.println("Ruedas: " + ruedas.size());
    }
}