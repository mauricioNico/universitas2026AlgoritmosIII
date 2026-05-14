package com.universitas;

public class Motor {

    private String tipo;
    private int cilindrada;

    public Motor(String tipo, int cilindrada) {
        this.tipo = tipo;
        this.cilindrada = cilindrada;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}