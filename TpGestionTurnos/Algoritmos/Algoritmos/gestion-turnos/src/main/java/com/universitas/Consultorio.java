package com.universitas;

public class Consultorio {
    private int numero;
    private String sector;

    public Consultorio(int numero, String sector) {
        this.numero = numero;
        this.sector = sector;
    }

    // Getters y Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }
}