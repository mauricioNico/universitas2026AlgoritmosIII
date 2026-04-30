package com.universitas;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica que permite representar distintos tipos de vehículos
 * sin necesidad de crear una clase específica para cada uno.
 *
 * @param <T> tipo del primer atributo específico
 * @param <U> tipo del segundo atributo específico
 */
public class VehiculoGenerico<T, U> extends Vehiculo {

    private String tipoVehiculo;
    private T atributo1;
    private U atributo2;
    private List<Rueda> ruedas;

    /**
     * Constructor de vehículo genérico.
     *
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param tipoVehiculo tipo de vehículo, por ejemplo Moto, Barco o Avión
     * @param atributo1 primer atributo específico
     * @param atributo2 segundo atributo específico
     */
    public VehiculoGenerico(Marca marca, String modelo, String tipoVehiculo, T atributo1, U atributo2) {
        super(marca, modelo);
        this.tipoVehiculo = tipoVehiculo;
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        this.ruedas = new ArrayList<>();
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public T getAtributo1() {
        return atributo1;
    }

    public U getAtributo2() {
        return atributo2;
    }

    public List<Rueda> getRuedas() {
        return ruedas;
    }

    /**
     * Agrega una rueda al vehículo genérico.
     *
     * @param rueda rueda a agregar
     */
    @Override
    public void agregarRueda(Rueda rueda) {
        if (rueda == null) {
            throw new IllegalArgumentException("La rueda no puede ser nula");
        }

        ruedas.add(rueda);
    }

    /**
     * Muestra la información del vehículo genérico.
     */
    @Override
    public void mostrarInfo() {
        System.out.println("Tipo de vehículo: " + tipoVehiculo);
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Atributo 1: " + atributo1);
        System.out.println("Atributo 2: " + atributo2);
        System.out.println("Cantidad de ruedas: " + ruedas.size());
    }
}
