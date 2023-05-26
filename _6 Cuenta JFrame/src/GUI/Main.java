package GUI;

import Domain.Database;

public class Main {
    public static void main(String[] args) {
        Database.getInstance().cargarDatos();

        Login login = new Login();
       login.setVisible(true);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Database.getInstance().guardarDatos();
        }));

    }
}
