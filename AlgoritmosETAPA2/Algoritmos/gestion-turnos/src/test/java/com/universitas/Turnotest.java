package com.universitas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.universitas.modelo.Consultorio;
import com.universitas.modelo.Especialidad;
import com.universitas.modelo.Paciente;
import com.universitas.modelo.Profesional;
import com.universitas.modelo.Turno;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

    private Turno turno;
    private Paciente paciente;
    private Profesional profesional;
    private Consultorio consultorio;
    private LocalDate fecha;
    private LocalTime hora;

    @BeforeEach
    void setUp() {
        paciente = new Paciente("Ana", "Gomez", "11222333", "OS-1");
        profesional = new Profesional("Dr", "Perez", "44555666", "MP-10",
                new Especialidad("Cardiología", "Corazón"));
        consultorio = new Consultorio(5, "Piso 2");
        fecha = LocalDate.of(2025, 6, 15);
        hora = LocalTime.of(10, 30);
        turno = new Turno(paciente, profesional, consultorio, fecha, hora);
    }

    @Test
    void testEstadoInicialEsPendiente() {
        assertEquals("Pendiente", turno.getEstado());
    }

    @Test
    void testConfirmarCambiaEstado() {
        turno.confirmar();
        assertEquals("Confirmado", turno.getEstado());
    }

    @Test
    void testCancelarCambiaEstado() {
        turno.cancelar();
        assertEquals("Cancelado", turno.getEstado());
    }

    @Test
    void testReprogramarCambiaFechaHoraYEstado() {
        LocalDate nuevaFecha = LocalDate.of(2025, 7, 20);
        LocalTime nuevaHora = LocalTime.of(14, 0);
        turno.reprogramar(nuevaFecha, nuevaHora);

        assertEquals("Reprogramado", turno.getEstado());
        assertEquals(nuevaFecha, turno.getFecha());
        assertEquals(nuevaHora, turno.getHora());
    }

    @Test
    void testGetPaciente() {
        assertEquals(paciente, turno.getPaciente());
    }

    @Test
    void testGetProfesional() {
        assertEquals(profesional, turno.getProfesional());
    }

    @Test
    void testGetConsultorio() {
        assertEquals(consultorio, turno.getConsultorio());
    }

    @Test
    void testGetFecha() {
        assertEquals(fecha, turno.getFecha());
    }

    @Test
    void testGetHora() {
        assertEquals(hora, turno.getHora());
    }

    @Test
    void testSetPaciente() {
        Paciente nuevoPaciente = new Paciente("Luis", "M", "99888777", "OS-2");
        turno.setPaciente(nuevoPaciente);
        assertEquals("Luis", turno.getPaciente().getNombre());
    }

    @Test
    void testSetProfesional() {
        Profesional nuevo = new Profesional("Dra", "Lopez", "77666555", "MP-20",
                new Especialidad("Pediatría", "Niños"));
        turno.setProfesional(nuevo);
        assertEquals("Dra", turno.getProfesional().getNombre());
    }

    @Test
    void testSetConsultorio() {
        Consultorio nuevo = new Consultorio(10, "Planta Baja");
        turno.setConsultorio(nuevo);
        assertEquals(10, turno.getConsultorio().getNumero());
    }

    @Test
    void testSetFecha() {
        LocalDate nueva = LocalDate.of(2026, 1, 1);
        turno.setFecha(nueva);
        assertEquals(nueva, turno.getFecha());
    }

    @Test
    void testSetHora() {
        LocalTime nueva = LocalTime.of(9, 0);
        turno.setHora(nueva);
        assertEquals(nueva, turno.getHora());
    }

    @Test
    void testConfirmarLuegoDeReprogramar() {
        turno.reprogramar(LocalDate.of(2025, 8, 1), LocalTime.of(11, 0));
        turno.confirmar();
        assertEquals("Confirmado", turno.getEstado());
    }
}
