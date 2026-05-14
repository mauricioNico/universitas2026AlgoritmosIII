package com.universitas;

import com.universitas.dao.AutoDAO;
import com.universitas.dao.CamionDAO;

/**
 * Clase principal para probar el sistema.
 */
public class App {

    public static void main(String[] args) {

        try {

            /*
             * ============================
             * CREACIÓN DE OBJETOS
             * ============================
             */

            Auto auto = new Auto(
                    Marca.TOYOTA,
                    "Corolla",
                    "Nafta",
                    1800
            );

            auto.agregarRueda(new Rueda("Michelin", 16));
            auto.agregarRueda(new Rueda("Michelin", 16));
            auto.agregarRueda(new Rueda("Michelin", 16));
            auto.agregarRueda(new Rueda("Michelin", 16));

            Camion camion = new Camion(
                    Marca.SCANIA,
                    "R450",
                    "Diesel",
                    13000,
                    20000
            );

            camion.agregarRueda(new Rueda("Pirelli", 22));
            camion.agregarRueda(new Rueda("Pirelli", 22));
            camion.agregarRueda(new Rueda("Pirelli", 22));
            camion.agregarRueda(new Rueda("Pirelli", 22));
            camion.agregarRueda(new Rueda("Pirelli", 22));
            camion.agregarRueda(new Rueda("Pirelli", 22));

            /*
             * ============================
             * MOSTRAR INFO
             * ============================
             */

            System.out.println();
            auto.mostrarInfo();

            System.out.println();
            camion.mostrarInfo();

            /*
             * ============================
             * SERVICIOS
             * ============================
             */

            ServicioVehiculo servicio = new ServicioVehiculo();

            servicio.realizarService(auto);
            servicio.cambiarAceite(auto);
            servicio.diagnosticar(auto);

            servicio.realizarService(camion);
            servicio.cambiarAceite(camion);
            servicio.diagnosticar(camion);

            /*
             * ============================
             * DAO + JDBC
             * ============================
             */

            AutoDAO autoDAO = new AutoDAO();
            CamionDAO camionDAO = new CamionDAO();

            int idAuto = autoDAO.guardar(auto);
            int idCamion = camionDAO.guardar(camion);

            System.out.println();
            System.out.println("Auto guardado con ID: " + idAuto);
            System.out.println("Camion guardado con ID: " + idCamion);

            /*
             * ============================
             * RECUPERAR DESDE MYSQL
             * ============================
             */

            Auto autoRecuperado = autoDAO.buscarPorId(idAuto);

            System.out.println();
            System.out.println("AUTO RECUPERADO");

            if (autoRecuperado != null) {
                autoRecuperado.mostrarInfo();
            }

        } catch (Exception e) {

            System.out.println("ERROR GENERAL");
            e.printStackTrace();
        }
    }
}