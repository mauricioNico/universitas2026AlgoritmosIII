package com.universitas.dao;

import com.universitas.modelo.Paciente;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PacienteDAOTest {

    @Test
    void testListarPacientes() {
        PacienteDAO dao = new PacienteDAO();
        List<Paciente> lista = dao.listar();
        
        // Verificamos que devuelva una lista (incluso si estuviera vacía, no debe ser null)
        assertNotNull(lista, "La lista de pacientes devuelta no debe ser nula.");
        
        // Como ya insertamos datos con App.java, el tamaño debería ser mayor a 0
        assertTrue(lista.size() > 0, "Debería haber al menos un paciente cargado en la base de datos.");
    }
}