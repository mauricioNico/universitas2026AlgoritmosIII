package tp_poo.personas;

public class Alumno extends Persona {
    private String legajo;

    public Alumno(String nombre, DNI dni, String legajo) {
        super(nombre, dni); // Llama al constructor de Persona
        this.legajo = legajo;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // Llama al mostrarDatos de Persona
        System.out.println("Rol: Alumno | Legajo: " + legajo);
    }
}
