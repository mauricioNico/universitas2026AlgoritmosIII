package com.universitas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfesionalTest {

    @Test
    void testConstructorYGetters() {
        Especialidad e = new Especialidad("Dermatología", "Piel");
        Profesional prof = new Profesional("Juan", "Perez", "44555666", "MP-10", e);
        
        assertEquals("Juan", prof.getNombre());
        assertEquals("MP-10", prof.getMatricula());
        assertEquals("Dermatología", prof.getEspecialidad().getNombre());
    }
}