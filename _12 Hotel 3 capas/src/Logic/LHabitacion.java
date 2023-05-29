package Logic;

import Domain.Habitacion;

public class LHabitacion {
    Habitacion habitacion;

    public LHabitacion(int numeroH, String tipo, int precio, boolean disponible) {
        habitacion = new Habitacion(numeroH, tipo, precio, disponible);
    }

    public Habitacion getHabitacion(){return habitacion;}

    public int getNumeroH() {
        return habitacion.getNumeroH();
    }

    public void setNumeroH(int numeroH) {
        habitacion.setNumeroH(numeroH);
    }

    public String getTipo() {
        return habitacion.getTipo();
    }

    public void setTipo(String tipo) {
        habitacion.setTipo(tipo);
    }

    public int getPrecio() {
        return habitacion.getPrecio();
    }

    public void setPrecio(int precio) {
        habitacion.setPrecio(precio);
    }

    public boolean isDisponible() {
        return habitacion.isDisponible();
    }

    public void setDisponible(boolean disponible) {
        habitacion.setDisponible(disponible);
    }
}
