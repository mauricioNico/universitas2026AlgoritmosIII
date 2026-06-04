import java.util.Scanner;
public class App {

    public static void main(String[] args) {

        Arbol arbol = new Arbol();
       int cantidadDeNodos, valorNodo;
Scanner scanner = new Scanner(System.in);
cantidadDeNodos = verificarEntrada(scanner, "Ingrese la cantidad de nodos que desea agregar al árbol:");
for(int i = 0; i < cantidadDeNodos; i++){
valorNodo = verificarEntrada(scanner, "Ingrese el valor del nodo:");
arbol.insertar(valorNodo);
}
/*
arbol.insertar(50);
arbol.insertar(30);
arbol.insertar(70);
arbol.insertar(20);
arbol.insertar(40);
arbol.insertar(60);
arbol.insertar(80); 
*/
System.out.println("Recorrido Preorden:");
arbol.preOrden();
System.out.println("\nRecorrido Inorden:");     
arbol.inOrden();
System.out.println("\nRecorrido Postorden:");
arbol.postOrden();
System.out.println("\nRecorrido por niveles (BFS):");
arbol.bfs();
}
private static int verificarEntrada(Scanner sc, String mensaje) {
    System.out.println(mensaje);
    while (!sc.hasNextInt()) {
        System.out.println("Error. Debe ingresar un número entero:");
        sc.next(); // Limpiar el buffer
    }

        return sc.nextInt();
    }
}