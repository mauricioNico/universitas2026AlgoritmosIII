package com.universitas.app;

import com.universitas.modelo.*;
import com.universitas.dao.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Gestión de Turnos con BD ---");

        // 1. Instanciar los DAOs
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
        ConsultorioDAO consultorioDAO = new ConsultorioDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        ProfesionalDAO profesionalDAO = new ProfesionalDAO();
        TurnoDAO turnoDAO = new TurnoDAO();

        // 2. Crear las entidades del modelo
        Especialidad cardiologia = new Especialidad("Cardiología", "Corazón");
        Consultorio consultorio1 = new Consultorio(1, "Planta Baja");
        Paciente pacienteGomez = new Paciente("Ana", "Gomez", "30333444", "OSDE-123");
        Profesional drPerez = new Profesional("Juan", "Perez", "20111222", "MP-4455", cardiologia);
        
        // 3. Guardar las entidades base PRIMERO (para que no fallen las llaves foráneas)
        System.out.println("\nRegistrando datos base en MySQL...");
        especialidadDAO.guardar(cardiologia);
        consultorioDAO.guardar(consultorio1);
        pacienteDAO.guardar(pacienteGomez);
        
        // El Profesional busca la Especialidad en la BD al guardarse
        profesionalDAO.guardar(drPerez);

        // 4. Crear y guardar un Turno
        System.out.println("\nAgendando turno en la BD...");
        LocalDate fechaTurno = LocalDate.of(2023, 12, 15);
        LocalTime horaTurno = LocalTime.of(10, 30);
        
        Turno nuevoTurno = new Turno(pacienteGomez, drPerez, consultorio1, fechaTurno, horaTurno);
        // Confirmamos el turno antes de guardarlo
        nuevoTurno.confirmar(); 
        
        // El Turno busca los IDs del paciente, profesional y consultorio en la BD al guardarse
        turnoDAO.guardar(nuevoTurno);
        
        System.out.println("\n--- Fin de la demostración ---");
    }
}