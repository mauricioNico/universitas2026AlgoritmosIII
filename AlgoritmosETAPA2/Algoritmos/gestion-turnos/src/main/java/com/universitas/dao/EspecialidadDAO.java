package com.universitas.dao;

import com.universitas.modelo.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EspecialidadDAO {
    public void guardar(Especialidad especialidad) {
        String sql = "INSERT INTO especialidad (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, especialidad.getNombre());
            ps.setString(2, especialidad.getDescripcion());
            ps.executeUpdate();
            System.out.println("Especialidad guardada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al guardar especialidad: " + e.getMessage());
        }
    }
}