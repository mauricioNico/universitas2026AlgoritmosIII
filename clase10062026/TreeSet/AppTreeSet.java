package TreeSet;
import java.util.Set;
import java.util.TreeSet;
import casero.Archivo;

public class AppTreeSet {

    public static void main(String[] args) {
/*
* Genero un objeto TreeSet de tipo Archivo, que es una colección que almacena elementos únicos y ordenados.
Es una implementación de la interfaz Set que utiliza un árbol rojo-negro para mantener los elementos ordenados.
* Agrego varios objetos Archivo al TreeSet utilizando el método add.
 */
        Set<Archivo> archivos = new TreeSet<>();
 archivos.add(new Archivo("trabajo", "docx", 300));
 archivos.add(new Archivo("informe", "pdf", 120));
        archivos.add(new Archivo("foto", "jpg", 120));
        archivos.add(new Archivo("datos", "csv", 80));
        archivos.add(new Archivo("resumen", "docx", 100));
        archivos.add(new Archivo("apuntes", "pdf", 200));
        archivos.add(new Archivo("backup", "zip", 1000));

        System.out.println("ARCHIVOS ORDENADOS:");
        for (Archivo archivo : archivos) {
            System.out.println(archivo);
        }

        System.out.println("\nBÚSQUEDA DE ARCHIVOS:");

        buscarArchivo(archivos, new Archivo("datos", "csv", 0));
        buscarArchivo(archivos, new Archivo("presentacion", "pptx", 0));
        buscarArchivo(archivos, new Archivo("backup", "zip", 0));
    }

    private static void buscarArchivo(Set<Archivo> archivos, Archivo archivo) {
        if (archivos.contains(archivo)) {
            System.out.println(archivo.getNombreCompleto() + " encontrado");
        } else {
            System.out.println(archivo.getNombreCompleto() + " no encontrado");
        }
    }
}