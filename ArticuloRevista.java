/**
 * Clase derivada ArticuloRevista
 * --------------------------------------------------------------
 * Hereda de Referencia y agrega los datos de una revista científica.
 *
 * Formato APA 7 de un artículo:
 *   Autor, A. (Año). Título del artículo. Nombre de la Revista,
 *   volumen(número), páginas. https://doi.org/xxxx
 */
public class ArticuloRevista extends Referencia {

    // ===== Atributos exclusivos de la subclase =====
    private String revista;
    private int volumen;
    private int numero;
    private String paginas;
    private String doi;   // puede quedar vacío si el artículo no tiene DOI

    /**
     * Constructor: los tres datos comunes van a la clase base con super(...).
     */
    public ArticuloRevista(String autor, int anio, String titulo,
                           String revista, int volumen, int numero,
                           String paginas, String doi) {
        super(autor, anio, titulo);
        this.revista = revista;
        this.volumen = volumen;
        this.numero = numero;
        this.paginas = paginas;
        this.doi = doi;
    }

    @Override
    public String getTipo() {
        return "Artículo de revista";
    }

    /**
     * Sobrescritura de formatoAPA(): reutiliza autorYAnio() de la clase base
     * y arma el resto con los datos de la revista.
     */
    @Override
    public String formatoAPA() {
        String cita = autorYAnio() + getTitulo() + ". "
                    + revista + ", " + volumen + "(" + numero + "), " + paginas + ".";
        if (tieneDOI()) {
            cita += " https://doi.org/" + doi;
        }
        return cita;
    }

    /**
     * Método exclusivo de ArticuloRevista: indica si el artículo tiene DOI.
     * APA 7 pide incluir el DOI siempre que exista.
     */
    public boolean tieneDOI() {
        return doi != null && !doi.isEmpty();
    }
}
