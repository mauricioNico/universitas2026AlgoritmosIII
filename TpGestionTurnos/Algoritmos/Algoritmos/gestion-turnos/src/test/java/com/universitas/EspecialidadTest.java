package com.universitas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {

    @Test
    void testConstructorYGetters() {
        Especialidad e = new Especialidad("Cardiología", "Corazón");
        assertEquals("Cardiología", e.getNombre());
        assertEquals("Corazón", e.getDescripcion());
    }

    @Test
    void testSetters() {
        Especialidad e = new Especialidad("", "");
        e.setNombre("Pediatría");
        e.setDescripcion("Niños");
        assertEquals("Pediatría", e.getNombre());
        assertEquals("Niños", e.getDescripcion());
    }
}