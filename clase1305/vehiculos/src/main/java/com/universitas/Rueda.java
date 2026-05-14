package com.universitas;

public class Rueda {

    private String marca;
    private int diametro;

    public Rueda(String marca, int diametro) {
        this.marca = marca;
        this.diametro = diametro;
    }

    public String getMarca() {
        return marca;
    }

    public int getDiametro() {
        return diametro;
    }
}