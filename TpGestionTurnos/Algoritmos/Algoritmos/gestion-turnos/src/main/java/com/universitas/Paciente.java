package com.universitas;

public class Paciente extends Persona {
    private String numeroAfiliado;

    public Paciente(String nombre, String apellido, String dni, String numeroAfiliado) {
        super(nombre, apellido, dni);
        this.numeroAfiliado = numeroAfiliado;
    }

    // Getters y Setters
    public String getNumeroAfiliado() { return numeroAfiliado; }
    public void setNumeroAfiliado(String numeroAfiliado) { this.numeroAfiliado = numeroAfiliado; }
}