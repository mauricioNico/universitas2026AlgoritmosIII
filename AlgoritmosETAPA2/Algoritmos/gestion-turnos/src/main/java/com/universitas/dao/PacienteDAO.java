package com.universitas.dao;

import com.universitas.modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    // 1. Operación: Guardar
    public void guardar(Paciente paciente) {
        // Utilizamos el signo de interrogación (?) para parametrizar la consulta
        String sql = "INSERT INTO paciente (nombre, apellido, dni, numero_afiliado) VALUES (?, ?, ?, ?)";
        
        // El bloque try-with-resources cierra automáticamente la conexión, el statement y el resultset
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            // Reemplazamos los '?' con los datos reales del objeto
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getDni());
            ps.setString(4, paciente.getNumeroAfiliado());
            
            ps.executeUpdate();
            System.out.println("Paciente guardado correctamente en la base de datos.");
            
        } catch (SQLException e) {
            System.err.println("Error al guardar paciente: " + e.getMessage());
        }
    }

    // 2. Operación: Listar
    public List<Paciente> listar() {
        List<Paciente> listaPacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            // Iteramos sobre los resultados devueltos por la base de datos
            while (rs.next()) {
                // Recuperamos los datos de cada columna
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String numeroAfiliado = rs.getString("numero_afiliado");
                
                // Reconstruimos el objeto Paciente original y lo agregamos a la lista
                Paciente p = new Paciente(nombre, apellido, dni, numeroAfiliado);
                listaPacientes.add(p);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar pacientes: " + e.getMessage());
        }
        
        return listaPacientes;
    }
}