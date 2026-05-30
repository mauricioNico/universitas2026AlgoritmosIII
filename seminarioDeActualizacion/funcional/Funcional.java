import java.util.List;

public class Funcional {

    public static void main(String[] args) {

        List<String> nombres =
                List.of("Juan", "Ana", "Pedro");

        nombres.forEach(
                nombre -> System.out.println(nombre)
        );
    }
}