package poli;

public class Perro extends Animal {
    public Perro() {
    }
    public Perro(String nombre) {
        super(nombre);
    }
    public String getNombre() {
        return super.getNombre();
    }   
    @Override //polimorfismo de sobreescritura o redefinicion (aplica en herencia)
    public void hacerSonido() {
        System.out.println("El perro ladra");
    }
    
}
