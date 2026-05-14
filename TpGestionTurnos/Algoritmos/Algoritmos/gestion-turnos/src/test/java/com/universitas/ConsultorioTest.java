package com.universitas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConsultorioTest {

    @Test
    void testConstructorYGetters() {
        Consultorio c = new Consultorio(10, "Piso 1");
        assertEquals(10, c.getNumero());
        assertEquals("Piso 1", c.getSector());
    }

    @Test
    void testSetters() {
        Consultorio c = new Consultorio(0, "");
        c.setNumero(20);
        c.setSector("Planta Baja");
        assertEquals(20, c.getNumero());
        assertEquals("Planta Baja", c.getSector());
    }
}