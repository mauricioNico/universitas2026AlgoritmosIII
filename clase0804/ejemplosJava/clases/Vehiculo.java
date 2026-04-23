package ejemplosJava.clases;

public class Vehiculo {
    private String modelo;
    private float largo, ancho, alto;
    private int cant_puertas;
    private int anio;
    private String color;
    private int velocidad;

    //uso de getters y setters
    public String getModelo() {
        return modelo;
    }   
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public float getLargo() {
        return largo;
    }
    public void setLargo(float largo) {
        this.largo = largo;
    }
    public float getAncho() {
        return ancho;
    }
    public void setAncho(float ancho) {
        this.ancho = ancho;
    }
    public float getAlto() {
        return alto;
    }
    public void setAlto(float alto) {
        this.alto = alto;
    }
    public int getCant_puertas() {
        return cant_puertas;
    }
    public void setCant_puertas(int cant_puertas) {
        this.cant_puertas = cant_puertas;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    //toString, sobrescribimos el método toString para mostrar la información del auto de forma legible, polimorfismo, el método toString es heredado de la clase Object, y lo sobrescribimos para mostrar la información del auto de forma legible. Polimorfismo por redefinición, el método toString es redefinido en la clase Auto, y se llama al método toString de la clase Object para mostrar la información del auto de forma legible.
    @Override   
    public String toString() {
        return "Auto [modelo=" + modelo + ", largo=" + largo + ", ancho=" + ancho + ", alto=" + alto
                + ", cant_puertas=" + cant_puertas + ", anio=" + anio + ", color=" + color + ", velocidad=" + velocidad + "km/h]";
    }
    //polimofirmo por sobrecarga, el mismo método cambia por la cantidad de arguementos, el método encender es sobrecargado, el primer método no recibe argumentos, y el segundo método recibe un argumento de tipo String, el método acelerar es sobrecargado, el primer método recibe un argumento de tipo int, y el segundo método no recibe argumentos.
    public void encender() {
        System.out.println("El vehículo está encendido");
        }
        
    public void encender(String mensaje)
        {
            System.out.println("El vehiculo está encendido: " + mensaje);
        }

    public void acelerar(int cantidadKm)
        {
            this.velocidad += cantidadKm;
        }
        public void acelerar()
        {
            this.velocidad += 10;
 
        }
}   

