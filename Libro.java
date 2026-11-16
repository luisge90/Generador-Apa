/**
 * Clase derivada Libro
 * --------------------------------------------------------------
 * Hereda de Referencia (extends) todo lo que tiene una fuente:
 * autor, año, título, getters y autorYAnio().
 * Solo agrega lo que es propio de un libro: la editorial.
 *
 * Formato APA 7 de un libro:
 *   Autor, A. (Año). Título del libro. Editorial.
 */
public class Libro extends Referencia {

    // ===== Atributo exclusivo de la subclase =====
    private String editorial;

    /**
     * Constructor: los datos comunes se mandan a la clase base
     * con super(...) y aquí solo se guarda la editorial.
     */
    public Libro(String autor, int anio, String titulo, String editorial) {
        super(autor, anio, titulo);   // llamada al constructor de Referencia
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    /**
     * Sobrescritura (override) del tipo de fuente.
     */
    @Override
    public String getTipo() {
        return "Libro";
    }

    /**
     * Sobrescritura de formatoAPA(): reutiliza la cita genérica de la
     * clase base (super.formatoAPA() ya da "Autor (Año). Título.")
     * y solo le añade la editorial.
     */
    @Override
    public String formatoAPA() {
        return super.formatoAPA() + " " + editorial + ".";
    }

    /**
     * Método exclusivo de Libro: calcula cuántos años tiene la edición.
     * Sirve para detectar libros que quizá ya tengan una edición más nueva.
     */
    public int antiguedad(int anioActual) {
        return anioActual - getAnio();   // usa el getter heredado
    }
}
