package instituto;
public class Empleado extends Persona {
    private float sueldo;
public Empleado(String nombre, String apellido, int dni, float sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }
    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
