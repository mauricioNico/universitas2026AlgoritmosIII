package abstraccion;

public class Circulo extends Figura {
    private double radio;
    public Circulo(String color, String unidadDeMedida, double radio) {
        super(color, unidadDeMedida);
        this.radio = radio;
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    @Override
    public String calcularArea() {
        return String.format("%.2f", Figura.getPi() * radio * radio) + " " + getUnidadDeMedida()+"²";
    }
    @Override
    public String calcularPerimetro() {
        return String.format("%.2f", 2 * Figura.getPi() * radio) + " " + getUnidadDeMedida();
    }
        @Override
public String toString() {
        return "Circulo{" + "radio=" + radio + ", color=" + getColor() + ", unidadDeMedida=" + getUnidadDeMedida() + '}';
    }
}
