package com.universitas.dao;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class ConexionBDTest {

    @Test
    void testConexionExitosa() {
        // Intentamos abrir la conexión en un bloque try
        try (Connection conn = ConexionBD.obtenerConexion()) {
            // Afirmamos que el objeto Connection no sea nulo
            assertNotNull(conn, "La conexión a la base de datos no debería ser nula.");
            // Afirmamos que la conexión esté abierta y lista para usarse
            assertFalse(conn.isClosed(), "La conexión debería estar abierta.");
        } catch (SQLException e) {
            // Si salta una excepción, forzamos el fallo del test
            fail("Falló la conexión a la base de datos: " + e.getMessage());
        }
    }
}