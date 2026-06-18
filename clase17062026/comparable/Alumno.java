
public class Alumno implements Comparable<Alumno> {

    private String nombre;
    private Integer legajo; //para numeros enteros uso Integer 
    // en lugar de int y compareTo funciona naturalmente 

    public Alumno(String nombre, Integer legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }
public String getNombre() {
        return nombre;
    }
    public Integer getLegajo() {
        return legajo;
    }

    @Override
    public String toString() {
        return nombre + " - " + legajo;
    }

    @Override
    public int compareTo(Alumno other) {
        //comparar por nombre y luego por legajo

        int result = this.getNombre().compareTo(other.getNombre());
        if (result == 0) {
            result = this.getLegajo().compareTo(other.getLegajo());
        }
        return result;
    }
}