package abstraccion;

public class App {
    public static void main(String[] args) {
        Circulo circulo = new Circulo("Rojo", "cm", 5);
        Rectangulo rectangulo = new Rectangulo("Azul", "mm", 4, 6);
        System.out.println(circulo.toString());
        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro());
        System.out.println(rectangulo.toString());
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        System.out.println("Perímetro del rectángulo: " + rectangulo.calcularPerimetro());
    }
}
