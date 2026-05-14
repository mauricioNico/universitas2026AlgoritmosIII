package com.universitas.dao;

import com.universitas.Camion;
import com.universitas.Marca;
import com.universitas.Rueda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamionDAO {

    private final VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private final MotorDAO motorDAO = new MotorDAO();
    private final RuedaDAO ruedaDAO = new RuedaDAO();

    public int guardar(Camion camion) throws SQLException {
        int idVehiculo = vehiculoDAO.guardar(camion, "CAMION");
        int idMotor = motorDAO.guardar(camion.getMotor());

        String sql = """
                INSERT INTO camion (id, motor_id, capacidad_carga)
                VALUES (?, ?, ?)
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idVehiculo);
            ps.setInt(2, idMotor);
            ps.setDouble(3, camion.getCapacidadCarga());
            ps.executeUpdate();
        }

        for (Rueda rueda : camion.getRuedas()) {
            ruedaDAO.guardar(rueda, idVehiculo);
        }

        return idVehiculo;
    }

    public Camion buscarPorId(int id) throws SQLException {
        String sql = """
                SELECT v.marca, v.modelo, m.tipo AS tipo_motor, m.cilindrada, c.capacidad_carga
                FROM vehiculo v
                INNER JOIN camion c ON v.id = c.id
                INNER JOIN motor m ON c.motor_id = m.id
                WHERE v.id = ?
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Camion camion = new Camion(
                        Marca.valueOf(rs.getString("marca")),
                        rs.getString("modelo"),
                        rs.getString("tipo_motor"),
                        rs.getInt("cilindrada"),
                        rs.getDouble("capacidad_carga")
                );

                for (Rueda rueda : ruedaDAO.listarPorVehiculo(id)) {
                    camion.agregarRueda(rueda);
                }

                return camion;
            }

            return null;
        }
    }

    public List<Camion> listarTodos() throws SQLException {
        List<Camion> camiones = new ArrayList<>();

        String sql = "SELECT id FROM camion";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                camiones.add(buscarPorId(rs.getInt("id")));
            }
        }

        return camiones;
    }

    public void actualizar(int id, Camion camion) throws SQLException {
        vehiculoDAO.actualizarDatosBase(id, camion);

        String sql = """
                SELECT motor_id
                FROM camion
                WHERE id = ?
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int motorId = rs.getInt("motor_id");
                motorDAO.actualizar(motorId, camion.getMotor());
            }
        }

        String updateCamion = """
                UPDATE camion
                SET capacidad_carga = ?
                WHERE id = ?
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(updateCamion)) {

            ps.setDouble(1, camion.getCapacidadCarga());
            ps.setInt(2, id);
            ps.executeUpdate();
        }

        ruedaDAO.eliminarPorVehiculo(id);

        for (Rueda rueda : camion.getRuedas()) {
            ruedaDAO.guardar(rueda, id);
        }
    }

    public void eliminar(int id) throws SQLException {
        try (Connection con = ConexionBD.obtenerConexion()) {
            con.setAutoCommit(false);

            try {
                ejecutarDelete(con, "DELETE FROM rueda WHERE vehiculo_id = ?", id);
                ejecutarDelete(con, "DELETE FROM camion WHERE id = ?", id);
                ejecutarDelete(con, "DELETE FROM vehiculo WHERE id = ?", id);

                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        }
    }

    private void ejecutarDelete(Connection con, String sql, int id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}