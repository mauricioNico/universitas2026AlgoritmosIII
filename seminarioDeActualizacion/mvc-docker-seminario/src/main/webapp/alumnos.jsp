<%@ page import="java.util.List" %>
<%@ page import="com.seminario.modelo.Alumno" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de alumnos</title>
</head>
<body>

    <h1>Listado de alumnos</h1>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Carrera</th>
        </tr>

        <%
            List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listaAlumnos");

            for (Alumno alumno : alumnos) {
        %>

        <tr>
            <td><%= alumno.getId() %></td>
            <td><%= alumno.getNombre() %></td>
            <td><%= alumno.getCarrera() %></td>
        </tr>

        <%
            }
        %>

    </table>

    <br>

    <a href="index.jsp">Volver al inicio</a>

</body>
</html>