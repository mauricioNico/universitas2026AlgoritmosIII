package com.universitas.dao;

import com.universitas.Rueda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RuedaDAO {

    public void guardar(Rueda rueda, int vehiculoId) throws SQLException {
        String sql = """
                INSERT INTO rueda (marca, diametro, vehiculo_id)
                VALUES (?, ?, ?)
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rueda.getMarca());
            ps.setInt(2, rueda.getDiametro());
            ps.setInt(3, vehiculoId);

            ps.executeUpdate();
        }
    }
//lo que es insert, update y delete se ejecuta con executeUpdate() porque no devuelve resultados, mientras que las consultas select se ejecutan con executeQuery() porque devuelven un ResultSet con los datos obtenidos de la consulta a la base de datos. A partir de alli uso rs.next() para iterar sobre los resultados obtenidos y crear objetos Rueda con los datos de cada fila del ResultSet, que luego se agregan a la lista de ruedas que se devuelve al final del método listarPorVehiculo.
    public List<Rueda> listarPorVehiculo(int vehiculoId) throws SQLException {
        List<Rueda> ruedas = new ArrayList<>();

        String sql = "SELECT * FROM rueda WHERE vehiculo_id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vehiculoId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ruedas.add(new Rueda(
                        rs.getString("marca"),
                        rs.getInt("diametro")
                ));
            }
        }

        return ruedas;
    }

    public void eliminarPorVehiculo(int vehiculoId) throws SQLException {
        String sql = "DELETE FROM rueda WHERE vehiculo_id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vehiculoId);
            ps.executeUpdate();
        }
    }
}
