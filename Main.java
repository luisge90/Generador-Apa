/**
 * Programa principal: Generador de Referencias APA
 * Aquí se instancian los objetos y se prueban sus métodos.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Instanciación de un objeto Bibliografia
        Bibliografia biblio = new Bibliografia("Referencias");

        // 2. Instanciación de varios objetos Referencia usando el constructor
        Referencia r1 = new Referencia(
            "Schildt, H.", 2019,
            "Java: The complete reference (11th ed.)",
            "McGraw-Hill Education");

        Referencia r2 = new Referencia(
            "Deitel, P., & Deitel, H.", 2016,
            "Cómo programar en Java (10a ed.)",
            "Pearson Educación");

        Referencia r3 = new Referencia(
            "Joyanes Aguilar, L., & Zahonero Martínez, I.", 2011,
            "Programación en Java 6: Algoritmos, programación orientada a objetos e interfaz gráfica de usuarios",
            "McGraw-Hill");

        Referencia r4 = new Referencia(
            "Gamma, E., Helm, R., Johnson, R., & Vlissides, J.", 1994,
            "Design patterns: Elements of reusable object-oriented software",
            "Addison-Wesley");

        // 3. Uso de métodos: agregar las referencias (en desorden a propósito)
        biblio.agregar(r1);
        biblio.agregar(r2);
        biblio.agregar(r3);
        biblio.agregar(r4);

        // 4. Prueba de un método individual de Referencia
        System.out.println("\nPrueba de formatoAPA() en un solo objeto:");
        System.out.println(r2.formatoAPA());

        // 5. Mostrar la bibliografía completa, ya ordenada alfabéticamente
        biblio.mostrar();
    }
}
