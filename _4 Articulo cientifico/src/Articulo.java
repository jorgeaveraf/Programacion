import javax.swing.*;

public class Articulo {
    //Atributos
    private String titulo;
    private String autor;
    private String[] palabrasClave;
    private String nombrePublicacion;
    private int año;
    private String resumen;

    // Primer constructor
    public Articulo(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Segundo constructor
    public Articulo(String titulo, String autor, String[] palabrasClave,
                    String nombrePublicacion, int año) {
        this(titulo, autor); // Llamada al primer constructor sobrecargado
        this.palabrasClave = palabrasClave;
        this.nombrePublicacion = nombrePublicacion;
        this.año = año;
    }

    // Tercer constructor
    public Articulo(String titulo, String autor, String[] palabrasClave,
                    String nombrePublicacion, int año, String resumen) {
        this(titulo, autor, palabrasClave, nombrePublicacion, año); // Llamada al segundo constructor sobrecargado
        this.resumen = resumen;
    }

    //Método
    public void imprimir() {
        JOptionPane.showMessageDialog(null, "Título: " + titulo);
        JOptionPane.showMessageDialog(null, "Autor: " + autor);
        if (palabrasClave != null) {
            for (int i = 0; i < palabrasClave.length; i++) {
                JOptionPane.showMessageDialog(null, "Palabra clave " + (i + 1) + ": " + palabrasClave[i]);
            }
        }
        JOptionPane.showMessageDialog(null, "Nombre de la publicación: " + nombrePublicacion);
        JOptionPane.showMessageDialog(null, "Año: " + año);
        JOptionPane.showMessageDialog(null, "Resumen: " + resumen);
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String[] getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String[] palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getNombrePublicacion() {
        return nombrePublicacion;
    }

    public void setNombrePublicacion(String nombrePublicacion) {
        this.nombrePublicacion = nombrePublicacion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}

