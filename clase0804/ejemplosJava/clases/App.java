package ejemplosJava.clases;

public class App {
    public static void main(String[] args) {
        Vehiculo miAuto = new Vehiculo(); //constructor por defecto
        miAuto.setModelo("Fiat Cronos");
        miAuto.setLargo(4.36f); 
        miAuto.setAncho(1.74f);
        miAuto.setAlto(1.5f);
        miAuto.setCant_puertas(4);
        miAuto.setAnio(2020);
        miAuto.setColor("Blanco");
        miAuto.encender();
        miAuto.encender(" - Bienvenido a bordo");
miAuto.acelerar();
        System.out.println(miAuto.toString()); 
       miAuto.acelerar(40);
        System.out.println(miAuto.toString());
  Micro miMicro = new Micro(); 
  //por ser un micro a la vez un vehículo puede usar los métodos de la clase Vehiculo, y también puede usar los métodos de la clase Micro, por ejemplo el método encender, que es un método de la clase Vehiculo, y el método setCant_asientos, que es un método de la clase Micro.
    miMicro.encender();
        miMicro.setModelo("Mercedes Benz Sprinter");
        miMicro.setLargo(6.96f); 
        miMicro.setAncho(2.02f);
        miMicro.setAlto(2.7f);
        miMicro.setCant_puertas(4);
        miMicro.setAnio(2021);
        miMicro.setColor("Gris");
        miMicro.setCant_asientos(20); 
        System.out.println(miMicro.toString());
    }
}
