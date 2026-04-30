package com.universitas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {

    @Test
    void testConstructorAutoValido() {
        Auto auto = new Auto(Marca.TOYOTA, "Corolla", "Nafta", 1800);

        assertAll(
            () -> assertNotNull(auto),
            () -> assertEquals(Marca.TOYOTA, auto.getMarca()),
            () -> assertEquals("Toyota", auto.getMarca().getNombre()),
            () -> assertEquals("Corolla", auto.getModelo()),
            () -> assertNotNull(auto.getMotor()),
            () -> assertEquals("Nafta", auto.getMotor().getTipo()),
            () -> assertEquals(1800, auto.getMotor().getCilindrada()),
            () -> assertNotNull(auto.getRuedas()),
            () -> assertEquals(0, auto.getRuedas().size())
        );
    }

    @Test
    void testAgregarHastaCincoRuedasDeMismaMedida() {
        Auto auto = new Auto(Marca.FORD, "Fiesta", "Nafta", 1600);

        for (int i = 0; i < 5; i++) {
            auto.agregarRueda(new Rueda("Pirelli", 15));
        }

        assertEquals(5, auto.getRuedas().size());
    }

    @Test
    void testAgregarMasDeCincoRuedasDebeFallar() {
        Auto auto = new Auto(Marca.FORD, "Focus", "Nafta", 2000);

        for (int i = 0; i < 5; i++) {
            auto.agregarRueda(new Rueda("Pirelli", 15));
        }

        IllegalStateException ex = assertThrows(
            IllegalStateException.class,
            () -> auto.agregarRueda(new Rueda("Pirelli", 15))
        );

        assertTrue(ex.getMessage().contains("más de 5 ruedas"));
    }

    @Test
    void testAgregarRuedaNulaDebeFallar() {
        Auto auto = new Auto(Marca.FORD, "Ka", "Nafta", 1000);

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> auto.agregarRueda(null)
        );

        assertTrue(ex.getMessage().contains("no puede ser nula"));
    }

    @Test
    void testAgregarRuedasDeDistintaMedidaDebeFallar() {
        Auto auto = new Auto(Marca.FORD, "Fiesta", "Nafta", 1600);

        auto.agregarRueda(new Rueda("Pirelli", 15));

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> auto.agregarRueda(new Rueda("Pirelli", 17))
        );

        assertTrue(ex.getMessage().contains("misma medida"));
    }
}