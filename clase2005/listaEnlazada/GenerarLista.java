package listaEnlazada;

import java.util.Scanner;

public class GenerarLista {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
         * Selección del tipo de lista
         */
        int tipoLista;
//para obligar al usuario a ingresar una opción válida, se utiliza un bucle do-while que solicita al usuario que seleccione el tipo de lista (1 para lista simplemente enlazada o 2 para lista doblemente enlazada). El bucle continuará ejecutándose hasta que el usuario ingrese una opción válida (1 o 2), lo que garantiza que el programa solo procederá con una selección correcta.
        do {

            tipoLista = pedirEntero(
                    scanner,
                    "Seleccione el tipo de lista:\n"
                            + "1. Lista simplemente enlazada\n"
                            + "2. Lista doblemente enlazada\n"
                            + "Ingrese su opción:"
            );

        } while (tipoLista != 1 && tipoLista != 2);

        /*
         * Cantidad de elementos
         */
        int cantidadElementos =
                pedirEntero(
                        scanner,
                        "Ingrese la cantidad de elementos:"
                );

        /*
         * Tipo de carga
         */
        int formaCarga;

        do {

            formaCarga = pedirEntero(
                    scanner,
                    "Seleccione la forma de carga:\n"
                            + "1. Manual\n"
                            + "2. Aleatoria\n"
                            + "Ingrese su opción:"
            );

        } while (formaCarga != 1 && formaCarga != 2);

        /*
         * Ejecutar lista seleccionada
         */
        if (tipoLista == 1) {

            ejecutarListaSimple(
                    scanner,
                    cantidadElementos,
                    formaCarga
            );

        } else {

            ejecutarListaDoble(
                    scanner,
                    cantidadElementos,
                    formaCarga
            );
        }

        scanner.close();
    }

    /*
     * Ejecutar lista simplemente enlazada
     */
    private static void ejecutarListaSimple(
            Scanner scanner,
            int cantidadElementos,
            int formaCarga
    ) {

        Lista lista = new Lista();

        /*
         * Cargar lista
         */
        for (int i = 0; i < cantidadElementos; i++) {

            int dato;

            if (formaCarga == 1) {

                dato = pedirEntero(
                        scanner,
                        "Ingrese el elemento "
                                + (i + 1) + ":"
                );

            } else {

                dato = (int) (Math.random() * 100);
            }

            lista.agregar(dato);
        }

        /*
         * Mostrar lista
         */
        System.out.println(
                "\nLISTA SIMPLEMENTE ENLAZADA:"
        );

        lista.imprimir();

        /*
         * Mostrar tamaño
         */
        System.out.println(
                "\nTamaño: "
                        + lista.calcularTamaño()
        );

        /*
         * Buscar nodo
         */
        int datoBuscar = pedirEntero(
                scanner,
                "\nIngrese el elemento a buscar:"
        );

        Nodo nodoBuscado =
                lista.buscar(datoBuscar);

        if (nodoBuscado != null) {

            System.out.println(
                    "Nodo encontrado: "
                            + nodoBuscado.getDato() + " en posición: " + (lista.obtenerPosicion(datoBuscar)
            +1));

        } else {

            System.out.println(
                    "Nodo no encontrado."
            );
        }

        /*
         * Eliminar nodo
         */
        int datoEliminar = pedirEntero(
                scanner,
                "\nIngrese el elemento a eliminar:"
        );

        lista.eliminar(datoEliminar);

        System.out.println(
                "\nLISTA DESPUÉS DE ELIMINAR:"
        );

        lista.imprimir();
    }

    /*
     * Ejecutar lista doblemente enlazada
     */
    private static void ejecutarListaDoble(
            Scanner scanner,
            int cantidadElementos,
            int formaCarga
    ) {

        ListaDoble lista = new ListaDoble();

        /*
         * Cargar lista
         */
        for (int i = 0; i < cantidadElementos; i++) {

            int dato;

            if (formaCarga == 1) {

                dato = pedirEntero(
                        scanner,
                        "Ingrese el elemento "
                                + (i + 1) + ":"
                );

            } else {

                dato = (int) (Math.random() * 100);
            }

            lista.agregar(dato);
        }

        /*
         * Mostrar lista
         */
        System.out.println(
                "\nLISTA DOBLEMENTE ENLAZADA:"
        );

        lista.imprimir();

        /*
         * Mostrar lista en reversa
         */
        System.out.println(
                "\nLISTA EN REVERSA:"
        );

        lista.imprimirReversa();

        /*
         * Mostrar tamaño
         */
        System.out.println(
                "\nTamaño: "
                        + lista.calcularTamaño()
        );

        /*
         * Buscar nodo
         */
        int datoBuscar = pedirEntero(
                scanner,
                "\nIngrese el elemento a buscar:"
        );

        Nodo nodoBuscado =
                lista.buscar(datoBuscar);

        if (nodoBuscado != null) {

            System.out.println(
                    "Nodo encontrado: "
                            + nodoBuscado.getAnterior().getDato() + " → " + nodoBuscado.getDato() + " → " + nodoBuscado.getSiguiente().getDato()
            );

        } else {

            System.out.println(
                    "Nodo no encontrado."
            );
        }

        /*
         * Eliminar nodo
         */
        int datoEliminar = pedirEntero(
                scanner,
                "\nIngrese el elemento a eliminar:"
        );

        lista.eliminar(datoEliminar);

        System.out.println(
                "\nLISTA DESPUÉS DE ELIMINAR:"
        );

        lista.imprimir();

        System.out.println(
                "\nLISTA EN REVERSA DESPUÉS DE ELIMINAR:"
        );

        lista.imprimirReversa();
    }

    /*
     * Solicitar un número entero validando
     * la entrada mediante excepciones.
     */
    private static int pedirEntero(
            Scanner scanner,
            String mensaje
    ) {

        int numero = 0;

        boolean valido;

        do {

            valido = true;

            System.out.println(mensaje);

            String entrada = scanner.next();

            try {

                numero =
                        Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                valido = false;

                System.out.println(
                        "Entrada no válida. "
                                + "Debe ingresar un número entero."
                );
            }

        } while (!valido);

        return numero;
    }
    //este método en lugar de usar try catch para validar la entrada del usuario puede usar hasNextInt() para verificar si la entrada es un número entero antes de intentar parsearla, lo que puede simplificar el código y evitar el uso de excepciones para el control de flujo.
    /*
    * solicitar un número entero validando la entrada mediante hasNextInt() sin usar excepciones.
    private static int pedirEntero(
        Scanner scanner,
        String mensaje  ) {     
        int numero = 0;
        boolean valido;
        do {
            valido = true;
            System.out.println(mensaje);
            if (scanner.hasNextInt()) { //verificar si la entrada es un número entero
                numero = scanner.nextInt();
            } else {
                valido = false;
                System.out.println(
                    "Entrada no válida. "
                    + "Debe ingresar un número entero."
                );
                scanner.next(); // Limpiar la entrada no válida
            }
        } while (!valido);
    */
}