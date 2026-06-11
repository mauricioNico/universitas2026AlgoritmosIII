package arbolComun;

public class App {

    public static void main(String[] args) {

        /*
         * Estructura:
         *
         * C:
         * ├── Documentos
         * │   ├── notas.txt
         * │   └── Java
         * │       └── apuntes.txt
         * │
         * └── Imagenes
         *     └── foto.jpg
         */

        NodoArbolSistema unidad =
                new NodoArbolSistema(
                        "C:",
                        true);

        NodoArbolSistema documentos =
                new NodoArbolSistema(
                        "Documentos",
                        true);

        NodoArbolSistema java =
                new NodoArbolSistema(
                        "Java",
                        true);

        NodoArbolSistema imagenes =
                new NodoArbolSistema(
                        "Imagenes",
                        true);

        NodoArbolSistema notas =
                new NodoArbolSistema(
                        "notas.txt",
                        false);

        NodoArbolSistema apuntes =
                new NodoArbolSistema(
                        "apuntes.txt",
                        false);

        NodoArbolSistema foto =
                new NodoArbolSistema(
                        "foto.jpg",
                        false);

        /*
         * Construcción del árbol
         */

        unidad.agregarHijo(documentos);

        unidad.agregarHijo(imagenes);

        documentos.agregarHijo(notas);

        documentos.agregarHijo(java);

        java.agregarHijo(apuntes);

        imagenes.agregarHijo(foto);

        /*
         * Crear explorador
         */

        ExploradorArchivos explorador =
                new ExploradorArchivos(
                        unidad);

        /*
         * Mostrar árbol completo
         */

        System.out.println(
                "ESTRUCTURA DEL SISTEMA\n");

        explorador.mostrarEstructura();

        /*
         * Buscar archivo
         */

        System.out.println(
                "\nBUSCANDO ARCHIVO...\n");

        String nombreBuscado =
                "apuntes.txt";

        NodoArbolSistema encontrado =
                explorador.buscar(
                        nombreBuscado);

        if (encontrado != null) {

            System.out.println(
                    "Archivo encontrado: "
                            + encontrado.getNombre());

            System.out.println(
                    "Ruta completa: "
                            + explorador.obtenerRutaCompleta(
                                    encontrado));

        } else {

            System.out.println(
                    "Archivo no encontrado.");
        }
    }
}
