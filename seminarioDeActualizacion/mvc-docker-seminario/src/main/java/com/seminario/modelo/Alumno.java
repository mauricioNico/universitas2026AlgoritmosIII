package com.seminario.modelo;

public class Alumno {

    private int id;
    private String nombre;
    private String carrera;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }
}
