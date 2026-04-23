package tp_poo;
import tp_poo.biblioteca.Libro;
import tp_poo.personas.Alumno;
import tp_poo.personas.DNI;
import tp_poo.personas.Profesor;
import tp_poo.vehiculos.Auto;
import tp_poo.vehiculos.Camion;
import tp_poo.vehiculos.Micro;
import tp_poo.vehiculos.Vehiculo;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- PRUEBA PARTE A y B: LIBRO ---");
        Libro l1 = new Libro("Java Básico", "Perez", 200);
        l1.mostrarInfo();
        
        // Probando validación
        Libro l2 = new Libro("Libro Roto", "Gomez", -5);
        l2.mostrarInfo();

        System.out.println("\n--- PRUEBA PARTE C: HERENCIA ---");
        DNI dni1 = new DNI("40123456", "A");
        DNI dni2 = new DNI("30987654", "B");
        
        Alumno alumno = new Alumno("Lucas", dni1, "LEG-1001");
        Profesor profe = new Profesor("Marta", dni2, "Algoritmos");
        
        alumno.mostrarDatos();
        System.out.println("-");
        profe.mostrarDatos();

        System.out.println("\n--- PRUEBA PARTE D: POLIMORFISMO ---");
        // Arrays de la clase padre para ver el polimorfismo en acción
        //se usa el constructor por defecto de cada clase hija, que a su vez llama al constructor de la clase padre 
        Vehiculo[] flota = new Vehiculo[3];
        flota[0] = new Auto();
        flota[1] = new Camion();
        flota[2] = new Micro() {
            
        };
flota[0].setPatente("ABC123"); 
        // Recorremos y le decimos "acelerar" y "frenar" a cada uno
        for (Vehiculo v : flota) {
            v.acelerar();
            v.frenar();
            System.out.println();
        }
   
    }
}