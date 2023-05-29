package GUI;

import Domain.Clientes;
import Logic.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LHotel lHotel = LHotel.getInstance();
        LClientes lClientes = lHotel.getLClientes();
        LHabitaciones lHabitaciones = lHotel.getLHabitaciones();
        LReservaciones lReservaciones = lHotel.getLReservaciones();
        LogicAgenda logicAgenda = LogicAgenda.getInstance();


        LCliente lCliente = new LCliente("Nat", 272,"nat");
        LCliente lCliente1 = new LCliente("Bruno", 27,"brun");
        LHabitacion lHabitacion = new LHabitacion(27, "sencilla", 100, true);
        LHabitacion lHabitacion1 = new LHabitacion(28, "doble", 200, true);
        LReservacion lReservacion = new LReservacion(4, lCliente.getCliente(), lHabitacion.getHabitacion(), LocalDate.now(), 10);


        lClientes.addCliente(lCliente);
        lClientes.addCliente(lCliente1);
        lHabitaciones.addRoom(lHabitacion);
        lHabitaciones.addRoom(lHabitacion1);
        lReservaciones.addReservacion(lReservacion);


        System.out.println(lClientes.index(27));


        Login login = new Login();
        login.setVisible(true);
    }
}