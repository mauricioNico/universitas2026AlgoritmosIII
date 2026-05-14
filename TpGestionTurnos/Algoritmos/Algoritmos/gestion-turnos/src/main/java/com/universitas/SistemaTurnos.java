package com.universitas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaTurnos {
    // El sistema administra colecciones de objetos en memoria
    private List<Turno> turnos;
    private List<Paciente> pacientes;
    private List<Profesional> profesionales;
    private List<Consultorio> consultorios;

    public SistemaTurnos() {
        this.turnos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.profesionales = new ArrayList<>();
        this.consultorios = new ArrayList<>();
    }

    // Métodos para registrar entidades en el sistema
    public void registrarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public void registrarProfesional(Profesional profesional) {
        this.profesionales.add(profesional);
    }

    public void registrarConsultorio(Consultorio consultorio) {
        this.consultorios.add(consultorio);
    }

    // Método de negocio para administrar turnos
    public boolean agendarTurno(Paciente paciente, Profesional profesional, Consultorio consultorio, LocalDate fecha, LocalTime hora) {
        // Mejora opcional: Validar que un profesional no tenga dos turnos en el mismo horario[cite: 1]
        for (Turno t : turnos) {
            if (t.getProfesional().equals(profesional) && 
                t.getFecha().equals(fecha) && 
                t.getHora().equals(hora) && 
                !t.getEstado().equals("Cancelado")) {
                System.out.println("Error: El profesional ya tiene un turno asignado en ese horario.");
                return false;
            }
        }
        
        Turno nuevoTurno = new Turno(paciente, profesional, consultorio, fecha, hora);
        this.turnos.add(nuevoTurno);
        return true;
    }

    // Getters para las colecciones (necesarios para los tests)
    public List<Turno> getTurnos() { return turnos; }
    public List<Paciente> getPacientes() { return pacientes; }
    public List<Profesional> getProfesionales() { return profesionales; }
    public List<Consultorio> getConsultorios() { return consultorios; }
}