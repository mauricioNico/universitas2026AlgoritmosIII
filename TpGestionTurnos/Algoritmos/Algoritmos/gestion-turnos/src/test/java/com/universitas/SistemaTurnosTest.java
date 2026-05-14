package com.universitas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class SistemaTurnosTest {
    private SistemaTurnos sistema;
    private Paciente paciente;
    private Profesional profesional;
    private Consultorio consultorio;

    @BeforeEach
    void setUp() {
        sistema = new SistemaTurnos();
        paciente = new Paciente("Ana", "G", "111", "OS-1");
        profesional = new Profesional("Dr", "Perez", "222", "MP-1", new Especialidad("Cardio", "C"));
        consultorio = new Consultorio(1, "A");
        
        sistema.registrarPaciente(paciente);
        sistema.registrarProfesional(profesional);
        sistema.registrarConsultorio(consultorio);
    }

    @Test
    void testRegistrarEntidadesEnColecciones() {
        assertEquals(1, sistema.getPacientes().size());
        assertEquals(1, sistema.getProfesionales().size());
        assertEquals(1, sistema.getConsultorios().size());
    }

    @Test
    void testAgendarTurnoExitoso() {
        boolean resultado = sistema.agendarTurno(paciente, profesional, consultorio, LocalDate.now(), LocalTime.now());
        assertTrue(resultado);
        assertEquals(1, sistema.getTurnos().size());
    }

    @Test
    void testValidacionTurnoDuplicado() {
        LocalDate fecha = LocalDate.of(2023, 10, 10);
        LocalTime hora = LocalTime.of(15, 30);
        
        // Primer turno (debe ser exitoso)
        boolean turno1 = sistema.agendarTurno(paciente, profesional, consultorio, fecha, hora);
        assertTrue(turno1);
        
        // Segundo turno en mismo horario y profesional (debe fallar según la mejora opcional)
        Paciente paciente2 = new Paciente("Luis", "M", "333", "OS-2");
        boolean turno2 = sistema.agendarTurno(paciente2, profesional, consultorio, fecha, hora);
        assertFalse(turno2);
        
        // Verificamos que solo se guardó un turno en la colección
        assertEquals(1, sistema.getTurnos().size());
    }
}