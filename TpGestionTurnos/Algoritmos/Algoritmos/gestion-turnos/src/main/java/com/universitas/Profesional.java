package com.universitas;

public class Profesional extends Persona {
    private String matricula;
    private Especialidad especialidad;

    public Profesional(String nombre, String apellido, String dni, String matricula, Especialidad especialidad) {
        super(nombre, apellido, dni);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }
}