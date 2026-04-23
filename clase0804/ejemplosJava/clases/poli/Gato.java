package poli;

public class Gato extends Animal {
   public Gato() {
    }
    public Gato(String nombre) {
        super(nombre);
    }
    public String getNombre() {
        return super.getNombre();
    }
    @Override //polimorfismo de sobreescritura o redefinicion (aplica en herencia)
    public void hacerSonido() {
        System.out.println("El gato maulla");
    }
}
