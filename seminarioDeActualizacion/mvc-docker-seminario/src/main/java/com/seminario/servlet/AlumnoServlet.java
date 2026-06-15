package com.seminario.servlet;

import com.seminario.modelo.Alumno;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/alumnos")
public class AlumnoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno(1, "Ana Gómez", "Programación"));
        alumnos.add(new Alumno(2, "Juan Pérez", "Sistemas"));
        alumnos.add(new Alumno(3, "Lucía Fernández", "Desarrollo Web"));

        request.setAttribute("listaAlumnos", alumnos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("alumnos.jsp");
        dispatcher.forward(request, response);
    }
}
