/**
 * Clase Referencia
 * Representa una fuente bibliográfica (un libro) y sabe
 * presentarse a sí misma en formato APA 7.
 */
public class Referencia {

    // ===== Atributos (privados para aplicar encapsulamiento) =====
    private String autor;
    private int anio;
    private String titulo;
    private String editorial;

    /**
     * Constructor: se ejecuta al crear (instanciar) un objeto Referencia
     * y asigna los valores iniciales de sus atributos.
     */
    public Referencia(String autor, int anio, String titulo, String editorial) {
        this.autor = autor;
        this.anio = anio;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    // ===== Métodos de acceso (getters) =====
    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    /**
     * Método principal de la clase: arma la cita en formato APA.
     * Estructura: Autor, A. (Año). Título. Editorial.
     */
    public String formatoAPA() {
        return autor + " (" + anio + "). " + titulo + ". " + editorial + ".";
    }
}
