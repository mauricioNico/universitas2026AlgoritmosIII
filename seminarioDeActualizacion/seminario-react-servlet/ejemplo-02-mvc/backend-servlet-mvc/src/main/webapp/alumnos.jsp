<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.seminario.model.Alumno" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MVC Tradicional - Alumnos</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 700px;
            margin: 40px auto;
            text-align: center;
        }

        h1 {
            color: #1f3c88;
        }

        form {
            margin: 20px 0;
        }

        input {
            padding: 10px;
            width: 250px;
        }

        button {
            padding: 10px 16px;
            cursor: pointer;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            background-color: #f1f1f1;
            margin: 10px 0;
            padding: 12px;
            border-radius: 8px;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <h1>Seminario de Actualización</h1>
    <h2>MVC tradicional con Servlet + JSP</h2>

    <form method="post" action="alumnos">
        <input type="text" name="nombre" placeholder="Ingrese nombre" required>
        <button type="submit">Guardar alumno</button>
    </form>

    <ul>
        <%
            List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");

            for (Alumno alumno : alumnos) {
        %>
            <li><%= alumno.getId() %> - <%= alumno.getNombre() %></li>
        <%
            }
        %>
    </ul>

</body>
</html>