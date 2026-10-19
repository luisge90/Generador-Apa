import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase Bibliografia
 * Agrupa varios objetos Referencia, los ordena alfabéticamente
 * por autor (como lo pide APA) y los imprime como lista final.
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
     * Agrega un objeto Referencia a la lista.
     */
    public void agregar(Referencia ref) {
        referencias.add(ref);
        System.out.println("Agregada: " + ref.getAutor() + " (" + ref.getAnio() + ")");
    }

    /**
     * Ordena las referencias alfabéticamente por apellido del autor.
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
     * Ordena e imprime todas las referencias en formato APA.
     */
    public void mostrar() {
        ordenar();
        System.out.println("\n===== " + nombre + " =====\n");
        for (Referencia ref : referencias) {
            System.out.println(ref.formatoAPA() + "\n");
        }
        System.out.println("Total de referencias: " + getTotal());
    }
}
