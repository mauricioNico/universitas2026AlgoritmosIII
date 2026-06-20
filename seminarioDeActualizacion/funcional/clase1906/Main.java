package clase1906;

public class Main {
    public static void main(String[] args) {
        Operacion suma=new Operacion() {
            public int calcular(int a, int b)
            {
                return a+b;
            }
        };
   System.out.println(suma.calcular(1,2)); }
}
