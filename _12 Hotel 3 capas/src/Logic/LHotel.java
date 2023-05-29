package Logic;

public class LHotel {
    private LClientes lClientes;
    private LHabitaciones lHabitaciones;
    private LReservaciones lReservaciones;

    private static LHotel instance;

    private LHotel() {
        lClientes = LClientes.getInstance();
        lHabitaciones = LHabitaciones.getInstance();
        lReservaciones = LReservaciones.getInstance();
    }

    public static LHotel getInstance() {
        if (instance == null) {
            instance = new LHotel();
        }
        return instance;
    }

    public LClientes getLClientes() {
        return lClientes;
    }

    public LHabitaciones getLHabitaciones() {
        return lHabitaciones;
    }

    public LReservaciones getLReservaciones() {
        return lReservaciones;
    }
}
