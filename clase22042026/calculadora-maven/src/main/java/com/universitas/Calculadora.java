package com.universitas;

public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    //los métodos static son aquellos que se invocan directamente desde la clase sin necesidad de crear una instancia de la clase.
        public static int restar(int a, int b) {
            return a - b;
        }
        public int dividir(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }
            return a / b;
        }
}
