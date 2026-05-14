package com.universitas;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private Paciente paciente;
    private Profesional profesional;
    private Consultorio consultorio;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado; //pendiente, confirmado, cancelado, reprogramado

    public Turno(Paciente paciente, Profesional profesional, Consultorio consultorio, LocalDate fecha, LocalTime hora) {
        this.paciente = paciente;
        this.profesional = profesional;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = "Pendiente"; // Por defecto, un turno nuevo está pendiente
    }

    // Métodos de negocio requeridos
    public void confirmar() {
        this.estado = "Confirmado";
    }

    public void cancelar() {
        this.estado = "Cancelado";
    }

    public void reprogramar(LocalDate nuevaFecha, LocalTime nuevaHora) {
        this.fecha = nuevaFecha;
        this.hora = nuevaHora;
        this.estado = "Reprogramado";
    }

    // Getters y Setters
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Profesional getProfesional() { return profesional; }
    public void setProfesional(Profesional profesional) { this.profesional = profesional; }

    public Consultorio getConsultorio() { return consultorio; }
    public void setConsultorio(Consultorio consultorio) { this.consultorio = consultorio; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}