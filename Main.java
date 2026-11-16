/**
 * Programa principal: Generador de Referencias APA (versión con herencia)
 * Aquí se instancian objetos de las tres subclases y se prueban
 * los métodos heredados, los sobrescritos y los exclusivos.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Instanciación de la bibliografía
        Bibliografia biblio = new Bibliografia("Referencias");

        // 2. Instanciación de objetos de las SUBCLASES
        //    (cada constructor llama internamente a super(...))

        // ----- Libros -----
        Libro l1 = new Libro(
            "Schildt, H.", 2019,
            "Java: The complete reference (11th ed.)",
            "McGraw-Hill Education");

        Libro l2 = new Libro(
            "Deitel, P., & Deitel, H.", 2016,
            "Cómo programar en Java (10a ed.)",
            "Pearson Educación");

        Libro l3 = new Libro(
            "Gamma, E., Helm, R., Johnson, R., & Vlissides, J.", 1994,
            "Design patterns: Elements of reusable object-oriented software",
            "Addison-Wesley");

        // ----- Artículos de revista -----
        ArticuloRevista a1 = new ArticuloRevista(
            "Liskov, B. H., & Wing, J. M.", 1994,
            "A behavioral notion of subtyping",
            "ACM Transactions on Programming Languages and Systems",
            16, 6, "1811–1841", "10.1145/197320.197383");

        ArticuloRevista a2 = new ArticuloRevista(
            "Snyder, A.", 1986,
            "Encapsulation and inheritance in object-oriented programming languages",
            "ACM SIGPLAN Notices",
            21, 11, "38–45", "10.1145/960112.28702");

        // ----- Sitios web -----
        SitioWeb w1 = new SitioWeb(
            "Oracle", 0,
            "Inheritance. The Java tutorials",
            "Oracle",
            "https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html");


        SitioWeb w3 = new SitioWeb(
            "GitHub", 0,
            "Creating and deleting branches within your repository",
            "GitHub Docs",
            "https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-and-deleting-branches-within-your-repository");

        // 3. Agregar a la bibliografía (en desorden a propósito).
        //    agregar() recibe Referencia, pero acepta cualquier subclase.
        System.out.println("=== Agregando fuentes ===");
        biblio.agregar(w1);
        biblio.agregar(l1);
        biblio.agregar(a1);
        biblio.agregar(l2);
        biblio.agregar(w3);
        biblio.agregar(a2);
        biblio.agregar(l3);

        // 4. Prueba de la herencia: métodos heredados, sobrescritos y exclusivos
        System.out.println("\n=== Pruebas de herencia ===");

        // Método heredado: getAutor() y getAnio() están en Referencia, no en Libro
        System.out.println("Heredado  -> l2.getAutor(): " + l2.getAutor()
                           + " | l2.getAnio(): " + l2.getAnio());

        // Método sobrescrito: el mismo formatoAPA() da resultados distintos
        System.out.println("Sobrescrito (Libro)    -> " + l2.formatoAPA());
        System.out.println("Sobrescrito (Artículo) -> " + a1.formatoAPA());
        System.out.println("Sobrescrito (Sitio)    -> " + w3.formatoAPA());

        // Métodos exclusivos de cada subclase
        System.out.println("Exclusivo -> l3.antiguedad(2026): " + l3.antiguedad(2026) + " años");
        System.out.println("Exclusivo -> a2.tieneDOI(): " + a2.tieneDOI());
        System.out.println("Exclusivo -> w1.getDominio(): " + w1.getDominio());

        // Comprobación con instanceof: un Libro también ES una Referencia
        System.out.println("¿l1 es un Libro? " + (l1 instanceof Libro));
        System.out.println("¿l1 es una Referencia? " + (l1 instanceof Referencia));

        // 5. Mostrar la bibliografía completa, ya ordenada alfabéticamente
        biblio.mostrar();
    }
}
