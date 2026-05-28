package com.universitas.dao;

import com.universitas.modelo.Especialidad;
import com.universitas.modelo.Profesional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDAO {

    public void guardar(Profesional profesional) {
        // 1. Buscamos el ID de la especialidad por su nombre
        String sqlBuscarEsp = "SELECT id FROM especialidad WHERE nombre = ?";
        // 2. Insertamos el profesional usando ese ID
        String sqlInsertProf = "INSERT INTO profesional (nombre, apellido, dni, matricula, especialidad_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement psBusqueda = conn.prepareStatement(sqlBuscarEsp);
             PreparedStatement psInsert = conn.prepareStatement(sqlInsertProf)) {

            // Ejecutamos la búsqueda de la especialidad
            psBusqueda.setString(1, profesional.getEspecialidad().getNombre());
            ResultSet rsEsp = psBusqueda.executeQuery();

            int especialidadId = -1;
            if (rsEsp.next()) {
                especialidadId = rsEsp.getInt("id");
            } else {
                System.err.println("Error: No se encontró la especialidad '" + profesional.getEspecialidad().getNombre() + "' en la base de datos.");
                return; // Cortamos la ejecución si no existe la especialidad
            }

            // Procedemos a insertar el profesional
            psInsert.setString(1, profesional.getNombre());
            psInsert.setString(2, profesional.getApellido());
            psInsert.setString(3, profesional.getDni());
            psInsert.setString(4, profesional.getMatricula());
            psInsert.setInt(5, especialidadId);

            psInsert.executeUpdate();
            System.out.println("Profesional guardado correctamente en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al guardar profesional: " + e.getMessage());
        }
    }

    public List<Profesional> listar() {
        List<Profesional> lista = new ArrayList<>();
        // Usamos un JOIN para traer también los datos de la especialidad y poder armar el objeto completo
        String sql = "SELECT p.nombre, p.apellido, p.dni, p.matricula, e.nombre AS esp_nombre, e.descripcion AS esp_desc " +
                     "FROM profesional p INNER JOIN especialidad e ON p.especialidad_id = e.id";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Especialidad esp = new Especialidad(rs.getString("esp_nombre"), rs.getString("esp_desc"));
                Profesional prof = new Profesional(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("matricula"),
                        esp
                );
                lista.add(prof);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar profesionales: " + e.getMessage());
        }
        return lista;
    }
}