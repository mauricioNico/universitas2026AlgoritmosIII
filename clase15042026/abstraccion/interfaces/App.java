package abstraccion.interfaces;

public class App {
    public static void main(String[] args) {        
        Televisor tv = new Televisor();       
        Computadora pc = new Computadora();
         // Método abstracto implementado
        tv.encender();        
        // Método default (ya viene implementado)
        tv.mostrarInfo();       
        // Método static de la interfaz
        Dispositivo.mensajeGeneral();        
        // Acceso a constantes
        System.out.println(Dispositivo.MARCA);    
        // Método abstracto implementado
        pc.encender();        
        // Método default (ya viene implementado)
        pc.mostrarInfo();   
        // Método static de la interfaz 
        Dispositivo.mensajeGeneral();
        // Acceso a constantes
        System.out.println(Dispositivo.VOLTAJE_MAXIMO);
            
    }
}
