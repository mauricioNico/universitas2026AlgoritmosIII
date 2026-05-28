package ar.edu.universitas.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparacionListas {

    private static final int CANTIDAD = 100000;
    private static final int POSICION = 90000;
    private static final int POSICION_MEDIO = CANTIDAD / 2;
    private static final int ANCHO_BARRA = 40;

    public static void main(String[] args) {
        mostrarRecorridoVisual();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < CANTIDAD; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayListGet = medir(() -> arrayList.get(POSICION));
        long linkedListGet = medir(() -> linkedList.get(POSICION));
        mostrarComparacion("ACCESO A LA POSICION " + POSICION, arrayListGet, linkedListGet);

        long arrayListAddInicio = medir(() -> {
            arrayList.add(0, -1);
            arrayList.remove(0);
        });

        long linkedListAddInicio = medir(() -> {
            linkedList.add(0, -1);
            linkedList.remove(0);
        });

        mostrarComparacion("INSERCION AL INICIO", arrayListAddInicio, linkedListAddInicio);

        long arrayListAddFinal = medir(() -> {
            arrayList.add(-1);
            arrayList.remove(arrayList.size() - 1);
        });

        long linkedListAddFinal = medir(() -> {
            linkedList.add(-1);
            linkedList.remove(linkedList.size() - 1);
        });

        mostrarComparacion("INSERCION AL FINAL", arrayListAddFinal, linkedListAddFinal);

        long arrayListAddMedio = medir(() -> {
            arrayList.add(POSICION_MEDIO, -1);
            arrayList.remove(POSICION_MEDIO);
        });

        long linkedListAddMedio = medir(() -> {
            linkedList.add(POSICION_MEDIO, -1);
            linkedList.remove(POSICION_MEDIO);
        });

        mostrarComparacion("INSERCION EN EL MEDIO", arrayListAddMedio, linkedListAddMedio);

        long arrayListRemoveMedio = medir(() -> {
            Integer eliminado = arrayList.remove(POSICION_MEDIO);
            arrayList.add(POSICION_MEDIO, eliminado);
        });

        long linkedListRemoveMedio = medir(() -> {
            Integer eliminado = linkedList.remove(POSICION_MEDIO);
            linkedList.add(POSICION_MEDIO, eliminado);
        });

        mostrarComparacion("ELIMINACION EN EL MEDIO", arrayListRemoveMedio, linkedListRemoveMedio);
    }

    private static void mostrarRecorridoVisual() {
        List<Integer> arrayList = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        List<Integer> linkedList = new LinkedList<>(arrayList);

        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println("ELEMENTOS Y RECORRIDO");
        System.out.println("=".repeat(70));
        mostrarEstructura("ArrayList ", arrayList);
        mostrarEstructura("LinkedList", linkedList);

        System.out.println();
        System.out.println("Acceso a la posicion 3:");
        System.out.println("ArrayList  -> salta directo al indice 3 -> " + arrayList.get(3));
        System.out.println("LinkedList -> recorre nodo por nodo hasta el indice 3");
        mostrarRecorridoIndice(linkedList, 3);

        System.out.println();
        System.out.println("Recorrido completo con for-each:");
        mostrarRecorridoCompleto("ArrayList ", arrayList);
        mostrarRecorridoCompleto("LinkedList", linkedList);
    }

    private static void mostrarEstructura(String nombre, List<Integer> lista) {
        System.out.println(nombre + ": " + lista);
    }

    private static void mostrarRecorridoIndice(List<Integer> lista, int posicionBuscada) {
        for (int i = 0; i <= posicionBuscada; i++) {
            String marca = i == posicionBuscada ? " <- encontrado" : "";
            System.out.println("  paso " + i + ": indice " + i + " = " + lista.get(i) + marca);
        }
    }

    private static void mostrarRecorridoCompleto(String nombre, List<Integer> lista) {
        System.out.print(nombre + ": ");

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));

            if (i < lista.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }

    private static long medir(Runnable operacion) {
        long inicio = System.nanoTime();
        operacion.run();
        long fin = System.nanoTime();

        return fin - inicio;
    }

    private static void mostrarComparacion(String titulo, long costoArrayList, long costoLinkedList) {
        long mayorCosto = Math.max(costoArrayList, costoLinkedList);

        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println(titulo);
        System.out.println("=".repeat(70));
        mostrarCosto("ArrayList ", costoArrayList, mayorCosto);
        mostrarCosto("LinkedList", costoLinkedList, mayorCosto);
        System.out.println("Menor costo: " + ganador(costoArrayList, costoLinkedList));
    }

    private static void mostrarCosto(String nombre, long costo, long mayorCosto) {
        int bloques = calcularBloques(costo, mayorCosto);
        String barra = "#".repeat(bloques);

        System.out.printf("%-10s %8d ns | %-40s%n", nombre, costo, barra);
    }

    private static int calcularBloques(long costo, long mayorCosto) {
        if (mayorCosto == 0) {
            return 0;
        }

        return Math.max(1, (int) ((costo * ANCHO_BARRA) / mayorCosto));
    }

    private static String ganador(long costoArrayList, long costoLinkedList) {
        if (costoArrayList < costoLinkedList) {
            return "ArrayList";
        }

        if (costoLinkedList < costoArrayList) {
            return "LinkedList";
        }

        return "Empate";
    }
}
