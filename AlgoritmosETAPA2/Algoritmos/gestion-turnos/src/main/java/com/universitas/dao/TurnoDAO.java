package com.universitas.dao;

import com.universitas.modelo.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {

    public void guardar(Turno turno) {
        String sqlPaciente = "SELECT id FROM paciente WHERE dni = ?";
        String sqlProfesional = "SELECT id FROM profesional WHERE matricula = ?";
        String sqlConsultorio = "SELECT id FROM consultorio WHERE numero = ?";
        String sqlInsert = "INSERT INTO turno (paciente_id, profesional_id, consultorio_id, fecha, hora, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion()) {
            // Obtener ID Paciente
            PreparedStatement psPac = conn.prepareStatement(sqlPaciente);
            psPac.setString(1, turno.getPaciente().getDni());
            ResultSet rsPac = psPac.executeQuery();
            if (!rsPac.next()) { System.err.println("Paciente no encontrado."); return; }
            int idPac = rsPac.getInt("id");

            // Obtener ID Profesional
            PreparedStatement psProf = conn.prepareStatement(sqlProfesional);
            psProf.setString(1, turno.getProfesional().getMatricula());
            ResultSet rsProf = psProf.executeQuery();
            if (!rsProf.next()) { System.err.println("Profesional no encontrado."); return; }
            int idProf = rsProf.getInt("id");

            // Obtener ID Consultorio
            PreparedStatement psCons = conn.prepareStatement(sqlConsultorio);
            psCons.setInt(1, turno.getConsultorio().getNumero());
            ResultSet rsCons = psCons.executeQuery();
            if (!rsCons.next()) { System.err.println("Consultorio no encontrado."); return; }
            int idCons = rsCons.getInt("id");

            // Insertar Turno [cite: 238]
            PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
            psInsert.setInt(1, idPac);
            psInsert.setInt(2, idProf);
            psInsert.setInt(3, idCons);
            psInsert.setDate(4, Date.valueOf(turno.getFecha())); // Convertimos LocalDate a java.sql.Date
            psInsert.setTime(5, Time.valueOf(turno.getHora()));  // Convertimos LocalTime a java.sql.Time
            psInsert.setString(6, turno.getEstado());

            psInsert.executeUpdate();
            System.out.println("Turno guardado exitosamente en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al guardar el turno: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM turno WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Turno con ID " + id + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún turno con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar turno: " + e.getMessage());
        }
    }

    // 3. Operación: Listar
    public List<Turno> listar() {
        List<Turno> lista = new ArrayList<>();
        // Alta consulta SQL con JOINs para cruzar toda la info
        String sql = "SELECT t.fecha, t.hora, t.estado, " +
                     "p.nombre AS pac_nombre, p.apellido AS pac_apellido, p.dni AS pac_dni, p.numero_afiliado, " +
                     "prof.nombre AS prof_nombre, prof.apellido AS prof_apellido, prof.dni AS prof_dni, prof.matricula, " +
                     "e.nombre AS esp_nombre, e.descripcion AS esp_desc, " +
                     "c.numero AS cons_numero, c.sector AS cons_sector " +
                     "FROM turno t " +
                     "INNER JOIN paciente p ON t.paciente_id = p.id " +
                     "INNER JOIN profesional prof ON t.profesional_id = prof.id " +
                     "INNER JOIN especialidad e ON prof.especialidad_id = e.id " +
                     "INNER JOIN consultorio c ON t.consultorio_id = c.id";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // 1. Reconstruimos la Especialidad y el Profesional
                Especialidad esp = new Especialidad(rs.getString("esp_nombre"), rs.getString("esp_desc"));
                Profesional prof = new Profesional(rs.getString("prof_nombre"), rs.getString("prof_apellido"), 
                                                   rs.getString("prof_dni"), rs.getString("matricula"), esp);

                // 2. Reconstruimos el Paciente
                Paciente pac = new Paciente(rs.getString("pac_nombre"), rs.getString("pac_apellido"), 
                                            rs.getString("pac_dni"), rs.getString("numero_afiliado"));

                // 3. Reconstruimos el Consultorio
                Consultorio cons = new Consultorio(rs.getInt("cons_numero"), rs.getString("cons_sector"));

                // 4. Armamos el Turno con sus fechas y estado
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                Turno turno = new Turno(pac, prof, cons, fecha, hora);
                turno.setEstado(rs.getString("estado")); // Pisamos el "Pendiente" por el estado real guardado

                lista.add(turno);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar turnos: " + e.getMessage());
        }
        return lista;
    }

    // 4. Operación: Buscar por ID
    public Turno buscarPorId(int id) {
        // Usamos la misma lógica del JOIN, pero filtramos por el ID del turno
        String sql = "SELECT t.fecha, t.hora, t.estado, " +
                     "p.nombre AS pac_nombre, p.apellido AS pac_apellido, p.dni AS pac_dni, p.numero_afiliado, " +
                     "prof.nombre AS prof_nombre, prof.apellido AS prof_apellido, prof.dni AS prof_dni, prof.matricula, " +
                     "e.nombre AS esp_nombre, e.descripcion AS esp_desc, " +
                     "c.numero AS cons_numero, c.sector AS cons_sector " +
                     "FROM turno t " +
                     "INNER JOIN paciente p ON t.paciente_id = p.id " +
                     "INNER JOIN profesional prof ON t.profesional_id = prof.id " +
                     "INNER JOIN especialidad e ON prof.especialidad_id = e.id " +
                     "INNER JOIN consultorio c ON t.consultorio_id = c.id " +
                     "WHERE t.id = ?";

        Turno turno = null;
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                // Usamos 'if' en vez de 'while' porque el ID es único y solo devuelve un registro
                if (rs.next()) {
                    Especialidad esp = new Especialidad(rs.getString("esp_nombre"), rs.getString("esp_desc"));
                    Profesional prof = new Profesional(rs.getString("prof_nombre"), rs.getString("prof_apellido"), 
                                                       rs.getString("prof_dni"), rs.getString("matricula"), esp);
                    Paciente pac = new Paciente(rs.getString("pac_nombre"), rs.getString("pac_apellido"), 
                                                rs.getString("pac_dni"), rs.getString("numero_afiliado"));
                    Consultorio cons = new Consultorio(rs.getInt("cons_numero"), rs.getString("cons_sector"));

                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    LocalTime hora = rs.getTime("hora").toLocalTime();
                    turno = new Turno(pac, prof, cons, fecha, hora);
                    turno.setEstado(rs.getString("estado"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar turno por ID: " + e.getMessage());
        }
        return turno;
    }
    // Nota para el proyecto: Los métodos listar() y buscarPorId(int id) requerirían hacer JOINs con las 4 tablas 
    // para reconstruir los objetos (Paciente, Profesional, Consultorio). Para mantener la legibilidad de esta etapa,
    // se recomienda implementarlos de forma similar a listar() de ProfesionalDAO, pero cruzando todas las tablas.
}