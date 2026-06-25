package Hash;
public class App {

    public static void main(String[] args) {

        TablaHashCasera tabla = new TablaHashCasera(10);

        tabla.agregar(new Alumno(23, "Juan"));
        tabla.agregar(new Alumno(14, "Ana"));
        tabla.agregar(new Alumno(33, "Luis"));
        tabla.agregar(new Alumno(44, "Sofía"));
        tabla.agregar(new Alumno(53, "Pedro"));

        System.out.println();
        tabla.mostrarTabla();

        System.out.println();
        Alumno buscado = tabla.buscar(33);

        if (buscado != null) {
            System.out.println("Alumno encontrado: " + buscado);
        } else {
            System.out.println("Alumno no encontrado");
        }
    }
}
