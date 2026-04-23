package abstraccion;
public abstract class Figura {
    private static double pi=Math.PI;
    private String color;
    private String unidadDeMedida;
    public Figura(String color, String unidadDeMedida) {
        this.color = color;
        this.unidadDeMedida = unidadDeMedida;
    }
    public static double getPi() {
        return pi;
    }

public String getColor() {
        return color;
    }
    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }   
    public String toString() {
        return "Figura{" + "color=" + color + ", unidadDeMedida=" + unidadDeMedida + '}';
    }   
    public abstract String calcularArea();
    public abstract String calcularPerimetro();
}