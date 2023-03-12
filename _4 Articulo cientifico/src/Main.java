public class Main {
    public static void main(String[] args) {
        Articulo articulo = new Articulo("Título del artículo", "Autor del artículo",
                new String[] {"Palabra clave 1", "Palabra clave 2"},
                "Nombre de la publicación", 2023,
                "Este es el resumen del artículo");
        articulo.imprimir();

    }
}