package GenerarJson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppHashMapJson {

    public static void main(String[] args) {

        Map<Integer, Alumno> alumnos = new HashMap<>();

        alumnos.put(1001, new Alumno(1001, "Juan", 8.5));
        alumnos.put(1002, new Alumno(1002, "Ana", 9.0));
        alumnos.put(1003, new Alumno(1003, "Luis", 7.5));
        alumnos.put(1004, new Alumno(1004, "Mauricio", 10.0));

        File archivo = new File("alumnos.json");

        try (FileWriter writer = new FileWriter(archivo)) {

            writer.write("{\n");
            writer.write("  \"alumnos\": [\n");

            int contador = 0;
            int total = alumnos.size();

            for (Alumno alumno : alumnos.values()) {

                writer.write("    {\n");
                writer.write("      \"legajo\": " + alumno.getLegajo() + ",\n");
                writer.write("      \"nombre\": \"" + alumno.getNombre() + "\",\n");
                writer.write("      \"promedio\": " + alumno.getPromedio() + "\n");
                writer.write("    }");

                contador++;

                if (contador < total) {
                    writer.write(",");
                }

                writer.write("\n");
            }

            writer.write("  ]\n");
            writer.write("}\n");

            System.out.println("Archivo JSON generado correctamente.");
            System.out.println("Ruta: " + archivo.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            System.out.println(e.getMessage());
        }
    }
}