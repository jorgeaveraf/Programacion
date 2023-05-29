package Logic;

import Domain.Cliente;
import Domain.Habitacion;
import Domain.Reservacion;
import java.time.LocalDate;

public class LReservacion {
    Reservacion reservacion;

    public LReservacion(int nReservacion, Cliente cliente, Habitacion habitacion, LocalDate fecha, int diasR) {
        reservacion= new Reservacion (nReservacion, cliente, habitacion, fecha, diasR);
    }

    public Reservacion getReservacion(){
        return reservacion;
    }
    public int getnReservacion() {
        return reservacion.getnReservacion();
    }

    public String getCliente() {
        return reservacion.getCliente().getNombre();
    }

    public int getHabitacion() {
        return reservacion.getHabitacion().getNumeroH();
    }

    public LocalDate getFecha() {
        return reservacion.getFecha();
    }

    public int getDiasR() {
        return reservacion.getDiasR();
    }


}
