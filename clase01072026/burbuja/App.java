package burbuja;

public class App {
    public static void main(String[] args) {

        int[] numeros = {5, 3, 8, 1};

        for (int i = 0; i < numeros.length-1; i++) {

            if (numeros[i] > numeros[i + 1]) {
                int aux = numeros[i];
                numeros[i] = numeros[i + 1];
                numeros[i + 1] = aux;
            }
        }
        System.out.println("Array ordenado luego de una primer pasada: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}
