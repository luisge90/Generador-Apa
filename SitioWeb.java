/**
 * Clase derivada SitioWeb
 * --------------------------------------------------------------
 * Hereda de Referencia y agrega el nombre del sitio y la URL.
 *
 * Formato APA 7 de una página web:
 *   Autor. (Año o s.f.). Título de la página. Nombre del sitio. URL
 * Si el autor y el sitio son el mismo (por ejemplo, Oracle),
 * APA pide omitir el nombre del sitio para no repetirlo.
 */
public class SitioWeb extends Referencia {

    // ===== Atributos exclusivos de la subclase =====
    private String nombreSitio;
    private String url;

    public SitioWeb(String autor, int anio, String titulo,
                    String nombreSitio, String url) {
        super(autor, anio, titulo);
        this.nombreSitio = nombreSitio;
        this.url = url;
    }

    @Override
    public String getTipo() {
        return "Sitio web";
    }

    /**
     * Sobrescritura de formatoAPA(): reutiliza autorYAnio() de la clase base.
     */
    @Override
    public String formatoAPA() {
        String cita = autorYAnio() + getTitulo() + ". ";
        // Si el sitio se llama igual que el autor, no se repite
        if (!getAutor().startsWith(nombreSitio)) {
            cita += nombreSitio + ". ";
        }
        return cita + url;
    }

    /**
     * Sobrescritura de describir(): primero llama al método de la clase
     * base con super.describir() y luego le agrega el dominio.
     */
    @Override
    public String describir() {
        return super.describir() + " (en línea: " + getDominio() + ")";
    }

    /**
     * Método exclusivo de SitioWeb: extrae el dominio de la URL.
     * Ejemplo: https://docs.oracle.com/javase/... -> docs.oracle.com
     */
    public String getDominio() {
        String sinProtocolo = url.replaceFirst("^https?://", "");
        int barra = sinProtocolo.indexOf('/');
        return (barra == -1) ? sinProtocolo : sinProtocolo.substring(0, barra);
    }
}
