package com.universitas.dao;

import com.universitas.Motor;

import java.sql.*;

public class MotorDAO {

    public int guardar(Motor motor) throws SQLException {
        String sql = """
                INSERT INTO motor (tipo, cilindrada)
                VALUES (?, ?)
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, motor.getTipo());
            ps.setInt(2, motor.getCilindrada());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            throw new SQLException("No se pudo obtener el ID del motor.");
        }
    }

    public void actualizar(int id, Motor motor) throws SQLException {
        String sql = """
                UPDATE motor
                SET tipo = ?, cilindrada = ?
                WHERE id = ?
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, motor.getTipo());
            ps.setInt(2, motor.getCilindrada());
            ps.setInt(3, id);

            ps.executeUpdate();
        }
    }
}