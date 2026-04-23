package com.universitas;
import static
org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
public class CalculadoraTest {
    @Test
    public void testSumar() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.sumar(2, 3);
        assertEquals(5, resultado);
    }
@Test
    public void testRestar() {
        int resultado = Calculadora.restar(5, 2);
        assertEquals(3, resultado);
    }
    @Test
    public void testSumarNegativos() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.sumar(-2, -3);
        assertEquals(-5, resultado);
    }
    @Test
    public void testDivisionPorCero() {
        Calculadora calculadora = new Calculadora();
        assertThrows(ArithmeticException.class, () -> {
            int resultado = calculadora.dividir(10, 0);
        });
    }
}
