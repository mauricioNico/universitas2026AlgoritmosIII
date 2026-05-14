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
     * @param marca  marca del vehículo
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
//obliga a las clases derivadas a implementar este método para agregar ruedas, ya que cada tipo de vehículo puede tener una cantidad diferente de ruedas.
public abstract void agregarRueda(Rueda rueda);

    /**
     * Muestra la información del vehículo.
     */
    public abstract void mostrarInfo();
}