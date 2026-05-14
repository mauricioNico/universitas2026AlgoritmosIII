package com.universitas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void testConstructorYGetters() {
        Paciente p = new Paciente("Ana", "Gomez", "11222333", "OS-123");
        assertEquals("Ana", p.getNombre());
        assertEquals("Gomez", p.getApellido());
        assertEquals("11222333", p.getDni());
        assertEquals("OS-123", p.getNumeroAfiliado());
    }

    @Test
    void testSetters() {
        Paciente p = new Paciente("", "", "", "");
        p.setNombre("Luis");
        p.setNumeroAfiliado("OS-456");
        assertEquals("Luis", p.getNombre());
        assertEquals("OS-456", p.getNumeroAfiliado());
    }
}