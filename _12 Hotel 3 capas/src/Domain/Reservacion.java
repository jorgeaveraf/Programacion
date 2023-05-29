package Domain;

import java.time.LocalDate;

public class Reservacion {
    private int nReservacion;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fecha;
    private int diasR;

    public Reservacion(int nReservacion, Cliente cliente, Habitacion habitacion, LocalDate fecha, int diasR) {
        this.nReservacion = nReservacion;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fecha = fecha;
        this.diasR = diasR;
    }

    public int getnReservacion() {
        return nReservacion;
    }

    public void setnReservacion(int nReservacion) {
        this.nReservacion = nReservacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDiasR() {
        return diasR;
    }

    public void setDiasR(int diasR) {
        this.diasR = diasR;
    }
}
