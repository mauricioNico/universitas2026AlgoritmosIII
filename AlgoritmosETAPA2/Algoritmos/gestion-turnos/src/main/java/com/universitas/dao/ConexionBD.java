package com.universitas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // URL de conexión apuntando a tu MySQL local en el puerto 3306 y a la base de datos del TP
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_turnos";
    // Usuario por defecto de la instalación
    private static final String USER = "root";
    // La contraseña que configuramos en la instalación de MySQL Community
    private static final String PASSWORD = "root";

    /**
     * Método estático encargado de abrir y devolver la conexión con MySQL.
     * Utiliza el DriverManager de JDBC para interactuar con el driver de MySQL.
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}