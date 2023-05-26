package Domain;

import java.io.*;
import java.util.ArrayList;

public class Agenda implements Serializable {

    private static Agenda instance = null;
    public ArrayList<Contactos> contactos;

    private Agenda() {
        contactos = new ArrayList<Contactos>();
    }

    public static Agenda getInstance() {
        if (instance == null) {
            instance = new Agenda();
        }
        return instance;
    }

    public void agregarCuenta(Contactos cuenta) {
        contactos.add(cuenta);
    }

    public ArrayList<Contactos> getContactos() {
        return contactos;
    }

    public void guardarDatos() {
        try {
            FileOutputStream fileOut = new FileOutputStream("datos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(contactos);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void cargarDatos() {
        try {
            FileInputStream fileIn = new FileInputStream("datos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            contactos = (ArrayList<Contactos>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
