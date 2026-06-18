package clase17062026.arbolComun;

import java.io.File;
/*
clase que implementa la interfaz Comparable para representar un archivo con sus atributos y permitir su comparación basada en el nombre completo (nombre + extensión). La clase incluye constructores para crear objetos Archivo a partir de un nombre completo o a partir de un objeto File, así como métodos para obtener el nombre completo, la ruta absoluta y una representación en cadena del archivo.
*/
public class Archivo implements Comparable<Archivo> {
/**
 * atributos de un archivo:
 * - nombre (sin extension)
 * - extension
 * - tamaño en bytes
 * - ruta absoluta
 */
    private String nombre;
    private String extension;
    private long tamanioBytes;
    private String rutaAbsoluta;
/*
* constructor que recibe cada atributo por separado
    */
    public Archivo(String nombre, String extension, long tamanioBytes, String rutaAbsoluta) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanioBytes = tamanioBytes;
        this.rutaAbsoluta = rutaAbsoluta;
    }
/*
sobrecarga del constructor que recibe el nombre completo (con extension) y se encarga de separar el nombre de la extension
 */
    public Archivo(String nombreCompleto) {
        int punto = nombreCompleto.lastIndexOf(".");

        if (punto != -1) {
            this.nombre = nombreCompleto.substring(0, punto);
            this.extension = nombreCompleto.substring(punto + 1);
        } else {
            this.nombre = nombreCompleto;
            this.extension = "";
        }

        this.tamanioBytes = 0;
        this.rutaAbsoluta = "";
    }
/*
metodo estático que recibe un objeto File y devuelve un objeto Archivo con los atributos correspondientes. Se encarga de extraer el nombre, la extensión, el tamaño y la ruta absoluta del archivo.
*/
    public static Archivo desdeFile(File file) {
        String nombreCompleto = file.getName();
        int punto = nombreCompleto.lastIndexOf(".");

        String nombre;
        String extension;

        if (punto != -1) {
            nombre = nombreCompleto.substring(0, punto);
            extension = nombreCompleto.substring(punto + 1);
        } else {
            nombre = nombreCompleto;
            extension = "";
        }

        return new Archivo(
                nombre,
                extension,
                file.length(),
                file.getAbsolutePath()
        );
    }
/*getters */
    public String getNombreCompleto() {
        if (extension == null || extension.isEmpty()) {
            return nombre;
        }

        return nombre + "." + extension;
    }

    public String getRutaAbsoluta() {
        return rutaAbsoluta;
    }
/*
la comparación entre archivos se basa en el nombre completo (nombre + extensión) sin importar mayúsculas o minúsculas. Esto permite ordenar los archivos alfabéticamente por su nombre, independientemente de su extensión o tamaño.
*/
    @Override
    public int compareTo(Archivo otro) {
        return this.getNombreCompleto()
                .compareToIgnoreCase(otro.getNombreCompleto());
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (" + tamanioBytes + " bytes)";
    }
}
