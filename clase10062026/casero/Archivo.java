package casero;

public class Archivo implements Comparable<Archivo> {

    private String nombre;
    private String extension;
    private int tamanioKB;

    public Archivo(String nombre, String extension, int tamanioKB) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanioKB = tamanioKB;
    }

    public String getNombreCompleto() {
        return nombre + "." + extension;
    }
/*
* Porque sobreescribimos el método compareTo 
* Sobrescribimos el método compareTo para definir un criterio de comparación específico 
para los objetos de tipo Archivo. 
compareToIgnoreCase se utiliza para comparar los nombres completos de los archivos 
sin tener en cuenta las mayúsculas o minúsculas,
*/
    @Override
    public int compareTo(Archivo otro) {
        return this.getNombreCompleto()
                .compareToIgnoreCase(otro.getNombreCompleto());
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " (" + tamanioKB + " KB)";
    }
}