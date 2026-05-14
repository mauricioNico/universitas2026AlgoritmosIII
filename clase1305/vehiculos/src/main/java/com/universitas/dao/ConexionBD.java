package com.universitas.dao;

import java.io.InputStream; //permite leer archivos de recursos como db.properties desde el classpath del proyecto, facilitando la carga de configuraciones externas.
import java.sql.Connection; //representa una conexión JDBC a la base de datos a traves de la interfaz Connection y obtiene una conexión activa a la base de datos MySQL utilizando DriverManager
import java.sql.DriverManager; //permite establecer conexiones JDBC con la base de datos
import java.sql.SQLException; //maneja la conexión JDBC en caso de errores
import java.util.Properties; //permite generar objetos a partir de archivos de configuración .properties

/**
 * Clase encargada de gestionar la conexión JDBC
 * con la base de datos MySQL.
 *
 * La configuración se obtiene desde:
 * src/main/resources/db.properties
 *
 * @author Universitas
 * @version 1.0
 */
public class ConexionBD {
/**
    * Variables estáticas para almacenar la configuración de conexión.
    * Se cargan una sola vez en el bloque estático.
*/
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
     * Bloque estático:
     * Se ejecuta una sola vez cuando se carga la clase.
     * Lee el archivo db.properties y carga el driver JDBC.
     */
    static {

        try (
                InputStream input = ConexionBD.class
                        .getClassLoader()
                        .getResourceAsStream("db.properties")
        ) {

            if (input == null) {
                throw new RuntimeException(
                        "No se encontró el archivo db.properties"
                );
            }

            Properties properties = new Properties();

            properties.load(input);// Carga las propiedades desde el archivo db.properties

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
            driver = properties.getProperty("db.driver");

            // Carga explícita del driver JDBC
            Class.forName(driver);

            System.out.println("Driver JDBC cargado correctamente.");

        } catch (Exception e) {

            System.out.println("Error al cargar la configuración JDBC.");
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una conexión activa a la base de datos.
     *
     * @return Connection conexión JDBC
     * @throws SQLException si ocurre un error de conexión
     */
    public static Connection obtenerConexion() throws SQLException {

        return DriverManager.getConnection(
                url,
                user,
                password
        );
    }
}
