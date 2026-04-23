package abstraccion.interfaces;

public interface Dispositivo {
     // Atributos (constantes)
    int VOLTAJE_MAXIMO = 220;      // public static final implícito
    String MARCA = "Genérica";     // constante
    // Método abstracto
    void encender();    
    // Método default (solo funciona o es visible para las instancias de la clase que implementa la interfaz)
    default void mostrarInfo() 
    {       
         System.out.println("Marca: " + MARCA);        System.out.println("Voltaje máximo: " + VOLTAJE_MAXIMO);
    }    
    // Método static
    static void mensajeGeneral() 
    {        
            System.out.println("Todos los dispositivos deben ser seguros.");   
         }
    }




