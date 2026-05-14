package com.universitas.dao;

import com.universitas.Auto;
import com.universitas.Marca;
import com.universitas.Rueda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {

    private final VehiculoDAO vehiculoDAO = new VehiculoDAO();
    private final MotorDAO motorDAO = new MotorDAO();
    private final RuedaDAO ruedaDAO = new RuedaDAO();

    public int guardar(Auto auto) throws SQLException {
        int idVehiculo = vehiculoDAO.guardar(auto, "AUTO");
        int idMotor = motorDAO.guardar(auto.getMotor());

        String sql = "INSERT INTO auto (id, motor_id) VALUES (?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idVehiculo);
            ps.setInt(2, idMotor);
            ps.executeUpdate();
        }

        for (Rueda rueda : auto.getRuedas()) {
            ruedaDAO.guardar(rueda, idVehiculo);
        }

        return idVehiculo;
    }

    public Auto buscarPorId(int id) throws SQLException {
        String sql = """
                SELECT v.marca, v.modelo, m.tipo AS tipo_motor, m.cilindrada
                FROM vehiculo v
                INNER JOIN auto a ON v.id = a.id
                INNER JOIN motor m ON a.motor_id = m.id
                WHERE v.id = ?
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery(); //la ejecucion devuelve un ResultSet con los datos obtenidos de la consulta a la base de datos, que en este caso incluye la marca, modelo, tipo de motor y cilindrada del vehículo con el ID especificado. A partir de ese ResultSet se puede iterar sobre los resultados obtenidos utilizando rs.next() para crear un objeto Auto con los datos correspondientes y luego se pueden agregar las ruedas asociadas al vehículo utilizando el método listarPorVehiculo del RuedaDAO.

            if (rs.next()) {
                Auto auto = new Auto(
                        Marca.valueOf(rs.getString("marca")),
                        rs.getString("modelo"),
                        rs.getString("tipo_motor"),
                        rs.getInt("cilindrada")
                );

                for (Rueda rueda : ruedaDAO.listarPorVehiculo(id)) {
                    auto.agregarRueda(rueda);
                }

                return auto;
            }

            return null;
        }
    }

    public List<Auto> listarTodos() throws SQLException {
        List<Auto> autos = new ArrayList<>();

        String sql = "SELECT id FROM auto";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                autos.add(buscarPorId(rs.getInt("id")));
            }
        }

        return autos;
    }

    public void actualizar(int id, Auto auto) throws SQLException {
        vehiculoDAO.actualizarDatosBase(id, auto);

        String sqlMotorId = "SELECT motor_id FROM auto WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sqlMotorId)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int motorId = rs.getInt("motor_id");
                motorDAO.actualizar(motorId, auto.getMotor());
            }
        }

        ruedaDAO.eliminarPorVehiculo(id);

        for (Rueda rueda : auto.getRuedas()) {
            ruedaDAO.guardar(rueda, id);
        }
    }

    public void eliminar(int id) throws SQLException {
        try (Connection con = ConexionBD.obtenerConexion()) {
            con.setAutoCommit(false);

            try {
                ejecutarDelete(con, "DELETE FROM rueda WHERE vehiculo_id = ?", id);
                ejecutarDelete(con, "DELETE FROM auto WHERE id = ?", id);
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