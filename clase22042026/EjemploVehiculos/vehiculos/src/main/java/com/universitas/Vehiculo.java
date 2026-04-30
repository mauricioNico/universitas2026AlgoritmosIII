package com.universitas;

/**
 * Clase abstracta que representa un vehículo genérico.
 */
public abstract class Vehiculo {

    private Marca marca;
    private String modelo;

    /**
     * Constructor base de vehículo.
     *
     * @param marca  marca del vehículo (enum Marca)
     * @param modelo modelo del vehículo
     */
    public Vehiculo(Marca marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Devuelve la marca del vehículo.
     *
     * @return marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * Devuelve el modelo del vehículo.
     *
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método abstracto para agregar ruedas.
     * Cada tipo de vehículo implementa su propia lógica.
     *
     * @param rueda rueda a agregar
     */
    public abstract void agregarRueda(Rueda rueda);

    /**
     * Muestra la información del vehículo.
     * Debe ser implementado por las clases hijas.
     */
    public abstract void mostrarInfo();
}