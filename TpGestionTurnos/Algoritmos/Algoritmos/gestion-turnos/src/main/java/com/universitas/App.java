package com.universitas;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Gestión de Turnos ---");

        // 1. Instanciar el sistema gestor
        SistemaTurnos sistema = new SistemaTurnos();

        // 2. Crear las entidades del modelo
        Especialidad cardiologia = new Especialidad("Cardiología", "Especialidad dedicada al corazón");
        Profesional drPerez = new Profesional("Juan", "Perez", "20111222", "MP-4455", cardiologia);
        Paciente pacienteGomez = new Paciente("Ana", "Gomez", "30333444", "OSDE-12345");
        Consultorio consultorio1 = new Consultorio(1, "Planta Baja");

        // 3. Registrar entidades en el sistema (todo en memoria)
        sistema.registrarProfesional(drPerez);
        sistema.registrarPaciente(pacienteGomez);
        sistema.registrarConsultorio(consultorio1);

        System.out.println("\nEntidades registradas correctamente en el sistema.");

        // 4. Agendar un turno utilizando LocalDate y LocalTime
        LocalDate fechaTurno = LocalDate.of(2023, 12, 15);
        LocalTime horaTurno = LocalTime.of(10, 30);
        
        System.out.println("\nAgendando el primer turno para " + pacienteGomez.getNombre() + " con el Dr. " + drPerez.getApellido() + "...");
        sistema.agendarTurno(pacienteGomez, drPerez, consultorio1, fechaTurno, horaTurno);
        
        // Obtener el turno recién agendado para probar sus métodos
        Turno turnoAgendado = sistema.getTurnos().get(0);
        System.out.println("Estado inicial del turno: " + turnoAgendado.getEstado());

        // 5. Probar la mejora opcional: Validar turno duplicado en el mismo horario
        System.out.println("\nIntentando agendar otro turno en el mismo horario para el mismo profesional...");
        Paciente otroPaciente = new Paciente("Carlos", "Lopez", "40555666", "SW-9876");
        sistema.agendarTurno(otroPaciente, drPerez, consultorio1, fechaTurno, horaTurno);

        // 6. Probar los métodos de negocio de la clase Turno: confirmar, reprogramar y cancelar[cite: 1]
        System.out.println("\nConfirmando el turno de Ana Gomez...");
        turnoAgendado.confirmar();
        System.out.println("Nuevo estado del turno: " + turnoAgendado.getEstado());

        System.out.println("\nReprogramando el turno...");
        LocalDate nuevaFecha = LocalDate.of(2023, 12, 16);
        LocalTime nuevaHora = LocalTime.of(11, 00);
        turnoAgendado.reprogramar(nuevaFecha, nuevaHora);
        System.out.println("Nuevo estado del turno: " + turnoAgendado.getEstado());
        System.out.println("Nueva fecha: " + turnoAgendado.getFecha() + " | Nueva hora: " + turnoAgendado.getHora());

        System.out.println("\nCancelando el turno...");
        turnoAgendado.cancelar();
        System.out.println("Estado final del turno: " + turnoAgendado.getEstado());
        
        System.out.println("\n--- Fin de la demostración ---");
    }
}