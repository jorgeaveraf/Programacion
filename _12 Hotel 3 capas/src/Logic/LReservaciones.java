package Logic;

import Domain.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class LReservaciones {
    private LClientes lClientes = LClientes.getInstance();
    private LHabitaciones lHabitaciones = LHabitaciones.getInstance();
    private Reservaciones reservaciones;
    private static LReservaciones instance;

    public LReservaciones() {
        reservaciones = new Reservaciones();
    }

    public static LReservaciones getInstance() {
        if (instance == null) {
            instance = new LReservaciones();
        }
        return instance;
    }

    public void mostrarReservaciones() {
        reservaciones.mostrarReservaciones();
    }

    public void addReservacion(LReservacion lReservacion) {
        reservaciones.addReservacion(lReservacion.getReservacion());
    }

    public Reservacion[] getReservaciones() {
        return reservaciones.getReservaciones();
    }

    public int getContador() {
        return reservaciones.getContador();
    }

    public void reservacionTable(DefaultTableModel model) {
        Reservacion[] reservacions = getReservaciones();
        for (Reservacion reservacion : reservacions) {
            if (reservacion != null) {
                Object[] rowData = {reservacion.getnReservacion(), reservacion.getCliente().getNombre(), reservacion.getHabitacion().getNumeroH(),
                        reservacion.getFecha(), reservacion.getDiasR()};
                model.addRow(rowData);
            }
        }
    }

    public LReservacion buscarReservacionPorNumero(int nReservacion) {
        Reservacion[] reservacions = getReservaciones();
        for (Reservacion reservacion : reservacions) {
            if (reservacion != null && reservacion.getnReservacion() == nReservacion) {
                LReservacion lReservacion = new LReservacion(reservacion.getnReservacion(), reservacion.getCliente(), reservacion.getHabitacion(), reservacion.getFecha(), reservacion.getDiasR());
                return lReservacion;
            }
        }
        return null;
    }

    public int index(int nReservacion) {
        Reservacion[] reservacions = getReservaciones();
        for (int i = 0; i < reservacions.length; i++) {
            Reservacion reservacion = reservacions[i];
            if (reservacion != null && reservacion.getnReservacion() == nReservacion) {
                return i;
            }
        }
        return -1;
    }

    public void setNReservation(int index, int nuevoNum) {
        if (index != -1) {
            Reservacion[] reservacions = getReservaciones();
            reservacions[index].setnReservacion(nuevoNum);
        }
    }

    public void setRCliente(int index, Cliente cliente) {
        if (index != -1) {
            Reservacion[] reservacions = getReservaciones();
            reservacions[index].setCliente(cliente);
        }
    }

    public void setRHabitacion(int index, Habitacion habitacion) {
        if (index != -1) {
            Reservacion[] reservacions = getReservaciones();
            reservacions[index].setHabitacion(habitacion);
        }
    }

    public void setRFecha(int index, LocalDate nFecha) {
        if (index != -1) {
            Reservacion[] reservacions = getReservaciones();
            reservacions[index].setFecha(nFecha);
        }
    }

    public void setRDias(int index, int nuevoNum) {
        if (index != -1) {
            Reservacion[] reservacions = getReservaciones();
            reservacions[index].setDiasR(nuevoNum);
        }
    }

    public void validarCliente(long accountLong, String nombreCliente) {
        Cliente cliente = null;
        Cliente[] clients = lClientes.getClientes();
        for (Cliente c : clients) {
            if (c != null && c.getNombre().equals(nombreCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            int index = index((int) accountLong);
            if (index != -1) {
                setRCliente(index, cliente);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The client does not exist, please register it");
        }
    }

    public void validarHabitacion(int accountLong, int nHabitacion) {
        Habitacion habitacion = null;
        Habitacion[] habitacions = lHabitaciones.getHabitaciones();
        for (Habitacion h : habitacions) {
            if (h != null && h.getNumeroH() == nHabitacion) {
                habitacion = h;
                break;
            }
        }

        if (habitacion != null) {
            int index = index(accountLong);
            if (index != -1) {
                setRHabitacion(index, habitacion);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The room does not exist, please register it");
        }
    }


    public void validarFecha(int index, LocalDate nFecha) {
        LocalDate fechaActual = LocalDate.now();
        if (nFecha.isAfter(fechaActual)) {
            setRFecha(index, nFecha);
        } else {
            JOptionPane.showMessageDialog(null, "The date isn't valid, please enter a valid date");
        }
    }

    public void setRNull(int index) {
        if (index != -1) {
            Reservacion[] reservacions = getReservaciones();
            reservacions[index] = null;
        }
    }
}
