package com.universitas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculadora calculadora = new Calculadora();
        int resultadoSuma = calculadora.sumar(5, 3);
        int resultadoResta = Calculadora.restar(5, 3);
        System.out.println("Resultado de la suma: " + resultadoSuma);
        System.out.println("Resultado de la resta: " + resultadoResta);
        int resultadoDivision = calculadora.dividir(10, 2);
        System.out.println("Resultado de la división: " + resultadoDivision);

    }
}
