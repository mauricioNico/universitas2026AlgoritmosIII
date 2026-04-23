package com.universitas;

/**
 * Representa una rueda de un vehículo.
 */
public class Rueda {

    private String marca;
    private int medida;

    /**
     * Constructor de rueda.
     *
     * @param marca  marca de la rueda
     * @param medida medida de la rueda
     */
    public Rueda(String marca, int medida) {
        this.marca = marca;
        this.medida = medida;
    }

    /**
     * Devuelve la marca de la rueda.
     *
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve la medida de la rueda.
     *
     * @return medida
     */
    public int getMedida() {
        return medida;
    }

    /**
     * Muestra la información de la rueda.
     */
    public void mostrarInfo() {
        System.out.println("Rueda -> Marca: " + marca + ", Medida: " + medida);
    }
}
