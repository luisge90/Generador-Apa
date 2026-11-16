/**
 * Clase base Referencia
 * --------------------------------------------------------------
 * En la Actividad 2 esta clase representaba solo un libro.
 * En la Actividad 3 se convierte en la CLASE BASE (superclase):
 * guarda lo que TODA fuente tiene en común (autor, año y título)
 * y define los métodos que las clases derivadas van a reutilizar
 * o a sobrescribir.
 *
 * Clases derivadas (subclases) que heredan de Referencia:
 *   - Libro            (agrega editorial)
 *   - ArticuloRevista  (agrega revista, volumen, número, páginas y DOI)
 *   - SitioWeb         (agrega nombre del sitio y URL)
 */
public class Referencia {

    // ===== Atributos comunes a cualquier fuente =====
    // Siguen siendo private (encapsulamiento): las subclases
    // no los tocan directamente, los consultan con los getters.
    private String autor;
    private int anio;       // 0 significa "sin fecha" (s.f.)
    private String titulo;

    /**
     * Constructor de la clase base.
     * Las subclases lo llaman con super(autor, anio, titulo)
     * para no repetir este código en cada una.
     */
    public Referencia(String autor, int anio, String titulo) {
        this.autor = autor;
        this.anio = anio;
        this.titulo = titulo;
    }

    // ===== Métodos de acceso (getters), heredados por todas las subclases =====
    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     * Método reutilizable: arma la parte "Autor (Año). " que es
     * igual en todos los tipos de fuente APA.
     * Es protected para que solo esta clase y sus subclases lo usen.
     * Si el año es 0, APA pide escribir (s.f.).
     */
    protected String autorYAnio() {
        String fecha = (anio == 0) ? "s.f." : String.valueOf(anio);
        // Un autor persona termina en inicial con punto ("Schildt, H.");
        // un autor institucional ("Oracle") necesita que se le agregue el punto.
        String nombre = autor.endsWith(".") ? autor : autor + ".";
        return nombre + " (" + fecha + "). ";
    }

    /**
     * Tipo de fuente. Cada subclase lo sobrescribe con su propio tipo.
     */
    public String getTipo() {
        return "Fuente general";
    }

    /**
     * Cita APA genérica: Autor (Año). Título.
     * Cada subclase la sobrescribe (@Override) para agregar
     * los datos propios de su tipo de fuente.
     */
    public String formatoAPA() {
        return autorYAnio() + titulo + ".";
    }

    /**
     * Descripción corta que usa Bibliografia al agregar una fuente.
     * SitioWeb la amplía llamando a super.describir().
     */
    public String describir() {
        return "[" + getTipo() + "] " + autor;
    }
}
