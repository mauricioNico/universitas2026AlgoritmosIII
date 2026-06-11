package com.seminario.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/alumnos")
public class AlumnoServlet extends HttpServlet {

    private static final List<String> alumnos = new ArrayList<>();
    private static int contador = 1;

    static {
        alumnos.add("{ \"id\": 1, \"nombre\": \"Ana\" }");
        alumnos.add("{ \"id\": 2, \"nombre\": \"Luis\" }");
        alumnos.add("{ \"id\": 3, \"nombre\": \"Marta\" }");
        alumnos.add("{ \"id\": 4, \"nombre\": \"Carlos\" }");
        contador = 5;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        configurarRespuesta(response);

        String json = "[" + String.join(",", alumnos) + "]";

        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        configurarRespuesta(response);

        StringBuilder body = new StringBuilder();
        BufferedReader reader = request.getReader();

        String linea;
        while ((linea = reader.readLine()) != null) {
            body.append(linea);
        }

        String contenido = body.toString();

        String nombre = contenido
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .replace("nombre:", "")
                .trim();

        String nuevoAlumno = "{ \"id\": " + contador + ", \"nombre\": \"" + nombre + "\" }";
        alumnos.add(nuevoAlumno);
        contador++;

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().write(nuevoAlumno);
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        configurarRespuesta(response);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void configurarRespuesta(HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }
}