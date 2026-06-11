package casero;

public class AppBST {

    public static void main(String[] args) {
/*        Arbol<Archivo> arbol = new Arbol<>();

        arbol.insertar(new Archivo("informe", "pdf", 120));
        arbol.insertar(new Archivo("foto", "jpg", 450));
        arbol.insertar(new Archivo("datos", "csv", 80));
        arbol.insertar(new Archivo("resumen", "docx", 100));
        arbol.insertar(new Archivo("apuntes", "pdf", 200));
        arbol.insertar(new Archivo("trabajo", "docx", 300));
        arbol.insertar(new Archivo("backup", "zip", 1000));

        System.out.println("RECORRIDO INORDEN:");
        arbol.inOrden();
        System.out.println("\nRECORRIDO PREORDEN:");
        arbol.preOrden();
        System.out.println("\nRECORRIDO POSTORDEN:");
        arbol.postOrden();
        System.out.println("\nRecorrido por niveles:");
        arbol.bfs();
        System.out.println("\nBÚSQUEDA DE ARCHIVOS:");

        buscarArchivo(arbol, new Archivo("datos", "csv", 0));
        buscarArchivo(arbol, new Archivo("presentacion", "pptx", 0));
        buscarArchivo(arbol, new Archivo("backup", "zip", 0));
    }

    private static void buscarArchivo(Arbol<Archivo> arbol, Archivo archivo) {
        if (arbol.buscar(archivo)) {
            System.out.println(archivo.getNombreCompleto() + " encontrado");
        } else {
            System.out.println(archivo.getNombreCompleto() + " no encontrado");
         }
  
 /*ejemplo de carga de materias */
 Arbol<String> materias = new Arbol<>();

        materias.insertar("Algoritmos y Estructuras de Datos III");
        materias.insertar("Bases de Datos");
         materias.insertar("Ingles");
         materias.insertar("Inteligencia Artificial");
        materias.insertar("Programación Orientada a Objetos");
        materias.insertar("Redes de Computadoras");
     
        materias.insertar("Seminario de Actualización");
        materias.insertar("Sistemas Operativos");
        
       
       materias.imprimirArbol(); 
    }
}