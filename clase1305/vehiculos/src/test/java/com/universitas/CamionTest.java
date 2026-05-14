package com.universitas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CamionTest {

    @Test
    void testConstructorCamionValido() {
        Camion camion = new Camion(Marca.SCANIA, "R450", "Diesel", 13000, 20000);

        assertNotNull(camion);
        assertEquals(Marca.SCANIA, camion.getMarca());
        assertEquals("R450", camion.getModelo());

        assertEquals(20000, camion.getCapacidadCarga());

        assertNotNull(camion.getMotor());
        assertEquals("Diesel", camion.getMotor().getTipo());
        assertEquals(13000, camion.getMotor().getCilindrada());

        assertNotNull(camion.getRuedas());
        assertEquals(0, camion.getRuedas().size());
    }

    @Test
    void testAgregarRuedasCamion() {
        Camion camion = new Camion(Marca.MERCEDES, "Actros", "Diesel", 12000, 18000);

        for (int i = 0; i < 6; i++) {
            camion.agregarRueda(new Rueda("Michelin", 22));
        }

        assertEquals(6, camion.getRuedas().size());
    }

    @Test
    void testAgregarMasDeDiezRuedasDebeFallar() {
        Camion camion = new Camion(Marca.IVECO, "Hi-Way", "Diesel", 13000, 22000);

        for (int i = 0; i < 10; i++) {
            camion.agregarRueda(new Rueda("Pirelli", 22));
        }

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            camion.agregarRueda(new Rueda("Pirelli", 22));
        });

        assertTrue(ex.getMessage().contains("más de 10 ruedas"));
    }

    @Test
    void testAgregarRuedaNulaDebeFallar() {
        Camion camion = new Camion(Marca.VOLVO, "FH", "Diesel", 14000, 25000);

        assertThrows(IllegalArgumentException.class, () -> {
            camion.agregarRueda(null);
        });
    }
}