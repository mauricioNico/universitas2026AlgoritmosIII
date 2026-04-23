package tp_poo.personas;

public class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, DNI dni, String materia) {
        super(nombre, dni);
        this.materia = materia;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Rol: Profesor | Materia: " + materia);
    }
}