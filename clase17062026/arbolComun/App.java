package clase17062026.arbolComun;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la ruta de una carpeta:");
        String ruta = sc.nextLine();

        File carpeta = new File(ruta);

        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La ruta no existe o no es una carpeta.");
            sc.close();
            return;
        }

        ExploradorArchivos explorador =
                new ExploradorArchivos(ruta);

        System.out.println("\nESTRUCTURA GENERAL:\n");
        explorador.mostrarEstructura();

        ArbolBST<Archivo> arbolBST = new ArbolBST<>();
        TreeSet<Archivo> treeSet = new TreeSet<>();

        File[] elementos = carpeta.listFiles();

        if (elementos != null) {

            for (File elemento : elementos) {

                if (elemento.isFile()) {

                    Archivo archivo =
                            Archivo.desdeFile(elemento);

                    arbolBST.insertar(archivo);

                    treeSet.add(archivo);
                }
            }
        }

        System.out.println("\nRECORRIDO BFS DEL BST:\n");
        arbolBST.recorrerBFS();

        System.out.println("\nARCHIVOS ORDENADOS CON TREESET:\n");

        for (Archivo archivo : treeSet) {
            System.out.println(archivo);
        }

        System.out.println("\nIngrese un archivo a buscar:");
        String nombreBuscado = sc.nextLine();

        Archivo archivoBuscado =
                new Archivo(nombreBuscado);

        System.out.println("\nBÚSQUEDA EN BST:");

        if (arbolBST.buscar(archivoBuscado)) {
            System.out.println("Archivo encontrado en el BST.");
        } else {
            System.out.println("Archivo no encontrado en el BST.");
        }

        System.out.println("\nBÚSQUEDA EN TREESET:");

        if (treeSet.contains(archivoBuscado)) {
            System.out.println("Archivo encontrado en el TreeSet.");
        } else {
            System.out.println("Archivo no encontrado en el TreeSet.");
        }

        sc.close();
    }
}

