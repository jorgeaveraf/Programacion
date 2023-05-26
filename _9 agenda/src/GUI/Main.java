package GUI;

import Domain.Agenda;

public class Main {
    public static void main(String[] args) {
        Agenda.getInstance().cargarDatos();

        Login login = new Login();
        login.setVisible(true);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Agenda.getInstance().guardarDatos();
        }));

    }
}