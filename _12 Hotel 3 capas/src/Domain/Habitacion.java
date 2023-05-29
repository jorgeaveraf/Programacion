package Domain;

public class Habitacion {
    private int numeroH;
    private String tipo;
    private int precio;
    private boolean disponible;

    public Habitacion(int numeroH, String tipo, int precio, boolean disponible) {
        this.numeroH = numeroH;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getNumeroH() {
        return numeroH;
    }

    public void setNumeroH(int numeroH) {
        this.numeroH = numeroH;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
