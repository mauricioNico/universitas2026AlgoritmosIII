package poli;

public abstract class Animal {
    private String nombre;
    public Animal() {
    }
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}
