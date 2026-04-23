package tp_poo.personas;

public class Persona {
    protected String nombre; // protected permite que las subclases accedan al atributo
    protected DNI dni;       // Composición: una Persona "tiene un" DNI

    public Persona(String nombre, DNI dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " | DNI: " + dni.getNumero());
    }
}