package com.universitas.dao;

import com.universitas.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement; //para ocultar datos sensibles y prevenir de la inyección SQL, permitiendo ejecutar sentencias SQL con parámetros de forma segura.
import java.sql.ResultSet; //devuelve un conjunto de resultados de una consulta SQL, permitiendo iterar sobre los datos obtenidos de la base de datos
import java.sql.SQLException;
import java.sql.Statement; //permite ejecutar sentencias SQL con parámetros y obtener resultados de consultas a la base de datos. Por ejemplo un insert no devuelve resultados, pero un select sí devuelve un ResultSet con los datos obtenidos de la consulta.

public class VehiculoDAO {

    public int guardar(Vehiculo vehiculo, String tipo) throws SQLException {
        String sql = """
                INSERT INTO vehiculo (marca, modelo, tipo)
                VALUES (?, ?, ?)
                """; //instruccion SQL parametrizada para insertar un nuevo vehículo en la tabla vehiculo, utilizando placeholders (?) para los valores que se establecerán posteriormente con PreparedStatement.

        try (Connection con = ConexionBD.obtenerConexion(); //me conecto a la base de datos utilizando el método obtenerConexion() de la clase ConexionBD, que devuelve una conexión activa a la base de datos MySQL.
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { //genera un objeto PreparedStatement a partir de la conexión y la consulta SQL, indicando que se desean obtener las claves generadas automáticamente (como el ID del nuevo vehículo) después de ejecutar la sentencia.

            ps.setString(1, vehiculo.getMarca().name()); //obtiene el atributo marca del objeto Vehiculo, lo convierte a su representación de cadena utilizando el método name() (asumiendo que Marca es un enum) y lo establece como el primer parámetro de la consulta SQL.
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, tipo);

            ps.executeUpdate(); //ejecuta la sentencia SQL de inserción en la base de datos, agregando un nuevo registro a la tabla vehiculo con los valores proporcionados.

            ResultSet rs = ps.getGeneratedKeys(); //después de ejecutar la inserción, se obtiene un ResultSet que contiene las claves generadas automáticamente por la base de datos (como el ID del nuevo vehículo) utilizando el método getGeneratedKeys() del PreparedStatement. El rs es un objeto de la clase ResultSet que permite acceder a los datos devueltos por la consulta, en este caso las claves generadas.
//el metodo next() del ResultSet se utiliza para avanzar al siguiente registro en el conjunto de resultados. En este caso, se verifica si hay al menos una fila (lo que indica que se generó una clave) y luego se obtiene el valor de la primera columna (que generalmente es el ID generado) utilizando el método getInt(1) y se devuelve como resultado del método guardar. Esto permite obtener el ID del nuevo vehículo insertado en la base de datos.
            if (rs.next()) { //si el ResultSet tiene al menos una fila (lo que indica que se generó una clave), se obtiene el valor de la primera columna (que generalmente es el ID generado) utilizando el método getInt(1) y se devuelve como resultado del método guardar. Esto permite obtener el ID del nuevo vehículo insertado en la base de datos.
                return rs.getInt(1);
            }
//en caso de que no se haya generado una clave (lo que sería inusual en una inserción exitosa), se lanza una excepción SQLException indicando que no se pudo obtener el ID del vehículo.
            throw new SQLException("No se pudo obtener el ID del vehículo.");
        }
    }

    public void actualizarDatosBase(int id, Vehiculo vehiculo) throws SQLException {
        String sql = """
                UPDATE vehiculo
                SET marca = ?, modelo = ?
                WHERE id = ?
                """;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getMarca().name());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, id);

            ps.executeUpdate();
//secuencia: se establece la conexión a la base de datos, se prepara la sentencia SQL de actualización con parámetros (query), se asignan los valores correspondientes a cada parámetro  (?=placeholders) utilizando los métodos setString y setInt del PreparedStatement, y finalmente se ejecuta la actualización en la base de datos con executeUpdate() (a traves del ps), lo que modifica el registro del vehículo con el ID especificado.

        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM vehiculo WHERE id = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}