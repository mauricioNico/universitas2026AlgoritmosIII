package tp_poo.vehiculos;

public abstract class Vehiculo {
private String patente;

public String getPatente() {
    return patente; 
}
public void setPatente(String patente) {
    this.patente = patente; 
}


    public void acelerar() {
        System.out.println("El vehículo está acelerando...");
    }
    
    public abstract void frenar(); // Método abstracto, cada vehículo lo implementará a su manera, es obligatorio que cada clase hija lo implemente
}
