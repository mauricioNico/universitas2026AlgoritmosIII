package com.universitas;


/**
 * Representa el motor de un vehículo.
 */
public class Motor {

    private String tipo;
    private int cilindrada;

    /**
     * Constructor del motor.
     *
     * @param tipo       tipo de motor
     * @param cilindrada cilindrada del motor en cc
     */
    public Motor(String tipo, int cilindrada) {
        this.tipo = tipo;
        this.cilindrada = cilindrada;
    }

    /**
     * Devuelve el tipo de motor.
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve la cilindrada del motor.
     *
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * Muestra la información del motor.
     */
    public void mostrarInfo() {
        System.out.println("Motor -> Tipo: " + tipo + ", Cilindrada: " + cilindrada + " cc");
    }
}