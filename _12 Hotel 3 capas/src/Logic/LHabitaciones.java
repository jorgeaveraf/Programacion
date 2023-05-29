package Logic;


import Domain.Cliente;
import Domain.Habitacion;
import Domain.Habitaciones;

import javax.swing.table.DefaultTableModel;

public class LHabitaciones {
    private Habitaciones habitaciones;
    private static LHabitaciones instance;

    public LHabitaciones() {
        habitaciones = new Habitaciones();
    }

    public static LHabitaciones getInstance() {
        if (instance == null) {
            instance = new LHabitaciones();
        }
        return instance;
    }

    public void mostrarHabitaciones(){
        habitaciones.mostrarHabitaciones();
    }

    public void addRoom(LHabitacion lHabitacion) {
        habitaciones.addHabitacion(lHabitacion.getHabitacion());
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones.getHabitaciones();
    }

    public void habitacionTable(DefaultTableModel model) {
        Habitacion[] habitacions = getHabitaciones();
        for (Habitacion habitacion : habitacions) {
            if (habitacion != null) {
                Object[] rowData = {habitacion.getNumeroH(), habitacion.getTipo(), habitacion.getPrecio(), habitacion.isDisponible()};
                model.addRow(rowData);
            }
        }
    }

    public LHabitacion buscarPorNumero(int nHabitacion) {
        Habitacion[] habitacions = getHabitaciones();
        for (Habitacion habitacion : habitacions) {
            if (habitacion != null && habitacion.getNumeroH() == nHabitacion) {
                LHabitacion lHabitacion = new LHabitacion(habitacion.getNumeroH(), habitacion.getTipo(), habitacion.getPrecio(),
                        habitacion.isDisponible());
                return lHabitacion;
            }
        }
        return null;
    }

    public int index(int nHabitacion) {
        Habitacion[] habitacions = getHabitaciones();
        for (int i = 0; i < habitacions.length; i++) {
            Habitacion habitacion = habitacions[i];
            if (habitacion != null && habitacion.getNumeroH() == nHabitacion) {
                return i;
            }
        }
        return -1;
    }

    public void setNRoom(int index, int nuevoNum) {
        if (index != -1) {
            Habitacion[] habitacions = getHabitaciones();
            habitacions[index].setNumeroH(nuevoNum);
        }
    }

    public void setTRoom(int index, String nuevoT) {
        if (index != -1) {
            Habitacion[] habitacions = getHabitaciones();
            habitacions[index].setTipo(nuevoT);
        }
    }

    public void setPRoom(int index, int nuevoP) {
        if (index != -1) {
            Habitacion[] habitacions = getHabitaciones();
            habitacions[index].setPrecio(nuevoP);
        }
    }

    public void setARoom(int index, boolean nuevoA) {
        if (index != -1) {
            Habitacion[] habitacions = getHabitaciones();
            habitacions[index].setDisponible(nuevoA);
        }
    }

    public void setHNull(int index) {
        if (index != -1) {
            Habitacion[] habitacions = getHabitaciones();
            habitacions[index] = null;
        }
    }
}
