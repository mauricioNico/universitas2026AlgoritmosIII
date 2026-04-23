package abstraccion;

public class Rectangulo extends Figura {
    private double base;
    private double altura;
    public Rectangulo(String color, String unidadDeMedida, double base, double altura) {
        super(color, unidadDeMedida);
        this.base = base;
        this.altura = altura;
    }
    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    @Override
    public String calcularArea() {
        return String.format("%.2f", base * altura) + " " + getUnidadDeMedida()+"²";
    }
    @Override
    public String calcularPerimetro() {
        return String.format("%.2f", 2 * (base + altura)) + " " + getUnidadDeMedida();
    }
    @Override
public String toString() {
        return "Rectangulo{" + "base=" + base + ", altura=" + altura + ", color=" + getColor() + ", unidadDeMedida=" + getUnidadDeMedida() + '}';
    }
}