package com.universitas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {
    private Turno turno;

    @BeforeEach
    void setUp() {
        Paciente p = new Paciente("A", "B", "1", "2");
        Profesional prof = new Profesional("C", "D", "3", "4", new Especialidad("E", "F"));
        Consultorio c = new Consultorio(1, "G");
        turno = new Turno(p, prof, c, LocalDate.of(2023, 1, 1), LocalTime.of(10, 0));
    }

    @Test
    void testEstadoInicial() {
        assertEquals("Pendiente", turno.getEstado());
    }

    @Test
    void testConfirmar() {
        turno.confirmar();
        assertEquals("Confirmado", turno.getEstado());
    }

    @Test
    void testCancelar() {
        turno.cancelar();
        assertEquals("Cancelado", turno.getEstado());
    }

    @Test
    void testReprogramar() {
        LocalDate nuevaFecha = LocalDate.of(2023, 1, 2);
        LocalTime nuevaHora = LocalTime.of(11, 0);
        turno.reprogramar(nuevaFecha, nuevaHora);
        
        assertEquals("Reprogramado", turno.getEstado());
        assertEquals(nuevaFecha, turno.getFecha());
        assertEquals(nuevaHora, turno.getHora());
    }
}