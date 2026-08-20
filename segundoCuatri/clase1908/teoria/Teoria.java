package teoria;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Contiene ejemplos básicos de representación de distintos tipos de grafos.
 */
public class Teoria {
/**
 * Ejecuta ejemplos de grafos generales, dirigidos, no dirigidos y ponderados.
 *
 * @param args argumentos de línea de comandos; no se utilizan
 */
public static void main(String[] args) {
    //grafo general:
      Set<String> vertices = Set.of("A", "B", "C");
      List<String> aristas = List.of("A-B", "B-C");
        for(String vertice : vertices) 
        System.out.println(vertice);
        System.out.println("Aristas: " + aristas);
    //grafo no dirigido, los vertices se representan con aristas que no tienen sentido definido, es decir, no hay un origen ni un destino, solo una conexión entre dos vertices.
    Map <String, List<String>> grafoNoDirigido = new HashMap<>();
grafoNoDirigido.put("Buenos Aires", new ArrayList<>());
grafoNoDirigido.put("La Plata", new ArrayList<>());
grafoNoDirigido.get("Buenos Aires").add("La Plata");
grafoNoDirigido.get("La Plata").add("Buenos Aires");
System.out.println("Grafo no dirigido: " + grafoNoDirigido);
      Map <String, List<String>> grafoDirigido = new HashMap<>();
      grafoDirigido.put("Buenos Aires", new ArrayList<>());
      grafoDirigido.get("Buenos Aires").add("La Plata");
      System.out.println("Grafo dirigido: " + grafoDirigido);
//grafo ponderado, los vertices se representan con aristas que tienen un peso o costo asociado, que puede ser una distancia, un tiempo, un costo monetario, etc.
      Map <String, List<AristaPonderada>> grafoPonderado = new HashMap<>();
      grafoPonderado.put("Buenos Aires", new ArrayList<>());
      grafoPonderado.get("Buenos Aires").add(new AristaPonderada("La Plata", 60));
      System.out.println("Grafo ponderado: " + grafoPonderado);
      //grado de un vertice, es el número de aristas que inciden en un vertice, es decir, el número de conexiones que tiene un vertice con otros vertices.
      grafoNoDirigido.get("Buenos Aires").add("Rosario");
      System.out.println("Grafo no dirigido con nuevo vértice: " + grafoNoDirigido);
      int gradoBuenosAires = grafoNoDirigido.get("Buenos Aires").size();
      System.out.println("Grado de Buenos Aires: " + gradoBuenosAires);
    }
}
