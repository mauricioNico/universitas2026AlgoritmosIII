package com.universitas;

/**
 * Enum que representa las marcas de vehículos disponibles.
 * Incluye un nombre amigable para mostrar por pantalla.
 */
public enum Marca {

    TOYOTA("Toyota"),
    FORD("Ford"),
    CHEVROLET("Chevrolet"),
    VOLKSWAGEN("Volkswagen"),
    RENAULT("Renault"),
    PEUGEOT("Peugeot"),
    FIAT("Fiat"),
SCANIA("Scania"),
MERCEDES_BENZ("Mercedes-Benz"),
IVECO("Iveco"),
VOLVO("Volvo"),
HONDA("Honda"),
YAMAHA("Yamaha"),
BOEING("Boeing");
    private String nombre;

    /**
     * Constructor del enum.
     *
     * @param nombre Nombre amigable de la marca
     */
    Marca(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre amigable de la marca.
     *
     * @return nombre de la marca
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sobrescribe toString para mostrar el nombre amigable.
     *
     * @return nombre de la marca
     */
    @Override
    public String toString() {
        return nombre;
    }
}
