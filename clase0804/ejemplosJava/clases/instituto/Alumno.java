package instituto;

public class Alumno extends Persona {
    private String legajo;
    public Alumno(String nombre, String apellido, int dni, String legajo) {
        super(nombre, apellido, dni);
        this.legajo = legajo;
    }
  public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Legajo: " + legajo);
    }  
}
