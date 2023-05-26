package Domain;

import java.io.*;
import java.util.ArrayList;

public class AgendaOld implements Serializable {

    private static AgendaOld instance = null;
    public ArrayList<ContactosOld> contactos;

    private AgendaOld() {
        contactos = new ArrayList<ContactosOld>();
    }

    public static AgendaOld getInstance() {
        if (instance == null) {
            instance = new AgendaOld();
        }
        return instance;
    }

    public void agregarCuenta(ContactosOld cuenta) {
        contactos.add(cuenta);
    }

    public ArrayList<ContactosOld> getContactos() {
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
            contactos = (ArrayList<ContactosOld>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
