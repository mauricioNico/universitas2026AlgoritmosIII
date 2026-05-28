package com.universitas.dao;

import com.universitas.modelo.Turno;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TurnoDAOTest {

    @Test
    void testListarTurnosCompleto() {
        TurnoDAO dao = new TurnoDAO();
        // Al llamar a listar, se ejecuta el JOIN de las 5 tablas
        List<Turno> lista = dao.listar();
        
        assertNotNull(lista, "La lista de turnos devuelta no debe ser nula.");
    }

    @Test
    void testBuscarPorIdInexistente() {
        TurnoDAO dao = new TurnoDAO();
        // Buscamos un ID altísimo que sabemos que no cargamos
        Turno turno = dao.buscarPorId(99999);
        
        // El método debería manejarlo correctamente y devolver un objeto nulo
        assertNull(turno, "Si el turno no existe en la BD, debería devolver null.");
    }
}