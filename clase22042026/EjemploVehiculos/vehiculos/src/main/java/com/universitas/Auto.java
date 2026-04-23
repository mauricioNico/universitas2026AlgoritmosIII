package com.universitas;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un auto.
 */
public class Auto extends Vehiculo {

    private Motor motor;
    private List<Rueda> ruedas;

    /**
     * Constructor del auto.
     *
     * @param marca       marca del auto
     * @param modelo      modelo del auto
     * @param tipoMotor   tipo de motor
     * @param cilindrada  cilindrada del motor
     */
    public Auto(String marca, String modelo, String tipoMotor, int cilindrada) {
        super(marca, modelo);
        this.motor = new Motor(tipoMotor, cilindrada);
        this.ruedas = new ArrayList<>();
    }

    @Override
    /**
     * Agrega una rueda al auto.
     *
     * @param rueda rueda a agregar
     */
    public void agregarRueda(Rueda rueda) {
    if (rueda == null) {
        throw new IllegalArgumentException("La rueda no puede ser nula.");
    }

    if (ruedas.size() >= 5) {
        throw new IllegalStateException("Un auto no puede tener más de 5 ruedas en este modelo.");
    }

    // 🔴 Validación de misma medida
    if (!ruedas.isEmpty()) { //!si no es vacío el array de ruedas, entonces se compara la medida de la nueva rueda con la medida de la primera rueda del auto.
        int medidaBase = ruedas.get(0).getMedida();
        if (rueda.getMedida() != medidaBase) {
            throw new IllegalArgumentException("Todas las ruedas deben tener la misma medida.");
        }
    }

    ruedas.add(rueda);
}

    /**
     * Devuelve el motor del auto.
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

    @Override
    public void mostrarInfo() {
        System.out.println("=== AUTO ===");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        motor.mostrarInfo();
        System.out.println("Cantidad de ruedas: " + ruedas.size());

        for (int i = 0; i < ruedas.size(); i++) {
            System.out.print("Rueda " + (i + 1) + ": ");
            ruedas.get(i).mostrarInfo();
        }
    }
}