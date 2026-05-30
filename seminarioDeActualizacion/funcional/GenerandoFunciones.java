public class GenerandoFunciones {
    public static void main(String[] args) {
        Operacion suma = (a, b) -> a + b;
        double resultado = suma.ejecutar(5, 3);
        System.out.println("El resultado de la suma es: " + resultado);
        Operacion potencia = (a, b) -> Math.pow(a, b);
        double resultadoPotencia = potencia.ejecutar(6, 3); 
        System.out.println("El resultado de la potencia es: " + resultadoPotencia);
        Operacion cociente = (a, b) -> a / b;
        double resultadoCociente = cociente.ejecutar(10, 2);    
        System.out.println("El resultado del cociente es: " + resultadoCociente);
   
    }
}
