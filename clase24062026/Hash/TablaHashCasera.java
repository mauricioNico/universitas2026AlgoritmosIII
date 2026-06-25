package Hash;
import java.util.LinkedList;

public class TablaHashCasera {

    private LinkedList<Alumno>[] tabla;
    private int tamanio;

    public TablaHashCasera(int tamanio) {
        this.tamanio = tamanio;
        this.tabla = new LinkedList[tamanio];

        for (int i = 0; i < tamanio; i++) {
            tabla[i] = new LinkedList<>();
        }
    }
//la función de hash se genera en este caso a partir
//del número de legajo
    private int obtenerIndice(int legajo) {
        return (legajo % tamanio); 
    }
/*
* cada alumno nuevo que se agrega a la coleccion se le 
asigna una posición de acuerdo a número de hash generado
por la función.
*/
    public void agregar(Alumno alumno) {
        int indice = obtenerIndice(alumno.getLegajo());

        tabla[indice].add(alumno);

        System.out.println("Alumno " + alumno.getNombre()
                + " guardado en posición " + indice);
    }

    public Alumno buscar(int legajo) {
        int indice = obtenerIndice(legajo);

        for (Alumno alumno : tabla[indice]) {
            if (alumno.getLegajo() == legajo) {
                return alumno;
            }
        }

        return null;
    }

    public void mostrarTabla() {
        for (int i = 0; i < tabla.length; i++) {
            System.out.println("Posición " + i + ": " + tabla[i]);
        }
    }
}
