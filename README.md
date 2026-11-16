# Generador de Referencias APA

Aplicación sencilla en Java para Programación Orientada a Objetos.

- **Rama `main`**: versión de la Actividad Formativa 2 (solo libros).
- **Rama `herencia`**: versión de la Actividad Formativa 3, extendida con herencia.

## Estructura (rama herencia)
- **Referencia.java**: clase base. Atributos comunes (autor, año, título), getters, `autorYAnio()` (protected), `getTipo()`, `formatoAPA()` y `describir()`.
- **Libro.java**: hereda de Referencia. Agrega `editorial`; sobrescribe `getTipo()` y `formatoAPA()` (usando `super.formatoAPA()`); método exclusivo `antiguedad()`.
- **ArticuloRevista.java**: hereda de Referencia. Agrega revista, volumen, número, páginas y DOI; sobrescribe `getTipo()` y `formatoAPA()`; método exclusivo `tieneDOI()`.
- **SitioWeb.java**: hereda de Referencia. Agrega nombre del sitio y URL; sobrescribe `getTipo()`, `formatoAPA()` y `describir()` (usando `super.describir()`); método exclusivo `getDominio()`.
- **Bibliografia.java**: guarda cualquier tipo de Referencia, las ordena por autor y las imprime. Nuevo método `contarPorTipo()`.
- **Main.java**: programa principal. Instancia objetos de las tres subclases y prueba métodos heredados, sobrescritos y exclusivos.

## Cómo ejecutarlo
Abrir el proyecto en Eclipse (u otro IDE de Java) y correr `Main.java`.

## Autor
Luis Gerardo Rojas Solorio
