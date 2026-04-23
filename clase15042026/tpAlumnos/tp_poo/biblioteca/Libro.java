package tp_poo.biblioteca;

public class Libro {
    // Atributos privados (Encapsulamiento)
    private String titulo;
    private String autor;
    private int paginas;

    // Constructor
    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        setPaginas(paginas); // Usamos el setter para aprovechar la validación
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        // Validación: no deja cargar páginas vacías o negativas
        if (paginas > 0) {
            this.paginas = paginas;
        } else {
            System.out.println("Error: El número de páginas debe ser mayor a 0. Se dejará en 1 por defecto.");
            this.paginas = 1;
        }
    }

    // Método de la Parte A
    public void mostrarInfo() {
        System.out.println("Libro: '" + titulo + "' | Autor: " + autor + " | Páginas: " + paginas);
    }
}