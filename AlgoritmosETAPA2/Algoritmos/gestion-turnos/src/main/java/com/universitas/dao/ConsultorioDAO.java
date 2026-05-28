package com.universitas.dao;

import com.universitas.modelo.Consultorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultorioDAO {
    public void guardar(Consultorio consultorio) {
        String sql = "INSERT INTO consultorio (numero, sector) VALUES (?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, consultorio.getNumero());
            ps.setString(2, consultorio.getSector());
            ps.executeUpdate();
            System.out.println("Consultorio guardado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al guardar consultorio: " + e.getMessage());
        }
    }
}