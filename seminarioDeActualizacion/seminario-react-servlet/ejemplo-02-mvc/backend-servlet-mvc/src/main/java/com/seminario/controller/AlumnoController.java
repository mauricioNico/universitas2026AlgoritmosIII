package com.seminario.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.seminario.model.Alumno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/alumnos")
public class AlumnoController extends HttpServlet {

    private static final List<Alumno> alumnos = new ArrayList<>();
    private static int contador = 4;

    static {
        alumnos.add(new Alumno(1, "Ana"));
        alumnos.add(new Alumno(2, "Luis"));
        alumnos.add(new Alumno(3, "Marta"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("alumnos", alumnos);

        request.getRequestDispatcher("/alumnos.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");

        if (nombre != null && !nombre.isBlank()) {
            alumnos.add(new Alumno(contador, nombre));
            contador++;
        }

        response.sendRedirect(request.getContextPath() + "/alumnos");
    }
}
