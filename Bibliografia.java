import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase Bibliografia
 * --------------------------------------------------------------
 * Agrupa varias referencias, las ordena alfabéticamente por autor
 * (como lo pide APA) y las imprime como lista final.
 *
 * Cambio en la Actividad 3: la lista es de tipo Referencia (la clase
 * base), así que puede guardar Libros, Artículos y Sitios web juntos.
 * Al llamar formatoAPA() Java ejecuta la versión de cada subclase.
 */
public class Bibliografia {

    // ===== Atributos =====
    private String nombre;
    private ArrayList<Referencia> referencias;

    /**
     * Constructor: recibe el nombre de la bibliografía
     * y crea una lista vacía para guardar las referencias.
     */
    public Bibliografia(String nombre) {
        this.nombre = nombre;
        this.referencias = new ArrayList<>();
    }

    /**
     * Agrega cualquier objeto que herede de Referencia.
     * describir() se resuelve según la subclase del objeto.
     */
    public void agregar(Referencia ref) {
        referencias.add(ref);
        System.out.println("Agregada: " + ref.describir());
    }

    /**
     * Ordena las referencias alfabéticamente por apellido del autor.
     * getAutor() es un método heredado de la clase base.
     */
    public void ordenar() {
        referencias.sort(Comparator.comparing(Referencia::getAutor));
    }

    /**
     * Devuelve cuántas referencias contiene la bibliografía.
     */
    public int getTotal() {
        return referencias.size();
    }

    /**
     * Nuevo en la Actividad 3: cuenta cuántas fuentes hay de un tipo.
     * Usa getTipo(), que cada subclase sobrescribe.
     */
    public int contarPorTipo(String tipo) {
        int contador = 0;
        for (Referencia ref : referencias) {
            if (ref.getTipo().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Ordena e imprime todas las referencias en formato APA,
     * y al final un resumen por tipo de fuente.
     */
    public void mostrar() {
        ordenar();
        System.out.println("\n===== " + nombre + " =====\n");
        for (Referencia ref : referencias) {
            System.out.println(ref.formatoAPA() + "\n");
        }
        System.out.println("Total de referencias: " + getTotal());
        System.out.println("  Libros: " + contarPorTipo("Libro"));
        System.out.println("  Artículos de revista: " + contarPorTipo("Artículo de revista"));
        System.out.println("  Sitios web: " + contarPorTipo("Sitio web"));
    }
}
