package instituto;

public class Profesor extends Empleado {
    private String [] materias;

    public Profesor(String nombre, String apellido, int dni, String[] materias, float sueldo) {
        super(nombre, apellido, dni, sueldo);
        this.materias = materias;
    }
    public Profesor(String nombre, String apellido, int dni, String[] materias) {
        super(nombre, apellido, dni, 0);
        this.materias = materias;
    }
    public String[] getMaterias() {
        return materias;
    }
    public void setMaterias(String[] materias) {
        this.materias = materias;
    }   
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.print("Materias que el profesor imparte: ");
        //for each para recorrer el array de materias
        for (String materia : materias) {
            System.out.print(materia + " ");
        }
        System.out.println();
    }
    
}
